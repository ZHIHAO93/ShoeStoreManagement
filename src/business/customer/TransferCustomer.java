package business.customer;

/**
 * 客户的数据传递对象
 * 
 * @author zhihao
 *
 */
public class TransferCustomer {

	/**
	 * 客户id
	 */
	private int idCustomer;
	/**
	 * 客户身份证
	 */
	private String identificationNumber;
	/**
	 * 客户名字
	 */
	private String name;
	/**
	 * 客户姓氏
	 */
	private String lastName;
	/**
	 * 客户状态，true 活动用户，false 禁止用户
	 */
	private Boolean enable;
	/**
	 * 
	 */
	private Float creditLimit;
	/**
	 * 新品推广状态，true 接受，false 禁止拒绝
	 */
	private boolean newsletter;

	/**
	 * 构造器，初始化id为0
	 */
	public TransferCustomer() {
		idCustomer = 0;
	}
	
	/**
	 * 获取客户ID
	 * @return idCustomer 客户ID
	 */
	public int getIdCustomer() {
		return idCustomer;
	}

	/**
	 * 设置客户ID
	 * @param idCustomer 客户ID
	 */
	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}

	/**
	 * 获取客户身份证
	 * @return identificationNumber 客户身份证
	 */
	public String getIdNumber() {
		return identificationNumber;
	}

	/**
	 * 设置客户身份证
	 * @param idNumber 客户身份证
	 */
	public void setIdNumber(String idNumber) {
		this.identificationNumber = idNumber;
	}

	/**
	 * 获取客户名字
	 * @return name 客户名字
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置客户名字
	 * @param name 客户名字
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取客户姓氏
	 * @return lastName 客户姓氏
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * 设置客户姓氏
	 * @param lastName 客户姓氏
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * 获取客户状态
	 * @return enable 客户状态， true 活动，false 禁止
	 */
	public Boolean getEnable() {
		return enable;
	}

	/**
	 * 这是客户状态
	 * @param enable 客户状态， true 活动，false 禁止
	 */
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	/**
	 * 
	 * @return
	 */
	public Float getCreditLimit() {
		return creditLimit;
	}

	/**
	 * 
	 * @param creditLimit
	 */
	public void setCreditLimit(Float creditLimit) {
		this.creditLimit = creditLimit;
	}

	/**
	 * 获取新品推广状态
	 * @return newsletter 新品推广状态，true 接受， false 拒绝
	 */
	public boolean getNewsletter() {
		return newsletter;
	}

	/**
	 * 设置新品推广状态
	 * @param newsletter 新品推广状态，true 接受，false 拒绝
	 */
	public void setNewsletter(boolean newsletter) {
		this.newsletter = newsletter;
	}

	public String toString() {
		return idCustomer + " " + identificationNumber + " " + name + " " + lastName + " " + creditLimit + " "
				+ newsletter + " " + enable;
	}

}
