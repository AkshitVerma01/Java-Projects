package com.companyname.LinkedList;


public class SLLSet {
	private int size;
	private SLLNode head;

	public SLLSet() {

		// Initialize an empty set
		this.size = 0;
		this.head = null;
	}

	public SLLSet(int[] sortedArray) {

		// As long as it won't be an empty set or negative length
		if (sortedArray.length > 0) {

			// Make the head the first element
			SLLNode node = new SLLNode(sortedArray[0], null);
			this.head = node;

			// Make the size of the array
			this.size = sortedArray.length;

			// Cannot start at 0 because thats the head

			// Assign the next node to the current node (current node is +1 of the head
			// node since we start at 1)
			for (int i = 1; i < this.size; i++) {
				node.next = new SLLNode(sortedArray[i], null);
				node = node.next;
			}
			// Array size cannot be negative, so make it empty
		} else {
			this.size = 0;
			this.head = null;
		}
	}

	public int getSize() {

		// Basic getter
		return this.size;
	}

	public SLLSet copy() {

		// Make a list to copy the elements over from the array im trying to copy
		int[] list = new int[this.size];

		// Make a reference to the head
		SLLNode head = this.head;
		int current = 0;

		while (head != null) {
			// Insert each value in the array to the list
			list[current] = head.value;
			head = head.next;
			current++;
		}

		// Make a new set with the new array
		SLLSet copy = new SLLSet(list);
		copy.size = this.size;
		return copy;
	}

	public boolean isIn(int v) {

		// Patter: Always make a head and a while for if its not null
		SLLNode head = this.head;

		// As long as it doesn't reach the end
		while (head != null) {

			// If the head value matches the int we're looking for
			if (head.value == v) {
				return true;

				// If the next head is not an int (means its the last element)
			} else if (head.next == null) {
				break;
			}
			head = head.next;
		}

		// If not found
		return false;
	}

	public void add(int v) {
		// Make the head as normal
		SLLNode head = this.head;

		// If v is not in the list
		if (this.isIn(v) == false) {

			// If the current reference is the null (the last node)
			if (this.head == null) {

				// Add the value to the last element
				this.head = new SLLNode(v, null);

				/*
				 * If the current value is larger than the int we're trying to add (SLL is
				 * increasing order) Add v to the current element and the head to the next
				 * element Insert before the element
				 */
			} else if (this.head.value > v) {
				this.head = new SLLNode(v, this.head);

				// If v is in the list
			} else {
				while (head.next != null) {

					// Find the next value
					int x = head.next.value;

					// Insert in the middle
					// If its less then the next value but greater then the current value
					if (v < x && v > head.value) {

						// Add value after the current element
						head.next = new SLLNode(v, head.next);
					}

					// Update head
					head = head.next;
				}

				// If the head is null and v is in the list
				if (v > head.value) {
					head.next = new SLLNode(v, null);
				}
			}
			size++;
		}
	}

	public void remove(int v) {

		// Make head
		SLLNode head = this.head;

		// If it exists
		if (this.isIn(v) == true) {
			this.size--;

			// If the value we're trying to remove is the same, make current = to the next
			if (head.value == v) {
				this.head = head.next;

				// If its not equal to v
			} else {
				while (head != null) {
					if (head.next == null) {
						break;

						// If the next value is the same
					} else if (head.next.value == v) {

						// Next value is the same as the next to next value
						head.next = head.next.next;
						break;
					}
					head = head.next;
				}
			}
		}
	}

	public SLLSet union(SLLSet s) {
		// Get the head of the 2nd set
		SLLNode header = s.head;

		// As long as the head of s isn't null
		if (header != null) {
			while (header != null) {

				// Add the values of the head to this set
				this.add(header.value);
				header = header.next;
			}
		}
		return this;
	}

	public SLLSet intersection(SLLSet s) {

		// New object set
		SLLSet intersect = new SLLSet();
		SLLNode sHead = s.head;

		// As long as either one of them is not null
		if (sHead != null || this.head != null) {

			// Check that this head is not null
			while (this.head != null) {

				// Loop through the list every run and reset the head every run
				sHead = s.head;

				// Check if the 2nd set head is not null
				while (sHead != null) {

					// If there equal to check for intersection
					if (this.head.value == sHead.value) {
						intersect.add(this.head.value);
					}

					// Once found, or not found, shift head one over
					sHead = sHead.next;
				}

				// Once gone through one iteration, shift current head by one
				this.head = this.head.next;
			}
		}

		return intersect;

	}

	public SLLSet difference(SLLSet s) {

		// Made a big set with all the elements
		SLLSet differ = this.union(s);

		// Assign head
		SLLNode thisHead = this.head;

		// While current head is in the s set (cause of intersection)
		while (thisHead != null) {
			if (s.isIn(thisHead.value)) {

				// Remove the intersection value
				differ.remove(thisHead.value);
			}

			// Shift head over to see if there's any more intersections
			thisHead = thisHead.next;
		}

		// This head node is the s head
		thisHead = s.head;

		// Same thing as above
		while (thisHead != null) {
			if (this.isIn(thisHead.value)) {
				differ.remove(thisHead.value);
			}
			thisHead = thisHead.next;
		}
		return differ;
	}

	public static SLLSet union(SLLSet[] sArray) {
		SLLSet ss = new SLLSet();

		// Loop through each, making a union of all
		for (int i = 0; i < sArray.length; i++) {
			ss = ss.union(sArray[i]);
		}

		return ss;
	}

	@Override
	public String toString() {
		SLLNode node = this.head;

		String s = "";

		while (node != null) {
			s += node.value;
			node = node.next;
			if (node != null) {
				s += ", ";
			}
		}
		s += "";
		return s;
	}
}