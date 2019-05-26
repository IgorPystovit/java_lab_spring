package com.epam.igorpystovit.model;

public class TreeNode<K,V> {
    public TreeNode<K,V> leftChild;
    public TreeNode<K,V> rightChild;
    private int treeKey;
    private K key;
    private V value;

    public TreeNode(){}
    public TreeNode(K key,V value){
        this.key = key;
        this.value = value;
    }

    public int getTreeKey() {
        return treeKey;
    }

    public void setTreeKey(int treeKey) {
        this.treeKey = treeKey;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public K getKey() {
        return key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public V getValue() {
        return value;
    }


}
