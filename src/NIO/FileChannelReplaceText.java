package NIO;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 * 替换某个路径下面所有文件的指定字符串，并且写入回去
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/11/10 13:59
 */
public class FileChannelReplaceText {
    public  static List<String> pathList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        String tableName = "G:\\JavaProjectNew\\03Project\\tablename.txt";
       //String readWritePath = "G:\\JavaProjectNew\\Trunk\\ETL_MySQL\\xQuant-platform-app-settle\\src\\main\\resources\\sqlMapper\\InstructionSettleMapper1.xml";
        RandomAccessFile randomAccessFile1 = new RandomAccessFile(tableName, "rw");
        FileChannel channel1 = randomAccessFile1.getChannel();
        ByteBuffer buf1 = ByteBuffer.allocate(1024*1024);
        channel1.read(buf1);
        buf1.flip();
        byte[] array1 = buf1.array();
        String str1 = new String(array1);
        String[] tableNameList = str1.split("\\r\\n");
        buf1.clear();
        folderMethod2("G:\\JavaProjectNew\\Trunk\\ETL_MySQL");
        //直接读取一个页面的所有数据
        ByteBuffer buf = ByteBuffer.allocate(1024*1024);
        pathList.forEach(readWritePath->{
            RandomAccessFile randomAccessFile = null;
            try {
                randomAccessFile = new RandomAccessFile(readWritePath, "rw");
                FileChannel channel = randomAccessFile.getChannel();

                channel.read(buf);
                buf.flip();
                byte[] array = buf.array();
                String str = new String(array);
                for (String name : tableNameList) {
                    //System.out.println(name);
                    if(str.contains(name.toLowerCase())){
                        str = str.replaceAll(name.toLowerCase(), name);
                    }

                }
               // System.out.println(str);

                buf.clear();

                FileOutputStream f1 = new FileOutputStream(readWritePath);
                FileChannel fc1 = f1.getChannel();
                ByteBuffer buffer = ByteBuffer.wrap(str.getBytes());
                fc1.write(buffer);
                fc1.close();//关闭通道
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        });

    }

    public static void folderMethod2(String path) {
        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (null != files) {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        //System.out.println("文件夹:" + file2.getAbsolutePath());
                        folderMethod2(file2.getAbsolutePath());
                    } else {
                        if(file2.getAbsolutePath().contains("sqlMapper") && file2.getAbsolutePath().contains(".xml")){
                            pathList.add(file2.getAbsolutePath());
                        }
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
    }
}
