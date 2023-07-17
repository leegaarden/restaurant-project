import java.util.*;

/*
 *다음 과제:  영업 끝났을 때 총 매출액 나오게 하기, -> 식당이 돌아가기 시작 
 */
public class ProjectMain  {
	public static void main (String[] args) {
		try {
			Scanner scan = new Scanner(System.in); //스캐너 생성
			Table table = new Table();
			
			System.out.println("테이블 몇 개 만드실 건가요?");
			int tableCapacity = scan.nextInt();
			
			System.out.println("메뉴 몇 개 만드실 건가요?");
			int menuCapacity = scan.nextInt();
		
			Restaurant restaurant = new Restaurant(tableCapacity, menuCapacity);
			
			while(true) {
				
				System.out.println("-----------기능선택창-----------");
				System.out.println("0. 설정 완료");
				System.out.println("1. 테이블 검색하기");
				System.out.println("2. 테이블 추가하기");
				System.out.println("3. 테이블 삭제하기");
				System.out.println("4. 메뉴 검색하기");
				System.out.println("5. 메뉴 추가하기");
				System.out.println("6. 메뉴 삭제하기");
				System.out.println("7. 영업 종료");
				System.out.println("-----------------------------");
				System.out.print("어떤 기능이 필요하신가요?: ");
				int func = scan.nextInt();
	
				if (func == 0) {
					System.out.println("설정이 완료 되었습니다. 매출 대박나세요~!");
					break;				
				}
				
				switch(func) {
				
				case 1: //테이블 검색하기 
					System.out.print("검색할 테이블 아이디을 입력하세요: ");
					String tableId1 = scan.next();
					Table searchT = new Table(tableId1);
					
					try {
						restaurant.searchTable(searchT);
						if (restaurant.searchTable(searchT) == -1 ) {
							System.out.println("해당 테이블은 아직 존재하지 않습니다. 삭제는 불가능하나 추가는 가능합니다.");
						} else {
							System.out.println("해당 테이블은 이미 존재합니다. 삭제는 가능하나 추가는 불가능합니다.");
						}
					} catch (java.lang.NullPointerException NullException) {
						System.out.println("NullException: 해당 테이블은 아직 존재하지 않습니다. 삭제는 불가능하나 추가는 가능합니다.");
					}
					
					
					try {
						restaurant.showTableIdArrary();
					} catch (java.lang.NullPointerException NullException) {
						for (int i = 0; i < tableCapacity - restaurant.tableCount ; i++) {
							System.out.print(" 비어있음");
						}
					}
					
					System.out.print("\n");
					break;
					
				case 2: //테이블 추가하기 
					System.out.print("추가할 테이블 아이디를 입력하세요: ");
					String tableId2 = scan.next();
					Table tableAdd = new Table(tableId2);
					
					try { 
						restaurant.addTable(tableAdd);
					} catch (java.lang.IndexOutOfBoundsException FullTableException) { //테이블 추가시 테이블 배열 길이를 넘길 경우
						System.out.println("테이블이 꽉 찼습니다.");
					} catch (Exception OverlapTableException) {
						System.out.println("중복되는 테이블이 있습니다.");
					} 
					
					try {
						restaurant.showTableIdArrary();
					} catch (java.lang.NullPointerException NullException) {
						for (int i = 0; i < tableCapacity - restaurant.tableCount ; i++) {
							System.out.print(" 비어있음");
						}
					}
					
					System.out.print("\n");
					break;
					
				case 3: //테이블 삭제하기
					System.out.print("삭제할 테이블 아이디를 입력하세요: ");
					String tableId3 = scan.next();
					Table tableDel = new Table(tableId3);
					
					try {
						restaurant.removeTable(tableDel);
					} catch (Exception RemoveTableException) {
						System.out.println("해당 테이블은 없습니다. 다시 확인해주세요.");
					} 
					
					try {
						restaurant.showTableIdArrary();
					} catch (java.lang.NullPointerException NullException) {
						for (int i = 0; i < tableCapacity - restaurant.tableCount ; i++) {
							System.out.print(" 비어있음");
						}
					}
					
					System.out.print("\n");
					break;
					
				case 4: //메뉴 검색하기 
					System.out.print("검색할 메뉴 아이디를 입력하세요: ");
					String menuId1 = scan.next();
					Menu searchM = new Menu(menuId1);
					
					try {
						restaurant.searchMenu(searchM);
						if (restaurant.searchMenu(searchM) == -1 ) {
							System.out.println("해당 메뉴는 아직 존재하지 않습니다. 삭제는 불가능하나 추가는 가능합니다.");
						} else {
							System.out.println("해당 메뉴는 이미 존재합니다. 삭제는 가능하나 추가는 불가능합니다.");
						}
					} catch (java.lang.NullPointerException NullException) {
						System.out.println("NullException: 해당 메뉴는 아직 존재하지 않습니다. 삭제는 불가능하나 추가는 가능합니다.");
					}
					
					
					try {
						restaurant.showMenuIdArrary();
					} catch (java.lang.NullPointerException NullException) {
						for (int i = 0; i < menuCapacity - restaurant.menuCount ; i++) {
							System.out.print(" 비어있음");
						}
					}
					
					System.out.print("\n");
					break;
					
				case 5: //메뉴 추가하기
					System.out.print("추가할 메뉴 아이디를 입력하세요: ");
					String menuId2 = scan.next();
					
					System.out.print("추가할 메뉴 이름을 입력하세요: ");
					String menuName1 = scan.next();
					
					System.out.print("추가할 메뉴 가격을 입력하세요: ");
					int menuPrice1 = scan.nextInt();
					
					Menu menuAdd = new Menu(menuId2, menuName1, menuPrice1);
		
					try { 
						restaurant.addMenu(menuAdd);
					} catch (java.lang.IndexOutOfBoundsException FullMenuException) { //메뉴 추가시 메뉴 배열 길이를 넘길 경우 
						System.out.println("메뉴가 꽉 찼습니다.");
					} catch (Exception OverlapMenuException) {
						System.out.println("중복되는 메뉴가 있습니다.");
					}
					
					try {
						restaurant.showMenuIdArrary();
					} catch (java.lang.NullPointerException NullException) {
						for (int i = 0; i < menuCapacity - restaurant.menuCount ; i++) {
							System.out.print(" 비어있음");
						}
					}
					
					System.out.print("\n");
					break;
					
				case 6: //메뉴 삭제하기 
					System.out.print("삭제할 메뉴 아이디를 입력하세요: ");
					String menuId3 = scan.next();

					Menu menuDel = new Menu(menuId3);

					try {
						restaurant.removeMenu(menuDel);
					} catch (Exception RemoveMenuException) {
						System.out.println("해당 메뉴는 없습니다. 다시 확인해주세요.");
					}
					
					try {
						restaurant.showMenuIdArrary();
					} catch (java.lang.NullPointerException NullException) {
						for (int i = 0; i < menuCapacity - restaurant.menuCount ; i++) {
							System.out.print(" 비어있음");
						}
					}
					
					System.out.print("\n");
					break;
					
				case 7:
					//영업종료하면 가게의 총 매출액이 나와야 함.
					
				}
				
			}
			
			

			
			/*=============================================================손님용=============================================================*/
			System.out.print("\n");
			System.out.println("====테이블====");
			try {
				restaurant.showTableIdArrary();
			} catch(java.lang.NullPointerException e) {
				System.out.println("Exception: 비어있음");
			}
			System.out.print("\n");
			System.out.println("============");
			
			while(true) { //존재하는 테이블인지 확인
				System.out.print("주문할 테이블 아이디를 입력하세요: ");
				String tId = scan.next();
				Table orderTId = new Table(tId);
				
				try {
					restaurant.searchTable(orderTId);
					if (restaurant.searchTable(orderTId) == -1 ) {
						System.out.println("해당 테이블은 존재하지 않습니다. 다시 확인하시고 주문해주세요.");
					} else {
						break; //반복문 탈출!
					}
				} catch (java.lang.NullPointerException NullException) {
					System.out.println("NullException: 해당 테이블은 존재하지 않습니다. 다시 확인하시고 주문해주세요.");
				}
			}
			
			//메뉴판 UI
			System.out.println("--------------메뉴판--------------");
			System.out.println("0. 체크아웃하기");
			System.out.println("\n");
			for (int i = 0; i < restaurant.menuList.length; i++) {
				System.out.println("아이디:" + restaurant.menuList[i].getMenuId() + " 이름:" + restaurant.menuList[i].getName() + " 가격:" + restaurant.menuList[i].getPrice() + "원");
				System.out.println("\n");
			}
			System.out.println("--------------------------------");		
			
			while (true) {
				String str = "0";
				System.out.print("메뉴 아이디를 선택하세요: ");
				String mId = scan.next();
				Order menup = new Order(mId);
				
				if (mId.equals(str)) {
					System.out.println("결제해드리겠습니다. 감사합니다.");
					System.out.print("가격은: ");
					System.out.println(table.payTable(menup) + "원"); //결제하고 체크아웃하기 
					break;
				}
				
				try {
					restaurant.searchMenu(menup);
					if (restaurant.searchMenu(menup) == -1 ) {
						System.out.println("해당 메뉴는 존재하지 않습니다. 다시 확인하시고 주문해주세요.");
						continue;
					}
				} catch (java.lang.NullPointerException NullException) {
					System.out.println("NullException: 해당 메뉴는 존재하지 않습니다. 다시 확인하시고 주문해주세요.");
					continue;
				}
				
				System.out.print("수량을 입력하세요: ");
				int oc = scan.nextInt();
				System.out.println("\n");
				int menuPrice = restaurant.menuPrice(menup);
				
				Order orderMenu = new Order(mId, oc, menuPrice);
				table.addOrder(orderMenu);
				
			}	
			scan.close();
		} catch (java.util.InputMismatchException e) {
			System.out.println("올바르게 입력해주세요.");
		} 

	}
}
