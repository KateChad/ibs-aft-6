package framework.datatest;

import java.util.List;

public class Data {
    String depositAmount;
    String time;
    String depositType;
    List<String> banksList;
    List<String> dipositParametersList;
    String checkCountDeposit;
    String checkBunk;
    String checkBidBank;
    String checkTermBank;
    String checkIncomeBank;

    public Data(String depositAmount, String time, String depositType, List<String> banksList,
                List<String> dipositParametersList, String checkCountDeposit, String checkBunk, String checkBidBank,
                String checkTermBank, String checkIncomeBank) {
        this.depositAmount = depositAmount;
        this.time = time;
        this.depositType = depositType;
        this.banksList = banksList;
        this.dipositParametersList = dipositParametersList;
        this.checkCountDeposit = checkCountDeposit;
        this.checkBunk = checkBunk;
        this.checkBidBank = checkBidBank;
        this.checkTermBank = checkTermBank;
        this.checkIncomeBank = checkIncomeBank;
    }

    public void setDepositAmount(String depositAmount) {
        this.depositAmount = depositAmount;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDepositType(String depositType) {
        this.depositType = depositType;
    }

    public void setBanksList(List<String> banksList) {
        this.banksList = banksList;
    }

    public void setDipositParametersList(List<String> dipositParametersList) {
        this.dipositParametersList = dipositParametersList;
    }

    public void setCheckCountDeposit(String checkCountDeposit) {
        this.checkCountDeposit = checkCountDeposit;
    }

    public void setCheckBunk(String checkBunk) {
        this.checkBunk = checkBunk;
    }

    public void setCheckBidBank(String checkBidBank) {
        this.checkBidBank = checkBidBank;
    }

    public void setCheckTermBank(String checkTermBank) {
        this.checkTermBank = checkTermBank;
    }

    public void setCheckIncomeBank(String checkIncomeBank) {
        this.checkIncomeBank = checkIncomeBank;
    }

    public String getDepositAmount() {
        return depositAmount;
    }

    public String getTime() {
        return time;
    }

    public String getDepositType() {
        return depositType;
    }

    public List<String> getBanksList() {
        return banksList;
    }

    public List<String> getDipositParametersList() {
        return dipositParametersList;
    }

    public String getCheckCountDeposit() {
        return checkCountDeposit;
    }

    public String getCheckBunk() {
        return checkBunk;
    }

    public String getCheckBidBank() {
        return checkBidBank;
    }

    public String getCheckTermBank() {
        return checkTermBank;
    }

    public String getCheckIncomeBank() {
        return checkIncomeBank;
    }
}
