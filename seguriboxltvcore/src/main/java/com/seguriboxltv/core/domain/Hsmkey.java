package com.seguriboxltv.core.domain;

import com.seguridata.certificate.SDCertificates;
import com.seguridata.certificate.bean.Certificate;
import com.seguridata.certificate.sdexception.SDException;
import java.sql.Date;
import java.util.Arrays;

//Clase dominio que representa las propiedades de la tabla AlgorithmHistory HSMKey
public class Hsmkey {

    private int hsmkeyId;
    private int algorithmSignId;
    private String keyTag;
    private int keySize;
    private String oid;
    private Date referenceDate;
    private boolean isActive;
    private byte[] certificate;
    private Date certificateExpiration;
    SDCertificates sdCertificates = new SDCertificates();
    Certificate Certificate = null;

    public Hsmkey() {
    }

    public Hsmkey(int hsmkeyId, int algorithmSignId, String keyTag, int keySize, String oid, Date referenceDate,
            boolean isActive, byte[] certificate, Date certificateExpiration) {
        super();
        this.hsmkeyId = hsmkeyId;
        this.algorithmSignId = algorithmSignId;
        this.keyTag = keyTag;
        this.keySize = keySize;
        this.oid = oid;
        this.referenceDate = referenceDate;
        this.isActive = isActive;
        this.certificate = certificate;
        this.certificateExpiration = certificateExpiration;
    }

    public int getHsmkeyId() {
        return hsmkeyId;
    }

    public void setHsmkeyId(int hsmkeyId) {
        this.hsmkeyId = hsmkeyId;
    }

    public int getAlgorithmSignId() {
        return algorithmSignId;
    }

    public void setAlgorithmSignId(int algorithmSignId) {
        this.algorithmSignId = algorithmSignId;
    }

    public String getKeyTag() {
        return keyTag;
    }

    public void setKeyTag(String keyTag) {
        this.keyTag = keyTag;
    }

    public int getKeySize() {
        return keySize;
    }

    public void setKeySize(int keySize) {
        this.keySize = keySize;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Date getReferenceDate() {
        return referenceDate;
    }

    public void setReferenceDate(Date referenceDate) {
        this.referenceDate = referenceDate;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public byte[] getCertificate() {
        return certificate;
    }

    public void setCertificate(byte[] certificate) throws SDException {
        this.certificate = certificate;
        Certificate = sdCertificates.decodeCertificate(certificate);
    }

    public Date getCertificateExpiration() {
        return (Date) Certificate.getNotBefore();
    }

    
    @Override
    public String toString() {
        return "Hsmkey [hsmkeyId=" + hsmkeyId + ", algorithmSignId=" + algorithmSignId + ", keyTag=" + keyTag
                + ", keySize=" + keySize + ", oid=" + oid + ", referenceDate=" + referenceDate + ", isActive="
                + isActive + ", certificate=" + Arrays.toString(certificate) + ", certificateExpiration="
                + certificateExpiration + "]";
    }

}
