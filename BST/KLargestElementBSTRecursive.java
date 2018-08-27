/* qs 14.3 - recursive - reversed in order */

public List<Integer> KLargestElementBST(Node node, int k)
{
	List<Integer> myList = new ArrayList<>();

	recursiveHelper(node, k, myList);

	return myList;
}

public void recursiveHelper(Node node, int k, List<Integer> list)
{
	if(node != null && list.size < k)
	{
		recursiveHelper(node.right, k, list);
		if(list.size < k)
		{
			list.add(node);
		}

		recursiveHelper(node.left, k, list);
	}
}

