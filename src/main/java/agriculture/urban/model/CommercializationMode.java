package agriculture.urban.model;

/**
 * Business commercialization mode
 * 
 * @author Gwennaël Bouteloup
 */
public class CommercializationMode {
	// Attributes
    private Integer id;
    private String description;
    private String name;

    // Methods
    // Constructors
    /**
     * Default constructor
     */
    public CommercializationMode() {
    }

    /**
     * Fill all fields constructor
     * @param id
     * @param description
     * @param name
     */
    public CommercializationMode(Integer id, String description,String name){
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}