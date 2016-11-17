package agriculture.urban.ui.components;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

import agriculture.urban.model.Business_InstallationType_OnGround;
import agriculture.urban.model.DAO.impl.Business_InstallationType_OnGround_DAOImpl;

@SuppressWarnings("serial")
public class TestView extends VerticalLayout implements TestViewIMVP, ClickListener, View {
	private final Logger logger = Logger.getLogger(getClass().getName());
	/* Only the presenter registers one listener... */
	private List<TestViewIMVPListener> listeners = new ArrayList<TestViewIMVPListener>();

	public TestView() {
		setSizeFull();
		setSpacing(true);

		Label label = new Label("Hello");
		label.setSizeFull();

		Button button = new Button("Click me");	
		button.setStyleName("applicationButton");
		button.setSizeFull();

		// Test log4j custom file logging
		System.out.println("############## ############## hello i'm testting log4j!");
		logger.info("Logger message: Here is some INFO");
		
		// Test database access
		try {
			Business_InstallationType_OnGround_DAOImpl business_InstallationType_OnGround_DAOImpl = new Business_InstallationType_OnGround_DAOImpl();
			logger.info("business_InstallationType_OnGround_DAOImpl : "+ business_InstallationType_OnGround_DAOImpl.toString());
			business_InstallationType_OnGround_DAOImpl.coucou();
			List<Business_InstallationType_OnGround>  list_business_InstallationType_OnGround_DAOImpl = business_InstallationType_OnGround_DAOImpl.getAll();
			
			if(list_business_InstallationType_OnGround_DAOImpl != null){
				for (Business_InstallationType_OnGround itBusiness_InstallationType_OnGroundin : 
					list_business_InstallationType_OnGround_DAOImpl){
					logger.info("Business_InstallationType_OnGround idBusiness:" + itBusiness_InstallationType_OnGroundin.getIdBusiness());
				}
			}else{
				logger.info("list_business_InstallationType_OnGround_DAOImpl is null...");
			}
			
		} catch (Exception | ExceptionInInitializerError ex) {
		    // handle any errors
			logger.error("Exception using DAO: " + ex.getMessage());
		}
		
		/*try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/urbanAgriDB", "root", "gbouteloupPass1");


		} catch (SQLException | ClassNotFoundException ex) {
			logger.error("SQLException: " + ex.getMessage());
		}*/
		
		addComponent(label);
		addComponent(button);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("Welcome! Please log in.");
	}

	@Override
	public void addListener(TestViewIMVPListener listener) {
		listeners.add(listener);
	}

	@Override
	public void buttonClick(ClickEvent event) {
		for (TestViewIMVPListener listener : listeners)
			listener.buttonClick(event.getButton().getCaption().charAt(0));
	}
}
