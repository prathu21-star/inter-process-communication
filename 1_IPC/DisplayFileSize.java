import java.io.File;

public class DisplayFileSize {
   public static long getFileSize(String filename) {
      File file = new File(filename);
      if (!file.exists() || !file.isFile()) {
         System.out.println("File doesn\'t exist");
         return -1;
      }
      return file.length();
   }
   public static void main(String[] args) 
     {
      long size = getFileSize("C:/Users/Prathu/OneDrive/Documents/DC_EXP/1.IPC/Flower1.jpg");
      System.out.println("Filesize in bytes: " + size);
     }
}