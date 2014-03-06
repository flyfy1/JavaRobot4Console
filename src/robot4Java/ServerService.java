package robot4Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;


public class ServerService {
	public static interface LineListener{
		public void onMessage(String msg, Writer out) throws IOException;
	}

	private LineListener listener;
	private int port_num;
	
	public ServerService(LineListener listener, int port_num){
		this.listener = listener;
		this.port_num = port_num;
	}
	
	public void serve() throws IOException{
		ServerSocket serverSocket = new ServerSocket(port_num);
	    
	    while(true){
	    	Socket clientSocket = serverSocket.accept();
	    	System.out.println("New connection accepted");
	    	
	    	Writer out =
    	        new OutputStreamWriter(clientSocket.getOutputStream(), "ASCII");
	    	
	    	System.out.println("Got IP address: " + clientSocket.getInetAddress());
	    	InetAddress clientAddr = clientSocket.getInetAddress();
	    	if(!isThisMyIpAddress(clientSocket.getInetAddress())){
	    		out.write("Only local connection is accetped.\n");
	    		out.flush();
	    		clientSocket.close();
	    		continue;
	    	}
	    	
	    	BufferedReader in = new BufferedReader(
    	        new InputStreamReader(clientSocket.getInputStream()));
	    	
    	    String inputLine;

    	    while ((inputLine = in.readLine()) != null) {
    	    	listener.onMessage(inputLine, out);
    	    }
	    }
	}
	
	private static boolean isThisMyIpAddress(InetAddress addr) {
	    // Check if the address is a valid special local or loop back
	    if (addr.isAnyLocalAddress() || addr.isLoopbackAddress())
	        return true;

	    // Check if the address is defined on any interface
	    try {
	        return NetworkInterface.getByInetAddress(addr) != null;
	    } catch (SocketException e) {
	        return false;
	    }
	}
}
