package pe.edu.upc.pandemia.models.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.pandemia.models.dao.IRegionDao;
import pe.edu.upc.pandemia.models.entities.Region;

public class RegionDaoImpl implements IRegionDao {

	@PersistenceContext(unitName = "pandemiaPU")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Region reg) {
		try {
			em.persist(reg);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error at insert Region in dao");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Region> list() {
		List<Region> list = new ArrayList<Region>();

		try {
			Query q = em.createQuery("from Region r");
			list = (List<Region>) q.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return list;
	}

	@Transactional
	@Override
	public void delete(Integer region_id) {
		Region re = new Region();

		try {
			re = em.getReference(Region.class, region_id);
			em.remove(re);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public List<Region> findByName(Region reg) {
		List<Region> list = new ArrayList<Region>();

		try {
			Query q = em.createQuery("from Region r where r.name like ?1");
			q.setParameter(1, "%" + reg.getName() + "%");
			list = (List<Region>) q.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return list;
	}

}
