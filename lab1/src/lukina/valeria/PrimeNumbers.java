package lukina.valeria;

import java.math.BigInteger;

class PrimeNumbers {
    public static void main(String[] args) {                   
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
