package com.kraftheinzcompany.main;

import java.sql.Connection;
import java.sql.SQLException;
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
import com.kraftheinzcompany.data.OracleDBConnection;
import com.kraftheinzcompany.model.Address;
import com.kraftheinzcompany.model.Batch;
import com.kraftheinzcompany.model.Factory;
import com.kraftheinzcompany.model.Ingredient;
import com.kraftheinzcompany.model.Packaging;
import com.kraftheinzcompany.model.PowerConsumption;
import com.kraftheinzcompany.model.WaterConsumption;
import com.kraftheinzcompany.utils.OracleSQLSequence;

public class Main {

	public static void main(String[] args) {

		/** 
		 * Kraft-Heinz Environmental Manager
		 * 
		 * The code below will insert sample data into each table of the system's database.
		 * 
		 * Refer to the Data Model for details on the Data Structure and to the Class Diagram
		 * (or the classes here) for details about the implementation of the Model layer.
		 * 
		 * @authors Victor Bussiki, 
		 * Thalison da Silva Santos, 
		 * Davi Matos Almeida Rocha , 
		 * Adriano Araujo Vendramini
		 * 
		 */

		try {
			Connection connection = OracleDBConnection.getInstance().getConnection();

			//T_KH_ADDRESS
			Address address = new Address(75460000, "Nerópolis", "Zona Rural", "Rodovia Go 222", 5, "S/N");
			AddressDAO addressDAO = new AddressDAO();

			addressDAO.insert(address);

			//T_KH_FACTORY
			Factory factory = new Factory(address, "50955707000472", false);
			FactoryDAO factoryDAO = new FactoryDAO();

			factoryDAO.insert(factory);

			Integer factoryId = null;


			factoryId = OracleSQLSequence.getMostRecentVal("cd_factory", "T_KH_FACTORY", connection);
			factory.setId(factoryId);


			// Water Consumption:
			WaterConsumption wConsumption = new WaterConsumption(factory, 30, LocalDate.of(2023, 5, 10), "Local reservoir");
			WaterConsumptionDAO wComsumptionDao = new WaterConsumptionDAO();

			wComsumptionDao.insert(wConsumption);

			//Power Consumption:
			PowerConsumption pConsumption = new PowerConsumption(factory, 80, LocalDate.of(2023, 5, 10), "Solar", "Renewable");
			PowerConsumptionDAO pConsumptionDao = new PowerConsumptionDAO();

			pConsumptionDao.insert(pConsumption);

			//Packaging
			Packaging packaging = new Packaging("Plastic bottle 400mL", true);
			PackagingDAO packagingDao = new PackagingDAO();

			packagingDao.insert(packaging);

			Integer packagingId = null;

			packagingId = OracleSQLSequence.getMostRecentVal("cd_packaging", "T_KH_PACKAGING", connection);

			packaging.setId(packagingId);


			//Ingredients

			Ingredient tomatoes = new Ingredient(true, "tomatoes", "Bela Vista Farm", 700);
			Ingredient vinegar = new Ingredient(true, "vinegar", "Vinícola Sao Mateus", 500);
			Ingredient sugar = new Ingredient(false, "sugar", "Engenho Central", 300);


			IngredientDAO ingredientDao = new IngredientDAO();

			ingredientDao.insert(tomatoes);
			tomatoes.setId(OracleSQLSequence.getMostRecentVal("cd_ingredient", "T_KH_INGREDIENT", connection)); 
			
			ingredientDao.insert(vinegar);
			vinegar.setId(OracleSQLSequence.getMostRecentVal("cd_ingredient", "T_KH_INGREDIENT", connection));
			
			ingredientDao.insert(sugar);
			sugar.setId(OracleSQLSequence.getMostRecentVal("cd_ingredient", "T_KH_INGREDIENT", connection));

			List<Ingredient> ingredients = new ArrayList<Ingredient>();
			ingredients.add(tomatoes);
			ingredients.add(vinegar);
			ingredients.add(sugar);
			
			//Production Batch
			Batch batch = new Batch(factory, packaging, "Ketchup Heinz Tradicional 397G", ingredients, LocalDate.of(2023, 5, 21), LocalDate.of(2024, 5, 21));
			BatchDAO batchDao = new BatchDAO();

			batchDao.insert(batch);
		} catch (SQLException e) {

			e.printStackTrace();

		} 

	}
}
