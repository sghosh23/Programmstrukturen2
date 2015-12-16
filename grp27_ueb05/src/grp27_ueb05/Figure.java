package grp27_ueb05;

/**
 *
 * @author Robin
 */
public class Figure {

    protected Color color;
    protected final static double EPSILON = 0.001;

    /**
     * creates an object of type figure and sets the color value
     *
     * @param color
     */
    Figure(Color color) {
        this.color = color;
    }

    /**
     * creates an object of type figure (standard constructor)
     */
    Figure() {
        this.color = null;
    }

    /**
     * gives back the area of the figure
     *
     * @return
     */
    public double getArea() {

        return 0;
    }

    /**
     * gives back the perimeter of the figure
     *
     * @return 0
     */
    public double getPerimeter() {

        return 0;
    }

    /**
     * compares the instance of figure that calls this methods with the input
     * figure by the area
     *
     * @param inputFigure an object from type Figure
     * @return -1 if input figure is bigger, 0 if both figures have same size, 1
     * if input figure is smaller
     */
    public int compare(Figure inputFigure) {

        if (this.getArea() > inputFigure.getArea()) {
            return 1;
        } else if (Math.abs(this.getArea() - inputFigure.getArea()) < EPSILON) {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * gives back a string 
     * @return 
     */
    @Override
    public String toString() {
        return String.format("Umfang: %6.2f, Fläche: %7.2f\n", getPerimeter(), getArea());
    }
}
