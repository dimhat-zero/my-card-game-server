package org.dimhat.hearthstone.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.Collections.swap;

/**
 * fisher yates洗牌算法
 */
public class FisherYatesShuffle implements Shuffle {

    @Override
    public void shuffle(List list) {
        Random random = new Random();
        int len = list.size();
        while(len-->1){
            int swapIndex = random.nextInt(len+1);
            swap(list,len,swapIndex);
        }
    }


    public static void main(String[] args){

        Shuffle shuffle  = new FisherYatesShuffle();

        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);

        shuffle.shuffle(list);
        System.out.println(list);
    }
}
