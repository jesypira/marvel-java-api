--Characters
insert into character (id, name, description, modified, resourceURI, thumbnail_id)
values (1, 'Hulk', 'Caught in a gamma bomb explosion while trying to save the life of a teenager, Dr. Bruce Banner was transformed into the incredibly powerful creature called the Hulk.',
        '2020-07-21T10:35:15-0400', 'http://gateway.marvel.com/v1/public/characters/1', 1);
insert into character (id, name, description, modified, resourceURI, thumbnail_id)
values (2, 'Thor', 'As the Norse God of thunder and lightning, Thor wields one of the greatest weapons ever made, the enchanted hammer Mjolnir.',
        '2020-03-11T10:18:57-0400', 'http://gateway.marvel.com/v1/public/characters/2', 2);

--Comic
insert into comic(id, diamond_code, digital_id, ean, format, isbn, issn, issue_number, modified, page_count, resourceuri, series_summary_id, thumbnail_id, title, upc, variant_description)
values (1,'1',1,'9781302 924850 51599','Trade Paperback','978-1-302-92485-0','',0, '2021-03-31T15:28:25-0400',120,'http://gateway.marvel.com/v1/public/comics/1',
        1,3,'Shang-Chi by Gene Luen Yang Vol. 1: Brothers & Sisters  (Trade Paperback)','','');
insert into comic(id, diamond_code, digital_id, ean, format, isbn, issn, issue_number, modified, page_count, resourceuri, series_summary_id, thumbnail_id, title, upc, variant_description)
values (2,'2',2,'9781302 923143 54499','Trade Paperback','978-1-302-92314-3','',0, '2021-03-31T15:28:25-0400',120,'http://gateway.marvel.com/v1/public/comics/2',
        1,4,'Avengers Academy: The Complete Collection Vol. 3 (Trade Paperback)"','','');

--Creator
insert into creator(id, name, resourceuri) values (1,'John Maxuel', 'http://gateway.marvel.com/v1/public/creators/1');
insert into creator(id, name, resourceuri) values (2,'Martha Maxuel', 'http://gateway.marvel.com/v1/public/creators/2');

--Event
insert into event(id, description, end_date, modified, next_event_id, previous_event_id, resourceuri, start_date, thumbnail_id, title)
VALUES (1, 'Loki sets about convincing the super-villains of Earth','2008-01-04 00:00:00', '2013-06-28T16:31:24-0400',2,null,'http://gateway.marvel.com/v1/public/events/1','1989-12-10 00:00:00',5,'Acts of Vengeance!');
insert into event(id, description, end_date, modified, next_event_id, previous_event_id, resourceuri, start_date, thumbnail_id, title)
VALUES (2, 'In a twisted version of the world they knew, the X-Men battle against the eternal mutant Apocalypse as Bishop seeks to repair the timeline','2008-01-04 00:00:00', '2013-06-28T16:31:24-0400',null,1,'http://gateway.marvel.com/v1/public/events/2','1989-12-10 00:00:00',6,'Age of Apocalypse');

--Series
insert into series(id, description, end_year, modified, next_series_id, previous_series_id, rating, resourceuri, start_year, thumbnail_id, title)
VALUES(1, '', 2022, '2020-07-29T09:04:18-0400', 2, null,null,'http://gateway.marvel.com/v1/public/series/1',2021,7,'Fantastic Four by Dan Slott Vol. 1 (2021)');
insert into series(id, description, end_year, modified, next_series_id, previous_series_id, rating, resourceuri, start_year, thumbnail_id, title)
VALUES(2, '', 2022, '2020-07-29T09:04:18-0400', null,1,null,'http://gateway.marvel.com/v1/public/series/2',2013,8,'15-Love GN-TPB (2013 - Present)');

--story
insert into story(id, description, modified, original_issue_id, resourceuri, thumbnail_id, title, type)
VALUES (1,'','1969-12-31T19:00:00-0500',1,'http://gateway.marvel.com/v1/public/stories/1',9,'Investigating the murder of a teenage girl, Cage suddenly learns that a three-way gang war is under way for control of the turf','story');
insert into story(id, description, modified, original_issue_id, resourceuri, thumbnail_id, title, type)
VALUES (2,'','1969-12-31T19:00:00-0500',2,'http://gateway.marvel.com/v1/public/stories/2',10,'Ordinary New York City cop Frankie; Gunzer now has a new call to duty not just to uphold the law, but to save','story');

--relationships
insert into character_comic (id_character, id_comic) values (1,1);
insert into character_comic (id_character, id_comic) values (1,2);
insert into character_comic (id_character, id_comic) values (2,1);

insert into character_story (id_character, id_story) values (1,1);
insert into character_story (id_character, id_story) values (1,2);
insert into character_story (id_character, id_story) values (2,1);

insert into character_event (id_character, id_event) values (1,1);
insert into character_event (id_character, id_event) values (1,2);
insert into character_event (id_character, id_event) values (2,1);

insert into character_series (id_character, id_series) values (1,1);
insert into character_series (id_character, id_series) values (1,2);
insert into character_series (id_character, id_series) values (2,1);

insert into series_comic (id_comic, id_series) values (1,1);
insert into series_comic (id_comic, id_series) values (1,2);
insert into series_comic (id_comic, id_series) values (2,1);

insert into series_story (id_story, id_series) values (1,1);
insert into series_story (id_story, id_series) values (1,2);
insert into series_story (id_story, id_series) values (2,1);

insert into series_event (id_event, id_series) values (1,1);
insert into series_event (id_event, id_series) values (1,2);
insert into series_event (id_event, id_series) values (2,1);

insert into series_creator (id_creator, id_series) values (1,1);
insert into series_creator (id_creator, id_series) values (1,2);
insert into series_creator (id_creator, id_series) values (2,1);

insert into creator_story (id_creator, id_story) values (1,1);
insert into creator_story (id_creator, id_story) values (1,2);
insert into creator_story (id_creator, id_story) values (2,1);

insert into creator_event (id_creator, id_event) values (1,1);
insert into creator_event (id_creator, id_event) values (1,2);
insert into creator_event (id_creator, id_event) values (2,1);

insert into creator_comic (id_creator, id_comic) values (1,1);
insert into creator_comic (id_creator, id_comic) values (1,2);
insert into creator_comic (id_creator, id_comic) values (2,1);

insert into event_story (id_event, id_story) values (1,1);
insert into event_story (id_event, id_story) values (1,2);
insert into event_story (id_event, id_story) values (2,1);

insert into event_comic (id_event, id_comic) values (1,1);
insert into event_comic (id_event, id_comic) values (1,2);
insert into event_comic (id_event, id_comic) values (2,1);

insert into story_comic (id_story, id_comic) values (1,1);
insert into story_comic (id_story, id_comic) values (1,2);
insert into story_comic (id_story, id_comic) values (2,1);