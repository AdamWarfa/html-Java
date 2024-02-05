package org.example;

import com.sun.source.tree.UsesTree;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MainLinkedList {
    public static void main (String[] args) {
        Set<Tag> tags = new HashSet<>();
        long start = System.currentTimeMillis();
        Set<Integer> hashCodes = new HashSet<>();

        for (int i = 0; i < 2000000; i++) {
            HTag htag = new HTag(1);
            htag.setId("id" + i);
            tags.add(htag);
            hashCodes.add(htag.hashCode());
            PTag ptag = new PTag();
            ptag.setId("id" + i);
            tags.add(ptag);
            hashCodes.add(ptag.hashCode());
        }

        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start));
        System.out.println(tags.size());
        System.out.println("hashcode size: " + hashCodes.size());

        int sz = tags.size();

        Iterator<Tag> it = tags.iterator();
        while (it.hasNext()) {
            Tag tag = it.next();
            if (tag instanceof PTag) {
                it.remove();
            } else {
                continue;
            }
        }
        HTag htag = new HTag(1);
        tags.add(htag);
        System.out.println(tags.size());
        tags.add(htag);
        System.out.println(tags.size());
        boolean ct = tags.contains(htag);

    }
}
