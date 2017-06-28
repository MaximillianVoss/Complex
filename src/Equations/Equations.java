package Equations;

import static java.lang.Math.*;

import Complex.Complex;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Equations {
    //перегрузка метода squareRoot для того чтобы передать массив
    public Complex[] squareRoot(double[] values) throws Exception {
        if (values.length > 2)
            return squareRoot(values[0], values[1], values[2]);
        else
            throw new IllegalArgumentException("Недостатоно аргументов");
        //throw new Exception("Недостатоно аргументов");
    }

    //перегрузка метода bisquareRoot для того чтобы передать массив
    public Complex[] biSquareRoot(double[] values) throws Exception {
        if (values.length > 2)
            return biSquareRoot(values[0], values[1], values[2]);
//            if (values[0] != 0)
//                return biSquareRoot(values[0], values[1], values[2]);
//            else
//                return squareRoot(values[1], 0, values[2]);
        else
            throw new IllegalArgumentException("Недостатоно аргументов");
        //throw new Exception("Недостатоно аргументов");
    }

    public Complex[] squareRoot(double a, double b, double c) throws Exception {
        Complex res[];
        if (a != 0) {
            double d = b * b - 4 * a * c;

            if (d >= 0) {
                double dsqrt = Math.sqrt(Math.abs(d));
                res = new Complex[]{
                        new Complex((-b - dsqrt), 0),
                        new Complex((-b + dsqrt), 0)};
            } else {
                double dsqrt = Math.sqrt(Math.abs(d));
                res = new Complex[]{
                        new Complex(-b, -dsqrt),
                        new Complex(-b, dsqrt)
                };
            }
            for (int i = 0; i < res.length; i++) {
                res[i].y /= 2 * a;
                res[i].x /= 2 * a;
            }
        } else if (b != 0) {
            res = new Complex[]{new Complex(-c / b, 0)};
        } else {
            throw new Exception("Нет решений!");
        }
        return res;
    }

    public Complex[] biSquareRoot(double _a, double _b, double _c) throws Exception {
        Complex result[] = new Complex[4];
        int k = 0;
        Complex roots[];
        if (_a != 0)
            roots = squareRoot(_a, _b, _c);
        else
            return squareRoot(_b, 0, _c);
        for (int i = 0; i < roots.length; i++) {
            if (roots[i].y != 0) {
                double a = roots[i].x, b = roots[i].y;
                double x = sqrt((sqrt(a * a + b * b) + a) / 2),
                        y = b / abs(b) * sqrt((sqrt(a * a + b * b) - a) / 2);
                result[k++] = new Complex(-x, -y);
                result[k++] = new Complex(x, y);
            } else {
                result[k++] = new Complex(roots[i].x).GetRoot(roots[i].x);
                result[k++] = new Complex(roots[i].x).GetRoot(roots[i].x).invert();
            }
        }
        return result;
    }
}


