package service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        try {

            int currencyServicePort = 50001;
            String currencyServiceHostname = "localhost";

            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Please choose which bank server to represent (1/2): ");
            String whichBank = input.readLine();

            System.out.println("Please provide 3 supported currencies: ");
            String[] currencies = input.readLine().split(" ");

            Bank bank = new Bank(whichBank, currencyServiceHostname, currencyServicePort, currencies);
            bank.start();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
