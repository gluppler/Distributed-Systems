// UDPClient.java
// A client program implementing UDP socket
import java.net.*;
import java.io.*;

public class UDPClient{
    public static void main(String args[])
    {//args give message contents and server hostname
		DatagramSocket aSocket = null;
		try {
		    int serverPort = 10101;
        String ip = "localhost";
        String message = "Hello World";
        InetAddress aHost = InetAddress.getByName(ip);

        System.out.println("start client...");
		    aSocket = new DatagramSocket(10001);

		    DatagramPacket request =
	                new DatagramPacket(message.getBytes(), message.length(), aHost, serverPort);
		    //send a message to server
		    aSocket.send(request);
		    System.out.println("send to    : " + request.getAddress() + ":" +
		    	request.getPort() + " message - " + new String(request.getData()).trim());
		    byte[] buffer = new byte[1000];
		    DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
		    System.out.println("waiting server reply ...");
		    //listening reply from server
		    aSocket.receive(reply);
		    System.out.println("reply from : " + reply.getAddress() + ":" +
		    	reply.getPort() + " message - " + new String(reply.getData()).trim());
		    //close socket
		    aSocket.close();
		}
		catch (SocketException e){
		    System.out.println("Socket: " + e.getMessage());
		}
	        catch (IOException e){
		    System.out.println("IO: " + e.getMessage());
		}
		finally{ if(aSocket != null) aSocket.close();}
}
}
