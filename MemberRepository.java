package com.web.p7; //리파지토리
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import jakarta.transaction.Transactional;
 
public interface MemberRepository extends JpaRepository<Member, String> {
    @Transactional
    @Modifying
    @Query("update Member set password=?2, username=?3, email=?4 where id=?1")
    int updateMember(String id, String password, String username, String email);
    
    @Transactional //비밀번호 초기화
    @Modifying
    @Query("update Member set password=concat("
            + "CHAR(FLOOR(65 + (RAND() * 26))), "
            + "CHAR(FLOOR(65 + (RAND() * 26))), "
            + "CHAR(FLOOR(97 + (RAND() * 26))), "
            + "CHAR(FLOOR(97 + (RAND() * 26))), "
            + "CHAR(FLOOR(48 + (RAND() * 10))), "
            + "CHAR(FLOOR(48 + (RAND() * 10))) "
            + "
    where id=?1")
    int resetPassword(String id);

    @Query("select count(id) from Member")
    long countMember();
}
