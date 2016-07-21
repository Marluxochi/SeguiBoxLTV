package com.seguriboxltv.core.domain;

import java.util.Date;

public class User {

	private int userId;
	private byte userType;
	private boolean onlyReader;
	private String username;
	private String password;
	private String prefix;
	private String firstName;
	private String middleName;
	private String lastName;
	private String rfc;
	private String curp;
	private String puesto;
	private String identificador;
	private String calle;
	private String numero;
	private String codigoPostal;
	private String municipio;
	private String colonia;
	private String estado;
	private byte authenticationMode;
	private byte[] certificate;
	private String hash256certificate;
	private boolean isActive;
	private String email;
	private String telNumber;
	private Integer countryCode;
	private boolean isLockedOut;
	private Date lastSigninDate;
	private Date referenceDate;
	private Date lastUpdated;
	private String ipaddress;
	private Byte statusId;
	private Integer lastUserLogRecordId;
	private Date lastActivityDate;

	public User() {
	}

	public User(int userId, byte userType, boolean onlyReader, String username, String prefix, String firstName,
			String middleName, String lastName, String rfc, String curp, String puesto, String identificador,
			String calle, String numero, String codigoPostal, String municipio, String colonia, String estado,
			byte authenticationMode, byte[] certificate, String hash256certificate, boolean isActive, String email,
			String telNumber, Integer countryCode, boolean isLockedOut, Date lastSigninDate, Date referenceDate,
			Date lastUpdated, String ipaddress, Byte statusId, Integer lastUserLogRecordId, Date lastActivityDate) {
		super();
		this.userId = userId;
		this.userType = userType;
		this.onlyReader = onlyReader;
		this.username = username;
		this.prefix = prefix;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.rfc = rfc;
		this.curp = curp;
		this.puesto = puesto;
		this.identificador = identificador;
		this.calle = calle;
		this.numero = numero;
		this.codigoPostal = codigoPostal;
		this.municipio = municipio;
		this.colonia = colonia;
		this.estado = estado;
		this.authenticationMode = authenticationMode;
		this.certificate = certificate;
		this.hash256certificate = hash256certificate;
		this.isActive = isActive;
		this.email = email;
		this.telNumber = telNumber;
		this.countryCode = countryCode;
		this.isLockedOut = isLockedOut;
		this.lastSigninDate = lastSigninDate;
		this.referenceDate = referenceDate;
		this.lastUpdated = lastUpdated;
		this.ipaddress = ipaddress;
		this.statusId = statusId;
		this.lastUserLogRecordId = lastUserLogRecordId;
		this.lastActivityDate = lastActivityDate;
	}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

  
        
        

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public byte getUserType() {
		return userType;
	}

	public void setUserType(byte userType) {
		this.userType = userType;
	}

	public boolean isOnlyReader() {
		return onlyReader;
	}

	public void setOnlyReader(boolean onlyReader) {
		this.onlyReader = onlyReader;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public byte getAuthenticationMode() {
		return authenticationMode;
	}

	public void setAuthenticationMode(byte authenticationMode) {
		this.authenticationMode = authenticationMode;
	}

	public byte[] getCertificate() {
		return certificate;
	}

	public void setCertificate(byte[] certificate) {
		this.certificate = certificate;
	}

	public String getHash256certificate() {
		return hash256certificate;
	}

	public void setHash256certificate(String hash256certificate) {
		this.hash256certificate = hash256certificate;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public Integer getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(Integer countryCode) {
		this.countryCode = countryCode;
	}

	public boolean isLockedOut() {
		return isLockedOut;
	}

	public void setLockedOut(boolean isLockedOut) {
		this.isLockedOut = isLockedOut;
	}

	public Date getLastSigninDate() {
		return lastSigninDate;
	}

	public void setLastSigninDate(Date lastSigninDate) {
		this.lastSigninDate = lastSigninDate;
	}

	public Date getReferenceDate() {
		return referenceDate;
	}

	public void setReferenceDate(Date referenceDate) {
		this.referenceDate = referenceDate;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public Byte getStatusId() {
		return statusId;
	}

	public void setStatusId(Byte statusId) {
		this.statusId = statusId;
	}

	public Integer getLastUserLogRecordId() {
		return lastUserLogRecordId;
	}

	public void setLastUserLogRecordId(Integer lastUserLogRecordId) {
		this.lastUserLogRecordId = lastUserLogRecordId;
	}

	public Date getLastActivityDate() {
		return lastActivityDate;
	}

	public void setLastActivityDate(Date lastActivityDate) {
		this.lastActivityDate = lastActivityDate;
	}

}