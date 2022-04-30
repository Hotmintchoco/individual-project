package member.model.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import member.model.dto.Member;

public class MemberManager {
	public static final int SIZE = 10;
	Member[] member = new Member[SIZE];
	public int memberCount;
	
	Scanner sc = new Scanner(System.in);
	
	public Member memberInput() {
		System.out.println("���̵� �Է����ּ���.");
		String id = sc.next();
		System.out.println("�̸��� �Է����ּ���.");
		String name = sc.next();
		System.out.println("��й�ȣ�� �Է����ּ���.");
		String password = sc.next();
		System.out.println("�̸����� �Է����ּ���.");
		String email = sc.next();
		System.out.println("������ �Է����ּ���.(������ M / ������ W)");
		String inputGender = sc.next();
		System.out.println("������ �Է����ּ���.");
		int age = sc.nextInt();
		
		char gender = inputGender.charAt(0);
		
		member[memberCount] = new Member(id, name, password, email, gender, age);
		return member[memberCount];
	}
	public void deleteMember() {
		int indexId;
		
		while (memberCount > 0) {
			List<Member> memberArrList = new ArrayList<Member>(memberCount);
			for (int i = 0; i < memberCount; i++) {
				memberArrList.add(new Member(member[i]));
			}
			
			System.out.println("�����ϰ��� �ϴ� ���̵� �Է��ϼ���.(������� 9��) : ");
			String inputId = sc.next();
			
			if (inputId.equals("9")) {
				System.out.println("�޴��� ���ư��ϴ�.");
				break;
				
			}
			
			for (int i = 0; i < memberCount; i++) {
				if (member[i].getId().equals(inputId)) {
					indexId = i;
					System.out.println("���̵��� ��й�ȣ�� �Է��ϼ��� : ");

					String inputPassword = sc.next();
					if (member[indexId].getPassword().equals(inputPassword)) {
						memberArrList.remove(indexId);
						member = memberArrList.toArray(new Member[memberArrList.size()]);
						System.out.println("������ �Ϸ�Ǿ����ϴ�.");
						System.out.println();
						memberCount--;
						break;
					} else {
						System.out.println("�߸��� ��й�ȣ�Դϴ�.");
					}
				} else {
					System.out.println("�������� �ʴ� ���̵��Դϴ�.");
				}
			}
		}
	}
	
	public void printAllMember() {
		
	}
	
	public void printMember(int index) {
		if (index == -1) {
			System.out.println("ȸ�������� �������� �ʽ��ϴ�.");
		} else if (index == 100){
			System.out.println();
		} else {
			System.out.println("ȸ���� �迭�ε����� [" + index + "]�Դϴ�.");
		}
	}
	
	public Member[] sortIDAsc() {
		List<Member> memberArrList = new ArrayList<Member>(memberCount);
		for (int i = 0; i < memberCount; i++) {
			memberArrList.add(new Member(member[i]));
		}
		Collections.sort(memberArrList);
		member = memberArrList.toArray(new Member[memberArrList.size()]);
		return member;
	}
	
	public Member[] sortIDDes() {
		List<Member> memberArrList = new ArrayList<Member>(memberCount);
		for (int i = 0; i < memberCount; i++) {
			memberArrList.add(new Member(member[i]));
		}
		Collections.sort(memberArrList,  Collections.reverseOrder());
		member = memberArrList.toArray(new Member[memberArrList.size()]);
		return member;
	}
	
	public Member[] sortAgeAsc() {
		int[] memberAge = new int[memberCount];
		for (int i = 0; i < memberCount; i++) {
			memberAge[i] = member[i].getAge();
		}
		
		Arrays.sort(memberAge);
		
		for (int i = 0; i < memberCount; i++) {
			for (int j = i+1; j < memberCount; j++) {
				if (memberAge[i] == member[j].getAge()) {
					Member tmp = member[j];
					member[j] = member[i];
					member[i] = tmp;
				}
			}
		}
		return member;
	}
	
	public Member[] sortAgeDes() {
		Integer[] memberAge = new Integer[memberCount];
		for (int i = 0; i < memberCount; i++) {
			memberAge[i] = member[i].getAge();
		}
		
		Arrays.sort(memberAge, Collections.reverseOrder());
		
		for (int i = 0; i < memberCount; i++) {
			for (int j = i+1; j < memberCount; j++) {
				if (memberAge[i] == member[j].getAge()) {
					Member tmp = member[j];
					member[j] = member[i];
					member[i] = tmp;
				}
			}
		}
		return member;
	}
	
	public Member[] sortGenderDes() {
		Character[] memberChar = new Character[memberCount];
		for (int i = 0; i < memberCount; i++) {
			memberChar[i] = member[i].getGender();
		}
		
		Arrays.sort(memberChar);
		
		for (int i = 0; i < memberCount; i++) {
			for (int j = i+1; j < memberCount; j++) {
				if (memberChar[i] == member[j].getGender()) {
					Member tmp = member[j];
					member[j] = member[i];
					member[i] = tmp;
				}
			}
		}
		return member;
	}
}