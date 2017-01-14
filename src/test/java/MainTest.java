import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import steps.MainSteps;

public class MainTest {

    @BeforeTest
    public void beforeTest() {
        Configuration.timeout = 6000;
        System.setProperty("webdriver.chrome.driver", "../YMtest/driver/chromedriver");
        Configuration.browser = "chrome";
    }

    @Test
    public void mainTest() {
        MainSteps mainSteps = new MainSteps();

        mainSteps.openYandex()
                .clickMarket()
                .chooseElectronic()
                .chooseTV()
                .setPriceFrom("20000")
                .checkSamsungAndLg().clickApplyButton()
                .check12ElementsOnPage()
                .storeFirstElement()
                .searchAndAssert();
    }
}