class InventoryMain {
	public static void main(String[] args) {
		try {
			int add_operations = Integer.parseInt(args[0]);
			int remove_operations = Integer.parseInt(args[1]);
			int bug_flag = Integer.parseInt(args[2]);
			
			Warehouse warehouse = new Warehouse(add_operations, remove_operations, bug_flag);
		} catch (Exception e) {
			System.out.println("Please Supply Correct Arguments via the Command Line.");
		}
	}
}