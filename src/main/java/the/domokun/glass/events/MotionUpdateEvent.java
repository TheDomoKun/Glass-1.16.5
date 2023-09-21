package the.domokun.glass.events;

import com.darkmagician6.eventapi.events.Event;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3f;

public class MotionUpdateEvent implements Event {
    Vector3d position;
    float moveForward,moveStrafing;
    boolean isMoving;

    public Vector3d getPosition() {
        return position;
    }

    public float getMoveForward() {
        return moveForward;
    }

    public float getMoveStrafing() {
        return moveStrafing;
    }

    public boolean isMoving() {
        return isMoving;
    }
    public static class Pre extends MotionUpdateEvent{
        public Pre(Vector3d position, float moveForward, float moveStrafing, boolean isMoving) {
            this.position = position;
            this.moveForward = moveForward;
            this.moveStrafing = moveStrafing;
            this.isMoving = isMoving;
        }
    }

    public static class Post extends MotionUpdateEvent{
        public Post(Vector3d position, float moveForward, float moveStrafing, boolean isMoving) {
            this.position = position;
            this.moveForward = moveForward;
            this.moveStrafing = moveStrafing;
            this.isMoving = isMoving;
        }
    }
}
