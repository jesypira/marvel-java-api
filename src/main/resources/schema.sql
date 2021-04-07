drop table if exists public.story_comic;
drop table if exists public.character_comic;
drop table if exists public.character_story;
drop table if exists public.character_event;
drop table if exists public.character_series;
drop table if exists public.series_comic;
drop table if exists public.series_story;
drop table if exists public.series_event;
drop table if exists public.series_creator;
drop table if exists public.creator_story;
drop table if exists public.creator_event;
drop table if exists public.creator_comic;
drop table if exists public.event_story;
drop table if exists public.event_comic;
drop table if exists character;
DROP TABLE if exists public.comic;
DROP TABLE if exists public.creator;
DROP TABLE if exists public.event;
DROP TABLE if exists public.series;
DROP TABLE if exists public.story;

CREATE TABLE public.character (
                                    id int8 NOT NULL,
                                    description varchar(255) NULL,
                                    modified timestamp NULL,
                                    name varchar(255) NULL,
                                    resourceuri varchar(255) NULL,
                                    thumbnail_id int8 NULL,
                                    CONSTRAINT character_pkey PRIMARY KEY (id)
);
CREATE TABLE public.comic (
                              id int8 NOT NULL,
                              diamond_code varchar(255) NULL,
                              digital_id int8 NULL,
                              ean varchar(255) NULL,
                              format varchar(255) NULL,
                              isbn varchar(255) NULL,
                              issn varchar(255) NULL,
                              issue_number float8 NULL,
                              modified timestamp NULL,
                              page_count int4 NULL,
                              resourceuri varchar(255) NULL,
                              series_summary_id int8 NULL,
                              thumbnail_id int8 NULL,
                              title varchar(255) NULL,
                              upc varchar(255) NULL,
                              variant_description varchar(255) NULL,
                              CONSTRAINT comic_pkey PRIMARY KEY (id)
);
CREATE TABLE public.creator (
                                id int8 NOT NULL,
                                name varchar(255) NULL,
                                resourceuri varchar(255) NULL,
                                CONSTRAINT creator_pkey PRIMARY KEY (id)
);

CREATE TABLE public.event (
                                id int8 NOT NULL,
                                description varchar(255) NULL,
                                end_date timestamp NULL,
                                modified timestamp NULL,
                                next_event_id int8 NULL,
                                previous_event_id int8 NULL,
                                resourceuri varchar(255) NULL,
                                start_date timestamp NULL,
                                thumbnail_id int8 NULL,
                                title varchar(255) NULL,
                                CONSTRAINT event_pkey PRIMARY KEY (id)
);


CREATE TABLE public.series (
                               id int8 NOT NULL,
                               description varchar(255) NULL,
                               end_year int4 NULL,
                               modified timestamp NULL,
                               next_series_id int8 NULL,
                               previous_series_id int8 NULL,
                               rating varchar(255) NULL,
                               resourceuri varchar(255) NULL,
                               start_year int4 NULL,
                               thumbnail_id int8 NULL,
                               title varchar(255) NULL,
                               CONSTRAINT series_pkey PRIMARY KEY (id)
);

CREATE TABLE public.story (
                              id int8 NOT NULL,
                              description varchar(255) NULL,
                              modified timestamp NULL,
                              original_issue_id int8 NULL,
                              resourceuri varchar(255) NULL,
                              thumbnail_id int8 NULL,
                              title varchar(255) NULL,
                              type varchar(255) NULL,
                              CONSTRAINT story_pkey PRIMARY KEY (id)
);

create table public.character_comic(
                                id_character int8 not null,
                                id_comic int8 not null,
                                constraint character_comic_pkey primary key (id_character, id_comic)
);

create table public.character_story(
                                         id_character int8 not null,
                                         id_story int8 not null,
                                         constraint character_story_pkey primary key (id_character, id_story)
);

create table public.character_event(
                                       id_character int8 not null,
                                       id_event int8 not null,
                                       constraint character_event_pkey primary key (id_character, id_event)
);

create table public.character_series(
                                       id_character int8 not null,
                                       id_series int8 not null,
                                       constraint character_series_pkey primary key (id_character, id_series)
);
create table public.series_comic(
                                        id_series int8 not null,
                                        id_comic int8 not null,
                                        constraint series_comic_pkey primary key (id_series, id_comic)
);
create table public.series_story(
                                    id_series int8 not null,
                                    id_story int8 not null,
                                    constraint series_story_pkey primary key (id_series, id_story)
);
create table public.series_event(
                                    id_series int8 not null,
                                    id_event int8 not null,
                                    constraint series_event_pkey primary key (id_series, id_event)
);
create table public.series_creator(
                                    id_series int8 not null,
                                    id_creator int8 not null,
                                    constraint series_creator_pkey primary key (id_series, id_creator)
);
create table public.creator_story(
                                      id_creator int8 not null,
                                      id_story int8 not null,
                                      constraint creator_story_pkey primary key (id_creator, id_story)
);
create table public.creator_event(
                                     id_creator int8 not null,
                                     id_event int8 not null,
                                     constraint creator_event_pkey primary key (id_creator, id_event)
);
create table public.creator_comic(
                                     id_creator int8 not null,
                                     id_comic int8 not null,
                                     constraint creator_comic_pkey primary key (id_creator, id_comic)
);
create table public.event_story(
                                     id_event int8 not null,
                                     id_story int8 not null,
                                     constraint event_story_pkey primary key (id_event, id_story)
);
create table public.event_comic(
                                     id_event int8 not null,
                                     id_comic int8 not null,
                                     constraint event_comic_pkey primary key (id_event, id_comic)
);
create table public.story_comic(
                                   id_story int8 not null,
                                   id_comic int8 not null,
                                   constraint story_comic_pkey primary key (id_story, id_comic)
);