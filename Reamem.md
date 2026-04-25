# 🎵 Video to Audio Extractor (Java + FFmpeg)

Program Java untuk mengekstrak audio (MP3) dari file video menggunakan FFmpeg.

---

## 📋 Persyaratan

Sebelum menjalankan program ini di laptop lain, pastikan sudah terinstall:

1. **Java JDK** (versi 8 ke atas)
    - Download: https://www.oracle.com/java/technologies/downloads/
    - Cek dengan: `java -version`

2. **FFmpeg**
    - Download: https://ffmpeg.org/download.html (pilih Windows builds)
    - Ekstrak ke folder mana saja, misalnya `C:\ffmpeg\`

---

## ⚙️ Cara Setup di Laptop Lain

### Langkah 1 — Install FFmpeg

1. Download FFmpeg dari https://www.gyan.dev/ffmpeg/builds/ (pilih `ffmpeg-release-essentials.zip`)
2. Ekstrak zip tersebut, misalnya ke `C:\ffmpeg\`
3. Pastikan path ke `ffmpeg.exe` ada, contoh:
   ```
   C:\ffmpeg\bin\ffmpeg.exe
   ```

### Langkah 2 — Sesuaikan Path di Kode

Buka file Java, lalu ubah **3 bagian** berikut sesuai kondisi laptop kamu:

```java
// 1. Path file video INPUT (file yang ingin diekstrak audionya)
String inputFilePath = "C:\\Users\\ASUS\\Videos\\Captures\\grafkom tnaggl 25 april.mp4";
//                      ↑ Ganti dengan path video di laptop kamu

// 2. Path file audio OUTPUT (hasil ekstraksi akan disimpan di sini)
String outputFilePath = "D:\\si\\test.mp3";
//                       ↑ Ganti dengan folder tujuan di laptop kamu

// 3. Path ffmpeg.exe
"D:\\ffmel\\ffmpeg-8.0.1-essentials_build\\bin\\ffmpeg.exe",
// ↑ Ganti dengan lokasi ffmpeg.exe yang sudah kamu install
```

> ⚠️ **Penting:** Gunakan double backslash `\\` untuk pemisah path di Windows, atau gunakan forward slash `/`.

### Langkah 3 — Compile dan Jalankan

Buka terminal / command prompt di folder project, lalu:

```bash
# Compile
javac NamaFileKamu.java

# Jalankan
java NamaFileKamu
```

---

## 📁 Contoh Konfigurasi

| Laptop Asal (contoh lama) | Laptop Baru (contoh baru) |
|---|---|
| `D:\ffmel\...\ffmpeg.exe` | `C:\ffmpeg\bin\ffmpeg.exe` |
| `C:\Users\ASUS\Videos\input.mp4` | `C:\Users\Budi\Downloads\video.mp4` |
| `D:\si\test.mp3` | `C:\Users\Budi\Desktop\hasil.mp3` |

---

## 🔍 Troubleshooting

| Masalah | Solusi |
|---|---|
| `Error: File video input tidak ditemukan` | Periksa kembali path video input, pastikan file ada |
| `Gagal. Terjadi kesalahan dengan kode exit: 1` | Periksa path `ffmpeg.exe`, pastikan sudah benar |
| `Error saat menjalankan proses ekstraksi` | Pastikan FFmpeg sudah terinstall dan path-nya sesuai |
| Tidak ada output MP3 | Pastikan folder tujuan output sudah ada sebelumnya |

---

## 📝 Catatan Tambahan

- Format output yang dihasilkan: **MP3** dengan bitrate **128kbps**
- Jika folder output belum ada, buat dulu secara manual sebelum menjalankan program
- Program akan menampilkan spinner animasi selama proses ekstraksi berlangsung
- Jika ada video lain yang ingin diekstrak, cukup ganti nilai `inputFilePath` dan `outputFilePath`