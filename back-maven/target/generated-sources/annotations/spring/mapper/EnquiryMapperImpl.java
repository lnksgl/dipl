package spring.mapper;

import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import spring.enquiry.Enquiry;
import spring.enquiry.EnquiryDto;
import spring.enquiry.EnquiryMapper;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-03-04T14:19:08+0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 13.0.2 (Oracle Corporation)"
)
@Component
public class EnquiryMapperImpl implements EnquiryMapper {

    @Override
    public EnquiryDto enquiryToEnquiryDto(Enquiry enquiry) {
        if ( enquiry == null ) {
            return null;
        }

        EnquiryDto enquiryDto = new EnquiryDto();

        return enquiryDto;
    }

    @Override
    public Enquiry dtoToEnquiry(EnquiryDto enquiryDto) {
        if ( enquiryDto == null ) {
            return null;
        }

        Enquiry enquiry = new Enquiry();

        return enquiry;
    }
}
