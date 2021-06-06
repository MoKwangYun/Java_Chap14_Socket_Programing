import java.io.*;
import java.net.*;

public class ServerEx3 {
	public static void main(String[] args) {
		ServerSocket listener = null;
		Socket socket = null;
		BufferedReader in = null;
		
		try {
			listener = new ServerSocket(9999);
			System.out.println("���� ��ٸ�...");
			socket = listener.accept();
			System.out.println("���� �Ǿ���");
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			while(true) {
				String inputMessage = in.readLine();
				System.out.println("������ �ޱ� ����");
				if(inputMessage.equalsIgnoreCase("bye")){
					System.out.println("Ŭ���̾�Ʈ���� ���� ����");
					break;
				}
				System.out.println("Ŭ���̾�Ʈ: " + inputMessage);
			}
		}
		catch(IOException e) {}
		
		try {	
			listener.close();
			socket.close();
		}
		catch(IOException e) {}
	}
}
