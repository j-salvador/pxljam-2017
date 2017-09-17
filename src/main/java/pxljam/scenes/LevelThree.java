package pxljam.scenes;

import core.scene.Scene;
import pxljam.entities.BasicBlockEntity;
import pxljam.entities.MovingBlockEntity;
import pxljam.entities.PlayerEntity;

/**
 * Created by Alex Mitchell on 17/09/2017.
 */
public class LevelThree extends Scene{

    public LevelThree(){
        addEntity(new PlayerEntity(2, 1.5f));

        for(int i = 0; i < 4; i++){
            addEntity(new BasicBlockEntity(i,3,  "grass-top"));
        }

        addEntity(new MovingBlockEntity(4, 3, "grass-top", 3f, 0f, 1));


        for(int i = 6; i < 11; i++){
            addEntity(new BasicBlockEntity(i,5, "grass-top"));
        }

        addEntity(new MovingBlockEntity(11, 5, "grass-top", 1f, 3f, 2));
    }
}
