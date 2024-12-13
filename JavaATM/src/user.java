import java.util.ArrayList;
import java.util.List;

public class user{
    private String accountNumber;
    private String holderName;
    private String pin;
    private double CheckingBalance;
    private double SavingsBalance;
    

    public user(String accountNumber, String holderName, String pin, double CheckingBalance, double SavingsBalance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.pin = pin;
        this.CheckingBalance = CheckingBalance;
        this.SavingsBalance = SavingsBalance;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public String getHolderName(){
        return holderName;
    }

    public String getPin(){
        return pin;
    }

    public double getCheckingBalance(){
        return CheckingBalance;
    }

    public double getSavingsBalance(){
        return SavingsBalance;
    }

    public void setCheckingBalance(double CheckingBalance){
        this.CheckingBalance = CheckingBalance;
    }

    public void setSavingsBalance(double SavingsBalance){
        this.SavingsBalance = SavingsBalance;
    }

    public boolean validatePin(String pin){
        return this.pin.equals(pin);
    }

    public boolean withdraw(double amount, String accountType){
        if (accountType.equals("Checking")){
            if (CheckingBalance >= amount){
                CheckingBalance -= amount;
                return true;
            }
        } else if (accountType.equals("Savings")){
            if (SavingsBalance >= amount){
                SavingsBalance -= amount;
                return true;
            }
        }
        return false;
    }

    public boolean transferFunds(double amount, String targetAccountType){
        if (targetAccountType.equalsIgnoreCase("saving")&& CheckingBalance >= amount){
            SavingsBalance += amount;
            CheckingBalance -= amount;
            return true;
        } else if (targetAccountType.equalsIgnoreCase("checking") && SavingsBalance >= amount){
            CheckingBalance += amount;
            SavingsBalance -= amount;
            return true;
        }
        return false;
    })))
    }

)

}