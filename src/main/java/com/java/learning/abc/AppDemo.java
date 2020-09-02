package com.java.learning.abc;

import java.util.WeakHashMap;

public class AppDemo {

    private static WeakHashMap allReferences = new WeakHashMap();

    public static int getSize(){
        return allReferences.size();
    }


    public AppDemo(){
        synchronized (allReferences){
            allReferences.put(this,null);
        }
    }
}
