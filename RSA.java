import java.util.*;
import java.math.*;

class RSA {
    public static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    public static void main(String[] args) {
        int p, q, n, z, d = 0, e;
        int msg;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the message : ");

        msg = sc.nextInt();

        double c;
        BigInteger msgback;
        
        System.out.println("Enter first prime no. :");
        p = sc.nextInt();

        System.out.println("Enter second prime no. :");
        q = sc.nextInt();

        n = p * q;

        z = (p - 1) * (q - 1);

        System.out.println("Value of z : " + z);

        for (e = 2; e < z; e++) {
            if (gcd(e, z) == 1)
                break;
        }

        System.out.println("Value of e : " + e);

        for (int i = 0; i <= 9; i++) {
            int x = 1 + i * z;

            if (x % e == 0) {
                d = x / e;
                break;
            }
        }

        System.out.println("Value of d : " + d);

        c = (Math.pow(msg, e)) % n;
        System.out.println("Encrypted message is : " + c);
        // converting int value of n to BigInteger
        BigInteger N = BigInteger.valueOf(n);
        // converting float value of c to BigInteger
        BigInteger C = BigDecimal.valueOf(c).toBigInteger();
        msgback = (C.pow(d)).mod(N);
        System.out.println("Decrypted message is : "+ msgback);

        sc.close();

    }
}