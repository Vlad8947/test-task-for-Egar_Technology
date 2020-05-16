package com.mcb.creditfactory.external;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface CollateralObject {
    BigDecimal getAssessedValue();
    Short getYear();
    LocalDate getAssessedDate();
    CollateralType getType();
}
