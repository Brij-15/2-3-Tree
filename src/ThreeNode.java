
public class ThreeNode {
	int smallItem;
	int largeItem;
	int midItem;
	
	Node leftChild;
	Node rightChild;
	Node midChild;
	
	public ThreeNode(int small, int mid, int large, Node left, Node middle, Node right){
		this.smallItem = small;
		this.midItem = mid;
		this.largeItem = large;
		this.leftChild = left;
		this.midChild = middle;
		this.rightChild = right;
	}
	
	  public int getSmall(){
	    return this.smallItem;
	  }
	  public int getMidItem(){
		  return this.midItem;
	  }
	  public int getLarge(){
	    return this.largeItem;
	  }
	  public Node getLeft(){
	    return this.leftChild;
	  }
	  public Node getMid(){
	    return this.midChild;
	  }
	  public Node getRight(){
	    return this.rightChild;
	  }
	  public void setSmall(int small){
	    this.smallItem = small;
	  }
	  public void setMidItem(int middle){
		  this.midItem = middle;
	  }
	  public void setLarge(int large){
	    this.largeItem = large;
	  }
	  public void setLeft(Node left){
	    this.leftChild = left;
	  }
	  public void setMid(Node mid){
	    this.midChild = mid;
	  }
	  public void setRight(Node right){
	    this.rightChild = right;
	  }
	  public void printTnode(){
		  System.out.println("The small value is: " + this.smallItem + " the large value is: " + this.largeItem);
	  }
	
}
