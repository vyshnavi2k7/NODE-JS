//) Create an abstract class named Shape that contains two integers and an empty method named printArea().
// Provide three classes named Rectangle, Triangle, and Circle such that each one of the classes extends the class Shape. 
//Each one of the classes contains only the method printArea() that prints the area of the given shape.


package javalab1;

abstract class Shape {
    int a, b;
       abstract void printArea();
class Rectangle extends Shape {
    Rectangle(int length, int breadth) {
        a = length;
        b = breadth;    }
    void printArea() {
        System.out.println("Area of Rectangle = " + (a * b));   }
}
class Triangle extends Shape {
    Triangle(int base, int height) {
        a = base;
        b = height;
    }
    void printArea() {
        System.out.println("Area of Triangle = " + (0.5 * a * b));   }
}
class Circle extends Shape {
    Circle(int radius) {
        a = radius;    }
    void printArea() {
        System.out.println("Area of Circle = " + (Math.PI * a * a));    }
    }
}
