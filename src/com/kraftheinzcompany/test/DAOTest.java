package com.kraftheinzcompany.test;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.kraftheinzcompany.dao.AddressDAO;
import com.kraftheinzcompany.dao.BatchDAO;
import com.kraftheinzcompany.dao.FactoryDAO;
import com.kraftheinzcompany.dao.IngredientDAO;
import com.kraftheinzcompany.dao.PackagingDAO;
import com.kraftheinzcompany.dao.PowerConsumptionDAO;
import com.kraftheinzcompany.dao.WaterConsumptionDAO;
import com.kraftheinzcompany.model.Address;
import com.kraftheinzcompany.model.Batch;
import com.kraftheinzcompany.model.Factory;
import com.kraftheinzcompany.model.Ingredient;
import com.kraftheinzcompany.model.Packaging;
import com.kraftheinzcompany.model.PowerConsumption;
import com.kraftheinzcompany.model.WaterConsumption;
import com.kraftheinzcompany.utils.OracleSQLSequence;

public class DAOTest {

	public static void main(String[] args) {
		
		Address address = new Address(1234567, "Sao Paulo", "Pinheiros", "Av Rebouças", 1300, null);
		AddressDAO addressDAO = new AddressDAO();
			
		
		
		Factory factory = new Factory(address, "63839393000141", true);
		factory.setId(3);
		
		FactoryDAO factoryDao = new FactoryDAO();
		
		
		WaterConsumption wc = new WaterConsumption(factory, 20, LocalDate.of(2023, 5, 10), "Local reservoir");
		WaterConsumptionDAO wcdao = new WaterConsumptionDAO();
		
		PowerConsumption pc = new PowerConsumption(factory, 30, LocalDate.of(2023, 5, 10), "Solar", "Renewable");
		PowerConsumptionDAO pcdao = new PowerConsumptionDAO();
		
		Packaging p = new Packaging("Plastic", true);
		p.setId(2);
		PackagingDAO pd = new PackagingDAO(); 
		
		Ingredient i = new Ingredient(false, "Tomatoes", "Bela-Vista Farm", 300);
		i.setId(2);
		Ingredient i2 = new Ingredient(true, "Vinegar", "Vinícola São João", 700);
		i2.setId(3);
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		ingredients.add(i);
		ingredients.add(i2);
		IngredientDAO id = new IngredientDAO();
		
		Batch b = new Batch(factory, p, "Ketchup Heinz Tradicional 397G", ingredients, LocalDate.of(2023, 4, 15), LocalDate.of(2024, 3, 10)); 
		BatchDAO bd = new BatchDAO();
		
		//Insert
		
		addressDAO.insert(address);
		
//		factoryDao.insert(factory);

//		wcdao.insert(wc);
		
//		pcdao.insert(pc);
		
//		pd.insert(p);
		
//		id.insert(i);
//		id.insert(i2);
		
//		bd.insert(b);
		
		
	}

}
