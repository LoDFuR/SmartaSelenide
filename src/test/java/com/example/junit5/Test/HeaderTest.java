package com.example.junit5.Test;
import com.example.junit5.Pages.Header;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class HeaderTest {

/*
* It opens site on the start page
* */
    @Test
    public void OpenSite(){
        open(Header.main);
        sleep(2000);
}

}
