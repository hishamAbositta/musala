package page.opject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Utils;

public class CompanyPage {
    private final WebDriver driver;

    public CompanyPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement LeaderShipSection() {
        return Utils.waitToBeClickable(driver, By.xpath("//h2[contains(text(),'Leadership')]"), 30);
    }

    public WebElement FacebookBtn() {
        return Utils.waitToBeClickable(driver, By.xpath("//body/footer[1]/div[1]/div[1]/a[4]/span[1]"), 30);
    }

    public WebElement AcceptCookies() {
        return Utils.waitToBeClickable(driver, By.xpath("//a[@id='wt-cli-accept-all-btn']"), 30);
    }
}
