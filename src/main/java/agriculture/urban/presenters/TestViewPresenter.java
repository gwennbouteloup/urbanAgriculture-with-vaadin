package agriculture.urban.presenters;

import java.util.List;

import agriculture.urban.model.Business_InstallationType_OnGround;
import agriculture.urban.model.DAO.core.Business_InstallationType_OnGround_DAO;
import agriculture.urban.ui.components.TestView;
import agriculture.urban.ui.components.TestViewIMVP.TestViewIMVPListener;

/**
 * The presenter in  Model-View-Presenter pattern is equivalent 
 * to Controller in MVC  pattern
 * 
 * @author Gwennaël Bouteloup
 *
 */
public class TestViewPresenter implements TestViewIMVPListener{
	// Model classes
	private Business_InstallationType_OnGround_DAO dao;
	// View class
	private TestView view; 
	
	public TestViewPresenter(Business_InstallationType_OnGround_DAO dao,
			TestView  view) {
		this.dao = dao;
		this.view  = view;

		view.addListener(this);
	}

	@Override
	public void buttonClick(char operation) {
		List<Business_InstallationType_OnGround> list = dao.getAll();	
		
	}

}
