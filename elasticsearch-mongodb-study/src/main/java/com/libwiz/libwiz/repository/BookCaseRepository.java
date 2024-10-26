package com.libwiz.libwiz.repository;

import com.libwiz.libwiz.entity.BookCase;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookCaseRepository extends ElasticsearchRepository<BookCase, String> {

    @Query("{\"bool\": {\"must\":[{\"match\": {\"name\": \"?0\"}}]}}")
    List<String> getByCustomQuery(String searchBooks);
}
