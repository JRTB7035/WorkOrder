





public class GUI {
	
	DB woDB = new DB();
	WorkOrder currentWO = null;
	public GUI(DB woDB) {
		// TODO Auto-generated constructor stub
	}


	public String getWorkDescription() {
		return "";
	};
	
	
	// This method will display a workOrder and allow a user to finalize it
	// The user must be able to provide the work order number
	public void finalize() {
		
		int woNum = promptForWO_Number();
		if (woNum == 0) return;  // user chose to abort
			
		WorkOrder currentWO = woDB.getWO(woNum);
		currentWO.setFinal();
		woDB.saveWO(currentWO);
		
	}
	
	public int getWO_Num() {
		return promptForWO_Number();
	}

/*
 *  JR to write this first.  This method will prompt the user to choose one of the following:
 *  
 *  return a string that matches one of the expected results shown in WOManager
 *  
 */
	public String getMenuSelection() {
		String selection = "create";
	
		return selection;
			
				
	}

	// JR to write this code second
	public String getTenantName() {
		String tName = "No name yet";	
		
		return tName;
	}


// This method will display the various fields in a work order on the user's screen
	public void showWO(WorkOrder currentWO) {
		String tName = currentWO.getTenantName();
		int woNum = currentWO.getSerialNumber();
		String workDescription = currentWO.getDescription();
		
		
	}


	public WOFields getDisplayFields() {
		// we need code that will read all of the fields and then send it off to a constructor
		String tName = null;
		String workDescription = null;
		String vendor = null;
		Double maxPrice = null;
		
		WOFields fields = new WOFields(tName, workDescription, vendor, maxPrice);
		return fields;
		
	}


	public int getWO_Num1() {
		// TODO Auto-generated method stub
		return 0;
	}


	public boolean checkForUserUpdate() {
		// Add code that checks the "update" box on the form and returns true iff checked
		return false;
	}


	//****************************************************************
	// These are the private functions:
	
	
	// This method will prompt the user to input a valid work order,
	// and will return that woNumber or 0 if user wishes to abort
	private int promptForWO_Number() {
		int woNum = 0;
		
		String promptTextOut = "Enter a Valid Work ORderID Please:";
//		this.currentWO;		
		
		return woNum;
	}

	

}
