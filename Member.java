package com.web.p7; //엔티티
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Member {
@Id public String id; //아이디
public String password; //비밀번호
public String username; //닉네임
public String email; //이메일
}
