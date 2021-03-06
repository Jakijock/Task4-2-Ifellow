package stepdefs;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.assertj.core.api.SoftAssertions;
import service.*;
import utils.ScreenshotMaker;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class JiraStepdefs {

    private final AuthorizationService authorizationService = new AuthorizationService();
    private final HomePageService homePageService = new HomePageService();
    private final SoftAssertions softAssertions = new SoftAssertions();
    private BrowseProjectsService browseProjectsService = new BrowseProjectsService();
    private RapidBoardService rapidBoardService = new RapidBoardService();
    private TestInformationService testInformationService = new TestInformationService();
    private final ScreenshotMaker screenshotMaker = new ScreenshotMaker();

    @Когда("^пользователь авторизирован")
    public void performAuthorization() {
        authorizationService.isAllRequiredFieldsAreVisible(softAssertions);
        authorizationService.performAuthorization("esirozh", "123Qwerty");
        authorizationService.getSignInButton().click();
        screenshotMaker.makeScreenshot();
    }

    @И("^открыта домашняя страница")
    public void isHomePageOpen() {
        homePageService.isAllRequiredFieldsAreVisible(softAssertions);
        screenshotMaker.makeScreenshot();
    }

    @Когда("^открыта страница с  проектами")
    public void openProjectPage() {
        homePageService.openBrowseProjectsPage();
        screenshotMaker.makeScreenshot();
    }

    @И("^выбран проект")
    public void selectProject(String project) {
        browseProjectsService.selectProject(project);
        screenshotMaker.makeScreenshot();
    }

    @Тогда("^сравниваем число задач с из количеством")
    public void compareNumberOfTasks() {
        rapidBoardService.openListOfTasks(softAssertions);
        Integer numberOfTasks = rapidBoardService.getNumberOfTasks();
        Integer numberOfTasksInList = rapidBoardService.getNumberOfTasksInLisy();
        assertTrue("Заявленное количество и количество задач в листе различны", numberOfTasks.equals(numberOfTasksInList));
        screenshotMaker.makeScreenshot();
    }

    @Тогда("^выбираем задачу")
    public void selectTask(String task) {
        rapidBoardService.openListOfTasks(softAssertions);
        rapidBoardService.showAllTasks();
        rapidBoardService.selectTest(task);
        screenshotMaker.makeScreenshot();
    }


    @И("^сравниеваем реальные версии с ожидаемыми")
    public void checkStatusAndVersion(List<String> arg) {
        String statusTest = rapidBoardService.getStatusValue(softAssertions);
        String versionTest = rapidBoardService.getVersionValue(softAssertions);
        assertEquals("Ожидался статус задачи " + arg.get(1), statusTest, arg.get(1));
        assertEquals("Ожидалась версия " + arg.get(0), versionTest, arg.get(0));
        screenshotMaker.makeScreenshot();
    }

    @И("^меняем статус задачи на ГОТОВО")
    public void changeTaskStatus() throws InterruptedException {
        rapidBoardService.openTestInformationPage(softAssertions);
        testInformationService.isAllRequiredFieldsAreVisible(softAssertions);
        testInformationService.completeTask();
        Thread.sleep(3000);
        String statusTest = rapidBoardService.getStatusValue(softAssertions);
        assertEquals("Ожидался статус задачи \"ГОТОВО\"", "ГОТОВО", statusTest);
        screenshotMaker.makeScreenshot();
    }
}
