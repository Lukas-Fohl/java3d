import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ray testRay = new ray(
            new vec(0, 0, 2),
            new vec(1, 1, -1));

        plane testPlane = new plane(
            new vec(1, 1, 1),
            new vec(1, 3, 5),
            new vec(2, 4, 8));

        obj testObj = new obj();
        testObj.readFromFile("");

        testObj.planeList.add(testPlane); //just for now --> else is empty

        int XCamSize = 20;
        int YCamSize = 20;

        cam mainCam = new cam(0,
            new vec(0, 0, 0),
            new vec(0, 0, 0),
            XCamSize,
            YCamSize);

        mainCam.initRays();

        Boolean[][] result = new Boolean[XCamSize][YCamSize];

        for(int x = 0; x < XCamSize; x++){
            for(int y = 0; y < YCamSize; y++){
                result[x][y] = false;
                for(var planeIter:testObj.planeList){
                    if(planeIter.hitByRay(mainCam.rays[x][y])){
                        //vec temp = testPlane.getHitByRayFactor(testRay);
                        //vec hitPoint = testPlane.getPointFromFactor(temp.x, temp.y);
                        result[x][y] = true;
                        break; //-->hit
                    }
                }
            }
        }


        //if(testPlane.hitByRay(testRay)){
            //vec temp = testPlane.getHitByRayFactor(testRay);

            //testPlane.setCoord();
            //testPlane.normal.printvec();
            //System.out.println(testPlane.solution);

            //vec hitPoint = testPlane.getPointFromFactor(temp.x, temp.y);
            //float distance = hitPoint.getDistanceToOtherPoint(testRay.startPoint);
            //hitPoint.printvec();
            //System.out.println(distance);
        //}


        /*Ablauf:
        * create coord form of plane
        * get hit fct of plane and ray
        * get point from fct and ray
        * Gleichungssystem Plane-normal-form && point
        * --> check if r || s < 1 | > 0
        * find distance of ray.start and hit
        */

    }
}
