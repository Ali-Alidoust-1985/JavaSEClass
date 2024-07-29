package biomedical;

public class BioDevice {


        private String name;
        private int serialNum;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSerialNum() {
            return serialNum;
        }

        public void setSerialNum(int serialNum) {
            this.serialNum = serialNum;
        }

        @Override
        public String toString() {
            return "BioDevice{" +
                    "name='" + name + '\'' +
                    ", serialNum=" + serialNum +
                    '}';
        }
}
