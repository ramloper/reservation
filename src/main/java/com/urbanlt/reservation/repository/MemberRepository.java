package com.urbanlt.reservation.repository;

import com.urbanlt.reservation.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
