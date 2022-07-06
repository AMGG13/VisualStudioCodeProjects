package DAO;

import OBJECTS.User;
import java.util.ArrayList;

public class UsersManagement {
    private ArrayList<User> Users;

    public UsersManagement() {
        Users = new ArrayList<User>();
    }

    public int login(User log){
        //0 no existe 1 existe pero la contraseña no es invalida y 2 esta bien
        int success =0;
        if(Users.contains(log)){
            if(Users.get(Users.indexOf(log)).getPassword().equals(log.getPassword())){
                success = 2;
            }else{
                success = 1;
            }
        }
        return success;
    }
    public boolean removeUser(User remove, boolean confirm){
        boolean removed = false;
        if(Users.contains(remove)){
            if(confirm){
                Users.remove(remove);
                removed = true;
            }
        }
        return removed;

    }
    public boolean register(User register){
        boolean success = false;
        if(!Users.contains(register)){
            Users.add(register);
            success=true;
        }
        return success;
    }

    public ArrayList<User> getUsers() {
        return Users;
    }
}
