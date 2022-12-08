package com.startjava.graduation.bookshelf;

import java.util.Scanner;

public class BookshelfTest {
    private static boolean isProgramCompleted = false;
    private static Bookshelf bookshelf;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        bookshelf = new Bookshelf();
        while (!isProgramCompleted) {
            printMenu();
            printBookShelf();
            System.out.print("Введите команду: ");
            try {
                String command = scanner.nextLine();
                while (true) {
                    selectAction(command);
                    if (isProgramCompleted) {
                        break;
                    }
                    System.out.print("Для продолжения работы нажмите Enter");
                    String enter = scanner.nextLine();
                    if (enter.isBlank()) {
                        break;
                    }
                    System.out.println("Не нажата клавиша Enter, повторите попытку");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void printMenu() {
        System.out.print("""
                ----------------------------------------------------------
                    ОБЪЯВЛЕНИЕ
                Как добавлять книги? Книги добавляются через Enter:
                Курсор стоит на новой строке вводим часть и нажимаем Enter
                Автор (Enter) Название (Enter) Год издания (Enter)
                Пример:
                Введите книгу для добавления нажимая Enter (команда)
                Пушкин А.С.                 (вводим и нажимаем Enter)
                Ромео и Джульета            (вводим и нажимаем Enter)
                2020                        (вводим и нажимаем Enter)
                ----------------------------------------------------------
                    МЕНЮ
                Команды, которые можно ввести в командной строке:
                1) Добавить книгу, ввести: Добавить
                2) Найти книгу, ввести: Найти
                3) Удалить книгу, ввести: Удалить
                4) Очистить полку, ввести: Очистить
                5) Завершить работу, ввести: Завершить
                -----------------------------------------------------
                """);
    }

    private static void printBookShelf() {
        if (bookshelf.getCountBooks() == 0) {
            System.out.println("Шкаф пуст. Вы можете добавить в него первую книгу");
        } else {
            System.out.println("Шкаф содержит " + bookshelf.getCountBooks() + " книги.  Свободно - " +
                    getAmountFreeSpace() + " полок");
            int shelfLength = bookshelf.getShelfLength();
            for (Book book : bookshelf.getAll()) {
                int numberCharacter = shelfLength - book.toString().length();
                System.out.println("|" + book + " ".repeat(numberCharacter) + "|");
                System.out.println("|" + "-".repeat(shelfLength) + "|");
            }
            if (bookshelf.getCountBooks() < Bookshelf.NUMBER_SHELVES) {
                System.out.println("|" + " ".repeat(shelfLength) + "|");
                System.out.println("|" + "-".repeat(shelfLength) + "|");
            }
        }
    }

    private static void selectAction(String command) {
        switch (command) {
            case "Добавить" -> addBook();
            case "Найти" -> findBook();
            case "Удалить" -> deleteBook();
            case "Очистить" -> bookshelf.clearShelves();
            case "Завершить" -> completeWork();
            default -> throw new IllegalArgumentException("Ошибка, ввели слово которое не является командой");
        }
    }

    private static void addBook() {
        System.out.println("Введите книгу для добавления нажимая Enter ");
        String author = scanner.nextLine();
        String title = scanner.nextLine();
        String yearPublication = scanner.nextLine();
        Book newBook = new Book(author.trim(), title.trim(),
                Integer.parseInt(yearPublication.replaceAll(" ","")));
        boolean isBookAddShelf = bookshelf.add(newBook);
        System.out.println("Книга " + newBook + (isBookAddShelf ? " добавлена на полку" :
                " не добавлена, нет места на полке") );
    }

    private static void findBook() {
        System.out.print("Введите название для поиска книги: ");
            String title = scanner.nextLine();
            Book book = bookshelf.find(title);
            System.out.println("Книга " + (book != null ? book : "с названием " + title + " не") + " найдена");
    }

    private static void deleteBook() {
        System.out.print("Для удаления книги введите ее название ");
        String titleBook = scanner.nextLine();
        if (bookshelf.delete(titleBook)) {
            System.out.println("Книга с названием " + titleBook + " удалена");
        } else {
            System.out.println("Книга с названием " + titleBook + " не найдена");
        }
    }

    private static int getAmountFreeSpace() {
        int amountFreeSpace = bookshelf.getAmountFreeSpace();
        if (amountFreeSpace == 0) {
            System.out.println("Места на полках нет");
        }
        return amountFreeSpace;
    }

    private static void completeWork() {
        System.out.println("Программа завершила свою работу");
        isProgramCompleted = true;
    }
}
