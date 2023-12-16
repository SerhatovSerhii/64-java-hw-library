package ait.practice.library.model;

import java.util.Objects;

public class Book implements Comparable<Book>{
    private String author;
    private String title;
    private Integer issueYear;  //  issue - выпуск книги
    private int quantResponse;
    private int rating;

    public Book(String author, String title, Integer issueYear) {
        this.author = author;
        this.title = title;
        this.issueYear = issueYear;
    }

    public int getQuantResponse() {
        return quantResponse;
    }

    public void setQuantResponse(int quantResponse) {
        this.quantResponse = quantResponse;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Book(String author, String title, Integer issueYear, int quantResponse, int rating) {
        this.author = author;
        this.title = title;
        this.issueYear = issueYear;
        this.quantResponse = quantResponse;
        this.rating = rating;
    }


    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public Integer getIssueYear() {
        return issueYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (!Objects.equals(author, book.author)) return false;
        if (!Objects.equals(title, book.title)) return false;
        return Objects.equals(issueYear, book.issueYear);
    }

    @Override
    public int hashCode() {
        int result = author != null ? author.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (issueYear != null ? issueYear.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", issueYear=" + issueYear +
                '}';
    }


    @Override
    public int compareTo(Book o) {
        return this.author.compareTo(o.getAuthor());
    }
}
