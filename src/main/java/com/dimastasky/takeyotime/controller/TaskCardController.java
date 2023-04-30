package com.dimastasky.takeyotime.controller;

import com.dimastasky.takeyotime.model.Task.TaskCard;
import com.dimastasky.takeyotime.model.dto.TaskCardCreateDto;
import com.dimastasky.takeyotime.service.TaskCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/take-yo-time/api/tasks")
public class TaskCardController {

    @Autowired
    TaskCardService taskCardService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<TaskCard> getAllTaskCards(@RequestParam(required = false) String title ) {
        if (title == null)
            return taskCardService.findAll();
        else
            return taskCardService.findByTitleContaining(title);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<TaskCard> getTaskCardById(@PathVariable("id") String id) {
        return taskCardService.findById(id);
    }

//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public Mono<TaskCard> createTask(@RequestBody TaskCardCreateDto creationDto) {
//        TaskCard card = TaskCardCreateDto.toEntity().getDestination(creationDto);
//        return taskCardService.save(card);
//    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<TaskCard> createTask(@RequestBody TaskCard taskCard) {
//        TaskCard card = TaskCardCreateDto.toEntity().getDestination(creationDto);
        return taskCardService.save(taskCard);
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<TaskCard> updateTaskCard(@PathVariable("id") String id, @RequestBody TaskCardCreateDto updateDto) {
        TaskCard card = TaskCardCreateDto.toEntity().getDestination(updateDto);
        return taskCardService.update(id, card);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteTaskCard(@PathVariable("id") String id) {
        return taskCardService.deleteById(id);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteAllTaskCards() {
        return taskCardService.deleteAll();
    }

    @GetMapping("/published")
    @ResponseStatus(HttpStatus.OK)
    public Flux<TaskCard> findByPublished() {
        return taskCardService.findByPublished(true);
    }


}
