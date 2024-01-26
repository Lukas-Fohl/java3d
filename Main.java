public class Main {
    public static void main(String[] args) {
        
        System.out.println("\n");

        ray testRay = new ray(
            new vec(0, 0, 2),
            new vec(1, 1, -1));

        plane testPlane = new plane(
            new vec(1, 1, 1),
            new vec(1, 3, 5),
            new vec(2, 4, 8));


        //ray testRay = new ray(
        //    new vec(0, 0, 0),
        //    new vec(0, 0, 1));
        //    
        //plane testPlane = new plane(
        //    new vec(1, 1, 1),
        //    new vec(1, 0, 0),
        //    new vec(0, 1, 0));

        if(testPlane.hitByRay(testRay)){
            vec temp = testPlane.getHitByRayFactor(testRay);

            //testPlane.setCoord();
            //testPlane.normal.printvec();
            //System.out.println(testPlane.solution);

            vec hitPoint = testPlane.getPointFromFactor(temp.x, temp.y);
            float distance = hitPoint.getDistanceToOtherPoint(testRay.startPoint);
            hitPoint.printvec();
            System.out.println(distance);
        }
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