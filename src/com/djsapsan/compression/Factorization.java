package com.djsapsan.compression;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by Арсен Кулиш on 20.08.2017.
 * пока юзаю только 256-битные числа
 * Max 256 bit number:
 * 115792089237316195423570985008687907853269984665640564039457584007913129639936
 * <p>
 * Логика класса:
 * До начала работы нужно сгенерировать бинарный файл простых числел до 65536. Для контроля используется статическая переменная.
 * Затем можно получить массив простых чисел в любом виде.
 */
public class Factorization {

    public static final BigInteger MAX256 = new BigInteger("115792089237316195423570985008687907853269984665640564039457584007913129639936");

    public static boolean isFileExist = false;           // существует ли бинарный файл
    private static boolean isBooleanArrayExist = false;  // просчитан ли бинарный массив

    public static BigInteger TWO = new BigInteger("2");

    Primes primes = new Primes();

    /**
     * @param n Максимальное число до которого происходит поиск простых числе
     * @return Возворащает простые числа в виде массива ArrayList (BigInteger)
     */
    public ArrayList<BigInteger> factorsToArray(BigInteger n) {

        ArrayList<BigInteger> factorsArray = new ArrayList<>(); // возвращаемый массив

        //for (int i = 0; i < 6541; i++) {        // заглушка
         //   if (boolPrimes16[i]) factorsArray.add(new BigInteger(Integer.toString(i+2)));
        //}

//
//        System.out.print("Calculating factors of " + n + " ... ");  // лог
//
//        while (n.mod(TWO).compareTo(BigInteger.ZERO) == 0) {       // проверка на четность ( n mod 2 == 0 )   TODO поигратся с младшими нулевыми битами
//            factorsArray.add(TWO);
//            n = n.divide(TWO);
//        }                                  // разделить число на 2
//
//        BigInteger factor = new BigInteger("3");            // проверка делителей до кореня числа TODO прикрутить массив простых чисел для ускорения
//
//        while (factor.multiply(factor).compareTo(n) != 0) {         //TODO сделать правильную проверку
//            if (n.mod(factor).compareTo(BigInteger.ZERO) == 0) {
//                factorsArray.add(factor);
//                n = n.divide(factor);
//            }
//            factor = factor.add(TWO);
//        }
//
//        if (n.compareTo(BigInteger.ZERO) != 0) factorsArray.add(factor);
//        else System.out.println();
        return factorsArray;
    }








}
