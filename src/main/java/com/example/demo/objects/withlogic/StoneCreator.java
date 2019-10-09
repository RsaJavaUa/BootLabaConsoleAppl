package com.example.demo.objects.withlogic;

import com.example.demo.objects.pojo.Amethist;
import com.example.demo.objects.pojo.Diamond;
import com.example.demo.objects.pojo.Opal;
import com.example.demo.objects.pojo.Stone;
import com.example.demo.objects.pojo.StoneType;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class StoneCreator {
    private static final Logger LOGGER = Logger.getLogger(StoneCreator.class);
    private Stone stone;

    public Stone createStone(int stoneType) {
        stone = createDefaultStone(stoneType);
        setRandomSizeAndTransparency();
        estimatePrice();
        return stone;
    }

    private Stone createDefaultStone(int stoneType) {
        switch (stoneType) {
            case 0:
                return new Diamond();
            case 1:
                return new Amethist();
            case 2:
                return new Opal();
        }
        LOGGER.error("Incorrect input. Should be 0 - 2.");
        throw new IllegalArgumentException("should be 0 - 2");
    }

    private void setRandomSizeAndTransparency() {
        Random random = new Random();
        int maxSizeOfStone = 100;
        int below100 = random.nextInt(99) + 1;
        stone.setTransparency((double) below100 / 100);
        stone.setSize(random.nextInt(maxSizeOfStone - 1) + 1);
    }

    private void estimatePrice() {
        stone.setPrice(Math.round(stone.getPrice() * typeCoeff() * transparencyCaff() * sizeCoeff()));
    }

    private float typeCoeff() {
        if (stone.getType().equals(StoneType.PRECIOUS)) {
            return 1.5f;
        }
        if (stone.getType().equals(StoneType.SEMIPRECIOUS)) {
            return 1.3f;
        } else {
            return 1;
        }
    }

    private float transparencyCaff() {
        if (stone.getTransparency() > 0.5) {
            return 1.5f;
        } else {
            return 1;
        }
    }

    private float sizeCoeff() {
        if (stone.getSize() > 50) {
            return 2;
        }
        if (stone.getSize() > 30) {
            return 1.5f;
        } else {
            return 1;
        }
    }
}
