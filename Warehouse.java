class Warehouse {
	private int inventory;
	private int add_operations;
	private int remove_operations;
	private int bug_flag;
	private OperationThread[] operations;
	private int current_thread_idx;

	public Warehouse(int add_operations, int remove_operations, int bug_flag) {
		this.add_operations = add_operations;
		this.remove_operations = remove_operations;
		this.bug_flag = bug_flag;

		operations = new OperationThread[add_operations + remove_operations]; // operations will hold all the threads to join them after launching those threads
		current_thread_idx = 0;

		startOperations();
	}

	private void startOperations() {
		Boolean add_operation = true;

		launch_threads(add_operations, add_operation);
		launch_threads(remove_operations, !add_operation);

		join_threads();
		System.out.println("Final Inventory Size = " + inventory);
	}

	private void launch_threads(int num_operations, Boolean operation_type) {
		for (int i = 0; i < num_operations; i++) {
			OperationThread thread = new OperationThread(this, operation_type, bug_flag);
			thread.start();

			operations[current_thread_idx] = thread;
			current_thread_idx++;
		}
	}

	private void join_threads() {
		for (int i = 0; i < operations.length; i++) {
			try {
				operations[i].join();
			} catch (Exception e) {}
		}
	}

	public int getInventorySize() {
		return inventory;
	}

	public void setInventorySize(int inventory) {
		this.inventory = inventory;
	}
}