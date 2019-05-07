package pl.justynababinska.dto;

public class CustomerDto {

	private Long id;
	private String firstName;
	private String lastName;
	private String mobile;
	private String address;
	private String identityCard;

	public CustomerDto() {
	};

	public CustomerDto(String firstName, String lastName, String mobile, String address, String identityCard) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.address = address;
		this.identityCard = identityCard;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIdentityCard() {
		return identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}
}
