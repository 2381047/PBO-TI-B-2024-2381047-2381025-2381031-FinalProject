package repositories;

import entities.todolist;

public class TodoListRepositoryImpl implements TodoListRepository {
    // Array untuk menyimpan TodoList
    private static todolist[] todos = new todolist[2];

    @Override
    public todolist[] getAll() {
        return todos;
    }

    @Override
    public void add(final todolist todolist) {
        // Memastikan array akan diresize jika penuh
        resizeArrayIfFull();

        // Menambahkan todo ke array pada posisi null
        for (int i = 0; i < todos.length; i++) {
            if (todos[i] == null) {
                todos[i] = todolist;
                break;
            }
        }
    }

    // Fungsi untuk memeriksa apakah array penuh dan meresize jika perlu
    private void resizeArrayIfFull() {
        boolean isFull = true;

        // Cek apakah array penuh
        for (int i = 0; i < todos.length; i++) {
            if (todos[i] == null) {
                isFull = false;
                break;
            }
        }

        // Jika penuh, resize array menjadi dua kali lebih besar
        if (isFull) {
            resizeArrayToTwoTimesBigger();
        }
    }

    // Fungsi untuk resize array menjadi dua kali lebih besar
    private void resizeArrayToTwoTimesBigger() {
        todolist[] temp = todos;
        todos = new todolist[todos.length * 2];
        System.arraycopy(temp, 0, todos, 0, temp.length); // Copy data lama ke array baru
    }

    @Override
    public Boolean remove(final Integer id) {
        // Validasi apakah ID yang diberikan valid
        if (isSelectedTodoNotValid(id)) {
            return false;
        }

        // Menghapus TodoList berdasarkan id
        for (int i = id - 1; i < todos.length; i++) {
            if (i == todos.length - 1) {
                todos[i] = null;  // Jika yang terakhir, set null
            } else {
                todos[i] = todos[i + 1];  // Geser elemen ke kiri
            }
        }
        return true;
    }

    // Validasi jika TodoList dengan id tertentu tidak valid
    private static boolean isSelectedTodoNotValid(final Integer id) {
        if (id <= 0) {
            return true;  // ID tidak valid jika kurang dari atau sama dengan 0
        }

        if (id - 1 >= todos.length || todos[id - 1] == null) {
            return true;  // ID lebih besar dari ukuran array atau elemen null
        }

        return false;
    }

    @Override
    public Boolean edit(final todolist todoList) {
        // Validasi apakah TodoList dengan ID yang diberikan valid
        if (isSelectedTodoNotValid(todoList.getId())) {
            return false;
        }

        // Update TodoList pada posisi yang sesuai dengan ID
        todos[todoList.getId() - 1] = todoList;
        return true;
    }
}