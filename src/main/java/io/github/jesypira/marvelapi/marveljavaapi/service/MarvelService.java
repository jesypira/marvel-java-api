package io.github.jesypira.marvelapi.marveljavaapi.service;

import io.github.jesypira.marvelapi.marveljavaapi.model.MarvelObject;
import io.github.jesypira.marvelapi.marveljavaapi.model.creator.Creator;
import io.github.jesypira.marvelapi.marveljavaapi.model.event.Event;
import io.github.jesypira.marvelapi.marveljavaapi.model.series.Series;
import io.github.jesypira.marvelapi.marveljavaapi.model.story.Story;
import io.github.jesypira.marvelapi.marveljavaapi.model.character.Character;
import io.github.jesypira.marvelapi.marveljavaapi.model.comic.Comic;
import io.github.jesypira.marvelapi.marveljavaapi.model.summaries.ItemSummary;
import io.github.jesypira.marvelapi.marveljavaapi.model.summaries.Summary;
import io.github.jesypira.marvelapi.marveljavaapi.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @autor Jéssica Cabral (jessica.cabral.a@gmail.com)
 * @since 07/04/2021
 */
@Service
public class MarvelService {

    @Autowired
    CharacterRepository characterRepository;
    @Autowired
    SeriesRepository seriesRepository;
    @Autowired
    ComicRepository comicRepository;
    @Autowired
    StoryRepository storyRepository;
    @Autowired
    EventRepository eventRepository;
    @Autowired
    CreatorRepository creatorRepository;

    protected Character setCharacterRelationships(Character character){
        List<Series> series = seriesRepository.findByCharacter(character.getId());
        character.setSeries(buildSeries(character, series));
        List<Story> stories = storyRepository.findByCharacter(character.getId());
        character.setStories(buildStories(character, stories));
        List<Comic> comics = comicRepository.findByCharacter(character.getId());
        character.setComics(buildComics(character, comics));
        List<Event> events = eventRepository.findByCharacter(character.getId());
        character.setEvents(buildEvents(character, events));
        return character;
    }

    protected Series setSeriesRelationships(Series series){
        List<Character> characters = characterRepository.findBySeries(series.getId());
        series.setCharacters(buildCharacters(series, characters));
        List<Creator> creators = creatorRepository.findBySeries(series.getId());
        series.setCreators(buildCreators(series, creators));
        List<Story> stories = storyRepository.findBySeries(series.getId());
        series.setStories(buildStories(series, stories));
        List<Comic> comics = comicRepository.findBySeries(series.getId());
        series.setComics(buildComics(series, comics));
        List<Event> events = eventRepository.findBySeries(series.getId());
        series.setEvents(buildEvents(series, events));
        return series;
    }

    protected Comic setComicRelationships(Comic comic){
        List<Character> characters = characterRepository.findByComic(comic.getId());
        comic.setCharacters(buildCharacters(comic, characters));
        List<Creator> creators = creatorRepository.findByComic(comic.getId());
        comic.setCreators(buildCreators(comic, creators));
        List<Story> stories = storyRepository.findByComic(comic.getId());
        comic.setStories(buildStories(comic, stories));
        List<Event> events = eventRepository.findByComic(comic.getId());
        comic.setEvents(buildEvents(comic, events));
        List<Series> series = seriesRepository.findByComic(comic.getId());
        comic.setSeries(buildSeries(comic, series));
        return comic;
    }

    protected Story setStoryRelationships(Story story){
        List<Character> characters = characterRepository.findByStory(story.getId());
        story.setCharacters(buildCharacters(story, characters));
        List<Creator> creators = creatorRepository.findByStory(story.getId());
        story.setCreators(buildCreators(story, creators));
        List<Event> events = eventRepository.findByStory(story.getId());
        story.setEvents(buildEvents(story, events));
        List<Series> series = seriesRepository.findByStory(story.getId());
        story.setSeries(buildSeries(story, series));
        List<Comic> comics = comicRepository.findByStory(story.getId());
        story.setComics(buildComics(story, comics));
        return story;
    }

    protected Event setEventRelationships(Event event){
        List<Character> characters = characterRepository.findByEvent(event.getId());
        event.setCharacters(buildCharacters(event, characters));
        List<Creator> creators = creatorRepository.findByEvent(event.getId());
        event.setCreators(buildCreators(event, creators));
        List<Story> stories = storyRepository.findByEvent(event.getId());
        event.setStories(buildStories(event, stories));
        List<Series> series = seriesRepository.findByEvent(event.getId());
        event.setSeries(buildSeries(event, series));
        List<Comic> comics = comicRepository.findByEvent(event.getId());
        event.setComics(buildComics(event, comics));
        return event;
    }

    private Summary buildEvents(MarvelObject object, List<Event> events){
        return Summary.builder()
                .itens(events.stream().map(obj->new ItemSummary(obj.getResourceURI(), obj.getTitle())).collect(Collectors.toList()))
                .returned(events.size())
                .available(eventRepository.countAll())
                .collectionURI(new StringBuilder(object.getResourceURI()).append("/events").toString())
                .build();
    }

    private Summary buildComics(MarvelObject object, List<Comic> comics){
        return Summary.builder()
                .itens(comics.stream().map(obj->new ItemSummary(obj.getResourceURI(), obj.getTitle())).collect(Collectors.toList()))
                .returned(comics.size())
                .available(comicRepository.countAll())
                .collectionURI(new StringBuilder(object.getResourceURI()).append("/comics").toString())
                .build();
    }

    private Summary buildStories(MarvelObject object, List<Story> stories){
        return Summary.builder()
                .itens(stories.stream().map(obj->new ItemSummary(obj.getResourceURI(), obj.getTitle(), obj.getType())).collect(Collectors.toList()))
                .returned(stories.size())
                .available(storyRepository.countAll())
                .collectionURI(new StringBuilder(object.getResourceURI()).append("/stories").toString())
                .build();
    }

    private Summary buildCharacters(MarvelObject object, List<Character> characters){
        return Summary.builder()
                .itens(characters.stream().map(obj->new ItemSummary(obj.getResourceURI(), obj.getName())).collect(Collectors.toList()))
                .returned(characters.size())
                .available(characterRepository.countAll())
                .collectionURI(new StringBuilder(object.getResourceURI()).append("/characters").toString())
                .build();
    }

    private Summary buildCreators(MarvelObject object, List<Creator> creators){
        return Summary.builder()
                .itens(creators.stream().map(obj->new ItemSummary(obj.getResourceURI(), obj.getName())).collect(Collectors.toList()))
                .returned(creators.size())
                .available(creatorRepository.countAll())
                .collectionURI(new StringBuilder(object.getResourceURI()).append("/creators").toString())
                .build();
    }

    private Summary buildSeries(MarvelObject object, List<Series> series){
        return Summary.builder()
                .itens(series.stream().map(obj->new ItemSummary(obj.getResourceURI(), obj.getTitle())).collect(Collectors.toList()))
                .returned(series.size())
                .available(seriesRepository.countAll())
                .collectionURI(new StringBuilder(object.getResourceURI()).append("/series").toString())
                .build();
    }


}
