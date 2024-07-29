package biomedical;

public class RadiographyDevice extends DiagnisisDevice {

    private int kV;
    private int mA;
    private int dose;
    private Boolean xRay;

    public int getkV() {
        return kV;
    }

    public void setkV(int kV) {
        this.kV = kV;
    }

    public int getmA() {
        return mA;
    }

    public void setmA(int mA) {
        this.mA = mA;
    }

    public int getDose() {
        return dose;
    }

    public void setDose(int dose) {
        this.dose = dose;
    }

    public Boolean getxRay() {
        return xRay;
    }

    public void setxRay(Boolean xRay) {
        this.xRay = xRay;
    }

    @Override
    public String toString() {
        return "RadiographyDevice{" +
                "kV=" + kV +
                ", mA=" + mA +
                ", dose=" + dose +
                ", xRay=" + xRay +
                '}';
    }
}
