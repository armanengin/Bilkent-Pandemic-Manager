package com.api.bpm.repository;

import com.api.bpm.model.entities.DormRoomInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DormRoomInfoRepository extends JpaRepository<DormRoomInfo, Long> {
    List<DormRoomInfo> findByDormNo(int dormNo);
}
