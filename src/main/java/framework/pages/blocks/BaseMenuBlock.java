package framework.pages.blocks;

import framework.managers.PageManager;
import framework.pages.BasePage;
import framework.pages.СontributionsPage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BaseMenuBlock extends BasePage {
    @FindBy (xpath = ".//div[@class='header__grid']")
    WebElement firstHeaderMenuBlock;
    @FindBy (xpath = ".//a[@class='main-menu__sections-link']")
    List<WebElement> firstHeaderMenusList;

    @Step("Проврка прогрузилось ли верхнее меню")
    public BaseMenuBlock checkHeaderMenuBlock() {
        Assertions.assertTrue(waitUntilElementToBeVisible(firstHeaderMenuBlock).isDisplayed(),
                "Блок меню не прогрузился");
        return this;
    }

    @Step("Перейти в меню {nameOfMenuList}")
    public СontributionsPage clickOnHeaderMenuList(String nameOfMenuList){
        for (WebElement category: firstHeaderMenusList) {
            if (category.getText().contains(nameOfMenuList)){
                waitUntilElementToBeClicable(category).click();
                return pageManager.getPage(СontributionsPage.class);
            }
        }
        Assertions.fail("Категория из базового меню "+ nameOfMenuList + " не найдена");
        return pageManager.getPage(СontributionsPage.class);
    }



}
