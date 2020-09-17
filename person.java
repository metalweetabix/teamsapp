package model;

public class person {
	protected name personName;
	protected String phone;
	protected String email;
	
	public person(name personName, String phone, String email) {
		this.personName = personName;
		this.phone = phone;
		this.email = email;
	}

	public name getName() {
		return personName;
	}

	public void setName(name newName) {
		this.personName = newName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
