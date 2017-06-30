package normaltest.main.java.chapter004;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GetChannel {

	public static final int BYTE_SIZE = 1024;
	public static void main(String[] args) throws IOException {
		//获取通道，通道只和缓冲器交互，ByteBuffer唯一一种直接和通道交互的缓冲器
		FileChannel fc = new FileOutputStream("data.txt").getChannel();
		fc.write(ByteBuffer.wrap("Some text".getBytes()));
		fc.close();

		fc = new RandomAccessFile("data.txt", "rw").getChannel();
		fc.position(fc.size());//移动到文件的末尾
		fc.write(ByteBuffer.wrap("Some more".getBytes()));
		fc.close();
		
		fc = new FileInputStream("data.txt").getChannel();
		ByteBuffer buff = ByteBuffer.allocate(BYTE_SIZE);
		fc.read(buff);
		buff.flip();//准备读取
		while (buff.hasRemaining()) {
			System.out.println((char)buff.get());
		}
		
		FileChannel in = new FileInputStream("data.txt").getChannel();
		FileChannel out = new FileOutputStream("data.txt").getChannel();
		ByteBuffer buffer2 = ByteBuffer.allocate(BYTE_SIZE);
		while (in.read(buffer2) != -1) {
			buffer2.flip(); //准备从ByteBuffer读内容
			out.write(buffer2);
			buffer2.clear(); //清空用于下次写入
		}
	}

}
