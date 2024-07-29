package kala_verasat;

public class notElectrical extends Kala {
    private Integer weight;

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "notElectrical{" +
                "weight=" + weight +
                '}';
    }
}
