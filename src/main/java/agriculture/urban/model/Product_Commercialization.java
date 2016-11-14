package agriculture.urban.model;

/**
 *  Do the link between products and used commercialisation mode.
 *  
 * @author Gwennaël Bouteloup
 */
public class Product_Commercialization {
	// Attributes
	private Product product;
	private CommercializationMode commercializationMode;
	private CompanyLocation companyLocation;
	
	// Methods
	// Constructors
	/**
	 * Default constructor
	 */
	public Product_Commercialization(){	
	}
	
	/**
	 * Fill all attributes constructor
	 * @param product
	 * @param commercialisationMode
	 * @param companyLocation
	 */
	public Product_Commercialization(Product product,CommercializationMode commercializationMode,CompanyLocation companyLocation){
		this.commercializationMode = commercializationMode;
		this.companyLocation = companyLocation;
		this.product = product;
	}
	
	// Getters and setters
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public CommercializationMode getCommercializationMode() {
		return commercializationMode;
	}

	public void setCommercialisationMode(CommercializationMode commercializationMode) {
		this.commercializationMode = commercializationMode;
	}

	public CompanyLocation getCompanyLocation() {
		return companyLocation;
	}

	public void setCompanyLocation(CompanyLocation companyLocation) {
		this.companyLocation = companyLocation;
	}
}
