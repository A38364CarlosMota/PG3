package Grupo4;
/*
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

public class TestSocialUser {

    @Test
    public void testConstruct() {
        User u1 = new SocialUser("Joana", "Jo");
        assertEquals( "Joana (JO) - not have friends", u1.toString());
        User u2= new SocialUser("Joaquim");
        assertEquals( "Joaquim (JOA) - not have friends", u2.toString());
    }

    @Test
    public void testIncLikes() {
        SocialUser u = new SocialUser("Joana", "Jo");
        assertEquals(0, u.getLikes());
        u.incLikes();
        assertEquals(1, u.getLikes());
        for ( int i= 1; i < 3; ++i ) u.incLikes();
        assertEquals(3, u.getLikes());
    }
    @Test
    public void testFriendRequest() {
        SocialUser u1 = new SocialUser("Joana", "Jo");
        SocialUser u2= new SocialUser("Joaquim");
        assertNull(u1.friendRequest( u2 ));
        assertEquals( "Joana (JO) - 1 friend", u1.toString());
        assertEquals( "Joaquim (JOA) - not have friends", u2.toString());
    }

    @Test
    public void testFriendRequestReject() {
        RejectionRule r =new RejectName( "JOA");
        SocialUser u1 = new SocialUser("Joana", "Jo",  r);
        SocialUser u2= new SocialUser("Joaquim");
        assertSame(r, u1.friendRequest( u2 ));
        assertEquals( "Joana (JO) - not have friends", u1.toString());
        assertEquals( "Joaquim (JOA) - not have friends", u2.toString());
    }

    @Test
    public void addFriend() throws RuleException {
        SocialUser u1 = new SocialUser("Joana", "Jo");
        SocialUser u2= new SocialUser("Joaquim");
        assertSame(u1, u1.addFriend( u2 ));
        assertEquals( "Joana (JO) - 1 friend", u1.toString());
        assertEquals( "Joaquim (JOA) - 1 friend", u2.toString());
    }

    @Test
    public void ExpectedRuleException() throws RuleException {
        RejectionRule r =new RejectName( "JO");
        SocialUser u1 = new SocialUser("Joana", "Jo");
        SocialUser u2= new SocialUser("Joaquim", "JOA", r);
        RuleException e = assertThrows(RuleException.class, () -> u1.addFriend( u2 ));
        assertEquals("Reject user by rule: \"Reject name JO\"", e.getMessage());
        assertEquals( "Joana (JO) - not have friends", u1.toString());
        assertEquals( "Joaquim (JOA) - not have friends", u2.toString());

        e = assertThrows(RuleException.class, () -> u2.addFriend( u1 ));
        assertEquals("Reject user by rule: \"Reject name JO\"", e.getMessage());
        assertEquals( "Joana (JO) - not have friends", u1.toString());
        assertEquals( "Joaquim (JOA) - not have friends", u2.toString());

    }

    @Test
    public void testGetFriends() throws RuleException {
        SocialUser u1 = new SocialUser("Joana", "Jo");
        SocialUser u2= new SocialUser("Joaquim");
        SocialUser u3= new SocialUser("Francisco");
        u1.addFriend( u2 ).addFriend( u3 );
        assertEquals("Joana (JO) - 2 friends", u1.toString());
        assertEquals(Arrays.asList(u2, u3), u1.getFriends((u) -> true));

        u3.incLikes();
        assertEquals(Arrays.asList( u2 ), u1.getFriends((u)-> u.getLikes()==0));
        assertEquals(Arrays.asList( u3 ), u1.getFriends((u)-> u.getLikes()!=0));
    }

    @Test
    public void testGetDescription() {
        // todo
    }

    @Test
    public void testCompareTo() {
        SocialUser u1 = new SocialUser("Joana", "Jo");
        SocialUser u2= new SocialUser("Joaquim");
        assertEquals(0, u1.compareTo( u2 ));
        u1.incLikes();
        assertTrue(u1.compareTo( u2 )>0);
        assertTrue(u2.compareTo( u1 )<0);
    }
}*/