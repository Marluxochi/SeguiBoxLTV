package com.seguriboxltv.core.domain;

import java.util.Date;

public class AuditTrail {

    private int recordId;
    private int userId;
    private Date eventDate;
    private Short eventCode;
    private Byte categoryCode;
    private String userHostIp;
    private String objectName;
    private Integer objectId;
    private String instanceName;
    private String notes;
    private String FullUserName;

    public AuditTrail() {
    }

    public AuditTrail(int recordId, Date eventDate) {
        this.recordId = recordId;
        this.eventDate = eventDate;
    }

    public AuditTrail(int recordId, int userId, Date eventDate, Short eventCode, Byte categoryCode, String userHostIp,
            String objectName, Integer objectId, String instanceName, String notes) {
        this.recordId = recordId;
        this.userId = userId;
        this.eventDate = eventDate;
        this.eventCode = eventCode;
        this.categoryCode = categoryCode;
        this.userHostIp = userHostIp;
        this.objectName = objectName;
        this.objectId = objectId;
        this.instanceName = instanceName;
        this.notes = notes;
    }

    public int getRecordId() {
        return this.recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public int getUsers() {
        return this.userId;
    }

    public void setUsers(int users) {
        this.userId = users;
    }

    public Date getEventDate() {
        return this.eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Short getEventCode() {
        return this.eventCode;
    }

    public void setEventCode(Short eventCode) {
        this.eventCode = eventCode;
    }

    public Byte getCategoryCode() {
        return this.categoryCode;
    }

    public void setCategoryCode(Byte categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getUserHostIp() {
        return this.userHostIp;
    }

    public void setUserHostIp(String userHostIp) {
        this.userHostIp = userHostIp;
    }

    public String getObjectName() {
        return this.objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public Integer getObjectId() {
        return this.objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public String getInstanceName() {
        return this.instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getFullUserName() {
        return FullUserName;
    }

    public void setFullUserName(String FullUserName) {
        this.FullUserName = FullUserName;
    }

}
