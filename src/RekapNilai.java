import java.util.Scanner;

public class RekapNilai {

    static final int SELESAI = -1;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double total = 0;
        int jumlah = 0;
        int nilai;

        System.out.println("===== REKAP NILAI KELAS =====");
        System.out.println("Ketik -1 kalau sudah selesai.");

        //do-while dipakai karena nilai pertama yang harus diminta dulu sebelum bisa di cek -1
        do {
            System.out.print("Nilai ke-" + (jumlah + 1) + " : ");
            nilai = input.nextInt();

            if (nilai == SELESAI) {
                continue;
            }

            if (nilai < 0 || nilai > 100) {
                System.out.println("Input Nilai harus 0 - 100 !");
                continue;
            }

            char grade;
            if (nilai >= 90) grade = 'A';
            else if (nilai >= 80) grade = 'B';
            else if (nilai >= 70) grade = 'C';
            else if (nilai >= 60) grade = 'D';
            else grade = 'E';

            //Jika urutannya dibalik 60 menjadi diatas maka yang terjadi adalah semua nilai yang diatas 60 akan berubah menjadi grade D.
            //nilai 85 menjadi D (kurang), padahal seharusnya grade B (baik).
            // ===== REKAP NILAI KELAS =====
            //Ketik -1 kalau sudah selesai.
            //Nilai ke-1 : 85
            // Grade D — Kurang
            //Nilai ke-2 : 60
            // Grade D — Kurang

            String keterangan = switch (grade) {
                case 'A' -> "Sangat Baik";
                case 'B' -> "Baik";
                case 'C' -> "Cukup";
                case 'D' -> "Kurang";
                default -> "Tidak Lulus";
            };
            System.out.println(" Grade " + grade + " — " + keterangan);

            total += nilai;
            jumlah++;

        } while (nilai != SELESAI);

        System.out.println();
        System.out.println("Nilai sah   : " + jumlah);

        if (jumlah == 0) {
            System.out.println("Tidak ada nilai sah.");
        } else {
            double rata = total / jumlah;
            String status = rata >= 60 ? "LULUS" : "TIDAK LULUS";
            System.out.println("Rata-rata   : " + String.format("%.2f", rata));
            System.out.println("Status      : " + status);
        }
    }
}
