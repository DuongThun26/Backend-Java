package com.javaweb.api;

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

@RestController
public class BuildingAPI {
	@RequestMapping(value = "/api/building", method = RequestMethod.GET)
	public void building(@RequestParam Map<String, String> params) {
		System.out.print(5/0);
		for(Map.Entry<String, String> mp : params.entrySet()) {
			System.out.println(mp.getKey() + ": " + mp.getValue());
		}
	}
	@PostMapping(value = "/api/building")
	public void createBuilding(@RequestBody Map<String, String> body) {
		for(Map.Entry<String, String> mp : body.entrySet()) {
			System.out.println(mp.getKey() + ": " + mp.getValue());
		}
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
