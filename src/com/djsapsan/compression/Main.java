package com.djsapsan.compression;

import java.math.BigInteger;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        BigInteger Number;
        ArrayList<BigInteger> factorsArray;

        Factorization factorization = new Factorization();

        Number = new BigInteger("10");
        factorsArray = factorization.factorsToArray(Number);

        factorization.systemOut(factorsArray);

    }
}
