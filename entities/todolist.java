package entities;

public class todolist {
    private Integer id;            // ID unik untuk setiap item dalam daftar
    private String namaAkunGame;   // Nama akun game yang terkait
    private String status;         // Status item (misalnya: "Pending", "Completed")
    private double harga;          // Harga akun game yang terkait
    private String emailPengguna;  // Email pengguna yang melakukan transaksi

    // Constructor default
    public todolist() {
    }

    // Constructor dengan parameter
    public todolist(Integer id, String namaAkunGame, String status, double harga, String emailPengguna) {
        this.id = id;
        this.namaAkunGame = namaAkunGame;
        this.status = status;
        this.harga = harga;
        this.emailPengguna = emailPengguna;
    }

    // Getter dan Setter untuk ID
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // Getter dan Setter untuk nama akun game
    public String getNamaAkunGame() {
        return namaAkunGame;
    }

    public void setNamaAkunGame(String namaAkunGame) {
        this.namaAkunGame = namaAkunGame;
    }

    // Getter dan Setter untuk status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Getter dan Setter untuk harga akun game
    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    // Getter dan Setter untuk email pengguna
    public String getEmailPengguna() {
        return emailPengguna;
    }

    public void setEmailPengguna(String emailPengguna) {
        this.emailPengguna = emailPengguna;
    }

    // Method toString untuk menampilkan informasi TodoList
    @Override
    public String toString() {
        return "TodoList{" +
                "id=" + id +
                ", namaAkunGame='" + namaAkunGame + '\'' +
                ", status='" + status + '\'' +
                ", harga=" + harga +
                ", emailPengguna='" + emailPengguna + '\'' +
                '}';
    }
}