import java.io.*;
import java.net.*;

class FileClient
{
    public static void main(String[] args) {
        try
        {
            Socket Clt = new Socket(InetAddress.getLocalHost(), 3210);
            PrintWriter OS = new PrintWriter(new BufferedWriter(new OutputStreamWriter(Clt.getOutputStream())), true);
            BufferedReader IS = new BufferedReader(new InputStreamReader(Clt.getInputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String CltMsg, SrvMsg;
            System.out.print("\nFilename : ");
            CltMsg = br.readLine();
            OS.println(CltMsg);
            while ((SrvMsg = IS.readLine()) != null)
                System.out.println(SrvMsg);
        }
        catch(Exception E) {
            System.out.println(E.getMessage());
        }
    }
}