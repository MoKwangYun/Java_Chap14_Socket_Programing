//����, Ŭ���̾�Ʈ ������ ���鼭 ������ �ְ� �޴�  ���α׷�

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
			System.out.println("���� ��ٸ�...");
			socket = listener.accept();
			System.out.println("���� �Ϸ�");
			
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			while(true) {
				//Ŭ���̾�Ʈ�κ��� ������ �ޱ�
				String inputMessage = in.readLine();
				if(inputMessage.equalsIgnoreCase("bye")) {
					System.out.println("Ŭ���̾�Ʈ���� ���� ����");
					break;
				}
				
				System.out.println("Ŭ���̾�Ʈ: " + inputMessage);
				
				//�������� Ŭ���̾�Ʈ�� ������ ������
				System.out.print("������>>");
				String outputMessage = scanner.nextLine();
				if(outputMessage.equalsIgnoreCase("bye")) {
					out.write(outputMessage+"\n");
					out.flush();
					System.out.println("���� ����");
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
