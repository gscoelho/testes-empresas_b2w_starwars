package br.com.starwars.entitys;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name="planet")
public class PlanetEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")	
	private Long id;

    @Column(name = "name")	
    private String name;

    @Column(name = "climate")	
    private String climate;
    
    @Column(name = "ground")	
    private String ground;
    
    @Column(name = "movieAppearancesNumber")	
    private Integer movieAppearancesNumber;
	
	public PlanetEntity() {}

    public PlanetEntity(Long id, String name, String climate, String ground, Integer movieAppearancesNumber) {
		this.id = id;
		this.name = name;
		this.climate = climate;
		this.ground = ground;
		this.movieAppearancesNumber = movieAppearancesNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClimate() {
		return climate;
	}

	public void setClimate(String climate) {
		this.climate = climate;
	}

	public String getGround() {
		return ground;
	}

	public void setGround(String ground) {
		this.ground = ground;
	}

	public Integer getMovieAppearancesNumber() {
		return movieAppearancesNumber;
	}

	public void setMovieAppearancesNumber(Integer movieAppearancesNumber) {
		this.movieAppearancesNumber = movieAppearancesNumber;
	}

	@Override
	public String toString() {
		return "PlanetEntity [id=" + id + ", name=" + name + ", climate=" + climate + ", ground=" + ground
				+ ", movieAppearancesNumber=" + movieAppearancesNumber + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlanetEntity other = (PlanetEntity) obj;
		return Objects.equals(climate, other.climate) && Objects.equals(ground, other.ground)
				&& Objects.equals(id, other.id) && Objects.equals(movieAppearancesNumber, other.movieAppearancesNumber)
				&& Objects.equals(name, other.name);
	}
	
}