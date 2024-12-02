package services;

import entities.todolist;

public interface TodoListService {
    todolist[] getAllTodos();
    void addTodo(todolist todo);
    boolean removeTodoById(int id);
    boolean editTodoById(todolist todo);
}