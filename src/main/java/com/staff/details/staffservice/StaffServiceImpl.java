package com.staff.details.staffservice;


import com.staff.details.model.StaffsDetails;
import com.staff.details.repo.StaffRepo;
import com.staff.details.staffservice.staffphase.Staffservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class StaffServiceImpl implements Staffservice{
    @Autowired
    StaffRepo staffRepo;

    @Override
    public List<StaffsDetails> getAllStaffs() {
        return staffRepo.getAllStaffs();
    }

    @Override
    public StaffsDetails getStaffById(Long id) {
        return staffRepo.getStaffsById(id);
    }


    @Override
    public void staffUpdate(StaffsDetails staffs) {

        staffRepo.save(staffs);


    }


    @Override
    public StaffsDetails addAStaff(StaffsDetails staffs){


        if (staffs == null)
            return null;
        else {

            return staffRepo.save(staffs);
        }


    }

    @Override
    public void deleteStaff(Long id) {
        StaffsDetails staff = staffRepo.getStaffsById(id);
        staffRepo.delete(staff);

    }

}