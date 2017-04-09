package model.dao.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Created by lonely on 21.06.16.
 */
@Data
@RequiredArgsConstructor
public abstract class User {
	private int id;
	private String userName;
	private String hashPassword;
	private String encryptionSalt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getHashPassword() {
		return hashPassword;
	}

	public void setHashPassword(String hashPassword) {
		this.hashPassword = hashPassword;
	}

	public String getEncryptionSalt() {
		return encryptionSalt;
	}

	public void setEncryptionSalt(String encryptionSalt) {
		this.encryptionSalt = encryptionSalt;
	}
}
