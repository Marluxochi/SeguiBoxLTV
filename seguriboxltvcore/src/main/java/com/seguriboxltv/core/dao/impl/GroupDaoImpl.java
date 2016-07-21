/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguriboxltv.core.dao.impl;

import com.seguriboxltv.core.dao.GroupDao;
import com.seguriboxltv.core.domain.Group;
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

/**
 *
 * @author JGM
 */
@Repository
public class GroupDaoImpl implements GroupDao {

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

    //Dao Implementation
    @Override
    public int Save(Group myGroup, String hostName, String userName) throws Exception {
        sql = "{call GroupSave(?,?,?,?,?,?,?,?)}";
        int outParameter;
        try {
            conn = dataSource.getConnection();
            cstmt = conn.prepareCall(sql);
            cstmt.setShort("GroupId", myGroup.getGroupId());
            cstmt.registerOutParameter("GroupId", Types.SMALLINT);
            cstmt.setShort("AreaId",myGroup.getAreaId());
            cstmt.setByte("ProfileType", myGroup.getProfileType());
            cstmt.setString("GroupName", myGroup.getGroupName());
            cstmt.setString("Description", myGroup.getDescription());
            cstmt.setBoolean("IsActive", true);
            cstmt.setString("UserName", userName);
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
            outParameter = cstmt.getShort("GroupId");
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
        return outParameter;
    }

    @Override
    public void Delete(int groupId, String hostName, String userName) throws Exception {
        sql = "{call GroupDelete(?,?,?)}";
        try {
            conn = dataSource.getConnection();
            cstmt = conn.prepareCall(sql);
            cstmt.setInt("GroupId", groupId);
            cstmt.setString("UserName", userName);
            cstmt.setString("HostName", hostName);
            rsl = cstmt.executeQuery();
            if (!rsl.next()) {
                throw new Exception("El Grupo no se guardo correctamente");
            } else {
                returnCode = rsl.getInt("returnCode");
                returnMessage = rsl.getString("returnMessage");
            }
        } catch (SQLException e) {
            throw e;
        } catch (Exception e1) {
            throw e1;
        }
    }

    @Override
    public Group GetByName(String groupName) throws Exception {
        sql = "{call GroupGetByName(?)}";
        Group result;
        try {
            conn = dataSource.getConnection();
            cstmt = conn.prepareCall(sql);
            cstmt.setString("GroupName", groupName);
            rsl = cstmt.executeQuery();
            if (!rsl.next()) {
                throw new Exception("No se pudo realizar la consulta");
            } else {
                result = new Group();
                result.setGroupId(rsl.getShort("GroupId"));
                result.setCreatedByUserId(rsl.getBigDecimal("CreatedByUserId"));
                result.setGroupName(rsl.getString("GroupName"));
                result.setDescription(rsl.getString("Description"));
                result.setIsActive(rsl.getBoolean("IsActive"));
                result.setReferenceDate(rsl.getDate("ReferenceDate"));
                result.setProfileType(rsl.getByte("ProfileType"));
                result.setPreconfigured(rsl.getBoolean("Preconfigured"));
                result.setAreaId(rsl.getShort("AreaId"));
                result.setDeactivatedDate(rsl.getDate("DeactivatedDate"));
                result.setDeactivatedByUserId(rsl.getInt("DeactivatedByUserId"));
            }
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
        return result;
    }

    @Override
    public List<Group> Get(int groupId) throws Exception {

        List<Group> result = new ArrayList<>();
        sql = ("{call GroupGet(?)}");
        try {
            conn = dataSource.getConnection();
            cstmt = conn.prepareCall(sql);
            cstmt.setShort("GroupId", (short) groupId);
            cstmt.registerOutParameter("GroupId", Types.SMALLINT);
            rsl = cstmt.executeQuery();

            while (rsl.next()) {
                Group item = new Group();
                item.setGroupId(rsl.getShort("GroupId"));
                item.setCreatedByUserId(rsl.getBigDecimal("CreatedByUserId"));
                item.setGroupName(rsl.getString("GroupName"));
                item.setDescription(rsl.getString("Description"));
                item.setIsActive(rsl.getBoolean("IsActive"));
                item.setReferenceDate(rsl.getDate("ReferenceDate"));
                item.setProfileType(rsl.getByte("ProfileType"));
                item.setPreconfigured(rsl.getBoolean("Preconfigured"));
                item.setAreaId(rsl.getShort("AreaId"));
                item.setDeactivatedDate(rsl.getDate("DeactivatedDate"));
                item.setDeactivatedByUserId(rsl.getInt("DeactivatedByUserId"));
                result.add(item);
            }

        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
        return result;
    }

    @Override
    public Group GetById(int groupId) throws Exception {
        Group result = null;
        sql = ("{call GroupGet(?)}");
        try {
            conn = dataSource.getConnection();
            cstmt = conn.prepareCall(sql);
            cstmt.setShort("GroupId", (short) groupId);
            cstmt.registerOutParameter("GroupId", Types.SMALLINT);
            rsl = cstmt.executeQuery();
            if (!rsl.next()) {
                throw new Exception("No se ejecuto la consulta");
            } else {
                result = new Group();
                result.setGroupId(rsl.getShort("GroupId"));
                result.setCreatedByUserId(rsl.getBigDecimal("CreatedByUserId"));
                result.setGroupName(rsl.getString("GroupName"));
                result.setDescription(rsl.getString("Description"));
                result.setIsActive(rsl.getBoolean("IsActive"));
                result.setReferenceDate(rsl.getDate("ReferenceDate"));
                result.setProfileType(rsl.getByte("ProfileType"));
                result.setPreconfigured(rsl.getBoolean("Preconfigured"));
                result.setAreaId(rsl.getShort("AreaId"));
                result.setDeactivatedDate(rsl.getDate("DeactivatedDate"));
                result.setDeactivatedByUserId(rsl.getInt("DeactivatedByUserId"));
            }
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
        return result;
    }

    @Override
    public List<User> GetUsers(int groupId) throws Exception {
        User user;
        List<User> result = new ArrayList<>();
        sql = "{call GroupGetUsers(?)}";
        try {
            conn = dataSource.getConnection();
            cstmt = conn.prepareCall(sql);
            cstmt.setShort("GroupId", (short) groupId);
            rsl = cstmt.executeQuery();

            while (rsl.next()) {
                user = new User();
                user.setUserId(rsl.getInt("UserId"));
                user.setUserType(rsl.getByte("UserType"));
                user.setOnlyReader(rsl.getBoolean("OnlyReader"));
                user.setUsername(rsl.getString("UserName"));
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
                result.add(user);

            }

        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
        return result;
    }

    @Override
    public void AddTask(int groupId, int TaskId, String invokedBy, String hostIp) throws Exception {
        sql = "{call GroupAddTask(?,?,?,?)}";
        try {
            conn = dataSource.getConnection();
            cstmt = conn.prepareCall(sql);
            cstmt.setShort("GroupId", (short) groupId);
            cstmt.setShort("TaskId", (short) TaskId);
            cstmt.setString("InvokedBy", invokedBy);
            cstmt.setString("HostIp", hostIp);
            rsl = cstmt.executeQuery();

            if (rsl.next()) {
                returnCode = rsl.getInt("returnCode");
                returnMessage = rsl.getString("returnMessage");
            }
            if (returnCode > 0) {
                throw new Exception(returnMessage);
            }
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public void RemoveTask(int groupId, int TaskId, String invokedBy, String hostIp) throws Exception {
        sql = "{call GroupRemoveTask(?,?,?,?)}";
        try {
            conn = dataSource.getConnection();
            cstmt = conn.prepareCall(sql);
            cstmt.setShort("GroupId", (short) groupId);
            cstmt.setShort("TaskId", (short) TaskId);
            cstmt.setString("InvokedBy", invokedBy);
            cstmt.setString("HostIp", hostIp);
            rsl = cstmt.executeQuery();

            if (rsl.next()) {
                returnCode = rsl.getInt("returnCode");
                returnMessage = rsl.getString("returnMessage");
            }
            if (returnCode > 0) {
                throw new Exception(returnMessage);
            }
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public void addHsmKey(int groupId, int hsmkeyId, String userName, String hostName) throws Exception {
        sql = "{call GroupAddHsmKey(?,?,?,?)}";
        try {
            cstmt = conn.prepareCall(sql);
            cstmt.setShort("GroupId", (short) groupId);
            cstmt.setInt("HsmKeyId", hsmkeyId);
            cstmt.setString("UserName", userName);
            cstmt.setString("HostName", hostName);
            rsl = cstmt.executeQuery();
            if (rsl.next()) {
                returnCode = rsl.getInt("returnCode");
                returnMessage = rsl.getString("returnMessage");
            }
            if (returnCode > 0) {
                throw new Exception(returnMessage);
            }
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void RemoveHsmKey(int groupId, int hsmkeyId, String userName, String hostName) throws Exception {
        sql = "{call GroupRemoveHsmKey(?,?,?,?)}";
        try {
            conn = dataSource.getConnection();
            cstmt = conn.prepareCall(sql);
            cstmt.setShort("GroupId", (short) groupId);
            cstmt.setInt("HsmKeyId", hsmkeyId);
            cstmt.setString("UserName", userName);
            cstmt.setString("HostName", hostName);
            rsl = cstmt.executeQuery();
            if (rsl.next()) {
                returnCode = rsl.getInt("returnCode");
                returnMessage = rsl.getString("returnMessage");
            }
            if (returnCode > 0) {
                throw new Exception(returnMessage);
            }
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void AddUser(int groupId, String userName, String invokedBy, String hostIp) throws Exception {
        sql = "{call GroupAddUser(?,?,?,?)}";
        try {
            conn = dataSource.getConnection();
            cstmt = conn.prepareCall(sql);
            cstmt.setShort("GroupId", (short) groupId);
            cstmt.setString("UserName", userName);
            cstmt.setString("InvokedBy", invokedBy);
            cstmt.setString("HostIp", hostIp);
            rsl = cstmt.executeQuery();
            if (rsl.next()) {
                returnCode = rsl.getInt("returnCode");
                returnMessage = rsl.getString("returnMessage");
            }
            if (returnCode > 0) {
                throw new Exception(returnMessage);
            }
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void RemoveUser(int groupId, String userName, String invokedBy, String hostIp) throws Exception {
        sql = "{call GroupRemoveUser(?,?,?,?)}";
        try {
            conn = dataSource.getConnection();
            cstmt = conn.prepareCall(sql);
            cstmt.setShort("GroupId", (short) groupId);
            cstmt.setString("UserName", userName);
            cstmt.setString("InvokedBy", invokedBy);
            cstmt.setString("HostIp", hostIp);
            rsl = cstmt.executeQuery();
            if (rsl.next()) {
                returnCode = rsl.getInt("returnCode");
                returnMessage = rsl.getString("returnMessage");
            }
            if (returnCode > 0) {
                throw new Exception(returnMessage);
            }
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

}
