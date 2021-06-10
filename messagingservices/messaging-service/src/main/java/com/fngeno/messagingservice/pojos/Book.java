package com.fngeno.messagingservice.pojos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {
    private final String bookId;
    private final String author;
    private final String title;

    @JsonCreator
    public Book(@JsonProperty("bookId") String bookId,
                @JsonProperty("author") String author,
                @JsonProperty("title") String title) {
        this.bookId = bookId;
        this.author = author;
        this.title = title;
    }

    public String getBookId() {
        return bookId;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
