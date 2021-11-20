package Grupo4;

import Grupo3.AirTrafficException;
import Grupo3.Aircraft;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Predicate;

public class Group extends User {

    private List<User> group = new ArrayList<>();
    String[] members;

    public Group(String name, String nickName, String...members) {
       super(name, nickName);
       this.members = members;
    }

    public Group append (User user) throws RuleException{

        RejectName b = new RejectName(user.name);
        for ( User a : group ){
            if(user.equals(group)) throw new RuleException(b);
        }
        group.add(user);

        Iterable<User> members = new Iterable<User>() {
            @Override
            public Iterator<User> iterator() {
                iterator().hasNext();
            return null;
            }

        };

        return this;
    }

    public List<User> getFriends (Predicate<User> filter) {
        List<User> all = new ArrayList<>();
        for ( User a: group ) {
            if (!filter.equals(a)) all.add(a);
        }

    return all;
    }

}
