package com.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage {


    WebDriver driver;

    public ContactUsPage(WebDriver _driver) {
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(_driver, 200);
        PageFactory.initElements(factory, this);
        driver = _driver;
    }




    @FindBy(xpath= "//div[@data-launchid='launchId']") public WebElement contacUsbutton;

    @FindBy(xpath= "//input[@id='FirstName']") public WebElement firstName;
    @FindBy(xpath= "//input[@id='LastName']") public WebElement lastName;
    @FindBy(xpath= "//input[@id='Email']") public WebElement Email;
    @FindBy(xpath= "//input[@id='Phone']") public WebElement Phone;
    @FindBy(xpath= "//input[@id='Title']") public WebElement Title;
    @FindBy(xpath= "//input[@id='Company']") public WebElement Company;
    @FindBy(xpath= "//select[@id='Country']") public WebElement Country;

    @FindBy(xpath= "//select[@id='custom2']") public WebElement howCanweHelpyou;
    @FindBy(xpath= "//select[@id='Enquiry__c']") public WebElement selectAsolution;
    @FindBy(xpath= "//button[text()='Submit']") public WebElement submitButton;

    @FindBy(xpath= "//input[@id='How_can_we_help__c']") public WebElement messageTxtbox;


    @FindBy(xpath= "//h3[text()='Thank you for getting in touch with us']") public WebElement thankyouMessage;







    @FindBy(xpath = "//h2[@class='cmp-title__text ']") public WebElement bodyTitle;


    //fill in the contact form
    public Boolean fillInContactform() throws InterruptedException {

        contacUsbutton.click();

        firstName.sendKeys("Testfirstname");
        lastName.sendKeys(("TestlastName"));
        Email.sendKeys(("test@testdata.com"));
        Phone.sendKeys(("987659821"));
        Title.sendKeys("Tester");
        Company.sendKeys("TestClient");



        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Country);
        Select dropdown = new Select(Country);
        dropdown.selectByValue("Philippines");
        Thread.sleep(100);


        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", howCanweHelpyou);
        Select dropdown_howCanweHelpyou = new Select(howCanweHelpyou);
        dropdown_howCanweHelpyou.selectByValue("Consult with an expert");
        Thread.sleep(100);


        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectAsolution);
        Select dropdown_selectSolution = new Select(selectAsolution);
        dropdown_selectSolution.selectByValue("Cloud services");
        Thread.sleep(100);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", messageTxtbox);
        messageTxtbox.sendKeys("Testing to send form");

        submitButton.click();

        return thankyouMessage.isDisplayed();






    }

    //methods / actions
    public String pageTitle(){
        String pageTitle = driver.getTitle();
        System.out.println("Page title : " + pageTitle);
        System.out.println("Char length: " + pageTitle.length());
        return pageTitle.trim();

    }

    public String bodyH2Title(){
        String h2title = bodyTitle.getText();
        System.out.println("Body title : " + h2title);
        return h2title.trim();

    }

}
