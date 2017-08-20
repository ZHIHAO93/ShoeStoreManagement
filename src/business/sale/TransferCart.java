package business.sale;

import java.util.HashMap;

/**
 * 购物车数据传输对象
 * 
 * @author zhihao
 *
 */
public class TransferCart {

	/**
	 * 产品id
	 */
	private Integer idProduct;
	/**
	 * 产品价格
	 */
	private float price;
	/**
	 * 产品数量
	 */
	private Integer quantity;
	/**
	 * 购物车
	 */
	private HashMap<Integer, TransferLifeLine> cart;

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
	public void setIDProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	/**
	 * 获取价格
	 * 
	 * @return price 价格
	 */
	public float getPrecio() {
		return price;
	}

	/**
	 * 设置价格
	 * 
	 * @param precio
	 *            价格
	 */
	public void setPrecio(float precio) {
		this.price = precio;
	}

	/**
	 * 获取数量
	 * 
	 * @return quantity 数量
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * 设置数量
	 * 
	 * @param quantity
	 *            数量
	 */
	public void setCantidad(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * 获取购物车
	 * 
	 * @return cart 购物车
	 */
	public HashMap<Integer, TransferLifeLine> getCarrito() {
		return cart;
	}

	/**
	 * 设置购物车
	 * 
	 * @param carrito
	 *            购物车
	 */
	public void setCarrito(HashMap<Integer, TransferLifeLine> carrito) {
		this.cart = carrito;
	}

}
