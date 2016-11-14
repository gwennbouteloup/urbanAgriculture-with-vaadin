package agriculture.urban.model;

/**
 * Business objective descriptions
 * 
 * @author Gwennaël Bouteloup
 */
public class Objective {
	// Attributes
    private Integer id;
    private String name;
    private String description;
    
    // Methods
    // Constructors
    /**
     * Default constructor
     */
    public Objective() {
    }
    
    /**
     * Fill all attributes constructor
     * @param id
     * @param name
     * @param description
     */
    public Objective(Integer id,String name,String description){
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