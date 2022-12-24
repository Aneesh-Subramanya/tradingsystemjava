# MTH9815 Final Project - A Trading System
## Generating input data files
**Path -** tradingsystemjava\test\inputFiles\generatefiles.ipynb or tradingsystemjava\test\inputFiles\generatefiles.py  
You can run either generateFiles.ipynb (IPython Notebook) or generateFiles.py (Python 3.x script). You can use the "num" variable (line 6) to control the number of MarketData and Price updates.

## Running the project
**Main class path -** src/main/java/Main.java  
You can simply run the **main** method in the above Main class. I recommend **JDK17** or higher although it should work on any modern JVM.

## Output
**Console outputs -** The console prints outputs from **GUIService, ExecutionService, and StreamingService.** Each service output is throttled to print one line every 300 milliseconds.  
**File outputs**
- Live logging 
  - **Path -** *tradingsystemjava\test\live,* **Files -** *gui.txt, executionslive.txt, streaming.txt*
  - The **GUIService, ExecutionService, and StreamingService** push their console outputs into these files as well for record keeping.
- Historical data service logging -
  - **Path -** *tradingsystemjava\test\historical,* **Files -** *allinquiries.txt, executions.txt, positions.txt, risk.txt, and streaming.txt*
  - The historical data services write outputs to the files above.

## Structure of the project
The project has been organized into packages for readability and maintainability. The project is organized into packages as below. 
- **src/main/constants -** Contains constants used throught the project.
- **src/main/enums -** Contains all the Enum classes used in the project.
- **src/main/java/services -** The main services that make up the trading system.
- **src/main/java/listeners -** The service listeners that connect the different services.
- **src/main/java/connectors -** The connectors that allow reading from external sources via sockets and publishing to external receivers via sockets.
- **src/main/java/histservices -** Historical data services.
- **src/main/java/histlisteners -** Historical service listeners.
- **src/main/java/histconnectors -** Historical service connectors.
- **src/main/java/publishers -** External publishers that read data from files and publish to the trading system through sockets.
- **src/main/java/subscribers -** External subscribers that receive data from the trading system through sockets and write to files.
- **src/main/java/products -** Contains different tradable product classes. For this project, it contains only the Bond class but it can be used to extend support to other tradable securities.
- **src/main/java/entities -** Contains classes that model conrete real-world objects, such as OrderBook, Order, and Trade.

## Bond CUSIP information
I have taken the CUSIPS for 2Y, 3Y, 5Y, 7Y, 10Y, 20Y, and 30Y tenors from the latest Treasury auctions as per [https://www.treasurydirect.gov/auctions/upcoming/](this website).  
The system mentions PV01 data for each UST in dollars. PV01 values represent the price change per $1000 face value. PV01 values have been taken from [https://www.cmegroup.com/education/courses/introduction-to-treasuries/how-can-you-measure-risk-in-treasuries.html](this website).  

