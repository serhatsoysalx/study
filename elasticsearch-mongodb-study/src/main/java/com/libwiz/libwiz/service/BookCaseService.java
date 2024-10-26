package com.libwiz.libwiz.service;

import com.libwiz.libwiz.entity.BookCase;
import com.libwiz.libwiz.repository.BookCaseRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookCaseService {

    private final BookCaseRepository bookCaseRepository;

    public List<String> getBySearchBooks(String searchBooks){
        return bookCaseRepository.getByCustomQuery(searchBooks);
    }

    public BookCase bookSave(BookCase bookCase){
        return bookCaseRepository.save(bookCase);
    }

    public List<BookCase> bookSave(List<BookCase> bookCase){
        return (List<BookCase>) bookCaseRepository.saveAll(bookCase);
    }

}
