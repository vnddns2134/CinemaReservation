package com.web.프로젝트명 //엔티티
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class movies {
@Id public String name; //제목
public Integer seat1; //총좌석수
public Integer seat2; //예매된좌석수
}
