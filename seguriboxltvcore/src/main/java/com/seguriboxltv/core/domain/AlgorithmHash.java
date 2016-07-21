package com.seguriboxltv.core.domain;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Date;

//Clase dominio que representa las propiedades de la tabla AlgorithmHash
public class AlgorithmHash {

    int algorithmHashId;
    short criptoModuleId;
    Date dateReference;
    Date expirationDate;
    String algorithmName;
    String algorithmDescription;
    String oid;
    byte[] binOid;
    int bits;
    int bytes;
    int Secure;
    boolean isActive;
    private String binOidToString;
    private String isActiveStr;

    public AlgorithmHash() {
    }

    public String getIsActiveStr() {
        
        String  ia="";
        
        if(isActive==true){
            ia="Activo";
        }else{
            ia="Desactivado";
        }
        return ia;
    }
    
    

    public int getAlgorithmHashId() {
        return algorithmHashId;
    }

    public void setAlgorithmHashId(int algorithmHashId) {
        this.algorithmHashId = algorithmHashId;
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

    public byte[] getBinOid() {
        return binOid;
    }

    public void setBinOid(byte[] bs) {
        this.binOid = bs;
    }

    public int getBits() {
        return bits;
    }

    public void setBits(int bits) {
        this.bits = bits;
    }

    public int getBytes() {
        return bytes;
    }

    public void setBytes(int bytes) {
        this.bytes = bytes;
    }

    public int getSecure() {
        return Secure;
    }

    public void setSecure(int secure) {
        Secure = secure;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getBinOidToString() {
        return Arrays.toString(binOid);
    }

    @Override
    public String toString() {
        return "AlgorithmHash{" + "algorithmHashId=" + algorithmHashId + ", criptoModuleId=" + criptoModuleId + ", dateReference=" + dateReference + ", expirationDate=" + expirationDate + ", algorithmName=" + algorithmName + ", algorithmDescription=" + algorithmDescription + ", oid=" + oid + ", binOid=" + binOid + ", bits=" + bits + ", bytes=" + bytes + ", Secure=" + Secure + ", isActive=" + isActive + ", binOidToString=" + binOidToString + '}';
    }

}
