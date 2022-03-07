package test.cases;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.opject.*;
import utils.Base;

import java.util.ArrayList;


public class TaskRuner extends Base {
    private HomePage homePage;
    private ContactUsPage contactUsPage;
    private CompanyPage companyPage;
    private FaceBookPage faceBookPage;
    private CareersPage careersPage;
    private QAPage qaPage;
    Faker faker = new Faker();
    String name = faker.name().firstName();
    String email = "h@test";
    String subject = faker.name().title();
    String message = faker.name().fullName();

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        contactUsPage = new ContactUsPage(driver);
        companyPage = new CompanyPage(driver);
        faceBookPage = new FaceBookPage(driver);
        careersPage = new CareersPage(driver);
        qaPage = new QAPage(driver);
        String baseUrl = "https://www.musala.com/";
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    public void TestCase1() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", homePage.getContactUseBtn());
        homePage.getContactUseBtn().click();
        contactUsPage.Name().sendKeys(name);
        contactUsPage.Email().sendKeys(email);
        contactUsPage.Subject().sendKeys(subject);
        contactUsPage.message().sendKeys(message);
        contactUsPage.Send().click();
        Assert.assertTrue(contactUsPage.ErrorMessage().isDisplayed());
    }

    @Test
    public void TestCase2() {
        homePage.Company().click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.musala.com/company/");
        String actualName = companyPage.LeaderShipSection().getText();
        Assert.assertTrue(actualName.contains("Leadership"));
        companyPage.AcceptCookies().click();
        companyPage.FacebookBtn().click();
        // hold all window handles in array list
        ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
        //switch to new tab
        driver.switchTo().window(newTb.get(1));
        new WebDriverWait(driver, 40).until(ExpectedConditions.urlToBe("https://www.facebook.com/MusalaSoft?fref=ts"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/MusalaSoft?fref=ts");
        // Javascript executor to check image
        Boolean isPresent = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete "
                + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", faceBookPage.FaceBookImage());
        //verify if status is true
        if (isPresent) {
            System.out.println("Logo present");
        } else {
            System.out.println("Logo not present");
        }
    }

    @Test
    public void TestCase3() {
        homePage.Careers().click();
        careersPage.openPositions().click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.musala.com/careers/join-us/");
        Select location = new Select(careersPage.selectLocation());
        location.selectByValue("Anywhere");
        careersPage.selectQA().isDisplayed();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", careersPage.selectQA());
        qaPage.generalDescription().isDisplayed();
        qaPage.requirement().isDisplayed();
        qaPage.responsibilities().isDisplayed();
        qaPage.WhatWeOffer().isDisplayed();
        qaPage.apply().isDisplayed();
        executor.executeScript("arguments[0].click();", qaPage.apply());
        qaPage.email().sendKeys(email);
        WebElement uploadElement = qaPage.uploadFile();

        // enter the file path onto the file-selection input field
        uploadElement.sendKeys("./file/test.TXT");
        qaPage.checkBox().click();
        executor.executeScript("arguments[0].click();", qaPage.Send());

    }

}
