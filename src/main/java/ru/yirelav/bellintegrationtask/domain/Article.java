package ru.yirelav.bellintegrationtask.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Article {
    private static final int MAX_CONTENT_SIZE = 10_000_000;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    @JsonProperty("id")
    private Long id;

    @Size(max = 100)
    @Column(name = "title", nullable = false, length = 100)
    @NotBlank
    String title;

    @Size(max = 64)
    @Column(name = "author", nullable = false, length = 64)
    @NotNull
    String author;

    @Lob
    @Column(name = "content", nullable = false)
    @Size(max = MAX_CONTENT_SIZE)
    String content;

    @Column(name = "dateOfPublished")
    @NotNull
    Instant dateOfPublished;

    public Instant getDateOfPublished() {
        return dateOfPublished;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
