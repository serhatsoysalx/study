package com.libwiz.libwiz.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Document(indexName = "bookcase")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BookCase {

    @Id
    @Field(name = "id", type = FieldType.Keyword)
    private String id;

    @Field(name = "bookname", type = FieldType.Text)
    private String bookName;

    @Field(name = "author_name", type = FieldType.Text)
    private String authorName;

    @Field(name = "publication_date", type = FieldType.Date)
    private Date publicationDate;

}
