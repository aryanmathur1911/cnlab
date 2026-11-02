
import java.util.*;

class CRC {
    public static void divide(int[] data, int[] gen, int len){
        for(int i=0; i<len; i++){
            if(data[i] == 1){
                for(int j = 0; j < gen.length; j++){
                    data[i+j] ^= gen[j];
                }
            }
        }
    }
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int mLen, gLen;

        System.out.println("Enter no. of message bits : ");
        mLen = sc.nextInt();

        System.out.println("Enter no of generator bits : ");
        gLen = sc.nextInt();

        int[] mess = new int[mLen], gen = new int[gLen];

        System.out.println("Enter message(space seperated 0 and 1) : ");
        for(int i=0; i < mLen; i++){
            mess[i] = sc.nextInt();
        }

        System.out.println("Enter generator(space seperated 0 and 1) : ");
        for(int i=0; i < gLen; i++){
            gen[i] = sc.nextInt();
        }
         
        int[] data = new int[mLen + gLen - 1];

        System.arraycopy(mess, 0, data, 0, mLen);

        divide(data, gen, mLen);

        System.out.println("Checksum code is : ");
        System.arraycopy(mess, 0, data, 0, mLen);

        for(int bit : data){
            System.out.println(bit);
        }

        System.out.println();

        //reciver side 

        System.out.println("Enter no. of bits in checksum code : ");
        int clen = sc.nextInt();
        int[] checkSum = new int[clen];

        System.out.println("Enter checksum code(space seperated 0 and 1 : ");
        for(int i=0; i<clen; i++){
            checkSum[i] = sc.nextInt();
        }

        int[] recieved = new int[clen + gLen -1];

        System.arraycopy(checkSum, 0, recieved, 0, clen);

        divide(recieved, gen, clen);

        boolean valid = true;

        for(int bit : recieved){
            if(bit == 1)
                valid = false;
        }

        System.out.println(valid ? "Data stream is valid" : "Data stream is invalid");
    }    
}
