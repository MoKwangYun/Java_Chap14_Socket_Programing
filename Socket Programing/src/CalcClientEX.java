import java.io.*;
import java.net.*;
import java.util.*;

public class CalcClientEX {
	public static void main(String[] args) {
		Socket socket = null;
		BufferedWriter out = null;
		Scanner scanner = new Scanner(System.in);
		
		try {
			socket = new Socket("localhost",9999);
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			while(true) {
				System.out.print("계산식(빈칸으로 띄어 입력, 예:24 + 42>>");
				String outputMessage = scanner.nextLine();
				
				if(outputMessage.equalsIgnoreCase("bye")) {
					System.out.println("연결 종료");
					out.write(outputMessage+"\n");
					out.flush();
					break;
				}
				out.write(outputMessage+"\n");
				out.flush();
				
				StringTokenizer st = new StringTokenizer(outputMessage," ");
				
				String tk1 = st.nextToken();
				String tk2 = st.nextToken();
				String tk3 = st.nextToken();
				
				switch(tk2) {
					case "+":{
						int n = Integer.parseInt(tk1);
						int m = Integer.parseInt(tk3);
						System.out.println("계산 결과: " + (n+m));
						break;
					}
					case "-":{
						int n = Integer.parseInt(tk1);
						int m = Integer.parseInt(tk3);
						System.out.println("계산 결과: " + (n-m));
						break;
					}
					case "*":{
						int n = Integer.parseInt(tk1);
						int m = Integer.parseInt(tk3);
						System.out.println("계산 결과: " + (n*m));
						break;
					}
					case "/":{
						int n = Integer.parseInt(tk1);
						int m = Integer.parseInt(tk3);
						System.out.println("계산 결과: " + (n/m));
						break;
					}
					default:{
						System.out.println("잘못된 수식 입력");
					}
				}
			}
		}
		catch(IOException e) {}
		try {
			socket.close();
		}
		catch(IOException e) {}
	}
}
