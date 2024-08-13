package io.trutz.spring.example.ui;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import io.trutz.spring.example.model.TodoRepository;

@Route
class TodoView extends VerticalLayout {

    private final TodoRepository repository;

    public TodoView(TodoRepository repository) {
        this.repository = repository;
        add(new H1("Hello, Spring!" + this.repository.count()));
    }

}
