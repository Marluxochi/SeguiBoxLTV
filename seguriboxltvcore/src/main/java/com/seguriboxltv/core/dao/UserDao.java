package com.seguriboxltv.core.dao;

import com.seguriboxltv.core.domain.User;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    public int Create(User user, String userName, String hostName) throws SQLException, Exception ;

    public void Delete(String userName, String invokedBy, String hostIP) throws SQLException, Exception;

    public User GetByUserName(String userName)throws SQLException, Exception ;

    public User GetById(int id)throws SQLException, Exception ;

    public void Lock(String userName, String invokedBy, String hostIP)throws SQLException, Exception;

    public  void Save(User user, String invokedBy, String hostIP)throws SQLException, Exception ;

    public List<User> Search(String search, short pageSize, short currentPage, int recordCount)throws SQLException, Exception ;

    public void SignIn(String userName, String ipAdress)throws SQLException, Exception;

    public void SignOut(int userId) throws SQLException, Exception;

    public User GetStateByUserName(String userName)throws SQLException, Exception;

    public User GetStateById(int id) throws SQLException, Exception;

    public void Unlock(String userName, String invokedBy, String HostIP) throws SQLException, Exception ;
    
     public void ResetPassword(String userName,String password)throws SQLException, Exception ;
     
     public int  MembershipValidateUser(String userName,String password,String hostName)throws SQLException, Exception;
}
