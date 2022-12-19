# Warehouse-Concrrency-Simulation

Program Specification:
Imagine a warehouse and some number of items in its inventory. We care only about the size of the inventory, not the nature of the items. In particular, we care about maintaining the size of the inventory correctly despite concurrent operations on it. The operations specifically are (1) adding a single item to the inventory, and (2) removing a single item from the inventory.

Your task is to implement a multithreaded Java program that supports concurrent addition and removal of items. Assume that the initial inventory size is 0.
