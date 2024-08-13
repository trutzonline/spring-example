package io.trutz.spring.example.ui;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

import io.trutz.spring.example.model.Todo;

public class TodoForm extends FormLayout {

    private final Binder<Todo> binder;

    public TodoForm() {

        binder = new Binder<Todo>();

        TextField titleField = new TextField();
        addFormItem(titleField, "Title");
        binder.forField(titleField).bind(Todo::getTitle, Todo::setTitle);

        TextField descriptionField = new TextField();
        addFormItem(descriptionField, "Description");
        binder.forField(descriptionField).bind(Todo::getDescription, Todo::setDescription);

    }

    public Binder<Todo> getBinder() {
        return binder;
    }

}