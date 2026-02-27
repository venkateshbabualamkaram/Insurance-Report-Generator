package in.venkyit.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.venkyit.entity.Insurance;
import in.venkyit.repo.InsuranceRepo;
import in.venkyit.request.SearchRequest;
import in.venkyit.request.UserDto;
import in.venkyit.service.ReportService;
import in.venkyit.utils.EmailUtils;
import in.venkyit.utils.PdfGenerator;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private InsuranceRepo repo;
    
    @Autowired
    private in.venkyit.utils.ExcelGenerator excelGenerator;
    
    @Autowired
    private PdfGenerator pdfGenerator;
    
    @Autowired
    private EmailUtils emailUtils;

    @Override
    public List<String> getAllPlanNames() {
        return repo.getPlanNames();
    }

    @Override
    public List<String> getAllPlanStatus() {
        return repo.getPlanStatus();
    }

    @Override
    public List<Insurance> getAllRequests(SearchRequest request) {

        // ⭐ Normalize string filters
        request.setPlanName(clean(request.getPlanName()));
        request.setPlanStatus(clean(request.getPlanStatus()));
        request.setGender(clean(request.getGender()));

        // ⭐ Dates already null if empty from React
        LocalDate startDate = request.getPlanStartDate();
        LocalDate endDate = request.getPlanEndDate();

        // ⭐ If all filters empty → return all
        if (request.getPlanName() == null &&
            request.getPlanStatus() == null &&
            request.getGender() == null &&
            startDate == null &&
            endDate == null) {

            return repo.findAll();
        }

        // ⭐ Otherwise dynamic search
        return repo.search(request);
    }

    // ⭐ Utility method
    private String clean(String val) {
        return (val == null || val.trim().isEmpty() || val.equalsIgnoreCase("select")) ? null : val;
    }

    @Override
    public boolean GeneratePdf(HttpServletResponse response,List<Insurance> plans) throws DocumentException, IOException {
    	
    	
    File file=new File("plans.pdf");
    
    pdfGenerator.generator(response, plans,file);
    
    String subject="plans info pdf";
    
    String body="<h1>plans pdf</h1>";
    
    String to="venkateshbabualamkaram7@gmail.com";
    
    emailUtils.sendEmail(subject, body, to, file);
    
    file.delete();
    
        return true;
    }
    
    @Override
    public boolean GenerateExcel(HttpServletResponse response,List<Insurance>plans)throws Exception {
    	
    	
    	File f=new File("plans.xls");
    	
    	excelGenerator.generator(response, plans,f);
    	
    	
    	String subject="Test Mail Subject";
    	
    	String body="<h1>Test mail body";
    	
    	String to="venkateshbabualamkaram7@gmail.com";
    	
    	
    	
    	emailUtils.sendEmail(subject, body, to,f);
    	f.delete();
    	
        return true;
    }

	@Override
	public Insurance saveUser(UserDto userDto) {
		// TODO Auto-generated method stub
		Insurance Ins=new Insurance();
		Ins.setCitizenName(userDto.getCitizenName());
		Ins.setPlanName(userDto.getPlanName());
		Ins.setGender(userDto.getGender());
		Ins.setPlanStatus(userDto.getPlanStatus());
		Ins.setDenialReason(userDto.getDenialReason());
		Ins.setBenefitAmount(userDto.getBenefitAmount());
		Ins.setPlanStartDate(userDto.getPlanStartDate());
		Ins.setPlanEndDate(userDto.getPlanEndDate());
		Ins.setTerminatedDate(userDto.getTerminatedDate());
		Ins.setTerminatedReason(userDto.getTerminatedReason());
		return repo.save(Ins);
	}
    
    
}

