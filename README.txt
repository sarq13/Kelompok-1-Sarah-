# README.txt

# SISTEM PEMESANAN TIKET BIOSKOP

## Deskripsi:

Program ini merupakan aplikasi berbasis Java untuk mengelola data film dan pemesanan tiket bioskop menggunakan struktur array dan record (class Film).

## Fitur yang tersedia:

1. Tambah Data Film
2. Tampilkan Semua Data Film
3. Edit Data Film
4. Hapus Data Film (Soft Delete)
5. Cari Film Berdasarkan Nama
6. Cari Film Berdasarkan ID (Binary Search)
7. Cari Film Berdasarkan Kategori
8. Urutkan Data Berdasarkan ID (Bubble Sort)
9. Urutkan Data Berdasarkan Nama (Selection Sort)
10. Urutkan Berdasarkan Tiket Terjual
11. Statistik Film
12. Menampilkan Film Akan Tayang
13. Update Status Film
14. Counter Film Berdasarkan Status
15. Simpan Data ke File TXT
16. Load Data dari File TXT

## Persyaratan:

* Java JDK 8 atau versi lebih baru
* Command Prompt / Terminal

## Struktur File:

PemesananTiketBioskop.java
README.txt
datafilm.txt (akan dibuat otomatis setelah proses penyimpanan)

## Cara Compile:

Buka terminal pada folder project lalu jalankan:

javac PemesananTiketBioskop.java

Jika berhasil maka akan terbentuk file:

PemesananTiketBioskop.class
Film.class

## Cara Menjalankan Program:

Jalankan perintah berikut:

java PemesananTiketBioskop

## Menu Program:

==================================================
SISTEM PEMESANAN TIKET BIOSKOP
==============================

1. Tambah Data Film
2. Tampilkan Semua Data
3. Edit Data Film
4. Hapus Data Film
5. Cari Berdasarkan Nama
6. Cari Berdasarkan ID
7. Cari Berdasarkan Kategori
8. Urutkan Berdasarkan ID
9. Urutkan Berdasarkan Nama
10. Urutkan Berdasarkan Tiket Terjual
11. Statistik Film
12. Film Akan Tayang
13. Update Status Film
14. Counter Film
15. Simpan Data ke File
16. Load Data dari File
17. Keluar
    ==================================================

## Penyimpanan Data:

Pilih menu 15 untuk menyimpan data ke file:

datafilm.txt

Format penyimpanan:

ID;Nama Film;Kategori;Status;Tiket Terjual;Tiket Tersedia

Contoh:

1;Avengers Endgame;Action;Sedang Tayang;95;5

## Memuat Data:

Pilih menu 16 untuk memuat kembali data dari file datafilm.txt.

## Catatan:

* Program menggunakan array statis dengan kapasitas maksimum 100 film.
* Penghapusan data menggunakan metode soft delete (status aktif = false).
* Saat program dijalankan pertama kali, sistem otomatis memuat 30 data film contoh.
* File datafilm.txt harus berada pada folder yang sama dengan file program.

## Author:

Nama : Dillan Gustav Alfaro
      Sarah Putri Aqillah
      Imelvi Karnia Zalukhu
      Cep Wildan Yanfa
Mata Kuliah : Algoritma & Struktur Data
Bahasa Pemrograman : Java
