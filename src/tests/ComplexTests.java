package tests;

import demo.parallel.Complex;
import junit.framework.TestCase;
import org.junit.Test;
public class ComplexTests extends TestCase {
    @Test
    public static void testIsEqual() {
        String msg = "Equal operation - error";
        Complex a = new Complex(2.7, 6);
        Complex b = new Complex(2.7, 6);
        assertTrue(msg, a.isEqual(b));
    }
    @Test
    public static void testDivides() {
        String msg = "Divide operation - error";
        Complex c = new Complex(2.7, 6);
        Complex d = new Complex(5, 8);
        c.divides(d);

        Complex a = new Complex(2.7, 6);
        Complex b = new Complex(5, 8);
        double real = (a.getRe() * b.getRe() + a.getIm() * b.getIm())/(b.getRe()*b.getRe() + b.getIm()*b.getIm());
        double imag = (b.getRe()*a.getIm() - b.getIm()*a.getRe())/(b.getRe()*b.getRe() + b.getIm()*b.getIm());
        assertTrue(msg, c.isEqual(new Complex(real, imag)));
    }
    @Test
    public static void testDividesNull() {
        String msg = "Divide operation - error";
        Complex b = new Complex(5, 8);
        assertTrue(msg, b.getRe()*b.getRe() + b.getIm()*b.getIm() != 0);
    }
    @Test
    public static void testCos() {
        String msg = "Cos operation - error";
        Complex a = new Complex(2.7, 6);
        Complex b = a.cos();
        assertTrue(msg, b.isEqual(new Complex(Math.cos(a.getRe()) * Math.cosh(a.getIm()), -Math.sin(a.getRe()) * Math.sinh(a.getIm()))));
    }
}
