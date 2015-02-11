JAVAC=javac
JAVA=java
MODELDIR=Model/
VIEWDIR=View/
CONTROLDIR=Controller/
COMMONDIR=CommonTypes/

all : View Model Controller

Model: $(MODELDIR)Model.java $(COMMONDIR)DisplaySize.java
	$(JAVAC) $^

Controller: $(CONTROLDIR)Controller.java
	$(JAVAC) $^

View: menuBar imageData repertory imageBrowser searchBar

menuBar: $(VIEWDIR)MainMenu.java
	$(JAVAC) $^

imageData: 

repertory: $(VIEWDIR)RepertoryPanel.java
	$(JAVAC) $^

imageBrowser:

searchBar:

clean:
	rm -f *.class $(VIEWDIR)*.class $(CONTROLDIR)*.class $(COMMONDIR)*.class $(MODELDIR)*.class
