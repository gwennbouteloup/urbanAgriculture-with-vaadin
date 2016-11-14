package agriculture.urban.model;

/**
 * Type of irrigation used for a production
 * 
 * @author Gwennaël Bouteloup
 */
public class IrrigationType {
	// Attributes
    private Integer id;
    private String name;
    private String description;
    
    // Methods
    // Constructors
    /**
     * Default constructor
     */
    public IrrigationType() {
    }

    /**
     * Fill all attributes constructors
     * @param id
     * @param name
     * @param description
     * @param productionCriterias
     */
    public IrrigationType(Integer id,String name,String description){
    	this.description = description;
    	this.id = id;
    	this.name = name;
    	this.description = description;
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