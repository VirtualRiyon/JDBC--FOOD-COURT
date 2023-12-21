package jdbc2.dto;

public class User {
	private String name;
	private String emial;
	private int phno;
	private String password;
	private int wallet;
	private int age;
	private String gender;
	
	public User(String name, String emial, int phno, String password, int wallet, int age, String gender) {
		super();
		this.name = name;
		this.emial = emial;
		this.phno = phno;
		this.password = password;
		this.wallet = wallet;
		this.age = age;
		this.gender = gender;
	}
	
	public User(String emial, String password) {
		super();
		this.emial = emial;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", emial=" + emial + ", phno=" + phno + ", password=" + password + ", wallet="
				+ wallet + ", age=" + age + "]";
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the emial
	 */
	public String getEmial() {
		return emial;
	}
	/**
	 * @param emial the emial to set
	 */
	public void setEmial(String emial) {
		this.emial = emial;
	}
	/**
	 * @return the phno
	 */
	public int getPhno() {
		return phno;
	}
	/**
	 * @param phno the phno to set
	 */
	public void setPhno(int phno) {
		this.phno = phno;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the wallet
	 */
	public int getWallet() {
		return wallet;
	}
	/**
	 * @param wallet the wallet to set
	 */
	public void setWallet(int wallet) {
		this.wallet = wallet;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
}
	