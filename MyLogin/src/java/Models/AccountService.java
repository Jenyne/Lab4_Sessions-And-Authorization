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
        switch (username) {
            case "adam":
                if (password == "password") {
                    user.setUsername("adam");
                    return user;
                }
                break;
            case "betty":
                if (password == "password") {
                    user.setUsername("betty");
                    return user;
                }
                break;
            case "admin":
                if (password == "password") {
                    user.setUsername("admin");
                    return user;
                }
                break;
        }
        return user;
    }
}
