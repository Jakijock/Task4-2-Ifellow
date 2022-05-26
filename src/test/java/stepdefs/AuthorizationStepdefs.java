package stepdefs;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import service.AuthorizationService;
import service.HomePageService;
import utils.ScreenshotMaker;

import java.util.List;

public class AuthorizationStepdefs {


    private final AuthorizationService authorizationService = new AuthorizationService();
    private final HomePageService homePageService = new HomePageService();
    private final SoftAssertions softAssertions = new SoftAssertions();
    private final ScreenshotMaker screenshotMaker = new ScreenshotMaker();

    @Когда("^вводим корректные логин и пароль")
    public void addLoginAndPassword(List<String> arg) {
        authorizationService.isAllRequiredFieldsAreVisible(softAssertions);
        authorizationService.performAuthorization(arg.get(0), arg.get(1));
        screenshotMaker.makeScreenshot();
    }

    @И("^нажимаем кнопку Войти")
    public void pressSignInButton() {
        authorizationService.getSignInButton().click();
        screenshotMaker.makeScreenshot();
    }

    @Тогда("^открывается домашняя страница")
    public void isHomePageOpen() {
        homePageService.isAllRequiredFieldsAreVisible(softAssertions);
        screenshotMaker.makeScreenshot();
    }

    @Когда("вводим некорректные логин и пароль: Логин={word}, Пароль={word}")
    public void enteringAnIncorrectUsernameAndPassword(String login, String password) {
        authorizationService.isAllRequiredFieldsAreVisible(softAssertions);
        authorizationService.performAuthorization(login, password);
        screenshotMaker.makeScreenshot();
    }

    @Тогда("^появляется ошибка о некорректности ввода логина или пароля")
    public void isErrorShown() {
        authorizationService.isErrorVisible(softAssertions);
        screenshotMaker.makeScreenshot();
    }

}

