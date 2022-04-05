package ru.tadzh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("П3+П4", "А5+А6", "П1", "А3");
//        System.out.println(getFormType("32"));
        System.out.println(getFullNameIndicator(new ArrayList<String>(Collections.singleton("А5+А6"))));
    }

    public static String getFormType(String codeIndicator) {
        String formType = ""; // тип определяемой формы 0409501 или 0409603
        List<String> list501 = new ArrayList(); //храним список показателей 501 формы
        List<String> list603 = new ArrayList(); //храним список показателей 603 формы
        for (IndexReference index : getIndexReference()) { //распределяем существующие показатели по двум листам
            if (index.getNameIndicator().indexOf("501") >= 0) {
                list501.add(index.toString());
            } else list603.add(index.toString());
        }

        for (String type : list501) {
            if (type.indexOf(codeIndicator) >= 0) {
                return formType = "501";
            }
        }

        for (String type : list603) {
            if (type.indexOf(codeIndicator) >= 0) {
                return formType = "603";
            }
        }
        System.out.println("косяк");
        return "0";
    }

    public static List<IndexReference> getIndexReference() {
        List<IndexReference> list = new ArrayList<>();
        list.add(new IndexReference("А5А6", "А5+А6 - Срочные, сберегательные депозиты и ссуды (непросроченные), 501 – Раздел I"));
        list.add(new IndexReference("П3П4","П3+П4 - Срочные, сберегательные депозиты и ссуды (непросроченные), 501 – Раздел II"));
        list.add(new IndexReference("П1","П1 - Остатки на корреспондентских счетах и депозиты до востребования, 603 - Пассивы"));
        list.add(new IndexReference("А3","А3 - Остатки на корреспондентских счетах и депозиты до востребования , 603 - Активы"));
        return list;
    }

    public static String getFullNameIndicator(List<String> codeIndicator) {
        String fullNameIndicators = "";
        for (int i = 0; i < codeIndicator.size(); i++) {
            for (IndexReference index : getIndexReference()) {
                if (index.getNumIndicator().equals(codeIndicator.get(i).replace("+", ""))) {
                    fullNameIndicators += index.getNameIndicator() + "\n";
                }
            }
        }
        return fullNameIndicators;
    }

//    String codeStr = codeIndicator.toString().replace("[", "('").replace("]", "')")
//            .replace("+", "").replace(", ", "','");
//String queryString =
//        "select check_flg, " +
//                "ind_nm, " +
//                "reg_no, " +
//                "co_nm, " +
//                "nr_country_cd, " +
//                "bal_401_beg_amt, " +
//                "bal_501_603_beg_amt, " +
//                "delta_beg_amt, " +
//                "bal_401_end_amt, " +
//                "bal_501_603_end_amt, " +
//                "delta_end_amt, " +
//                "dsc, " +
//                "color_cd " +
//                "from table(dev_dm_bs_data.pkg_control_401vs501603_ui.f_tCompare401vs501603(" + monthInfo + ", DEV_DM_BS_DATA.T_SPARAMETER_TABLE" + codeStr + "))";
//        return jdbcTemplate.query(queryString, new CompareForm401vs501and603Mapper());
}
