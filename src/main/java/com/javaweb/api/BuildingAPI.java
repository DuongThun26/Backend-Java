package com.javaweb.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.beans.BuildingDTO;
import com.javaweb.beans.ErrorResponseDTO;
import com.javaweb.customException.FieldRequiredException;

@RestController
public class BuildingAPI {
	@PostMapping(value = "/api/building")
	public ErrorResponseDTO building(@RequestBody BuildingDTO buildingDTO) {
		try {
			valiDate(buildingDTO);
		}catch(FieldRequiredException e){
			ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
			errorResponseDTO.setError(e.getMessage());
			List<String> details = new ArrayList<>();
			details.add("Xem lại phần name và numberOfBasement!");
			errorResponseDTO.setDetails(details);
			return errorResponseDTO;
		}
		return null;
	}
	public void valiDate(BuildingDTO buildingDTO) throws FieldRequiredException{
		if(buildingDTO.getName() == "" || buildingDTO.getNumberOfBasement() == null || buildingDTO.getName() == null) {
			throw new FieldRequiredException("name or numberOfBasement is null!");
		}
	}
//	@PostMapping(value = "/api/building")
//	public void createBuilding(@RequestBody Map<String, String> body) {
//		for(Map.Entry<String, String> mp : body.entrySet()) {
//			System.out.println(mp.getKey() + ": " + mp.getValue());
//		}
//	}
	@PutMapping(value = "/api/building/update")
	public BuildingDTO updateBuilding(@RequestBody BuildingDTO buildingDTO) {
		return buildingDTO;
	}
	@DeleteMapping(value = "api/building/delete/{id}")
	public void deleteBuilding(@PathVariable Integer id) {
		System.out.println("Xoa thanh cong toa nha co ma: " + id);
	}
}
