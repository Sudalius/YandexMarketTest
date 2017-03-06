import com.sudyarov.properties.Config;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.sudyarov.steps.BaseStep;
import com.sudyarov.steps.MainSteps;
import java.io.IOException;

public class MainTest {

    @BeforeTest
    public void beforeTest() {
        BaseStep.beforeTest();
    }

    @Test
    public void mainTest() throws IOException {

        MainSteps mainSteps = new MainSteps();
        Config config = new Config();

        mainSteps.openYandex()
                .clickMarket()
                .chooseElectronic()
                .chooseTV()
                .setPriceFrom(config.loadTvPrice("tvPrice"))
                .checkSamsungAndLg().clickApplyButton()
                .check12ElementsOnPage()
                .storeFirstElement()
                .searchAndAssert();
    }
}