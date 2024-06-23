package com.web.p7; //Repository
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import jakarta.transaction.Transactional;

public interface MemberRepository extends JpaRepository<Member, String>{
	@Query("select m.password from Member m where m.id=?1")
	String findPasswordById(String id);
	
	@Transactional
    @Modifying
    @Query("update Member set password=?2, email=?3 where id=?1")
    int updateMember(String id, String password, String email);
}
