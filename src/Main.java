import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

//        String expression = ".contains(\"没有数据\")";
//        Pattern pattern = Pattern.compile("\\.contains\\(\"(.*?)\"\\)");
//        Matcher subString = pattern.matcher(expression);
//
//        List<String> params = new ArrayList<>(4);
//        while (subString.find()) {
//            String param = subString.group(1);
//            if (!params.contains(param)) {
//                params.add(param);
//            }
//        }
//        System.out.println(params);

        String expression2 = ">=80";
        Pattern pattern2 = Pattern.compile("\\d+");
        Matcher subString2 = pattern2.matcher(expression2);

        List<String> params2 = new ArrayList<>(4);
        while (subString2.find()) {
            String param = subString2.group(0);
            if (!params2.contains(param)) {
                params2.add(param);
            }
        }
        System.out.println(params2);
    }
}
