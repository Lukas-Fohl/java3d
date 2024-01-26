public class plane{
    //normal-Form
    public vec startPoint;
    public vec dir1 = new vec(0, 0, 0);
    public vec dir2 = new vec(0, 0, 0);
    //coord-Form
    public vec normal = new vec(0, 0, 0);
    public float solution = 0;

    public plane(vec starVecIn, vec dir1In, vec dir2In){
        this.startPoint = starVecIn;
        this.dir1 = dir1In;
        this.dir2 = dir2In;
    }

    public vec getNormal(){
        vec reval = new vec(0, 0, 0);
        reval.x = ( this.dir1.y * this.dir2.z ) - ( this.dir1.z * this.dir2.y );

        reval.y = ( this.dir1.x * this.dir2.z ) - ( this.dir1.z * this.dir2.x );
        reval.y = - reval.y;

        reval.z = ( this.dir1.x * this.dir2.y ) - ( this.dir1.y * this.dir2.x );

        return reval;
    }

    public void printPlane(){
        System.out.println("start:\t" + startPoint.x + " ; " + startPoint.y + " ; " + startPoint.z);
        System.out.println("dir1:\t" + dir1.x + " ; " + dir1.y + " ; " + dir1.z);
        System.out.println("dir2:\t" + dir2.x + " ; " + dir2.y + " ; " + dir2.z);
    }

    public void initFromPoints(vec vec1, vec vec2, vec vec3){
        this.startPoint = vec1;
        this.dir1 = new vec(vec1.x-vec2.x, vec1.y-vec2.y, vec1.z-vec2.z);
        this.dir2 = new vec(vec2.x-vec3.x, vec2.y-vec3.y, vec2.z-vec3.z);
    }

    public void setCoord(){
        this.normal = this.getNormal();
        this.solution = this.startPoint.getScalar(this.normal);
    }

    public float getHitRayFactor(ray rayIn){
        float rAmount = 0;
        float numAmount = 0;

        rAmount += this.normal.x * ( rayIn.dir.x );
        numAmount += this.normal.x * ( rayIn.startPoint.x );

        rAmount += this.normal.y * ( rayIn.dir.y );
        numAmount += this.normal.y * ( rayIn.startPoint.y );

        rAmount += this.normal.z * ( rayIn.dir.z );
        numAmount += this.normal.z * ( rayIn.startPoint.z );

        return (this.solution - numAmount)/rAmount;
    }

    public boolean hasPoint(vec pointIn){
        // pointIn.x = this.startPoint.x + this.dir1.x /* *t */ + this.dir2.x /* *r */;
        // pointIn.y = this.startPoint.y + this.dir1.y /* *t */ + this.dir2.y /* *r */;
        // pointIn.z = this.startPoint.z + this.dir1.z /* *t */ + this.dir2.z /* *r */;

        //float s = 1;
        //float t = (pointIn.x - this.startPoint.x) - ((dir1.x*s)/dir2.x);

        //pointIn.y = this.startPoint.y + dir1.y * s + dir2.y * ( (pointIn.x - this.startPoint.x) - ((dir1.x*s)/dir2.x) ); | - this.startPoint.y

        //pointIn.y - this.startPoint.y = dir1.y * s + dir2.y * ( (pointIn.x - this.startPoint.x) - ((dir1.x*s)/dir2.x) ); | / dir2.y

        //(pointIn.y - this.startPoint.y) / dir2.y = ( dir1.x * s ) / dir2.y + (pointIn.x - this.startPoint.x) + ((dir1.x*s)/dir2.x) | - (pointIn.x - this.startPoint.x)

        //( ( pointIn.y - this.startPoint.y ) / dir2.y ) - ( pointIn.x - this.startPoint.x ) = ( dir1.x * s ) / dir2.y + ((dir1.x*s)/dir2.x) | tu

        //((dir1.x*s*dir2.x)/dir2.y) + ((dir1.x*s*dir2.y )/dir2.x) --> (dir1.x*s*dir2.y + dir1.x*s*dir2.x) / (dir2.y + dir2.x)

        //( ( pointIn.y - this.startPoint.y ) / dir2.y ) - ( pointIn.x - this.startPoint.x ) = (dir1.x*s*dir2.y + dir1.x*s*dir2.x) / (dir2.y + dir2.x) | * (dir2.y + dir2.x)

        //(dir1.x*s*dir2.y + dir1.x*s*dir2.x) = ( ( ( pointIn.y - this.startPoint.y ) / dir2.y ) - ( pointIn.x - this.startPoint.x ) ) * (dir2.y + dir2.x) | tu

        //s * (dir1.x*dir2.y + dir1.x*dir2.x) = ( ( ( pointIn.y - this.startPoint.y ) / dir2.y ) - ( pointIn.x - this.startPoint.x ) ) * (dir2.y + dir2.x) | / (dir1.x*dir2.y + dir1.x*dir2.x)
        //s = ( ( ( ( pointIn.y - this.startPoint.y ) / dir2.y ) - ( pointIn.x - this.startPoint.x ) ) * (dir2.y + dir2.x) ) / (dir1.x*dir2.y + dir1.x*dir2.x)

        //s = (this.startPoint.y+dir2.y*pointIn.x−dir2.y*this.startPoint.x−pointIn.y)/(dir1.y−dir2.y*(dir1.x/dir2.x))

        //--> solve for t and r

        return true;
    }

    public boolean hitByRay(ray rayIn){
        this.setCoord();

        float denominator = rayIn.dir.getScalar(this.normal);
        float dir1Fct;
        float dir2Fct;
        if (denominator != 0){
            vec rayToPlane = this.startPoint.getSubtract(rayIn.startPoint);

            dir1Fct = rayToPlane.getScalar(this.normal) / denominator;
            dir2Fct = rayIn.dir.getScalar(rayToPlane) / denominator;
            //System.out.println(dir1Fct);
            //System.out.println(dir2Fct);
            
        }else{
            return false;
        }

        if ( (dir1Fct >= 0.0 && dir1Fct <= 1.0) && (dir2Fct >= 0.0 && dir2Fct <= 1.0) ){
            return true;
        }
        return false;
    }

    public vec getHitByRayFactor(ray rayIn){
        this.setCoord();

        float denominator = rayIn.dir.getScalar(this.normal);
        float dir1Fct;
        float dir2Fct;
        vec rayToPlane = this.startPoint.getSubtract(rayIn.startPoint);

        dir1Fct = rayToPlane.getScalar(this.normal) / denominator;
        dir2Fct = rayIn.dir.getScalar(rayToPlane) / denominator;

        return new vec(dir1Fct, dir2Fct, 0.0f);
    }

    public vec getPointFromFactor(float dir1Fct, float dir2Fct){
        float tempX = this.startPoint.x + (dir1Fct*dir1.x) + (dir2Fct*dir2.x);
        float tempY = this.startPoint.y + (dir1Fct*dir1.y) + (dir2Fct*dir2.y);
        float tempZ = this.startPoint.z + (dir1Fct*dir1.z) + (dir2Fct*dir2.z);
        return new vec(tempX, tempY, tempZ);
    }
}