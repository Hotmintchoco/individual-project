package member.view;

import java.util.Arrays;
import java.util.Scanner;
import member.model.dao.MemberManager;
import member.model.dto.Member;

public class MemberMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberManager mManager = new MemberManager();
	Member[] member = new Member[mManager.SIZE];
	
	public MemberMenu() {}
	
	public void mainMenu(){
		
		Outer:
		while (true) {
			System.out.println("현재 등록된 회원수는 " + mManager.memberCount + "명 입니다.");
			System.out.println("1. 새 회원 등록");
			System.out.println("2. 회원 조회");
			System.out.println("3. 회원 정보 수정");
			System.out.println("4. 회원 정보 정렬");
			System.out.println("5. 회원 삭제");
			System.out.println("6. 모두 출력");
			System.out.println("9. 끝내기");
			
			int input = sc.nextInt();
			
			if (input == 1) {
				member[mManager.memberCount] = mManager.memberInput();
				mManager.memberCount++;
			} else if (input == 2) {
				mManager.printMember(searchMenu());
				System.out.println();
			} else if (input == 3) {
				modifyMenu();
			} else if (input == 4) {
				sortMenu();
			} else if (input == 5) {
				mManager.deleteMember();
			} else if (input == 6) {
				mManager.printAllMember();
			} else if (input == 9) {
				System.out.print("정말로 끝내시겠습니까? (y/n) : ");
				
				while(true) {
					String endInput = sc.next();

					if (endInput.equalsIgnoreCase("y")) {
						break Outer;
					} else if (endInput.equalsIgnoreCase("n")) {
						System.out.println("시스템을 진행합니다.");
						System.out.println();
						break;
					} else
						System.out.println("잘못된 입력입니다.");
				} // end문 while.
			}
			
		} // while문 
	} //mainMenu 메서드.
	
	public int searchMenu(){
		while (true) {
			System.out.println("1. 아이디로 검색");
			System.out.println("2. 이름으로 검색");
			System.out.println("3. 이메일로 검색");
			System.out.println("9. 이전 메뉴로 가기");
			
			int searchInput = sc.nextInt();
			if (searchInput == 1) {
				System.out.print("아이디를 입력하세요: ");
				String inputId = sc.next();
				for (int i = 0; i < mManager.memberCount; i++) {
					if(member[i].getId().equals(inputId)) {
						return i;
					}
				}
				return -1;
			}
			else if (searchInput == 2) {
				System.out.print("이름을 입력하세요: ");
				String inputName = sc.nextLine();
				for (int i = 0; i < mManager.memberCount; i++) {
					if(member[i].getName().equals(inputName)) {
						return i;
					} 
				}
				return -1;
			}
			else if (searchInput == 3) {
				System.out.print("이메일을 입력하세요: ");
				String inputemail = sc.nextLine();
				for (int i = 0; i < mManager.memberCount; i++) {
					if(member[i].getEmail().equals(inputemail)) {
						return i;
					} 
				}
				return -1;
			}
			else if (searchInput == 9) {
				System.out.println("메인메뉴로 화면 이동합니다.");
				break;
			}
		}
		return 100;
	}
	
	public int searchMenu(String inputStr){
		while (true) {
			for (int i = 0; i < mManager.memberCount; i++) {
				if (member[i].getId().equals(inputStr)) {
					return i;
				}
				return -1;
			}
		}
	}
	
	public void sortMenu(){
		while (true) {
			System.out.println();
			System.out.println("1. 아이디 오름차순 정렬 출력");
			System.out.println("2. 아이디 내림차순 정렬 출력");
			System.out.println("3. 나이 오름차순 정렬 출력");
			System.out.println("4. 나이 내림차순 정렬 출력");
			System.out.println("5. 성별 내림차순 정렬 출력(남여순)");
			System.out.println("9. 이전 메뉴로 가기");
			
			int sortInput = sc.nextInt();
			
			if (sortInput == 1) {
				member = mManager.sortIDAsc();
				for (int i = 0; i < mManager.memberCount; i++) {
					System.out.print(member[i].getId() + " ");
				}
			}
			else if (sortInput == 2) {
				member = mManager.sortIDDes();
				for (int i = 0; i < mManager.memberCount; i++) {
					System.out.print(member[i].getId() + " ");
				}
			}
			else if (sortInput == 3) {
				member = mManager.sortAgeAsc();
				for (int i = 0; i < mManager.memberCount; i++) {
					System.out.print(member[i].getAge() + " ");
				}
			}
			else if (sortInput == 4) {
				member = mManager.sortAgeDes();
				for (int i = 0; i < mManager.memberCount; i++) {
					System.out.print(member[i].getAge() + " ");
				}
			}
			else if (sortInput == 5) {
				member = mManager.sortGenderDes();
				for (int i = 0; i < mManager.memberCount; i++) {
					System.out.print(member[i].getGender() + " ");
				}
			}
			else if (sortInput == 9) {
				System.out.println("메인메뉴로 화면 이동합니다.");
				break;
			}
		}
	}
	
	public void modifyMenu(){
		while (true) {
			System.out.println("1. 암호 변경");
			System.out.println("2. 이메일 변경");
			System.out.println("3. 나이 변경");
			System.out.println("9. 이전 메뉴로 가기");
			
			int searchInput = sc.nextInt();
			
			if (searchInput == 9) {
				System.out.println("메인메뉴로 화면 이동합니다.");
				break;
			}
			
			System.out.print("변경할 회원의 아이디를 입력하세요: ");
			String inputId = sc.next();
			if (searchInput == 1) {
				int memberIndex = searchMenu(inputId);
				if (0 <= memberIndex && memberIndex <= 10) {
					System.out.println("변경할 암호를 입력하세요.");
					String inputPassword = sc.next();
					member[memberIndex].setPassword(inputPassword);
					System.out.println("회원의 정보가 변경되었습니다.");
				}
			}
			else if (searchInput == 2) {
				int memberIndex = searchMenu(inputId);
				if (0 <= memberIndex && memberIndex <= 10) {
					System.out.println("변경할 이메일을 입력하세요.");
					String inputEmail = sc.next();
					member[memberIndex].setEmail(inputEmail);
					System.out.println("회원의 정보가 변경되었습니다.");
				}
			}
			else if (searchInput == 3) {
				int memberIndex = searchMenu(inputId);
				if (0 <= memberIndex && memberIndex <= 10) {
					System.out.println("변경할 나이를 입력하세요.");
					int inputAge = sc.nextInt();
					member[memberIndex].setAge(inputAge);
					System.out.println("회원의 정보가 변경되었습니다.");
				}
			}
		}
	}
}
