package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {



        HTag hTag = new HTag(1);
        hTag.setText("jeg er et h tag");

        // System.out.println(hTag.toHtmlString());

        LinkedList<Tag> hTags = new LinkedList<>();

        for (int i = 0; i < 20; i++) {
        HTag htag2 = new HTag(2);
        htag2.setText("jeg er et h tag");
        hTags.add(htag2);
        PTag pTag = new PTag();
        pTag.setText("jeg er et p tag");
        hTags.add(pTag);
        }
        System.out.println(hTags.size());

        Iterator<Tag> it = hTags.iterator();
        while (it.hasNext()) {
            Tag tag = it.next();
            if (tag instanceof PTag) {
                it.remove();
            } else {
                continue;
            }

        }
        System.out.println(hTags);
        System.out.println(hTags.size());
    /*    for (int i = 19; i > 0; i--) {
            HTag hTag2 = new HTag(5-(i % 5));
            hTag2.setText("jeg er et " + hTag2.getTagName() + " tag");
            hTag2.setColor(i*4, i*8, i*5);
            hTags.add(hTag2);

            for(int j = 1 ; j < 5; j++){
                PTag pTag = new PTag();
                pTag.setText("jeg er et p tag indeni " + hTag2.getTagName() + " tag");
                pTag.setColor(i+50, i+100, i+200);
                hTags.add(pTag);
            }
        }

        System.out.println(hTags.size());

        for (Tag tag: hTags) {
            System.out.println(tag.toHtmlString());
        }

        BodyTag body = new BodyTag();
        body.setChildren(hTags);

        System.out.println(body.toHtmlString());
        System.out.println(body.toHtmlString());
        body.toHtmlStringFile("index.html");

        body.setColor(255,10,15);
        System.out.println(body.getColor()); */
    }
}