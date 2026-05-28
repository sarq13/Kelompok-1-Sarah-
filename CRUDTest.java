import java.util.Scanner;

// Struktur Record untuk Film
class Film {
    int id;
    String namaFilm;
    String kategori;
    String statusFilm;
    int tiketTerjual;
    int tiketTersedia;
    boolean aktif;

    public Film(int id, String nama, String kat, String stat, int terjual, int sedia) {
        this.id = id;
        this.namaFilm = nama;
        this.kategori = kat;
        this.statusFilm = stat;
        this.tiketTerjual = terjual;
        this.tiketTersedia = sedia;
        this.aktif = true;
    }
}

public class CRUDTest {
    static Scanner input = new Scanner(System.in);
    static Film[] daftarFilm = new Film[100];
    static int jumlahData = 0;

    // menambahkan data
    static void tambahData() {
        System.out.print("ID: "); int id = input.nextInt(); input.nextLine();
        System.out.print("Nama: "); String nama = input.nextLine();
        System.out.print("Kategori: "); String kat = input.nextLine();
        System.out.print("Status: "); String stat = input.nextLine();
        System.out.print("Terjual: "); int terjual = input.nextInt();
        System.out.print("Tersedia: "); int sedia = input.nextInt();

        daftarFilm[jumlahData++] = new Film(id, nama, kat, stat, terjual, sedia);
        System.out.println("Data ditambahkan.");
    }

    // untuk menampilkan data
    static void tampilData() {
        System.out.println("\n==============================================================");
        System.out.printf("%-4s %-25s %-10s %-15s %-10s %-10s\n",
                "ID|","NAMA|","KATEGORI|","STATUS|","JUAL|","SISA|");

        for (int i = 0; i < jumlahData; i++) {
            if (daftarFilm[i].aktif) {
                System.out.printf("%-4d %-25s %-10s %-15s %-10d %-10d\n",
                        daftarFilm[i].id,
                        daftarFilm[i].namaFilm,
                        daftarFilm[i].kategori,
                        daftarFilm[i].statusFilm,
                        daftarFilm[i].tiketTerjual,
                        daftarFilm[i].tiketTersedia);
            }
        }
    }

    // untuk edit data
    static void editData() {
        System.out.print("ID edit: ");
        int cari = input.nextInt(); input.nextLine();

        for (int i = 0; i < jumlahData; i++) {
            if (daftarFilm[i].id == cari && daftarFilm[i].aktif) {
                System.out.print("Nama baru: ");
                daftarFilm[i].namaFilm = input.nextLine();

                System.out.print("Terjual baru: ");
                daftarFilm[i].tiketTerjual = input.nextInt();

                System.out.println("Update sukses.");
                return;
            }
        }
        System.out.println("Tidak ditemukan.");
    }

    // untuk menghapus data
    static void hapusData() {
        System.out.print("ID hapus: ");
        int cari = input.nextInt();

        for (int i = 0; i < jumlahData; i++) {
            if (daftarFilm[i].id == cari) {
                daftarFilm[i].aktif = false;
                System.out.println("Dihapus.");
                return;
            }
        }
        System.out.println("Tidak ditemukan.");
    }

    public static void main(String[] args) {
        int pilih;
        do {
            System.out.println("\n=== CRUD FILM ===");
            System.out.println("|1.| Tambah       |");
            System.out.println("|2.| Tampil       |");
            System.out.println("|3.| Edit         |");
            System.out.println("|4.| Hapus        |");
            System.out.println("|0.| Keluar       |");
            System.out.println("==================");
            System.out.print("Pilih: ");
            pilih = input.nextInt(); input.nextLine();

            switch(pilih) {
                case 1: tambahData(); break;
                case 2: tampilData(); break;
                case 3: editData(); break;
                case 4: hapusData(); break;
                case 0: System.out.println("Keluar"); break;
                default: System.out.println("Pilihan salah!");
            }
        } while(pilih != 0);
    }
}