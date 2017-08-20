package business.sale;

public class TransferLifeLine {
	/**
	 * 产品ID
	 */
	private Integer idProduct;
	/**
	 * 产品价格
	 */
	private Float price;
	/**
	 * 产品数量
	 */
	private Integer quantity;
	/**
	 * 销售ID
	 */
	private Integer idSale;

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
	public void setIDProducto(Integer idProduct) {
		this.idProduct = idProduct;
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

	/**
	 * 获取产品数量
	 * 
	 * @return quantity 产品数量
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * 设置数量
	 * 
	 * @param quantity
	 *            数量
	 */
	public void setCantidad(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * 获取销售ID
	 * 
	 * @return idSale 销售ID
	 */
	public Integer getIDSale() {
		return idSale;
	}

	/**
	 * 设置销售ID
	 * 
	 * @param idSale
	 *            销售ID
	 */
	public void setIdVenta(Integer idSale) {
		this.idSale = idSale;
	}

	public String toString() {
		return "" + idProduct + price + quantity;
	}
}
