package org.edupoll.repository.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

import org.edupoll.model.Todo;
import org.edupoll.repository.TodoRepository;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class InMemoryTodoRepository implements TodoRepository {
	List<Todo> list;

	@PostConstruct
	public void init() {
		list = new ArrayList<>();
		list.add(new Todo("3fe9de11", "user", "자바 기초 다기지", new Date(113, 6, 1), null));
		list.add(new Todo("f7e9def9", "user", "자바 웹 기초 다기지", new Date(113, 7, 1), null));
		list.add(new Todo("1a71c677", "master", "자바 마스터하기", new Date(129, 11, 31), null));
	}

	@Override
	public void create(Todo todo) {
		list.add(todo);
	}

	@Override
	public Todo findById(String id) {
		return list.stream().filter((one) -> {
			return one.getId().equals(id);
		}).findFirst().orElse(null);
	}

	@Override
	public List<Todo> findByOwner(String owner) {
		return list.stream().filter(t -> t.getOwner().equals(owner)).toList();

	}

	@Override
	public void deleteById(String id) {
		list = list.stream().filter((one) -> {
			return !one.getId().equals(id);
		}).toList();
	}

	@Override
	public void update(Todo todo) {

	}

}
