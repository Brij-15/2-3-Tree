
public class Node{
	 int smallItem;
	  int largeItem;
	  int total = 0;
	  Node leftChild;
	  Node midChild;
	  Node rightChild;

	  public Node(int small,int big,Node left,Node mid,Node right){
	    this.smallItem = small;
	    this.largeItem = big;
	    this.leftChild = left;
	    this.midChild = mid;
	    this.rightChild = right;
	  }
	  public int getSmall(){
	    return this.smallItem;
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
	  public void printNode(){
		  System.out.println("The small value is: " + this.smallItem + " the large value is: " + this.largeItem);
	  }
	  public int getElements(){
		  //if(total == 3){
			//  total = 3;
		  //}
		   if(this.getSmall() != -1 && this.getLarge() != -1){
			  total = 2;
		  }
		  else if(this.getSmall() == -1 || this.getLarge() != -1){
			  total = 1;
		  }
		  else if(this.getSmall() == -1 && this.getLarge() == -1){
			  total = 0;
		  }
		  return total;
	  }
	  public void incElements(){
		  total++;
	  }
	  public void setElements(int total){
		  this.total = total;
	  }
	  public int numChildren(){
			if(this.leftChild == null && this.rightChild == null && this.midChild == null){
				return 0;
			} 
			else if(this.leftChild != null && this.rightChild == null && this.midChild == null) {
				return 1;
			}
			else if(this.leftChild == null && this.rightChild != null && this.midChild == null){
				return 1;
			}
			else if(this.leftChild == null && this.rightChild == null && this.midChild != null){
				return 1;
			}
			else if(this.leftChild != null && this.rightChild == null && this.midChild != null){
				return 2;
			}
			else if(this.leftChild != null && this.rightChild != null && this.midChild == null){
				return 2;
			}
			else if(this.leftChild == null && this.rightChild != null && this.midChild != null){
				return 2;
			}
			else if(this.leftChild != null && this.rightChild != null && this.midChild != null){
				return 3;
			}
			return -1;
		}
	  
}

