package in.venkyit.request;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class UserDto {
	
	private String citizenName;
	
	private String planName;
	
	private String planStatus;
	
	private String gender;
	
	private Integer benefitAmount;
	
	private String denialReason;
	
	private String terminatedReason;

	private LocalDate planStartDate;
	
	private LocalDate planEndDate;
	
	
	private LocalDate TerminatedDate;
}
