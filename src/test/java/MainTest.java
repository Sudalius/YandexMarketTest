import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import steps.MainSteps;

public class MainTest {

    MainSteps mainSteps = new MainSteps();

    @BeforeTest
    public void beforeTest() {
        Configuration.timeout = 6000;
    }

    @Test
    public void mainTest() {
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