package com.sbu.intl.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sbu.intl.converters.ListToStringConverter;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Builder
@AllArgsConstructor
public class Applicant {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    private String email;
    private String password;
    private String firstName;
    private String lastName;


    private Date dateApplied;

    @OneToOne
    @JsonIgnore
    private Response response;
    //Personal Info
    private Date birth;
    private String nationality;
    private String degree;
    //todo
//    highSchoolDoc: undefined,
//    bachelorDoc: undefined,
//    MasterDoc: undefined,
    private String applyFor;
    private String job;
    private String gender;
    private String aboutApplicant;

    //Contact Details
    private String address;
    private String city;
    private String mobile;
    private String phone;
    private boolean hasMedicalCondition;
    @Column
    @Convert(converter = ListToStringConverter.class)
    private List<String> medicalConditions;
    @Column
    @Convert(converter = ListToStringConverter.class)
    private List<String> hearAboutUsWays;
    //Pass And Visa
    private String passCountry;
    private String passNumber;
    private Date passExpiry;
    private boolean hasVisa;
    //todo
    //passDoc: undefined,
    private String visaType;
    private String visaNumber;
    private Date visaExpiry;

    //Course Selection
    @Transient
    private List<Wish> wishList;
    @Column
    @Convert(converter = ListToStringConverter.class)
    private List<String> wishListStr;

    public Applicant(String email, String password, String firstName, String lastName) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void update(Applicant applicant) throws JsonProcessingException {
        this.setDateApplied(applicant.getDateApplied());

        this.setBirth(applicant.getBirth());
        this.setGender(applicant.getGender());
        this.setNationality(applicant.getNationality());
        this.setDegree(applicant.getDegree());
        this.setApplyFor(applicant.getApplyFor());
        this.setJob(applicant.getJob());
        this.setAboutApplicant(applicant.getAboutApplicant());

        this.setAddress(applicant.getAddress());
        this.setCity(applicant.getCity());
        this.setMobile(applicant.getMobile());
        this.setPhone(applicant.getPhone());
        this.setHasMedicalCondition(applicant.isHasMedicalCondition());
        this.setMedicalConditions(applicant.getMedicalConditions());
        this.setHearAboutUsWays(applicant.getHearAboutUsWays());
        //Pass And Visa
        this.setPassCountry(applicant.getPassCountry());
        this.setPassNumber(applicant.getPassNumber());
        this.setPassExpiry(applicant.getPassExpiry());
        this.setHasVisa(applicant.isHasVisa());
        this.setVisaType(applicant.getVisaType());
        this.setVisaNumber(applicant.getVisaNumber());
        this.setVisaExpiry(applicant.getVisaExpiry());
        //Course Selection
        this.setWishListStr(processWishList(applicant.getWishList()));

    }

    public List<String> processWishList(List<Wish> wishList) {
        StringBuilder stringBuilder;
        List<String> wishes = new ArrayList<>();
        for (Wish wish : wishList) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(wish.getFaculty()).append(": ");
            stringBuilder.append(wish.getDepartment());
            wishes.add(stringBuilder.toString());
        }
        return wishes;
    }

    public Applicant(String email, String password, String firstName, String lastName, Response response, Date birth, String gender, String nationality, String degree, String applyFor, String job, String aboutApplicant) {
        this(email, password, firstName, lastName);
        this.response = response;
        this.birth = birth;
        this.gender = gender;
        this.nationality = nationality;
        this.degree = degree;
        this.applyFor = applyFor;
        this.job = job;
        this.aboutApplicant = aboutApplicant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Applicant applicant = (Applicant) o;
        return id != null && Objects.equals(id, applicant.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
