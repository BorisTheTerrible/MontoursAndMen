/*
 *  All Rights Reserved by Johnathan Schemenaur
 */

package montours_and_men.network;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.logging.Level;
import java.util.logging.Logger;
import montours_and_men.network.packets.HandshakePacket;

public final class NetworkManager
{
   TCPSocket tcpSocket;
   UDPSocket udpSocket;
   
   private boolean isConnected = false;
    
   public NetworkManager()
   {
       
   }
   
   public boolean getIsConnected()
   {
       return isConnected;
   }
   
   public boolean tryEstablishConnection(String serverIp, int serverPort)
   {
       try
       {
           InetSocketAddress inetSocketAddress = new InetSocketAddress(serverIp, serverPort);
           
           //tcpSocket = new TCPSocket(inetSocketAddress);
           
           udpSocket = new UDPSocket(inetSocketAddress);
       }
       catch (Exception ex)
       {
           Logger.getLogger(NetworkManager.class.getName()).log(Level.INFO, ex.toString());
           return false;
       }
       
       isConnected = true;
       return true;
   }
   
}
