package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Data {
    public List<Toy> getToyListFromFile(String filename) throws IOException {
        List<Toy> toyList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String str;
        String[] tempArray;
        while ((str = br.readLine()) != null) {
            tempArray = str.split(";");
            toyList.add(new Toy(Integer.parseInt(tempArray[0]), tempArray[1], Integer.parseInt(tempArray[2])));
        }
        br.close();
        return toyList;
    }

    public List<Toy> getToyListByUser() {
        int id = 1;
        String name;
        int dropFrequency;
        List<Toy> toyList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (id<4) {
            System.out.println("Добавление игрушки " + id + ": ");
            System.out.print("Введите наименование: ");
            name = sc.next();
            System.out.print("Введите вероятность выпадения: ");
            dropFrequency = Integer.parseInt(sc.next());
            toyList.add(new Toy(id, name, dropFrequency));
            id++;
        }
        return toyList;
    }

    public List<Toy> getLotteryList(List<Toy> toyList) {
        List<Toy> lotteryList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            lotteryList.add(toyList.remove(0));
        }
        return lotteryList;
    }

    public List<Toy> setFreq(List<Toy> lotteryList) {
        int chance;
        Scanner sc = new Scanner(System.in);
        for (Toy item : lotteryList) {
            System.out.print(item + ", вероятность = ");
            chance = Integer.parseInt(sc.nextLine());
            item.setDropFrequency(chance);
        }
        return lotteryList;
    }

    public PriorityQueue<Toy> getLotteryQueue(List<Toy> lotteryList) {
        PriorityQueue<Toy> lotteryQueue = new PriorityQueue<>();
        for (int i = 0; i < 3; i++) {
            lotteryQueue.add(lotteryList.get(i));
        }
        return lotteryQueue;
    }

    public void printQueue (PriorityQueue<Toy> lotteryQueue) {
        for (Toy item : lotteryQueue) {
            System.out.println(item.getId()+ ": " + item.getName() + " (" + item.getDropFrequency() + ")");
        }
    }

    public void writeWinnersToFile (Toy toy){
        try(FileWriter writer = new FileWriter("winners.toys", true))
        {
            writer.write(String.valueOf(toy) + "\n");
            writer.flush();
            writer.close();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void writeStampToFile (){
        Date d = new Date();
        try(FileWriter writer = new FileWriter("winners.toys", true))
        {
            writer.write("Розыгрыш х 10 (" + String.valueOf(d.toString()) + "):\n");
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}