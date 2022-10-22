package practise;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] students = {"Radiushyn", "Vera Terletskaya", "Dima", "Kapusta", "Bogdan(HedgehogOfFate)",
                "Ivan(DinnerboneMI)", "Crybaby", "dani4feed", "Tim(kievthenics)", "Taras", "pavlo", "daddy shatokhin",
                "Kirill(wojak17)", "Wongayas", "Nazik ravliuk", "Ivan Ovchar", "Denis bald", "Hanna(HAAsedo)",
                "Denis Patlatyy", "Gleb Pasevich", "sssss", "Katherine", "Timur", "Kr.Nikita", "Anya(annakutova)",
                "Roman Nevmerzhytskyi", "Sasha solopenko", "Artem shymko", "Alyona Popova", "Misha", "Kirill(k_realll)",
                "Mik(miiixerrr)", "Anya Terletskaya", "Ksysha"};
        List<String> list = new java.util.ArrayList<>(Arrays.stream(students).toList());
        LinkedList<String> result = new LinkedList<>();
        Random rand = new Random();
        int number;
        for(int i = 0; i < students.length; i++) {
            number = rand.nextInt(list.size());
            result.add(list.get(number));
            list.remove(number);
        }

        for(int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
