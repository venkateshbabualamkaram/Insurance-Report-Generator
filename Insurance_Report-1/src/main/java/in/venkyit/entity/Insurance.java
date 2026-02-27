package in.venkyit.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name="citizen_plans_Info")
@Entity
public class Insurance {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="citizen_id")
    private Integer citizenId;

    @Column(name="citizen_name")
    private String citizenName;

    @Column(name="gender")
    private String gender;

    @Column(name="plan_name")
    private String planName;

    @Column(name="plan_status")
    private String planStatus;

    @Column(name="plan_start_date")
    private LocalDate planStartDate;

    @Column(name="plan_end_date")
    private LocalDate planEndDate;

    @Column(name="benefit_amount")
    private Integer benefitAmount;

    @Column(name="denial_reason")
    private String denialReason;

    @Column(name="terminated_date")
    private LocalDate terminatedDate;

    @Column(name="terminated_reason")
    private String terminatedReason;
}