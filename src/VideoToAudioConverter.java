void main() {

    String inputFilePath = "C:\\Users\\ASUS\\Videos\\Captures\\grafkom tnaggl 25 april.mp4";
    String outputFilePath = "D:\\si\\test.mp3";


    File inputFile = new File(inputFilePath);
    if (!inputFile.exists()) {
        IO.println("Error: File video input tidak ditemukan di: " + inputFilePath);
        return;
    }

    extractAudio(inputFilePath, outputFilePath);
}

public static void extractAudio(String input, String output) {
    ProcessBuilder processBuilder = new ProcessBuilder(
            "D:\\ffmel\\ffmpeg-8.0.1-essentials_build\\bin\\ffmpeg.exe",
            "-y",
            "-i", input,
            "-vn",
            "-c:a", "libmp3lame",
            "-b:a", "128k",
            output
    );

    processBuilder.redirectErrorStream(true);

    try {
        IO.println("Memulai ekstraksi audio. Mohon tunggu...");
        Process process = processBuilder.start();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String[] spinner = {"|", "/", "-", "\\"};
            int i = 0;

            while (reader.readLine() != null) {
                IO.print("\rMengekstrak Audio... " + spinner[i % spinner.length]);
                i++;
            }
            IO.println();
        }
        int exitCode = process.waitFor();
        if (exitCode == 0) {
            IO.println("Berhasil! Audio telah diekstrak dari video.");
        } else {
            IO.println("Gagal. Terjadi kesalahan dengan kode exit: " + exitCode);
        }

    } catch (IOException | InterruptedException e) {
        IO.println("Error saat menjalankan proses ekstraksi: " + e.getMessage());
        Thread.currentThread().interrupt();
    }
}