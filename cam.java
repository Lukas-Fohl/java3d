import java.util.ArrayList;
import java.util.List;
public class cam{
    float fov = 90;
    vec position = new vec(0, 0, 0);
    vec rotation = new vec(0, 0, 0);
    List<ray> rays = new ArrayList<ray>(); //viewpoints
    public cam(float fovIn, vec positionIn, vec rotationIn){
        this.fov = fovIn;
        this.position = positionIn;
        this.rotation = rotationIn;
    }
}