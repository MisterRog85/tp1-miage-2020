package com.acme.todolist.application.port.in;

import com.acme.todolist.domain.TodoItem;

public interface AddTodoItems {
	void addTodoItem(TodoItem item);
}
