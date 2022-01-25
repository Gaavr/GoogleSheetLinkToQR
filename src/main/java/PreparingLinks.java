import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PreparingLinks {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static String sheetLink;
    private static final String SHEET_CELL_PREFIX = "&range=";
    private static int numberOfList;
    private static String scopeStrings;

    static ArrayList<String> letters;
    static ArrayList<Integer> numbers;
    public static void main(String[] args) {
    }


    public static ArrayList<String> getLinksForRange() {
        String range = scopeStrings;

        letters = new ArrayList<>();
        numbers = new ArrayList<>();
        try {
            Pattern patternNumbers = Pattern.compile("[0-9]+");
            Matcher matcherNumbers = patternNumbers.matcher(range);
            while (matcherNumbers.find()) {
                numbers.add(Integer.parseInt(matcherNumbers.group()));
            }

            Pattern patternString = Pattern.compile("[a-zA-Z]+");
            Matcher matcherString = patternString.matcher(range);
            while (matcherString.find()) {
                letters.add(matcherString.group());
            }
        } catch (Exception e) {
            System.out.println("ОШИБКА ПРИ ВВОДЕ ДИАПАЗОНА!");
        }

        ArrayList<String> links = new ArrayList<>();
        for (int i = numbers.get(0); i < numbers.get(1); i++) {
            links.add(sheetLink + SHEET_CELL_PREFIX + letters.get(0) + i);
        }
        return links;
    }

    public static void getData() {
        try {
            System.out.println("Введите ссылку на таблицу (пример: https://docs.google.com/spreadsheets/d/1BxiMVs0XRA5n" +
                    "FMdKvBdBZjgmUUqptlbs74OgvE2upms/edit#gid=0 )");
            sheetLink = reader.readLine();
            System.out.println("Введите номер листа в таблице");
            numberOfList = Integer.parseInt(reader.readLine());
            System.out.println("Введите диапазон строк через дефис, указывая буквы ЛАТИНИЦЕЙ (пример: A1-22)");
            scopeStrings = reader.readLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
