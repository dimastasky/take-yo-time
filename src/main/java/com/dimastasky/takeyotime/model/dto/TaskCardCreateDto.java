package com.dimastasky.takeyotime.model.dto;

import com.dimastasky.takeyotime.model.Task.TaskCard;
import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.annotations.JMap;
import lombok.Data;

@Data
public class TaskCardCreateDto {

    @JMap
    private String userId;

    @JMap
    private String title;

    @JMap
    private String description;

    @JMap
    private Boolean isPublished;

    public static JMapper<TaskCard, TaskCardCreateDto> toEntity() {
        return new JMapper<>(TaskCard.class, TaskCardCreateDto.class);
    }

}
