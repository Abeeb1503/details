package com.staff.details.repo;

import com.staff.details.model.StaffsDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepo extends JpaRepository<StaffsDetails,Long> {
    @Query("select s from StaffsDetails  s")
    public List<StaffsDetails> getAllStaffs();
    @Query("select s from  StaffsDetails s where s.id=:id")
    public StaffsDetails getStaffsById(@Param("id") Long id);
}
