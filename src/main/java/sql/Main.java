package sql;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> arrayIndex  = Arrays.asList("П3+П4","А5+А6","П1","А3");
        System.out.println(arrayIndex.toString().replaceAll("[\\[\\]]", ""));
//        System.out.println(arrayIndex);
//        String str = arrayIndex.toString()
//                .replace("[", "'")
//                .replace("]", "'")
//                .replace("+", "")
//                .replace(", ", "','");
//
////        str = str.replace("[", "'");
////        str = str.replace("]", "'");
////        str = str.replace("+", "");
////        str = str.replace(", ", "','");
//        System.out.println(str);

                //убрал
//        @Autowired
//        private ApplicationConfiguration applicationConfiguration;
//        Connection con = applicationConfiguration.oracleDataSource().getConnection();
//        oracle.jdbc.OracleConnection oraConn =  con.unwrap(oracle.jdbc.OracleConnection.class);
//        oracle.sql.ARRAY arr = oraConn.createARRAY("DEV_DM_BS_DATA.T_SPARAMETER_TABLE", arrayIndex);
    }
}
