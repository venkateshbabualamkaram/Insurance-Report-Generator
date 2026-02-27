package in.venkyit.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

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
import jakarta.servlet.http.HttpServletResponse;

@Component
public class PdfGenerator {
	
public void generator(HttpServletResponse response,List<Insurance>plans,File file) throws DocumentException, IOException {
	

	Document document=new Document(PageSize.A4.rotate());
	
	PdfWriter.getInstance(document, response.getOutputStream());
	
	PdfWriter.getInstance(document, new FileOutputStream(file));
	
	document.open();
	Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
	Paragraph title=new Paragraph("Citizens_plan_Info");
	title.setAlignment(Element.ALIGN_CENTER);
	document.add(title);
    PdfPTable table = new PdfPTable(11);
    table.setWidthPercentage(100);

    Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

    table.addCell(new PdfPCell(new Phrase("ID", headerFont)));
    table.addCell(new PdfPCell(new Phrase("Citizen Name", headerFont)));
    table.addCell(new PdfPCell(new Phrase("Gender", headerFont)));
    table.addCell(new PdfPCell(new Phrase("Plan Name", headerFont)));
    table.addCell(new PdfPCell(new Phrase("Plan Status", headerFont)));
    table.addCell(new PdfPCell(new Phrase("Plan Start Date", headerFont)));
    table.addCell(new PdfPCell(new Phrase("Plan End Date", headerFont)));
    table.addCell(new PdfPCell(new Phrase("Benefit Amount", headerFont)));
    table.addCell(new PdfPCell(new Phrase("Denial Reason", headerFont)));
    table.addCell(new PdfPCell(new Phrase("Terminated Date", headerFont)));
    table.addCell(new PdfPCell(new Phrase("Terminated Reason", headerFont)));
    

	for (Insurance plan : plans) {
    	table.addCell(plan.getCitizenId() != null ? String.valueOf(plan.getCitizenId()) : "N/A");
    	table.addCell(plan.getCitizenName() != null ? String.valueOf(plan.getCitizenName()) : "N/A");
    	table.addCell(plan.getGender() != null ? String.valueOf(plan.getGender()) : "N/A");
    	table.addCell(plan.getPlanName() != null ? String.valueOf(plan.getPlanName()) : "N/A");
    	table.addCell(plan.getPlanStatus() != null ? String.valueOf(plan.getPlanStatus()) : "N/A");
    	table.addCell(plan.getPlanStartDate() != null ? String.valueOf(plan.getPlanStartDate()) : "N/A");
    	table.addCell(plan.getPlanEndDate() != null ? String.valueOf(plan.getPlanEndDate()) : "N/A");
    	table.addCell(plan.getBenefitAmount() != null ? String.valueOf(plan.getBenefitAmount()) : "N/A");
    	table.addCell(plan.getDenialReason() != null ? String.valueOf(plan.getDenialReason()) : "N/A");
    	table.addCell(plan.getTerminatedDate()!= null ? String.valueOf(plan.getTerminatedDate()) : "N/A");
    	table.addCell(plan.getTerminatedReason()!= null ? String.valueOf(plan.getTerminatedReason()) : "N/A");
    }

    document.add(table);
    document.close();
	}
}
