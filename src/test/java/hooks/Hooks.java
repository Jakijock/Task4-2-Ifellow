package hooks;


import com.codeborne.selenide.Configuration;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class Hooks {

    private static final String BASE_URL = "https://edujira.ifellow.ru/";

    @Before
    public static void openBrowser() {
        Configuration.startMaximized = true;
        open(BASE_URL);
    }

    @After
    public static void closeDriver() {
        closeWebDriver();
    }
}
