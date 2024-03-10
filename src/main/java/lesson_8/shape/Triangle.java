package lesson_8.shape;

class Triangle extends Shape {
    private double side;

    public Triangle(String title, double side) {
        super(title);
        this.side = side;
    }

    @Override
    double calculateArea() {
        return Math.sqrt(3) * side * side / 4;
    }

    @Override
    double calculatePerimeter() {
        return 3 * side;
    }
}
