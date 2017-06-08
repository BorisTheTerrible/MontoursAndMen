/*
 *  All Rights Reserved by Johnathan Schemenaur
 */

package montours_and_men.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import montours_and_men.Start;
import montours_and_men.network.packets.Packet;
import montours_and_men.utilities.Settings;
import montours_and_men.utilities.SystemManager;

public final class UDPSocket
{
    private DatagramSocket datagramSocket;

    public UDPSocket(InetSocketAddress inetSocketAddress) throws Exception
    {
        datagramSocket = new DatagramSocket(Settings.CLIENT_PORT);
        datagramSocket.connect(inetSocketAddress);
    }
    
    public void send(Packet packet)
    {
        DatagramPacket datagramPacket = new DatagramPacket
        (
                packet.getBytes(), 
                packet.getBytes().length,
                datagramSocket.getInetAddress(), 
                datagramSocket.getPort()
        );
        
        try
        {
            datagramSocket.send(datagramPacket);
        } 
        catch (Exception ex)
        {
            Logger.getLogger(NetworkManager.class.getName()).log(Level.INFO, ex.toString());
        }
    }
}
