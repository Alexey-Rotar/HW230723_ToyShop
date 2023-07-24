package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Interface {
    public void Menu() throws IOException {
        int parameter;
        Scanner sc = new Scanner(System.in);
        System.out.println("Получение массива игрушек...");
        System.out.println("1 - загрузить из файла;");
        System.out.println("2 - задать вручную;");
        System.out.println("0 - завершение работы.");
        parameter = Integer.parseInt(sc.nextLine());
        Data data = new Data();
        Lottery lottery = new Lottery();
        List<Toy> toyList = new ArrayList<>();
        List<Toy> lotteryList = new ArrayList<>();
        PriorityQueue<Toy> lotteryQueue = new PriorityQueue<>();

        switch (parameter) {
            case 1:
                toyList = data.getToyListFromFile("data.toys");
                System.out.println("Массив игрушек загружен.");
                lotteryList = data.getLotteryList(toyList);
                System.out.println("Задайте вероятность выпадения для игрушек, %:");;
                lotteryQueue = data.getLotteryQueue(data.setFreq(lotteryList));
                break;
            case 2:
                lotteryList = data.getToyListByUser();
                lotteryQueue = data.getLotteryQueue(lotteryList);
                break;
            case 0:
                System.out.println("Работа завершена.");
                System.exit(0);
            default:
                System.out.println("Ошибка при выборе пункта меню!");
        }

    if (lottery.checkToys(lotteryQueue)) {
        System.out.println("Проведение розыгрышей среди игрушек...");
        data.printQueue(lotteryQueue);
        System.out.println("Игрушки-победители:");
        data.writeStampToFile();
        for (int i = 0; i < 9; i++) {
            Toy toyWinner = lottery.startLottery(lotteryQueue);
            System.out.println("* * * " + toyWinner + " * * *");
            data.writeWinnersToFile(toyWinner);
        }
        data.writeWinnersToFile(lottery.startLottery(lotteryQueue));
    }
    else
        System.out.println("Неверно указаны вероятности! Невозможно провести лотерею!");
    }
}
