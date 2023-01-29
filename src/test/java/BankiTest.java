import framework.datatest.Data;
import framework.datatest.PackageData;
import framework.pages.CalculationFormPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

public class BankiTest extends BaseTests {
    PackageData pack = new PackageData();
    Data data = pack.getPack2();

    @Test
    @DisplayName("Проверка калькулятора доходности")
    public void bankiTest() {
        pageManager.getPage(CalculationFormPage.class)
                .getBaseMenuBlock()
                .checkHeaderMenuBlock()
                .clickOnHeaderMenuList("Вклады")
                .checkDownoldPage()
                .clickCalculation()
                .checkCalculation()
                .inputDepositAmount(data.getDepositAmount())
                .checkDepositAmount(data.getDepositAmount())
                .selectParametrFromDropDownList("Срок", data.getTime())
                .checkParametrFromDropDownList("Срок", data.getTime())
                .selectParametrFromDropDownList("Тип вклада", data.getDepositType())
                .checkParametrFromDropDownList("Тип вклада", data.getDepositType());

        for (String bank : data.getBanksList()) {
            pageManager.getPage(CalculationFormPage.class)
                    .selectBank(bank)
                    .checkSelectBank(bank);
        }

        //дописать проверки на клик по чекбоксам, не могу найти изменения в html
        for (String parameters : data.getDipositParametersList()) {
            pageManager.getPage(CalculationFormPage.class).selectParameter(parameters);
        }
        pageManager.getPage(CalculationFormPage.class)
                .checkCountDepositsInButton(data.getCheckCountDeposit())
                .showResult()
                .checkSearchResult(data.getCheckCountDeposit())
                .closeModalWindow()
                .checkСontribution(data.getCheckBunk(), data.getCheckBidBank(), data.getCheckTermBank(),
                        data.getCheckIncomeBank());
        //проверка по срокам
    }
}
