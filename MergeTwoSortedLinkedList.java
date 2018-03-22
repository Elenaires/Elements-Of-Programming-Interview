public ListNode MergeTwoSortedLinkedList(ListNode L1, ListNode L2)
{
	ListNode newHead;
	ListNode current;
	ListNode secondary;
	ListNode next;

	if(L1.head.value > L2.head.value)
	{
		newHead = L1.head;
		secondary = L2.head;
		current = newHead;
	}
	else
	{
		newHead = L2.head;
		secondary = L1.head;
		current = newHead;
	}

	next = current.next;
	
	ListNode temp;
	while(next != null)
	{
		if(next.value > secondary.value)
		{
			temp = next;
			current.next = secondary;
			secondary = temp;
		}
		current = current.next;
	}

	current.next = secondary;
	return head;
}
