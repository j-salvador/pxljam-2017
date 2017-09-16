package serialisation;

import core.components.ColliderComponent;
import core.components.Component;
import core.scene.Camera;
import core.scene.Entity;
import core.scene.Scene;
import maths.Vector;
import physics.Collider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Alex Mitchell
 */
public class SceneFromFile {
    private static final String filePath = "./SaveGame.txt";

    public static Scene read(){

        Camera cam;
        Set<Entity> entities;


        BufferedReader read;


        try{

            read = new BufferedReader(new FileReader(filePath));
            cam = readCamera(read);






        }catch (IOException e){

        }

        return null;
    }

    private static Camera readCamera(BufferedReader reader) throws IOException{
        Vector location;
        Vector dimension;
        float scale;

        String[] locationInfo = reader.readLine().split(" ");
        location = new Vector(Float.parseFloat(locationInfo[0]), Float.parseFloat(locationInfo[1]));
        String[] dimensionInfo = reader.readLine().split(" ");
        dimension = new Vector(Float.parseFloat(dimensionInfo[0]), Float.parseFloat(dimensionInfo[1]));
        String[] scaleInfo = reader.readLine().split(" ");
        scale = Float.parseFloat(scaleInfo[0]);

        return new Camera(location, dimension, scale);
    }

    private static Entity readEntity(BufferedReader reader) throws IOException{
        Vector postition;
        Set<Component> components = new HashSet<>();

        String[] locationInfo = reader.readLine().split(" ");
        postition = new Vector(Float.parseFloat(locationInfo[0]), Float.parseFloat(locationInfo[1]));

        String line;
        while((line = reader.readLine() )!= null){
            String[] componentInfo = line.split(" ");

            try {
                Class clazz = Class.forName(componentInfo[0]);




            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }

        return null;
    }

    private static ColliderComponent readCollider(){
        return null;
    }
}
