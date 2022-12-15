public class Persegi implements BangunDatar {
    private double sisi;

    public void setSisi(double sisi) {
        this.sisi = sisi;
    }

    public double getSisi() {
        return sisi;
    }

    public double luas() {
        return sisi * sisi;
    }

    public double keliling() {
        return 4 * sisi;
    }
}
