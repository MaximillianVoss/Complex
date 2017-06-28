package Complex;

import static java.lang.Math.*;

public class Complex {
    public double x;
    public double y;

    //заполнение х и у
    public Complex(double _x, double _y) {
        x = Correсt(_x);
        y = Correсt(_y);
    }

    //заполнение комлексного числа как действительного
    public Complex(double _x) {
        x = Correсt(_x);
        y = 0;
    }

    private double Correсt(double value) {
        if (value == -0)
            return 0;
        else
            return value;
    }

    public Complex GetRoot(double _x) {
        if (_x >= 0) {
            x = sqrt(_x);
            y = 0;
        } else {
            x = 0;
            y = sqrt(-_x);
        }
        return new Complex(x,y);
    }

    //инвертируем знаки
    public Complex invert() {
        if (x != 0)
            x = -x;
        if (y != 0)
            y = -y;
        return this;
    }

    public Complex sum(Complex c) {
        return new Complex(x + c.x, y + c.y);
    }

    public Complex minus(Complex c) {
        return new Complex(x - c.x, y - c.y);
    }

    public Complex mult(Complex c) {
        return new Complex(x * c.x - y * c.y, y * c.x + x * c.y);
    }

    public Complex div(Complex c) throws Exception {
        if ((c.x != 0) && (c.y != 0))
            return new Complex((x * c.x + y * c.y) / (c.x * c.x + c.y * c.y), (y * c.x - x * c.y) / (c.x * c.x + c.y * c.y));
        throw new IllegalArgumentException("Аргумент х<=0");
        //throw new Exception("Знаменатель равен 0");
    }

    public Double abs() {
        return sqrt(x * x + y * y);
    }

    public Complex cont() {
        return new Complex(x, -y);
    }

    public Double arg() throws Exception {
        if (x > 0) return atan(y / x);
        throw new IllegalArgumentException("Аргумент х<=0");
        //throw new Exception("Аргумент х<=0");

    }


}

