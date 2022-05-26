package stepdefs;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.assertj.core.api.SoftAssertions;
import service.*;
import utils.ScreenshotMaker;

public class TaskStepdefs {

    private HomePageService homePageService = new HomePageService();
    private SoftAssertions softAssertion = new SoftAssertions();
    private CreateTestService createTestService = new CreateTestService();
    private final ScreenshotMaker screenshotMaker = new ScreenshotMaker();

    @Когда("^открыта страница для создания задач")
    public void openCreateTestPage() {
        homePageService.openCreateTestPage();
        screenshotMaker.makeScreenshot();
    }

    @Тогда("заполняем поля: Тема={word}, Описание={word}")
    public void fillAllFields(String name, String description) {
        createTestService.isAllRequiredFieldsAreVisible(softAssertion);
        createTestService.performCreateTest(name, description);
        screenshotMaker.makeScreenshot();
    }

    @И("^нажимаем кнопку Создать тест")
    public void pressCreateButton() {
        createTestService.pressCreateButton();
        screenshotMaker.makeScreenshot();
    }
}
