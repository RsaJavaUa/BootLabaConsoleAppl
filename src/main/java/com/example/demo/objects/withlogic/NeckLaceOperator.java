package com.example.demo.objects.withlogic;

import com.example.demo.objects.pojo.Stone;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class NeckLaceOperator {
    private final static Logger LOGGER = Logger.getLogger(NeckLaceOperator.class);

    @Autowired
    private StoneCreator stoneCreator;
    private List<Stone> necklace = new ArrayList<>();
    private Comparator<Stone> comparator = Comparator.comparing(Stone::getPrice);

    public void addStonesToNeckclace(int type, int quantity) {
        for (int i = 0; i < quantity; i++) {
            necklace.add(stoneCreator.createStone(type));
        }
        System.out.println("You have added " + quantity + " "
                + necklace.get(necklace.size() - 1).getClass().getSimpleName() + " to you necklace");
        LOGGER.info("You have added " + quantity + " "
                + necklace.get(necklace.size() - 1).getClass().getSimpleName() + " to you necklace");
    }

    public void showNecklace() {
        System.out.println("You have next stones in you necklace:");
        necklace.forEach(System.out::println);
        LOGGER.info("You have next stones in you necklace:");
        necklace.forEach(stone ->LOGGER.info(stone.toString()));
    }

    public void sortStonesByPrice() {
        necklace.sort(comparator);
    }

    public int calculatePrice() {
        return necklace.stream().mapToInt(Stone::getPrice).sum();
    }

    public int calculateSize() {
        return necklace.stream().mapToInt(Stone::getSize).sum();
    }

    public List<Stone> filterByTransparencyRange(double bottomLimit, double upperLimit) {
        return necklace.stream()
                .filter(stone -> stone.getTransparency() > bottomLimit)
                .filter(stone -> stone.getTransparency() < upperLimit)
                .collect(Collectors.toList());
    }

    public int getNumersOfStones(){
        return necklace.size();
    }

    public void removeAllStones(){
        necklace.removeAll(necklace);
    }

    public List <Stone> getStones(){
        return necklace;
    }
}
