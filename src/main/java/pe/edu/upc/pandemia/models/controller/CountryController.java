package pe.edu.upc.pandemia.models.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.pandemia.models.entities.Country;
import pe.edu.upc.pandemia.models.entities.Region;
import pe.edu.upc.pandemia.models.service.ICountryService;
import pe.edu.upc.pandemia.models.service.IRegionService;

@Named
@RequestScoped
public class CountryController {
	
	@Inject
	private ICountryService cService;
	
	@Inject
	private IRegionService rService;
	
	private Country country;
	List<Country> countryList;
	List<Region> regionList;
	
	//Constructor
	@PostConstruct
	public void init() {
		this.country = new Country();
		countryList = new ArrayList<Country>();
		regionList = new ArrayList<Region>();
		this.listCountry();
		this.listRegion();
	}
	
	// Specialized methods
	public String newCountry() {
		this.setCountry(new Country());
		return "country.xhtml";
	}
	
	public void insert() {
		try {
			cService.insert(country);
		} catch (Exception e) {
			System.out.println("Error at insert in CountryController");
		}
	}
	
	public void listCountry() {
		try {
			countryList = cService.list();
		}catch(Exception e) {
			System.out.println("Error at list in CountryController");
		}
	}
	
	public void listRegion() {
		try {
			regionList = rService.list();
		}catch(Exception e) {
			System.out.println("Error at list in CountryController");
		}
	}
	
	public void delete(Country country) {
		try {
			cService.delete(country.getId());
			this.listCountry();
		} catch (Exception e) {
			System.out.println("Error at delete in CountryController");
		}
	}
	
	//Getters & Setters
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public List<Country> getCountryList() {
		return countryList;
	}
	public void setCountryList(List<Country> countryList) {
		this.countryList = countryList;
	}
	public List<Region> getRegionList() {
		return regionList;
	}
	public void setRegionList(List<Region> regionList) {
		this.regionList = regionList;
	}
	
}
