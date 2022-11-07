package com.exekutagarriak;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class RandomString {

  static String getAlphaNumericString(int n) {

    String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

    StringBuilder sb = new StringBuilder(n);

    for (int i = 0; i < n; i++) {
      int index = (int) (AlphaNumericString.length() * Math.random());

      sb.append(AlphaNumericString.charAt(index));
    }
    return sb.toString();
  }

  public static void main(String[] args) {

    int produktuKopurua = 2000;  // <------------------------------- Balio hau aldatu
    String produktua = "";

    String strFileOut = "data/importazioak/produktuakR.csv";

    try (PrintWriter outputStream = new PrintWriter(new FileWriter(strFileOut))) {
      outputStream.println("ID;IZENA;STOCKA;PREZIOA");
      for (int i = 0; i < produktuKopurua; i++) {
        int id = i;
        int n = 20;
        
        Random r = new Random();
        int low = 1;
        int high = 1000;
        int prezioa = r.nextInt(high - low) + low;
        int stocka = r.nextInt(high - low) + low;

        produktua = id + ";" + RandomString.getAlphaNumericString(n)+ ";" + stocka + ";" + prezioa;

        outputStream.println(produktua);
      }
    } catch (IOException e) {
      System.out.println(strFileOut + " fitxategiarekin arazoren bat egon da.");
    }
  }
}