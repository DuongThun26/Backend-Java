package com.javaweb.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.customException.FieldRequiredException;
import com.javaweb.model.BuildingDTO;
import com.javaweb.service.BuildingService;

@RestController
public class BuildingAPI {
	@Autowired
	private BuildingService buildingService;
	@PostMapping(value = "/api/building")
	public Object createBuilding(@RequestBody BuildingDTO buildingDTO){
		valiDate(buildingDTO);
		return "success";
	}
	
	public void valiDate(BuildingDTO buildingDTO){
		if(buildingDTO.getName().trim().isEmpty() || buildingDTO.getNumberOfBasement() == null || buildingDTO.getName() == null) {
			throw new FieldRequiredException("name or numberOfBasement is null!");
		}
	}
	@GetMapping(value="/api/building")
	public List<BuildingDTO> getAllBuilding(){
	    List<BuildingDTO> buildings = buildingService.getAllBuilding();
	    return buildings;
	}
	@PutMapping(value = "/api/building/update")
	public BuildingDTO updateBuilding(@RequestBody BuildingDTO buildingDTO) {
		return buildingDTO;
	}
	@DeleteMapping(value = "api/building/delete/{id}")
	public void deleteBuilding(@PathVariable Integer id) {
		System.out.println("Xoa thanh cong toa nha co ma: " + id);
	}
}
