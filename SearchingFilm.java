import java.util.Scanner;

class Film {

    int id;
    String namaFilm;
    String kategori;
    boolean aktif;

    public Film(int id, String namaFilm, String kategori) {

        this.id = id;
        this.namaFilm = namaFilm;
        this.kategori = kategori;
        this.aktif = true;
    }
}

public class SearchingFilm {

    static Scanner input = new Scanner(System.in);

    static Film[] daftarFilm = new Film[100];
    static int jumlahData = 0;

    public static void main(String[] args) {

        inisialisasiData();

        int pilih;

        do {

            System.out.println("\n===== MENU SEARCHING =====");
            System.out.println("1. Cari Berdasarkan Nama");
            System.out.println("2. Cari Berdasarkan ID");
            System.out.println("3. Cari Berdasarkan Kategori");
            System.out.println("4. Tampilkan Data");
            System.out.println("0. Keluar");

            System.out.print("Pilih Menu: ");
            pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {

                case 1:
                    cariNama();
                    break;

                case 2:
                    cariID();
                    break;

                case 3:
                    cariKategori();
                    break;

                case 4:
                    tampilData();
                    break;

                case 0:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Menu tidak tersedia.");
            }

        } while (pilih != 0);
    }

    // ================= TAMPIL DATA =================
    static void tampilData() {

        System.out.println("\n===== DATA FILM =====");

        for (int i = 0; i < jumlahData; i++) {

            if (daftarFilm[i].aktif) {

                System.out.println(
                        daftarFilm[i].id + " | " +
                        daftarFilm[i].namaFilm + " | " +
                        daftarFilm[i].kategori
                );
            }
        }
    }

    // ================= SEARCH NAMA =================
    static void cariNama() {

        System.out.print("Cari Nama Film: ");
        String cari = input.nextLine();

        boolean ditemukan = false;

        for (int i = 0; i < jumlahData; i++) {

            if (daftarFilm[i].aktif &&
                daftarFilm[i].namaFilm.toLowerCase().contains(cari.toLowerCase())) {

                System.out.println(
                        daftarFilm[i].id + " | " +
                        daftarFilm[i].namaFilm + " | " +
                        daftarFilm[i].kategori
                );

                ditemukan = true;
            }
        }

        if (!ditemukan) {

            System.out.println("Film tidak ditemukan.");
        }
    }

    // ================= SEARCH KATEGORI =================
    static void cariKategori() {

        System.out.print("Cari Kategori: ");
        String cari = input.nextLine();

        boolean ditemukan = false;

        for (int i = 0; i < jumlahData; i++) {

            if (daftarFilm[i].aktif &&
                daftarFilm[i].kategori.equalsIgnoreCase(cari)) {

                System.out.println(
                        daftarFilm[i].id + " | " +
                        daftarFilm[i].namaFilm + " | " +
                        daftarFilm[i].kategori
                );

                ditemukan = true;
            }
        }

        if (!ditemukan) {

            System.out.println("Kategori tidak ditemukan.");
        }
    }

    // ================= SORT ID =================
    static void bubbleSortID() {

        for (int i = 0; i < jumlahData - 1; i++) {

            for (int j = 0; j < jumlahData - i - 1; j++) {

                if (daftarFilm[j].id > daftarFilm[j + 1].id) {

                    Film temp = daftarFilm[j];
                    daftarFilm[j] = daftarFilm[j + 1];
                    daftarFilm[j + 1] = temp;
                }
            }
        }
    }

    // ================= SEARCH ID =================
    static void cariID() {

        bubbleSortID();

        System.out.print("Cari ID Film: ");
        int cari = input.nextInt();

        int kiri = 0;
        int kanan = jumlahData - 1;

        while (kiri <= kanan) {

            int tengah = (kiri + kanan) / 2;

            if (daftarFilm[tengah].id == cari) {

                System.out.println("Film ditemukan:");
                System.out.println(
                        daftarFilm[tengah].id + " | " +
                        daftarFilm[tengah].namaFilm + " | " +
                        daftarFilm[tengah].kategori
                );

                return;

            } else if (daftarFilm[tengah].id < cari) {

                kiri = tengah + 1;

            } else {

                kanan = tengah - 1;
            }
        }

        System.out.println("Film tidak ditemukan.");
    }

    // ================= DATA AWAL =================
    static void inisialisasiData() {

        daftarFilm[jumlahData++] =
                new Film(1, "Avengers Endgame", "Action");

        daftarFilm[jumlahData++] =
                new Film(2, "Spider Man No Way Home", "Action");

        daftarFilm[jumlahData++] =
                new Film(3, "Frozen 2", "Animasi");

        daftarFilm[jumlahData++] =
                new Film(4, "Insidious", "Horror");

        daftarFilm[jumlahData++] =
                new Film(5, "Interstellar", "SciFi");
    }
}
