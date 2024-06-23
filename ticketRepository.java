package com.web.p8;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ticketRepository extends JpaRepository<ticket, String> {
}
