package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.dto.Book;
import com.example.bookstoreapi.service.BookService;
import com.example.bookstoreapi.util.ResponseStructure;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
@Tag(name = "Book Controller", description = "CRUD operations and filtering for books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Operation(
        summary = "Save a new book",
        description = "Creates a new book and returns the saved object. The author must already exist.",
        responses = {
            @ApiResponse(responseCode = "201", description = "Book saved successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input, such as a non-existent author")
        }
    )
    @PostMapping
    public ResponseStructure<Book> saveBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @Operation(
        summary = "Fetch book by ID",
        description = "Retrieves a book based on the ID provided",
        responses = {
            @ApiResponse(responseCode = "200", description = "Book fetched successfully"),
            @ApiResponse(responseCode = "404", description = "Book not found")
        }
    )
    @GetMapping("/{id}")
    public ResponseStructure<Book> fetchBookById(@PathVariable int id) {
        return bookService.fetchBookById(id);
    }

    @Operation(
        summary = "Search and filter books",
        description = "Fetches books with optional filters for title, genre, and minimum price. Results are paginated and can be sorted.",
        responses = {
            @ApiResponse(responseCode = "200", description = "Books retrieved successfully")
        }
    )
    @GetMapping
    public ResponseEntity<Page<Book>> searchBooks(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String genre,
            @RequestParam(required = false) Double minPrice,
            @Parameter(hidden = true) Pageable pageable) {
        Page<Book> page = bookService.searchBooks(title, genre, minPrice, pageable);
        return ResponseEntity.ok(page);
    }

    @Operation(
        summary = "Update book by ID",
        description = "Updates an existing book's details",
        responses = {
            @ApiResponse(responseCode = "200", description = "Book updated successfully"),
            @ApiResponse(responseCode = "404", description = "Book not found")
        }
    )
    @PutMapping("/{id}")
    public ResponseStructure<Book> updateBook(@PathVariable int id, @RequestBody Book newBook) {
        return bookService.updateBook(id, newBook);
    }

    @Operation(
        summary = "Delete book by ID",
        description = "Deletes the book with the given ID",
        responses = {
            @ApiResponse(responseCode = "204", description = "Book deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Book not found")
        }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id) {
        if (bookService.deleteBookById(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
