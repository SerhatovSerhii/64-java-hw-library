package ait.practice.library.model;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Reader> readers;
    public Library(){
        init(); //  метод, кот. заполнит книжками и читателями
    }

    private void init() {
        books = new ArrayList<>();  //  min - 10, увеличивается в 1,5 раза
        books.add(new Book("George Orwell", "1984", 2021, 5,5)); //  0  т.к. Array List все будет по индексам
        books.add(new Book("J. K. Rowling", "H.Potter and the Sorcerer`s Stone", 1997));    //  1
        books.add(new Book("J. R. R. Tolkien", "The Lord of the Rings", 2020)); //   2
        books.add(new Book("Harper Lee", "To Kill a Mockinbird", 1960));    //  4
        books.add(new Book("F. Scott Fitzgerald", "The Great Gatsby", 1925));   // 5
        books.add(new Book("Лев Толстой", "Война и мир", 1869));    //  6
        //  добавляем читателей
        readers = new ArrayList<>();
        readers.add(new Reader("Иванов Иван Иванович", "ivanov@email.test.com", true, 5));   //  0
        readers.add(new Reader("Петров Петр Петрович", "petrov@email.test.com", true));   //  1
        readers.add(new Reader("Сидоров Сидор Сидорович", "sidorov@email.test.com", true));   //  2
        readers.add(new Reader("Андреев Андрей Андревич", "andreev@email.test.com"));   //  1
        readers.add(new Reader("Николаев Николай Николаевич", "nikolaev@email.test.com"));   //  2
        readers.add(new Reader("nikolaev@email.test.com", 4));   //  2
        readers.add(new Reader("kolaev@email.test.com", 2));   //  2
        readers.add(new Reader("laev@email.test.com", 1));   //  2
        readers.add(new Reader("ev@email.test.com", 5));   //  2
        readers.add(new Reader("niko@email.test.com", 8));   //  2

        //  журнал выдачи книг
        readers.get(0).getBooks().add(books.get(0));    //  Иванов(0) взял книгу с індексом (0)(books "George Orwell")
        readers.get(1).getBooks().add(books.get(0));    //  Петров(1) взял книгу с індексом (0)(books "")
        readers.get(1).getBooks().add(books.get(1));    //  Петров(1) взял книгу с індексом (1)(books "")
        readers.get(1).getBooks().add(books.get(4));    //  Петров(1) взял книгу с індексом (4)(books "")
        readers.get(2).getBooks().add(books.get(0));    //
        readers.get(2).getBooks().add(books.get(2));    //
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Reader> getReaders() {
        return readers;
    }
}
