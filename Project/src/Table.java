
public class Table  {
	
	//변수
	public String tableId; //테이블 아이디 
	public Order[] orderList = new Order[100]; //일단 임의로 100이라 지정
	int orderListCount; //주문 배열 몇 번째인지
	
	Order order = new Order();
	
	//생성자
	public Table() {}; //매개 변수 없는 생성자 	
	public Table (String tableId) {
		this.tableId = tableId;
	}
	
	//getter & setter
	
	public String getTableId() {
		return tableId;
	}
	public void setTableId(String tableId) {
		this.tableId =  tableId;
	}
	
	//equals 함수 재정의 
    public boolean equals(Table t) {
    	if (this.tableId.equals(t.getTableId())) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
	//기능   
	public int payTable(Order o) { //주문 결제, reset 하는 기능 
		int result = 0;
		int total = 0;
		for (int i = 0; i < orderList.length; i++) {
			if (orderList[i] == null) {
				break;
			}
			result = orderList[i].getOrderPrice();
			total += result;
			orderList[i] = null; //reset
		}
		order.orderCount = 0; //
		orderListCount = 0;
		return total;
	}
	
    //주문 검색하는 기능
	public int searchOrder(Order order) throws Exception { 
		for (int i = 0; i < orderListCount; i++) {
			if (orderList[i].equals(order)) {
				return i; //존재할 경우 인덱스 return 
			} else if (orderList[i].getMenuId() == null) {
				throw new Exception();
			}
		}
		return -1; //처음 시키는 메뉴인 경우 	
	}
	
	public void addOrder(Order order) { 
		try {
			int j = searchOrder(order);
			 
			if (j == -1) {//처음 주문하는 경우 
				orderList[orderListCount] = order; //처음 addOrder 하면 우선은 배열에 추가하고 
				orderListCount ++;		
			} else {
				orderList[j].orderCount += order.getOrderCount(); //재주문일 경우 존재하는 배열에 횟수 추가해주기
			}
		} catch(Exception NullException) {
			System.out.println("Exception: 해당 주문은 접수되지 못합니다.");
		}
	}
}
