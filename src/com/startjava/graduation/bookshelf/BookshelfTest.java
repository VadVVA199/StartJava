package com.startjava.graduation.bookshelf;

import java.util.Scanner;

public class BookshelfTest {
    private static boolean isEndProgram = true;
    private static Bookshelf bookshelf;

    public static void main(String[] args) {
        bookshelf = new Bookshelf();
        String menu = """
                ------------------------------------------------
                Команды который можно ввести в командной строке:
                1) Добавить книгу, ввести: Добавить
                2) Найти книгу, ввести: Найти
                3) Удалить книгу, ввести: Удалить
                4) Очистить полку, ввести: Очистить
                5) Завершить работу, ввести: Завершить
                ------------------------------------------------
                """;
        while (isEndProgram) {
            System.out.print(menu);
            if (getNumberBookOnShelves() == 0) {
                System.out.println("Шкаф пуст. Вы можете добавить в него первую книгу");
            } else {
                System.out.println("Шкаф содержит " + getNumberBookOnShelves() + " книги.  Свободно - " +
                        getAmountFreeSpace() + " полок");
                printBooksOnShelves();
            }
            System.out.print("Введите команду: ");
            Scanner scanner = new Scanner(System.in);
            try {
                String command = scanner.nextLine();
                while (true) {
                    checkingCommand(command);
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

    private static void printBooksOnShelves() {
        Book[] books = bookshelf.getNumberBooks();
        int lenMaxStringBook = 0;
        for (Book book : books) {
            if (book != null) {
                int len = book.toString().length();
                if (len > lenMaxStringBook) {
                    lenMaxStringBook = len;
                }
            }
        }
        for (Book book : books) {
            if (book != null) {
                int numberCharacter = lenMaxStringBook - book.toString().length();
                System.out.println("|" + book + " ".repeat(numberCharacter) + "|");
                System.out.println("|" + "-".repeat(lenMaxStringBook) + "|");
            }
        }
        if (getNumberBookOnShelves() < bookshelf.NUMBER_SHELVES) {
            System.out.println("|" + " ".repeat(lenMaxStringBook) + "|");
            System.out.println("|" + "-".repeat(lenMaxStringBook) + "|");
        }
    }

    private static void checkingCommand(String commandString) {
        String[] command = checkingString(commandString);
        switch (command[0]) {
            case "Добавить" -> addBook();
            case "Найти" -> findBook();
            case "Удалить" -> deleteBook();
            case "Очистить" -> clearShelf();
            case "Завершить" -> completeWork();
            default -> throw new IllegalArgumentException("Ошибка, ввели слово которое не является командой");
        }
    }

    private static String[] checkingString(String commandString) {
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
        System.out.println("Для добавления книги введите как показано в примере");
        System.out.print("Пример: Пушкин А.С., Ромео и Джульета, 2020\nВведите Автора, Название, год издания через " +
                "запятую ");
        Scanner scanner = new Scanner(System.in);
        String stringIn = scanner.nextLine();
        String[] bookAttributes = stringIn.split(",");
        Book newBook = new Book(bookAttributes[0].trim(), bookAttributes[1].trim(),
                Integer.parseInt(bookAttributes[2].replaceAll(" ","")));
        boolean isBookAddShelf = bookshelf.addBook(newBook);
        System.out.println("Книга " + newBook + (isBookAddShelf ? " добавлена на полку" :
                " не добавлена, нет места на полке") );
    }

    private static int findBook() {
        System.out.print("Введите название для поиска книги: ");
        Scanner scanner = new Scanner(System.in);
        String titleBook = scanner.nextLine();
        int indexBook = bookshelf.findBook(titleBook);
        if (indexBook == -1) {
            System.out.println("Книга с названием: " + titleBook + " не найдена!");
            return indexBook;
        }
        System.out.println("Книга " + bookshelf.getNumberBooks()[indexBook] + " найдена");
        return indexBook;
    }

    private static void deleteBook() {
        System.out.println("Для удаления книги введите ее название.");
        int index = findBook();
        if (index != -1) {
            bookshelf.delete(index);
        }
    }

    private static void clearShelf() {
        bookshelf.clearShelf();
    }

    private static int getNumberBookOnShelves() {
        return bookshelf.getNumberBookOnShelves();
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
