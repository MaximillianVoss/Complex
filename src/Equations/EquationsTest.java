package Equations;

import org.junit.Before;
import org.junit.Test;
import Complex.Complex;
import org.omg.CORBA.Object;

import static org.junit.Assert.*;

/**
 * Created by LaneBoy on 16.05.17.
 */
public class EquationsTest {
    double values[][];
    double values1[][];
    double results[][];
    double results1[][];
    double results2[][];

    @Before
    public void setUp() throws Exception {
        values = new double[][]{
                {0, 2, 3},
                {0, 0, 3},
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {5, 10, -5},
                {1, 7, 6},
                {-1, 65, -90}
        };
        values1 = new double[][]{
                {0, 1, 1},
                {0, 1, -1}
        };
        results = new double[][]{
                {-1.5, 0},
                {},
                {-1.0, -1.41, -1.0, 1.41},
                {-0.63, -1.05, -0.63, 1.05},
                {-0.57, -0.98, -0.57, 0.98},
                {-2.41, 0, 0.41, 0},
                {-6, 0, -1, 0},
                {63.59, 0, 1.42, 0}
        };
        results1 = new double[][]{
                {0, -1.22, 0, 1.22},
                {},
                {-0.6, 1.17, 0.6, -1.17, -0.6, -1.17, 0.6, 1.17},
                {-0.5, 0.96, 0.5, -0.96, -0.5, -0.96, 0.5, 0.96},
                {-0.5, 0.9, 0.5, -0.9, -0.5, -0.9, 0.5, 0.9},
                {0, 1.55, 0, -1.55, 0.64, 0, -0.64, 0},
                {0, 2.45, 0, -2.45, 0, 1, 0, -1},
                {7.97, 0, -7.97, 0, 1.19, 0, -1.19, 0}
        };

        results2 = new double[][]{
                {0, -1, 0, 1},
                {-1, 0, 1, 0}
        };
    }

    @Test
    public void squareRoot() throws Exception {
        Equations eq = new Equations();
        for (int i = 0; i < values.length; i++) {
            try {
                Complex temp[] = eq.squareRoot(values[i]);
                for (int j = 0, k = 0; j < temp.length; j++, k += 2) {
                    org.junit.Assert.assertEquals(results[i][k], temp[j].x, 0.1);
                    org.junit.Assert.assertEquals(results[i][k + 1], temp[j].y, 0.1);
                }
            } catch (Exception ex) {
                org.junit.Assert.assertEquals(ex.getMessage(), "Нет решений!");
            }
        }
    }


    @Test
    public void biSquareRoot1() throws Exception {
        Equations eq = new Equations();
        for (int i = 0; i < 1; i++) {
            try {
                Complex temp[] = eq.biSquareRoot(values[i]);

                for (int j = 0, k = 0; j < temp.length / 2; j++, k += 2) {
                    org.junit.Assert.assertEquals(results1[i][k], temp[j].x, 0.1);
                    org.junit.Assert.assertEquals(results1[i][k + 1], temp[j].y, 0.1);
                }
            } catch (Exception ex) {
                org.junit.Assert.assertEquals(ex.getMessage(), "Нет решений!");
            }
        }
    }

    @Test
    public void biSquareRoot2() throws Exception {
        Equations eq = new Equations();
        for (int i = 1; i < results1.length; i++) {
            try {
                Complex temp[] = eq.biSquareRoot(values[i]);

                for (int j = 0, k = 0; j < temp.length; j++, k += 2) {
                    org.junit.Assert.assertEquals(results1[i][k], temp[j].x, 0.1);
                    org.junit.Assert.assertEquals(results1[i][k + 1], temp[j].y, 0.1);
                }
            } catch (Exception ex) {
                org.junit.Assert.assertEquals(ex.getMessage(), "Нет решений!");
            }
        }
    }

    @Test
    //тест на вырожденные биквадратные уравнения в квадратные
    public void biSquareRoot3() throws Exception {
        Equations eq = new Equations();
        for (int i = 0; i < results2.length; i++) {
            try {
                Complex temp[] = eq.biSquareRoot(values1[i]);
                org.junit.Assert.assertEquals(results2[i][0], temp[0].x, 0.1);
                org.junit.Assert.assertEquals(results2[i][1], temp[0].y, 0.1);
                org.junit.Assert.assertEquals(results2[i][2], temp[1].x, 0.1);
                org.junit.Assert.assertEquals(results2[i][3], temp[1].y, 0.1);
            } catch (Exception ex) {
                org.junit.Assert.assertEquals(ex.getMessage(), "Нет решений!");
            }
        }

    }

}