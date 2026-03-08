package com.javaweb.repository.imp;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;

@Repository
public class BuildingRepositoryImp implements BuildingRepository{
	String url = "jdbc:mysql://localhost:3306/building_management";
	String name = "root";
	String password = "2662004";
	
	@Override
	public List<BuildingEntity> getAllBuilding() {
		List<BuildingEntity> buildings = new ArrayList<BuildingEntity>();
		try(Connection conn = DriverManager.getConnection(url, name, password)){
			if (conn != null) {
                System.out.println("Connected to the database!");
                // Proceed to Step 3: Create a Statement
                Statement stm = (Statement) conn.createStatement();
    			String sql = "SELECT * FROM building";
    		    ResultSet rs = stm.executeQuery(sql);
    		    while (rs.next()) {
    		    	BuildingEntity buildingEntity = new BuildingEntity();
    		    	buildingEntity.setName(rs.getString("name"));
    		    	buildingEntity.setNumberOfBasement(rs.getString("number_of_basement"));
    		    	buildingEntity.setWard(rs.getString("ward"));
    		    	buildingEntity.setCity(rs.getString("city"));
    		    	buildingEntity.setColor(rs.getString("color"));
    		        buildings.add(buildingEntity);
    		    }
    		    conn.close();
            }			
		}catch(SQLException e) {
			System.err.println("Database connection failed:");
            e.printStackTrace();
		}
	    return buildings;
	}
	
}
