package com.seguriboxltv.core.domain;

import java.sql.Date;
import java.util.Arrays;

//Clase dominio que representa las propiedades de la tabla AlgorithmAsymmetric
public class AlgorithmAsymmetric {

    int algorithmAsymmetricId;
    short cryptoModuleId;
    Date referenceDate;
    Date expirationDate;
    String algorithmName;
    String algorithmDescription;
    String oid;
    byte[] binOid;
    int minBits;
    int maxBits;
    int deltaBits;
    int minSecureBits;
    int secure;
    boolean isActive;
    private String binOidToString;

    public AlgorithmAsymmetric() {
    }

    public int getAlgorithmAsymmetricId() {
        return algorithmAsymmetricId;
    }

    public void setAlgorithmAsymmetricId(int algorithmAsymmetricId) {
        this.algorithmAsymmetricId = algorithmAsymmetricId;
    }

    public short getCryptoModuleId() {
        return cryptoModuleId;
    }

    public void setCryptoModuleId(short cryptoModuleId) {
        this.cryptoModuleId = cryptoModuleId;
    }

    public Date getDateReference() {
        return referenceDate;
    }

    public void setDateReference(Date dateReference) {
        this.referenceDate = dateReference;
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

    public void setBinOid(byte[] binOid) {
        this.binOid = binOid;
    }

    public int getMinBits() {
        return minBits;
    }

    public void setMinBits(int minBits) {
        this.minBits = minBits;
    }

    public int getMaxBits() {
        return maxBits;
    }

    public void setMaxBits(int maxBits) {
        this.maxBits = maxBits;
    }

    public int getDeltaBits() {
        return deltaBits;
    }

    public void setDeltaBits(int deltaBits) {
        this.deltaBits = deltaBits;
    }

    public int getMinSecureBits() {
        return minSecureBits;
    }

    public void setMinSecureBits(int minSecureBits) {
        this.minSecureBits = minSecureBits;
    }

    public int getSecure() {
        return secure;
    }

    public void setSecure(int secure) {
        this.secure = secure;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }


    public String getBinOidToString() {
        return Arrays.toString(binOid);
    }
    
    

   

}
