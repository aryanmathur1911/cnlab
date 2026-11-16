
import java.util.Random;
import java.util.Scanner;

public class StopAndWaitProtocol {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Stop-and-Wait Protocol Simulation\n");

        int frame = 0;
        boolean ackReceived;

        while (true) {
            System.out.print("Send frame " + frame + "? (y/n): ");
            String input = scanner.nextLine().toLowerCase();

            if (input.equals("n")) {
                System.out.println("Exiting protocol simulation.");
                break;
            }

            System.out.println("Sending frame " + frame + "...");

            if (random.nextInt(10) < 2) {
                System.out.println("Frame " + frame + " lost during transmission.");
                continue;
            } else {
                System.out.println("Frame " + frame + " sent successfully.");
            }

            ackReceived = false;

            if (random.nextInt(10) < 2) {
                System.out.println("Acknowledgment for frame " + frame + " lost.");
            } else {
                System.out.println("Acknowledgment for frame " + frame + " received.");
                ackReceived = true;
            }

            if (ackReceived) {
                frame++;
            } else {
                System.out.println("Resending frame " + frame + "...");
            }
        }

        scanner.close();
        System.out.println("Protocol simulation ended.");
    }
}
