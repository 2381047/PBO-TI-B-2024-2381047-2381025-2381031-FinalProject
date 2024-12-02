package repositories;

import entities.todolist;
import java.util.List;

public interface TodoListRepository {
    // Mengambil semua TodoList
    List<TodoListRepository> getAll();

    // Menambahkan TodoList baru
    void add(TodoListRepository todoList);

    // Menghapus TodoList berdasarkan ID
    boolean remove(Integer id);

    // Mengedit TodoList
    boolean update(TodoListRepository todoList);
}