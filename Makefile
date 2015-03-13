JAVAC=javac
JAVA=java
MODELDIR=Model/
VIEWDIR=View/
CONTROLDIR=Controller/
COMMONDIR=CommonTypes/
CLASSDIR=bin/
SQLITEJAR=sqlite-jdbc-3.8.7.jar
NAME=DatImageViewer

all : Controller Model View Common $(NAME)

$(NAME): $(NAME).java
	$(JAVAC) -d $(CLASSDIR) $^

Common: $(COMMONDIR)DisplaySize.java $(COMMONDIR)ChangeClass.java $(COMMONDIR)ChangeType.java
	$(JAVAC) -d $(CLASSDIR) $^

Model: $(MODELDIR)Model.java $(MODELDIR)DatabaseHandler.java
	$(JAVAC) -d $(CLASSDIR) $^

Controller: $(CONTROLDIR)Controller.java
	$(JAVAC) -d $(CLASSDIR) $^

View: $(VIEWDIR)MainView.java $(VIEWDIR)MainMenu.java $(VIEWDIR)ImageDataPanel.java $(VIEWDIR)RepertoryPanel.java $(VIEWDIR)ImageBrowserPanel.java $(VIEWDIR)ImagePanel.java $(VIEWDIR)TopBar.java $(VIEWDIR)MyWindowListener.java $(VIEWDIR)Thumbnail.java
	$(JAVAC) -d $(CLASSDIR) $^

run:
	$(JAVA) -classpath $(SQLITEJAR):$(CLASSDIR):. $(NAME)

clean:
	@rm -fr $(CLASSDIR)*
