public class Lingkaran implements BangunDatar {
    public static final double PI = 3.14;
    private double radius;

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double luas() {
        return PI * radius * radius;
    }

    public double keliling() {
        return 2 * PI * radius;
    }
}
