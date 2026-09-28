import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<String,User> userMap=new HashMap<>();
    private User currentUser =null;

    public boolean registerUser(String username,String password,String fullName,String contact)
    {
        if(userMap.containsKey(username)){
            System.out.println("Username already taken, please choose another");
            return false;
        }
        User user=new User(username,password,fullName,contact);
        userMap.put(username,user);
        System.out.println("Registration Successful!");
        return true;
    }
    public boolean loginUser(String username,String password)
    {
        if(!userMap.containsKey(username)){
            System.out.println("No User Found with this username");
            return false;
        }
        User user=userMap.get(username);
        if(!user.getPassword().equals(password))
        {
            System.out.println("Incorrect Password");
            return false;
        }
        currentUser=user;
        System.out.println("Welcome:"+currentUser.getFullname()+"!");
        return true;
    }
      public void logOutUser()
    {
     if(currentUser!=null)
     {
         System.out.println("Logged Out"+currentUser.getFullname());
     }
     currentUser=null;
    }
    public User getCurrentUser(){
        return currentUser;
    }
    public boolean isLoggedIn(){
        return currentUser!=null;
    }
  }
