package lukina.valeria;

import java.math.BigInteger;

//import java.util.Scanner;
//ctrl + лкм   реализация методов

class PrimeNumbers {
    public static void main(String[] args) {                    //psvm
        /*
        Scanner input = new Scanner(System.in);
        System.out.println("Please, enter the first point:");   //sout
        int first = input.nextInt();
        System.out.println("Please, enter the second point:");
        int second = input.nextInt();
         */ //ввод с консоли

        BigInteger first = BigInteger.valueOf(0);
        BigInteger second = BigInteger.valueOf(0);

        try {
            first = new BigInteger(args[0]);
            second = new BigInteger(args[1]);
        }
        catch (IllegalArgumentException e){
            System.out.println("Wrong input!");
        }
        printNum(first, second);
    }

    //как называется?
    //почему косячит?
    //исправить?

    static BigInteger three = new BigInteger("3");
    static BigInteger twF = new BigInteger("24");

    static void printNum(BigInteger a, BigInteger b) {
        BigInteger i;
        for (i = a; ; i = i.add(BigInteger.ONE)) {
            if (i.equals(BigInteger.ONE)) continue;
            if (((i.multiply(i)).mod(twF).equals(BigInteger.ONE)) | (i.equals(BigInteger.TWO)) | (i.equals(three))) {
                System.out.println(i);
            }
            if (i.equals(b)) break;
        }
    }
}