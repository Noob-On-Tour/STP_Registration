package controller;

/*
 * Created by Ahmed on 10/4/2016.
 */

public class Single_Instance {
//    public static File file;
//    public static FileChannel fileChannel;
//    public static FileLock fileLock;
//
//    public static void main(String[] args) {
//        try {
//            file = new File("key");
//            if (file.exists()) {
//                file.delete();
//            }
//            fileChannel = new RandomAccessFile(file, "rw").getChannel();
//            fileLock = fileChannel.tryLock();
//            if (fileLock == null) {
//                fileChannel.close();
//                throw new RuntimeException("Only one can run at a time");
//            }
//            Thread shutdown = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    unlock();
//                }
//            });
//            Runtime.getRuntime().addShutdownHook(shutdown);
//            System.out.print("H");
//            while (true) {
//
//            }
//        } catch (IOException e) {
//            throw new RuntimeException("Could Start Process");
//        }
//    }
//
//    public static void unlock() {
//        try {
//            if (fileLock != null) {
//                fileLock.release();
//                fileChannel.close();
//                file.delete();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
