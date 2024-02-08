public class ray {
    vec startPoint = new vec(0, 0, 0);
    vec dir = new vec(0, 0, 0);
    public ray(vec startPointIn, vec dirIn){
        this.startPoint = startPointIn;
        this.dir = dirIn;
    }

    public boolean hasPoint(vec pointToCheck){
        float xDiff = (pointToCheck.x - startPoint.x);
        float yDiff = (pointToCheck.y - startPoint.y);
        float zDiff = (pointToCheck.z - startPoint.z);

        if( (xDiff/dir.x == yDiff/dir.y) && (yDiff/dir.y == zDiff/dir.z) ){
            return true;
        }

        return false;
    }

    public void initFromPoints(vec vec1, vec vec2){
        this.startPoint = vec1;
        this.dir.x = vec1.x - vec2.x;
        this.dir.y = vec1.y - vec2.y;
        this.dir.z = vec1.z - vec2.z;
    }

    public ray getInitFromPoints(vec vec1, vec vec2){
        ray tempRay = new ray(new vec(0, 0, 0), new vec(0, 0, 0));
        tempRay.initFromPoints(vec1, vec2);
        return tempRay;
    }

    public vec getPointFromFactor(float factorIn){
        return new vec(
            factorIn * dir.x + startPoint.x,
            factorIn * dir.y + startPoint.y, 
            factorIn * dir.z + startPoint.z);
    }
}