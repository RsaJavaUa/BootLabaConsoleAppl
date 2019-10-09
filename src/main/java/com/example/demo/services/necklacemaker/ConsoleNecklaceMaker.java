package com.example.demo.services.necklacemaker;

import com.example.demo.objects.withlogic.NeckLaceOperator;
import com.example.demo.services.UserInputService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component (value = "console")
public class ConsoleNecklaceMaker extends NecklaceMaker {
    private final static Logger LOGGER = Logger.getLogger(ConsoleNecklaceMaker.class);

    @Autowired
    private NeckLaceOperator neckLace;

    @Autowired
    private UserInputService inputService;

    public NeckLaceOperator createNecklace() {
        while (true) {
            int userInputStone = inputService.userInputStoneType();
            if (userInputStone == 4) {
                LOGGER.info("End of process of creating necklace...Bye");
                System.out.println("End of process of creating necklace...Bye");
                break;
            }
            int stoneQuantity = inputService.userInputStoneQuantity();
            neckLace.addStonesToNeckclace(userInputStone, stoneQuantity);
            if (inputService.userInputContinueLoop() == 2) {
                break;
            }
        }
        return neckLace;
    }
}

