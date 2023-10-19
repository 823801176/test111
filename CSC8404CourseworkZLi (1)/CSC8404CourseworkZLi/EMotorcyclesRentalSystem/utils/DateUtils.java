package EMotorcyclesRentalSystem.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    public static int getYear(int i) {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }
    
    public static Date getCurrentDate() {
        return Calendar.getInstance().getTime();
    }

    public static int getAge(Date birthDate) {
        if (birthDate == null) {
            throw new IllegalArgumentException("The birthDate is required");
        }

        Calendar today = Calendar.getInstance();
        Calendar birth = Calendar.getInstance();

        birth.setTime(birthDate);

        int age = today.get(Calendar.YEAR) - birth.get(Calendar.YEAR);

        if (today.get(Calendar.MONTH) < birth.get(Calendar.MONTH) ||
            (today.get(Calendar.MONTH) == birth.get(Calendar.MONTH) && today.get(Calendar.DAY_OF_MONTH) < birth.get(Calendar.DAY_OF_MONTH))) {
            age--;
        }

        return age;
    }

    public static int getDifferenceInYears(Date startDate, Date endDate) {
        Calendar start = Calendar.getInstance();
        start.setTime(startDate);
        Calendar end = Calendar.getInstance();
        end.setTime(endDate);

        int diff = end.get(Calendar.YEAR) - start.get(Calendar.YEAR);
        if (end.get(Calendar.MONTH) < start.get(Calendar.MONTH) ||
            (end.get(Calendar.MONTH) == start.get(Calendar.MONTH) && end.get(Calendar.DATE) < start.get(Calendar.DATE))) {
            diff--;
        }
        return diff;
    }
}
