
DROP SCHEMA IF EXISTS chat cascade;

CREATE SCHEMA chat;

CREATE TABLE chat.user(
	id		BIGSERIAL	UNIQUE	PRIMARY KEY,
	login	VARCHAR(30)	NOT NULL,
	pass	VARCHAR(25)	NOT NULL
);

CREATE TABLE chat.room(
	id		BIGSERIAL	UNIQUE	PRIMARY KEY,
	name	VARCHAR(30)	NOT NULL,
	owner	BIGINT		REFERENCES chat.user(id)
);

CREATE TABLE chat.message(
	id		BIGSERIAL	UNIQUE	PRIMARY KEY,
	author	BIGINT		REFERENCES chat.user(id),
	room	BIGINT		REFERENCES chat.room(id),
	text	TEXT,
	time	TIMESTAMPTZ	NOT NULL
);
