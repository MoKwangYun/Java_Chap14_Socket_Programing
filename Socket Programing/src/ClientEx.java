//����, Ŭ���̾�Ʈ ������ ���鼭 ������ �ְ� �޴�  ���α׷�
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
				
				String inputMessage = in.readLine();
				if(inputMessage.equalsIgnoreCase("bye")){
					System.out.println("�������� ���� ����");
					break;
				}
				System.out.println("����: " + inputMessage);
			}
			
		}
		catch(IOException e) {}
		
		try {	
			socket.close();
		}
		catch(IOException e) {}
	}
}