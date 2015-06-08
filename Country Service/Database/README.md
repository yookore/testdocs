###Database is in MySQL and exported to .sql file. Original file found on the internet is a zipped file with a .csv file inside.

A mini java program was written to read it and dump it’s data into MySQL database which is used by the country service.

The java program also removed the special ASCII chars not supported by MySQL to put plain text for names of Cities, Region/Provinces and Countries.

The MySql database named CountryService consists of 3 tables namely City, Region and Country. each link by the auto_increment primary key. City is linked with Region by rig_id(Region’s PK) and Region is linked with Country by con_id(Country’s PK).

###Java sample code

String fileName="/all_cities_in_the_world.csv";
String q = null;

//Create object of FileReader
FileReader inputFile = new FileReader(fileName);
	          
//Instantiate the BufferedReader Class
BufferedReader bufferReader = new BufferedReader(inputFile);

//Variable to hold the one line data
String line;
int count = 0;
	          
// Read file line by line and print on the console
while ((line = bufferReader.readLine()) != null)   {
	count++;
   if(count>=219084){ //This is the second run, java got full and broke at 219083 records
        String[] row = line.split(",");
	
	/*The replaceALL removes the ASCII charactors and the escape of (‘)
         double the them to be able to be inserted as part of the data rather
	 than being read*/            
	System.out.println(count + " " + row[0].replaceAll("[^\\x20-\\x7e]", 	"").replace("\'","\'\'") + ", "+ row[1].replaceAll("[^\\x20-\\x7e]", 	"").replace("\'","\'\'") + ", "+ row[2].replaceAll("[^\\x20-\\x7e]", 	"").replace("\'","\'\'") );
				
	Statement stmt = con.createStatement();
	//ResultSet rs;219084

	q = "insert into country values ('"+row[0].replaceAll("[^\\x20-\\x7e]", 	"").replace("\'","\'\'")+"','"+row[1].replaceAll("[^\\x20-\\x7e]", 	"").replace("\'","\'\'")+"','"+row[2].replaceAll("[^\\x20-\\x7e]", 	"").replace("\'","\'\'")+"')";

	if(stmt.execute(q)){
	    System.out.println(“Row inserted");
	}
    }
}

After all data was inserted into MySql, it was then formatted using MySql (Insert Select from table to table) into 3 table as explained earlier.

Lastly another java program was developed to match them with primary keys, the update query was not responding so new tables were created then used insert select again including primary keys to link them.