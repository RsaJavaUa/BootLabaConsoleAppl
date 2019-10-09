package com.example.demo.services;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class UserInputService {
    public int userInputHowToCreateNecklace() {
        while (true) {
            System.out.println("How to create necklace? 1. - manually from console; 2. - randomly by program");
            int userInput = new Scanner(System.in).nextInt();
            if (userInput < 0 || userInput > 3) {
                System.out.println("Incorrect input. Please try again");
            } else {
                return userInput;
            }
        }
    }

    public int userInputStoneType() {
        while (true) {
            System.out.println("Enter what type of stone you want to add to necklace. 1.- diamond; 2. - amethyst; " +
                    "3. - opal; 4. - exit menu(interrupt program)");
            int userInput = new Scanner(System.in).nextInt();
            if (userInput < 0 || userInput > 4) {
                System.out.println("Incorrect input. Please try again");
            } else {
                return userInput;
            }
        }
    }

    public int userInputStoneQuantity() {
        while (true) {
            System.out.println("Enter what stone quantity you want to add to necklace. Positive number below 30.");
            int userInput = new Scanner(System.in).nextInt();
            if (userInput < 0 || userInput > 30) {
                System.out.println("Incorrect input. Please try again");
            } else {
                return userInput;
            }
        }
    }

    public int userInputContinueLoop() {
        while (true) {
            System.out.println("Do you want to continue adding stones to you necklace? 1. - yes;  2. - no");
            int userInput = new Scanner(System.in).nextInt();
            if (userInput < 0 || userInput > 2) {
                System.out.println("Incorrect input. Please try again");
            } else {
                return userInput;
            }
        }
    }

    public int chooseAction() {
        while (true) {
            System.out.println("Choose action: 1. - Total price of necklace;  2. - Total size of stones; " +
                    "3 - Sort stones by price; 4 - Filter by transparency range; 5 - Print necklace; 6 - Exit.");
            int userInput = new Scanner(System.in).nextInt();
            if (userInput < 0 || userInput > 6) {
                System.out.println("Incorrect input. Please try again");
            } else {
                return userInput;
            }
        }
    }

    public double[] chooseTransparencyRange() {
        while (true) {
            System.out.println("Enter transparency range to filter stones. Enter first number. From 0 to  99");
            int firstInput = new Scanner(System.in).nextInt();
            System.out.println("Enter transparency range to filter stones. Enter second number. From 0 to  99");
            int secondInput = new Scanner(System.in).nextInt();
            if (firstInput < 0 || firstInput > 99 || secondInput > 99 || secondInput < 0) {
                System.out.println("Incorrect input. Please try again");
            } else {
                return userInputIntoArray(firstInput, secondInput);
            }
        }
    }

    private double[] userInputIntoArray(int firstNumber, int secondNumber) {
        int temp;
        if (firstNumber < secondNumber) {
            return new double[]{(Math.round(firstNumber) / 100.0), (Math.round(secondNumber) / 100.0)};
        } else {
            temp = firstNumber;
            firstNumber = secondNumber;
            secondNumber = temp;
            return new double[]{(Math.round(firstNumber) / 100.0), (Math.round(firstNumber) / 100.0)};
        }
    }
}
