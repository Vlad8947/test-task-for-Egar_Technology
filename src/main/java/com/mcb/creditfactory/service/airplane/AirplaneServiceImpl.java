package com.mcb.creditfactory.service.airplane;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.external.ExternalApproveService;
import com.mcb.creditfactory.model.Airplane;
import com.mcb.creditfactory.repository.AirplaneRepository;
import com.mcb.creditfactory.service.assessment.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class AirplaneServiceImpl implements AirplaneService {

    @Autowired
    private ExternalApproveService approveService;
    @Autowired
    private AirplaneRepository airplaneRepository;
    @Autowired
    private AssessmentService assessmentService;

    @Override
    public boolean approve(AirplaneDto airplaneDto) {
        int approveCode = approveService.approve(new AirplaneAdapter(airplaneDto));
        return approveCode == 0;
    }

    @Override
    public Airplane save(Airplane airplane) {
        return airplaneRepository.save(airplane);
    }

    @Override
    public Optional<Airplane> load(Long id) {
        return airplaneRepository.findById(id);
    }

    @Override
    public Airplane fromDto(AirplaneDto airplaneDto) {
        return new Airplane(
                airplaneDto.getId(),
                airplaneDto.getBrand(),
                airplaneDto.getModel(),
                airplaneDto.getManufacturer(),
                airplaneDto.getFuelCapacity(),
                airplaneDto.getSeats(),
                airplaneDto.getYear(),
                assessmentService.fromDto(airplaneDto.getAssessmentDtos())
        );
    }

    @Override
    public AirplaneDto toDTO(Airplane airplane) {
        return new AirplaneDto(
                airplane.getId(),
                airplane.getBrand(),
                airplane.getModel(),
                airplane.getManufacturer(),
                airplane.getFuelCapacity(),
                airplane.getSeats(),
                airplane.getYear(),
                assessmentService.toDto(airplane.getAssessments())
        );
    }

    @Override
    public Long getId(Airplane airplane) {
        return airplane.getId();
    }

}
