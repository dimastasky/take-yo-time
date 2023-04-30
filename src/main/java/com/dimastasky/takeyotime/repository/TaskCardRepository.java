package com.dimastasky.takeyotime.repository;

import com.dimastasky.takeyotime.model.Task.TaskCard;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface TaskCardRepository extends ReactiveMongoRepository<TaskCard, String> {
    Flux<TaskCard> findByIsPublished(Boolean isPublished);

    Flux<TaskCard> findByTitleContaining(String title);
}
