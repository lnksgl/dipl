package spring.enquiry;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import spring.user.UserRepository;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Component
public class EnquiryMathOperations {

    UserRepository userRepository;

    public double minEvaluation(List<Enquiry> enquiryList) {
        double[] evaluations = new double[enquiryList.size()];

        for (int i = 0; i < enquiryList.size() - 1; i++) {
            evaluations[i] = parseEvaluation(enquiryList.get(i).getIdUsers());
        }

        Arrays.sort(evaluations);

        return evaluations[24];
    }

    public double parseEvaluation(Long id) {
        return Double.parseDouble(userRepository.findById(id).get().getScanDocument());
    }

    public double average(String[] evaluations) {
        int sum = 0;

        for (String evaluation : evaluations) {
            sum += Integer.decode(evaluation);
        }

        return sum / (double) evaluations.length;
    }
}
