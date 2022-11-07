CREATE DATABASE db_blockchain with template = template0 ENCODING 'UTF8' LC_COLLATE = 'en_US.UTF-8' LC_CTYPE = 'en_US.UTF-8';

create extension pgcrypto;

create table Users (

	id uuid primary key,
	email text not null,
	password text not null

)

create table Questions(

	id uuid primary key,
	id_user uuid not null references users(id),
	question text not null,
	insertion_date timestamptz default current_timestamp
);

create table Answers(
	id uuid primary key,
	id_question uuid references questions(id)

);

create table AnswersQuestionsUsers(

	id_answer uuid references Answers(id),
	id_question uuid references Questions(id),
	id_user uuid references Users(id),
	primary key(id_answer, id_question, id_user)
);

