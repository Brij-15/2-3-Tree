
public class Node<K, E> {
protected K key;
protected E element;
protected Node<E,K> left, right;

public Node(K key, E element,Node<E,K> left, Node<E,K>right ){
	this.key = key;
	this.element = element;
	this.left = left;
	this.right = right;
}
public K getKey(){
	return key;
}
public E getElement(){
	return element;
}
public Node<E,K> getLeft(){
	return left;
}
public Node<E,K> getRight(){
	return right;
}
public void setElement(E element){
	this.element = element;
}
public void setLeft(Node<E,K> node){
	this.left = node;
}
public void setRight(Node<E,K> node){
	this.right = node;
}
}

