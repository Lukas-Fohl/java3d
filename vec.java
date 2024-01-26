public class vec {
    float x,y,z = 0;
    public vec(float xIn, float yIn, float zIn){
        this.x = xIn;
        this.y = yIn;
        this.z = zIn;
    }

    public void printvec(){
        System.out.println("vec:\t" + x + " ; " + y + " ; " + z);
    }

    public float getScalar(vec vecIn){
        return this.x * vecIn.x + this.y * vecIn.y + this.z * vecIn.z;
    }

    public vec getSubtract(vec vecIn){
        return new vec(this.x-vecIn.x, this.y-vecIn.y, this.z-vecIn.z);
    }

    public float getDistanceToOtherPoint(vec vecIn){
        return (float)Math.sqrt(
            Math.pow((double)(this.x - vecIn.x), 2.0) +
            Math.pow((double)(this.y - vecIn.y), 2.0) +
            Math.pow((double)(this.y - vecIn.y), 2.0)
        );
    }
}