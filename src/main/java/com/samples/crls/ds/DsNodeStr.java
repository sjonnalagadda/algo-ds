package com.samples.crls.ds;

public class DsNodeStr {

    int value;
    String key;
    DsNodeStr prev;
    DsNodeStr next;

    DsNodeStr(final String key, int value) {
        this.key = key;
        this.value = value;
    }
}
