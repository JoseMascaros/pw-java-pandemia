package pe.edu.upc.pandemia.models.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.pandemia.models.dao.ICountryDao;
import pe.edu.upc.pandemia.models.entities.Country;

public class CountryDaoImpl implements ICountryDao {
	
	@PersistenceContext(unitName = "pandemiaPU")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insert(Country country) {
		try {
			em.persist(country);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error at insert Region in dao");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Country> list() {
		List<Country> list = new ArrayList<Country>();

		try {
			Query q = em.createQuery("from Country c");
			list = (List<Country>) q.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return list;
	}
	
	@Transactional
	@Override
	public void delete(Integer country_id) {
		Country country = new Country();

		try {
			country = em.getReference(Country.class, country_id);
			em.remove(country);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
