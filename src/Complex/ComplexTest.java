package Complex;


import Equations.Equations;

import static java.lang.Math.atan;
import static java.lang.StrictMath.sqrt;
import static org.junit.Assert.*;


public class ComplexTest {
    Complex a,b;
    @org.junit.Before
    public void setUp() throws Exception {
        a = new Complex(0,0);
        b = new Complex(0.3,0.5);
    }

    @org.junit.Test
    public void sum() throws Exception {
        double sum =0;
        for(double i=-100;i<100;i+=0.1) {
            sum+=i;
            a=a.sum(new Complex(i,i));
            assertEquals(a.x,sum,1E-7);
            assertEquals(a.y,sum,1E-7);
        }
    }

    @org.junit.Test
    public void minus() throws Exception {
        for (double i = -100; i < 100; i += 0.1) {
            b = a.minus(new Complex(i, i));
            assertEquals(b.x, -i, 1E-7);
            assertEquals(b.y, -i, 1E-7);
        }
    }
    @org.junit.Test
    public void mult() throws Exception {
        double [] x1 ={1,-4,0,56,-53};
        double [] y1 ={2,-7,0,43,-45};
        double [] x2 ={3,-10,0,87,-67};
        double [] y2 ={4,-5,0,99,-34};
        double [] values1 ={-5,5,0,615,2021};
        double [] values2 ={10,90,0,9285,4817};
        for (int i = 0; i < 5; i++) {
            a = new Complex(x1[i],y1[i]);
            a = a.mult(new Complex(x2[i], y2[i]));
            assertEquals(a.x, values1[i], 1E-7);
            assertEquals(a.y, values2[i], 1E-7);
        }
    }

    @org.junit.Test
    public void div() throws Exception {
        double [] x1 ={13,-2,0,1,23,0};
        double [] y1 ={1,1,8,-2,1,0};
        double [] x2 ={7,1,0,1,7,0};
        double [] y2 ={-6,-1,5,2,1,0};
        double [] values1 ={1,-1.5,1.6,-0.6,3.24};
        double [] values2 ={1,-0.5,0,-0.8,-0.32};
        for (int i = 0; i < 5; i++) {
            a = new Complex(x1[i],y1[i]);
            try {
                a = a.div(new Complex(x2[i], y2[i]));
                assertEquals(a.x, values1[i], 1E-7);
                assertEquals(a.y, values2[i], 1E-7);
            }
            catch(Exception ex)
            {
                org.junit.Assert.assertEquals(ex.getMessage(),"Знаменатель равен 0");
            }
        }
    }

    @org.junit.Test
    public void abs() throws Exception {
        for (double i = -100; i < 100; i += 0.1) {
            a= new Complex(i,i);
            assertEquals(a.abs(), sqrt(2*i*i), 1E-7);
        }
    }

    @org.junit.Test
    public void cont() throws Exception {
        for (double i = -100; i < 100; i += 0.1) {
            a= new Complex(i,i);
            a = a.cont();
            assertEquals(a.x, i, 1E-7);
            assertEquals(a.y, -i, 1E-7);
        }
    }

    @org.junit.Test
    public void arg() throws Exception {
        for (double i = -100; i < 100; i += 0.1) {
            a = new Complex(i,i);
            try {
                assertEquals(a.arg(), atan(i / i), 1E-7);
            }
            catch(Exception ex)
            {
                org.junit.Assert.assertEquals(ex.getMessage(),"Аргумент х<=0");
            }
        }
    }
    @org.junit.Test
    public void squareRoot() throws Exception {
        double values1[] = {1, 1, 20};
        double values2[] = {1, 1, -20};
        Equations eq =new Equations();
        Complex res1[]=eq.squareRoot(values1[0], values1[1], values1[2]);
        Complex res2[]=eq.squareRoot(values2[0], values2[1], values2[2]);


    }

}