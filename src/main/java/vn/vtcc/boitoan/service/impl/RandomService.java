package vn.vtcc.boitoan.service.impl;

import java.util.Random;

/**
 * Created by TuanAnh on 22/02/2018.
 */
public class RandomService {
    public static final Random RANDOMER = new Random();

    public static int getRandomInt(int maxNumber) {
        return RANDOMER.nextInt(maxNumber) + 1;
    }

    public static int getRandomInt() {
        return RANDOMER.nextInt();
    }
}
