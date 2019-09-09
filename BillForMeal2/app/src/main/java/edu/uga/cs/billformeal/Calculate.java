package edu.uga.cs.billformeal;

/**
 * This class has a single static method for calculating the bill
 */
public class Calculate {
    public static String CalculateBill(double bill, int partyNum, double tip){
        double pSize = (double) partyNum;
        double amt = (bill*(tip))/pSize;
        String r = "$" + String.format("%.2f", amt);
        System.out.println(r);
        return(r);
    }
}

