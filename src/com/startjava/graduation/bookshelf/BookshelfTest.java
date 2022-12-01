package com.startjava.graduation.bookshelf;

import java.util.Scanner;

public class BookshelfTest {
    private static boolean isEndProgram = true;
    private static Bookshelf bookshelf;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        bookshelf = new Bookshelf();
        while (isEndProgram) {
            System.out.print(getMenu());
            if (getNumberBookOnShelves() == 0) {
                System.out.println("Шкаф пуст. Вы можете добавить в него первую книгу");
            } else {
                System.out.println("Шкаф содержит " + getNumberBookOnShelves() + " книги.  Свободно - " +
                        getAmountFreeSpace() + " полок");
                printBooksOnShelves();
            }
            System.out.print("Введите команду: ");
            try {
                String command = scanner.nextLine();
                while (true) {
                    selectAction(command);
                    if (!isEndProgram) {
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

    private static String getMenu() {
        return """
                -----------------------------------------------------
                    ОБЪЯВЛЕНИЕ
                Как добавлять книги? Книги добавляются через запятую:
                Автор (запятая) Название (запятая) Год издания
                Пример: Пушкин А.С., Ромео и Джульета, 2020
                -----------------------------------------------------
                    МЕНЮ
                Команды, которые можно ввести в командной строке:
                1) Добавить книгу, ввести: Добавить
                2) Найти книгу, ввести: Найти
                3) Удалить книгу, ввести: Удалить
                4) Очистить полку, ввести: Очистить
                5) Завершить работу, ввести: Завершить
                -----------------------------------------------------
                """;
    }

    private static void printBooksOnShelves() {
        Book[] books = bookshelf.getAllBooks();
        int lenMaxStringBook = 0;
        for (Book book : books) {
                int len = book.toString().length();
                if (len > lenMaxStringBook) {
                    lenMaxStringBook = len;
            }
        }
        for (Book book : books) {
            if (book != null) {
                int numberCharacter = lenMaxStringBook - book.toString().length();
                System.out.println("|" + book + " ".repeat(numberCharacter) + "|");
                System.out.println("|" + "-".repeat(lenMaxStringBook) + "|");
            }
        }
        if (getNumberBookOnShelves() < Bookshelf.NUMBER_SHELVES) {
            System.out.println("|" + " ".repeat(lenMaxStringBook) + "|");
            System.out.println("|" + "-".repeat(lenMaxStringBook) + "|");
        }
    }

    private static void selectAction(String commandString) {
        String[] command = menuItem(commandString);
        switch (command[0]) {
            case "Добавить" -> addBook();
            case "Найти" -> findBook();
            case "Удалить" -> deleteBook();
            case "Очистить" -> clearShelf();
            case "Завершить" -> completeWork();
            default -> throw new IllegalArgumentException("Ошибка, ввели слово которое не является командой");
        }
    }

    private static String[] menuItem(String commandString) {
        if (commandString.isBlank()) {
            throw new IllegalArgumentException("Ошибка, ввели пустую строку");
        }
        String[] array = commandString.split(" ");
        if (array.length != 1) {
            throw new IllegalArgumentException("Ошибка, ввели лишнее слово");
        }
        return array;
    }

    private static void addBook() {
        System.out.print("Введите книгу для добавления ");
        String stringIn = scanner.nextLine();
        String[] bookAttributes = stringIn.split(",");
        Book newBook = new Book(bookAttributes[0].trim(), bookAttributes[1].trim(),
                Integer.parseInt(bookAttributes[2].replaceAll(" ","")));
        boolean isBookAddShelf = bookshelf.addBook(newBook);
        System.out.println("Книга " + newBook + (isBookAddShelf ? " добавлена на полку" :
                " не добавлена, нет места на полке") );
    }

    private static void findBook() {
        System.out.print("Введите название для поиска книги: ");
        try {
            String titleBook = scanner.nextLine();
            System.out.println("Книга " + (bookshelf.findBook(titleBook) instanceof Book ? bookshelf.findBook(titleBook)
                    : "с названием " + titleBook + " не") + " найдена");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void deleteBook() {
        System.out.print("Для удаления книги введите ее название ");
        try {
            String titleBook = scanner.nextLine();
            if (bookshelf.findBook(titleBook) instanceof Book) {
                Book book = bookshelf.findBook(titleBook);
                bookshelf.delete(book.getTitle());
                System.out.println("Книга " + book + " удалена");
            } else {
                System.out.println("Книга с названием " + titleBook + " не найдена");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void clearShelf() {
        bookshelf.clearShelf();
    }

    private static int getNumberBookOnShelves() {
        return bookshelf.getCountBooks();
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
        isEndProgram = false;
    }
}
