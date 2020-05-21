import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class OrderMyStorePage {
    private final WebDriver webDriver;

    public OrderMyStorePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }

    public OrderMyStorePage proceedToCheckoutClick() {
        String href = webDriver.findElement(By.xpath("//a[contains(@title,'Proceed to checkout')]")).getAttribute("href");
        webDriver.navigate().to(href);
        return this;
    }

    public boolean imageIsExist() {
        WebElement img = webDriver.findElement(By.xpath("//img[contains(@src,'http://automationpractice.com/img/p/1/1-small_default.jpg')]"));
        return img != null;
    }
}
