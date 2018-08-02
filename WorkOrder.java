
public class WorkOrder {
	private  int serialNum = 0;
	private String description;
	private String tName;
	private boolean blocked;
	
	
// Constructor requires only tenantName and workDescription; serial number, and other info will be automatically assigned and added
	public WorkOrder(String tenantName, String workDescription){
		// TODO Auto-generated constructor stub
		this.tName = tenantName;
		this.description = workDescription;
		this.serialNum++;
		blocked = false;	// This flag is set when a Work Order is complete and can no longer be changed.
	}

	public void setDescription(String newDescription){
		this.setDescription(newDescription);
		
	}

	public void setName(String newName) {
		this.setName(newName);
	}

	public String getTenantName() {
		// TODO Auto-generated method stub
		return this.tName;
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return this.description;
	}

	public int getSerialNumber() {
		// TODO Auto-generated method stub
		return this.serialNum;
	}

	public void setFinal() {
		this.blocked = true;
		
	}

//	public void updateWO(Object wOFields) {
//		// TODO Auto-generated method stub
//		
//	}

	public void updateWO(WOFields fields) {
		// TODO Auto-generated method stub
		
	}

}
