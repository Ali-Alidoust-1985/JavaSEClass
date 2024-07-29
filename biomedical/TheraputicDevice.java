package biomedical;

public class TheraputicDevice extends BioDevice{
    private String application;
    private String technology;
    private String output;

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    @Override
    public String toString() {
        return "TheraputicDevice{" +
                "application='" + application + '\'' +
                ", technology='" + technology + '\'' +
                ", output='" + output + '\'' +
                '}';
    }
}
