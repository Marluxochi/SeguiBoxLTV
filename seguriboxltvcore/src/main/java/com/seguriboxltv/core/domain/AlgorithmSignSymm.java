package com.seguriboxltv.core.domain;

import java.util.Date;

//Clase dominio que representa las propiedades de la tabla AlgorithmSignSymm
public class AlgorithmSignSymm {

    private int assymetricId;
    private int hashId;
    private int algorithmSignId;
    private short criptoModuleId;
    private Date dateReference;
    private Date expirationDate;
    private String algorithmName;
    private String algorithmDescription;
    private String oid;
    private byte[] binOid;
    private byte[] hashBin;
    private byte[] asymmBin;
    private boolean isActive;
    private int a;
    private String hashName;
    private String asymetricName;
    private String status;

    public String getHashName() {
        return hashName;
    }

    public void setHashName(String hashName) {
        this.hashName = hashName;
    }

    public String getAsymetricName() {
        return asymetricName;
    }

    public void setAsymetricName(String asymetricName) {
        this.asymetricName = asymetricName;
    }

    public String getStatus() {
        String sts;
        if(isActive==true){
            sts="Activo";
        }else{
            sts="Desactivado";
        }
        return sts;
    }

    
    public int getAlgorithmSignId() {
        return algorithmSignId;
    }

    public void setAlgorithmSignId(int algorithmSignId) {
        this.algorithmSignId = algorithmSignId;
    }

    public short getCriptoModuleId() {
        return criptoModuleId;
    }

    public void setCriptoModuleId(short criptoModuleId) {
        this.criptoModuleId = criptoModuleId;
    }

    public Date getDateReference() {
        return dateReference;
    }

    public void setDateReference(Date dateReference) {
        this.dateReference = dateReference;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getAlgorithmName() {
        return algorithmName;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public String getAlgorithmDescription() {
        return algorithmDescription;
    }

    public void setAlgorithmDescription(String algorithmDescription) {
        this.algorithmDescription = algorithmDescription;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public byte[] getHashBin() {
        return hashBin;
    }

    public void setHashBin(byte[] bs) {
        this.hashBin = bs;
    }

    public byte[] getAsymmBin() {
        return asymmBin;
    }

    public void setAsymmBin(byte[] bs) {
        this.asymmBin = bs;
    }

    public byte[] getBinOid() {
        return binOid;
    }

    public void setBinOid(byte[] bs) {
        this.binOid = bs;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public int getAssymetricId() {
        return assymetricId;
    }

    public void setAssymetricId(int assymetricId) {
        this.assymetricId = assymetricId;
    }

    public int getHashId() {
        return hashId;
    }

    public void setHashId(int hashId) {
        this.hashId = hashId;
    }

    @Override
    public String toString() {
        return "AlgorithmSignSymm{" + "assymetricId=" + assymetricId + ", hashId=" + hashId + ", algorithmSignId=" + algorithmSignId + ", criptoModuleId=" + criptoModuleId + ", dateReference=" + dateReference + ", expirationDate=" + expirationDate + ", algorithmName=" + algorithmName + ", algorithmDescription=" + algorithmDescription + ", oid=" + oid + ", binOid=" + binOid + ", hashBin=" + hashBin + ", asymmBin=" + asymmBin + ", isActive=" + isActive + ", a=" + a + '}';
    }

}
