package com.example.junit5.Test;

import com.example.junit5.Pages.Applicant;
import com.example.junit5.Pages.Catalog;
import com.example.junit5.Pages.Header;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ApplicantTest {
    @Test
    public void openPage(){
        open(Applicant.main);
        getWebDriver().manage().window().maximize();
        Applicant.PhoneNumberInputForm.setValue("980-750-68-90");
        sleep(500);
        Applicant.SubmitPhoneNumberInputForm.click();
        sleep(599);
        Applicant.AuthorizationPin1.setValue("1");
        sleep(250);
        Applicant.AuthorizationPin2.setValue("1");
        sleep(250);
        Applicant.AuthorizationPin3.setValue("1");
        sleep(250);
        Applicant.AuthorizationPin4.setValue("1");
        sleep(5000);
}

    @Test
    public void openPersonalityPolitics(){
        open(Applicant.main);
        sleep(1500);
        Applicant.PersonalityPoliticsLink.click();
        sleep(3000);
    }
}
