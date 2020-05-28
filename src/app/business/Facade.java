package app.business;

import app.business.model.User;


public interface Facade {
    /**
     * Login method 
     * @param username
     * @param password
     * @return user or null if user not exist
     */
    public User login(String username, String password);
}
