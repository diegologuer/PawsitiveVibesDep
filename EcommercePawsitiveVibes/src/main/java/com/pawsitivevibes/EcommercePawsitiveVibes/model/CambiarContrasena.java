package com.pawsitivevibes.EcommercePawsitiveVibes.model;

public class CambiarContrasena {
	private String oldPassword;
	private String newPassword;
	
	public CambiarContrasena(String oldPassword, String newPassword) {
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
	}
	
	public CambiarContrasena() {
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	@Override
	public String toString() {
		return "CambiarContrasena [oldPassword=" + oldPassword + ", newPassword=" + newPassword + "]";
	}
	
	
	
}
