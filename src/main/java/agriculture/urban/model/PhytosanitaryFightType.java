package agriculture.urban.model;

/**
 * The phytosanitary fight type used for product(s)
 * 
 * @author Gwennaël Bouteloup
 */
public class PhytosanitaryFightType {
	// Attributes
    private Integer id;
    private String name;
    private String description;

    // Methods
    // Constructors
    /**
     * Default constructor
     */
    public PhytosanitaryFightType() {
    }

    /**
     * Fill all attributes constructor
     * @param id
     * @param name
     * @param description
     * @param productionCriteria
     */
    public PhytosanitaryFightType(Integer id,String name,String description) {
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