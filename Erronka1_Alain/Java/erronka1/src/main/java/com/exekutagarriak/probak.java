package com.exekutagarriak;

import java.text.SimpleDateFormat;

public class probak {
    public static void main(String[] args) {
        garbitu();
        String timeStamp;
        timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new java.util.Date());
        System.out.println(timeStamp);

    }

    private static void garbitu() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
