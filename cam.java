import java.util.ArrayList;
import java.util.List;
public class cam{
    float fov = 90;
    vec position = new vec(0, 0, 0);
    vec rotation = new vec(0, 0, 0);
    int sizeX, sizeY = 0;
    ray[][] rays = new ray[sizeX][sizeY]; //viewpoints
    public cam(float fovIn, vec positionIn, vec rotationIn, int sizeXIN, int sizeYIN){
        this.fov = fovIn;
        this.position = positionIn;
        this.rotation = rotationIn;
        this.sizeX = sizeXIN;
        this.sizeY = sizeYIN;
        rays = new ray[sizeXIN][sizeYIN];
    }

    public void initRays(){
        //TODO: use Rotation && fov
        ray tempRay = new ray(rotation, position);
        for(int x = 0; x < sizeX; x++){
            for(int y = 0; y < sizeY; y++){
                rays[x][y] = tempRay.getInitFromPoints(position, new vec(x, y, 2));
            }
        }
        return;
    }

    public void display(Boolean[][] displayIn){
        for(int yIter = 0; yIter < sizeY; yIter++){
            for(int xIter = 0; xIter < sizeX; xIter++){
                System.out.print(((displayIn[xIter][yIter]==true)?"#":" "));
            }
            System.out.print("\n");
        }
        return;
    }
}