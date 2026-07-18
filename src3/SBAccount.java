public class SBAccount extends Account {

    private int accountType; // 1 = Normal, 2 = NRI

    public SBAccount(double amount, int accountType) {
        super(amount);
        this.accountType = accountType;
    }

    @Override
    public double calculateInterest() {

        if (accountType == 1)
            interestRate = 4;
        else if (accountType == 2)
            interestRate = 6;
        else
            interestRate = 0;

        return (amount * interestRate) / 100;
    }
}