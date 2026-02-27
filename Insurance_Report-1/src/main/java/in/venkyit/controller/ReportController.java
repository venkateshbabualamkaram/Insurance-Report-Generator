package in.venkyit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import in.venkyit.entity.Insurance;
import in.venkyit.request.SearchRequest;
import in.venkyit.request.UserDto;
import in.venkyit.service.ReportService;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin(
    origins = "http://localhost:3000",
    allowedHeaders = "*",
    methods = {RequestMethod.GET, RequestMethod.POST}
)
public class ReportController {
	
	@Autowired
	private ReportService service;
	
	@PostMapping("/excel")
	public void downloadExcel(HttpServletResponse response,@RequestBody SearchRequest request) throws Exception {
		
		response.setContentType("application/octet-stream");
		
		String headerKey="Content-Disposition";
		
		String headerValue="attachment;filename=plans.xls";
		
		response.setHeader(headerKey, headerValue);
		
		List<Insurance> plans=service.getAllRequests(request);
		service.GenerateExcel(response,plans);
	}
	
	@PostMapping("/pdf")
	public void downloadPdf(HttpServletResponse response,@RequestBody SearchRequest request) throws Exception {
		
		response.setContentType("application/pdf");
		
		String headerkey="Content-Disposition";
		
		String headerValue="attachment;filename=plans.pdf";
		
		response.setHeader(headerkey, headerValue);
		
		List<Insurance> plans=service.getAllRequests(request);
		
		service.GeneratePdf(response,plans);
	}
	
	@GetMapping("/names")
	public ResponseEntity<List<String>> getPlanNames(){
		
		List<String> plans=service.getAllPlanNames();
		return new ResponseEntity<>(plans,HttpStatus.OK);
	}
	
	@GetMapping("/status")
	public ResponseEntity<List<String>> getAllPlanStatuses(){
		
		List<String> status=service.getAllPlanStatus();
		
		return new ResponseEntity<>(status,HttpStatus.OK);
	}
	
	@PostMapping("/search")
	public ResponseEntity<List<Insurance>> getAllRequests(@RequestBody SearchRequest request){
		
		List<Insurance> req=service.getAllRequests(request);
		
		return new ResponseEntity<>(req,HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Insurance> saveUserAll(@RequestBody UserDto userDto){
		
		 Insurance request=service.saveUser(userDto);
		 return new ResponseEntity<>(request,HttpStatus.OK);
	}
}
