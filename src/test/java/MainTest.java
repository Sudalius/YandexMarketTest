
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterTest;
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
        WebDriverManager.chromedriver().setup();
        props = BaseStep.loadProperties();
        mainSteps = new MainSteps();
    }

    @Test
    public void mainTest() {
        mainSteps.openYandexMarket(props.getProperty("baseURL"))
                .chooseComputers()
                .chooseLaptops()
                .setPriceFrom(props.getProperty("priceFrom"))
                .markAppleAndMicrosoft()
                .checkFoundedTitlesQuantityOnPage(48)
                .storeFirstElement()
                .putElementAndCheckSearchResult();
    }

    @AfterTest
    public void afterTest() {
        BaseStep.driver.close();
    }
}
