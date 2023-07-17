
public class Order extends Menu {

	int orderCount; //주문횟수
	double orderPrice;
	/*구현해야 하는 기능: 테이블 존재하는지 검색해서 있으면 메뉴에 따른 수량 ++ ,
	 *메뉴 추가하기 (이미 주문한 메뉴면 수량 +1, 처음 주문하는 메뉴이면 OrderList의 맨 마지막에 새로운 order 추가
	 *이를 위해 orderList 배열도 search 하는 함수 필요 
	*/
	//생성자
	public Order() {}
	public Order (String menuId) { //메뉴 검색하기 용 생성자
		this.menuId = menuId;
	}
	public Order(String menuId, int orderCount, int price) {
		this.menuId = menuId;
		this.orderCount = orderCount;
		this.price = price;
	}

	//getter & setter
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	public int getOrderCount() {
		return orderCount;
	}	
	public int getOrderPrice() {
		return this.price * orderCount;
	} 

	
	//equals 함수 재정의 
    public boolean equals(Order o) {
    	if (this.menuId.equals(o.getMenuId())) {
    		return true;
    	} else {
    		return false;
    	}
    }
}
