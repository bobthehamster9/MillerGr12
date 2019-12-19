package me.Jack.Projects.Arrays;

import java.util.Scanner;

public class PrintACheque {
    public void run() {
    Scanner scanner = new Scanner(System.in);
	int iChqAmount, iPennies, iTens, iDollars, iHundreds, iBlockOf3, iSection;
	String [] hundreds = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	String [] tens = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	double dChqAmount;
	String sPennies = "";
	String sSectionPhrase = "";
	StringBuilder sChqPhrase = new StringBuilder();

	System.out.print("Please enter the Amount for the Cheque: ");
	dChqAmount = scanner.nextDouble();
	iChqAmount = (int) (dChqAmount * 100);
	if (iChqAmount < 0){ iChqAmount *= -1;}

	iPennies = iChqAmount % 100;
	sPennies = "" + iPennies;
	if (sPennies.length() == 1){ sPennies = "0" + sPennies;}
	iChqAmount /= 100;
	if (iChqAmount == 0) {
	    sChqPhrase = new StringBuilder("Zero ");
	} else {
	    for (iSection = 1; iSection <= 2; iSection++) {

		iBlockOf3  = iChqAmount % 1000;
		iChqAmount /= 1000;
		sSectionPhrase = "";
		iTens      = iBlockOf3 % 100;
		iDollars   = iBlockOf3 % 10;
		iHundreds  = iBlockOf3 / 100;

		sSectionPhrase += hundreds[iHundreds + iSection - 2] + " ";
		if (iHundreds > 0)  sSectionPhrase += "Hundred ";

		if (iTens >= 20) {
		    iTens /= 10;
		    sSectionPhrase += tens[iTens + iSection - 3] + " ";
		    sSectionPhrase += hundreds[iDollars + iSection - 2] + " ";
	    
		} else {
		    sSectionPhrase += hundreds[iTens];
		}

		if (iBlockOf3 > 0) {
			if (iSection == 2) sChqPhrase.insert(0, sSectionPhrase + "Thousand ");
			else sChqPhrase.append(sSectionPhrase);
			}
	    }
	    System.out.println("\n\nThe amount in words would be:\n\t" + sChqPhrase + "Dollars and " + sPennies + " Cents");
	}
    } // main method
} // PrintACheque class
