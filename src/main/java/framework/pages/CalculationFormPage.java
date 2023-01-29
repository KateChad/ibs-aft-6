package framework.pages;

import framework.pages.blocks.BaseMenuBlock;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CalculationFormPage extends BasePage {
    private BaseMenuBlock baseMenuBlock = new BaseMenuBlock();

    @FindBy(xpath = ".//div[@direction='vert']//input[@name ='amount']")
    WebElement depositAmountInput;
    @FindBy(xpath = ".//div[@direction='vert']//div[@data-test='dropdown']")
    List<WebElement> dropDownList;
    @FindBy(xpath = ".//div[@direction='vert']//div[@data-test='dropdown']//li/div")
    List<WebElement> dropDownListContainsText;
    @FindBy(xpath = ".//div[@direction='vert']//div[@data-placement='bottom']//li//label")
    List<WebElement> dropDownListOfBank;
    @FindBy(xpath = ".//div[@direction='vert']//label[contains(text(),'Банки')]//../input")
    WebElement inputBank;
    @FindBy(xpath = ".//div[@direction='vert']//label[contains(@class,'Checkbox')]")
    List<WebElement> checkboxWithParametrs;
    @FindBy(xpath = ".//div[contains(@class,'ModalBody')]//button")
    WebElement buttonShow;

    @Step("Ввод суммы вклада")
    public CalculationFormPage inputDepositAmount(String depositAmount) {
        waitUntilElementToBeClicable(depositAmountInput).sendKeys(depositAmount);
        return this;
    }

    @Step("Проверка ввода суммы вклада")
    public CalculationFormPage checkDepositAmount(String depositAmount) {
        Assertions.assertEquals(depositAmount, waitUntilElementToBeClicable(depositAmountInput)
                        .getAttribute("value").replaceAll("[^0-9]", ""),
                "Невернна введенна сумма вклада");
        return this;
    }

    @Step("Выбрать в {nameOfDropDown} параметр {selectParameter}")
    public CalculationFormPage selectParameterFromDropDownList(String nameOfDropDown, String selectParameter) {
        for (WebElement dropDownElement : dropDownList) {
            if (dropDownElement.findElement(By.xpath(".//../label"))
                    .getText().contains(nameOfDropDown)) {
                WebElement dropDownButton = dropDownElement.findElement(By
                        .xpath(".//div[@data-test='dropdown-button']"));
                waitUntilElementToBeClicable(dropDownButton).click();
                for (WebElement textInDropDownElement : dropDownListContainsText) {
                    if (textInDropDownElement.getText().contains(selectParameter)) {
                        waitUntilElementToBeClicable(textInDropDownElement).click();
                        return this;
                    }
                }
            }
        }
        Assertions.fail("Выпадающий список " + nameOfDropDown + " не найден");
        return this;
    }

    @Step("Проверка значения в поле {nameOfDropDown} параметр {selectParametr}")
    public CalculationFormPage checkParametrFromDropDownList(String nameOfDropDown, String selectParametr) {
        for (WebElement dropDownElement : dropDownList) {
            if (dropDownElement.findElement(By.xpath(".//../label"))
                    .getText().contains(nameOfDropDown)) {
                Assertions.assertEquals(selectParametr, dropDownElement
                        .findElement(By.xpath(".//div[@direction='row']//span"))
                        .getText(), "Значение параметра не верное");
                return this;
            }
        }
        Assertions.fail("Выпадающий список " + nameOfDropDown + " не найден");
        return this;
    }

    @Step("Выбор банка {nameOfBank}")
    public CalculationFormPage selectBank(String nameOfBank) {
        inputBank.click();
        inputBank.sendKeys(nameOfBank);
        for (WebElement selectParameter : dropDownListOfBank) {
            if (waitUntilElementToBeVisible(selectParameter).getText().contains(nameOfBank)) {
                selectParameter.click();
                inputBank.click();
                return this;
            }
        }

        Assertions.fail("Не найден банк " + nameOfBank);
        return this;
    }

    @Step("Выбор банков {banks}")
    public CalculationFormPage selectBanks(List<String> banks){
        for (String bank : banks) {
            selectBank(bank);
        }
        return this;
    }

    private CalculationFormPage checkSelectBank(String nameOfBank) {
        inputBank.click();
        for (WebElement selectParameter : dropDownListOfBank) {
            if (waitUntilElementToBeVisible(selectParameter).getText().contains(nameOfBank)) {
                waitStabilityPage(5000, 200);
                Assertions.assertTrue(Boolean.parseBoolean(selectParameter
                        .findElement(By.xpath("./input")).getAttribute("checked")), "Элемент не выбран");
                inputBank.click();
                return this;
            }
        }
        Assertions.fail("Не найден банк " + nameOfBank);
        return this;
    }

    @Step("Проверка выбора банков {banks}")
    public CalculationFormPage checkBanks(List<String> banks){
        for (String bank : banks) {
            checkSelectBank(bank);
        }
        return this;
    }

    private CalculationFormPage selectParameter(String nameOfParameter) {
        for (WebElement parameter : checkboxWithParametrs) {
            if (parameter.findElement(By.xpath("./span[2]"))
                    .getText().contains(nameOfParameter)) {
                parameter.click();
                return this;
            }
        }
        Assertions.fail("Чекбокс " + nameOfParameter + " не найден");
        return this;
    }

    @Step("Выбор параметров {parameters}")
    public CalculationFormPage selectParameters(List<String> parameters){
        for (String parameter : parameters) {
            selectParameter(parameter);
        }
        return this;
    }

    @Step("Проверка количества вкладов {countDeposits}")
    public CalculationFormPage checkCountDepositsInButton(String countDeposits) {
        waitStabilityPage(5000, 200);
        Assertions.assertEquals(countDeposits, buttonShow.getText()
                        .replaceAll("[^0-9]", "")
                , "Количество вкладов не равно " + countDeposits);
        return this;
    }

    public СontributionsPage showResult() {
        waitUntilElementToBeClicable(buttonShow).click();
        return pageManager.getPage(СontributionsPage.class);
    }

    public BaseMenuBlock getBaseMenuBlock() {
        return baseMenuBlock;
    }
}
