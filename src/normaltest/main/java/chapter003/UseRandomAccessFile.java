package normaltest.main.java.chapter003;

import java.io.IOException;
import java.io.RandomAccessFile;

public class UseRandomAccessFile {

	public static void display(String filePath) throws IOException {
		RandomAccessFile rf = new RandomAccessFile(filePath, "r");
		for (int i = 0; i < 7; i ++) {
			System.out.println(rf.readDouble());
		}
		System.out.println(rf.readUTF());
		rf.close();
	}
	public static void main(String[] args) throws IOException {
		RandomAccessFile rf = new RandomAccessFile("rtest.dat", "rw");
		for (int i = 0; i < 7; i ++) {
			rf.writeDouble(i*1.547);
		}
		rf.writeUTF("end of file");
		rf.close();
		display("rtest.dat");
		rf = new RandomAccessFile("rtest.dat", "rw");
		rf.seek(5*8);//查找的是从其实开始计算的位置
		rf.writeDouble(4.98);
		rf.close();
		display("rtest.dat");
	}

}
