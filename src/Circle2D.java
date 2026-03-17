public class Circle2D {
    private String name;
    private double centerY;
    private double centerX;
    private double radius;

    public Circle2D(String name, double centerY, double centerX, double radius) {
        this.name = name;
        this(centerY, centerX, radius);
    }

    public Circle2D(double centerY, double centerX, double radius) {
        this.name = "";
        this.centerY = centerY;
        this.centerX = centerX;
        this.radius = radius;
    }

    public double getArea(){
        return Math.PI * radius * radius;
    }

    public double getPerimeter(){
        return 2 * radius * Math.PI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCenterY() {
        return centerY;
    }

    public void setCenterY(double centerY) {
        this.centerY = centerY;
    }

    public double getCenterX() {
        return centerX;
    }

    public void setCenterX(double centerX) {
        this.centerX = centerX;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle2D{" +
                "name='" + name + '\'' +
                ", centerY=" + centerY +
                ", centerX=" + centerX +
                ", radius=" + radius +
                '}';
    }

    public static double centerDistance(Circle2D x1, Circle2D x2){
        return Math.sqrt(Math.pow(x1.centerX - x2.centerX, 2) + Math.pow(x1.centerY - x2.centerY, 2));
    }

    public boolean isIntersecting(Circle2D x2){
        return Circle2D.centerDistance(this, x2) < this.radius + x2.radius;
    }

    public boolean isInside(Circle2D x2){
        return Circle2D.centerDistance(this, x2) <= this.radius - x2.radius;
    }

    public boolean isTouching(Circle2D x2){
        return Circle2D.centerDistance(this, x2) == this.radius + x2.radius;
    }

    static void main() {
        Circle2D circle1 = new Circle2D(0, 0, 1);
        Circle2D circle2 = new Circle2D(1, 0, 1);

        System.out.println(circle1.toString());
        System.out.println(circle1.getArea());

        System.out.println(Circle2D.centerDistance(circle1, circle2));
        System.out.println(circle1.isTouching(circle2));
    }
}
