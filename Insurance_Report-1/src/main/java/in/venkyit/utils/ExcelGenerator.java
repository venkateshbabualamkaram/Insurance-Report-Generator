package in.venkyit.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import in.venkyit.entity.Insurance;
import in.venkyit.repo.InsuranceRepo;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ExcelGenerator {

	
	public void generator(HttpServletResponse response,List<Insurance> plans,File file) throws IOException {
	   	Workbook workbook=new HSSFWorkbook();
    	Sheet sheet=workbook.createSheet("CitizenPlansInfo");
    	Row headerRow=sheet.createRow(0);
    	
    	headerRow.createCell(0).setCellValue("ID");
    	headerRow.createCell(1).setCellValue("CitizeName");
    	headerRow.createCell(2).setCellValue("gender");
    	headerRow.createCell(3).setCellValue("planName");
    	headerRow.createCell(4).setCellValue("planStatus");
    	headerRow.createCell(5).setCellValue("planStartDate");
    	headerRow.createCell(6).setCellValue("planEndDate");
    	headerRow.createCell(7).setCellValue("benefitAmount");
    	headerRow.createCell(8).setCellValue("denialReason");
    	headerRow.createCell(9).setCellValue("terminatedDate");
    	headerRow.createCell(10).setCellValue("terminatedReason");
    	int dataRowInd=1;
    	for(Insurance plan : plans) {
    		Row dataRow=sheet.createRow(dataRowInd++);
    		
       		if(null!=plan.getCitizenId()) {
				dataRow.createCell(0).setCellValue(plan.getCitizenId());
    		}else {
    			dataRow.createCell(0).setCellValue("N/A");
    		}
    		
    	
       		if(null!=plan.getCitizenName()) {
       			dataRow.createCell(1).setCellValue(plan.getCitizenName());
    		}else {
    			dataRow.createCell(1).setCellValue("N/A");
    		}
    		
       		if(null!=plan.getGender()) {
       			dataRow.createCell(2).setCellValue(plan.getGender());
    		}else {
    			dataRow.createCell(2).setCellValue("N/A");
    		}
    		
    		
       		if(null!=plan.getPlanName()) {
       			dataRow.createCell(3).setCellValue(plan.getPlanName());
    		}else {
    			dataRow.createCell(3).setCellValue("N/A");
    		}
    		
    		
    		if(null!=plan.getPlanStatus()) {
    			dataRow.createCell(4).setCellValue(plan.getPlanStatus());
    		}else {
    			dataRow.createCell(4).setCellValue("N/A");
    		}
    		
    		
    		if(null!=plan.getPlanStartDate()) {
    			dataRow.createCell(5).setCellValue(plan.getPlanStartDate().toString());
    		}else {
    			dataRow.createCell(5).setCellValue("N/A");
    		}
    		
    		
    		if(null!=plan.getPlanEndDate()) {
    			dataRow.createCell(6).setCellValue(plan.getPlanEndDate().toString());
    		}else {
    			dataRow.createCell(6).setCellValue("N/A");
    		}
    		
    		if(null!=plan.getBenefitAmount()) {
    			dataRow.createCell(7).setCellValue(plan.getBenefitAmount());
    		}else {
    			dataRow.createCell(7).setCellValue("N/A");
    		}
    		
    		
    		if(null!=plan.getDenialReason()) {
    			dataRow.createCell(8).setCellValue(plan.getDenialReason());
    		}else {
    			dataRow.createCell(8).setCellValue("N/A");
    		}
    		
    		if(null!=plan.getTerminatedDate()) {
    			dataRow.createCell(9).setCellValue(plan.getTerminatedDate());
    		}else {
    			dataRow.createCell(9).setCellValue("N/A");
    		}
    		
    		if(null!=plan.getTerminatedReason()) {
    			dataRow.createCell(10).setCellValue(plan.getTerminatedReason());
    		}else {
    			dataRow.createCell(10).setCellValue("N/A");
    		}
    	}
    	
    	FileOutputStream fos=new FileOutputStream(file);
    	workbook.write(fos);
    	fos.close();
    	
    	ServletOutputStream outStream=response.getOutputStream();
    	workbook.write(outStream);
    	workbook.close();
    	outStream.close();
	}
}
