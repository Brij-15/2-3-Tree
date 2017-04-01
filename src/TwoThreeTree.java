

/**
 * @author Brij Patel 101008373
 * As a convention we will always put the value to be inserted into the small value of the node
 * -1 means that there is no value in that spot.
 *
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
		inOrderTraversal(focusNode.leftChild);
		focusNode.printNode();
		inOrderTraversal(focusNode.rightChild);
	}//recursive call 
}

public void insert(Node newNode){
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
			else if(focusNode.getSmall() < newNode.getSmall() && focusNode.getLarge() > newNode.getSmall()){//MOVE TO RIGHT; checks to see if given key is greater than large of current node
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
				ThreeNode t1 = combine(focusNode, newNode);
				split(t1, parent);
			}
		}
	}
	
}

public void split(ThreeNode t1, Node parent){
	if(parent.getElements() == 1){
		parent.setLarge(parent.getSmall());
		parent.setSmall(t1.getMidItem());
		Node n1 = new Node(t1.getSmall(), -1, null, null,null);
		Node n2 = new Node(t1.getLarge(), -1, null, null, null);
		parent.setLeft(n1);
		parent.setRight(n2);
	}
	if(parent.getElements() == 2){
		
	}
}

public ThreeNode combine(Node focusNode, Node newNode){
	if(focusNode.getSmall() > newNode.getSmall()){
			ThreeNode t1 = new ThreeNode(newNode.getSmall(),focusNode.getSmall(), focusNode.getLarge(),null,null,null,null);
		}
	else if(focusNode.getSmall() < newNode.getSmall() && newNode.getSmall() < focusNode.getLarge()){
			ThreeNode t1 = new ThreeNode(focusNode.getSmall(), newNode.getSmall(), focusNode.getLarge(),null,null,null,null);
	}
	else if(focusNode.getSmall() < newNode.getSmall() && newNode.getSmall() > focusNode.getLarge()){
		ThreeNode t1 = new ThreeNode(focusNode.getSmall(),focusNode.getLarge(), newNode.getSmall(),null,null,null,null);
	}
	return t1;
}

public Node getParent(Node n){
	Node temp = root;
	while(true){
		if(temp.getSmall() > n.getSmall()){
			if(temp.getLeft() == n){
				return temp;
			} else {
				temp = temp.leftChild;
			}
			
		}
		else if(temp.getSmall() < n.getSmall() && temp.getLarge() > n.getLarge()){
			if(temp.getMid() == n){
				return temp;
			} else {
				temp = temp.midChild;
			}
		}
		else if(temp.getSmall() < n.getSmall() && temp.getLarge() < n.getLarge()){
			if(temp.getRight() == n){
				return temp;
			} else {
				temp = temp.rightChild;
			}
		}
	}
}


public static void main(String [] args){
System.out.println("hello");
TwoThreeTree t = new TwoThreeTree();
Node n1 = new Node(8,-1,null,null,null);
t.insert(n1);
Node n2 = new Node(10, -1, null,null,null);
t.insert(n2);
Node n3 = new Node(2,-1,null,null,null);
t.insert(n3);
t.inOrderTraversal(n1);
}//ends main
}
