package com.samples.crls.ds;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private DsNodeStr head;
    private DsNodeStr tail;
    private int cacheSize;
    private Map<String, DsNodeStr> cache;

    LRUCache(int cacheSize) {
        this.cacheSize = cacheSize;
        this.head = this.tail =  null;
        cache = new HashMap<>();
    }

    void addOrUpdate(String key, int x) {
        //time for eviction
        DsNodeStr oldNode = this.cache.get(key);
        if(oldNode != null) {
            oldNode.value = x;
            moveToTop(oldNode);
        } else {
            final DsNodeStr aNode = new DsNodeStr(key, x);
            if(cache.size() == this.cacheSize) {
                DsNodeStr deletedNode = deleteTailNode();
                cache.remove(deletedNode.key);
            }
            addNode(aNode);
            cache.put(key, aNode);
        }
    }

    int get(String key) {
        final DsNodeStr dsNodeStr = cache.get(key);
        if(dsNodeStr == null) {
            throw new RuntimeException("No key found in cache");
        }
        moveToTop(dsNodeStr);
        return dsNodeStr.value;
    }

    void delete(final String key) {
        DsNodeStr oldNode = this.cache.remove(key);
        if(oldNode != null) {
            moveToTop(oldNode);
            deleteNode(oldNode);
        }
    }

    private void deleteNode(final DsNodeStr aNode) {
        //When there is only one mode.
        if(this.head == aNode && this.tail == aNode) {
            this.head = this.tail = null;
        } else if(this.head == aNode) {//When node is head node.
            this.head = aNode.next;
        } else if(this.tail == aNode) {//When node is tail node.
            deleteTailNode();
        } else { //Somewhere in-between
            aNode.prev.next = aNode.next;
            aNode.next.prev = aNode.prev;
        }
    }

    private void moveToTop(final DsNodeStr aNode) {
        //Somewhere in-between
        if(aNode != this.head && aNode != this.tail) {
            aNode.prev.next = aNode.next;
            aNode.next.prev = aNode.prev;
            addNode(aNode);
        } else if(aNode == this.tail) {
            // Since deleting and adding to the head, We should re-use.
            deleteTailNode();
            addNode(aNode);
        } else { //When already at the head
            //noop
        }
    }

    private DsNodeStr deleteTailNode() {
        DsNodeStr dsNodeStr = this.tail;
        if (this.head == this.tail) {
            this.head = this.tail = null;
        } else {
            this.tail.prev.next = null;
            this.tail = this.tail.prev;
        }
        return dsNodeStr;
    }

    private  void addNode( DsNodeStr aNode) {
        if (this.head == null && this.tail == null) {
            this.head = aNode;
            this.tail = aNode;
        } else {
            aNode.next = head;
            head.prev = aNode;
            head = aNode;
        }
    }
}
