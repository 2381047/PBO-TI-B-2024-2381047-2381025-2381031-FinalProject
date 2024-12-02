package views;

import entities.todolist;
import services.TodolistServiceImpl;
import services.TodoListService;
import services.TodolistServiceImpl;

import java.util.Scanner;

public class TodoListTerminalViewImpl {
    private TodoListService todoListService;
    private Scanner scanner;

    // Constructor
    public TodoListTerminalViewImpl() {
        this.todoListService = new TodolistServiceImpl();  // Inisialisasi service
        this.scanner = new Scanner(System.in);  // Inisialisasi scanner untuk input
    }

    // Menampilkan menu utama
    public void showMenu() {
        while (true) {
            System.out.println("\n===== Todo List Menu =====");
            System.out.println("1. Lihat Semua Todo");
            System.out.println("2. Tambah Todo");
            System.out.println("3. Edit Todo");
            System.out.println("4. Hapus Todo");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");

            int option = scanner.nextInt();
            scanner.nextLine();  // Membuang newline yang tertinggal setelah nextInt()

            switch (option) {
                case 1:
                    viewAllTodos();
                    break;
                case 2:
                    addTodo();
                    break;
                case 3:
                    editTodo();
                    break;
                case 4:
                    deleteTodo();
                    break;
                case 5:
                    System.out.println("Keluar dari aplikasi...");
                    return;
                default:
                    System.out.println("Opsi tidak valid. Silakan coba lagi.");
            }
        }
    }

    // Menampilkan semua todo
    private void viewAllTodos() {
        todolist[] todos = todoListService.getAllTodos();
        if (todos.length == 0) {
            System.out.println("Tidak ada todo list.");
        } else {
            System.out.println("\n===== Semua Todo List =====");
            for (todolist todo : todos) {
                if (todo != null) {
                    System.out.println(todo);
                }
            }
        }
    }

    // Menambah todo baru
    private void addTodo() {
        System.out.print("\nMasukkan ID Todo: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Membuang newline yang tertinggal setelah nextInt()

        System.out.print("Masukkan Judul Todo: ");
        String title = scanner.nextLine();

        System.out.print("Masukkan Deskripsi Todo: ");
        String description = scanner.nextLine();

        System.out.print("Masukkan Status Todo (Pending/Completed): ");
        String status = scanner.nextLine();

        todolist newTodo = new todolist(id, title, description, status);
        todoListService.addTodo(newTodo);
        System.out.println("Todo baru berhasil ditambahkan!");
    }

    // Mengedit todo yang ada
    private void editTodo() {
        System.out.print("\nMasukkan ID Todo yang ingin diedit: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Membuang newline yang tertinggal setelah nextInt()

        System.out.print("Masukkan Judul Todo baru: ");
        String title = scanner.nextLine();

        System.out.print("Masukkan Deskripsi Todo baru: ");
        String description = scanner.nextLine();

        System.out.print("Masukkan Status Todo baru (Pending/Completed): ");
        String status = scanner.nextLine();

        todolist updatedTodo = new todolist(id, title, description, status);
        boolean result = todoListService.editTodoById(updatedTodo);

        if (result) {
            System.out.println("Todo berhasil diperbarui!");
        } else {
            System.out.println("Gagal memperbarui Todo. Mungkin ID tidak valid.");
        }
    }

    // Menghapus todo berdasarkan ID
    private void deleteTodo() {
        System.out.print("\nMasukkan ID Todo yang ingin dihapus: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Membuang newline yang tertinggal setelah nextInt()

        boolean result = todoListService.removeTodoById(id);
        if (result) {
            System.out.println("Todo berhasil dihapus!");
        } else {
            System.out.println("Gagal menghapus Todo. Mungkin ID tidak valid.");
        }
    }
}