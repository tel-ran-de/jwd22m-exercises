import model.Server;
import storage.IServerStorage;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpGatewaySender implements Runnable {
    private final String host;
    private final IServerStorage serverStorage;
    private final int udpToGatewayPort;
    private final int periodMillis;


    public UdpGatewaySender(String host, IServerStorage serverStorage, int udpToGatewayPort, int periodMillis) {
        this.host = host;
        this.serverStorage = serverStorage;
        this.udpToGatewayPort = udpToGatewayPort;
        this.periodMillis = periodMillis;
    }

    @Override
    public void run() {
        try {
            InetAddress inetAddress = InetAddress.getByName(host);
            DatagramSocket udpSocket = new DatagramSocket();
            while (true) {
                try {
                    Thread.sleep(periodMillis);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Server server = serverStorage.getOptimal();
                if (server == null)
                    continue;

                String best = server.toString();

                System.out.println("sending best server to gateway: " + best + ":" + server.getLoad());

                byte[] sendBest = best.getBytes();
                DatagramPacket packetOut = new DatagramPacket(
                        sendBest,
                        sendBest.length,
                        inetAddress,
                        udpToGatewayPort
                );

                udpSocket.send(packetOut);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
