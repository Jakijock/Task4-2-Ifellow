package service;

import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import pages.AuthorizationPage;

import static utils.Assertions.isVisible;

public class AuthorizationService extends AuthorizationPage {

    public void performAuthorization(
            String email,
            String password
    ) {
        getEmailInput().clearAndType(email);
        getPasswordInput().clearAndType(password);
    }

    public void pressSignInButton() {
        getSignInButton().click();
    }

    public void isAllRequiredFieldsAreVisible(SoftAssertions softAssertion) {
        isVisible(softAssertion, getEmailInput(), "Email");
        isVisible(softAssertion, getPasswordInput(), "Password");
    }

    public void isSignInButtonVisible(SoftAssertions softAssertion) {
        isVisible(softAssertion, getSignInButton(), "Enter");
    }

    public void isErrorVisible(SoftAssertions softAssertion) {
        isVisible(softAssertion, getErrorSingIn(), "Error");
    }

}

