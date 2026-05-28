import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class AdditionalFeatures {

    // NOTE: ini harus NYAMBUNG ke class utama kamu
    // jadi asumsi:
    // Film[] daftarFilm;
    // int jumlahData;
    // Scanner input;

    static Film[] daftarFilm;
    static int jumlahData;
    static Scanner input;

    // ================= UPDATE STATUS =================
    static void updateStatus() {

        System.out.print("ID: ");
        int id = input.nextInt(); input.nextLine();

        for (int i = 0; i < jumlahData; i++) {

            if (daftarFilm[i].id == id && daftarFilm[i].aktif) {

                System.out.print("Status baru: ");
                daftarFilm[i].statusFilm = input.nextLine();

                System.out.println("Status berhasil diupdate.");
                return;
            }
        }

        System.out.println("Film tidak ditemukan.");
    }

    // ================= COUNTER =================
    static void counterFilm() {

        int sedang = 0;
        int akan = 0;

        for (int i = 0; i < jumlahData; i++) {

            if (daftarFilm[i].aktif) {

                if (daftarFilm[i].statusFilm.equalsIgnoreCase("Sedang Tayang"))
                    sedang++;

                if (daftarFilm[i].statusFilm.equalsIgnoreCase("Akan Tayang"))
                    akan++;
            }
        }

        System.out.println("\n===== COUNTER FILM =====");
        System.out.println("Sedang Tayang : " + sedang);
        System.out.println("Akan Tayang   : " + akan);
    }

    // ================= STATISTIK =================
    static void statistikLanjutan() {

        int totalFilm = 0;
        int totalTersedia = 0;
        int totalTerjual = 0;

        int max = -1;
        int idx = -1;

        for (int i = 0; i < jumlahData; i++) {

            if (daftarFilm[i].aktif) {

                totalFilm++;
                totalTersedia += daftarFilm[i].tiketTersedia;
                totalTerjual += daftarFilm[i].tiketTerjual;

                if (daftarFilm[i].tiketTerjual > max) {
                    max = daftarFilm[i].tiketTerjual;
                    idx = i;
                }
            }
        }

        System.out.println("\n===== STATISTIK FILM =====");
        System.out.println("Total Film     : " + totalFilm);
        System.out.println("Tiket Tersedia : " + totalTersedia);
        System.out.println("Tiket Terjual  : " + totalTerjual);

        if (idx != -1) {
            System.out.println("Film Terlaris  : " + daftarFilm[idx].namaFilm);
        }
    }

    // ================= SAVE =================
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
            System.out.println("Data berhasil disimpan.");

        } catch (Exception e) {
            System.out.println("Gagal menyimpan file.");
        }
    }

    // ================= LOAD =================
    static void loadDariFile() {

        try {
            Scanner file = new Scanner(new File("datafilm.txt"));

            jumlahData = 0;

            while (file.hasNextLine()) {

                String line = file.nextLine();
                if (line.isEmpty()) continue;

                String[] d = line.split(";");

                if (d.length == 6) {

                    daftarFilm[jumlahData++] = new Film(
                            Integer.parseInt(d[0]),
                            d[1],
                            d[2],
                            d[3],
                            Integer.parseInt(d[4]),
                            Integer.parseInt(d[5])
                    );
                }
            }

            file.close();
            System.out.println("Data berhasil diload.");

        } catch (Exception e) {
            System.out.println("File tidak ditemukan / format salah.");
        }
    }
}