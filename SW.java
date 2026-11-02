public class SW {
    int winSize, totalPackets, currPacket;

    SW(int ws, int tp) {
        this.winSize = ws;
        this.totalPackets = tp;
        this.currPacket = 0;
    }

    public void recieveAck() {
        System.out.println("Recieved Acknowledgement for Packet : " + currPacket);
    }

    public void sendPackets() {
        while (currPacket < totalPackets) {
            for (int i = 0; i < winSize && currPacket < totalPackets; i++) {
                System.out.println("Packet Sent : " + currPacket++);
            }
            recieveAck();
        }

    }

    public static void main(String[] args) {
        int winSize = 4, totalPackets = 10;

        SW sw = new SW(winSize, totalPackets);

        sw.sendPackets();
    }
}
