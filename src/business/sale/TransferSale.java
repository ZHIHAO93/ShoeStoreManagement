package business.sale;

import java.sql.Date;
import java.util.HashMap;

public class TransferSale {
	/**
	 * 销售ID
	 */
	private int idSale;
	/**
	 * 客户ID
	 */
	private Integer idCustomer;
	/**
	 * 销售金额
	 */
	private Float totalCost;
	/**
	 * 日期
	 */
	private Date date;
	/**
	 * 购物车
	 */
	private HashMap<Integer, TransferLifeLine> cart;

	/**
	 * 获取销售ID
	 * @return idSale 销售ID
	 */
	public Integer getIDSale() {
		return idSale;
	}

	/**
	 * 设置销售ID
	 * @param idSale 销售ID
	 */
	public void setIDSale(int idSale) {
		this.idSale = idSale;
	}

	/**
	 * 获取客户ID
	 * @return idCustomer 客户ID
	 */
	public Integer getIDCustomer() {
		return idCustomer;
	}

	/**
	 * 设置客户ID
	 * @param idCustomer 客户ID
	 */
	public void setIDCliente(Integer idCustomer) {
		this.idCustomer = idCustomer;
	}

	/**
	 * 获取销售金额
	 * @return totalSale
	 */
	public Float getTotalSale() {
		return totalCost;
	}

	/**
	 * 设置销售金额
	 * @param totalCost 设置销售金额
	 */
	public void setTotalVenta(Float totalCost) {
		this.totalCost = totalCost;
	}

	/**
	 * 获取日期
	 * @return date 日期
	 */
	public Date getFecha() {
		return date;
	}

	/**
	 * 设置日期
	 * @param fecha 日期
	 */
	public void setFecha(Date fecha) {
		this.date = fecha;
	}

	/**
	 * 获取购物车
	 * @return cart 购物车
	 */
	public HashMap<Integer, TransferLifeLine> getCart() {
		return cart;
	}

	/**
	 * 设置购物车
	 * @param cart 购物车
	 */
	public void setCart(HashMap<Integer, TransferLifeLine> cart) {
		this.cart = cart;
	}

	public String toString() {
		return idSale + " " + idCustomer + " " + totalCost + " " + date;
	}
}
