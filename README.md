# Simple Java Port Scanner

---
Project by : **Ken Aryo B - 202310370311006**

## Deskripsi Proyek
Proyek ini adalah **Simple Java Port Scanner** yang memungkinkan pengguna untuk memindai port terbuka di sebuah alamat IP tertentu. Aplikasi ini memiliki dua opsi utama:
1. Memindai rentang port tertentu.
2. Memindai satu port spesifik.

Proyek ini dibuat dengan bahasa **Java** dan telah di-refactor untuk meningkatkan modularitas, performa, dan keterbacaan kode. Setelah refactoring, aplikasi terbagi menjadi beberapa komponen untuk pemisahan tanggung jawab dan kemudahan perawatan.

## Fitur
- **Pemindaian Port Tunggal**: Memeriksa status satu port di alamat IP tertentu.
- **Pemindaian Rentang Port**: Memindai beberapa port secara paralel untuk meningkatkan kecepatan dan efisiensi.
- **Handling Error yang Lebih Baik**: Menampilkan pesan yang informatif jika terjadi kesalahan dalam pemindaian.
- **Log Modular**: Log status setiap port yang di-scan.

## Teknologi yang Digunakan
- **Java SE** (JDK 8 atau lebih baru)
- **Threading** (menggunakan ExecutorService untuk pemindaian paralel)

## Struktur Proyek
- **SimplePortScanner.java**: Kelas utama yang menangani input pengguna dan menjalankan program.
- **PortScanner.java**: Kelas yang berisi logika utama pemindaian port.
- **Logger.java**: Kelas utilitas untuk menampilkan log ke konsol.

## Petunjuk Menjalankan Proyek

### Persyaratan
- **Java Development Kit (JDK)** versi 8 atau lebih baru.

### Langkah Menjalankan
1. **Clone** repositori atau unduh proyek ini.
2. Buka terminal dan navigasikan ke direktori proyek.
3. **Kompilasi** program dengan perintah berikut:
   ```bash
   javac SimplePortScanner.java
   ```
4. **Jalankan** program dengan perintah berikut:
   ```bash
   java SimplePortScanner
   ```
   atau jika anda menggunakan intellij IDEA anda juga bisa jalankan / run dengan menekan tombol run yang ada di pojok kanan atas

### Instruksi Penggunaan
Setelah menjalankan program, Anda akan diminta untuk memilih opsi pemindaian:
1. **Opsi 1**: Untuk memindai rentang port tertentu, masukkan alamat IP yang ingin di-scan, lalu masukkan nomor port awal dan port akhir.
2. **Opsi 2**: Untuk memindai port spesifik, masukkan alamat IP dan nomor port yang ingin di-scan.

### Contoh Penggunaan
```plaintext
Port Scanner Menu:
1. Scan range of ports
2. Scan a specific port
Choose an option: 1

Enter IP address to scan: 192.168.1.1
Enter start port: 20
Enter end port: 25
```

## Refactoring yang Dilakukan
Berikut adalah refactoring yang telah dilakukan pada proyek ini:
1. **Pemisahan Kelas Scanner**: Memindahkan logika scanning ke dalam kelas `PortScanner` agar lebih modular.
2. **Pemecahan Menu dan Logika Utama**: Memisahkan menu dan logika utama ke metode `displayMenu` dan `handleUserChoice` untuk mempermudah perawatan.
3. **Penambahan Threading**: Menggunakan `ExecutorService` untuk menjalankan pemindaian port secara paralel dan meningkatkan performa.
4. **Handling Error yang Lebih Baik**: Menambahkan `Exception` handling pada pemindaian port.
5. **Log Modular**: Memisahkan log status ke kelas `Logger` untuk mempermudah perubahan atau peningkatan fitur logging.

## Catatan Penting
- Pastikan Anda memiliki akses jaringan ke alamat IP yang akan dipindai.
- Waktu pemindaian dapat bervariasi tergantung pada rentang port dan respons dari IP yang dituju.
- Port scanner ini adalah alat sederhana dan tidak mendukung pemindaian tingkat lanjut. Gunakan dengan bertanggung jawab.

---

by : **Ken Aryo B - 202310370311006**