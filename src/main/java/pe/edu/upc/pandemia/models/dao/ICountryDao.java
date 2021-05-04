package pe.edu.upc.pandemia.models.dao;

import java.util.List;

import pe.edu.upc.pandemia.models.entities.Country;

public interface ICountryDao {
	public void insert(Country country);
	
	public List<Country>list();
	
	public void delete(Integer country_id);
}
