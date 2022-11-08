CREATE DATABASE db_blockchain with template = template0 ENCODING 'UTF8' LC_COLLATE = 'en_US.UTF-8' LC_CTYPE = 'en_US.UTF-8';

create extension pgcrypto;

create table Users (
	id uuid primary key default gen_random_uuid(),
	email text not null,
	password text null
);

create table Questions(
	id uuid primary key default gen_random_uuid(),
	question text not null
);

create table Answers(
	id uuid primary key default gen_random_uuid(),
	question_id uuid references questions(id),
	answer text not null
);

create table UserAnswer(
	user_id uuid references Users(id),
	answer_id uuid references Answers(id),
	answer_date timestamptz default current_timestamp,
	primary key(answer_id, user_id)
);

