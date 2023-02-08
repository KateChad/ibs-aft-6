import framework.datatest.Data;
import framework.datatest.PackageData;
import framework.pages.CalculationFormPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class BankiTest extends BaseTests {

    static Data[] dataPack() {
        return new Data[]{
                packageData.getPack2(),packageData.getPack1(),
        };
    }

    @ParameterizedTest
    @MethodSource("dataPack")
    @DisplayName("Проверка калькулятора доходности")
    public void bankiTest(Data data) {
        pageManager.getPage(CalculationFormPage.class)
                .getBaseMenuBlock()
                .checkHeaderMenuBlock()
                .clickOnHeaderMenuList("Вклады")
                .checkDownoldPage()
                .clickCalculation()
                .checkCalculation()
                .inputDepositAmount(data.getDepositAmount())
                .checkDepositAmount(data.getDepositAmount())
                .selectParameterFromDropDownList("Срок", data.getTime())
                .checkParametrFromDropDownList("Срок", data.getTime())
                .selectParameterFromDropDownList("Тип вклада", data.getDepositType())
                .checkParametrFromDropDownList("Тип вклада", data.getDepositType())
                .selectBanks(data.getBanksList())
                .checkBanks(data.getBanksList())
                .selectParameters(data.getDipositParametersList())
                .checkSelectParameters(data.getDipositParametersList())
                .checkCountDepositsInButton(data.getCheckCountDeposit())
                .showResult()
                .closeModalWindow()
                .checkSearchResult(data.getCheckCountDeposit())
                .checkСontribution(data.getCheckBunk(), data.getCheckBidBank(), data.getCheckTermBank(),
                        data.getCheckIncomeBank());
    }
}
