package io.trutz.spring.example.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.MongoId;

public class Todo {

        @MongoId
        ObjectId id;

        String title;

        String description;

        public ObjectId getId() {
                return id;
        }

        public String getTitle() {
                return title;
        }

        public String getDescription() {
                return description;
        }

        public void setId(ObjectId id) {
                this.id = id;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public void setDescription(String description) {
                this.description = description;
        }

}