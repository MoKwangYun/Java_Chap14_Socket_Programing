import java.io.*;
import java.net.*;

public class CalcServerEx {
	public static void main(String[] args) {
		ServerSocket listener = null;
		Socket socket = null;
		BufferedReader in = null;
		
		try {
			listener= new ServerSocket(9999);
			System.out.println("������ ��ٸ��� �ֽ��ϴ�....");
			socket = listener.accept();
			System.out.println("���� �Ǿ����ϴ�.");
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			while(true) {
				String inputMessage =	in.readLine();
				if(inputMessage.equalsIgnoreCase("bye")) {
					System.out.println("Ŭ���̾�Ʈ���� ������ �����Ͽ����ϴ�.");
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
