package latihanp1;

import java.util.Scanner;
import java.util.Locale;

/**
 *
 * @author Hadi
 */
public class LatihanP1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        
        // Array untuk menyimpan data
        String[] nim = new String[100];
        String[] nama = new String[100];
        double[] nilaiUts = new double[100];
        double[] nilaiUas = new double[100];
        double[] nilaiAkhir = new double[100];
        char[] grade = new char[100];
        
        int jumlahData = 0;
        int pilihan = 0;

        do {
            try {
                System.out.println("\n===== MENU UTAMA =====");
                System.out.println("1. Masukkan Data");
                System.out.println("2. Tampilkan Semua Data");
                System.out.println("3. Selesai / Keluar");
                System.out.print("Pilihan Anda: ");
                
                String inputMenu = input.nextLine();
                pilihan = Integer.parseInt(inputMenu);

                if (pilihan == 1) {
                    // Hanya proses input di sini
                    System.out.println("\n--- Input Data Ke-" + (jumlahData + 1) + " ---");
                    System.out.print("NIM  : "); nim[jumlahData] = input.nextLine();
                    System.out.print("Nama : "); nama[jumlahData] = input.nextLine();
                    System.out.print("UTS  : "); nilaiUts[jumlahData] = Double.parseDouble(input.nextLine());
                    System.out.print("UAS  : "); nilaiUas[jumlahData] = Double.parseDouble(input.nextLine());

                    // Hitung nilai akhir & grade
                    nilaiAkhir[jumlahData] = (nilaiUts[jumlahData] * 0.4) + (nilaiUas[jumlahData] * 0.6);
                    if (nilaiAkhir[jumlahData] >= 80) grade[jumlahData] = 'A';
                    else if (nilaiAkhir[jumlahData] >= 70) grade[jumlahData] = 'B';
                    else if (nilaiAkhir[jumlahData] >= 60) grade[jumlahData] = 'C';
                    else if (nilaiAkhir[jumlahData] >= 50) grade[jumlahData] = 'D';
                    else grade[jumlahData] = 'E';

                    jumlahData++;
                    System.out.println(">>> Data sudah tersimpan. Silahkan pilih menu 2 untuk melihatnya.");

                } else if (pilihan == 2) {
                    // Hanya tampilkan data jika user ketik 2
                    if (jumlahData == 0) {
                        System.out.println("\n[!] Belum ada data. Isi dulu di menu 1.");
                    } else {
                        System.out.println("\n=========================================================================");
                        System.out.printf("%-5s %-15s %-20s %-8s %-8s %-8s %-5s\n", "No", "NIM", "Nama", "UTS", "UAS", "Akhir", "Grade");
                        System.out.println("-------------------------------------------------------------------------");
                        for (int i = 0; i < jumlahData; i++) {
                            System.out.printf("%-5d %-15s %-20s %-8.2f %-8.2f %-8.2f %-5c\n", 
                                              (i + 1), nim[i], nama[i], nilaiUts[i], nilaiUas[i], nilaiAkhir[i], grade[i]);
                        }
                        System.out.println("=========================================================================");
                        System.out.println("Tekan ENTER untuk kembali ke menu...");
                        input.nextLine(); // Jeda agar user bisa baca tabel
                    }

                } else if (pilihan == 3) {
                    System.out.println("Program Berakhir.");
                } else {
                    System.out.println("Pilihan salah!");
                }
            } catch (Exception e) {
                System.out.println("Error: Input tidak valid.");
            }
        } while (pilihan != 3);
    }
}
