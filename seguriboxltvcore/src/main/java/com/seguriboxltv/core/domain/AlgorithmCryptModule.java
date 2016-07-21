package com.seguriboxltv.core.domain;

import com.seguridata.crypto.CryptoModule;
import com.seguridata.crypto.bean.AssymetricAlgs;
import com.seguridata.crypto.bean.HashAlgs;
import com.seguridata.crypto.bean.SymmetricAlgs;
import com.seguridata.crypto.sdexception.SDException;
import java.util.Date;
import java.util.List;

//Clase dominio que representa las propiedades de la tabla AlgorithmCryptModule
public class AlgorithmCryptModule {

    short cryptoModuleId;
    Date dateReference;
    Date expirationDate;
    String moduleVersion;
    String description;
    boolean isActive;

    public AlgorithmCryptModule() {
    }

    public short getCryptoModuleId() {
        return cryptoModuleId;
    }

    public void setCryptoModuleId(short cryptoModuleId) {
        this.cryptoModuleId = cryptoModuleId;
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

    public String getModuleVersion() {
        return moduleVersion;
    }

    public void setModuleVersion(String moduleVersion) {
        this.moduleVersion = moduleVersion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public List<HashAlgs> GetAlgorithmHash() throws SDException {

        return new CryptoModule().getHashAlgs();
    }

    public List<AssymetricAlgs> GetAssymetricAlgs() throws SDException {

        return new CryptoModule().getAssymetricAlgs();
    }

    public List<SymmetricAlgs> GetSymmetricAlgs() throws SDException {

        return new CryptoModule().getSymmetricAlgs();
    }

    @Override
    public String toString() {
        return "AlgorithmCryptModule{" + "cryptoModuleId=" + cryptoModuleId + ", dateReference=" + dateReference + ", expirationDate=" + expirationDate + ", moduleVersion=" + moduleVersion + ", description=" + description + ", isActive=" + isActive + '}';
    }
    
}
