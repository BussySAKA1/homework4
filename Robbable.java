/**
 * The Robbable interface represents an entity that can be robbed.
 * @author mpaulus7
 * @version 10.24
 */
public interface Robbable {

    /**
     * Defines the action of being robbed.
     *
     * @return The number of items (e.g., candies) lost during the robbery.
     */
    int beRobbed();
}
