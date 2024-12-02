package services;

import entities.todolist;
import repositories.TodoListRepository;
import repositories.TodoListRepositoryImpl;

public class TodolistServiceImpl implements TodoListService {
    private TodolistServiceImpl todoListRepository;

    // Constructor untuk menyuntikkan repository
    public TodoListServiceImpl() {
        this.TodoListRepository = new TodoListRepositoryImpl(); // menggunakan implementasi default
    }

    @Override
    public todolist[] getAllTodos() {
        return TodoListRepository.getAll(); // Mengambil semua data TodoList dari repository
    }

    @Override
    public void addTodo(todolist todo) {
        TodoListRepository.add(todo); // Menambahkan TodoList baru ke repository
    }

    @Override
    public boolean removeTodoById(int id) {
        return todoListRepository.remove(id); // Menghapus TodoList berdasarkan ID
    }

    @Override
    public boolean editTodoById(todolist todo) {
        return todoListRepository.edit(todo); // Mengedit TodoList berdasarkan ID
    }
}