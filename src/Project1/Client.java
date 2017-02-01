package Project1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Client
{
	public static void main (String []args) throws IOException
	{	
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		Socket s = null; 
		
		try
		{
			s = new Socket(args[0], 5050);
		}
		catch(Exception e)
		{
			System.out.println("Client disconnected. Server shutting down"); 
		}
		
		BufferedReader file = null;
		file = new BufferedReader(new FileReader("data500B.txt"));
		String temp    = null;
		String buffer  = "";
		while ((temp = file.readLine()) != null) 
		{
		    buffer = buffer.concat(temp);				
		}
		
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);		
		long initialTime;
		long endTime;
		BufferedReader in = new BufferedReader(new InputStreamReader (s.getInputStream()));
		initialTime = System.currentTimeMillis();
		out.println(buffer);
		endTime = System.currentTimeMillis();					
		System.out.println("start: " + initialTime +","+endTime + ( endTime - initialTime)+ "ms");
		file.close();
		in.close();
		out.close();
		s.close();
	}
}