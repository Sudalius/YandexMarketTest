
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.sudyarov.steps.BaseStep;
import com.sudyarov.steps.MainSteps;
import java.io.IOException;
import java.util.Properties;

public class MainTest {

    private Properties props;
    private MainSteps mainSteps;

    @BeforeTest
    public void beforeTest() throws IOException {
        BaseStep.beforeTest("chrome");  // use "firefox" in this field to execute test in Firefox browser
        mainSteps = new MainSteps();               // but pay attention: geckodriver for Firefox currently unstable
        props = BaseStep.loadProperties();
    }


    @Test
    public void mainTest() {

        mainSteps.openYandex()
                .clickMarket()
                .chooseElectronic()
                .chooseTV()
                .setPriceFrom(props.getProperty("priceFrom"))
                .checkSamsungAndLg()
                .check48ElementsOnPage()
                .storeFirstElement()
                .searchAndAssert();
    }
}