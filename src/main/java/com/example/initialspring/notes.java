package com.example.initialspring;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "notes")
public class notes {
    @Id
    private ObjectId id;

    public void setId(ObjectId id) {
        this.id = id;
    }

    private String title;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    private String content;

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public ObjectId getId() {
        return id;
    }
}
