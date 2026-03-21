import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        Shape shape = new Shape("blue", true);
//        System.out.println(shape.toString());

        Shape circle = new Circle(3, "black", true);
        System.out.println(((Circle) circle).getRadius());

        Shape rect = new Rectangle(12, 8);
        System.out.println(((Rectangle) rect).getLength());
        System.out.println(((Rectangle) rect).getWidth());

        Shape sqr = new Square(12);


        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(circle);
        shapes.add(rect);
        shapes.add(sqr);

        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                Circle c = (Circle) shape;
                System.out.println(c.toString());
            } else if (shape instanceof Rectangle) {
                Rectangle r = (Rectangle) shape;
                System.out.println(r.toString());
            } else {
                Square s = (Square) shape;
                System.out.println(s.toString());
            }
        }

        double sum = 0;

        for (Shape shape : shapes) {
            sum += shape.getArea();
        }
        System.out.println("Total area: " + sum);

        Shape largest = shapes.get(0);
        double largestPerimeter = 0;

        for (Shape shape : shapes) {
            double perimeter = 0;
            if (shape instanceof Circle) {
                perimeter = ((Circle) shape).getPerimeter();
            } else if (shape instanceof Square) {
                perimeter = ((Square) shape).getPerimeter();
            } else if (shape instanceof Rectangle) {
                perimeter = ((Rectangle) shape).getPerimeter();
            }
            if (perimeter > largestPerimeter) {
                largestPerimeter = perimeter;
                largest = shape;
            }
        }
        System.out.println("Largest perimeter: " + largest);

        double side = 0;
        for (Shape shape : shapes) {
            if (shape instanceof Square) {
                side = ((Square) shape).getSide();
            }
        }
        System.out.println(side);
    }



}
