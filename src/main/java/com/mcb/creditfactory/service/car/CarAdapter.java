package com.mcb.creditfactory.service.car;

import com.mcb.creditfactory.dto.AssessmentDto;
import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.external.CollateralObject;
import com.mcb.creditfactory.external.CollateralType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;

public class CarAdapter implements CollateralObject {

    private CarDto carDto;
    private AssessmentDto lastAssessmentDto;

    public CarAdapter(CarDto carDto) {
        this.carDto = carDto;
        lastAssessmentDto = carDto.getAssessmentDtos().stream()
                .max(Comparator.comparing(AssessmentDto::getDate))
                .get();
    }

    @Override
    public BigDecimal getAssessedValue() {
        return lastAssessmentDto.getValue();
    }

    @Override
    public Short getYear() {
        return carDto.getYear();
    }

    @Override
    public LocalDate getAssessedDate() {
        return lastAssessmentDto.getDate();
    }

    @Override
    public CollateralType getType() {
        return CollateralType.CAR;
    }


}
