JAVAC=javac
JAVA=java
MODELDIR=Model/
VIEWDIR=View/
CONTROLDIR=Controller/
COMMONDIR=CommonTypes/
CLASSDIR=bin/

all : View Model Controller demo

Model: $(MODELDIR)Model.java $(COMMONDIR)DisplaySize.java
	$(JAVAC) $(CLASSDIR) $^

Controller: $(CONTROLDIR)Controller.java
	$(JAVAC) $(CLASSDIR) $^

View: menuBar imageData repertory imageBrowser searchBar

menuBar: $(VIEWDIR)MainMenu.java
	$(JAVAC) -d $(CLASSDIR) $^

imageData: $(VIEWDIR)ImageDataPanel.java
	$(JAVAC) -d $(CLASSDIR) $^

repertory: $(VIEWDIR)RepertoryPanel.java
	$(JAVAC) -d $(CLASSDIR) $^

imageBrowser: $(VIEWDIR)ImageBrowserPanel.java
	$(JAVAC) -d $(CLASSDIR) $^

demo: Demo.java $(VIEWDIR)RepertoryPanel.java $(VIEWDIR)MyWindowListener.java $(VIEWDIR)ImageDataPanel.java $(VIEWDIR)MainMenu.java
	$(JAVAC) -d $(CLASSDIR) $^

runDemo:
	$(JAVA) -classpath $(CLASSDIR) Demo

searchBar:

clean:
	@rm -f *.class $(VIEWDIR)*.class $(CONTROLDIR)*.class $(COMMONDIR)*.class $(MODELDIR)*.class
