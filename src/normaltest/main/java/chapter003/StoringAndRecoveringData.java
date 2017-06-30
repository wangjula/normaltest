package normaltest.main.java.chapter003;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StoringAndRecoveringData {

	public static void main(String[] args) throws IOException {
		//DataOutputStream面向字节，其他都是面向字符
		//InputStream和OutputStream读出来的是字节流，而Reader和Writer读取出来的是字符串
		DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("data.txt")));
		out.writeInt(1);
		out.writeDouble(23.0d);
		out.writeUTF("this is pi");
		out.close();
		
		DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("data.txt")));
		System.out.println(in.readInt());
		System.out.println(in.readDouble());
		System.out.println(in.readUTF());
		in.close();
	}

}
