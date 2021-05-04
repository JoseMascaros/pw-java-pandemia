package pe.edu.upc.pandemia.models.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.pandemia.models.dao.ICountryDao;
import pe.edu.upc.pandemia.models.entities.Country;
import pe.edu.upc.pandemia.models.service.ICountryService;

@Named
@RequestScoped
public class CountryServiceImpl implements ICountryService {
	
	@Inject
	private ICountryDao cDao;
	
	@Override
	public void insert(Country country) {
		cDao.insert(country);
	}

	@Override
	public List<Country> list() {
		return cDao.list();
	}

	@Override
	public void delete(int countryId) {
		cDao.delete(countryId);
	}
	
}
