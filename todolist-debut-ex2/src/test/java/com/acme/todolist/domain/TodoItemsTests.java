package com.acme.todolist.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import org.junit.jupiter.api.Test;

public class TodoItemsTests {

	static final String LATE = "[LATE!] ";
	
	@Test
	public void finalContent_todoIsLate() {
		LocalDate date = LocalDate.parse("2020-03-20");
		Instant late = date.atStartOfDay(ZoneId.of("Europe/Paris")).toInstant();
		TodoItem todo = new TodoItem("1", late, "retard");

		assertTrue(todo.finalContent().contains(LATE));
	}

	@Test
	public void finalContent_todoIsNotLate() {
		Instant notLate = Instant.now();
		TodoItem todo = new TodoItem("2", notLate, "pas en retard");

		assertTrue(!todo.finalContent().contains(LATE));
	}
}
