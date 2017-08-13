package business.product;

/**
 * 产品的数据传输对象
 * 
 * @author zhihao
 *
 */
public class TransferProduct {

	/**
	 * 产品id
	 */
	private Integer idProduct;
	/**
	 * 产品品牌
	 */
	private String brand;
	/**
	 * 产品类型
	 */
	private String type;
	/**
	 * 产品颜色
	 */
	private String color;
	/**
	 * 产平状态， true 线上产品，false 下架产品
	 */
	private boolean enable;
	/**
	 * 产品库存量
	 */
	private Integer stock;
	/**
	 * 产品价格
	 */
	private Float price;

	/**
	 * 构造器，初始化id为0
	 */
	public TransferProduct() {
		idProduct = 0;
	}

	/**
	 * 获取产品ID
	 * 
	 * @return idProduct 产品ID
	 */
	public Integer getIDProduct() {
		return idProduct;
	}

	/**
	 * 设置产品ID
	 * 
	 * @param idProduct
	 *            产品ID
	 */
	public void setIDProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}

	/**
	 * 获取产品品牌
	 * 
	 * @return brand 产品品牌
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * 设置产品品牌
	 * 
	 * @param brand
	 *            产品品牌
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * 获取产品类型
	 * 
	 * @return type 产品类型
	 */
	public String getType() {
		return type;
	}

	/**
	 * 设置产品类型
	 * 
	 * @param type
	 *            产品类型
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 获取产品颜色
	 * 
	 * @return color 产品颜色
	 */
	public String getColor() {
		return color;
	}

	/**
	 * 设置产品颜色
	 * 
	 * @param color
	 *            产品颜色
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * 获取产品状态
	 * 
	 * @return enable 产品状态
	 */
	public boolean getEnable() {
		return enable;
	}

	/**
	 * 设置产品状态
	 * 
	 * @param enable
	 *            产品状态
	 */
	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	/**
	 * 获取产品库存量
	 * 
	 * @return stock 产品库存量
	 */
	public Integer getStock() {
		return stock;
	}

	/**
	 * 设置产品库存量
	 * 
	 * @param stock
	 *            产品库存量
	 */
	public void setStock(Integer stock) {
		this.stock = stock;
	}

	/**
	 * 获取产品价格
	 * 
	 * @return price 产品价格
	 */
	public Float getPrice() {
		return price;
	}

	/**
	 * 设置产品价格
	 * 
	 * @param price
	 *            产品价格
	 */
	public void setPrice(Float price) {
		this.price = price;
	}

	public String toString() {
		return idProduct + " " + brand + " " + type + " " + color + " " + enable + " " + stock + " " + price;
	}

}
