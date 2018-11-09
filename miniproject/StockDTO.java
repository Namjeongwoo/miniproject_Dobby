package miniproject;

public class StockDTO {
	private int recipe_id;
	private int put_id;
	private int Stock_chicken;
	private int Stock_sweet;
	private int Stock_soy;
	private int Stock_cheese;
	private int Stock_spicy;
	private int Stock_springonion;
	private int Stock_onion;
	private int Stock_honey;
	private int Stock_dduck;
	private int Stock_sacheon;
	private int Stock_gralic;
	private int Stock_shrimp;

	public StockDTO() {
		
	}

	public StockDTO(int recipe_id, int put_id, int stock_chicken, int stock_sweet, int stock_soy, int stock_cheese,
			int stock_spicy, int stock_springonion, int stock_onion, int stock_honey, int stock_dduck,
			int stock_sacheon, int stock_gralic, int stock_shrimp) {
		this.recipe_id = recipe_id;
		this.put_id = put_id;
		Stock_chicken = stock_chicken;
		Stock_sweet = stock_sweet;
		Stock_soy = stock_soy;
		Stock_cheese = stock_cheese;
		Stock_spicy = stock_spicy;
		Stock_springonion = stock_springonion;
		Stock_onion = stock_onion;
		Stock_honey = stock_honey;
		Stock_dduck = stock_dduck;
		Stock_sacheon = stock_sacheon;
		Stock_gralic = stock_gralic;
		Stock_shrimp = stock_shrimp;
	}

	public int getRecipe_id() {
		return recipe_id;
	}

	public void setRecipe_id(int recipe_id) {
		this.recipe_id = recipe_id;
	}

	public int getPut_id() {
		return put_id;
	}

	public void setPut_id(int put_id) {
		this.put_id = put_id;
	}

	public int getStock_chicken() {
		return Stock_chicken;
	}

	public void setStock_chicken(int stock_chicken) {
		Stock_chicken = stock_chicken;
	}

	public int getStock_sweet() {
		return Stock_sweet;
	}

	public void setStock_sweet(int stock_sweet) {
		Stock_sweet = stock_sweet;
	}

	public int getStock_soy() {
		return Stock_soy;
	}

	public void setStock_soy(int stock_soy) {
		Stock_soy = stock_soy;
	}

	public int getStock_cheese() {
		return Stock_cheese;
	}

	public void setStock_cheese(int stock_cheese) {
		Stock_cheese = stock_cheese;
	}

	public int getStock_spicy() {
		return Stock_spicy;
	}

	public void setStock_spicy(int stock_spicy) {
		Stock_spicy = stock_spicy;
	}

	public int getStock_springonion() {
		return Stock_springonion;
	}

	public void setStock_springonion(int stock_springonion) {
		Stock_springonion = stock_springonion;
	}

	public int getStock_onion() {
		return Stock_onion;
	}

	public void setStock_onion(int stock_onion) {
		Stock_onion = stock_onion;
	}

	public int getStock_honey() {
		return Stock_honey;
	}

	public void setStock_honey(int stock_honey) {
		Stock_honey = stock_honey;
	}

	public int getStock_dduck() {
		return Stock_dduck;
	}

	public void setStock_dduck(int stock_dduck) {
		Stock_dduck = stock_dduck;
	}

	public int getStock_sacheon() {
		return Stock_sacheon;
	}

	public void setStock_sacheon(int stock_sacheon) {
		Stock_sacheon = stock_sacheon;
	}

	public int getStock_gralic() {
		return Stock_gralic;
	}

	public void setStock_gralic(int stock_gralic) {
		Stock_gralic = stock_gralic;
	}

	public int getStock_shrimp() {
		return Stock_shrimp;
	}

	public void setStock_shrimp(int stock_shrimp) {
		Stock_shrimp = stock_shrimp;
	}
	
	
}
