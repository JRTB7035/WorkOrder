import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;


public class WorkOrderManager extends JFrame {
	boolean waitingForUserInput = true;			
	public static DB woDB = new DB(); // create dataBase object
	public static GUI guiDisplay = new GUI(woDB);
	Action createAction, reviseAction, finalizeAction, closedWOAction, openWOAction, printAction, exitAction;
	
	
	//  Added by JR 7-29-18:
	public static JMenuBar menuBar = new JMenuBar();
	public static JMenu menuFile = new JMenu("Menu");
	
	
	public static void main(String[] args) {
		
		WorkOrderManager wom = new WorkOrderManager(); // Added by JR launches wom object
		
		while (true) {
			
		//String selection = guiDisplay.getMenuSelection();
	
			String menuChoice = wom.getSelection();
			
			System.out.println("User choose " + menuChoice + " in main menu");
			
			switch (menuChoice){
				case "create": 
					createWorkOrder();
					break;
				case "revise":
					reviseWO(0);
					break;
				case "print":
					printWO();
					break;
				case "finalize":
					finalizeWO();
					break;
				case "show open":	// This will list all open WO's -- we may get fancy and allow date, vendor, tenant, etc. constraints
					showOpenWOs();
					break;
				case "show closed":
					showClosedWOs();
					break;
			}
		}
	}


	// By JR: 07.30.18
	public WorkOrderManager(){

		super("EJM Work Orders");  // header

		setLayout(new GridBagLayout()); // Set the wom object layout to GridBagLayout. 
		
		// sets the frame size and defines wom layout 

		GridBagConstraints constraint = new GridBagConstraints();
		constraint.insets = new Insets(50, 50, 50, 50); // frame size
		constraint.gridx = 0; // set X axis value to 0
		constraint.gridwidth = 1; // set Width to 2
		constraint.gridy = 1; // set Y axis value to 1
		

		 
		// Menu bar with selections for users  
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menuFile = new JMenu("Menu");
		JMenuItem menuItemCreate = new JMenuItem("Create");
		JMenuItem menuItemRevise = new JMenuItem("Revise");
		JMenuItem menuItemFinalize = new JMenuItem("Finalize");
		JMenuItem menuItemClosedWO = new JMenuItem("Closed WO's");
		JMenuItem menuItemOpenWO = new JMenuItem("Open WO's");
		JMenuItem menuItemPrint = new JMenuItem("Print");
		JMenuItem menuItemExit = new JMenuItem("Exit");
		
		menuFile.add(menuItemCreate);
		menuItemCreate.setActionCommand(getSelection());
		menuFile.add(menuItemRevise);
		menuItemCreate.setActionCommand(getSelection());
		menuFile.add(menuItemFinalize);
		menuItemCreate.setActionCommand(getSelection());
		menuFile.add(menuItemClosedWO);	
		menuItemCreate.setActionCommand(getSelection());
		menuFile.add(menuItemOpenWO);
		menuItemCreate.setActionCommand(getSelection());
		menuFile.add(menuItemPrint);
		menuItemCreate.setActionCommand(getSelection());
		menuFile.add(menuItemExit);
		menuItemCreate.setActionCommand(Exit(0));
		

		menuBar.add(menuFile); 
		
		setJMenuBar(menuBar);

		
		pack(); // auto adjust frame to screen 
		setLocationRelativeTo(null); // default frame position 
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // if user closes frame code will not run		
		setVisible(true); // make wom object visible 
	}
	
	
	private String Exit(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	
	


	private String getSelection() {
		String selection = null;
		while (waitingForUserInput)
		{
			
		
			
			
		}
		return selection;
						
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getActionCommand().equals(createAction))
		{
		System.out.println("create");
		}
		if(ae.getActionCommand().equals(reviseAction))
		{
		System.out.println("revise");
		}
		if(ae.getActionCommand().equals(finalizeAction))
		{
		System.out.println("finalize");
		}
		if(ae.getActionCommand().equals(closedWOAction))
		{
		System.out.println("Closed WO's");
		}
		if(ae.getActionCommand().equals(openWOAction))
		{
		System.out.println("Open WO's");
		}
		if(ae.getActionCommand().equals(printAction))
		{
		System.out.println("print");
		}
		if(ae.getActionCommand().equals(exitAction))
		{
		System.out.println("Exit");
		}
	}
	
	
		
	
	
	
	
 

	// ************************************************************************************************
	//*************************************************************************************************
	
	private static void createWorkOrder() {
		String tName = guiDisplay.getTenantName();
		System.out.println("Tenant name is " + tName);
		String workDescription = guiDisplay.getWorkDescription();
		WorkOrder newWO = new WorkOrder(tName, workDescription);
		
		woDB.saveWO(newWO);
		int woNum = newWO.getSerialNumber();
		// We should go straight to revise WO 
		reviseWO(woNum);
	}

	private static void reviseWO(int woNum) {
		// if woNum is 0, the WO that needs to be revised has not yet been identified,
		// but this code can also be reached from createWO(), in which case the corresponding woNum will be passed
		if(woNum == 0) {
			woNum = guiDisplay.getWO_Num();
			if (woNum == 0) return;  // will return 0 if user 
		}
		
		WorkOrder currentWO = woDB.getWO(woNum);
		guiDisplay.showWO(currentWO);
		
		boolean waitingForUserUpdate = true;		
		while (waitingForUserUpdate) {//
			waitingForUserUpdate = guiDisplay.checkForUserUpdate();
		}
		
		WOFields fields = guiDisplay.getDisplayFields();
		currentWO.updateWO(fields);
	}
	
	private static void finalizeWO() {
		guiDisplay.finalize();
		// TODO Auto-generated method stub
	}


	private static void printWO() {
		// TODO Auto-generated method stub
		
	}
	
	private static void showOpenWOs() {
		// TODO Auto-generated method stub
		
	}

	private static void showClosedWOs() {
		// TODO Auto-generated method stub
		
	}


}
