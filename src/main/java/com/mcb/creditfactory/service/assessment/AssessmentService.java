package com.mcb.creditfactory.service.assessment;

import com.mcb.creditfactory.dto.AssessmentDto;
import com.mcb.creditfactory.model.Assessment;

import java.util.Set;

public interface AssessmentService {

    Set<AssessmentDto> toDto(Set<Assessment> assessments);
    Set<Assessment> fromDto(Set<AssessmentDto> assessmentDtos);

}
