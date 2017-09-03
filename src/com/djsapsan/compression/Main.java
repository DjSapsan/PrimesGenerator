package com.djsapsan.compression;

import java.math.BigInteger;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Character> primesArray;

        Primes primes = new Primes();      // работаем с простыми числами

        primesArray = primes.getIntPrimes16();                  // получаем список простых чисел

        primes.systemOut(primesArray);                  // выводим массив на экран

    }
}
