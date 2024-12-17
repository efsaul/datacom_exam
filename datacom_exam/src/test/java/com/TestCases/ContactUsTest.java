package com.PageObjects.TestCases;

import com.PageObjects.ContactUsPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utility.Instance;

public class ContactUsTest extends Instance {
    public static WebDriver driver ;
    ContactUsPage cp;

    @BeforeClass
    public void navigateTourl(){
        driver = getChromeDriverInstance("https://datacom.com/nz/en/contact-us");
       cp = new ContactUsPage(driver);
    }

    @Test(priority = 1, enabled = true)
    public void verifyTheactualPagetitle() throws InterruptedException {

        String actualPagetitle = cp.pageTitle();

        Assert.assertEquals(actualPagetitle, "Contact Us — Get In Touch");

    }

    @Test(priority = 2, enabled = true)
    public void verifyPagetitlecontainsSpecificvalue() throws InterruptedException {

        String actualPagetitle = cp.pageTitle();

        Assert.assertTrue(actualPagetitle.contains("Contact Us"));
        Assert.assertTrue(actualPagetitle.contains("Get In Touch"));
    }

    @Test(priority = 3, enabled = true)
    public void verifyBodytitle() throws InterruptedException {
        Assert.assertEquals(cp.bodyH2Title(),"Our locations");
    }

    @Test(priority = 4, enabled = true)
    public void verifyContactformIssubmitted() throws InterruptedException {

        Assert.assertTrue(cp.fillInContactform());
    }




    //cleanup driver / close after test execution
    @AfterClass
    public void closeDriver(){
        driver.close();
        driver.quit();
    }



}
