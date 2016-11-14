package agriculture.urban.model;

/**
 * The location of an installation
 * 
 * @author Gwennaël Bouteloup
 */
public abstract class InstallationLocation {
	// Attributes
    private Integer id;
    private String country;
    private String address;
    private Integer zipCode;
    private String city;
    private String description;

    // Methods
    // Constructors
    /**
     * Default constructor
     */
    public InstallationLocation() {
    }
    
    /**
     * Fill all attributes constructor
     * @param id
     * @param country
     * @param address
     * @param zipCode
     * @param city
     * @param description
     */
    public InstallationLocation(Integer id, String country, String address, Integer zipCode, String city, String description){
    	this.address = address;
    	this.city = city;
    	this.country = country;
    	this.description = description;
    	this.id = id;
    	this.zipCode = zipCode;
    }
    	
    // Methods
    // Getters and setters
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String adress) {
		this.address = adress;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}