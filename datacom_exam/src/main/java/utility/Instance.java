package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class Instance  {

    public WebDriver _driver;

    //Instantiate a chrome driver
    public WebDriver getChromeDriverInstance(String _url) {
        String chromeExepath = System.getProperty("user.dir") + "\\src\\main\\java\\utility\\chromedriver-win32\\chromedriver.exe";
        System.out.println("driver exe file path: " + chromeExepath);
        System.setProperty("webdriver.chrome.driver",chromeExepath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        _driver = new ChromeDriver( options);
        if(_url != null){
            _driver.get(_url);

        }
        _driver.manage().window().maximize();

        return  _driver;

    }


}