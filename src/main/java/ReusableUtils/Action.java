package ReusableUtils;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Action {

     static WebDriver driver;

   static public void enterText(String webelement , String text)
    {
        try {
            driver.findElement(By.xpath(webelement)).sendKeys(text);
        }
        catch (Exception e) {
            e.getMessage();

        }
    }

       static public  void clickon(String Webeleemnt)
        {

            driver.findElement(By.xpath(Webeleemnt)).click();
       }

static public  void  openbrowser( String browser) throws InterruptedException {

        switch (browser){
            case "chrome":
                System.setProperty("webdriver.chrome.driver","./src/main/resources/drivers/chromedriver1.exe");
                 driver = new ChromeDriver();
                 driver.manage().window().maximize();

                 break;

            case "firefox": {
                System.setProperty("webdriver.firefox.driver", "./src/main/resources/drivers/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            }
            default:
                System.out.println("Browser not specified");
                break;
        }
}

static public void  openUrl(String URL) throws InterruptedException {


        driver.get(URL);

}

static public  void closebrowser() throws InterruptedException {

        driver.quit();

}


}
