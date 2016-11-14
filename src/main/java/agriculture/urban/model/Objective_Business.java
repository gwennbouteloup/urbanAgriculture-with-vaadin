package agriculture.urban.model;

/**
 * Do the link between Objectives and Business
 * 
 * @author Gwennaël Bouteloup
 */
public class Objective_Business {
	// Attributes
	private Objective objective;
	private Business business;
	private CompanyLocation companyLocation;
	
	// Methods
	// Constructors
	public Objective_Business(){
	}
	
	/**
	 * Fill all attributes methods
	 * @param objective
	 * @param business
	 * @param companyLocation
	 */
	public Objective_Business(Objective objective, Business business, CompanyLocation companyLocation){
		this.setBusiness(business);
		this.setCompanyLocation(companyLocation);
		this.setObjective(objective);
	}

	// Getters and setters
	public Objective getObjective() {
		return objective;
	}

	public void setObjective(Objective objective) {
		this.objective = objective;
	}

	public Business getBusiness() {
		return business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}

	public CompanyLocation getCompanyLocation() {
		return companyLocation;
	}

	public void setCompanyLocation(CompanyLocation companyLocation) {
		this.companyLocation = companyLocation;
	}
}
