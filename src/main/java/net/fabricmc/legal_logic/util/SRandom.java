package net.fabricmc.legal_logic.util;

import java.util.Random;

public class SRandom {
    public int GetRInt(int min,int max) {
        return new Random().nextInt(max - min) + min;
    }
}