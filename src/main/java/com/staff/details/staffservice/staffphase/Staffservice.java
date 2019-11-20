package com.staff.details.staffservice.staffphase;


import com.staff.details.model.StaffsDetails;

import java.util.List;

public interface Staffservice {
    List<StaffsDetails> getAllStaffs();
    StaffsDetails getStaffById(Long id);
    void staffUpdate(StaffsDetails staffs);
    void deleteStaff(Long id);
    StaffsDetails addAStaff(StaffsDetails staffs);
}
