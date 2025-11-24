CXX=g++
CXXFLAGS=-std=c++17 -O2 -Wall

# Default to LOCAL unless explicitly disabled
ifndef SUBMIT
    CXXFLAGS += -DLOCAL_TESTING
endif

main: main.o
	$(CXX) main.o $(FRMWRKS) -o main

main.o: main.cpp
	$(CXX) $(CXXFLAGS) -c main.cpp

clean:
	rm *.o main