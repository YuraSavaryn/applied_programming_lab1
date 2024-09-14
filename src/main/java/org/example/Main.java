package org.example;

import java.util.Scanner;

/*
 * Клас, який працює із числами Люка
 * */
class LukaNumbers {
    private final int index;
    private final int number;

    public LukaNumbers(int index, int number) {
        this.index = index;
        this.number = number;
    }

    public int getIndex() {
        return index;
    }

    public int getNumber() {
        return number;
    }

    /*
     * Повертає створений масив чисел Люка
     *
     * @return Масив N чисел Люка
     *  */
    public static LukaNumbers[] initializeArr(int amount) {
        LukaNumbers[] numbers = new LukaNumbers[amount];

        if (1 <= amount)
            numbers[0] = new LukaNumbers(0, 1);
        if (2 <= amount)
            numbers[1] = new LukaNumbers(1, 2);
        for (int i = 2; i < amount; i++) {
            int value = numbers[i - 1].getNumber() + numbers[i - 2].getNumber();
            numbers[i] = new LukaNumbers(i, value);
        }
        return numbers;
    }

    /*
     * Виводить переданий масив чисел Люка
     *
     * @return Noting
     * */
    public static void showNumsLuka(LukaNumbers[] numbers) {
        System.out.println("Numbers of Luka: ");
        for (LukaNumbers num : numbers) {
            System.out.print(num.getNumber() + " ");
        }
    }

    /*
     * Визначає, які серед чисел Люка в масиві закінчуються на задану цифру
     *
     * @return Nothing
     * */
    public static void checkNumsLuka(LukaNumbers[] numbers, int number) {
        System.out.println("\nNumbers with last number - " + number + ": ");
        for (LukaNumbers num: numbers) {
            if (num.getNumber() % 10 == number)
                System.out.println("index " + num.getIndex() + ": " + num.getNumber());
        }
    }
}

/*
 * Головний клас, який шукає які серед N чисел Люка закінчуються на задане число
 *
 * @author -Yura Savarun
 * */
public class Main {
    /*
     * Основна функція, яка виконує поставлену задачу
     * */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Input an amount of numbers Luka: ");
        int n = scan.nextInt();

        LukaNumbers[] nums = LukaNumbers.initializeArr(n);

        System.out.print("Input a number: ");
        int number = scan.nextInt();

        LukaNumbers.showNumsLuka(nums);

        LukaNumbers.checkNumsLuka(nums, number);
    }
}