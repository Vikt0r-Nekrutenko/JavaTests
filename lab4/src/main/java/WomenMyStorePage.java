import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WomenMyStorePage {
    private final WebDriver webDriver;

    public WomenMyStorePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }

    @FindBy(linkText = "Women")
    private WebElement womenButton;

    public void open() {
        String href = womenButton.getAttribute("href");
        webDriver.navigate().to(href);
    }

    public int unitCount() {
        return webDriver.findElements(By.className("ajax_block_product")).size();
    }

    public int yellowUnitCount() {
        int count = 0;
        List<WebElement> units = webDriver.findElements(By.className("color_pick"));
        for (WebElement unit : units) {
            String href = unit.getAttribute("href");
            try {
                if (href.contains("color-yellow")) {
                    count++;
                }
            } catch (NullPointerException ignored) {  }
        }
        return count;
    }

    public void gridToListView() {
        webDriver.findElement(By.className("icon-th-list")).click();
    }

    public boolean checkProductDescription() {
        return !webDriver.findElements(By.className("product-desc")).isEmpty();
    }

    public BlouseMyStorePage unit(String unitName) {
        WebElement unit1 = webDriver.findElement(By.linkText(unitName));
        if (unit1 != null)
            return new BlouseMyStorePage(webDriver, unit1.getAttribute("href"));
        else return null;
    }
}
