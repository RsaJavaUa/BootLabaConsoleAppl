package com.example.demo.services.necklacemaker;

import com.example.demo.objects.pojo.StoneType;
import com.example.demo.objects.withlogic.NeckLaceOperator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component (value = "random")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RandomNecklaceMaker extends NecklaceMaker {
    @Autowired
    private NeckLaceOperator neckLace;
    private Random random = new Random();

    public NeckLaceOperator createNecklace() {
        int iterationAndQuantityLimit = random.nextInt(5) + 1;
        for (int i = 0; i < iterationAndQuantityLimit; i++) {
            neckLace.addStonesToNeckclace(random.nextInt(StoneType.values().length),
                    random.nextInt(iterationAndQuantityLimit) + 1);
        }
        return neckLace;
    }
}
