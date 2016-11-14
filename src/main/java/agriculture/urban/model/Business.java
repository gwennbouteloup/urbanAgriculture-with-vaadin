package agriculture.urban.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Urban agriculture business model definition
 * 
 * @author Gwennaël Bouteloup
 */
@SuppressWarnings("serial")
@Entity
@Table(name="Business")
public class Business implements Serializable {
	// Attributes
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
    private Integer id;
	
	@Column(name="name")
    private String name;
	
	@Column(name="description")
    private String description;

    // Methods
    // Constructors
    /**
     * Default constructor
     */
    public Business() {
    }
   
    /**
     * Fill all attributes parameter
     * @param id
     * @param name
     * @param description
     */
    public Business (Integer id,String name,String description){
    	this.setDescription(description);
    	this.setId(id);
    	this.setName(name);
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