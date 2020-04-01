package xyz.moheng.taoist_nature.util;

import java.util.Random;

public class SRandom {
    public static int GetRInt(int min,int max) {
        return new Random().nextInt(max - min) + min;
    }
}