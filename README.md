# Smart Library Management System

## Project Overview
This project is a Library Management System built using Java. I created this as part of my "Build Your Own Project" assignment to demonstrate Object-Oriented Programming (OOP) concepts.

The main goal of this application is to replace manual book tracking with a digital system. It allows a librarian or student to add books to the system, view the available catalog, and borrow books. A key feature I implemented is **File Persistence**, which ensures that records are saved to a local file (`library_data.ser`) and are not lost when the program is closed.

## Features
* **View Catalog:** Shows a list of all books with their ID, Title, Author, and availability status.
* **Add Books:** Allows the user to input details for new books and adds them to the library.
* **Borrowing System:** Users can borrow a book using its ID. The system checks if the book is already borrowed before confirming.
* **Data Saving:** All data is automatically saved to a file after every change (add or borrow).
* **Input Validation:** The program handles errors (like entering text instead of a number) so it doesn't crash.

## Technologies Used
* **Language:** Java (Core Java)
* **Data Structures:** ArrayList (for dynamic storage)
* **File Handling:** Java Serialization (`ObjectOutputStream` / `ObjectInputStream`)
* **Tools:** Visual Studio Code / Eclipse, Git

## Steps to Install & Run
1.  **Clone or Download** this repository to your computer.
2.  Open the folder in your IDE (VS Code, IntelliJ, or Eclipse).
3.  Navigate to the `src` folder in your terminal.
4.  **Compile the code:**
    ```bash
    javac com/library/main/Main.java
    ```
5.  **Run the application:**
    ```bash
    java com.library.main.Main
    ```

## Testing the Project
You can test the functionality by following these steps:

1.  **Start the app:** Run the Main class.
2.  **Check empty state:** Select option `1` to view books (it might be empty or show default data).
3.  **Add a Book:** Select option `2`. Enter ID: `101`, Title: `Core Java`, Author: `Cay Horstmann`.
4.  **Verify Addition:** Select option `1` again to see the new book.
5.  **Borrow a Book:** Select option `3` and enter ID `101`.
6.  **Restart:** Close the application and run it again.
7.  **Check Persistence:** Select option `1`. The book `Core Java` should still be there, and its status should say `[Borrowed]`.
