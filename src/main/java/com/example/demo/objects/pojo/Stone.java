package com.example.demo.objects.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Stone implements Comparable<Stone> {
    private Integer size;
    private Double transparency;
    private StoneType type;
    private Integer price;

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public int compareTo(Stone stone) {
        return price.compareTo(stone.getPrice());
    }

}
