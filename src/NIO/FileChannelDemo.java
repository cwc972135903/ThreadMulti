package NIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/5/14 15:56
 */
public class FileChannelDemo {
    public static void main(String ...args) throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("G://浦发项目迁移构建保险版本工程的说明20200217.docx", "rw");
        FileChannel inChannel = aFile.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(48);

        int bytesRead = inChannel.read(buf);
        System.out.println("position:" + buf.position());
        System.out.println("limit:" + buf.limit());
        System.out.println("cap:" + buf.capacity());
        System.out.println("mark:" + buf.mark());
        while (bytesRead != -1) {
            System.out.println("Read " + bytesRead);
            buf.flip();

            while(buf.hasRemaining()){
                System.out.print((char) buf.get());
            }

            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();

    }
}
