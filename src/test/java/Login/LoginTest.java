package Login;

/*
* Author Naveen Reddy
*
*
*
* */

import Pages.Loginpage;
import ReusableUtils.Action;
import TestData.Readnwrite;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest {

    static ExtentTest test;
    static ExtentReports report;
    @BeforeClass
    public void starTest()
    {
        report = new ExtentReports("./test-output/InfineonPOrtal-Results.html");
        test = report.startTest("Infineon Application Automation Results");
    }

    @Test
    public  void verifyLoginTest() throws IOException, InterruptedException
    {
        Action.openbrowser("chrome");
        Action.openUrl("https://subs-cp-dev.com/#/login");
        Action.enterText(Loginpage.email, Readnwrite.readdata("fb",0,0));
        Action.enterText(Loginpage.password,Readnwrite.readdata("fb",0,1));
        Action.clickon(Loginpage.login);
        Thread.sleep(5000);
        test.log(LogStatus.PASS,"Login Test case Executed");
        Action.closebrowser();

    }
    @Test
    public void forgotpassword() throws InterruptedException, IOException {
        Action.openbrowser("chrome");
        Action.openUrl("https://subs-cp-dev.com/#/login");
        Action.clickon(Loginpage.forgotpassword);

        Action.enterText(Loginpage.forgotPWEmail, Readnwrite.readdata("fb",0,0));
        Thread.sleep(5000);

        test.log(LogStatus.PASS,"Forgot link is working as expected");
        Action.closebrowser();

    }

 @AfterClass
public void endTest(){
        report.endTest(test);
        report.flush();

}



}
