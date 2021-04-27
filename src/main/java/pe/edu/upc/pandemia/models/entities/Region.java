package pe.edu.upc.pandemia.models.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "regions")
public class Region {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "region_id")
	private Integer id;

	@Column(name = "region_name", length = 25)
	private String name;

	// @OneToMany(mappedBy = "region", fetch = FetchType.LAZY)
	// private List<Country> countries;

	// -- Constructor, Getter & Setter
	// public Region() {
	// countries = new ArrayList<Country>();
	// }

	public Region() {
		super();
	}

	public Region(Integer id, String name) {
		this.name = name;
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// public List<Country> getContries() {
	// return countries;
	// }

	// public void setContries(List<Country> countries) {
	// this.countries = countries;
	// }

}
