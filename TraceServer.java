
import java.io.*;

class TraceServer{
    public static void main(String[] args){
        try{
            String str;
            System.out.print("Enter domain name: ");
            BufferedReader buf1 = new BufferedReader(new InputStreamReader(System.in));
            str = buf1.readLine();
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec("tracert " + str);
            InputStream in = p.getInputStream();
            BufferedReader buf2 = new BufferedReader(new InputStreamReader(in));
            while((str = buf2.readLine()) != null)
                System.out.println(str);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}