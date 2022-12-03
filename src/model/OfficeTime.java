package model;

public class OfficeTime {
    private int hour;
    private int minute;
    private String mode;
    public OfficeTime(String input){
         this.hour = Integer.parseInt(input.substring(0,2));
         this.minute = Integer.parseInt(input.substring(3,5));
         this.mode = input.substring(6,8);
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    @Override
    public String toString() {
        return "OfficeTime{" +
                "hour=" + hour +
                ", minute=" + minute +
                ", mode='" + mode + '\'' +
                '}';
    }
}
