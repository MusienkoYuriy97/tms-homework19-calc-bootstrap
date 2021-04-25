package service;

import dao.UserDao;
import dao.UserDaoImp;
import entity.User;
import exception.user.InputDataUserException;
import exception.user.UserDataException;
import exception.user.UserException;

import java.util.List;

public class UserService {
    UserDao userDao = new UserDaoImp();

    public void userRegister(String username, String fname,String lname, int age, String password) throws UserException {
        if (username == null || password == null){
            throw new InputDataUserException("Enter at least your username and password");
        }
        if (userDao.containsUsername(username)){
            throw new UserDataException("User already exist");
        }
        userDao.saveUser(new User(username,fname,lname,age,password));
    }

    public List<User> getUsersList(){
        return userDao.getUsers();
    }

    public User getUserLoggedIn(String username, String password) throws UserException {
        if (username == null && password == null){
            throw new InputDataUserException("Please enter both of your password and username");
        }
        if (!userDao.containsUsernameAndPassword(username,password)){
            throw new InputDataUserException("Wrong username or password.\n" +
                    "Please enter both of your password and username correctly.");
        }
        return userDao.findUserByUsername(username);
    }

    public void updatePassword(User user, String password1,String password2) throws UserException {
        if (!password1.equals(password2)){
            throw new UserDataException("Your password was not changed. New password and repeated new password did not match.");
        }else {
            if (user.getPassword().equals(password2)){
                throw new UserDataException("You cannot use this old password because it has been compromised.");
            }
        }
        userDao.updatePassword(user,password1);
    }
}
