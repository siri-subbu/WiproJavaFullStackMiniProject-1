public class FDAccount extends Account {

    private int noOfDays;
    private int ageOfACHolder;

    public FDAccount(double amount, int noOfDays, int ageOfACHolder) {
        super(amount);
        this.noOfDays = noOfDays;
        this.ageOfACHolder = ageOfACHolder;
    }

    @Override
    public double calculateInterest() {

        if (amount < 10000000) {

            if (ageOfACHolder >= 60) {

                if (noOfDays >= 7 && noOfDays <= 14)
                    interestRate = 5.0;
                else if (noOfDays >= 15 && noOfDays <= 29)
                    interestRate = 5.25;
                else if (noOfDays >= 30 && noOfDays <= 45)
                    interestRate = 6.0;
                else if (noOfDays > 45 && noOfDays <= 60)
                    interestRate = 7.5;
                else if (noOfDays >= 61 && noOfDays <= 184)
                    interestRate = 8.0;
                else if (noOfDays >= 185 && noOfDays <= 365)
                    interestRate = 8.5;

            } else {

                if (noOfDays >= 7 && noOfDays <= 14)
                    interestRate = 4.5;
                else if (noOfDays >= 15 && noOfDays <= 29)
                    interestRate = 4.75;
                else if (noOfDays >= 30 && noOfDays <= 45)
                    interestRate = 5.5;
                else if (noOfDays > 45 && noOfDays <= 60)
                    interestRate = 7.0;
                else if (noOfDays >= 61 && noOfDays <= 184)
                    interestRate = 7.5;
                else if (noOfDays >= 185 && noOfDays <= 365)
                    interestRate = 8.0;
            }

        } else {

            if (noOfDays >= 7 && noOfDays <= 14)
                interestRate = 6.5;
            else if (noOfDays >= 15 && noOfDays <= 29)
                interestRate = 6.75;
            else if (noOfDays >= 30 && noOfDays <= 45)
                interestRate = 6.75;
            else if (noOfDays > 45 && noOfDays <= 60)
                interestRate = 8.0;
            else if (noOfDays >= 61 && noOfDays <= 184)
                interestRate = 8.5;
            else if (noOfDays >= 185 && noOfDays <= 365)
                interestRate = 10.0;
        }

        return (amount * interestRate) / 100;
    }
}