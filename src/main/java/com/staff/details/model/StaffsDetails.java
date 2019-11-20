package com.staff.details.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "staffprofiles", schema = "STAFFS", catalog = "")
public class StaffsDetails implements Serializable{



        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        @Basic
        @Column(name = "Name")
        private String name;
        @Basic
        @Column(name = "Surname")
        private String surname;

        @Basic
        @Column(name = "Marital_Status")
        // @NotBlank (message ="Should not be blank")
        @Enumerated(EnumType.STRING)
        private Status status;
        @Basic
        @Column(name = "Home_Address")
        private String address;
        @Basic
        @Column(name = "Hometown_Address")
        private String hometown;
        @Basic
        @Column(name = "Qualification")
        private String qualification;
        @Basic
        @Column(name = "School")
        private String school;

        @Size(max = 11, message = "Digit shouldnt be greater than 11 digits ")
        @Column(name = "PhoneNumber")
        private String phoneNumber;

        @Basic
        @Column(name = "Employment_Date")
        private String dateOfEmployment;

        @Basic
        @Column(name = "Designation")
        private String designation;

        @Basic
        @Column(name = "Date_Of_Birth")
        //@Past(message= "Date Must be in the past")
        private String dateOfBirth;

        @Column(name = "next_Of_Kin")
        private String nextOfKin;



        @Basic
        @Column(name = "Gender")
        @Enumerated(EnumType.STRING)
        private Gender gender;


        public StaffsDetails() {
        }

        public StaffsDetails(String name, String surname, Status status, String address, String hometown, String qualification, String school, @Size(max = 11, message = "Digit shouldnt be greater than 11 digits ") String phoneNumber, String dateOfEmployment, String designation, String dateOfBirth, String nextOfKin,  Gender gender) {
            this.name = name;
            this.surname = surname;
            this.status = status;
            this.address = address;
            this.hometown = hometown;
            this.qualification = qualification;
            this.school = school;
            this.phoneNumber = phoneNumber;
            this.dateOfEmployment = dateOfEmployment;
            this.designation = designation;
            this.dateOfBirth = dateOfBirth;
            this.nextOfKin = nextOfKin;

            this.gender = gender;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public Status getStatus() {
            return status;
        }

        public void setStatus(Status status) {
            this.status = status;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getHometown() {
            return hometown;
        }

        public void setHometown(String hometown) {
            this.hometown = hometown;
        }

        public String getQualification() {
            return qualification;
        }

        public void setQualification(String qualification) {
            this.qualification = qualification;
        }

        public String getSchool() {
            return school;
        }

        public void setSchool(String school) {
            this.school = school;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getDateOfEmployment() {
            return dateOfEmployment;
        }

        public void setDateOfEmployment(String dateOfEmployment) {
            this.dateOfEmployment = dateOfEmployment;
        }

        public String getDesignation() {
            return designation;
        }

        public void setDesignation(String designation) {
            this.designation = designation;
        }

        public String getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public String getNextOfKin() {
            return nextOfKin;
        }

        public void setNextOfKin(String nextOfKin) {
            this.nextOfKin = nextOfKin;
        }


        public Gender getGender() {
            return gender;
        }

        public void setGender(Gender gender) {
            this.gender = gender;
        }


        @Override
        public String toString() {
            return "Staffs{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", status=" + status +
                    ", address='" + address + '\'' +
                    ", hometown='" + hometown + '\'' +
                    ", qualification='" + qualification + '\'' +
                    ", school='" + school + '\'' +
                    ", phoneNumber='" + phoneNumber + '\'' +
                    ", dateOfEmployment='" + dateOfEmployment + '\'' +
                    ", designation='" + designation + '\'' +
                    ", dateOfBirth='" + dateOfBirth + '\'' +
                    ", nextOfKin='" + nextOfKin + '\'' +

                    ", gender=" + gender +
                    '}';
        }
    }




