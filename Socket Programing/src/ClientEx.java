//서버, 클라이언트 번갈아 가면서 데이터 주고 받는  프로그램
import java.io.*;
import java.net.*;
import java.util.*;

public class ClientEx {
	public static void main(String[] args) {
		Socket socket = null;
		BufferedReader in =null;
		BufferedWriter out = null;
		Scanner scanner = new Scanner(System.in);
		try {
			socket = new Socket("localhost",9999);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			while(true) {
				
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
				
				String inputMessage = in.readLine();
				if(inputMessage.equalsIgnoreCase("bye")){
					System.out.println("서버에서 연결 종료");
					break;
				}
				System.out.println("서버: " + inputMessage);
			}
			
		}
		catch(IOException e) {}
		
		try {	
			socket.close();
		}
		catch(IOException e) {}
	}
}
