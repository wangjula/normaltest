package normaltest.main.java.chapter003;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

public class BasicFileOutPut {

	private static final String fileName = "BaseFileOutPut.txt";
	
	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(
				new StringReader("This is test for java io\nstart Bufferedreader\nwaiting...\nfinish\n"));
		try {
			//java io 分为两层： 来源去处 + 装饰器
			//其中装饰器可叠加多个
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
			String s;
			int lineNum = 0;
			while ((s=in.readLine())!=null) {
				out.println(lineNum ++ + ":" +s);
			}
			out.close();
			System.out.println("writer over!");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
