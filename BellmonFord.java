import java.util.Scanner;

public class BellmonFord {

    static final int MAX_VAL = 999;

    int D[], n;

    public BellmonFord(int n) {
        this.n = n;
        D = new int[n + 1];
    }

    void shortest(int s, int A[][]) {
        // Initialize the D array
        for (int i = 0; i <= n; i++) {
            D[i] = MAX_VAL;
        }

        D[s] = 0;

        for (int k = 1; k < n; k++) { // perform relaxation 1 to (n-1) times
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (D[i] != MAX_VAL && A[i][j] != MAX_VAL && D[j] > D[i] + A[i][j]) {
                        D[j] = D[i] + A[i][j];
                    }
                }
            }
        }

        //after relaxations if graph still has a possiblity of relaxation mean it has a negative cycle
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                if (A[i][j] != MAX_VAL && D[i] != MAX_VAL && D[j] > D[i] + A[i][j]) {
                    System.out.println("The Graph contains a negative edge cycle");
                    return;
                }

        for(int i=1; i<=n; i++){
            System.out.println("Distance of source "+s+" to "+i+ " : " + D[i]);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the no of vertices : ");
        int n = sc.nextInt();

        int A[][] = new int[n+1][n+1];

        System.out.println("Enter weighted matrix : ");

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++) {
                A[i][j] = sc.nextInt();
                if (i == j) A[i][j] = 0;
                else if (A[i][j] == 0) A[i][j] = MAX_VAL;
            }

        System.out.println("Enter the source vertex");
        int s = sc.nextInt();

        BellmonFord b = new BellmonFord(n);

        b.shortest(s, A);

    }
}
