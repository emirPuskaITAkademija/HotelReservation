package app.business;

import app.business.model.Privilege;
import app.business.model.User;
import java.util.List;


public interface Facade {
    /**
     * Login method 
     * @param username
     * @param password
     * @return user or null if user not exist
     */
    public User login(String username, String password);
    
    
    /**
     * metodu koja čita korisnike iz baze
     * 
     */
    public List<User> getAllUsers();
    
    public List<Privilege> getAllPrivileges();
    
    public void saveUser(User user);
    
    public void deleteUser(User user);
    
    public void updateUser(User user);
}
