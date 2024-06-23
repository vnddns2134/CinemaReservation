package com.web.p7; //Entity
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Movie {
	@Id public String id; // 아이디
	public String movieName; // 영화 제목
	public String theater; // 극장 지점
	public String date; // 상영 날짜
	public String time; // 상영 시간
	public String seats; // 좌석
}
