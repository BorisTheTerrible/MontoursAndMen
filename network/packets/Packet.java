/*
 *  All Rights Reserved by Johnathan Schemenaur
 */

package montours_and_men.network.packets;

import java.nio.charset.StandardCharsets;

public abstract class Packet
{
   public final int packetId;
   
   public Packet(int packetId)
   {
       this.packetId = packetId;
   }
   
   public static int getPacketIdFromPacket(byte[] bytes, boolean isBigEndian)
   {
       return 0;
   }
   
   public static byte[] packageStringToLength(String stringToPackage, int length)
   {
       return stringToPackage.substring(0, length).concat("\0").getBytes(StandardCharsets.US_ASCII);
   }
   
   public static byte packageBoolean(boolean booleanToPackage)
   {
       if(booleanToPackage == true)
       {
           return 1;
       }
       else
       {
           return 0;
       }
   }
   
   //Packet needs to contain packetId for first value
   //ByteBuffer order needs to be set before any vales are added
   public abstract byte[] getBytes();
}
