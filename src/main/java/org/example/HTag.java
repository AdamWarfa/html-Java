package org.example;

public class HTag extends Tag {

    private byte number;

    public HTag(int hNum) {
        number = (byte) hNum;
        this.setNumber(number);
    }

    public byte getNumber() {
        return number;
    }

    public void setNumber(byte number) {
        this.number = number;
        this.setTagName("h" + number);
    }

    public void setNumber(int number) {
        this.number = (byte) number;
    }

    @Override
    public String toString() {
        String s = super.toString();
        return s + "HTag{" +
                "number=" + number +
                '}';
    }
}