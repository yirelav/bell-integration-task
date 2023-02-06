CREATE SEQUENCE IF NOT EXISTS article_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE article
(
    id                BIGINT                      NOT NULL,
    title             VARCHAR(255)                NOT NULL,
    author            VARCHAR(255)                NOT NULL,
    content           OID                         NOT NULL,
    date_of_published TIMESTAMP WITH TIME ZONE    NOT NULL,
    CONSTRAINT pk_article PRIMARY KEY (id)
);