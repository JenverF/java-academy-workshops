package com.pluralsight.Calculators;

public class FinancialCalculators {
    static void main() {
        // Mortgage Calc
        double principal = 53000; // P
        double interestRate = 7.625; // r
        double monthlyInterestRate = interestRate / 100 / 12;
        int loanLength = 15;
        int loanLengthInMonths = loanLength * 12;

        double monthlyPayment = principal * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, loanLengthInMonths)) / ((Math.pow(1 + monthlyInterestRate, loanLengthInMonths)) - 1);

        double totalInterestPaid = monthlyPayment * loanLengthInMonths - principal;
        System.out.println("Monthly Payment: " + monthlyPayment);
        System.out.println("Total interest paid: " + totalInterestPaid);

        // Compound Interest Calc
        double principal2 = 1000;
        double interestRate2 = 1.75/100;
        int nrOfYears = 5;

        double futureValue = principal2 * Math.pow(1 + interestRate2 / 365, 365 * nrOfYears);
        System.out.println(futureValue);

        // Present Value Calc
        double monthlyPayment2 = 3000;
        int nrOfYears2 = 20;
        int nrOfMonths = nrOfYears2 * 12;
        double monthlyInterest = 2.5 / 100 / 12;

        double presentValue = monthlyPayment2 * (1 - (1/Math.pow(1 + monthlyInterest, nrOfMonths))) / monthlyInterest;
        System.out.println(presentValue);
    }
}
