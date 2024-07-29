package kala_verasat;

public class Laptop extends Electrical{
    private String cpuType;
    private Integer ramLevel;
    private String model;

    public String getCpuType() {
        return cpuType;
    }

    public Integer getRamLevel() {
        return ramLevel;
    }

    public String getModel() {
        return model;
    }

    public void setCpuType(String cpuType) {
        this.cpuType = cpuType;
    }

    public void setRamLevel(Integer ramLevel) {
        this.ramLevel = ramLevel;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Labtob{" +
                "cpuType='" + cpuType + '\'' +
                ", ramLevel=" + ramLevel +
                ", model='" + model + '\'' +
                '}';
    }
}
