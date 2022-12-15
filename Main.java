import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

interface DoubleScanner {
    double input(String prompt);
}

interface WriteFile {
    void write(String namaFile, String data);
}

interface ReadFile {
    void read(String namaFile);
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        DoubleScanner sDoubleScanner = (prompt) -> {
            int num = 0;
            while (true) {
                try {
                    System.out.print(prompt);
                    num = input.nextInt();
                    input.nextLine();
                    break;
                } catch (Exception e) {
                    System.out.println("Input harus angka!");
                    input.nextLine();
                }
            }
            return num;
        };

        WriteFile wFile = (namaFile, data) -> {
            try {
                FileWriter writer = new FileWriter(namaFile, true);
                String result = String.format("---\n%s", data);
                writer.write(result);
                writer.close();
            } catch (IOException e) {
                System.out.println("Sistem erorr! Mohon kembali lagi nanti");
            }
        };

        ReadFile rFile = (namaFile) -> {
            try {
                File file = new File(namaFile);
                Scanner fileReader = new Scanner(file);
                int i = 1;
                System.out.println("\nRIWAYAT PERHITUNGAN : ");
                while (fileReader.hasNextLine()) {
                    String data = fileReader.nextLine();
                    if (data.contains("---")) {
                        System.out.printf("\n%d.", i);
                        i++;
                    } else {
                        System.out.printf("\t%s\n", data);
                    }
                } 
                fileReader.close();
            } catch (IOException e) {
                System.out.println("error");
            }

        };

        menu:
        while (true) {
            System.out.println("\n===============================================");
            System.out.println("\nDaftar Menu");
            System.out.println("1. Persegi");
            System.out.println("2. Lingkaran");
            System.out.println("3. Segitiga");
            System.out.println("4. Keluar");
            int choice = (int)sDoubleScanner.input("Masukkan pilihan (1..4) : ");
            System.out.println("\n===============================================");

            switch (choice) {
                case 1:
                    Persegi persegi1 = new Persegi();   
                    System.out.println("\nPERSEGI\n");
                    double sisi = sDoubleScanner.input("Masukkan sisi persegi = ");
                    persegi1.setSisi(sisi);

                    String dataPersegi = String.format("Sisi = %.2f\nLuas = %.2f\nKeliling = %.2f\n", sisi, persegi1.luas(), persegi1.keliling());
                    System.out.println("\nHASIL : \n" + dataPersegi);
                    wFile.write("persegi.txt", dataPersegi);
                    rFile.read("persegi.txt");
                    break;
                case 2:
                    Lingkaran lingkaran1 = new Lingkaran();
                    System.out.println("\nLINGKARAN\n");
                    double radius = sDoubleScanner.input("Masukkan radius lingkaran = ");
                    lingkaran1.setRadius(radius);

                    String dataLingkaran = String.format("Radius = %.2f\nLuas = %.2f\nKeliling = %.2f\n", radius, lingkaran1.luas(), lingkaran1.keliling());
                    System.out.println("\nHASIL : \n" + dataLingkaran);
                    wFile.write("lingkaran.txt", dataLingkaran);
                    rFile.read("lingkaran.txt");
                    break;
                case 3:
                    System.out.println("\nSEGITIGA");
                    System.out.println("\nPilihan segittiga : ");
                    System.out.println("1. Segitiga sama sisi");
                    System.out.println("2. Segitiga sama kaki\n");
                    int pilihanSegitiga = (int)sDoubleScanner.input("Masukkan pilihan segitiga (1..2) = ");

                    switch (pilihanSegitiga) {
                        case 1 :
                            SegitigaSamaSisi segitigaSamaSisi1 = new SegitigaSamaSisi();
                            System.out.println("\n\nSEGITIGA SAMA SISI\n");
                            double alasSSS = sDoubleScanner.input("Masukkan alas segitiga sama sisi = ");
                            segitigaSamaSisi1.setAlas(alasSSS);
                            double tinggiSSS = sDoubleScanner.input("Masukkan tinggi segitiga sama sisi = ");
                            segitigaSamaSisi1.setTinggi(tinggiSSS);

                            String dataSSS = String.format("Alas = %.2f\nTinggi = %.2f\nLuas = %.2f\nKeliling = %.2f\n", alasSSS,tinggiSSS, segitigaSamaSisi1.luas(), segitigaSamaSisi1.keliling());
                            System.out.println("\nHASIL : \n" + dataSSS);
                            wFile.write("segitigasamasisi.txt", dataSSS);
                            rFile.read("segitigasamasisi.txt");
                            break;
                        case 2 :
                            SegitigaSamaKaki segitigaSamaKaki1 = new SegitigaSamaKaki();
                            System.out.println("\n\nSEGITIGA SAMA KAKI\n");
                            double alasSSK = sDoubleScanner.input("Masukkan alas segitiga sama kaki = ");
                            segitigaSamaKaki1.setAlas(alasSSK);
                            double sisiKaki = sDoubleScanner.input("Masukkan sisi kaki segitiga sama kaki = ");
                            segitigaSamaKaki1.setSisiKaki(sisiKaki);
                            double tinggiSSK = sDoubleScanner.input("Masukkan tinggi segitiga sama kaki = ");
                            segitigaSamaKaki1.setTinggi(tinggiSSK);

                            String dataSSK = String.format("Alas = %.2f\nSisi kaki = %.2f\nTinggi = %.2f\nLuas = %.2f\nKeliling = %.2f\n", alasSSK, sisiKaki, tinggiSSK, segitigaSamaKaki1.luas(), segitigaSamaKaki1.keliling());
                            wFile.write("segitigasamakaki.txt", dataSSK);
                            System.out.println("\nHASIL : \n" + dataSSK);
                            rFile.read("segitigasamakaki.txt");
                            break;
                        default :
                            System.out.println("Pilihan segitiga salah!");
                            break;
                    }
                    break;
                case 4:
                    System.out.println("Thanks....");
                    break menu;
                default:
                    System.out.println("\nPilihan salah!");
                    break;
            }
        }

        input.close();
    }
}
