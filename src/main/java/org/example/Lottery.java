package org.example;

import java.util.PriorityQueue;
import java.util.Random;

public class Lottery {
    public Toy startLottery (PriorityQueue<Toy> lotteryQueue) {
        int freqSum = 0;
        Random r = new Random();
        int random = r.nextInt(100) + 1;
        //System.out.println("[" + random + "]");
        for (Toy item : lotteryQueue) {
            freqSum += item.getDropFrequency();
            if (random <= freqSum) {
                return item;
            }
        }
        return null;
    }

    public boolean checkToys (PriorityQueue<Toy> lotteryQueue) {
        int freqSum = 0;
        for (Toy item : lotteryQueue) {
            freqSum += item.getDropFrequency();
        }
        if (freqSum == 100)
            return true;
        else
            return false;
    }
}
