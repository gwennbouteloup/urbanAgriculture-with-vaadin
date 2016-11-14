package agriculture.urban.model;

/**
 * Do the link  between companies and corresponding locations
 * 
 * @author Gwennaël Bouteloup
 */
public class CompanyLocation {
	// Attributes
	private Company company;
	private InstallationLocation installationLocation;
    private String responsibleFirstName;
    private String responsibleName;
    private String phoneNumber;
    private Integer employeesNumber;
    private String description;

    // Methods
    // Constructors
    /**
     * Default constructor
     */
    public CompanyLocation() {
    }
    
    /**
     * Fill all attributes constructor
     * @param company
     * @param installationLocation
     * @param responsibleFirstName
     * @param responsibleName
     * @param phoneNumber
     * @param employeesNumber
     * @param description
     */
    public CompanyLocation(Company company,	 InstallationLocation installationLocation, 
    		String responsibleFirstName, String responsibleName,String phoneNumber, Integer employeesNumber, String description){
    	this.setCompany(company);
    	this.setDescription(description);
    	this.setEmployeesNumber(employeesNumber);
    	this.setInstallationLocation(installationLocation);
    	this.setPhoneNumber(phoneNumber);
    	this.setResponsibleFirstName(responsibleFirstName);
    	this.setResponsibleName(responsibleName);
    }
    		
    // Getters and setters
    public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public InstallationLocation getInstallationLocation() {
		return installationLocation;
	}

	public void setInstallationLocation(InstallationLocation installationLocation) {
		this.installationLocation = installationLocation;
	}

	public String getResponsibleFirstName() {
		return responsibleFirstName;
	}

	public void setResponsibleFirstName(String responsibleFirstName) {
		this.responsibleFirstName = responsibleFirstName;
	}

	public String getResponsibleName() {
		return responsibleName;
	}

	public void setResponsibleName(String responsibleName) {
		this.responsibleName = responsibleName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getEmployeesNumber() {
		return employeesNumber;
	}

	public void setEmployeesNumber(Integer employeesNumber) {
		this.employeesNumber = employeesNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
}
