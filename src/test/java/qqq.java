

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class qqq {

    private final static String REPOSITORY = "allure-notifications";
    private final static String ISSUE_NAME = "Add launch user name";

    @Test
    public void testGithub() {
        step("Открыть главную страницу", () -> {
            open("https://github.com");
        } );

        step("Помск репзитория" +  REPOSITORY , () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY );
            $(".header-search-input").submit();
        } );

        step("Переход в репозиторий", () -> {
            $(linkText(REPOSITORY)).click();
        } );

        step("Открыть раздел Issues", () -> {
            $(partialLinkText("Issues")).click();
        } );

        step("Проверка названия Issue", () -> {
            $("#issue_65_link").shouldHave(text(ISSUE_NAME));
        } );

    }
}