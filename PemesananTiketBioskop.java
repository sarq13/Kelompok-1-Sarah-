import java.util.Scanner;
import java.io.*;

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

public class PemesananTiketBioskop {

    static Scanner input = new Scanner(System.in);
    static Film[] daftarFilm = new Film[100];
    static int jumlahData = 0;

    public static void main(String[] args) {

        inisialisasi30Data();
        int pilih;

        do {

            System.out.println("\n==================================================");
            System.out.println("         SISTEM PEMESANAN TIKET BIOSKOP");
            System.out.println("==================================================");
            System.out.println("1.  Tambah Data Film");
            System.out.println("2.  Tampilkan Semua Data");
            System.out.println("3.  Edit Data Film");
            System.out.println("4.  Hapus Data Film");
            System.out.println("5.  Cari Berdasarkan Nama");
            System.out.println("6.  Cari Berdasarkan ID");
            System.out.println("7.  Cari Berdasarkan Kategori");
            System.out.println("8.  Urutkan Berdasarkan ID");
            System.out.println("9.  Urutkan Berdasarkan Nama");
            System.out.println("10. Urutkan Berdasarkan Tiket Terjual");
            System.out.println("11. Statistik Film");
            System.out.println("12. Film Akan Tayang");
            System.out.println("13. Update Status Film");
            System.out.println("14. Counter Film");
            System.out.println("15. Simpan Data ke File");
            System.out.println("16. Load Data dari File");
            System.out.println("0.  Keluar");
            System.out.println("==================================================");

            System.out.print("Pilih Menu: ");
            pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {

                case 1: tambahData(); break;
                case 2: tampilData(); break;
                case 3: editData(); break;
                case 4: hapusData(); break;
                case 5: cariNama(); break;
                case 6: cariID(); break;
                case 7: cariKategori(); break;
                case 8: bubbleSortID(); tampilData(); break;
                case 9: selectionSortNama(); tampilData(); break;
                case 10: bubbleSortTiket(); tampilData(); break;
                case 11: statistikFilm(); break;
                case 12: filmAkanTayang(); break;
                case 13: updateStatus(); break;
                case 14: counterFilm(); break;
                case 15: simpanKeFile(); break;
                case 16: loadDariFile(); break;
                case 0: System.out.println("Keluar..."); break;
                default: System.out.println("Pilihan salah!");
            }

        } while (pilih != 0);
    }

    // ================= TAMBAH =================
    static void tambahData() {

        System.out.print("ID: ");
        int id = input.nextInt();
        input.nextLine();

        System.out.print("Nama: ");
        String nama = input.nextLine();

        System.out.print("Kategori: ");
        String kat = input.nextLine();

        System.out.print("Status: ");
        String stat = input.nextLine();

        System.out.print("Terjual: ");
        int terjual = input.nextInt();

        System.out.print("Tersedia: ");
        int sedia = input.nextInt();

        daftarFilm[jumlahData++] = new Film(id, nama, kat, stat, terjual, sedia);

        System.out.println("Data ditambahkan.");
    }

