package service;

import org.assertj.core.api.SoftAssertions;
import pages.TestInformationPage;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static utils.Assertions.isVisible;

public class TestInformationService extends TestInformationPage {

    public void isAllRequiredFieldsAreVisible(SoftAssertions softAssertion){
        isVisible(softAssertion, getBusinessProcessesButton(), "BusinessProcesses");
    }

    public void completeTask() {
        getBusinessProcessesButton().click();
        getWebDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        getDoneButton().click();
    }

}
