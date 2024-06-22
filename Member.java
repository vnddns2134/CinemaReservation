package com.web.p7; //엔티티
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Member {
@Id public String id;
public String password;
public String username;
public String email;
}