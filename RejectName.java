package Grupo4;

public class RejectName implements RejectionRule {
    String description;
    User user;

    public RejectName(String d){
        this.description = d;
    }

    public boolean reject(User u){
        return u.getDescription("").contains(description);
    };

    public String getDescription(){return "Rejected Name";}
}
