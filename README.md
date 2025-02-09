# Sistem Kehadiran Siswa dan Umpan Balik Guru

Selamat datang di Sistem Kehadiran Siswa dan Umpan Balik Guru! Aplikasi ini dikembangkan menggunakan Java, JavaFX, dan JDBC, serta menggunakan MySQL untuk database. Sistem ini memungkinkan pengelolaan kehadiran siswa dan pengumpulan umpan balik guru secara efisien.

## Fitur

1. **Manajemen Kehadiran Siswa**:
   - Menandai kehadiran siswa.
   - Melihat catatan kehadiran.
   - Menghasilkan laporan kehadiran.

2. **Sistem Umpan Balik Guru**:
   - Mengirimkan umpan balik untuk siswa.
   - Melihat riwayat umpan balik.
   - Menghasilkan laporan umpan balik.

## Prasyarat

Sebelum memulai, pastikan Anda telah menginstal:

- Java Development Kit (JDK) 8 atau lebih tinggi
- MySQL Server
- MySQL Connector/J (JDBC Driver)
- IDE seperti IntelliJ IDEA, Eclipse, atau NetBeans (opsional tapi direkomendasikan)

## Memulai

### Menyiapkan Database

1. **Instal MySQL**: Unduh dan instal MySQL dari situs web resmi.
2. **Buat Database dan Tabel**:
   - Buka MySQL Workbench atau klien MySQL lainnya.
   - Buat database baru dan tabel untuk siswa, kehadiran, dan umpan balik.

### Mengkonfigurasi Aplikasi

1. **Klon Repositori**:
   ```bash
   git clone https://github.com/idiarso4/student-attendance.git
   cd student-attendance
   ``

2. **Konfigurasi Koneksi Database**:
   - Perbarui pengaturan koneksi database di file `dbconfig.properties` dengan kredensial MySQL dan detail database Anda.

### Menjalankan Aplikasi

1. **Build dan Jalankan**:
   - Buka proyek di IDE Anda.
   - Build dan jalankan aplikasi.

2. **Menggunakan Aplikasi**:
   - Navigasi melalui UI untuk mengelola kehadiran siswa dan mengirimkan umpan balik guru.

## Berkontribusi

Kontribusi sangat diterima! Silakan ikuti langkah-langkah berikut:

1. Fork repositori.
2. Buat branch baru (`git checkout -b feature-branch`).
3. Lakukan perubahan Anda.
4. Commit perubahan Anda (`git commit -m 'Menambah fitur baru'`).
5. Push ke branch (`git push origin feature-branch`).
6. Buka pull request.

## Lisensi

Proyek ini dilisensikan di bawah Lisensi MIT - lihat file [LICENSE](LICENSE) untuk detail.

## Kontak

Jika Anda memiliki pertanyaan atau saran, jangan ragu untuk menghubungi pengelola proyek.

Terima kasih telah menggunakan Sistem Kehadiran Siswa dan Umpan Balik Guru!

ket 1
=========

Struktur pom.xml
Group ID dan Artifact ID:
groupId: com.example
artifactId: javafx0
Ini mendefinisikan identitas unik untuk proyek Anda.
Dependencies:
Anda telah menambahkan beberapa dependensi penting, termasuk:
mysql-connector-java untuk koneksi ke database MySQL.
javafx-controls, javafx-fxml, dll., untuk pengembangan aplikasi JavaFX.
junit untuk pengujian unit.
Build Plugins:
Anda menggunakan maven-compiler-plugin untuk mengatur versi Java yang digunakan.
javafx-maven-plugin untuk menjalankan aplikasi JavaFX.
Langkah Selanjutnya
Periksa Versi Plugin:
Pastikan semua versi plugin dan dependensi sesuai dengan yang Anda butuhkan.
Jalankan Proyek:
Setelah memastikan semua konfigurasi benar, Anda bisa menjalankan proyek dengan perintah:
bash
CopyInsert in Terminal
mvn clean javafx:run
Debugging:
Jika Anda mengalami masalah saat menjalankan proyek, Anda bisa menjalankan Maven dengan opsi debug:
bash
CopyInsert in Terminal
mvn clean javafx:run -X
Jika Anda ingin menambahkan atau