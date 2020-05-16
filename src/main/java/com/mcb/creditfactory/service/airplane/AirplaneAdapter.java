package com.mcb.creditfactory.service.airplane;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.dto.AssessmentDto;
import com.mcb.creditfactory.external.CollateralObject;
import com.mcb.creditfactory.external.CollateralType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;

public class AirplaneAdapter implements CollateralObject {

    private AirplaneDto airplaneDto;
    private AssessmentDto lastAssessmentDto;

    public AirplaneAdapter(AirplaneDto airplaneDto) {
        this.airplaneDto = airplaneDto;
        lastAssessmentDto = airplaneDto.getAssessmentDtos().stream()
                .max(Comparator.comparing(AssessmentDto::getDate))
                .get();
    }

    @Override
    public BigDecimal getAssessedValue() {
        return lastAssessmentDto.getValue();
    }

    @Override
    public Short getYear() {
        return airplaneDto.getYear();
    }

    @Override
    public LocalDate getAssessedDate() {
        return lastAssessmentDto.getDate();
    }

    @Override
    public CollateralType getType() {
        return CollateralType.AIRPLANE;
    }
}
