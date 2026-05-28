import java.util.Scanner;

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

public class SortFilm {

    static Scanner input = new Scanner(System.in);
    static Film[] daftarFilm = new Film[100];
    static int jumlahData = 0;

    public static void main(String[] args) {

        inisialisasi30Data();
        int pilih;

        do {
            System.out.println("\n==================================================");
            System.out.println("            PENGURUTAN DATA FILM BIOSKOP");
            System.out.println("==================================================");
            System.out.println("1. Urutkan Berdasarkan ID         (Bubble Sort)");
            System.out.println("2. Urutkan Berdasarkan Nama       (Selection Sort)");
            System.out.println("3. Urutkan Berdasarkan Tiket Terjual (Bubble Sort)");
            System.out.println("0. Keluar");
            System.out.println("==================================================");
            System.out.print("Pilih Menu: ");
            pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {
                case 1:
                    bubbleSortID();
                    System.out.println("\n[Diurutkan berdasarkan ID - Ascending]");
                    tampilData();
                    break;
                case 2:
                    selectionSortNama();
                    System.out.println("\n[Diurutkan berdasarkan Nama - A ke Z]");
                    tampilData();
                    break;
                case 3:
                    bubbleSortTiket();
                    System.out.println("\n[Diurutkan berdasarkan Tiket Terjual - Terbanyak ke Tersedikit]");
                    tampilData();
                    break;
                case 0:
                    System.out.println("Keluar...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (pilih != 0);
    }

    // ================= TAMPIL DATA =================
    static void tampilData() {

        System.out.println("\n==============================================================================");
        System.out.printf("%-4s %-25s %-10s %-15s %-10s %-10s\n",
                "ID", "NAMA", "KATEGORI", "STATUS", "JUAL", "SISA");
        System.out.println("==============================================================================");

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

        System.out.println("==============================================================================");
    }

    // ================= BUBBLE SORT BERDASARKAN ID (Ascending) =================
    static void bubbleSortID() {

        System.out.println("\nProses Bubble Sort berdasarkan ID...");

        for (int i = 0; i < jumlahData - 1; i++) {

            for (int j = 0; j < jumlahData - i - 1; j++) {

                if (daftarFilm[j].id > daftarFilm[j + 1].id) {

                    Film t = daftarFilm[j];
                    daftarFilm[j] = daftarFilm[j + 1];
                    daftarFilm[j + 1] = t;
                }
            }
        }

        System.out.println("Selesai! Data berhasil diurutkan berdasarkan ID.");
    }

    // ================= SELECTION SORT BERDASARKAN NAMA (A-Z) =================
    static void selectionSortNama() {

        System.out.println("\nProses Selection Sort berdasarkan Nama...");

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

        System.out.println("Selesai! Data berhasil diurutkan berdasarkan Nama.");
    }

    // ================= BUBBLE SORT BERDASARKAN TIKET TERJUAL (Descending) =================
    static void bubbleSortTiket() {

        System.out.println("\nProses Bubble Sort berdasarkan Tiket Terjual...");

        for (int i = 0; i < jumlahData - 1; i++) {

            for (int j = 0; j < jumlahData - i - 1; j++) {

                if (daftarFilm[j].tiketTerjual < daftarFilm[j + 1].tiketTerjual) {

                    Film t = daftarFilm[j];
                    daftarFilm[j] = daftarFilm[j + 1];
                    daftarFilm[j + 1] = t;
                }
            }
        }

        System.out.println("Selesai! Data berhasil diurutkan berdasarkan Tiket Terjual.");
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