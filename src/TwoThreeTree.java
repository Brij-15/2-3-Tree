

/**
 * @author Brij Patel 101008373
 * As a convention we will always put the value to be inserted into the small value of the node
 * -1 means that there is no value in that spot.
 *Split works but nodes arn't getting assigned properly I dont know how to fix it. n7 is the point where it stops working
 */
public class TwoThreeTree{
	Node root;
	Node focusNode;
	Node parent;
	int maxElements = 2;
	int maxChildren = 3;
	boolean found = false;
public TwoThreeTree(){
		root = null;
	}
public void inOrderTraversal(Node focusNode){
	if(focusNode != null){
		if(focusNode.getElements() == 1){
		inOrderTraversal(focusNode.leftChild);
		focusNode.printNode();
		inOrderTraversal(focusNode.rightChild);
	}
		else if(focusNode.getElements() == 2){
			inOrderTraversal(focusNode.leftChild);
			focusNode.printNode();
			inOrderTraversal(focusNode.midChild);
			//System.out.print(focusNode.getSmall());
			inOrderTraversal(focusNode.getRight());
		}
	}//recursive call 
}

public void insert(Node newNode){
	found = false;
	if(root == null){
		root = newNode;
	}else{
		focusNode = root;
		parent = focusNode;
		while(found == false){
			if(focusNode.getSmall() > newNode.getSmall()){//MOVE LEFT; checks if current key is greater than given key if it is move to the left
					if(focusNode.numChildren() == 0){
						found = true;
					} else{
					parent = focusNode;
					focusNode = focusNode.leftChild;
					}
			}
			else if(focusNode.getSmall() < newNode.getSmall() && focusNode.getLarge() > newNode.getSmall()){//MOVE MIDDLE; checks to see if given key is greater than small val but less than large value
				if(focusNode.numChildren() == 0){
					found = true;
				} else{
				parent = focusNode;
				focusNode = focusNode.midChild;
				}
			}
			else if(focusNode.getSmall() < newNode.getSmall() && focusNode.getLarge() < newNode.getSmall()){//MOVE TO RIGHT; checks to see if given key is greater than large of current node
				if(focusNode.numChildren() == 0){
					found = true;
				} else{
				parent = focusNode;
				focusNode = focusNode.rightChild;
				}
			}
		}
		if(focusNode.numChildren() == 0){//always inserts at the leafs
			if(focusNode.getElements() != 2){
				if(focusNode.getSmall() > newNode.getSmall()){
					focusNode.setLarge(focusNode.getSmall());
					focusNode.setSmall(newNode.getSmall());
				} else {
					focusNode.setLarge(newNode.getSmall());
				}
			} else { //node full
				if(parent.getElements() >= 1){
				ThreeNode t1 = combine(focusNode, newNode);
				focusNode.incElements();
				split(t1, parent);
				} 
			}
		}
	}
	
}

public void split(ThreeNode t1, Node parent){
	/*if(parent == root){
		Node n1 = new Node(t1.getSmall(),-1,null,null,null);
		Node n2 = new Node(t1.getMidItem(),-1,null,null,null);
		Node n3 = new Node(t1.getLarge(),-1,null,null,null);
		root = n2;
		root.leftChild = n1;
		root.rightChild = n3;
	}*/
	if(parent.getElements() == 1){	
	if(parent.getLarge() != -1){
		parent.setLarge(parent.getSmall());
		}
		if(parent.getLeft().getElements() == 3){
			parent.setLarge(parent.getSmall());
			parent.setSmall(t1.getMidItem());
			
		}else{
		parent.setLarge(t1.getMidItem());
		}
		Node n1 = new Node(t1.getSmall(), -1, null, null,null);
		Node n2 = new Node(t1.getLarge(), -1, null, null, null);
		parent.setMid(n1);
		parent.setRight(n2);
	}
	else if(parent.getElements() == 2){
		if(parent.getRight().getElements() == 3|| parent.getMid().getElements() == 3 || parent.getLeft().getElements() == 3){
		   if(parent.getRight() != null){
			ThreeNode t2 = new ThreeNode(parent.getSmall(),parent.getLarge(),t1.getMidItem(),null,null,null,null);
			Node n3 = new Node (t1.getSmall(), -1,null,null,null);
			Node n4 = new Node(t1.getLarge(),-1,null,null,null);
			getParent(root,parent).incElements();
			split(t2,getParent(root, parent));
		}
		else if(parent.getLeft() != null){
			if(parent.getLeft().getElements() == 3){
				
			}
		}
		else if(parent.getMid() != null){
			if(parent.getMid().getElements() == 3){
				
			}
		}
	}
	}
	else if(parent == root && parent.getElements() == 3){
		Node n1 = new Node(t1.getSmall(),-1,parent.getLeft(),null,);
		Node n2 = new Node(t1.getMidItem(),-1,null,parent.getMid(),null);
		Node n3 = new Node(t1.getLarge(),-1,null,null,parent.getRight());
		root = n2;
		root.setLeft(n1);
		root.setRight(n3);
	}
}

public Node getParent(Node c, Node find){
	     if(c.getLeft() == find || c.getMid() == find || c.getRight() == find){
	       return c;
	     }
	  
	     else{
	       if(find.getSmall() < c.getSmall() && c.getLeft() != null){
	        return getParent(c.getLeft(), find);
	        }
	      else if(find.getSmall() < c.getSmall() && find.getLarge() < c.getLarge() && c.getMid() != null){
	        return getParent(c.getMid(), find);
	        }
	      else if(find.getSmall() < c.getLarge() && c.getRight() != null ){
	        return getParent(c.getRight(), find);
	        }
	     }
		return find;
	  
	   }

public ThreeNode combine(Node focusNode, Node newNode){
	ThreeNode t1 = new ThreeNode(-1,-1,-1,null,null,null,null);
	if(focusNode.getSmall() > newNode.getSmall()){
			t1 = new ThreeNode(newNode.getSmall(),focusNode.getSmall(), focusNode.getLarge(),null,null,null,null);
		}
	else if(focusNode.getSmall() < newNode.getSmall() && newNode.getSmall() < focusNode.getLarge()){
			t1 = new ThreeNode(focusNode.getSmall(), newNode.getSmall(), focusNode.getLarge(),null,null,null,null);
	}
	else if(focusNode.getSmall() < newNode.getSmall() && newNode.getSmall() > focusNode.getLarge()){
		t1 = new ThreeNode(focusNode.getSmall(),focusNode.getLarge(), newNode.getSmall(),null,null,null,null);
	}
	return t1;
}


public static void main(String [] args){
System.out.println("hello");
TwoThreeTree t = new TwoThreeTree();
Node n1 = new Node(0,-1,null,null,null);
t.insert(n1);
//t.inOrderTraversal(n1);
Node n2 = new Node(1, -1, null,null,null);
t.insert(n2); //works
Node n3 = new Node(2,-1,null,null,null);
t.insert(n3);//works
Node n4 = new Node(3,-1,null,null,null);
t.insert(n4);//works
Node n5 = new Node(4,-1,null,null,null);
t.insert(n5);//
Node n6 = new Node(5,-1,null,null,null);
t.insert(n6);//works
Node n7 = new Node(6,-1,null,null,null);
t.insert(n7);
Node n8 = new Node(7,-1,null,null,null);
t.insert(n8);
Node n9 = new Node(8,-1,null,null,null);
t.insert(n9);
}//ends main
}
