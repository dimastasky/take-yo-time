package com.dimastasky.takeyotime.service;

import com.dimastasky.takeyotime.model.Task.TaskCard;
import com.dimastasky.takeyotime.repository.TaskCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class TaskCardService {

    @Autowired
    TaskCardRepository repository;

    public Flux<TaskCard> findAll() {
        return repository.findAll();
    }

    public Flux<TaskCard> findByTitleContaining(String title) {
        return repository.findByTitleContaining(title);
    }

    public Mono<TaskCard> findById(String id) {
        return repository.findById(id);
    }

    public Mono<TaskCard> save(TaskCard taskCard) {
        return repository.save(taskCard);
    }

    public Mono<TaskCard> update(String id, TaskCard taskCard) {
        return repository.findById(id).map(Optional::of).defaultIfEmpty(Optional.empty())
                .flatMap(optionalTaskCard -> {
                    if (optionalTaskCard.isPresent()) {
                        taskCard.setId(id);
                        return  repository.save(taskCard);
                    }
                    return Mono.empty();
                });
    }

    public Mono<Void> deleteById(String id) {
        return repository.deleteById(id);
    }

    public Mono<Void> deleteAll() {
        return repository.deleteAll();
    }

    public Flux<TaskCard> findByPublished(Boolean isPublished) {
        return repository.findByIsPublished(isPublished);
    }

}
