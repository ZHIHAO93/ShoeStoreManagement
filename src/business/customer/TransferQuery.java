package business.customer;

public class TransferQuery {

	/**
	 * 金额
	 */
	private Float nEuros;
	/**
	 * 开始时间
	 */
	private String startDate;
	/**
	 * 结束时间
	 */
	private String finalDate;

	/**
	 * 获取金额
	 * @return nEuros 金额
	 */
	public Float getNEuros() {
		return nEuros;
	}

	/**
	 * 设置金额
	 * @param nEuros 金额
	 */
	public void setNEuros(Float nEuros) {
		this.nEuros = nEuros;
	}

	/**
	 * 获取开始时间
	 * @return startDate 开始时间
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * 设置开始时间
	 * @param startDate 开始时间
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	/**
	 * 获取结束时间
	 * @return finalDate 结束时间
	 */
	public String getFinalDate() {
		return finalDate;
	}

	/**
	 * 设置结束时间
	 * @param finalDate 结束时间
	 */
	public void setFinalDate(String finalDate) {
		this.finalDate = finalDate;
	}

	public String toString() {
		return nEuros + " " + startDate + " " + finalDate;
	}

}
