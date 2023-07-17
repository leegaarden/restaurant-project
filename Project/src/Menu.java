public class Menu { 
	
	
	//변수	
	public String menuId; //메뉴 아이디
	public String name; //메뉴 이름
	public int price; // 메뉴 가격 
	public int menuCount; //메뉴 수량
	
	//생성자
	public Menu(){} 
	public Menu (String menuId) {
		this.menuId = menuId;
	}
	public Menu (String menuId, String name, int price) { 
		this.menuId = menuId;
		this.name = name;
		this.price = price;
	}
	//getter & setter

	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
    // equals() 함수 재정의
	public boolean equals(Menu m) {
    	if (this.menuId.equals(m.getMenuId())) {
    		return true;
    	} else {
    		return false;
    	}
    }
	
}
