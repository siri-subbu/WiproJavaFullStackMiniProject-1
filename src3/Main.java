import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\nMAIN MENU");
            System.out.println("---------");
            System.out.println("1. Interest Calculator - SB");
            System.out.println("2. Interest Calculator - FD");
            System.out.println("3. Interest Calculator - RD");
            System.out.println("4. Exit");
            System.out.print("Enter your option (1..4): ");

            choice = sc.nextInt();

            try {

                switch (choice) {

                    case 1:

                        System.out.print("Enter the Average amount in your account: ");
                        double sbAmount = sc.nextDouble();

                        if (sbAmount < 0)
                            throw new InvalidAmountException("Invalid Amount. Please enter non-negative values.");

                        System.out.print("Enter Account Type (1-Normal, 2-NRI): ");
                        int type = sc.nextInt();

                        SBAccount sb = new SBAccount(sbAmount, type);

                        System.out.println("Interest gained: Rs. " + sb.calculateInterest());

                        break;

                    case 2:

                        System.out.print("Enter the FD amount: ");
                        double fdAmount = sc.nextDouble();

                        if (fdAmount < 0)
                            throw new InvalidAmountException("Invalid Amount. Please enter non-negative values.");

                        System.out.print("Enter the number of days: ");
                        int days = sc.nextInt();

                        if (days < 0)
                            throw new InvalidAmountException("Invalid Number of days. Please enter non-negative values.");

                        System.out.print("Enter your age: ");
                        int age = sc.nextInt();

                        if (age < 0)
                            throw new InvalidAmountException("Invalid Age. Please enter non-negative values.");

                        FDAccount fd = new FDAccount(fdAmount, days, age);

                        System.out.println("Interest gained is: Rs. " + fd.calculateInterest());

                        break;

                    case 3:

                        System.out.print("Enter the Monthly Amount: ");
                        double monthlyAmount = sc.nextDouble();

                        if (monthlyAmount < 0)
                            throw new InvalidAmountException("Invalid Amount. Please enter non-negative values.");

                        System.out.print("Enter the number of months (6/9/12/15/18/21): ");
                        int months = sc.nextInt();

                        if (months < 0)
                            throw new InvalidAmountException("Invalid Number of months. Please enter non-negative values.");

                        System.out.print("Enter your age: ");
                        age = sc.nextInt();

                        if (age < 0)
                            throw new InvalidAmountException("Invalid Age. Please enter non-negative values.");

                        RDAccount rd = new RDAccount(monthlyAmount, months, age);

                        System.out.println("Interest gained is: Rs. " + rd.calculateInterest());

                        break;

                    case 4:

                        System.out.println("Thank you!");
                        break;

                    default:

                        System.out.println("Invalid Choice.");

                }

            } catch (InvalidAmountException e) {

                System.out.println(e.getMessage());

            }

        } while (choice != 4);

        sc.close();
    }
}