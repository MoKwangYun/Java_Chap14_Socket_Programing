import java.io.*;
import java.net.*;

public class CalcServerEx {
	public static void main(String[] args) {
		ServerSocket listener = null;
		Socket socket = null;
		BufferedReader in = null;
		
		try {
			listener= new ServerSocket(9999);
			System.out.println("연결을 기다리고 있습니다....");
			socket = listener.accept();
			System.out.println("연결 되었습니다.");
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			while(true) {
				String inputMessage =	in.readLine();
				if(inputMessage.equalsIgnoreCase("bye")) {
					System.out.println("클라이언트에서 연결을 종료하였습니다.");
					break;
				}
				System.out.println(inputMessage);
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
