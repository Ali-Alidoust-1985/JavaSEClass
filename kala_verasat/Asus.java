package kala_verasat;

public class Asus {
        private Integer batteryLevel;

        public Integer getBatteryLevel() {
            return batteryLevel;
        }

        public void setBatteryLevel(Integer batteryLevel) {
            this.batteryLevel = batteryLevel;
        }

        @Override
        public String toString() {
            return "Asus{" +
                    "batteryLevel=" + batteryLevel +
                    '}';
        }
}
