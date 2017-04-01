
public class ThreeNode {
	int smallItem;
	int largeItem;
	int midItem;
	//left to right 
	Node firstChild;
	Node secondChild;
	Node thirdChild;
	Node fourthChild;
	
	public ThreeNode(int small, int mid, int large, Node first, Node second, Node third, Node fourth){
		this.smallItem = small;
		this.midItem = mid;
		this.largeItem = large;
		this.firstChild = first;
		this.secondChild = second;
		this.thirdChild = third;
		this.fourthChild = fourth;
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
	  public Node getFirst(){
	    return this.firstChild;
	  }
	  public Node getSecond(){
	    return this.secondChild;
	  }
	  public Node getThird(){
	    return this.thirdChild;
	  }
	  public Node getFourth(){
		  return this.fourthChild;
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
	  public void setFirst(Node l){
	    this.firstChild = l;
	  }
	  public void setSecond(Node m){
	    this.secondChild = m;
	  }
	  public void setThird(Node right){
	    this.thirdChild = right;
	  }
	  public void setFourth(Node f){
		  this.fourthChild = f;
	  }
	  public void printTnode(){
		  System.out.println("The small value is: " + this.smallItem + "The middle item is "+ this.midItem+" the large value is: " + this.largeItem);
	  }
	
}
