JAVAC=javac
JAVA=java
MODELDIR=Model/
VIEWDIR=View/
CONTROLDIR=Controller/
COMMONDIR=CommonTypes/
CLASSDIR=bin/

all : Controller Model View Common main

Common: $(COMMONDIR)DisplaySize.java $(COMMONDIR)ChangeClass.java $(COMMONDIR)ChangeType.java
	$(JAVAC) -d $(CLASSDIR) $^

Model: $(MODELDIR)Model.java $(COMMONDIR)DisplaySize.java
	$(JAVAC) -d $(CLASSDIR) $^

Controller: $(CONTROLDIR)Controller.java
	$(JAVAC) -d $(CLASSDIR) $^

View: mainView menuBar imageData repertory imageBrowser topBar browseFrame renameFrame

mainView: $(VIEWDIR)MainView.java
	$(JAVAC) -d $(CLASSDIR) $^

menuBar: $(VIEWDIR)MainMenu.java
	$(JAVAC) -d $(CLASSDIR) $^

topBar: $(VIEWDIR)TopBar.java
	$(JAVAC) -d $(CLASSDIR) $^

imageData: $(VIEWDIR)ImageDataPanel.java
	$(JAVAC) -d $(CLASSDIR) $^

repertory: $(VIEWDIR)RepertoryPanel.java
	$(JAVAC) -d $(CLASSDIR) $^

imageBrowser: $(VIEWDIR)ImageBrowserPanel.java
	$(JAVAC) -d $(CLASSDIR) $^

browseFrame: $(VIEWDIR)BrowseFrame.java
	$(JAVAC) -d $(CLASSDIR) $^

renameFrame: $(VIEWDIR)RenameFrame.java
	$(JAVAC) -d $(CLASSDIR) $^

main: $(VIEWDIR)MainView.java $(MODELDIR)Model.java $(VIEWDIR)RepertoryPanel.java $(VIEWDIR)MyWindowListener.java $(VIEWDIR)ImageDataPanel.java $(VIEWDIR)MainMenu.java $(VIEWDIR)TopBar.java
	$(JAVAC) -d $(CLASSDIR) $^

runMain:
	$(JAVA) -classpath $(CLASSDIR) $(VIEWDIR)MainView

searchBar:

clean:
	@rm -fr $(CLASSDIR)*
