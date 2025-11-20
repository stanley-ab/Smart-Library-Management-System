package com.library.main;

import com.library.model.Book;
import com.library.service.FileHandler;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Book> library;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        library = FileHandler.loadBooks();

        // If library is empty (first run), add default data
        if (library.isEmpty()) {
            library.add(new Book(101, "Effective Java", "Joshua Bloch"));
            library.add(new Book(102, "Clean Code", "Robert C. Martin"));
            FileHandler.saveBooks(library);
        }

        while (true) {
            System.out.println("\n=== LIBRARY MANAGEMENT SYSTEM ===");
            System.out.println("1. View All Books");
            System.out.println("2. Add New Book");
            System.out.println("3. Borrow Book");
            System.out.println("4. Exit");
            System.out.print("Select Option: ");

            int choice = -1;
            try {
                String input = scanner.nextLine();
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    viewBooks();
                    break;
                case 2:
                    addBook();
                    break;
                case 3:
                    borrowBook();
                    break;
                case 4:
                    FileHandler.saveBooks(library);
                    System.out.println("Data saved. Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void viewBooks() {
        System.out.println("\n--- Book Catalog ---");
        if (library.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book b : library) {
                System.out.println(b);
            }
        }
    }

    private static void addBook() {
        try {
            System.out.print("Enter Book ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            // Check for duplicate ID
            for (Book b : library) {
                if (b.getId() == id) {
                    System.out.println("Error: Book ID already exists.");
                    return;
                }
            }

            System.out.print("Enter Title: ");
            String title = scanner.nextLine();
            System.out.print("Enter Author: ");
            String author = scanner.nextLine();

            library.add(new Book(id, title, author));
            FileHandler.saveBooks(library);
            System.out.println("Book added successfully.");

        } catch (NumberFormatException e) {
            System.out.println("Error: ID must be a number.");
        }
    }

    private static void borrowBook() {
        try {
            System.out.print("Enter Book ID to borrow: ");
            int id = Integer.parseInt(scanner.nextLine());

            boolean found = false;
            for (Book b : library) {
                if (b.getId() == id) {
                    if (!b.isBorrowed()) {
                        b.setBorrowed(true);
                        FileHandler.saveBooks(library);
                        System.out.println("You have successfully borrowed: " + b.getTitle());
                    } else {
                        System.out.println("Book is already borrowed.");
                    }
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Book not found.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: ID must be a number.");
        }
    }
}