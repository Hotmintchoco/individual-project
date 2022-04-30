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
			System.out.println("���� ��ϵ� ȸ������ " + mManager.memberCount + "�� �Դϴ�.");
			System.out.println("1. �� ȸ�� ���");
			System.out.println("2. ȸ�� ��ȸ");
			System.out.println("3. ȸ�� ���� ����");
			System.out.println("4. ȸ�� ���� ����");
			System.out.println("5. ȸ�� ����");
			System.out.println("6. ��� ���");
			System.out.println("9. ������");
			
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
				System.out.print("������ �����ðڽ��ϱ�? (y/n) : ");
				
				while(true) {
					String endInput = sc.next();

					if (endInput.equalsIgnoreCase("y")) {
						break Outer;
					} else if (endInput.equalsIgnoreCase("n")) {
						System.out.println("�ý����� �����մϴ�.");
						System.out.println();
						break;
					} else
						System.out.println("�߸��� �Է��Դϴ�.");
				} // end�� while.
			}
			
		} // while�� 
	} //mainMenu �޼���.
	
	public int searchMenu(){
		while (true) {
			System.out.println("1. ���̵�� �˻�");
			System.out.println("2. �̸����� �˻�");
			System.out.println("3. �̸��Ϸ� �˻�");
			System.out.println("9. ���� �޴��� ����");
			
			int searchInput = sc.nextInt();
			if (searchInput == 1) {
				System.out.print("���̵� �Է��ϼ���: ");
				String inputId = sc.next();
				for (int i = 0; i < mManager.memberCount; i++) {
					if(member[i].getId().equals(inputId)) {
						return i;
					}
				}
				return -1;
			}
			else if (searchInput == 2) {
				System.out.print("�̸��� �Է��ϼ���: ");
				String inputName = sc.nextLine();
				for (int i = 0; i < mManager.memberCount; i++) {
					if(member[i].getName().equals(inputName)) {
						return i;
					} 
				}
				return -1;
			}
			else if (searchInput == 3) {
				System.out.print("�̸����� �Է��ϼ���: ");
				String inputemail = sc.nextLine();
				for (int i = 0; i < mManager.memberCount; i++) {
					if(member[i].getEmail().equals(inputemail)) {
						return i;
					} 
				}
				return -1;
			}
			else if (searchInput == 9) {
				System.out.println("���θ޴��� ȭ�� �̵��մϴ�.");
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
			System.out.println("1. ���̵� �������� ���� ���");
			System.out.println("2. ���̵� �������� ���� ���");
			System.out.println("3. ���� �������� ���� ���");
			System.out.println("4. ���� �������� ���� ���");
			System.out.println("5. ���� �������� ���� ���(������)");
			System.out.println("9. ���� �޴��� ����");
			
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
				System.out.println("���θ޴��� ȭ�� �̵��մϴ�.");
				break;
			}
		}
	}
	
	public void modifyMenu(){
		while (true) {
			System.out.println("1. ��ȣ ����");
			System.out.println("2. �̸��� ����");
			System.out.println("3. ���� ����");
			System.out.println("9. ���� �޴��� ����");
			
			int searchInput = sc.nextInt();
			
			if (searchInput == 9) {
				System.out.println("���θ޴��� ȭ�� �̵��մϴ�.");
				break;
			}
			
			System.out.print("������ ȸ���� ���̵� �Է��ϼ���: ");
			String inputId = sc.next();
			if (searchInput == 1) {
				int memberIndex = searchMenu(inputId);
				if (0 <= memberIndex && memberIndex <= 10) {
					System.out.println("������ ��ȣ�� �Է��ϼ���.");
					String inputPassword = sc.next();
					member[memberIndex].setPassword(inputPassword);
					System.out.println("ȸ���� ������ ����Ǿ����ϴ�.");
				}
			}
			else if (searchInput == 2) {
				int memberIndex = searchMenu(inputId);
				if (0 <= memberIndex && memberIndex <= 10) {
					System.out.println("������ �̸����� �Է��ϼ���.");
					String inputEmail = sc.next();
					member[memberIndex].setEmail(inputEmail);
					System.out.println("ȸ���� ������ ����Ǿ����ϴ�.");
				}
			}
			else if (searchInput == 3) {
				int memberIndex = searchMenu(inputId);
				if (0 <= memberIndex && memberIndex <= 10) {
					System.out.println("������ ���̸� �Է��ϼ���.");
					int inputAge = sc.nextInt();
					member[memberIndex].setAge(inputAge);
					System.out.println("ȸ���� ������ ����Ǿ����ϴ�.");
				}
			}
		}
	}
}