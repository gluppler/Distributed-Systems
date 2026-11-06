// UDPServer.java
// A server program implementing UDP socket
import java.net.*;
import java.io.*;

public class UDPServer{
    public static void main(String args[])
    {
		DatagramSocket aSocket = null;
		try{
	        System.out.println("start server...");
	        //create a datagram socket using port 10100
	        aSocket = new DatagramSocket(10101); 
		    byte[] buffer = new byte[1000];
		    while(true){
				DatagramPacket request = new DatagramPacket(buffer, buffer.length);
				//listening incoming request
				aSocket.receive(request);
				System.out.println("receive from : " +
					request.getAddress().toString() + ":" + request.getPort() +
					" message - " + new String(request.getData()).trim());

				DatagramPacket reply = new DatagramPacket(request.getData(),
					request.getLength(), request.getAddress(), request.getPort());
				//sending a reply message to client
				aSocket.send(reply);
				System.out.println("reply to     : " + reply.getAddress() + ":"
					+ reply.getPort() + "\n");
	        }
        }
        catch (SocketException e){
            System.out.println("Socket: " + e.getMessage());
        }
        catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
		//close socket
		finally{ if(aSocket != null) aSocket.close();}
    }
}
