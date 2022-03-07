package page.opject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Utils;

public class CareersPage {
    private final WebDriver driver;

    public CareersPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement openPositions() {
        return Utils.waitToBeClickable(driver, By.xpath("//span[contains(text(),'Check our open positions')]"), 30);
    }

    public WebElement selectLocation() {
        return Utils.waitToBeClickable(driver, By.xpath("//select[@id='get_location']"), 30);
    }

    public WebElement selectQA() {
        return Utils.waitToBeClickable(driver, By.xpath("//div[@class='inner-wraper']//img[@alt='Experienced Automation QA Engineer']"), 30);
    }

}
