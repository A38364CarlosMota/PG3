package Grupo4;

import Grupo3.Aircraft;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SocialUser extends User  {
    private RejectionRule rules[];
    private List<User> friends = new ArrayList<>();
    private User user;
    private int numAmigos = 0;


    public SocialUser(String name, String nickName, RejectionRule ... rules){
        super(name, nickName);
        this.rules = rules;
    }

    public SocialUser(String name){
        super(name,name.substring(0,3));
        this.rules = new RejectionRule[0]; //ARRAY VAZIO
    }

    public RejectionRule friendRequest(SocialUser other){
        for (RejectionRule rule : rules) {
            if(rule.reject(other)) return rule;
        }
        friends.add(other);

        return null;
    }

    @Override
    public List getFriends(Predicate<User> f) {
        List<User> amigos = new ArrayList<>();
        for ( User a: friends) {
            if (f.test(a)) amigos.add(a);
        }
        return amigos;
    }

    public SocialUser addFriend(SocialUser friend) throws RuleException{
       if(!(friendRequest(friend)==null)) throw new RuleException(friendRequest(friend));
       numAmigos++;
       return friend;
    }

    public String getDescription ( String prefix){
      if(numAmigos == 0) return ( super.toString()+ "not have friends");

      return (super.toString()+ numAmigos + "friends");
    }


}
