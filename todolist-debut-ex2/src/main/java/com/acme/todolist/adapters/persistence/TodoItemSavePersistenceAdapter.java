package com.acme.todolist.adapters.persistence;
 
import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.acme.todolist.application.port.out.UpdateTodoItem;
import com.acme.todolist.domain.TodoItem;

@Component
public class TodoItemSavePersistenceAdapter implements UpdateTodoItem {
	
	private TodoItemRepository todoItemRepository;
	
	private TodoItemMapper mapper;
	
	@Inject
	public TodoItemSavePersistenceAdapter(TodoItemRepository todoItemRepository, TodoItemMapper mapper) {
		super();
		this.todoItemRepository = todoItemRepository;
		this.mapper = mapper;
	}

	@Override
	public void storeNewTodoItem(TodoItem todoItem) {
		this.todoItemRepository.save(mapper.mapToTodoItemJpaEntity(todoItem));
	}
}