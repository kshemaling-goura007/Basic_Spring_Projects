
package com.kshem.Service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.kshem.Model.Book;
import com.kshem.Exception.BookNotFoundException;

@Service
public class BookService {

    List<Book> books = new ArrayList<>();

    // Add Single Book
    public String addBook(Book book) {

        boolean exists = books.stream()
                .anyMatch(b -> b.getBookId() == book.getBookId());

        if (exists) {
            return "Book ID already exists";
        }

        books.add(book);
        return "Book Added Successfully";
    }

    // Add Multiple Books at Once
    public String addBooks(List<Book> newBooks) {

        Set<Integer> bookIds = new HashSet<>();

        // Store existing book IDs
        for (Book b : books) {
            bookIds.add(b.getBookId());
        }

        // Check duplicate IDs before adding any books
        for (Book b : newBooks) {

            if (!bookIds.add(b.getBookId())) {
                return "Duplicate Book ID found: " + b.getBookId();
            }
        }

        // Add all books if IDs are unique
        books.addAll(newBooks);
        return "All Books Added Successfully";
    }

    
    // Get All Books
    public List<Book> getBooks() {
        return books;
    }

    
    // Get Book by ID
    public Book getBookByID(int bid) {

        for (Book b : books) {
            if (b.getBookId() == bid) {
                return b;
            }
        }

        throw new BookNotFoundException(
                "Book not found with ID: " + bid);
    }
    
    

    // Update Book Availability
    public String updateAvailablity(int bookId, boolean available) {

        Book book = getBookByID(bookId);

        if (book != null) {
            book.setAvailable(available);
            return "Book Availability Updated Successfully";
        }

        return "Book Not Found";
    }

    
    // Delete Book
    public String deleteBook(int bookId) {

        boolean removed = books.removeIf(
                b -> b.getBookId() == bookId);

        if (removed) {
            return "Book Deleted Successfully";
        }

        return "Book Not Found";
    }

    
    // Count Books
    public int getBookCount() {
        return books.size();
    }

    
    // Search book by name (complete)
    public List<Book> getBooksByName(String name) {
        return books.stream()
                .filter(b -> b.getBookName()
                        .equalsIgnoreCase(name))
                .toList();
    }
    

    // Search book by partial name
    public List<Book> getBookByName(String name) {
        return books.stream()
                .filter(b -> b.getBookName() != null
                        && b.getBookName().toLowerCase()
                        .contains(name.trim().toLowerCase()))
                .toList();
    }
    

    // Search by author
    public List<Book> getBookByAuthor(String author) {
        return books.stream()
                .filter(b -> b.getAuthor() != null
                        && b.getAuthor().toLowerCase()
                        .contains(author.trim().toLowerCase()))
                .toList();
    }

    
    // Update details of book
    public String update(int id, Book b) {
        for (Book book : books) {
            if (book.getBookId() == id) {
                book.setBookName(b.getBookName());
                book.setAuthor(b.getAuthor());
                book.setPrice(b.getPrice());
                book.setAvailable(b.isAvailable());

                return "Records Updated Successfully";
            }
        }

        return "Record Not Found";
    }
    

    // Books below 300
    public List<Book> getBooksBelowPrice(double price) {
        return books.stream()
                .filter(b -> b.getPrice() < price)
                .toList();
    }

    
    // Books above 300
    public List<Book> getBooksAbovePrice(double price) {
        return books.stream()
                .filter(b -> b.getPrice() > price)
                .toList();
    }
}
