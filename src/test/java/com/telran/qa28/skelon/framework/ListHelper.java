package com.telran.qa28.skelon.framework;

import com.telran.qa28.skelon.model.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListHelper extends HelperBase {
    public ListHelper(WebDriver wd) {
        super(wd);
    }

    public void addNewList() {
        click(By.cssSelector(".placeholder"));
    }

    public void typeName(List list) {
        type(By.name("name"), list.getName());
    }

    public void saveEdit() {
        click(By.cssSelector(".js-save-edit"));
    }

    public boolean isThereAList() {
        return wd.findElements(By.cssSelector(".placeholder")).size() > 0;
    }


}
