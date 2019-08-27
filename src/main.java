import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {
//        new Thread(() -> System.out.println("Printing from a runnable!")).start();

        Runnable runnable = () -> {
            String myString = "Lest's split this up into an array";
            String[] parts = myString.split(" ");
            Arrays.stream(parts).forEach(System.out::println);
        };

        Function<String, String> fc = s -> {
            StringBuilder returnValue = new StringBuilder();
            for(int i=0; i<s.length(); i++) {
                if(i % 2 == 1) {
                    returnValue.append(s.charAt(i));
                }
            }
            return returnValue.toString();
        };

        String str = "1234567890";
        String result = fc.apply(str);
      // System.out.println(result);

        System.out.println(applyFc(fc, str));

        Supplier<String> iLoveJava = () -> "I love java";
        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);

        List<String> topNames = Arrays.asList(
                "amelia",
                "Olivia",
                "emily",
                "isla",
                "Ava",
                "olivier",
                "jack",
                "charlie",
                "harry",
                "jacob"
        );

//        topNames.stream().map(s -> s.substring(0,1).toUpperCase().concat(s.substring(1,s.length()))
//        ).sorted().forEach(System.out::println);

        topNames.stream()
                .map(s -> s.substring(0,1).toUpperCase().concat(s.substring(1)))
                .peek(System.out::println)
                .collect(Collectors.toList());

        long i = topNames.stream().map(s -> s.substring(0,1).toUpperCase().concat(s.substring(1,s.length()))
        ).filter(s -> s.startsWith("A")).count();
        System.out.println("number of names starting with A: " + i);
    }

    public static String applyFc(Function<String, String> fc, String str) {
        return  fc.apply(str);
    }

}
