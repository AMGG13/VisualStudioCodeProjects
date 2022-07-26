package OBJECTS;

import EXCEPTIONS.IncorrectPasswordException;
import EXCEPTIONS.TooShortIDException;
import java.util.Objects;

public class User {
    protected String id;
    protected String password;

    public User(String id, String password) throws TooShortIDException, IncorrectPasswordException {
        setId(id);
        setPassword(password);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) throws TooShortIDException {
        int large;
        large = id.length();
        if(large <4){
            throw new TooShortIDException();
        }
        else{
            this.id=id;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws IncorrectPasswordException {
        int large;
        large = password.length();
        if(large<8){
            throw new IncorrectPasswordException();
        }else
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId().equals(user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
