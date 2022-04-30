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
	
	public Member memberInput() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("아이디를 입력해주세요.");
		String id = sc.nextLine();
		System.out.println("이름을 입력해주세요.");
		String name = sc.nextLine();
		System.out.println("비밀번호를 입력해주세요.");
		String password = sc.nextLine();
		System.out.println("이메일을 입력해주세요.");
		String email = sc.nextLine();
		System.out.println("성별을 입력해주세요.(남성은 M / 여성은 W)");
		String inputGender = sc.nextLine();
		System.out.println("연령을 입력해주세요.");
		int age = sc.nextInt();
		
		char gender = inputGender.charAt(0);
		
		member[memberCount] = new Member(id, name, password, email, gender, age);
		return member[memberCount];
	}
	public void deleteMember() {
		
	}
	
	public void printAllMember() {
		
	}
	
	public void printMember(int index) {
		if (index == -1) {
			System.out.println("회원정보가 존재하지 않습니다.");
		} else if (index == 100){
			System.out.println();
		} else {
			System.out.println("회원의 배열인덱스는 [" + index + "]입니다.");
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
