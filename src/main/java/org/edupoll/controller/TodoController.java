package org.edupoll.controller;

import java.util.List;

import org.edupoll.model.Quest;
import org.edupoll.model.Todo;
import org.edupoll.service.QuestService;
import org.edupoll.service.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import jakarta.validation.Valid;

@Controller
public class TodoController {
	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	TodoService todoService;

	@Autowired
	QuestService questService;

	@GetMapping("/todos")
	public String gotoTodolist(@SessionAttribute String logonId, ModelMap model) {
		List<Todo> todos = todoService.getTodos(logonId);
		List<Quest> quests = questService.getThisWeekQuest();
		model.put("todos", todos);
		model.put("quests", quests);

		return "todos/list";
	}

	@GetMapping("/todos/create")
	public String gotoCreateTodoView() {

		return "todos/create";
	}

	@PostMapping("/todos/create-task")
	public String handleCreateTodo(@Valid Todo todo, BindingResult result, @SessionAttribute String logonId,
			Model model) {
		logger.debug("injected Todo's {}, {}", todo.getDescription(), todo.getTargetDate());

		if (result.hasErrors()) {
			model.addAttribute("msg", "유효하지 않은 값들이 존재합니다.");
			return "todos/create";
		} else {
			boolean rst = todoService.addNewTodo(todo, logonId);
			if (rst) {
				return "redirect:/todos";
			} else {
				return "todos/create";
			}
		}
	}

	@GetMapping("/todos/delete")
	public String handleDeleteTodo(@RequestParam String todoId, @SessionAttribute String logonId) {

		boolean rst = todoService.removeTodo(todoId, logonId);

		if (rst) {
			return "redirect:/todos";
		} else {
			return "fail";
		}
	}

	@GetMapping("/todos/update")
	public String gotoUpdateView(@RequestParam String todoId, ModelMap model) {
		Todo todo = todoService.getTodo(todoId);
		model.addAttribute("todo", todo);

		return "todos/update";
	}

	@PostMapping("/todos/update-task")
	public String handleUpdate(@Valid Todo todo, BindingResult result, @SessionAttribute String logonId,
			ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute("todo", todo);
			model.addAttribute("error", "유효하지 않은 데이터가 포함되어있다");
			return "todos/update";
		}
		boolean rst = todoService.updateTodo(todo, logonId);
		if (rst) {
			return "redirect:/todos";
		} else {
			model.addAttribute("todo", todo);
			model.addAttribute("error", "서비스 장애로 요청을 처리할 수 없습니다.");
			return "todos/update";
		}
	}

	@GetMapping("/todos/addQuest")
	public String handleAddQuest(@RequestParam int questId, @SessionAttribute String logonId) {
		boolean rst = todoService.acceptNewQuest(questId, logonId);

		return "redirect:/todos";

	}

}
