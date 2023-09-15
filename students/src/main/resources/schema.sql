BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS students (
    id            bigint unique PRIMARY KEY,
    name          varchar(40) NOT NULL
);

COMMIT TRANSACTION;