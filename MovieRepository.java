package com.web.p7; //리파지토리
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import jakarta.transaction.Transactional;
 
public interface MovieRepository extends JpaRepository<Movie, String> {


}
