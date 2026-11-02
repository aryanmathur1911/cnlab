import java.util.Scanner;

class Queue{
    int[] q;
    int f = 0, r = 0;

    Scanner sc = new Scanner(System.in);

    public void insert(int n){
        q = new int[10];

        for(int i=0; i<n; i++){
            System.out.print("Enter the element "+i+" : ");
            int ele = sc.nextInt();

            if(r+1 > 3){
                System.out.println("Queue full / Lost packet : "+ele);
                break;
            }
            else{
                r++;
                q[i] = ele;
            }
        }
    }

    public void delete(){
        Thread t = new Thread();

        if(r == 0)
            System.out.println("Empty Queue");
        else{
            for(int i=f; i<r; i++){
                try{
                    t.sleep(1000);
                }
                catch(Exception e){}

                System.out.println("Leaked Packet : "+q[i]);
            }
            System.out.println();
        }
    }
}

public class Leaky extends Thread
{
    public static void main (String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        Queue q = new Queue();

        System.out.print("Enter no. of packets : ");
        int size = sc.nextInt();

        q.insert(size);
        q.delete();
    }    
}
