
package com.thiendz.tool.autopadlet.util;

import com.thiendz.tool.autopadlet.util.enums.RandomType;
import java.util.Random;

public class Utils {

    public static final Random RANDOM = new Random();

    public static String randomCustom(int len, String add, String remove, RandomType... randTypes) {

        if (len < 1) {
            len = 10;
        }
        if (add == null) {
            add = "";
        }
        if (remove == null) {
            remove = "";
        }

        StringBuilder sumItUp = new StringBuilder();
        for (int i = 0; i < randTypes.length; i++) {
            RandomType randomType = randTypes[i];
            sumItUp.append(randomType.toString());
        }
        sumItUp.append(add);

        if (sumItUp.length() == 0) {
            return "";
        }

        char[] sumItUpChrs = sumItUp.toString().toCharArray();
        StringBuilder strRandCustom = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char randChr;
            do {
                randChr = sumItUpChrs[RANDOM.nextInt(sumItUpChrs.length)];
            } while (remove.indexOf(randChr) > -1);
            strRandCustom.append(randChr);
        }
        return strRandCustom.toString();
    }
    
    public static void sleep(long milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
        }
    }
}
