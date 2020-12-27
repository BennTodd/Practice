package com.ATQA2020Lagoshin;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstWebTests {
    private RemoteWebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
    };

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        };
    };
    @Test (priority = 0)
    public void mainUrlTest() {
        //Given user provides a valid URL
        driver.get("https://www.namecheap.com");
        //Then user gets to the main page
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='gb-header']")).isDisplayed());
    };

    @Test(priority = 1)
    public void newTestSecond() {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        //Given that user provides a valid URL
        driver.get("https://www.namecheap.com/");
        // When user navigates to the footer
        driver.findElement(By.cssSelector(".gb-footer"));
        //Then user is still on the main page
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='static-domain-search-domain-search-input']")).isDisplayed());
    };
    @Test(priority = 2)
    public void newTestThird() {
        //Given user provides a valid URL
        driver.get("https://www.namecheap.com/hosting/email/");
        //Then user gets to the Email page
        Assert.assertTrue(driver.findElement(By.cssSelector(".gb-hero__body>h1")).isDisplayed());
    };
    @Test(priority = 3)
    public void newTestFourth() {
        //Given user provides a valid URL
        driver.get("https://www.namecheap.com/domains/domain-name-search/");
        //Then user gets to the Domain Search Page
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='gb-row gb-domain-name-search--pricing gb-section']")).isDisplayed());
    };

    @Test(priority = 4)
    public void newTestFifth() {
        //Given user provides a valid URL
        driver.get("https://www.namecheap.com/domains/domain-name-search/");
        //Then user navigates to the TLDs pricing table
        driver.findElement(By.xpath("//div[@class='gb-row gb-domain-name-search--pricing gb-section']"));
        //When user clicks on +Show More button to see the full list
        driver.findElement(By.xpath("//button[@class='gb-btn gb-mb-6 gb-btn-show-more']")).click();
        //Then user gets to see the full pricing list
        Assert.assertTrue(driver.findElement(By.xpath("//button[contains(text(),'- Show Less')]")).isDisplayed());

    };

}
