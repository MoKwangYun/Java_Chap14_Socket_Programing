//서버, 클라이언트 번갈아 가면서 데이터 주고 받는  프로그램

import java.io.*;
import java.net.*;
import java.util.*;

public class SeverEX {
	public static void main(String[] args) {
		ServerSocket listener = null;
		Socket socket = null;
		BufferedWriter out = null;
		Scanner scanner = new Scanner(System.in);
		BufferedReader in = null;
		
		try {
			listener = new ServerSocket(9999);
			System.out.println("연결 기다림...");
			socket = listener.accept();
			System.out.println("연결 완료");
			
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			while(true) {
				//클라이언트로부터 데이터 받기
				String inputMessage = in.readLine();
				if(inputMessage.equalsIgnoreCase("bye")) {
					System.out.println("클라이언트에서 연결 종료");
					break;
				}
				
				System.out.println("클라이언트: " + inputMessage);
				
				//서버에서 클라이언트로 데이터 보내기
				System.out.print("보내기>>");
				String outputMessage = scanner.nextLine();
				if(outputMessage.equalsIgnoreCase("bye")) {
					out.write(outputMessage+"\n");
					out.flush();
					System.out.println("연결 종료");
					break;
				             }
				out.write(outputMessage+"\n");
				out.flush();
			}
		}
		catch(IOException e) {
		}
		
		try {
			listener.close();
			socket.close();
		}
		catch(IOException e) {}
			
	}
}
