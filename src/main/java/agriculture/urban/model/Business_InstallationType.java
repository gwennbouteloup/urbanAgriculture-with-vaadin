package agriculture.urban.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *  The type of installation used for the business
 *  
 * @author Gwennaël Bouteloup 
 */
@SuppressWarnings("serial")
@MappedSuperclass
public abstract class Business_InstallationType implements Serializable{
	// Attributes
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idCompany", updatable = false, nullable = false)
	private Integer idCompany;
	
	@Column(name="idCompanyLocation")
	private Integer idCompanyLocation; 
	
	@Column(name="idBusiness")
	private Integer idBusiness;
	
	@Column(name="idInstallationType")
	private Integer idInstallationType;
	
	// Methods
	// Constructors
	/**
	 * Default constructor
	 */
	public Business_InstallationType(){
	}
	
	/**
	 * Fill all fields constructor
	 * @param business
	 * @param installationType
	 * @param companyLocation
	 * @throws Exception 
	 */
	public Business_InstallationType(Business business,InstallationType installationType,CompanyLocation companyLocation) throws Exception{
		if(business == null){
			throw new Exception ("Business_InstallationType constructor: business passed in parameter is null");
		}
		if(installationType == null){
			throw new Exception ("Business_InstallationType constructor: installationType passed in parameter is null");
		}
		if(companyLocation == null){
			throw new Exception ("Business_InstallationType constructor: companyLocation passed in parameter is null");
		}
		
		if(companyLocation.getCompany()!=null){
			this.setIdCompany(companyLocation.getCompany().getId());
		}else{
			throw new Exception ("Business_InstallationType constructor: the Company linked to the  "
					+ "companyLocation passed in parameter is null");
		}
		if(companyLocation.getInstallationLocation()!=null){ 
			this.setIdCompanyLocation(companyLocation.getInstallationLocation().getId());
		}else{
			throw new Exception ("Business_InstallationType constructor: the InstallationLocation linked to the  "
					+ "companyLocation passed in parameter is null");
		}
		this.setIdBusiness(business.getId());
		this.setIdInstallationType(installationType.getId());
	}

	// Getters and setters
	public Integer getIdCompany() {
		return idCompany;
	}

	public void setIdCompany(Integer idCompany) {
		this.idCompany = idCompany;
	}

	public Integer getIdCompanyLocation() {
		return idCompanyLocation;
	}

	public void setIdCompanyLocation(Integer idCompanyLocation) {
		this.idCompanyLocation = idCompanyLocation;
	}

	public Integer getIdBusiness() {
		return idBusiness;
	}

	public void setIdBusiness(Integer idBusiness) {
		this.idBusiness = idBusiness;
	}

	public Integer getIdInstallationType() {
		return idInstallationType;
	}

	public void setIdInstallationType(Integer idInstallationType) {
		this.idInstallationType = idInstallationType;
	}
	
	
}
