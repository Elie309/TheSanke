package com.elie309.thesnake.Utils;



public class PVector implements Cloneable{

    private float x;
    private float y;

    /**
     * PVector will help in handling two dimensions vectors
     * @param x - Horizontal position
     * @param y - Vertical position
     */
    public PVector(float x, float y) {
        this.x = x;
        this.y = y;
    }


    //#region Methods

    public void setVector(PVector v){
        setX(v.getX());
        setY(v.getY());
    }

    /**
     * This method will add another vector to our current one.
     * @param v - Vector
     */
    public void add( PVector v){
        setX(this.getX() + v.getX());
        setY(this.getY() + v.getY());
    }

    /**
     * This method will subtract another vector to our current one.
     * @param v - Vector
     */
    public void subtract(PVector v){
        setX(this.getX() - v.getX());
        setY(this.getY() - v.getY());
    }

    /**
     * Multiply our vector by another number - Which will increase its size
     * @param n - Scalar (One value)
     */
    public void multi(float n){
        setX(this.getX() * n);
        setY(this.getY() * n);
    }

    /**
     * Multiply our X only with scalar
     * @param nx - Scalar number
     */
    public void multiX(float nx){
        setX(this.getX() * nx);
    }

    /**
     * Multiply our Y only with scalar
     * @param ny - Scalar number
     */
    public void multiY(float ny){
        setY(this.getY() * ny);
    }


    /**
     * Divide our vector by another number - Which will reduce its size
     * @param n - Scalar (One value)
     */
    public void div(float n){
        setX(this.getX() / n);
        setY(this.getY() / n);
    }

    /**
     * Method to get the Magnitude of our vector
     * @return float number
     */
    public float mag(){
        float xsq = this.getX() * this.getX();
        float ysq = this.getY() * this.getY();
        return (float) Math.sqrt(xsq + ysq);
    }

    /**
     * This method will normalize our vector by dividing our X and Y with the magnitude.
     */
    public void normalize(){
        float m = mag();
        if (m != 0) {
            div(m);
        }
    }



    //#endregion

    //#region Non-Mathematical methods

    /**
     * Generate a random vector under a certain range
     * @param xRange - Most probably will be the Width
     * @param yRange - Most probably will be the Height
     * @return PVector
     */
    public static PVector generateRandomVector(float xRange, float yRange) {
        float x = (float) (Math.random()) * xRange;
        float y = (float) (Math.random()) * yRange;
        return new PVector(x, y);
    }


    /**
     * Method that will check if our vectors intersect
     * @param vector1 - Vector 1
     * @param vector2 - Vector 2
     * @return boolean true or false
     */
    public static boolean intersect(PVector vector1, PVector vector2) {
        return vector1.x == vector2.x && vector1.y == vector2.y;
    }

    /**
     * Method to check the intersection using a square
     * @param vector1 - Vector 1
     * @param size1 - Size will be used for width and height since it is a square
     * @param vector2 - Vector 2
     * @param size2 - Size will be used for width and height since it is a square
     * @return boolean true or false
     */
    public static boolean intersect(PVector vector1, float size1, PVector vector2, float size2) {
        float left1 = vector1.getX() -size1;
        float right1 = vector1.getX() + size1;
        float top1 = vector1.getY() -size1;
        float bottom1 = vector1.getY() + size1;

        float left2 = vector2.getX() - size2;
        float right2 = vector2.getX() + size2;
        float top2 = vector2.getY() - size2;
        float bottom2 = vector2.getY() + size2;

        return !(right1 < left2 || left1 > right2 || bottom1 < top2 || top1 > bottom2);
    }

    //#endregion

    //#region Getters And Setters

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    //#endregion

    //#region Override

    @Override
    public String toString() {
        return "PVector{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public PVector clone() throws CloneNotSupportedException
    {
        return (PVector) super.clone();
    }

    //#endregion

}
