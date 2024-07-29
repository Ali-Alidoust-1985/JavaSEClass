package biomedical;

public class ElectroSurgery extends TheraputicDevice {
    private int frequency;
    private int temperature;

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Electrosurgery{" +
                "frequency=" + frequency+"HZ" +
                ", temperature=" + temperature+ " Celsius Degree " +
                '}';
    }
}
