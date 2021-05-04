package pe.edu.upc.pandemia.models.dao;

import java.util.List;

import pe.edu.upc.pandemia.models.entities.Region;

public interface IRegionDao {

	public void insert(Region reg);

	public List<Region> list();

	public void delete(Integer region_id);
	
	public List<Region> findByName(Region reg);
}
