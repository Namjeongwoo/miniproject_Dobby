package miniproject;

public class RecipeDTO {
	private int recipe_id; //주문ID
	private int recipe_sweet; 
	private int recipe_soy;
	private int recipe_cheese;
	private int recipe_spicy;
	private int recipe_spingonion;
	private int recipe_onion;
	private int recipe_honey;
	private int recipe_dduck;
	private int recipe_sacheon;
	private int recipe_garlic;
	private int recipe_shrimp;
	
	public RecipeDTO(){
		
	}

	public RecipeDTO(int recipe_id, int recipe_sweet, int recipe_soy, int recipe_cheese, int recipe_spicy,
			int recipe_spingonion, int recipe_onion, int recipe_honey, int recipe_dduck, int recipe_sacheon,
			int recipe_garlic, int recipe_shrimp) {
		super();
		this.recipe_id = recipe_id;
		this.recipe_sweet = recipe_sweet;
		this.recipe_soy = recipe_soy;
		this.recipe_cheese = recipe_cheese;
		this.recipe_spicy = recipe_spicy;
		this.recipe_spingonion = recipe_spingonion;
		this.recipe_onion = recipe_onion;
		this.recipe_honey = recipe_honey;
		this.recipe_dduck = recipe_dduck;
		this.recipe_sacheon = recipe_sacheon;
		this.recipe_garlic = recipe_garlic;
		this.recipe_shrimp = recipe_shrimp;
	}

	public int getRecipe_id() {
		return recipe_id;
	}

	public void setRecipe_id(int recipe_id) {
		this.recipe_id = recipe_id;
	}

	public int getRecipe_sweet() {
		return recipe_sweet;
	}

	public void setRecipe_sweet(int recipe_sweet) {
		this.recipe_sweet = recipe_sweet;
	}

	public int getRecipe_soy() {
		return recipe_soy;
	}

	public void setRecipe_soy(int recipe_soy) {
		this.recipe_soy = recipe_soy;
	}

	public int getRecipe_cheese() {
		return recipe_cheese;
	}

	public void setRecipe_cheese(int recipe_cheese) {
		this.recipe_cheese = recipe_cheese;
	}

	public int getRecipe_spicy() {
		return recipe_spicy;
	}

	public void setRecipe_spicy(int recipe_spicy) {
		this.recipe_spicy = recipe_spicy;
	}

	public int getRecipe_spingonion() {
		return recipe_spingonion;
	}

	public void setRecipe_spingonion(int recipe_spingonion) {
		this.recipe_spingonion = recipe_spingonion;
	}

	public int getRecipe_onion() {
		return recipe_onion;
	}

	public void setRecipe_onion(int recipe_onion) {
		this.recipe_onion = recipe_onion;
	}

	public int getRecipe_honey() {
		return recipe_honey;
	}

	public void setRecipe_honey(int recipe_honey) {
		this.recipe_honey = recipe_honey;
	}

	public int getRecipe_dduck() {
		return recipe_dduck;
	}

	public void setRecipe_dduck(int recipe_dduck) {
		this.recipe_dduck = recipe_dduck;
	}

	public int getRecipe_sacheon() {
		return recipe_sacheon;
	}

	public void setRecipe_sacheon(int recipe_sacheon) {
		this.recipe_sacheon = recipe_sacheon;
	}

	public int getRecipe_garlic() {
		return recipe_garlic;
	}

	public void setRecipe_garlic(int recipe_garlic) {
		this.recipe_garlic = recipe_garlic;
	}

	public int getRecipe_shrimp() {
		return recipe_shrimp;
	}

	public void setRecipe_shrimp(int recipe_shrimp) {
		this.recipe_shrimp = recipe_shrimp;
	}
	
	

}//end recipeDTO
