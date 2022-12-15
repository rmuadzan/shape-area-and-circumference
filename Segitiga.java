public abstract class Segitiga implements BangunDatar {
    protected double alas;
    protected double tinggi;

    public void setAlas(double alas) {
        this.alas = alas;
    }

    public double getAlas() {
        return alas;
    }

    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;
    }

    public double getTinggi() {
        return tinggi;
    }

    public double luas() {
        return 0.5 * alas * tinggi;
    }

}
