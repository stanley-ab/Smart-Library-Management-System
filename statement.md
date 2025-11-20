# Project Problem Statement

## 1. Problem Statement
Managing library records manually on paper or using simple spreadsheets is inefficient and prone to errors. It is difficult to quickly check if a book is available or borrowed. Additionally, many basic student projects do not save data, meaning all records are lost when the program closes. This project aims to solve these issues by creating a digital system that tracks book inventory and saves the data permanently to a file.

## 2. Scope of the Project
The scope of this project is limited to a **console-based application** that handles the core operations of a library.

* **In Scope:**
    * Developing a menu-driven interface for user interaction.
    * Implementing functionality to add new books and view the list of books.
    * Creating a borrowing feature that updates the book's status.
    * Implementing file handling to save and load data automatically.

* **Out of Scope:**
    * This project does not include a Graphical User Interface (GUI).
    * It does not use an external database server (like MySQL); it uses local file storage.
    * It does not handle user login/authentication passwords.

## 3. Target Users
The primary users of this system are:
* **Librarians/Admins:** Who need to add new books to the inventory and check the status of books.
* **Students:** Who want to search for books and borrow them.

## 4. High-Level Features
* **Book Management:** The system allows adding new books with ID, Title, and Author details.
* **Check-in/Check-out:** A specific feature to change the status of a book from "Available" to "Borrowed".
* **Data Persistence:** The application uses Java Serialization to write objects to a file (`library_data.ser`), ensuring data remains available even after restarting the application.
* **Error Handling:** Prevents the application from crashing if the user enters invalid data (like text instead of numbers).
