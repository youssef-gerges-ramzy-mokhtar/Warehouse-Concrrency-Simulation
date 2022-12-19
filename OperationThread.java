class OperationThread extends Thread {
	Warehouse warehouse;
	Boolean add_operation;
	int bug_flag;

	public OperationThread(Warehouse warehouse, Boolean add_operation, int bug_flag) {
		this.warehouse = warehouse;
		this.add_operation = add_operation;
		this.bug_flag = bug_flag;
	}

	public void run() {
		if (bug_flag == 0) correct_run();
		else bug_run();
	}

	private void correct_run() {
		synchronized(System.out) {
			int current_size = warehouse.getInventorySize();
			update_inventory(current_size);
			print_msg();
		}
	}

	private void bug_run() {
		int current_size = warehouse.getInventorySize();
		
		try {
			Thread.sleep(5);
		} catch (Exception e) {}

		update_inventory(current_size);

		if (add_operation) System.out.println("Added. Inventory Size = " + warehouse.getInventorySize());
		else System.out.println("Removed. Inventory Size = " + warehouse.getInventorySize());
	}

	private void update_inventory(int current_size) {
		if (add_operation) current_size++;
		else current_size--;

		warehouse.setInventorySize(current_size);
	}

	private void print_msg() {
		if (add_operation) System.out.print("Added. ");
		else System.out.print("Removed. ");

		System.out.println("Inventory Size = " + warehouse.getInventorySize());
	}
}