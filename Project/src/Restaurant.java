
public class Restaurant {
	
	//클래스를 배열로 선언 
	public int exam;
	private Table[] tableList;
	public Menu[] menuList; 
	public int tableCount; //테이블 수 
	public int menuCount;  //메뉴 수 
	int orderListCount; //주문 배열 몇 번째인지
	
	//생성자
	public Restaurant() {};
	public Restaurant (int tableCapacity, int menuCapacity) { //테이블 수용 인원과 메뉴 수량 결정하는 생성자 
		this.tableList = new Table[tableCapacity];
		this.menuList = new Menu[menuCapacity];
		this.tableCount = 0;
		this.menuCount = 0;
	}
	
	Table table = new Table();
	//기능
	
	public void showTableIdArrary () { //테이블 아이디 배열 보여주는 함수
		
		for (int i = 0; i<tableList.length; i++) {
			System.out.print(tableList[i].getTableId() + " "); 
		}
	} 
	
	public void showMenuIdArrary () { //메뉴 아이디 배열 보여주는 함수 
		
		for (int i = 0; i<menuList.length; i++) {
			System.out.print(menuList[i].getMenuId() + " "); 
		}
	}
	
	public int searchTable(Table table)  { //테이블 검색하는 기능
		
		for (int i = 0; i < tableCount; i++) {
			if (tableList[i].equals(table)) {
				return i;
			}
		}
		return -1; //없는 경우 	 	
	}
	
	public void addTable(Table table) throws Exception { //테이블 더하는 기능 
		
		int j = searchTable(table);
		
		if (j == -1) { 
			tableList[tableCount] = table;
			tableCount ++;
		} else {
			throw new Exception("중복 테이블 존재");
		}
		
	} 
	
	public void removeTable(Table table) throws Exception { //테이블 삭제하는 기능 
		
		int j = searchTable(table);
		int count = tableList.length;

		if (j == -1) {
			throw new Exception("삭제할 테이블 없음");
		} else {
			for (int i = searchTable(table) ; i < count -1; i ++) {
				tableList[i] = tableList[i+1];
			}
			tableList[count-1] = null;
			tableCount --;
		}
	}	
	
	public int searchMenu(Menu menu) { //메뉴 검색하는 기능

		for (int i = 0; i < menuCount; i++) {
			if (menuList[i].equals(menu)) {
				return i;
			}
		}
		return -1;//없는 경우 
	}
	
	
	public void addMenu(Menu menu) throws Exception{ //메뉴 추가하는 기능
		
		int j = searchMenu(menu);
		
		if (j == -1) { 
			menuList[menuCount] = menu;
			menuCount ++;
		} else {
			throw new Exception("중복 메뉴 존재");
		}
		
	}
	 
	public void removeMenu(Menu menu) throws Exception{ //메뉴 삭제하는 기능
		
		int j = searchMenu(menu);
		int count = menuList.length;

		if (j == -1) {
			throw new Exception("삭제할 메뉴 없음");
		} else {
			for (int i = searchMenu(menu) ; i < count -1; i ++) {
				menuList[i] = menuList[i+1];
			}
			menuList[count-1] = null;
			menuCount --;
		}
	}
	
	public int menuPrice(Menu menu)  { //가격 return 하는 기능 
		
		int price = 0;
		try {
			int j = searchMenu(menu);
			if (j == -1) {
				price = 0;
			} else {
				price = menuList[j].getPrice();
			}
		} catch (Exception e) {
			System.out.println("금액 찾을 수 없음");
		}
		return price;
	}
		
}
