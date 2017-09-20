package edu.orangecoastcollege.cs273.phuynh101.paintestimator;

/**
 * Created by phuynh101 on 9/19/2017.
 */

/**
 * Display the main activity, update views
 */
public class InteriorRoom {
    private int mDoors;
    private int mWindows;
    private float mHeight;
    private float mWidth;
    private float mLength;

    /**
     * The area of doors
     */
    public static final float DOOR_AREA = 21;
    /**
     * The area of windows
     */
    public static final float WINDOW_AREA = 16;
    /**
     * The square feet per gallon
     */
    public static final float SQ_FEET_PER_GALLON = 275;

    /**
     * Default constructor
     */
    public InteriorRoom() {

    }

    /**
     * Get the number of doors
     * @return The number of doors
     */
    public int getDoors() {
        return mDoors;
    }

    /**
     * Set the number of doors
     * @param doors The number of doors
     */
    public void setDoors(int doors) {
        mDoors = doors;
    }

    /**
     * Get the number of windows
     * @return The number of windows
     */
    public int getWindows() {
        return mWindows;
    }

    /**
     * Set the number of windows
     * @param windows the number of windows
     */
    public void setWindows(int windows) {
        mWindows = windows;
    }

    /**
     * Get the height of the room
     * @return the height of the room
     */
    public float getHeight() {
        return mHeight;
    }

    /**
     * Set the height of the room
     * @param height
     */
    public void setHeight(float height) {
        mHeight = height;
    }

    /**
     * Get the width of the room
     * @return The width of the room
     */
    public float getWidth() {
        return mWidth;
    }

    /**
     * Set the width of the room
     * @param width The width
     */
    public void setWidth(float width) {
        mWidth = width;
    }

    /**
     * Get the length of the room
     * @return The length of the room
     */
    public float getLength() {
        return mLength;
    }

    /**
     * set the length of the room
     * @param length The length of the room
     */
    public void setLength(float length) {
        mLength = length;
    }

    /**
     * Calculate the area of doors and windows
     * @return The area of doors and windows
     */
    public float doorAndWindowArea()
    {
        return mDoors * DOOR_AREA + mWindows * WINDOW_AREA;
    }

    /**
     * Calculate the surface area of the wall
     * @return The surface area of the wall
     */
    public float wallSurfaceArea()
    {
        return 2 * mLength * mHeight + 2 * mWidth * mHeight + mLength * mWidth;
    }

    /**
     * Calculate the total surface area
     * @return The total surface area
     */
    public float totalSurfaceArea() {
        return wallSurfaceArea() - doorAndWindowArea();
    }

    /**
     * Calculate the gallons of paint required
     * @return The gallons of paint required
     */
    public float gallonsOfPaintRequired()
    {
        return totalSurfaceArea() / SQ_FEET_PER_GALLON;
    }

}
