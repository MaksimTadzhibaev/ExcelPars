package month;

public class MonthP {
    public static String monthParse(String monthInfo) {
        int commaIndex = monthInfo.indexOf(",");
        Integer month = Integer.parseInt(monthInfo.substring(0, commaIndex))-1;
        String year = monthInfo.substring(commaIndex + 1);
        String period = "";

        for (Month monthEn : Month.values()) {
            if (month.equals(monthEn.ordinal())) {
                period = monthEn.name() + " " + year + " года";
                break;
            }
        }
        return period;
    }
    private enum Month {
        Январь, Февраль, Март, Апрель, Май, Июнь, Июль, Август, Сентябрь, Октябрь, Ноябрь, Декабрь
    }
}
