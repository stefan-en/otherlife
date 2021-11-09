package tilegame.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//clasa ce ma ajuta la incarcarea hartii si indexarea acesteia
// returnezi niste intiger din fisierul tau text
public class Utils {

    public static String loadFile(String path)
    {
        StringBuilder builder = new StringBuilder();

        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null)
                builder.append(line +"\n");

            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return builder.toString();
    }

    public static int goInt(String number) {
        try {
            return Integer.parseInt(number);
        }catch(NumberFormatException e){
            e.printStackTrace();
            return  0;
        }
    }
}
