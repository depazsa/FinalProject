# 📚 Final Project – Library Book Checkout System

## ✅ Problem Statement

This project is a **Library Book Checkout System** that allows users to manage a collection of books. The system tracks available books and checked-out books, and uses file persistence to save and load data between sessions.

---

## 💡 Features

- 📥 **Add a Book** – Add new books to the library.
- 📤 **Check Out a Book** – Move a book from the available list to checked-out.
- 🔁 **Return Book (via code edit)** – You can return books by adjusting data files (bonus idea: add this feature later).
- 📋 **View Available Books** – See all books currently in the library.
- 📦 **View Checked-Out Books** – See which books are currently checked out.
- 💾 **Data Persistence** – Data is saved to files on exit and loaded on startup.

---

## 🧠 Concepts Used

| Concept               | Usage                                                   |
|----------------------|----------------------------------------------------------|
| **ArrayList**        | To store available books.                                |
| **Array**            | To store checked-out books (fixed size, up to 100).      |
| **Recursion**        | For input validation (e.g., retrying on invalid input).  |
| **Try-Catch**        | To handle input mismatches and file I/O errors.          |
| **File Persistence** | Data saved to and loaded from `available_books.txt` and `checked_out_books.txt`. |

---

## 📁 File Structure

# FinalProject