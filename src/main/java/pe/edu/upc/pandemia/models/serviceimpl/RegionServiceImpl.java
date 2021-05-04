package pe.edu.upc.pandemia.models.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.pandemia.models.dao.IRegionDao;
import pe.edu.upc.pandemia.models.entities.Region;
import pe.edu.upc.pandemia.models.service.IRegionService;

@Named
@RequestScoped
public class RegionServiceImpl implements IRegionService {

	@Inject
	private IRegionDao rDao;

	@Override
	public void insert(Region reg) {
		rDao.insert(reg);
	}

	@Override
	public List<Region> list() {
		return rDao.list();
	}

	@Override
	public void delete(Integer region_id) {
		rDao.delete(region_id);
	}

	@Override
	public List<Region> findByName(Region reg) {
		return rDao.findByName(reg);
	}

}
