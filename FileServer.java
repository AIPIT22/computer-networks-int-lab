import java.io.*;
import java.net.*;
public class FileServer
{
    public static void main(String[] args) {
        File dir;
        ServerSocket ss;
        Socket conn;
        BufferedReader br;
        PrintWriter pw;
        dir = new File("E:\\");
        if(!dir.exists() || !dir.isDirectory())
        {
            System.out.println("Directory does not exist");
            System.exit(-1);
        }
        try
        {
            ss = new ServerSocket(3210);
            conn = ss.accept();
            br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            pw = new PrintWriter(conn.getOutputStream());
            String name = br.readLine().trim();
            File F = new File(dir, name);
            if((!F.exists()) || F.isDirectory())
                pw.println("File does not exists");
            else
            {
                pw.println("\n");
                BufferedReader fin = new BufferedReader(new FileReader(F));
                while(true)
                {
                    String line = fin.readLine();
                    if(line == null) break;
                    pw.println(line);
                }
                System.out.println("File Transferred\n");
            }
            pw.flush();
            pw.close();
        }
        catch(Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
