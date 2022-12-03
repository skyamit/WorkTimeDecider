package services;

import model.Employee;
import model.OfficeTime;

public class TimeCalculator {

    public void calculate(Employee employee) {
        int totalMinuteIn12 = 720;
        OfficeTime inTime = employee.getInTime();
        OfficeTime outTime = employee.getOutTime();

        if(inTime.getMode().equals("AM") && outTime.getMode().equals("PM")){
            // 12 - AM + PM time
            int inMinute = inTime.getHour()*60 + inTime.getMinute();
            int outMinute = outTime.getHour()*60 + outTime.getMinute();
            int totalMinute = totalMinuteIn12 - inMinute + outMinute;
            apply30MinuteRule(totalMinute);
        }
        else if(inTime.getMode().equals("PM") && outTime.getMode().equals("PM")){
            // out time - inTime
            int inMinute = inTime.getHour()*60 + inTime.getMinute();
            int outMinute = outTime.getHour()*60 + outTime.getMinute();
            int totalMinute = outMinute - inMinute;
            apply30MinuteRule(totalMinute);
        }
        else if(inTime.getMode().equals("AM") && outTime.getMode().equals("AM")){
            // out time - inTime
            int inMinute = inTime.getHour()*60 + inTime.getMinute();
            int outMinute = outTime.getHour()*60 + outTime.getMinute();
            int totalMinute = outMinute - inMinute;
            System.out.println(" "+ inMinute+" "+outMinute+" "+totalMinute);
            apply30MinuteRule(totalMinute);
        }
        else{
            // 12 - PM + AM time
            int inMinute = inTime.getHour()*60 + inTime.getMinute();
            int outMinute = outTime.getHour()*60 + outTime.getMinute();
            int totalMinute = totalMinuteIn12 - inMinute + outMinute;
            apply30MinuteRule(totalMinute);
        }
    }

    public void apply30MinuteRule(int total) {
        int min = total%60;
        int hour = total/60;

        if(min < 30){
            hour--;
        }
        min = 30;

        System.out.println("Total Hour worked : "+hour+" Hours "+min +" Minutes");
    }
}
