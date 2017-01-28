/*
 *  All Rights Reserved by Johnathan Schemenaur
 */

package montours_and_men.network;

import java.net.InetAddress;
import java.net.SocketException;
import montours_and_men.network.packets.HandshakePacket;
import montours_and_men.utilities.SystemManager;

public final class NetworkManager
{
   UDPSocket udpSocket;
    
   public NetworkManager()
   {
       try
       {
           udpSocket = new UDPSocket(InetAddress.getLoopbackAddress(), 30000);
       }
       catch (SocketException socketException)
       {
           SystemManager.consolePrintStack(socketException);
           udpSocket = null;
       }
       
       udpSocket.send(new HandshakePacket("ayy"));
   }
}
