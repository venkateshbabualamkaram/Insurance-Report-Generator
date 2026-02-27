package in.venkyit.request;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class SearchRequest {
	
	
	private String PlanName;
	
	private String PlanStatus;
	
	private String Gender;
	
	@JsonFormat(pattern="yyyy-mm-dd")
	private LocalDate PlanStartDate;
	
	@JsonFormat(pattern="yyyy-mm-dd")
	private LocalDate PlanEndDate;
}
