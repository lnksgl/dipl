package spring.enquiry;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.group.GroupService;
import spring.user.UserService;

import java.time.Instant;
import java.util.List;

import static java.util.stream.Collectors.toList;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Service
@AllArgsConstructor
@Transactional(readOnly = true)
@CacheConfig(cacheNames = {"service"})
public class EnquiryService {

    EnquiryRepository enquiryRepository;
    GroupService groupService;
    UserService userService;
    EnquiryMapper enquiryMapper;
    EnquiryMathOperations enquiryMathOperations;

    @Transactional
    public void createEnquiry(EnquiryDto enquiryDto) {
        Enquiry enquiry = mapFromDtoToEnquiry(enquiryDto);
        saveEnquiry(enquiry);

        List<Enquiry> enquiryList = readByIdGroups(enquiry.getIdGroups());

        if (checkMinEvaluation(enquiryList)) {
            groupService.updateAverage(enquiryMathOperations.minEvaluation(enquiryList), enquiry.getIdGroups());
        }
    }

    @Transactional
    public void saveEnquiry(Enquiry enquiry) {
        enquiryRepository.save(enquiry);
    }

    private boolean checkMinEvaluation(List<Enquiry> enquiryList) {
        return enquiryList.size() > 25;
    }

    @Transactional
    public void deleteEnquiry(long id) {
        enquiryRepository.delete(enquiryRepository.findById(id).orElseThrow(() -> new EnquiryNotFoundException("For id " + id)));
    }

    @Cacheable
    public List<EnquiryDto> showAllEnquiries() {
        return enquiryRepository.findAll().stream().map(this::mapFromEnquiryToDto).collect(toList());
    }

    @Transactional
    public List<Enquiry> readByIdGroups(Long id) {
        return enquiryRepository.findByIdGroups(id);
    }

    public Enquiry mapFromDtoToEnquiry(EnquiryDto enquiryDto) {
        Enquiry enquiry = new Enquiry();
        enquiry.setIdUsers(userService.showUsername(enquiryDto.getUsername()).get(0).getId());
        enquiry.setIdGroups(groupService.showNameGroup(enquiryDto.getName()).get(0).getId());
        enquiry.setCreatedOn(Instant.now());

        return enquiry;
    }

    public EnquiryDto mapFromEnquiryToDto(Enquiry enquiry) {
        return enquiryMapper.enquiryToEnquiryDto(enquiry);
    }
}
