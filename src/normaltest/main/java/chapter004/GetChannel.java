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
		//��ȡͨ����ͨ��ֻ�ͻ�����������ByteBufferΨһһ��ֱ�Ӻ�ͨ�������Ļ�����
		FileChannel fc = new FileOutputStream("data.txt").getChannel();
		fc.write(ByteBuffer.wrap("Some text".getBytes()));
		fc.close();

		fc = new RandomAccessFile("data.txt", "rw").getChannel();
		fc.position(fc.size());//�ƶ����ļ���ĩβ
		fc.write(ByteBuffer.wrap("Some more".getBytes()));
		fc.close();
		
		fc = new FileInputStream("data.txt").getChannel();
		ByteBuffer buff = ByteBuffer.allocate(BYTE_SIZE);
		fc.read(buff);
		buff.flip();//׼����ȡ
		while (buff.hasRemaining()) {
			System.out.println((char)buff.get());
		}
		
		FileChannel in = new FileInputStream("data.txt").getChannel();
		FileChannel out = new FileOutputStream("data.txt").getChannel();
		ByteBuffer buffer2 = ByteBuffer.allocate(BYTE_SIZE);
		while (in.read(buffer2) != -1) {
			buffer2.flip(); //׼����ByteBuffer������
			out.write(buffer2);
			buffer2.clear(); //��������´�д��
		}
	}

}
