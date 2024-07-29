package kala_verasat;

public class Electrical extends Kala {
    private Integer voltage;

    public Integer getVoltage() {
        return voltage;
    }

    public void setVoltage(Integer voltage) {
        this.voltage = voltage;
    }

    @Override
    public String toString() {
        return "Electrical{" +
                "voltage=" + voltage +
                '}';
    }
}
