package com.seguriboxltv.core.dao.impl;

import com.seguriboxltv.core.dao.UserDao;
import com.seguriboxltv.core.domain.User;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private DataSource dataSource;
    private Connection conn;
    private String sql = "";
    private int returnCode = 0;
    private String returnMessage = "";
    private CallableStatement cstmt = null;
    private ResultSet rsl = null;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public int Create(User user, String userName, String hostName) throws SQLException, Exception {
        sql = "{call UserCreate(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

        try {
            conn = dataSource.getConnection();
            cstmt = conn.prepareCall(sql);
            //cstmt.setInt("UserId",user.getUserId()); No esta en SP           
            //cstmt.setString("Prefix",user.getPrefix());No esta en SP
            cstmt.setString("UserName", user.getUsername()); //1
            cstmt.setString("Password", user.getPassword()); //2
            cstmt.setString("FirstName", user.getFirstName());//3
            cstmt.setString("MiddleName", user.getMiddleName());//4
            cstmt.setString("LastName", user.getLastName());           //5 
            cstmt.setString("Telefono", user.getTelNumber());//6
            cstmt.setString("RFC", user.getRfc());//7            
            cstmt.setString("CURP", user.getCurp());//8
            cstmt.setString("Puesto", user.getPuesto());//9
            cstmt.setString("Identificador", user.getIdentificador());//10
            cstmt.setString("Calle", user.getCalle());//11
            cstmt.setString("Numero", user.getNumero());//12
            cstmt.setString("CodigoPostal", user.getCodigoPostal());//13
            cstmt.setString("Municipio", user.getMunicipio());//14
            cstmt.setString("Colonia", user.getColonia());//15            
            cstmt.setString("Estado", user.getEstado());//16
            cstmt.setInt("CountryCode", user.getCountryCode());//17 //Is Strng or Int
            cstmt.setByte("AuthenticationMode", user.getAuthenticationMode());//18            
            cstmt.setShort("UserType", user.getUserType());//19
            cstmt.setBoolean("OnlyReader", user.isOnlyReader());//20
            cstmt.setBytes("Certificate", user.getCertificate());//21
            cstmt.setString("Hash256Certificate", user.getHash256certificate());//22
            cstmt.setString("Email", user.getEmail());//23
            cstmt.setString("InvokedBy", userName);//24 Maybe it will change 
            cstmt.setString("HostIP", hostName);//25 Maybe it will change 
            rsl = cstmt.executeQuery();
            if (!rsl.next()) {
                throw new Exception("El store procedure no retorno codigo");
            } else {

                returnCode = rsl.getInt("ReturnCode");
                returnMessage = rsl.getString("ReturnMessage");

                if (returnCode > 0) {

                    throw new Exception(returnMessage);
                } else {

                    System.out.println("El registro se creo correctamente");
                }
            }

        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
        return 0;
    }

    @Override
    public void Delete(String username, String userName, String hostName) throws SQLException, Exception {
        sql = "{call UserDelete(?,?,?)}";
        try {
            conn = dataSource.getConnection();
            cstmt = conn.prepareCall(sql);
            cstmt.setString("UserName", username);
            cstmt.setString("InvokedBy", userName);
            cstmt.setString("HostIP", hostName);
            rsl = cstmt.executeQuery();
            if (!rsl.next()) {
                throw new Exception("El store procedure no retorno codigo");
            } else {
                returnCode = rsl.getInt("ReturnCode");
                returnMessage = rsl.getString("ReturnMessage");
                if (returnCode > 0) {
                    throw new Exception(returnMessage);
                } else {

                    System.out.println("El registro se elimino correctamente");
                }
            }

        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public User GetByUserName(String userName) throws SQLException, Exception {
        sql = "{call UserGet(?)}";
        User user = new User();

        try {
            conn = dataSource.getConnection();

            cstmt = conn.prepareCall(sql);
            cstmt.setString("UserName", userName);
            rsl = cstmt.executeQuery();

            if (!rsl.next()) {

                throw new Exception("No existe registro en la base de datos con el username: " + userName);
            } else {

                user.setUserId(rsl.getInt("UserId"));
                user.setUserType(rsl.getByte("UserType"));
                user.setOnlyReader(rsl.getBoolean("OnlyReader"));
                user.setUsername(rsl.getString("UserName"));
                user.setPrefix(rsl.getString("Prefix"));
                user.setFirstName(rsl.getString("FirstName"));
                user.setMiddleName(rsl.getString("MiddleName"));
                user.setLastName(rsl.getString("LastName"));
                user.setRfc(rsl.getString("RFC"));
                user.setCurp(rsl.getString("CURP"));
                user.setPuesto(rsl.getString("Puesto"));
                user.setIdentificador(rsl.getString("Identificador"));
                user.setCalle(rsl.getString("Calle"));
                user.setNumero(rsl.getString("Numero"));
                user.setCodigoPostal(rsl.getString("CodigoPostal"));
                user.setMunicipio(rsl.getString("Municipio"));
                user.setColonia(rsl.getString("Colonia"));
                user.setEstado(rsl.getString("Estado"));
                user.setAuthenticationMode(rsl.getByte("AuthenticationMode"));
                user.setCertificate(rsl.getBytes("Certificate"));
                user.setHash256certificate(rsl.getString("Hash256Certificate"));
                user.setActive(rsl.getBoolean("IsActive"));
                user.setEmail(rsl.getString("Email"));
                user.setTelNumber(rsl.getString("TelNumber"));
                user.setCountryCode(rsl.getInt("CountryCode"));//String or Int
                user.setLockedOut(rsl.getBoolean("IsLockedOut"));
                user.setLastSigninDate(rsl.getDate("LastSigninDate"));
                user.setReferenceDate(rsl.getDate("ReferenceDate"));
                user.setLastUpdated(rsl.getDate("LastUpdated"));
                user.setIpaddress(rsl.getString("IPAddress"));
                user.setStatusId(rsl.getByte("StatusId"));
                user.setLastUserLogRecordId(rsl.getInt("LastUserLogRecordId"));
                user.setLastActivityDate(rsl.getDate("LastActivityDate"));
            }

        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
        return user;
    }

    @Override
    public User GetById(int id) throws SQLException, Exception {
        sql = "{call UserGetById(?)}";
        User user = new User();

        try {
            conn = dataSource.getConnection();
            cstmt = conn.prepareCall(sql);
            cstmt.setInt("UserId", id);
            rsl = cstmt.executeQuery();

            if (!rsl.next()) {

                throw new Exception("No existe registro en la base de datos con el id: " + id);
            } else {

                user.setUserId(rsl.getInt("UserId"));
                user.setUserType(rsl.getByte("UserType"));
                user.setOnlyReader(rsl.getBoolean("OnlyReader"));
                user.setUsername(rsl.getString("UserName"));
                user.setPrefix(rsl.getString("Prefix"));
                user.setFirstName(rsl.getString("FirstName"));
                user.setMiddleName(rsl.getString("MiddleName"));
                user.setLastName(rsl.getString("LastName"));
                user.setRfc(rsl.getString("RFC"));
                user.setCurp(rsl.getString("CURP"));
                user.setPuesto(rsl.getString("Puesto"));
                user.setIdentificador(rsl.getString("Identificador"));
                user.setCalle(rsl.getString("Calle"));
                user.setNumero(rsl.getString("Numero"));
                user.setCodigoPostal(rsl.getString("CodigoPostal"));
                user.setMunicipio(rsl.getString("Municipio"));
                user.setColonia(rsl.getString("Colonia"));
                user.setEstado(rsl.getString("Estado"));
                user.setAuthenticationMode(rsl.getByte("AuthenticationMode"));
                user.setCertificate(rsl.getBytes("Certificate"));
                user.setHash256certificate(rsl.getString("Hash256Certificate"));
                user.setActive(rsl.getBoolean("IsActive"));
                user.setEmail(rsl.getString("Email"));
                user.setTelNumber(rsl.getString("TelNumber"));
                user.setCountryCode(rsl.getInt("CountryCode"));
                user.setLockedOut(rsl.getBoolean("IsLockedOut"));
                user.setLastSigninDate(rsl.getDate("LastSigninDate"));
                user.setReferenceDate(rsl.getDate("ReferenceDate"));
                user.setLastUpdated(rsl.getDate("LastUpdated"));
                user.setIpaddress(rsl.getString("IPAddress"));
                user.setStatusId(rsl.getByte("StatusId"));
                user.setLastUserLogRecordId(rsl.getInt("LastUserLogRecordId"));
                user.setLastActivityDate(rsl.getDate("LastActivityDate"));

            }

        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
        return user;
    }

    @Override
    public void Lock(String username, String userName, String hostName) throws SQLException, Exception {
        sql = "{call UserLock(?,?,?)}";
        try {
            conn = dataSource.getConnection();
            cstmt = conn.prepareCall(sql);
            cstmt.setString("UserName", username);
            cstmt.setString("InvokedBy", userName);
            cstmt.setString("HostIP", hostName);
            rsl = cstmt.executeQuery();
            if (!rsl.next()) {
                throw new Exception("El store procedure no retorno codigo");
            } else {

                returnCode = rsl.getInt("ReturnCode");
                returnMessage = rsl.getString("ReturnMessage");

                if (returnCode > 0) {

                    throw new Exception(returnMessage);
                } else {

                    System.out.println("El registro se bloqueo correctamente");
                }
            }

        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public void Save(User user, String userName, String hostName) throws SQLException, Exception {

        sql = "{call UserSave(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";//26 Items

        try {
            conn = dataSource.getConnection();
            cstmt = conn.prepareCall(sql);
            cstmt.setInt("UserId", user.getUserId());
            cstmt.setString("UserName", user.getUsername());
            cstmt.setString("FirstName", user.getFirstName());
            cstmt.setString("MiddleName", user.getMiddleName());
            cstmt.setString("LastName", user.getLastName());
            cstmt.setString("Telefono", sql);
            cstmt.setString("RFC", user.getRfc());
            cstmt.setString("CURP", user.getCurp());
            cstmt.setString("Puesto", user.getPuesto());
            cstmt.setString("Identificador", user.getIdentificador());
            cstmt.setString("Calle", user.getCalle());
            cstmt.setString("Numero", user.getNumero());
            cstmt.setString("CodigoPostal", user.getCodigoPostal());
            cstmt.setString("Municipio", user.getMunicipio());
            cstmt.setString("Colonia", user.getColonia());
            cstmt.setString("Estado", user.getEstado());
            cstmt.setInt("CountryCode", user.getCountryCode());
            cstmt.setByte("AuthenticationMode", user.getAuthenticationMode());
            cstmt.setShort("UserType", user.getUserType());
            cstmt.setBoolean("OnlyReader", true);
            cstmt.setBytes("Certificate", user.getCertificate());
            cstmt.setString("Hash256Certificate", user.getHash256certificate());
            cstmt.setString("Email", user.getEmail());
            cstmt.setBoolean("IsActive", user.isActive());
            cstmt.setString("InvokedBy", userName);
            cstmt.setString("HostIP", hostName);
            rsl = cstmt.executeQuery();

            if (!rsl.next()) {

                throw new Exception("El store procedure no retorno codigo");
            } else {

                returnCode = rsl.getInt("ReturnCode");
                returnMessage = rsl.getString("ReturnMessage");

                if (returnCode > 0) {

                    throw new Exception(returnMessage);
                } else {

                    System.out.println("El registro se salvo correctamente");
                }
            }

        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<User> Search(String search, short pageSize, short currentPage, int recordCount) throws SQLException, Exception {

        sql = "{call UserSearch(?,?,?,?)}"; //No SP
        User user = null;
        int recordCounter = 0;
        List<User> list = new ArrayList<>();
        try {
            conn = dataSource.getConnection();
            cstmt = conn.prepareCall(sql);
            cstmt.setString("SearchName", search);
            cstmt.setShort("PageSize", pageSize);
            cstmt.setShort("CurrentPage", currentPage);
            cstmt.registerOutParameter("RecordCount", Types.INTEGER);
            rsl = cstmt.executeQuery();

            while (rsl.next()) {
                user = new User();
                user.setUserId(rsl.getInt("UserId"));
                user.setUsername(rsl.getString("UserName"));
                user.setFirstName(rsl.getString("FirstName"));
                user.setMiddleName(rsl.getString("MiddleName"));
                user.setLastName(rsl.getString("LastName"));
                user.setActive(rsl.getBoolean("IsActive"));
                user.setLockedOut(rsl.getBoolean("IsLockedOut"));
                list.add(user);
            }

            recordCounter = cstmt.getInt("RecordCount");
            System.out.println(recordCounter);

        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
        return list;
    }

    @Override
    public void SignIn(String username, String ipAdress) throws SQLException, Exception {
        sql = "{call UserSignIn(?,?)}";

        try {
            conn = dataSource.getConnection();
            cstmt = conn.prepareCall(sql);
            cstmt.setString("UserName", username);
            cstmt.setString("IPAddress", ipAdress);
            rsl = cstmt.executeQuery();

            if (!rsl.next()) {

                throw new Exception("El store procedure no retorno codigo");
            } else {

                returnCode = rsl.getInt("ReturnCode");
                returnMessage = rsl.getString("ReturnMessage");

                if (returnCode > 0) {

                    throw new Exception(returnMessage);
                } else {

                    System.out.println("La operación se realizo con exito");
                }
            }

        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public void SignOut(int userId) throws SQLException, Exception {

        sql = "{call UserSignOut(?)}";

        try {
            conn = dataSource.getConnection();
            cstmt = conn.prepareCall(sql);
            cstmt.setInt("UserId", userId);
            rsl = cstmt.executeQuery();

            if (!rsl.next()) {

                throw new Exception("El store procedure no retorno codigo");
            } else {

                returnCode = rsl.getInt("ReturnCode");
                returnMessage = rsl.getString("ReturnMessage");

                if (returnCode > 0) {

                    throw new Exception(returnMessage);
                } else {

                    System.out.println("La operación se realizo con exito");
                }
            }

        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public User GetStateByUserName(String userName) throws SQLException, Exception {
        sql = "{call UserStateGet(?)}";
        User user = new User();

        try {
            conn = dataSource.getConnection();
            cstmt = conn.prepareCall(sql);
            cstmt.setString("UserName", userName);
            boolean results = cstmt.execute();
            int rsCount = 0;

            while (results) {

                rsl = cstmt.getResultSet();
                rsCount++;
                while (rsl.next()) {
                    if (rsCount == 1) {
                        returnCode = rsl.getInt("ReturnCode");
                        returnMessage = rsl.getString("ReturnMessage");
                        if (returnCode > 0) {

                            throw new Exception(returnMessage);
                        } else {
                            System.out.println("La busqueda fue realizada con existo");
                        }
                    } else {

                        user.setUserId(rsl.getInt("UserId"));
                        user.setUsername(rsl.getString("UserName"));
                        user.setStatusId(rsl.getByte("StatusId"));
                        user.setFirstName(rsl.getString("FirstName"));
                        user.setMiddleName(rsl.getString("MiddleName"));
                        user.setLastName(rsl.getString("LastName"));
                        user.setAuthenticationMode(rsl.getByte("AuthenticationMode"));
                        user.setUserType(rsl.getByte("UserType"));
                        user.setIpaddress(rsl.getString("IPAddress"));
                    }
                }
                rsl.close();

                results = cstmt.getMoreResults();
            }

            cstmt.close();

        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }

        return user;
    }

    @Override
    public User GetStateById(int id) throws SQLException, Exception {
        sql = "{call UserStateGetById(?)}";
        User user = new User();

        try {
            conn = dataSource.getConnection();
            cstmt = conn.prepareCall(sql);
            cstmt.setInt("UserId", id);
            boolean results = cstmt.execute();
            int rsCount = 0;

            while (results) {

                rsl = cstmt.getResultSet();
                rsCount++;
                while (rsl.next()) {
                    if (rsCount == 1) {
                        returnCode = rsl.getInt("ReturnCode");
                        returnMessage = rsl.getString("ReturnMessage");
                        if (returnCode > 0) {

                            throw new Exception(returnMessage);
                        } else {
                            System.out.println("La busqueda fue realizada con existo");
                        }
                    } else {

                        user.setUserId(rsl.getInt("UserId"));
                        user.setUsername(rsl.getString("UserName"));
                        user.setStatusId(rsl.getByte("StatusId"));
                        user.setFirstName(rsl.getString("FirstName"));
                        user.setMiddleName(rsl.getString("MiddleName"));
                        user.setLastName(rsl.getString("LastName"));
                        user.setAuthenticationMode(rsl.getByte("AuthenticationMode"));
                        user.setUserType(rsl.getByte("UserType"));
                        user.setIpaddress(rsl.getString("IPAddress"));
                    }
                }
                rsl.close();

                results = cstmt.getMoreResults();
            }

            cstmt.close();

        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }

        return user;
    }

    @Override
    public void Unlock(String userName, String invokedBy, String HostIP) throws SQLException, Exception {

        sql = "{call UserUnLock(?,?,?)}";

        try {
            conn = dataSource.getConnection();
            cstmt = conn.prepareCall(sql);
            cstmt.setString("UserName", userName);
            cstmt.setString("InvokedBy", invokedBy);
            cstmt.setString("HostIP", HostIP);
            cstmt.execute();

        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void ResetPassword(String userName, String password) throws SQLException, Exception {

        sql = "{call ResetPassword(?,?)}";
        try {
            conn = dataSource.getConnection();
            cstmt = conn.prepareCall(sql);
            cstmt.setString(userName, password);
            cstmt.execute();
        } catch (Exception e) {
        }

    }

    @Override
    public int MembershipValidateUser(String userName, String password, String hostName) throws SQLException, Exception {
        sql = "{call MembershipValidateUser(?,?,?)}";
        int userValidation;
        try {
            conn = dataSource.getConnection();
            cstmt = conn.prepareCall(sql);
            cstmt.setString("UserName", userName);
            cstmt.setString("Password", password);
            cstmt.setString("HostName", hostName);
            boolean results = cstmt.execute();
            if (results) {
                rsl = cstmt.getResultSet();
                if (rsl.next()) {
                    returnCode = rsl.getInt("ReturnCode");
                    returnMessage = rsl.getString("ReturnMessage");
                }
                if (returnCode > 0) {
                    throw new Exception(returnMessage);
                }
            }
            userValidation=returnCode;
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
        return userValidation;
    }

}
