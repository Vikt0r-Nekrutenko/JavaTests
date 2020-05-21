import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestAutorization {
    WebDriver webDriver;

    public  TestAutorization()
    {
        System.setProperty("webdriver.gecko.driver", "C:/Users/grhin0/IdeaProjects/geckodriver.exe");
        webDriver = new FirefoxDriver();
    }

    @Test
    public void loginTest() {
        // a)	Користувач переходить на http://automationpractice.com
        webDriver.get("http://automationpractice.com");

        // b)	Натискає на кнопку “Sign in” на панелі меню.
        webDriver.findElement(By.className("login")).click();

        // c)	Вводить логін і пароль у відповідні поля та натискає  кнопку “Sign in”.
        webDriver.findElement(By.id("email")).sendKeys("18fi.v.nekrutenko@std.npu.edu.ua");
        webDriver.findElement(By.id("passwd")).sendKeys("nekrutya");
        webDriver.findElement(By.id("SubmitLogin")).click();
    }

    @Test
    public void autorizationTest() {
        // a)	Користувач переходить на http://automationpractice.com
        webDriver.get("http://automationpractice.com");

        // b)	Натискає на кнопку “Sign in” на панелі меню.
        webDriver.findElement(By.className("login")).click();

        // c)	Перевіряє що title “Login - My Store”.
        Assert.assertEquals("Login - My Store", webDriver.getTitle());

        // d)	Вводить логін і пароль у відповідні поля та натискає  кнопку “Sign in”.
        webDriver.findElement(By.id("email")).sendKeys("18fi.v.nekrutenko@std.npu.edu.ua");
        webDriver.findElement(By.id("passwd")).sendKeys("nekrutya");
        webDriver.findElement(By.id("SubmitLogin")).click();

        // e)	Перевіряє що title “My account - My Store”.
        Assert.assertEquals("My account - My Store", webDriver.getTitle());

        // f)	Перевіряє що правильні ім’я та прізвище користувача відображені на панелі меню.
        Assert.assertEquals("viktor nekrutenko", webDriver.findElement(By.className("account")).findElement(By.tagName("span")).getText());
    }

    @Test
    public void invalidEmailFieldTest() {
        // a)	Користувач переходить на http://automationpractice.com
        webDriver.get("http://automationpractice.com");

        // b)	Натискає на кнопку “Sign in” на панелі меню.
        webDriver.findElement(By.className("login")).click();

        // c)   Натискає “Sign in”
        webDriver.findElement(By.id("SubmitLogin")).click();

        // d)   перевірить що при натисканні на кнопку кнопку “Sign in” з порожнім полем «Email address» буде показано повідомлення «An email address required».
        Assert.assertEquals("An email address required.", webDriver.findElement(By.className("alert-danger")).findElement(By.tagName("ol")).findElement(By.tagName("li")).getText());
    }

    @Test
    public void invalidPasswdFieldTest() {
        // a)	Користувач переходить на http://automationpractice.com
        webDriver.get("http://automationpractice.com");

        // b)	Натискає на кнопку “Sign in” на панелі меню.
        webDriver.findElement(By.className("login")).click();

        // d)	Вводить логін у відповідне поля та натискає  кнопку “Sign in”.
        webDriver.findElement(By.id("email")).sendKeys("18fi.v.nekrutenko@std.npu.edu.ua");
        webDriver.findElement(By.id("SubmitLogin")).click();

        // d)   перевірить що при натисканні на кнопку кнопку “Sign in” з порожнім полем «Password» буте показано повідомлення «Password is required».
        Assert.assertEquals("Password is required.", webDriver.findElement(By.className("alert-danger")).findElement(By.tagName("ol")).findElement(By.tagName("li")).getText());
    }

    @Test
    public void  purchaseTest() throws InterruptedException {
        loginTest();

        // d)	Переходить в розділ T-shirts
        WebElement tshirts = webDriver.findElement(By.xpath("//a[contains(@title,'T-shirts')]"));
        String href = tshirts.getAttribute("href");
        webDriver.navigate().to(href);

        // e)	Відкриває товар «Faded Short Sleeve T-shirts»
        WebElement fadedShortSleeve = webDriver.findElement(By.linkText("Faded Short Sleeve T-shirts"));
        href = fadedShortSleeve.getAttribute("href");
        webDriver.navigate().to(href);

        // f)	Додає його в корзину
        webDriver.findElement(By.xpath("//button[contains(@class,'exclusive')]")).click();

        // h)   Відкриває корзину та перевіряє що в корзині знаходиться товар з правильною назвою
        href = webDriver.findElement(By.className("shopping_cart")).findElement(By.tagName("a")).getAttribute("href");
        webDriver.navigate().to(href);

        Assert.assertNotNull(webDriver.findElement(By.linkText("Faded Short Sleeve T-shirts")));

        // g)   Перевіряє ціну товару
        WebElement price = webDriver.findElement(By.id("product_price_1_1_324027")).findElement(By.className("price"));
        Assert.assertEquals("$16.51", price.getText());
        float pri = Float.parseFloat(price.getText().split("\\$")[1]);

        // i.	Виставляє кількість одиниць товару 2 та перевіряє що значення поле TOTAL рівно ціні помноженій на 2.
        href = webDriver.findElement(By.id("cart_quantity_up_1_1_0_324027")).getAttribute("href");
        webDriver.navigate().to(href);

        String totalProductPrice = webDriver.findElement(By.id("total_product_price_1_1_324027")).getText();
        float prT = Float.parseFloat(totalProductPrice.split("\\$")[1]);

        Assert.assertEquals(pri * 2, prT, 0);
    }

    @Test
    public void findTest() {
        loginTest();

        // d)   Вводить у поле пошуку товар «Printed Chiffon Dress»
        WebElement searchField = webDriver.findElement(By.id("search_query_top"));
        searchField.sendKeys("Printed Chiffon Dress");
        searchField.submit();

        // e)   Перевіряє що товар знайдено перевіривши назву
        WebDriverWait wait = new WebDriverWait(webDriver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Printed Chiffon Dress")));

        WebElement printedChiffonDress =  webDriver.findElement(By.linkText("Printed Chiffon Dress"));
        Assert.assertNotNull(printedChiffonDress);

        // f)   Перевіряє що у товару присутня знижка 20%
        WebElement pricePercentReduction =  webDriver.findElement(By.className("price-percent-reduction"));
        Assert.assertEquals("-20%", pricePercentReduction.getText());
    }
}
