package miniproject;

public class BreakdownDTO {
	 private int order_id; //주문번호
	 private String breakdown_name; //주문내역 - 메뉴명
	 private String breakdown_price; //주문내역 - 메뉴가격
	 private String breakdown_quantity; //메뉴수량
	 public BreakdownDTO() {
		 
	 }
	public BreakdownDTO(int order_id, String breakdown_name, String breakdown_price, String breakdown_quantity) {
		
		this.order_id = order_id;
		this.breakdown_name = breakdown_name;
		this.breakdown_price = breakdown_price;
		this.breakdown_quantity = breakdown_quantity;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getBreakdown_name() {
		return breakdown_name;
	}
	public void setBreakdown_name(String breakdown_name) {
		this.breakdown_name = breakdown_name;
	}
	public String getBreakdown_price() {
		return breakdown_price;
	}
	public void setBreakdown_price(String breakdown_price) {
		this.breakdown_price = breakdown_price;
	}
	public String getBreakdown_quantity() {
		return breakdown_quantity;
	}
	public void setBreakdown_quantity(String breakdown_quantity) {
		this.breakdown_quantity = breakdown_quantity;
	}
	 
}
