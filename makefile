JC =javac
JVM=java
.SUFFIXES:.java .class
.java.class:
	$(JC) $*.java

CLASSES = \
	Main.java\
	UserScreen.java\
	TimeKepper.java\
	Train.java\
	Coach.java\
	CoveredFreight.java\
	DieselEngine.java\
	ElectricalEngine.java\
	FileReader.java\
	OpenFreight.java\
	SleepingCar.java\
	StationMaker.java\
	TrainMaker.java\
	TrainMapTextHandler.java\
	TrainStationHandler.java\
	TrainStation.java\
	TrainsTextHandler.java\
	StatusEnum.java\
	Cart.java\
	TrainMapData.java\
	TrainsData.java\
	TrainStationsData.java
MAIN = Main

default: clean classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class

run: $(MAIN).class
	$(JVM) $(MAIN) 

run-clean: clean classes run
