package Grupo1;

import org.junit.jupiter.api.Test;

import static Grupo1.StreamsUtils.contentWithReplace;
import static Grupo1.StreamsUtils.insert;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TesteInsert {

    @Test
    public void testeInsert(){
        StringBuilder s = new StringBuilder("123");
        insert(s);
      //  StringBuilder s1 = new StringBuilder("1234");
       // insert(s1);

        assertEquals("123", s.toString() );
       // assertEquals("1234", s.toString() );
    }

    @Test
    public void teste2Insert(){

        StringBuilder s1 = new StringBuilder("1234");
        insert(s1);
        assertEquals("1.234", s1.toString() );
    }
    @Test
    public void teste3Insert(){

        StringBuilder s2 = new StringBuilder("123456");
        insert(s2);
        assertEquals("123.456", s2.toString() );
    }

    @Test
    public void teste4Replace(){


        assertEquals("tESTE 123.456 ", contentWithReplace("tESTE 123456 ") );
    }

}
