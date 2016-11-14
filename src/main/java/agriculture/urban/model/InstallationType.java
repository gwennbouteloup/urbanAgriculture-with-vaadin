package agriculture.urban.model;

/**
 * The type of installation used for a business
 * 
 * @author Gwennaël Bouteloup
 */
public class InstallationType {
	// Attributes
    private Integer id;
    private String name;
    private String description;

    // Methods
    /**
     * Default constructor
     */
    public InstallationType() {
    }
    
    /**
     * Fill all fields constructor
     * @param id
     * @param name
     * @param description
     */
    public InstallationType(Integer id,String name,String description){
    	this.description = description;
    	this.id = id;
    	this.name = name;
    }

    // Getters and setters
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}