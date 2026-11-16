
import java.net.*;
import java.io.*;

public class UDPReceiver {
    public static void main(String[] args) throws IOException {
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress serverAddress = InetAddress.getByName("localhost");

        byte[] sendBuffer;
        byte[] receiveBuffer = new byte[1024];

        BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in)
        );

        while (true) {
            System.out.print("Client: ");
            String clientMessage = reader.readLine();
            sendBuffer = clientMessage.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(
                sendBuffer, sendBuffer.length, serverAddress, 9876
            );

            clientSocket.send(sendPacket);

            DatagramPacket receivePacket = new DatagramPacket(
                receiveBuffer, receiveBuffer.length
            );

            clientSocket.receive(receivePacket);

            String serverMessage = new String(
                receivePacket.getData(), 0, receivePacket.getLength()
            );

            System.out.println("Server: " + serverMessage);

            if (clientMessage.equalsIgnoreCase("exit")) {
                System.out.println("Client exited.");
                break;
            }
        }

        clientSocket.close();
    }
}
