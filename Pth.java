import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
public class Pth {
public static void main(String[] args) throws IOException
{
try {
    Process p = Runtime
                    .getRuntime()
                    .exec("cmd /c start cmd.exe /K \"python likegraph.py\"");
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
}
}
}