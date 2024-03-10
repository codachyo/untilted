package lesson_8.shape;

import java.util.Random;

class ShapeUtil {
    Random random = new Random();

    Circle createRandomCircle() {
        return new Circle("circle", random.nextDouble());
    }

    Square createRandomSquare() {
        return new Square("square", random.nextDouble());
    }

    Rectangle createRandomRectangle() {
        return new Rectangle("rectangle", random.nextDouble(), random.nextDouble());
    }

    Triangle createRandomTriangle() {
        return new Triangle("triangle", random.nextDouble());
    }

    Shape createRandomShape() {
        int randomNumber = random.nextInt(4);
        if (randomNumber == 0) {
            return createRandomCircle();
        } else if (randomNumber == 1) {
            return createRandomSquare();
        } else if (randomNumber == 2) {
            return createRandomRectangle();
        } else {
            return createRandomTriangle();
        }
    }

    double calculateArea(Shape[] shapes) {
        double result = 0;
        for (Shape shape : shapes) {
            result += shape.calculateArea();
        }
        return result;
    }

    double calculatePerimeter(Shape[] shapes) {
        double result = 0;
        for (Shape shape : shapes) {
            result += shape.calculatePerimeter();
        }
        return result;
    }

    double calculateArea(Shape shape) {
        return shape.calculateArea();
    }

    double calculatePerimeter(Shape shape) {
        return shape.calculatePerimeter();
    }
}
