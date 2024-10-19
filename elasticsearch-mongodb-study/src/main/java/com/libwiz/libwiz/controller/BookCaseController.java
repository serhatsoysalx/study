package com.libwiz.libwiz.controller;

import com.libwiz.libwiz.entity.BookCase;
import com.libwiz.libwiz.service.BookCaseService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookcase")
@EnableElasticsearchRepositories
@RequiredArgsConstructor
public class BookCaseController {

    private final BookCaseService bookCaseService;

    @PostMapping("/booksave")
    public ResponseEntity<BookCase> bookSave(@RequestBody BookCase bookCase){
        return ResponseEntity.ok(bookCaseService.bookSave(bookCase));
    }

    @PostMapping("/multiplebooksave")
    public ResponseEntity<List<BookCase>> multipleBookSave(@RequestBody List<BookCase> bookCase){
        return ResponseEntity.ok(bookCaseService.bookSave(bookCase));
    }

    @GetMapping("/{searchbooks}")
    public ResponseEntity<List<String>> getBook(@PathVariable String searchbooks){
        return ResponseEntity.ok(bookCaseService.getBySearchBooks(searchbooks));
    }
}
