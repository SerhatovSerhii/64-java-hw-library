package ait.practice.library;

import ait.practice.library.model.Book;
import ait.practice.library.model.Email;
import ait.practice.library.model.Library;
import ait.practice.library.model.Reader;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class LibAppl {
    public static void main(String[] args) {
        Library library = new Library();    //  создаем новую библиотеку
        library.getBooks().forEach(System.out::println);    //  печатаем список книг
        System.out.println("==================== Activites =========================");
        library.getReaders().forEach(System.out::println);
        System.out.println("==================== Books Unsorted =========================");
        library.getBooks().forEach(System.out::println);
        System.out.println("==================== Books Sorted =========================");
        List<Book> listBookByYearIssue = library.getBooks().stream()
                .sorted(Comparator.comparing(Book::getIssueYear))
                .collect(Collectors.toList());
        listBookByYearIssue.forEach(System.out::println);
        System.out.println("==================== Mailing List All Users =========================");
//        ArrayList<Email> emailArrayLists = new ArrayList<>();   //  формируем спиок для рассылки
//        for (Reader reader : library.getReaders()   //  обращаемся к library и берем читателей с имэйлами .getReaders
//             ) {
//            emailArrayLists.add(new Email(reader.getEmail()));  //  добавляем новый имэйл в созданный список
//        }
//        for (Email email : emailArrayLists
//             ) {
//            System.out.println(email);  // печатаем все имэйлы
//
//        }
        List<Email> addresses = library.getReaders().stream()   //  берем в library читателей. getReaders() и стримим
                .map(Reader::getEmail)  //  преобразовать, забрать у Readers только имейл
                .map(Email::new)    //  появился в другом листе этот имэйл
                .collect(Collectors.toList());
        addresses.forEach(System.out::println); //  печатаем
        System.out.println("==================== Mailing List Subscribed Users =========================");
        // найти пользователей, кот. нужно проверять на то, что у них разрешена подпискаи они брали более 1 книги
//    List<Email> adressesSubscribed = new ArrayList<>();
//        for (Reader reader : library.getReaders()
//             ) {if (reader.isSubscriber()  &&  reader.getBooks().size() >= 1)
//                 adressesSubscribed.add(new Email(reader.getEmail()));
//        }
//        adressesSubscribed.forEach(System.out::println);

        List<Email> adressesSubscribed = library.getReaders().stream()
                .filter(Reader::isSubscriber)
                .filter(r -> r.getBooks().size() >= 1)
                .map(Reader::getEmail)
                .map(Email::new)
                .collect(Collectors.toList());
        adressesSubscribed.forEach(System.out::println);
//        System.out.println("==================== List of Books =========================");
////        Set<Book> rentedBooks = new HashSet<>();
////        for (Reader reader : library.getReaders()
////             ) {rentedBooks.addAll(reader.getBooks())  ; //  собираем все книги, кот. брались в библиотеке
////        }
////rentedBooks.forEach(System.out::println);
//        List<Book> rentedBooks = library.getReaders().stream()  //  стримим Readers и вытряхиваем книги
//                .flatMap(reader -> reader.getBooks().stream())  //  от каждого reader берем какие книги он брал
//                .distinct() //  убираем дубликаты
//                .collect(Collectors.toList());  //  делаем коллекцию
//        rentedBooks.forEach(System.out::println);

        System.out.println("==================== Max books rented =========================");
//int max = 0;
//        for (Reader reader : library.getReaders()
//             ) {if (reader.getBooks().size() > max){
//                 max = reader.getBooks().size();
//        }
//        }
//        System.out.println(max);
        Integer res = library.getReaders().stream() //  Integer res - конечный результат
                .map(reader -> reader.getBooks().size())    //  возьмем у reader его .size() .getBooksов()
                .reduce(0, (max, size) -> size > max ? size : max);    //  задать начальное знач. для аккум, .reduce - выравнивает в одну величину
        System.out.println("Максимальное количество книг, которые брали: " + res);
        System.out.println("==================== List E-mails for User`s group =========================");
//  Собрать всех пользователей в групу, которые брали больше всего раз книги
        Map<String, List<Email>> result = new HashMap<>();
        for (Reader reader : library.getReaders()) {
            if (reader.isSubscriber()) {
                if (reader.getBooks().size() > 2) {
                    if ((!result.containsKey("TOO_MUCH"))) {    //  по этому ключу еще нет значений
                        result.put("TOO_MUCH", new ArrayList<>());
                    }
                    result.get("TOO_MUCH").add(new Email(reader.getEmail()));
                } else {
                    if (!result.containsKey("OK")) {
                        result.put("OK", new ArrayList<>());
                    }
                    result.get("OK").add(new Email(reader.getEmail()));
                }
            }
        }
          //    Проход по всем ключам и значениям
        for (String key : result.keySet()) {
            System.out.println("key: " + key + " value: " + result.get(key));
        }
        System.out.println("=============== Печать MAP помощью entrySet ========================");
        System.out.println(result.entrySet());
        System.out.println("=============== List E-mails for User`s group с помощью stream ========================");
Map<String, List<Email>> map = library.getReaders().stream()
        .filter(Reader::isSubscriber)
        .collect(groupingBy(r -> r.getBooks().size() > 2 ? "TOO MUCH" : "OK", mapping (r -> new Email(r.getEmail()), Collectors.toList()))) ;  //  Собираем в группы
        System.out.println(map.entrySet());
        System.out.println("==============================================");
        //  Проверить брал ли кто-то из читателей библиотеки какие-небудь книги Л.Толстого
        boolean check = checkBook(library, "To Kill a Mockinbird");
        System.out.println(check);
        System.out.println("================== Groups of Users II =======================");
        Map<Integer, String> readersMap = library.getReaders().stream()
                .filter(Reader::isSubscriber)
                .collect(groupingBy(r -> r.getBooks().size(), mapping (Reader::getName, joining(", ", "{", "}"))));
        System.out.println(readersMap.entrySet());
        System.out.println("================== Groups of Users II Jura =======================");
        Map<Integer, Reader> readerMap = library.getReaders().stream()
                .collect(Collectors.toMap(reader -> reader.getBooks().size(), reader -> reader));
        System.out.println(readerMap.entrySet());
        System.out.println("================== Groups of Users by likes =======================");
        List<Reader> quantLikes = library.getReaders().stream()
                .sorted(Comparator.comparing(Reader::getQuantLikes))
                .collect(Collectors.toList());
        listBookByYearIssue.forEach(System.out::println);


    }

    private static boolean checkBook(Library library, String author) {
        return library.getReaders().stream()
                .flatMap(reader -> reader.getBooks().stream())
                .anyMatch(book -> author.equals(book.getAuthor()));
    }
}
