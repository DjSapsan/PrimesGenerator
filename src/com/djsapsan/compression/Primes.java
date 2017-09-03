package com.djsapsan.compression;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.BitSet;

/** <p>Класс для работы с простыми числами</p>
 * <p>Методы позволяют генерировать простые числа в файлы и массивы, проверять простоту числа и другое</p>
 * <p> version 1.0 - loop repeating:379575. Average repeats for every number: 58</p>
 */
public class Primes {

    private ArrayList<Character> intPrimes16 = new ArrayList<Character>();       // массив простых целых чисел от 2 до 65536
    private BitSet boolPrimes16 = new BitSet(65535);                       // булевый массив простых чисел от 2 до 65536
    private int loopRepeating = 0;

    public Primes() {
        generatePrimes16bit();  //TODO если нет массива, то сгенерировать иначе игнор
    }

    public ArrayList<Character> getIntPrimes16() {
        return intPrimes16;
    }

    /**
     * <p>Генерирует простые числа до 65536 в бинарный массив</p>
     */
    private void generatePrimes16bit() {
        boolPrimes16.set(0);    intPrimes16.add((char)2);                      // число 2 простое
        boolPrimes16.set(1);    intPrimes16.add((char)3);                      // число 3 простое

        for (int i = 5; i < 65536; i+=2) {          // перебираем числа от 3 до 65536
            if(isPrime16bit(i)) {
                boolPrimes16.set(i-2);
                intPrimes16.add((char)i);
            }
        }
    }

    /**
     * <p>Проверяет, простое ли число.</p>
     * Алгортим проверяет все нечетные числа заданного включительно, чтобы найти делителя.
     * Если делителя не найдено, то число простое.
     * <p>Четные числа лучше не проверять</p>
     * @param number число, которе нужно проверить на простоту (максимум 65536)
     * @return true, если число простое
     */
    private boolean isPrime16bit(int number) {
        //if (number % 2 == 0) return false;                          // если четное - игнорим
        for (int i = 0; intPrimes16.get(i)*intPrimes16.get(i) <= number; i++) {
            if (number % intPrimes16.get(i) == 0) return false;         // если делится на простое, то это не простое
            loopRepeating++;
        }
        return true;
    }

    /**
     * <p> выводит массив на экран</p>
     * @param arrayList массив на вывод
     */
    public void systemOut(ArrayList<Character> arrayList) {
        System.out.println("loop repeating:" + loopRepeating + ". Average repeats for every number: " + loopRepeating/intPrimes16.size());

        for (Character n :
                arrayList) {
            System.out.println((int)n);
        }
    }

    public boolean newFilePrimes16bit() throws IOException {
        RandomAccessFile file = new RandomAccessFile("primes16.bin", "w");


        return true;
    }


}
