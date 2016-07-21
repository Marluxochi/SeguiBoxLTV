package com.seguriboxltv.core.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.seguriboxltv.core.dao.CarDao;
import com.seguriboxltv.core.domain.Car;


@Repository
public class CarDaoImpl implements CarDao {

	@Autowired
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource){
		
		this.dataSource=dataSource;
	}
	
	public List<Car> getCarDetails() {
		System.out.println("entro");
		//String sql="SELECT * FROM CarList";
		String sql="{call getCarList}";
		Connection conn=null;
		List<Car> cars=new ArrayList<>();
		try {
			System.out.println("entro al catchmnmj");
			
			conn=dataSource.getConnection();
			System.out.println(dataSource.getConnection());
			//PreparedStatement ps = conn.prepareStatement(sql);
			PreparedStatement ps = conn.prepareCall(sql);
			
			System.out.println("entro al catch2");
			ResultSet rs = ps.executeQuery();
			System.out.println("entro al catch3");
			
			while(rs.next()){
				System.out.println("entro while");
				Car car=new Car();
				car.setId(rs.getInt("id"));
				car.setName(rs.getString("nombre"));
				System.out.println("nombre -"+rs.getString("nombre"));
				cars.add(car);
			}
			
		} catch (Exception e) {
			
			System.out.println("la excepcion es: "+e);;
		}finally{
			
			
		}
		
		
		System.out.println("hola desde el dao22: "+cars.size());
//		for(Car c : cars){
//			
//			System.out.println(c.getName());
//		}

		
		return cars;
	}

}
