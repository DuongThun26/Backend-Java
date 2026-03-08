package com.javaweb.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.service.BuildingService;
@Service
public class BuildingServiceImp implements BuildingService{
	@Autowired
	private BuildingRepository buildingRepository;
	@Override
	public List<BuildingDTO> getAllBuilding() {
		// TODO Auto-generated method stub
		List<BuildingDTO> result = new ArrayList<BuildingDTO>();
		List<BuildingEntity> buildings = buildingRepository.getAllBuilding();
		for(BuildingEntity item : buildings) {
			BuildingDTO buildingDTO = new BuildingDTO();
			buildingDTO.setName(item.getName());
			buildingDTO.setNumberOfBasement(item.getNumberOfBasement());
			buildingDTO.setAddress(item.getCity() + ", " + item.getWard());
			buildingDTO.setColor(item.getColor());
			result.add(buildingDTO);
		}		
		return result;
	}

}
