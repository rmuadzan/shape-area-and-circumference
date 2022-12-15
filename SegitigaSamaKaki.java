public class SegitigaSamaKaki extends Segitiga {
    private double sisiKaki;

    public void setSisiKaki(double sisiKaki) {
        this.sisiKaki = sisiKaki;
    }

    public double getSisiKaki() {
        return sisiKaki;
    }

    public double keliling() {
        return 2 * sisiKaki + alas;
    }
}
