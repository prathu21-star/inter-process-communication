import java.io.*;
import java.net.*;
import java.lang.reflect.Method;

class Server {
	public static void main(String argv[]) throws Exception {

		String s = null;
		ServerSocket welcomeSocket = new ServerSocket(6789);
		try {
			while (true) {
				Socket connectionSocket = welcomeSocket.accept();

				BufferedReader inFromClient = new BufferedReader(
						new InputStreamReader(connectionSocket.getInputStream()));
				String y = inFromClient.readLine();
				System.out.println("Demand Received from Client:");

				int demand = Integer.parseInt(y);
				System.out.println("Demand No is: " + demand);

				String className = null;
				String methodName = null;

				switch (demand) {
					case 1:
						className = "ContentsOfFolder";
						methodName = "main";
						break;

					case 2:
						className = "DisplayFileSize";
						methodName = "main";
						break;

					case 3:
						className = "EmptySpace";
						methodName = "main";
						break;

					default:
						System.out.println("Enter demand number between 1 to 3");
						break;
				}

				if (className != null && methodName != null) {
					Class<?> clazz = Class.forName(className);
					Method method = clazz.getMethod(methodName, String[].class);
					method.invoke(null, (Object) new String[0]);

					String x = "";
					BufferedReader stdInput = new BufferedReader(new InputStreamReader(System.in));
					while ((s = stdInput.readLine()) != null) {
						x = x + s;
					}

					System.out.println("My message is " + x);
					DataOutputStream DataToClient = new DataOutputStream(connectionSocket.getOutputStream());
					DataToClient.writeBytes(x + '\n');
				}
			}
		} finally {
			welcomeSocket.close();
		}
	}
}
