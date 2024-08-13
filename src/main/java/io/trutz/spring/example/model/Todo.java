package io.trutz.spring.example.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.MongoId;

public record Todo(@MongoId ObjectId id) {
}
