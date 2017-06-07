/*
 *  All Rights Reserved by Johnathan Schemenaur
 */

package montours_and_men.network;

import java.net.InetAddress;

public final class NetworkManager
{
   TCPSocket tcpSocket;
   UDPSocket udpSocket;
   
   private boolean hasEstablishedConnection = false;
    
   public NetworkManager()
   {
       
   }
   
   public void establishConnection(String formattedIpAndPort, int timeout)
   {
      // InetAddress inetAddress = new InetAddress();
   }
   
}
