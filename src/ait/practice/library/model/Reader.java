package ait.practice.library.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Reader {
private String name;
private String email;
private boolean subscriber; //  subscriber - подписчик
    private List<Book> books;
    private int quantLikes;


    public Reader(String name, String email, boolean subscriber) {
        this.name = name;
        this.email = email;
        this.subscriber = subscriber;
        this.books = new ArrayList<>(); //  инициализация списка книг читателя

    }
    public Reader(String name, String email, boolean subscriber, int likes) {
        this.name = name;
        this.email = email;
        this.subscriber = subscriber;
        this.books = new ArrayList<>(); //  инициализация списка книг читателя
        this.quantLikes = likes;

    }

    public Reader(String name, String email) {
        this.name = name;
        this.email = email;
    }
    public Reader(String email, int likes) {
        this.email = email;
        this.quantLikes = likes;

    }
    public boolean isSubscriber(){
        return subscriber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSubscriber(boolean subscriber) {
        this.subscriber = subscriber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reader reader = (Reader) o;

        return Objects.equals(email, reader.email);
    }

    @Override
    public int hashCode() {
        return email != null ? email.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", subscriber=" + subscriber +
                ", books=" + books +
                '}';
    }

    public int getQuantLikes() {
        return quantLikes;
    }

    public void setQuantLikes(int quantLikes) {
        this.quantLikes = quantLikes;
    }
}
