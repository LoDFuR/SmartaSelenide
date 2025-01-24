package com.example.junit5.Test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.conditions.Enabled;
import com.codeborne.selenide.conditions.Visible;
import com.example.junit5.Pages.Catalog;
import com.example.junit5.Pages.Header;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class toApplicantTest {

    @Test
    public void toApplicantTest() {
        open(Catalog.main);
        getWebDriver().manage().window().maximize();
        sleep(2000);
        // Выбираем товар
        Catalog.PhoneLink.scrollIntoView(false);
        sleep(1500);
        Catalog.PhoneLink.click();
        sleep(1500);
        Catalog.ProgrammOptionsButton.click();
        sleep(2500);
        sleep(500);
        Catalog.FirstProgrammButton.click();
        sleep(3000);
        Catalog.NoAccsButton.click();
        sleep(3000);
        Catalog.NoAppsButton.isDisplayed();
        Catalog.NoAppsButton.click();
        sleep(3000);
        sleep(500);
        Catalog.OrderButton.click();
        sleep(1500);
        // Authorization
        Catalog.PhoneNumberInputForm.setValue("980-750-68-90");
        sleep(500);
        Catalog.SubmitPhoneNumberInputForm.click();
        sleep(599);
        Catalog.AuthorizationPin1.setValue("4");
        sleep(250);
        Catalog.AuthorizationPin2.setValue("4");
        sleep(250);
        Catalog.AuthorizationPin3.setValue("4");
        sleep(250);
        Catalog.AuthorizationPin4.setValue("4");
        sleep(2000);
    }

    @Test
    public void toCyberityTest(){
        open(Catalog.main);
        sleep(2000);
        // Выбираем товар
        Catalog.PhoneLink.scrollIntoView(false);
        sleep(1500);
        Catalog.PhoneLink.click();
        sleep(1000);
        //Catalog.ProgrammOptionsButton.scrollIntoView(true);
        //Catalog.ProgrammOptionsButton.scrollTo();
        sleep(500);
       // Catalog.ProgrammOptionsButton.scrollTo();
        sleep(1000);
        Catalog.ProgrammOptionsButton.click();
        sleep(1500);
      //  Catalog.ThirdProgrammButton.scrollIntoView(true);
        sleep(500);
        Catalog.FirstProgrammButton.click();
        sleep(2000);
//        Catalog.NoAppsButton.scrollIntoView(true);
        Catalog.NoAccsButton.click();
        sleep(2000);
        Catalog.NoAppsButton.isDisplayed();
        Catalog.NoAppsButton.click();
        sleep(2000);
     //   Catalog.OrderButton.scrollIntoView(false);
        sleep(500);
        Catalog.OrderButton.click();
        sleep(1500);
        // Authorization
        Catalog.PhoneNumberInputForm.setValue("980-749-72-00");
        sleep(500);
        Catalog.SubmitPhoneNumberInputForm.click();
        sleep(599);
        Catalog.AuthorizationPin1.setValue("4");
        sleep(250);
        Catalog.AuthorizationPin2.setValue("4");
        sleep(250);
        Catalog.AuthorizationPin3.setValue("4");
        sleep(250);
        Catalog.AuthorizationPin4.setValue("4");
        sleep(2000);
        // Если нужно аннулировать заявку
        if (Catalog.DeclineOrderButton.isEnabled()) {
            sleep(500);
            Catalog.DeclineOrderButton.click();
            sleep(1000);
            Catalog.ApproveButton.click();
            sleep(2000);
        }
        Catalog.StartCyberityButton.click();
        sleep(7000);
//        Catalog.NextStepCyberityButton.shouldBe(Condition.visible);
//        Catalog.NextStepCyberityButton.isEnabled();
//        sleep(1500);
//        Catalog.NextStepCyberityButton.click();
//        sleep(3000);
    }



}
