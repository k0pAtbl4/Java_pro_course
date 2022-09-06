package lesson16;

import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringWorker {
    public String str;
    public HashMap<String, Integer> data;

    public StringWorker(String str) {
        this.str = str;
        data = new HashMap<>();
    }

    public void wordCount() {
        String[] words = new String[0];
        String copy = str;
        if(copy != null) {
            copy = copy.replace(", ", " ").replace(". ", " ");
            words = copy.split(" ");
        }
        for (int i = 0; i < words.length; i++) {
            if (data.containsKey(words[i])) {
                int count = data.get(words[i]) + 1;
                data.put(words[i], count);
            } else {
                data.put(words[i], 1);
            }
        }
    }

    public void symbolChange(int index, char symbol) {
        String[] words = new String[0];
        Pattern pat;
        Matcher mat;
        if(str != null) {
            words = str.split(" ");
        }
        for(int i = 0; i < words.length; i++) {
            pat = Pattern.compile(words[i]);
            mat = pat.matcher(str);
            char[] temp = str.toCharArray();
            while(mat.find()) {
                if (mat.start() + index < temp.length) {
                    temp[mat.start() + index] = symbol;
                    str = "";
                    for (int k = 0; k < temp.length; k++) {
                        str += temp[k];
                    }
                }
            }
        }
    }

    public void sameSymbolEndStart() {
        Pattern pat = Pattern.compile("[ !,.]");
        String[] array = pat.split(str);
        for(int i = 0; i < array.length; i++) {
            char[] temp = array[i].toCharArray();
            if(temp.length > 0) {
                if (temp[0] == temp[temp.length - 1]) {
                    System.out.print(array[i] + " ");
                }
            }
        }
    }

    public int punctuationMarksCount() {
        Pattern pat = Pattern.compile("[!,.?:]");
        Matcher mat = pat.matcher(str);
        int count = 0;
        while(mat.find()) {
            count++;
        }
        return count;
    }

    public void printString() {
        System.out.println(str);
    }

    @Override
    public String toString() {
        return data.toString();
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
