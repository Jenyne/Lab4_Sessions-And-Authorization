/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Nykke
 */
public class AccountService {

    public User login(String username, String password) {
        User user = new User();
        username = username.toLowerCase();
        switch (username) {
            case "adam":
                if (password.equals("password")) {
                    user.setUsername("adam");
                    user.setPassword("");
                    return user;
                }else if(!password.equals("password")) {
                    user.setUsername("Wrong Username or Password");
                    user.setPassword("");
                    return user;
                }
                break;
            case "betty":
                if (password.equals("password")) {
                    user.setUsername("betty");
                    user.setPassword("");
                    return user;
                }else if(!password.equals("password")) {
                    user.setUsername("Wrong Username or Password");
                    user.setPassword("");
                    return user;
                }
                break;
            case "admin":
                if (password.equals("password")) {
                    user.setUsername("admin");
                    user.setPassword("");
                    return user;
                }else if(!password.equals("password")) {
                    user.setUsername("Wrong Username or Password");
                    user.setPassword("");
                    return user;
                }
                break;
            default:
                user = null;
        }
        return user;

    }
}
