package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.dto.Author;
import com.example.bookstoreapi.service.AuthorService;
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
@RequestMapping("/authors")
@Tag(name = "Author Controller", description = "CRUD operations for Authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @Operation(
        summary = "Save a new author",
        description = "Creates a new author and returns the saved object",
        responses = {
            // --- FIX --- Removed the 'content' attribute. Swagger will infer the response from the method signature.
            @ApiResponse(responseCode = "201", description = "Author saved successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
        }
    )
    @PostMapping
    public ResponseStructure<Author> saveAuthor(@RequestBody Author author) {
        return authorService.saveAuthor(author);
    }

    @Operation(
        summary = "Fetch author by ID",
        description = "Retrieves an author based on the ID provided",
        responses = {
            @ApiResponse(responseCode = "200", description = "Author fetched successfully"),
            @ApiResponse(responseCode = "404", description = "Author not found")
        }
    )
    @GetMapping("/{id}")
    public ResponseStructure<Author> fetchAuthorById(@PathVariable int id) {
        return authorService.fetchAuthorById(id);
    }

    @Operation(
        summary = "Fetch all authors with pagination",
        description = "Retrieves a paginated list of all authors",
        responses = {
            @ApiResponse(responseCode = "200", description = "Authors retrieved")
        }
    )
    @GetMapping
    public ResponseEntity<Page<Author>> fetchAllAuthors(
            @Parameter(hidden = true) Pageable pageable) {
        Page<Author> page = authorService.fetchAllAuthors(pageable);
        return ResponseEntity.ok(page);
    }

    @Operation(
        summary = "Update author by ID",
        description = "Updates an existing author's details",
        responses = {
            @ApiResponse(responseCode = "200", description = "Author updated successfully"),
            @ApiResponse(responseCode = "404", description = "Author not found")
        }
    )
    @PutMapping("/{id}")
    public ResponseStructure<Author> updateAuthor(@PathVariable int id, @RequestBody Author newAuthor) {
        return authorService.updateAuthor(id, newAuthor);
    }

    @Operation(
        summary = "Delete author by ID",
        description = "Deletes the author with the given ID",
        responses = {
            @ApiResponse(responseCode = "204", description = "Author deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Author not found")
        }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable int id) {
        if (authorService.deleteAuthorById(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
