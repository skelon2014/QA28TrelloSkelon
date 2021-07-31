package com.telran.qa28.skelon.framework;

import com.telran.qa28.skelon.model.Card;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CardHelper extends HelperBase {
    public CardHelper(WebDriver wd) {
        super(wd);
    }

    public void addNew() {
        waitForElementAndclick(By.cssSelector(".js-add-a-card"), 15);
    }

    public void fillForm(Card card) {
        type(By.cssSelector(".js-card-title"), card.getName());
        click(By.cssSelector(".js-cc-menu"));
        click(By.cssSelector(".js-label-selector"));

        selectLable(card.getColor());

        //    type(By.cssSelector("textarea[placeholder='Enter a title for this card…']"), "This a new listTest");


    }

    private void selectLable(String color) {
        if (color != null) {
            click(By.cssSelector(".card-label-" + color + ""));
        }
    }

    public void confirmCreation() {
        click(By.cssSelector("input[value='Add card']"));
    }
}
