package com.testjob.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.testjob.helpers.Attachments;
import config.WebDriverProvider;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseConfig {
    @BeforeAll
    static void setup() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        //Configuration.baseUrl = "https://hh.ru/";
        Configuration.holdBrowserOpen = false;
        WebDriverProvider.setConfig();
        //Configuration.browser = System.getProperty("browser", "chrome");

        //System.setProperty("browser_version","105");
        //Configuration.browserVersion = System.getProperty("browser_version", "100");

        //System.setProperty("browser_size","1920x1080");
        //Configuration.browserSize = System.getProperty("browser_size","1920x1080");


        //String remoteUrl = System.getProperty("remote_url");
//        if (remoteUrl != null) {
//            final ChromeOptions chromeOptions = new ChromeOptions();
//            chromeOptions.addArguments("--no-sandbox");
//            Configuration.remote = remoteUrl;
//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            capabilities.setCapability("enableVNC", true);
//            capabilities.setCapability("enableVideo", true);
//
//            //capabilities.addArguments("--no-sandbox");
//            Configuration.browserCapabilities = capabilities;
//        }
    }
    @AfterEach
    void addAttachments() {
        Attachments.screenshotAs("screenshot");
        Attachments.pageSource();
        Attachments.consoleLogs();
        Attachments.addVideo();
    }
//    @AfterAll
//    static void addVideo() {
//     Attachments.addVideo();
//    }
}
