package views;

import entities.todolist;

public interface TodoListView {
    // Menampilkan semua todo list
    void displayAllTodos(todolist[] todos);

    // Menampilkan pesan jika todo berhasil ditambah
    void showTodoAddedMessage(todolist todo);

    // Menampilkan pesan jika todo berhasil diperbarui
    void showTodoUpdatedMessage(todolist todo);

    // Menampilkan pesan jika todo berhasil dihapus
    void showTodoDeletedMessage(int id);

    // Menampilkan pesan kesalahan
    void showErrorMessage(String message);

    // Menampilkan menu utama
    void showMenu();
}