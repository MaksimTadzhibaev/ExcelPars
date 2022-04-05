package inter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Obj> bool = new ArrayList<>();
        bool.add(new Obj(true, 1));
        bool.add(new Obj(true, 1));
        bool.add(new Obj(false, 1));
        bool.add(new Obj(true, 1));
        List <String> inta = (bool.stream().map(x->{String an = (x.b) ? "да" : "нет";
            return an;
        }).collect(Collectors.toList()));
        System.out.println(inta);

    }
    static class Obj {
        boolean b;
        int a;

        public Obj(boolean b, int a) {
            this.b = b;
            this.a = a;
        }
    }

//    List<Integer> listCheck = oracleRepositoryForm102Vs401.getForm102vs401Info(quarterInfo, areCountriesLoaded).stream()
//            .map(x -> {Integer i = (x.isChecked()) ? 1 : 0; return i;}).collect(Collectors.toList());

//        context.putVar("listCheck", listCheck);
}
