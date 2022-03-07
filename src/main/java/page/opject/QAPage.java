package page.opject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Utils;

public class QAPage {
    private final WebDriver driver;

    public QAPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement generalDescription() {
        return Utils.waitToBeClickable(driver, By.xpath("//h2[contains(text(),'Requirements')]"), 30);
    }

    public WebElement requirement() {
        return Utils.waitToBeClickable(driver, By.xpath("//h2[contains(text(),'Requirements')]"), 30);
    }

    public WebElement responsibilities() {
        return Utils.waitToBeClickable(driver, By.xpath("//h2[contains(text(),'Responsibilities')]"), 30);
    }

    public WebElement WhatWeOffer() {
        return Utils.waitToBeClickable(driver, By.xpath("//h2[contains(text(),'What we offer')]"), 30);
    }

    public WebElement apply() {
        return Utils.waitToBeClickable(driver, By.xpath("//input[@value='Apply']"), 30);
    }

    public WebElement email() {
        return Utils.waitToBeClickable(driver, By.xpath("//input[@id='cf-2']"), 30);
    }

    public WebElement uploadFile() {
        return Utils.waitToBeClickable(driver, By.xpath("//input[@id='uploadtextfield']"), 30);
    }

    public WebElement Send() {
        return Utils.waitToBeClickable(driver,
                By.xpath("//div[@class='btn-cf-wrapper']//input[@type='submit'//value['Send']]"), 30);
    }

    public WebElement checkBox() {
        return Utils.waitToBeClickable(driver,
                By.xpath("//input[@id='adConsentChx']"), 30);
    }
}
