package com.djsapsan.compression;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by Арсен Кулиш on 20.08.2017.
 * пока юзаю только 256-битные числа
 * 115792089237316195423570985008687907853269984665640564039457584007913129639936
 */
public class Factorization {

    public boolean primes16[] = new boolean[65533]; //массив простых чисел от 3 до 65536

    public static final BigInteger MAX256 = new BigInteger("115792089237316195423570985008687907853269984665640564039457584007913129639936");
    public static BigInteger TWO = new BigInteger("2");

    public ArrayList<BigInteger> factorsToArray(BigInteger n) {

        ArrayList<BigInteger> factorsArray = new ArrayList<>(); // возвращаемый массив

        System.out.print("Calculating factors of " + n + " ... ");  // лог

        while (n.mod(TWO).compareTo(BigInteger.ZERO) == 0) {       // проверка на четность ( n mod 2 == 0 )   TODO поигратся с младшими нулевыми битами
            factorsArray.add(TWO);
            n = n.divide(TWO);
        }                                  // разделить число на 2

        BigInteger factor = new BigInteger("3");            // проверка делителей до кореня числа TODO прикрутить массив простых чисел для ускорения

        while (factor.multiply(factor).compareTo(n) != 0) {         //TODO сделать правильную проверку
            if (n.mod(factor).compareTo(BigInteger.ZERO) == 0) {
                factorsArray.add(factor);
                n = n.divide(factor);
            }
            factor = factor.add(TWO);
        }

        if (n.compareTo(BigInteger.ZERO) != 0) factorsArray.add(factor);
        else System.out.println();
        return factorsArray;
    }

    public void systemOut(ArrayList<BigInteger> arrayList) {
        System.out.println();

        for (BigInteger n :
                arrayList) {
            System.out.println(n);
        }
    }

    /**
     * <p>Проверяет, простое ли число.</p>
     * Алгортим проверяет все нечетные числа до кореня заданного, чтобы найти делителя.
     * Если делителя не найдено, то число простое.
     * @param number число, которе нужно проверить на простоту (максимум 65536)
     * @return true, если число простое
     */
    private boolean isPrime16bit(int number){
        if(number%2==0) return false;
        for (int i = 3; i*i <= number; i+=2) {
            if(number%i==0) return false;
        }
        return true;
    }

    /**
     * <p>Генерирует простые числа до 65536 в бинарный массив</p>
     * @return бинарный массив, где n является простым, если его значение true
     */
    private boolean[] generatePrimes16bit(){
        boolean arrayPrimes[] = new boolean[65533]; //массив простых чисел от 3 до 65536
        for (int i = 3; i < 65533; i++) {
            arrayPrimes[i] = isPrime16bit(i);
        }
        return arrayPrimes;
    }

    public boolean newFilePrimes16bit() throws IOException {
        RandomAccessFile file = new RandomAccessFile("primes16.bin","w");



        return true;
    }


}
