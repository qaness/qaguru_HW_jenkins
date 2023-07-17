package demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import demoqa.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        String browser = System.getProperty("browser", "chrome");
        String version = System.getProperty("version", "99.0");
        String windowSize = System.getProperty("windowSize", "1920x1080");
        String baseUrl = System.getProperty("baseUrl", "https://demoqa.com");
        String remoteBrowser = System.getProperty("remoteBrowser", "https://user1:1234@selenoid.autotests.cloud/wd/hub");


        Configuration.baseUrl = baseUrl;
        Configuration.browser = browser;
        Configuration.browserVersion = version;
        Configuration.browserSize = windowSize;
        // Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = "eager";

        Configuration.remote = remoteBrowser;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

        closeWebDriver();
    }


    }
