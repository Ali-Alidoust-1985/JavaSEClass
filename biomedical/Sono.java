package biomedical;

public class Sono extends DiagnisisDevice {
    private boolean xRay;
    private int dimension;
    private boolean colour;

    public boolean isxRay() {
        return xRay;
    }

    public void setxRay(boolean xRay) {
        this.xRay = xRay;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public boolean isColour() {
        return colour;
    }

    public void setColour(boolean colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Sono{" +
                "xRay=" + xRay + " "+
                "dimension=" + dimension+"D" +
                ", colour=" + colour +
                '}';
    }
}
