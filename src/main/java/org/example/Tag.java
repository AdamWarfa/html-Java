package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Tag {

    private String id;
    private String tagName;
    private String text;
    private List<Tag> children;
    private String color = "";

    public Tag() {
        children = new ArrayList<>();
    }

    public List<Tag> getChildren() {
        return children;
    }

    public String getColor() {
        return color;
    }


    public void setColor(int r, int g, int b) {
        String red = Integer.toHexString(r);
        String green = Integer.toHexString(g);
        String blue = Integer.toHexString(b);
        this.setColor("#" + red + green + blue);

    }

    public static String rgbToColorString(int red, int green, int blue) {
        red = Math.min(255, Math.max(0, red));
        green = Math.min(255, Math.max(0, green));
        blue = Math.min(255, Math.max(0, blue));

        String colorString = String.format("#%02x%02x%02x", red, green, blue);

        return colorString;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public void setChildren(List<Tag> children) {
        this.children = children;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id='" + id + '\'' +
                ", tagName='" + tagName + '\'' +
                ", text='" + text + '\'' + " children: " + children.size() +
                '}';
    }

    public String toHtmlString() {
        String s1 = "";
        if (this.getColor().length() > 0) {
            s1 = "<" + tagName + " style=" + '"' + "background-color:" + color + '"' + ">";
        } else {
            s1 = s1 + "<" + tagName+ ">";
        }
        for (Tag tag : children) {
            String child = tag.toHtmlString();
            s1 += child;
        }
        s1 = s1 + text + "</" + tagName + ">";
        return s1;
    }

    public String toHtmlStringFile(String fileName) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(this.toHtmlString());
            writer.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());

        }
        return fileName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return Objects.equals(id, tag.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}