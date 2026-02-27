package in.venkyit.load;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.venkyit.entity.Insurance;
import in.venkyit.repo.InsuranceRepo;

@Component
public class DataLoader implements ApplicationRunner{

    @Autowired
    private InsuranceRepo repo;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        repo.deleteAll();

        Insurance I1=new Insurance();
        I1.setCitizenName("venky");
        I1.setGender("male");
        I1.setPlanName("cash");
        I1.setPlanStatus("Approved");
        I1.setPlanStartDate(LocalDate.now());
        I1.setPlanEndDate(LocalDate.now().plusMonths(6));
        I1.setBenefitAmount(5000);

        Insurance I2=new Insurance();
        I2.setCitizenName("shiva");
        I2.setGender("male");
        I2.setPlanName("cash");
        I2.setPlanStatus("Denied");
        I2.setDenialReason("employee");

        Insurance I3=new Insurance();
        I3.setCitizenName("shiva");
        I3.setGender("male");
        I3.setPlanName("cash");
        I3.setPlanStatus("Terminated");
        I3.setTerminatedDate(LocalDate.now());
        I3.setTerminatedReason("money Pending");

        Insurance I4=new Insurance();
        I4.setCitizenName("rani");
        I4.setGender("female");
        I4.setPlanName("food");
        I4.setPlanStatus("Approved");
        I4.setPlanStartDate(LocalDate.now());
        I4.setPlanEndDate(LocalDate.now().plusMonths(6));
        I4.setBenefitAmount(4000);

        Insurance I5=new Insurance();
        I5.setCitizenName("rocky");
        I5.setGender("male");
        I5.setPlanName("food");
        I5.setPlanStatus("Denied");
        I5.setDenialReason("Teacher");

        Insurance I6=new Insurance();
        I6.setCitizenName("shiva");
        I6.setGender("male");
        I6.setPlanName("food");
        I6.setPlanStatus("Terminated");
        I6.setTerminatedDate(LocalDate.now());
        I6.setTerminatedReason("Due to money pending");

        Insurance I7=new Insurance();
        I7.setCitizenName("rani");
        I7.setGender("female");
        I7.setPlanName("medical");
        I7.setPlanStatus("Approved");
        I7.setPlanStartDate(LocalDate.now());
        I7.setPlanEndDate(LocalDate.now().plusMonths(6));
        I7.setBenefitAmount(6000);

        Insurance I8=new Insurance();
        I8.setCitizenName("king");
        I8.setGender("male");
        I8.setPlanName("medical");
        I8.setPlanStatus("Denied");
        I8.setDenialReason("doctor");

        Insurance I9=new Insurance();
        I9.setCitizenName("queen");
        I9.setGender("female");
        I9.setPlanName("medical");
        I9.setPlanStatus("Terminated");
        I9.setTerminatedDate(LocalDate.now());
        I9.setTerminatedReason("still pending");

        Insurance I10=new Insurance();
        I10.setCitizenName("shankar");
        I10.setGender("male");
        I10.setPlanName("employment");
        I10.setPlanStatus("Approved");
        I10.setPlanStartDate(LocalDate.now());
        I10.setPlanEndDate(LocalDate.now().plusMonths(6));
        I10.setBenefitAmount(4000);

        Insurance I11=new Insurance();
        I11.setCitizenName("abd");
        I11.setGender("male");
        I11.setPlanName("employment");
        I11.setPlanStatus("Denied");
        I11.setDenialReason("advertiser");

        Insurance I12=new Insurance();
        I12.setCitizenName("rose");
        I12.setGender("female");
        I12.setPlanName("employment");
        I12.setPlanStatus("Terminated");
        I12.setTerminatedDate(LocalDate.now());
        I12.setTerminatedReason("not paid");

        List<Insurance> list=Arrays.asList(I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12);

        repo.saveAll(list);
    }
}