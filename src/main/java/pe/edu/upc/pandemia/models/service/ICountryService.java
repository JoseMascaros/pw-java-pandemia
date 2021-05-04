package pe.edu.upc.pandemia.models.service;

import java.util.List;

import pe.edu.upc.pandemia.models.entities.Country;

public interface ICountryService {
	public void insert(Country country);

	public List<Country> list();

	public void delete(int countryId);
}
