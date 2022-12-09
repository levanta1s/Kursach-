package depositclient.model;

public class Validator {

    public boolean validateInt(int number) {
        return number > 0;
    }

    public boolean validateString(String str) {
        int length = str.length();
        return length != 0 && length <= 20;
    }


    public boolean validateDate(String date) {
        if (date.length() == 10) {
            try {
                String year = date.charAt(0) + String.valueOf(date.charAt(1)) + date.charAt(2) + date.charAt(3);
                int yearInt = (int) Double.parseDouble(year);
                if (yearInt < 2000 || yearInt > 2022) {
                    return false;
                }

                String month = date.charAt(5) + String.valueOf(date.charAt(6));
                int monthInt = (int) Double.parseDouble(month);
                if (monthInt < 0 || monthInt > 12) {
                    return false;
                }

                String day = String.valueOf(date.charAt(8)) + date.charAt(9);
                int dayInt = (int) Double.parseDouble(day);
                return dayInt >= 0 && dayInt <= 31;
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }
}
