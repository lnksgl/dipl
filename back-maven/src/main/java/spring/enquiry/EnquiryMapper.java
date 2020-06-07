package spring.enquiry;

import org.mapstruct.Mapper;
import spring.enquiry.Enquiry;
import spring.enquiry.EnquiryDto;

@Mapper(componentModel = "spring")
public interface EnquiryMapper {

    EnquiryDto enquiryToEnquiryDto(Enquiry enquiry);

    Enquiry dtoToEnquiry(EnquiryDto enquiryDto);
}
