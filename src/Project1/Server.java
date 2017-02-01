package Project1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
	public static void main (String[]args)throws IOException
	{
		int port = 5050;
		ServerSocket ss = null;
		Socket socket = null;
		try 
		{
			ss = new ServerSocket(port); 
			socket = ss.accept();
			System.out.println("Server running");
		}
		catch(IOException e )
		{	
			System.out.println("Client disconnected");
		}
		
		BufferedReader in= new BufferedReader(new InputStreamReader(socket.getInputStream()));		 
		PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
		String t = null;
		String s;
		s = in.readLine();		
		out.println(s);				
		out.close();
		in.close();
		ss.close();
		ss.close();	
	}
}