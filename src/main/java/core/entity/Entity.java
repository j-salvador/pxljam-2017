package core.entity;

import core.components.Component;
import maths.Vector;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * This class represents the entities within the game
 * @author Alex Mitchell
 */
public abstract class Entity implements Comparable<Entity>{

    private Set<Component> components = new HashSet<>();

    private Vector position;

    public Entity(Vector position) {
        this.position = position;
    }

    /**
     * Translate the entity
     *
     * @param dx Position change in the X plane
     * @param dy Position change in the Y plane
     */
    public void translate(float dx, float dy) {
        position.add(dx, dy);
    }

    public Vector getPosition() {
        return position;
    }

    public void setPosition(Vector position) {
        this.position = position;
    }


    final public void addComponent(Component component) {
        components.add(component);
    }

    /**
     * Gathers a collection of the components stored within this Entity
     * @return The collection of components
     */
    public final Collection<Component> getComponents() {
        return components;
    }

    /**
     * Returns a collection of components of a specified type type
     * @param type The class
     * @param <T> The type of class
     * @return The collection of Components
     */
    public <T extends Component> Collection<T> getComponents(Class<T> type) {
        Collection<T> components = new HashSet<>();

        for (Component component : getComponents()) {
            if (type.equals(component.getClass())) {
                components.add(type.cast(component));
            }
        }
        return components;
    }

    /**
     * Comparator to compare 2 entities' z values.
     * @param e1 entity that is passed in
     * @return 0 if z values are equal, < 0 if passed entity is closer to screen, > 0 if passed entity is further from
     * screen</>
     */
    @Override
    public int compareTo(Entity e1){
        return (int)(this.position.z - e1.position.z);
    }

}
