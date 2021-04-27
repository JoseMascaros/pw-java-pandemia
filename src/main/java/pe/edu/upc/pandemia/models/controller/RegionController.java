package pe.edu.upc.pandemia.models.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.pandemia.models.entities.Region;
import pe.edu.upc.pandemia.models.service.IRegionService;

@Named
@RequestScoped
public class RegionController {

	@Inject
	private IRegionService rService;

	private Region region;

	List<Region> regionList;

	// Constructor
	@PostConstruct
	public void init() {
		this.region = new Region();
		this.regionList = new ArrayList<Region>();
		this.list();
	}

	// Specialized methods
	public String newRegion() {
		this.setRegion(new Region());
		return "region.xhtml";
	}

	public void insert() {
		try {
			rService.insert(region);
		} catch (Exception e) {
			System.out.println("Error at insert in RegionController");
		}
	}

	public void list() {
		try {
			regionList = rService.list();
		}catch(Exception e) {
			System.out.println("Error at list in RegionController");
		}
	}
	
	public void delete(Region re) {
		try {
			rService.delete(re.getId());
			this.list();
		} catch (Exception e) {
			System.out.println("Error at delete in RegionController");
		}
	}

	// Getter & Setter
	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public List<Region> getRegionList() {
		return regionList;
	}

	public void setRegionList(List<Region> regionList) {
		this.regionList = regionList;
	}

}
