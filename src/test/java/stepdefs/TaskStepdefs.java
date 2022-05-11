package stepdefs;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.assertj.core.api.SoftAssertions;
import service.*;

public class TaskStepdefs {

    private HomePageService homePageService = new HomePageService();
    private SoftAssertions softAssertion = new SoftAssertions();
    private CreateTestService createTestService = new CreateTestService();

    @Когда("^открыта страница для создания задач")
    public void openCreateTestPage() {
        homePageService.openCreateTestPage();
    }

    @Тогда("заполняем поля: Тема={word}, Описание={word}")
    public void fillAllFields(String name, String description) {
        createTestService.isAllRequiredFieldsAreVisible(softAssertion);
        createTestService.performCreateTest(name, description);
    }

    @И("^нажимаем кнопку Создать тест")
    public void pressCreateButton() {
        createTestService.pressCreateButton();
    }
}
