package Grupo1;

/*
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;*/

import java.io.*;

import static java.lang.Character.isDigit;

/*import static Grupo1.StreamsUtils.copyWithReplace;*/


public class StreamsUtils {

    public static int insert(StringBuilder unformated) {
        int i = unformated.length() % 3;
        int count=0;
        if (i == 0) i = 3;

        for (; i < unformated.length(); i += 4) {
            unformated.insert(i, '.');
            count++;
        }
        return count;
    }


    public static int copyWithReplace(Reader in, Writer pw) throws IOException {

        int count = 0;
        int count2=0;
        int aux;
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        String aux1 = "";

        while ((aux = in.read()) != -1) {

            if (isDigit(aux)) {
                sb.append((char)aux);
                count++;
            } else {
                if (count > 0) {
                    count2=insert(sb);
                    pw.append(sb);
                }
                pw.write(aux);

            }
        }

        return count2;
    }
    public static String contentWithReplace( String content){
        StringReader in = new StringReader(content);
        StringWriter out = new StringWriter();
        try{
            copyWithReplace(in , out);
        }catch(IOException e){}

        return out.toString();
    }
}