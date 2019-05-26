package com.epam.igorpystovit.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BinaryTree<K,V> {
    public TreeNode<K,V> root;
    private int size;
    private StringBuilder sb;
    private Logger logger = LogManager.getLogger(BinaryTree.class.getName());

    public BinaryTree(){
        size = 0;
        sb = new StringBuilder();
    }

    private int hashCode(K key){
        int hashNum = key.hashCode()^(16*size);
        return hashNum % 16;
    }

    public int size(){
        return size;
    }

    public boolean remove(K key){
        boolean modified = false;
        int hashTreeKey = hashCode(key);
        TreeNode<K,V> headTreeNode = root;
        TreeNode<K,V> prevTreeNode = null;

        if (!contains(key)){
            logger.info("No such element");
        }else{
            while (headTreeNode != null){
                if (headTreeNode.getKey().equals(key)){
                    break;
                }

                prevTreeNode = headTreeNode;
                if (headTreeNode.getTreeKey() <= hashTreeKey){
                    headTreeNode = headTreeNode.rightChild;
                }else{
                    headTreeNode = headTreeNode.leftChild;
                }

            }

            if (headTreeNode != null){
                //does not have childrens
                if ((headTreeNode.leftChild == null) && (headTreeNode.rightChild == null)){
                    if (prevTreeNode != null){
                        if (prevTreeNode.rightChild.getKey().equals(headTreeNode.getKey())){
                            prevTreeNode.rightChild = null;
                            modified = true;
                        }else{
                            prevTreeNode.leftChild = null;
                            modified = true;
                        }
                    }
                    //has one child
                }else if (headTreeNode.leftChild == null){
                    if (prevTreeNode != null){
                        if ((prevTreeNode.rightChild.getKey().equals(headTreeNode.getKey()))){
                            prevTreeNode.rightChild = headTreeNode.rightChild;
                            modified = true;
                        }else{
                            prevTreeNode.leftChild = headTreeNode.rightChild;
                            modified = true;
                        }
                    }
                }else if (headTreeNode.rightChild == null){
                    if (prevTreeNode != null){
                        if ((prevTreeNode.rightChild.getKey().equals(headTreeNode.getKey()))){
                            prevTreeNode.rightChild = headTreeNode.leftChild;
                            modified = true;
                        }else{
                            prevTreeNode.leftChild = headTreeNode.leftChild;
                            modified = true;
                        }
                    }
                    //has two childs
                }else{
                    if (prevTreeNode.rightChild.getKey().equals(headTreeNode.getKey())){
                        prevTreeNode.rightChild = getSuccessor(headTreeNode);
                        modified = true;
                    }else{
                        prevTreeNode.leftChild = getSuccessor(headTreeNode);
                        modified = true;
                    }
                }
            }

        }

        if (modified){
            size--;
        }

        return modified;
    }

    private TreeNode<K,V> getSuccessor(TreeNode<K,V> deleteNode){
        TreeNode<K,V> headTreeNode = deleteNode.rightChild;
        TreeNode<K,V> successorParent = deleteNode;
        TreeNode<K,V> successor = deleteNode;
        while (headTreeNode != null){
            successorParent = successor;
            successor = headTreeNode;
            headTreeNode = headTreeNode.leftChild;
        }

        if (successor != deleteNode.rightChild){
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = deleteNode.rightChild;
        }
        return successor;
    }

    public boolean contains(K key){
        boolean contains = false;
        int hashTreeKey = hashCode(key);
        TreeNode<K,V> headTreeNode = root;
        while (headTreeNode != null){
            if (headTreeNode.getKey().equals(key)){
                contains = true;
                break;
            }
            if (headTreeNode.getTreeKey() <= hashTreeKey){
                headTreeNode = headTreeNode.rightChild;
            }else{
                headTreeNode = headTreeNode.leftChild;
           }
        }
        return contains;
    }

    public boolean put(K key,V value){
        int hashTreeKey = hashCode(key);
        boolean modififed = false;
        if (root == null){
            root = new TreeNode<>(key,value);
            root.setTreeKey(hashTreeKey);
            size++;
            modififed = true;
        }else {
            TreeNode<K,V> headTreeNode = root;
            TreeNode<K,V> prevTreeNode = null;
            while (headTreeNode != null){
                if (headTreeNode.getTreeKey() == hashTreeKey){
                    headTreeNode.setValue(value);
                    modififed = true;
                }
                prevTreeNode = headTreeNode;
                if (hashTreeKey >= headTreeNode.getTreeKey()){
                    headTreeNode = headTreeNode.rightChild;
                }else{
                    headTreeNode = headTreeNode.leftChild;
                }
            }

            if (!modififed){
                size++;
                headTreeNode = new TreeNode<>(key,value);
                headTreeNode.setTreeKey(hashTreeKey);
                if (prevTreeNode != null){
                    if (hashTreeKey >= prevTreeNode.getTreeKey()){
                        prevTreeNode.rightChild = headTreeNode;
                    }else {
                        prevTreeNode.leftChild = headTreeNode;
                    }
                }
                modififed = true;
            }
        }
        return modififed;
    }

    public V get(K key){
        V value = null;
        int hashTreeKey = hashCode(key);
        if (size == 0){
            logger.info("The tree is void");
        }else{
            TreeNode<K,V> headTreeNode = root;
            while (headTreeNode != null){
                if (headTreeNode.getKey() == key){
                    value = headTreeNode.getValue();
                    break;
                }
                if (headTreeNode.getTreeKey() <= hashTreeKey){
                    headTreeNode = headTreeNode.rightChild;
                }else {
                    headTreeNode = headTreeNode.leftChild;
                }
            }
        }
        return value;
    }


    private String goThrough(TreeNode rootNode){
        if (rootNode != null){
            goThrough(rootNode.leftChild);
            if ((rootNode.leftChild == null) || (rootNode.rightChild == null)){
                sb.append(rootNode.getKey()+"="+rootNode.getValue()+"\n");
            }else{
                sb.append(rootNode.getKey()+"="+rootNode.getValue());
            }
            goThrough(rootNode.rightChild);
        }
        return sb.toString();
    }

    public String toString(){
        sb = new StringBuilder();
        return goThrough(root);
    }
}
