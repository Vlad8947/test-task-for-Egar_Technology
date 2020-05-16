package com.mcb.creditfactory.service.assessment;

import com.mcb.creditfactory.dto.AssessmentDto;
import com.mcb.creditfactory.model.Assessment;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AssessmentServiceImpl implements AssessmentService {

    @Override
    public Set<AssessmentDto> toDto(Set<Assessment> assessments) {
        return assessments.stream()
                .map(assessment ->
                        new AssessmentDto(
                                assessment.getId(),
                                assessment.getAssessedValue(),
                                assessment.getAssessedDate()))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Assessment> fromDto(Set<AssessmentDto> assessmentDtos) {
        return assessmentDtos.stream()
                .map(assessmentDto ->
                        new Assessment(
                                assessmentDto.getId(),
                                assessmentDto.getDate(),
                                assessmentDto.getValue()))
                .collect(Collectors.toSet());
    }

}