    // ================= TAMPIL =================
    static void tampilData() {

        System.out.println("\n==============================================================");

        System.out.printf("%-4s %-25s %-10s %-15s %-10s %-10s\n",
                "ID","NAMA","KATEGORI","STATUS","JUAL","SISA");

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

    // ================= EDIT =================
    static void editData() {

        System.out.print("ID edit: ");
        int cari = input.nextInt();
        input.nextLine();

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

    // ================= HAPUS =================
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
    }

    // ================= SORT =================
    static void bubbleSortID() {

        for (int i = 0; i < jumlahData - 1; i++) {

            for (int j = 0; j < jumlahData - i - 1; j++) {

                if (daftarFilm[j].id > daftarFilm[j + 1].id) {

                    Film t = daftarFilm[j];
                    daftarFilm[j] = daftarFilm[j + 1];
                    daftarFilm[j + 1] = t;
                }
            }
        }
    }

    static void selectionSortNama() {

        for (int i = 0; i < jumlahData - 1; i++) {

            int min = i;

            for (int j = i + 1; j < jumlahData; j++) {

                if (daftarFilm[j].namaFilm.compareToIgnoreCase(daftarFilm[min].namaFilm) < 0) {

                    min = j;
                }
            }

            Film t = daftarFilm[min];
            daftarFilm[min] = daftarFilm[i];
            daftarFilm[i] = t;
        }
    }

    static void bubbleSortTiket() {

        for (int i = 0; i < jumlahData - 1; i++) {

            for (int j = 0; j < jumlahData - i - 1; j++) {

                if (daftarFilm[j].tiketTerjual < daftarFilm[j + 1].tiketTerjual) {

                    Film t = daftarFilm[j];
                    daftarFilm[j] = daftarFilm[j + 1];
                    daftarFilm[j + 1] = t;
                }
            }
        }
    }

    // ================= SEARCH =================
    static void cariNama() {

        System.out.print("Cari Nama: ");
        String cari = input.nextLine();

        for (int i = 0; i < jumlahData; i++) {

            if (daftarFilm[i].aktif &&
                    daftarFilm[i].namaFilm.toLowerCase().contains(cari.toLowerCase())) {

                System.out.println(daftarFilm[i].namaFilm);
            }
        }
    }

    static void cariKategori() {

        System.out.print("Cari Kategori: ");
        String cari = input.nextLine();

        for (int i = 0; i < jumlahData; i++) {

            if (daftarFilm[i].aktif &&
                    daftarFilm[i].kategori.equalsIgnoreCase(cari)) {

                System.out.println(daftarFilm[i].namaFilm);
            }
        }
    }

    static void cariID() {

        bubbleSortID();

        System.out.print("Cari ID: ");
        int cari = input.nextInt();

        int l = 0;
        int r = jumlahData - 1;

        while (l <= r) {

            int m = (l + r) / 2;

            if (daftarFilm[m].id == cari) {

                System.out.println(daftarFilm[m].namaFilm);
                return;

            } else if (daftarFilm[m].id < cari) {

                l = m + 1;

            } else {

                r = m - 1;
            }
        }

        System.out.println("Tidak ditemukan.");
    }

    // ================= STATISTIK =================
    static void statistikFilm() {

        int total = 0;
        int sisa = 0;
        int max = -1;
        int idx = -1;

        for (int i = 0; i < jumlahData; i++) {

            if (daftarFilm[i].aktif) {

                total++;
                sisa += daftarFilm[i].tiketTersedia;

                if (daftarFilm[i].tiketTerjual > max) {

                    max = daftarFilm[i].tiketTerjual;
                    idx = i;
                }
            }
        }

        System.out.println("Total Film : " + total);
        System.out.println("Tiket Tersedia : " + sisa);

        if (idx != -1) {

            System.out.println("Terlaris : " + daftarFilm[idx].namaFilm);
        }
    }

    static void filmAkanTayang() {

        System.out.println("\nFILM AKAN TAYANG:");

        for (int i = 0; i < jumlahData; i++) {

            if (daftarFilm[i].statusFilm.equalsIgnoreCase("Akan Tayang")) {

                System.out.println(daftarFilm[i].namaFilm);
            }
        }
    }

    // ================= FITUR TAMBAHAN =================
    static void updateStatus() {

        System.out.print("ID: ");
        int id = input.nextInt();
        input.nextLine();

        for (int i = 0; i < jumlahData; i++) {

            if (daftarFilm[i].id == id) {

                System.out.print("Status baru: ");
                daftarFilm[i].statusFilm = input.nextLine();

                System.out.println("Status berhasil diupdate.");
                return;
            }
        }
    }

    static void counterFilm() {

        int total = 0;
        int sedang = 0;
        int akan = 0;

        for (int i = 0; i < jumlahData; i++) {

            if (daftarFilm[i].aktif) {

                total++;

                if (daftarFilm[i].statusFilm.equalsIgnoreCase("Sedang Tayang")) {

                    sedang++;
                }

                if (daftarFilm[i].statusFilm.equalsIgnoreCase("Akan Tayang")) {

                    akan++;
                }
            }
        }

        System.out.println("Total Film : " + total);
        System.out.println("Sedang Tayang : " + sedang);
        System.out.println("Akan Tayang : " + akan);
    }

    static void simpanKeFile() {

        try {

            PrintWriter w = new PrintWriter("datafilm.txt");

            for (int i = 0; i < jumlahData; i++) {

                if (daftarFilm[i].aktif) {

                    w.println(
                            daftarFilm[i].id + ";" +
                            daftarFilm[i].namaFilm + ";" +
                            daftarFilm[i].kategori + ";" +
                            daftarFilm[i].statusFilm + ";" +
                            daftarFilm[i].tiketTerjual + ";" +
                            daftarFilm[i].tiketTersedia
                    );
                }
            }

            w.close();

            System.out.println("Tersimpan.");

        } catch (Exception e) {

            System.out.println("Gagal save.");
        }
    }

    static void loadDariFile() {

        try {

            Scanner b = new Scanner(new File("datafilm.txt"));
            jumlahData = 0;

            while (b.hasNextLine()) {

                String[] d = b.nextLine().split(";");

                daftarFilm[jumlahData++] = new Film(
                        Integer.parseInt(d[0]),
                        d[1],
                        d[2],
                        d[3],
                        Integer.parseInt(d[4]),
                        Integer.parseInt(d[5])
                );
            }

            b.close();

            System.out.println("Loaded.");

        } catch (Exception e) {

            System.out.println("File tidak ada.");
        }
    }

    // ================= DATA AWAL =================
    static void inisialisasi30Data() {

        String[] nama = {
                "Avengers Endgame", "Spider Man No Way Home", "The Batman", "Fast Furious 9", "John Wick 4",
                "Insidious", "The Nun", "Annabelle", "Pengabdi Setan", "KKN Desa Penari",
                "Frozen 2", "Toy Story 4", "Minions", "Moana", "Encanto",
                "Interstellar", "Inception", "Oppenheimer", "Top Gun Maverick", "Mission Impossible",
                "Doctor Strange", "Black Panther", "Aquaman", "Transformers", "Joker",
                "Deadpool", "Cars", "Up", "Coco", "Elemental"
        };

        String[] kat = {
                "Action","Action","Action","Action","Action",
                "Horror","Horror","Horror","Horror","Horror",
                "Animasi","Animasi","Animasi","Animasi","Animasi",
                "SciFi","SciFi","SciFi","Action","Action",
                "Action","Action","Action","SciFi","Drama",
                "Comedy","Animasi","Animasi","Animasi","Animasi"
        };

        String[] stat = {
                "Sedang Tayang","Sedang Tayang","Sedang Tayang","Akan Tayang","Sedang Tayang",
                "Sedang Tayang","Akan Tayang","Sedang Tayang","Sedang Tayang","Akan Tayang",
                "Sedang Tayang","Sedang Tayang","Akan Tayang","Sedang Tayang","Akan Tayang",
                "Sedang Tayang","Sedang Tayang","Akan Tayang","Sedang Tayang","Sedang Tayang",
                "Akan Tayang","Sedang Tayang","Sedang Tayang","Akan Tayang","Sedang Tayang",
                "Sedang Tayang","Sedang Tayang","Akan Tayang","Sedang Tayang","Akan Tayang"
        };

        int[] terjual = {
                95,88,76,65,90,
                70,50,45,85,92,
                60,58,40,75,35,
                80,89,55,93,82,
                67,91,73,64,78,
                87,49,52,69,44
        };

        int[] sedia = {
                5,12,24,35,10,
                30,50,55,15,8,
                40,42,60,25,65,
                20,11,45,7,18,
                33,9,27,36,22,
                13,51,48,31,56
        };

        for (int i = 0; i < nama.length; i++) {

            daftarFilm[jumlahData++] = new Film(
                    i + 1,
                    nama[i],
                    kat[i],
                    stat[i],
                    terjual[i],
                    sedia[i]
            );
        }
    }
}