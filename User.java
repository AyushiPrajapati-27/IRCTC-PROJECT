public class User {
    private String username;
    private String password;
    private String fullname;
    private String contact;

    public User(String username,String password,String fullname,String contact) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.contact = contact;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username= username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password= password;
    }

    public String getFullname(){
        return fullname;
    }

    public void setFullname(String fullname){
        this.fullname= fullname;
    }
    public String getContact(){
        return username;
    }

    public void setContact(String contact){
        this.contact= contact;
    }
    @Override
    public String toString(){
        return fullname +" ("+username+")";
    }
}
