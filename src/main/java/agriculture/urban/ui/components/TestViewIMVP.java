package agriculture.urban.ui.components;

/**
 * Generic interface for using Model-View-Presenter Pattern
 * 
 * @author Gwennaël Bouteloup
 */
public interface TestViewIMVP {
    public interface TestViewIMVPListener {
        void buttonClick(char operation);
    }
    
    public void addListener(TestViewIMVPListener listener);
}
