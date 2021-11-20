package Grupo4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.IterableResult;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class TestGroup {
    private static final RejectionRule[] r = {new RejectName("Joana"), new RejectDate(new Date(1, 1, 2000))};
    private static SocialUser u1 = new SocialUser("Joaquim");
    private static SocialUser u2 = new SocialUser("Carlos", "Carl", r);
    private static SocialUser u3 = new SocialUser("Joana", "Jo", r[1]);


    @Test
    public void testConstruct() {
        Group gjf = new Group("JavaFellows", "jf");
        assertEquals("group JavaFellows (JF) {\n}", gjf.toString());
    }


    @Test
    public void testAppend() throws RuleException {
        Group gjf = new Group("JavaFellows", "jf");
        assertFalse( gjf.iterator().hasNext());
        gjf.append(u1).append(u3);
        Iterator<User> it = gjf.iterator();
        assertTrue( gjf.iterator().hasNext());
        assertTrue( Stream.of(u1, u3).allMatch(u -> it.next() == u ));
        assertFalse( it.hasNext());
    }


    @Test
    public void testGetFriends() throws RuleException {
        Group gjf = new Group("JavaFellows", "jf");
        SocialUser u1= new SocialUser("Joaquim");
        SocialUser u2=new SocialUser("Carlos","Carl", r );
        SocialUser u3=new SocialUser ("Joana","Jo",r[1]);
        gjf.append(u1).append(u3);
        assertTrue(gjf.getFriends(u -> true).isEmpty());
        u1.addFriend( u2 ).addFriend( u3 );
        u2.incLikes();
        assertEquals(Arrays.asList(u2, u3, u1),gjf.getFriends(u -> true));
        assertEquals(Arrays.asList(u2),gjf.getFriends(u -> u.getLikes() > 0 ));
        assertEquals(Arrays.asList(u3, u1),gjf.getFriends(u -> u.toString().contains("JO")));

    }

    @Test
    public void testGetDescription() throws RuleException {
        Group gjf = new Group("JavaFellows", "jf");

        gjf.append(u1).append(u3);
        String gjfDesc = "group JavaFellows (JF) {\n\tJoaquim (JOA) - not have friends\n\tJoana (JO) - not have friends\n}";
        assertEquals(gjfDesc, gjf.toString());
        gjfDesc= '\t'+gjfDesc.replaceAll("\t", "\t\t").replace("}", "\t}");
        Group gte = new Group("Teachers", "te");
        gte.append(u2).append(gjf);
        assertEquals("group Teachers (TE) {\n\tCarlos (CARL) - not have friends\n"+gjfDesc+ "\n}", gte.toString());

    }


}
