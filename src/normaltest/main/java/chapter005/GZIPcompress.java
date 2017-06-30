package normaltest.main.java.chapter005;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZIPcompress {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("data.txt"));

		BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream("test.zip")));
		int c;
		while ((c = in.read()) != -1) {
			out.write(c);
		}
		in.close();
		out.close();
		//BufferedReader只接受某种读取数据源的Reader
		BufferedReader in1 = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream("test.zip"))));
		while ((c= in1.read()) != -1) {
			System.out.println((char)c);
		}
		in1.close();
	}

}
