package com.example.demo.objects.pojo;

public class Amethist extends Stone {
    public Amethist() {
        setType(StoneType.PRECIOUS);
        setPrice(150);
    }

    @Override
    public String toString() {
        return "Amethist{" +
                "size=" + getSize() +
                ", transparency=" + getTransparency() +
                ", price=" + getPrice() +
                '}';
    }
}
