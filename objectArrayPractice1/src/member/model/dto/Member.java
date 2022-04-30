package member.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member implements Comparable<Member>{
	private String id;
	private String name;
	private String password;
	private String email;
	private char gender;
	private int age;
	
	public Member() {}
	
	public Member(Member member) {
		this(member.id, member.name, member.password,
				member.email,  member.gender, member.age);
	}
	
	public Member(String id, String name, String password, String email,
			char gender, int age) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.age = age;
	}
	
	public String memberInfo() {
		return id + " " + name + " " + password + " " + email +
				" " + gender + " " + age;
	}

	@Override
	public int compareTo(Member m) {
		return Integer.compare(this.id.length(), m.id.length());
	}
}
