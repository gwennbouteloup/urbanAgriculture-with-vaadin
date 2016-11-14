package agriculture.urban.model;

/**
 * Fertilization type used for a production on an installation
 * 
 * @author Gwennaël Bouteloup
 */
public class FertilizationType {
	// Attributes
    private Integer id;
    private String name;
    private String description;

    // Methods
    // Constructors
    /**
     * Default constructor
     */
    private FertilizationType() {
    }
    
    /**
     * Fill all attributes constructor
     * @param id
     * @param name
     * @param description
     * @param productionCriterias
     */
    private FertilizationType(Integer id,String name,String description){
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