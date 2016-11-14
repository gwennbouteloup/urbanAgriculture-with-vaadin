package agriculture.urban.ui;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.Navigator.ComponentContainerViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import agriculture.urban.ui.components.TestView;

@SuppressWarnings("serial")
@Theme("evidence")
@Widgetset("war.MyAppWidgetset")
public class UrbanAgricultureUI extends UI {
	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = UrbanAgricultureUI.class)
	public static class Servlet extends VaadinServlet {
	
	}
	public Navigator navigator;

	public static final String REGVIEW = "register";
	public static final String MAINMANAGERVIEW = "mainManager";

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		layout.setSpacing(true);
		setContent(layout);
		ComponentContainerViewDisplay viewDisplay = new ComponentContainerViewDisplay(layout);
		navigator = new Navigator(UI.getCurrent(), viewDisplay);
		navigator.addView("", new TestView());
	}
}

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
/*@SuppressWarnings("serial")
@Theme("valo")
@Title("Valo Theme Test")
@StyleSheet("valo-theme-ui.css")
@PreserveOnRefresh
public class UrbanAgricultureUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
	}
	private boolean _testMode = false;
    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = ValoThemeUI.class)
    
    /**public static class Servlet extends VaadinServlet {

        @Override
        protected void servletInitialized() throws ServletException {
            super.servletInitialized();
            getService().addSessionInitListener(
                    new ValoThemeSessionInitListener());
        }
    }

    private static LinkedHashMap<String, String> themeVariants = new LinkedHashMap<String, String>();
    static {
        themeVariants.put(ValoTheme.THEME_NAME, "Valo");
        themeVariants.put("midsummer-night", "Midsummer Night");
        themeVariants.put("tests-valo-blueprint", "Blueprint");
        themeVariants.put("tests-valo-dark", "Dark");
        themeVariants.put("tests-valo-facebook", "Facebook");
        themeVariants.put("tests-valo-flatdark", "Flat dark");
        themeVariants.put("tests-valo-flat", "Flat");
        themeVariants.put("tests-valo-light", "Light");
        themeVariants.put("tests-valo-metro", "Metro");
        themeVariants.put("tests-valo-reindeer", "Migrate Reindeer");
    }
    //private TestIcon testIcon = new TestIcon(100);

    private ValoMenuLayout _root = null;
    private ComponentContainer _viewDisplay = null;
    CssLayout _menu = new CssLayout();
    CssLayout _menuItemsLayout = new CssLayout();
    {
        _menu.setId("testMenu");
    }
    private Navigator _navigator = null;
    private LinkedHashMap<String, String> _menuItems = new LinkedHashMap<String, String>();

    @Override
    protected void init(VaadinRequest request) {
    	_root = new ValoMenuLayout();
    	_viewDisplay = _root.getContentContainer();
    	
        if (request.getParameter("test") != null) {
            _testMode = true;

            if (browserCantRenderFontsConsistently()) {
                getPage().getStyles().add(
                        ".v-app.v-app.v-app {font-family: Sans-Serif;}");
            }
        }

        if (getPage().getWebBrowser().isIE()
                && getPage().getWebBrowser().getBrowserMajorVersion() == 9) {
            _menu.setWidth("320px");
        }

        if (!_testMode) {
            Responsive.makeResponsive(this);
        }

        getPage().setTitle("Valo Theme Title");
        setContent(_root);
        _root.setWidth("100%");

        _root.addMenu(buildMenu());
        addStyleName(ValoTheme.UI_WITH_MENU);

        _navigator = new Navigator(this, _viewDisplay);

        _navigator.addView("welcome", (View)null);
        _navigator.addView("urban-agriculture-overview", (View)null);
        _navigator.addView("project_creation_approach", (View)null);
        //_navigator.addView("labels", Labels.class);

        String f = Page.getCurrent().getUriFragment();
        if (f == null || f.equals("")) {
            _navigator.navigateTo("welcome");
        }

        //_navigator.setErrorView(CommonParts.class);

        _navigator.addViewChangeListener(new ViewChangeListener() {

            @Override
            public boolean beforeViewChange(ViewChangeEvent event) {
                return true;
            }

            @Override
            public void afterViewChange(ViewChangeEvent event) {
                for (Iterator<Component> it = _menuItemsLayout.iterator(); it
                        .hasNext();) {
                    it.next().removeStyleName("selected");
                }
                for (Entry<String, String> item : _menuItems.entrySet()) {
                    if (event.getViewName().equals(item.getKey())) {
                        for (Iterator<Component> it = _menuItemsLayout
                                .iterator(); it.hasNext();) {
                            Component c = it.next();
                            if (c.getCaption() != null
                                    && c.getCaption().startsWith(
                                            item.getValue())) {
                                c.addStyleName("selected");
                                break;
                            }
                        }
                        break;
                    }
                }
                _menu.removeStyleName("valo-menu-visible");
            }
        });

    }

    private boolean browserCantRenderFontsConsistently() {
        // PhantomJS renders font correctly about 50% of the time, so
        // disable it to have consistent screenshots
        // https://github.com/ariya/phantomjs/issues/10592

        // IE8 also has randomness in its font rendering...

        return getPage().getWebBrowser().getBrowserApplication()
                .contains("PhantomJS")
                || (getPage().getWebBrowser().isIE() && getPage()
                        .getWebBrowser().getBrowserMajorVersion() <= 9);
    }

    static boolean is_testMode() {
        return ((ValoThemeUI) getCurrent())._testMode;
    }

    Component buildTestMenu() {
        CssLayout menu = new CssLayout();
        _menu.addStyleName(ValoTheme.MENU_PART_LARGE_ICONS);

        Label logo = new Label("Va");
        logo.setSizeUndefined();
        logo.setPrimaryStyleName(ValoTheme.MENU_LOGO);
        _menu.addComponent(logo);

        Button b = new Button(
                "Reference <span class=\"valo-menu-badge\">3</span>");
        b.setIcon(FontAwesome.TH_LIST);
        b.setPrimaryStyleName(ValoTheme.MENU_ITEM);
        b.addStyleName("selected");
        b.setHtmlContentAllowed(true);
        _menu.addComponent(b);

        b = new Button("API");
        b.setIcon(FontAwesome.BOOK);
        b.setPrimaryStyleName(ValoTheme.MENU_ITEM);
        _menu.addComponent(b);

        b = new Button("Examples <span class=\"valo-menu-badge\">12</span>");
        b.setIcon(FontAwesome.TABLE);
        b.setPrimaryStyleName(ValoTheme.MENU_ITEM);
        b.setHtmlContentAllowed(true);
        _menu.addComponent(b);

        return menu;
    }

    CssLayout buildMenu() {
        // Add items
        menuItems.put("common", "Common UI Elements");
        menuItems.put("labels", "Labels");
        menuItems.put("buttons-and-links", "Buttons & Links");
        menuItems.put("textfields", "Text Fields");
        menuItems.put("datefields", "Date Fields");
        menuItems.put("comboboxes", "Combo Boxes");
        menuItems.put("selects", "Selects");
        menuItems.put("checkboxes", "Check Boxes & Option Groups");
        menuItems.put("sliders", "Sliders & Progress Bars");
        menuItems.put("colorpickers", "Color Pickers");
        menuItems.put("menubars", "Menu Bars");
        menuItems.put("trees", "Trees");
        menuItems.put("tables", "Tables & Grids");
        menuItems.put("dragging", "Drag and Drop");
        menuItems.put("panels", "Panels");
        menuItems.put("splitpanels", "Split Panels");
        menuItems.put("tabs", "Tabs");
        menuItems.put("accordions", "Accordions");
        menuItems.put("popupviews", "Popup Views");
        if (getPage().getBrowserWindowWidth() >= 768) {
            menuItems.put("calendar", "Calendar");
        }
        menuItems.put("forms", "Forms");

        HorizontalLayout top = new HorizontalLayout();
        top.setWidth("100%");
        top.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
        top.addStyleName(ValoTheme.MENU_TITLE);
        _menu.addComponent(top);
        _menu.addComponent(createThemeSelect());

        Button showMenu = new Button("Menu", new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                if (_menu.getStyleName().contains("valo-menu-visible")) {
                    _menu.removeStyleName("valo-menu-visible");
                } else {
                    _menu.addStyleName("valo-menu-visible");
                }
            }
        });
        show_menu.addStyleName(ValoTheme.BUTTON_PRIMARY);
        show_menu.addStyleName(ValoTheme.BUTTON_SMALL);
        show_menu.addStyleName("valo-menu-toggle");
        show_menu.setIcon(FontAwesome.LIST);
        _menu.addComponent(showMenu);

        Label title = new Label("<h3>Vaadin <strong>Valo Theme</strong></h3>",
                ContentMode.HTML);
        title.setSizeUndefined();
        top.addComponent(title);
        top.setExpandRatio(title, 1);

        MenuBar settings = new MenuBar();
        settings.addStyleName("user-menu");
        StringGenerator sg = new StringGenerator();
        MenuItem settingsItem = settings.addItem(sg.nextString(true)
                + " " + sg.nextString(true) + sg.nextString(false),
                new ClassResource("profile-pic-300px.jpg"),
                null);
        settingsItem.addItem("Edit Profile", null);
        settingsItem.addItem("Preferences", null);
        settingsItem.addSeparator();
        settingsItem.addItem("Sign Out", null);
        _menu.addComponent(settings);

        _menuItemsLayout.setPrimaryStyleName("valo-menuitems");
        _menu.addComponent(menuItemsLayout);

        Label label = null;
        int count = -1;
        for (final Entry<String, String> item : menuItems.entrySet()) {
            if (item.getKey().equals("labels")) {
                label = new Label("Components", ContentMode.HTML);
                label.setPrimaryStyleName(ValoTheme.MENU_SUBTITLE);
                label.addStyleName(ValoTheme.LABEL_H4);
                label.setSizeUndefined();
                _menuItemsLayout.addComponent(label);
            }
            if (item.getKey().equals("panels")) {
                label.setValue(label.getValue()
                        + " <span class=\"valo-menu-badge\">" + count
                        + "</span>");
                count = 0;
                label = new Label("Containers", ContentMode.HTML);
                label.setPrimaryStyleName(ValoTheme.MENU_SUBTITLE);
                label.addStyleName(ValoTheme.LABEL_H4);
                label.setSizeUndefined();
                _menuItemsLayout.addComponent(label);
            }
            if (item.getKey().equals("calendar")) {
                label.setValue(label.getValue()
                        + " <span class=\"valo-menu-badge\">" + count
                        + "</span>");
                count = 0;
                label = new Label("Other", ContentMode.HTML);
                label.setPrimaryStyleName(ValoTheme.MENU_SUBTITLE);
                label.addStyleName(ValoTheme.LABEL_H4);
                label.setSizeUndefined();
                _menuItemsLayout.addComponent(label);
            }
            Button b = new Button(item.getValue(), new ClickListener() {
                @Override
                public void buttonClick(ClickEvent event) {
                    _navigator.navigateTo(item.getKey());
                }
            });
            if (count == 2) {
                b.setCaption(b.getCaption()
                        + " <span class=\"valo-menu-badge\">123</span>");
            }
            b.setHtmlContentAllowed(true);
            b.setPrimaryStyleName(ValoTheme.MENU_ITEM);
            b.setIcon(testIcon.get());
            _menuItemsLayout.addComponent(b);
            count++;
        }
        label.setValue(label.getValue() + " <span class=\"valo-menu-badge\">"
                + count + "</span>");

        return menu;
    }

    private Component createThemeSelect() {
        final NativeSelect ns = new NativeSelect();
        ns.setNullSelectionAllowed(false);
        ns.setId("themeSelect");
        ns.addContainerProperty("caption", String.class, "");
        ns.setItemCaptionPropertyId("caption");
        for (String identifier : themeVariants.keySet()) {
            ns.addItem(identifier).getItemProperty("caption")
                    .setValue(themeVariants.get(identifier));
        }

        ns.setValue(ValoTheme.THEME_NAME);
        ns.addValueChangeListener(new ValueChangeListener() {
            @Override
            public void valueChange(ValueChangeEvent event) {
                setTheme((String) ns.getValue());
            }
        });
        return ns;
    }

    static Handler actionHandler = new Handler() {
        private final Action ACTION_ONE = new Action("Action One");
        private final Action ACTION_TWO = new Action("Action Two");
        private final Action ACTION_THREE = new Action("Action Three");
        private final Action[] ACTIONS = new Action[] { ACTION_ONE, ACTION_TWO,
                ACTION_THREE };

        @Override
        public void handleAction(Action action, Object sender, Object target) {
            Notification.show(action.getCaption());
        }

        @Override
        public Action[] getActions(Object target, Object sender) {
            return ACTIONS;
        }
    };

    static Handler getActionHandler() {
        return actionHandler;
    }

    static final String CAPTION_PROPERTY = "caption";
    static final String DESCRIPTION_PROPERTY = "description";
    static final String ICON_PROPERTY = "icon";
    static final String INDEX_PROPERTY = "index";

    @SuppressWarnings("unchecked")
    static IndexedContainer generateContainer(final int size,
                                       final boolean hierarchical) {
        TestIcon testIcon = new TestIcon(90);
        IndexedContainer container = hierarchical ? new HierarchicalContainer()
                : new IndexedContainer();
        StringGenerator sg = new StringGenerator();
        container.addContainerProperty(CAPTION_PROPERTY, String.class, null);
        container.addContainerProperty(ICON_PROPERTY, Resource.class, null);
        container.addContainerProperty(INDEX_PROPERTY, Integer.class, null);
        container
                .addContainerProperty(DESCRIPTION_PROPERTY, String.class, null);
        for (int i = 1; i < size + 1; i++) {
            Item item = container.addItem(i);
            item.getItemProperty(CAPTION_PROPERTY).setValue(
                    sg.nextString(true) + " " + sg.nextString(false));
            item.getItemProperty(INDEX_PROPERTY).setValue(i);
            item.getItemProperty(DESCRIPTION_PROPERTY).setValue(
                    sg.nextString(true) + " " + sg.nextString(false) + " "
                            + sg.nextString(false));
            item.getItemProperty(ICON_PROPERTY).setValue(testIcon.get());
        }
        container.getItem(container.getIdByIndex(0))
                .getItemProperty(ICON_PROPERTY).setValue(testIcon.get());

        if (hierarchical) {
            for (int i = 1; i < size + 1; i++) {
                for (int j = 1; j < 5; j++) {
                    String id = i + " -> " + j;
                    Item child = container.addItem(id);
                    child.getItemProperty(CAPTION_PROPERTY).setValue(
                            sg.nextString(true) + " " + sg.nextString(false));
                    child.getItemProperty(ICON_PROPERTY).setValue(
                            testIcon.get());
                    ((Hierarchical) container).setParent(id, i);

                    for (int k = 1; k < 6; k++) {
                        String id2 = id + " -> " + k;
                        child = container.addItem(id2);
                        child.getItemProperty(CAPTION_PROPERTY).setValue(
                                sg.nextString(true) + " "
                                        + sg.nextString(false));
                        child.getItemProperty(ICON_PROPERTY).setValue(
                                testIcon.get());
                        ((Hierarchical) container).setParent(id2, id);

                        for (int l = 1; l < 5; l++) {
                            String id3 = id2 + " -> " + l;
                            child = container.addItem(id3);
                            child.getItemProperty(CAPTION_PROPERTY).setValue(
                                    sg.nextString(true) + " "
                                            + sg.nextString(false));
                            child.getItemProperty(ICON_PROPERTY).setValue(
                                    testIcon.get());
                            ((Hierarchical) container).setParent(id3, id2);
                        }
                    }
                }
            }
        }
        return container;
    }
}*/
