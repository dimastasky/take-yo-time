package com.dimastasky.takeyotime.model.Task;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "task-card")
@Getter
@Setter
@RequiredArgsConstructor
public class TaskCard {

    @Id
    private String id;

    private String userId;

    private String title;

    private String description;

    private Boolean isPublished;

    public TaskCard(String userId, String title, String description, Boolean isPublished) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.isPublished = isPublished;
    }


}
