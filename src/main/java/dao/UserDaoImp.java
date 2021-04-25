package dao;


import entity.User;
import exception.user.UserException;
import exception.user.UserNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImp implements UserDao {
    private static List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return new ArrayList<>(users);
    }

    public void saveUser(User user) throws UserException {
        users.add(user);
    }

    public boolean containsUsername(String username){
        for (User user : users) {
            if (user.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }

    public boolean containsUsernameAndPassword(String username, String password){
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    @Override
    public User findUserByUsername(String username) throws UserNotFoundException {
        for (User user : users) {
            if (user.getUsername().equals(username)){
                return user;
            }
        }
        throw new UserNotFoundException("User not found");
    }

    public void updatePassword(User user,String newPassword) throws UserException {
        for (User user1 : users) {
            if (user1.getUsername().equals(user.getUsername())){
                user1.setPassword(newPassword);
                break;
            }
        }
    }
}
