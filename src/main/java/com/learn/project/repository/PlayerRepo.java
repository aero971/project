package com.learn.project.repository;

import com.learn.project.entity.Player;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayerRepo extends MongoRepository<Player, ObjectId> {
}
