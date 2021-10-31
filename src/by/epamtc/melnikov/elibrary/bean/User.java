package by.epamtc.melnikov.elibrary.bean;

import java.io.Serializable;

import by.epamtc.melnikov.elibrary.bean.type.UserType;

public class User implements Serializable {

	private static final long serialVersionUID = 2222934865604193821L;

	private String login;
	private String password;
	private UserType userType;
	
	public User() {
		
	}
	
	public User(String login, String password, UserType userType) {
		this.login = login;
		this.password = password;
		this.userType = userType;
	}

	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public UserType getUserType() {
		return userType;
	}
	
	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [login=" + login + ", password=" + password + ", userType=" + userType + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userType == null) ? 0 : userType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userType != other.userType)
			return false;
		return true;
	}
	
}
