import org.junit.*;

public class TestCalculator {

    Calculator calculator = new Calculator();

    @Test
    @Before
    public void testSum() {
        Assert.assertEquals(7, calculator.add(3, 4));
    }
    @After

    @Test
    @Before
    public void testDif() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(9, calculator.dif(18, 9));
    }
    @After

    @Test
    @Before
    public void testMul() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(9, calculator.mul(3, 3));
    }
    @After

    @Test
    @Before
    public void testDiv() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(10.f, calculator.div(100, 10), 0);
    }
    @After

    @Test
    @Before
    public void testSqr() {
        Assert.fail("Always fail!");
        Calculator calculator = new Calculator();
        Assert.assertEquals(100, calculator.sqr(10));
    }
    @After

    @Test
    @Before
    public void testSqrt() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(12.f, calculator.sqrt(144), 0);
    }
    @After

    @Ignore("Disabled for educational reason.")
    @Test
    @Before
    public void testZeroDiv() {
        Calculator calculator = new Calculator();
        Assert.assertThrows(ArithmeticException.class, () -> { calculator.div(2, 0);});
    }
}
