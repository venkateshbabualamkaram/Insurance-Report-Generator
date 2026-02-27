package in.venkyit.service;

import java.util.List;

import in.venkyit.entity.Insurance;
import in.venkyit.request.SearchRequest;
import in.venkyit.request.UserDto;
import jakarta.servlet.http.HttpServletResponse;

public interface ReportService {
	
	public List<String> getAllPlanNames();
	
	public List<String> getAllPlanStatus();
	
	public List<Insurance> getAllRequests(SearchRequest request);
	
	public boolean GeneratePdf(HttpServletResponse response,List<Insurance> plans) throws Exception;
	
	public boolean GenerateExcel(HttpServletResponse responses,List<Insurance> plans) throws Exception;
	
	public Insurance saveUser(UserDto userDto);
}
