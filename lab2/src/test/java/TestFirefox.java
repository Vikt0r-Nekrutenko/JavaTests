import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class TestFirefox {
    WebDriver webDriver;
    public  TestFirefox()
    {
        System.setProperty("webdriver.gecko.driver", "C:/Users/grhin0/IdeaProjects/geckodriver.exe");
        webDriver = new FirefoxDriver();
    }

    @Test
    public void googleTest() {
        webDriver.get("https://google.com");
        Assert.assertEquals("Google", webDriver.getTitle());

        Assert.assertNotNull(webDriver.findElement(By.className("gNO89b")));
        Assert.assertNotNull(webDriver.findElement(By.id("hplogo")));
        Assert.assertNotNull(webDriver.findElement(By.className("RNNXgb")));
        Assert.assertNotNull(webDriver.findElement(By.linkText("Gmail*")));
    }

    @Test
    public void wikipediaTest() {
        webDriver.get("https://wikipedia.org");
        webDriver.navigate().to("https://uk.wikipedia.org/wiki/Київ");

        Assert.assertNotNull(webDriver.findElement(By.xpath("//img[contains(@src,'//upload.wikimedia.org/wikipedia/commons/thumb/1/1a/COA_of_Kyiv_Kurovskyi.svg/90px-COA_of_Kyiv_Kurovskyi.svg.png')]")));
        List<WebElement> td = webDriver.findElements(By.tagName("td"));
        WebElement populationItem = null;
        WebElement gustotaPopulation = null;
        for (WebElement element : td) {
            if (element.getText().equals("2 967 000 (1 березня 2020)")) {
                populationItem = element;
            } else if (element.getText().equals("3536,35 осіб/км²")) {
                gustotaPopulation = element;
            }
        }

        Assert.assertNotNull(populationItem);
        Assert.assertNotNull(gustotaPopulation);

        List<WebElement> th = webDriver.findElements(By.tagName("th"));
        WebElement averageAprilTemperature = null;
        for (WebElement element : th) {
            if (element.getText().equals("9,3")) {
                averageAprilTemperature = element;
            }
        }
        Assert.assertNotNull(averageAprilTemperature);

        Assert.assertNotNull(webDriver.findElement(By.id("Епідемія_коронавірусу")));
    }
}
