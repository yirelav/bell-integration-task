CREATE SEQUENCE IF NOT EXISTS article_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE article
(
    id                BIGINT       NOT NULL,
    title             VARCHAR(100) NOT NULL,
    author            VARCHAR(64)  NOT NULL,
    content           OID          NOT NULL,
    date_of_published TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_article PRIMARY KEY (id)
);