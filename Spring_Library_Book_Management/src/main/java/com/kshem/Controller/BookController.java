
package com.kshem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.kshem.Model.Book;
import com.kshem.Service.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    // Add Single Book
    @PostMapping("/addBook")
    public String addBook(@Valid @RequestBody Book book) {
        return bookService.addBook(book);
    }

    // Add Multiple Books at Once
    @PostMapping("/addBooks")
    public String addBooks(
            @RequestBody @Valid List<@Valid Book> newBooks) {
        return bookService.addBooks(newBooks);
    }

    // Get All Books
    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return bookService.getBooks();
    }

    // Search Book by ID
    @GetMapping("/book/{bookId}")
    public Book getBookByID(@PathVariable int bookId) {
        return bookService.getBookByID(bookId);
    }

    // Update Book Availability
    @PatchMapping("/updateAvailability/{bookId}")
    public String updateAvailability(
            @PathVariable int bookId,
            @RequestParam boolean available) {
        return bookService.updateAvailablity(bookId, available);
    }

    // Delete Book
    @DeleteMapping("/deleteBook/{bookId}")
    public String deleteBook(@PathVariable int bookId) {
        return bookService.deleteBook(bookId);
    }

    // Get Book Count
    @GetMapping("/count")
    public int getBookCount() {
        return bookService.getBookCount();
    }

    // Complete name
    @GetMapping("/name/{name}")
    public List<Book> getBooksByName(@PathVariable String name) {
        return bookService.getBooksByName(name);
    }

    // Partial name
    @GetMapping("/names")
    public List<Book> getBookByName(@RequestParam String name) {
        return bookService.getBookByName(name);
    }

    // Get book by author
    @GetMapping("/author")
    public List<Book> getBookByAuthor(@RequestParam String author) {
        return bookService.getBookByAuthor(author);
    }

    // Update book details
    @PutMapping("/update/{id}")
    public String updateBook(@PathVariable int id, @RequestBody Book b) {
        return bookService.update(id, b);
    }

    // Books below price
    @GetMapping("/price/below")
    public List<Book> getBooksBelowPrice(@RequestParam double price) {
        return bookService.getBooksBelowPrice(price);
    }

    // Books above price
    @GetMapping("/price/above")
    public List<Book> getBooksAbovePrice(@RequestParam double price) {
        return bookService.getBooksAbovePrice(price);
    }
}
