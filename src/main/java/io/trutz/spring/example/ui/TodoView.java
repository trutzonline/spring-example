package io.trutz.spring.example.ui;

import org.springframework.data.domain.PageRequest;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.data.provider.BackEndDataProvider;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.router.Route;

import io.trutz.spring.example.model.Todo;
import io.trutz.spring.example.model.TodoRepository;

@Route
class TodoView extends VerticalLayout {

    public TodoView(TodoRepository todoRepository) {

        TodoForm todoForm = new TodoForm();

        Grid<Todo> allTodos = new Grid<>(Todo.class);
        BackEndDataProvider<Todo, Void> dataProvider = DataProvider.fromCallbacks(
                query -> {
                    var page = PageRequest.of(query.getPage(), query.getPageSize());
                    return todoRepository.findAll(page).stream();
                },
                query -> (int) todoRepository.count());
        allTodos.setDataProvider(dataProvider);

        Button saveButton = new Button("Save");
        saveButton.addClickListener(click -> {
            try {
                Todo todo = new Todo();
                todoForm.getBinder().writeBean(todo);
                todoRepository.save(todo);
                allTodos.getDataProvider().refreshAll();
            } catch (ValidationException validationException) {
            }
        });

        add(todoForm, saveButton, allTodos);
    }

}
