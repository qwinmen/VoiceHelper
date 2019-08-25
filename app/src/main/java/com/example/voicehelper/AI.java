package com.example.voicehelper;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class AI {
    public static String getAnswer(String input) {
        String str = input.toLowerCase();
        ArrayList<String> answers = new ArrayList<String>();

        if(str.equals("hello"))
            answers.add("Wassup!");

        if(str.contains("help"))
            answers.add("Empty help :(");

        if(str.contains("get time") || str.contains("current time")) {
            SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss", new Locale("ru"));
            answers.add(time.format(new Date()));
        }

        if(str.contains("get day") || str.contains("current day")) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd:MM:YYYY", new Locale("en"));
            answers.add(simpleDateFormat.format(new Date()));
        }

        if(answers.size() > 0)
        {
            //String.join(",", answers);
            return Join(",", answers);
        }

        return "Lol AI";
    }

    private static String Join(String splitter, ArrayList<String> strings){
        String result = "";
        for (int i = 0; i < strings.size(); i++) {
            result += strings.get(i) + splitter;
        }
        return result.substring(0, result.lastIndexOf(splitter));
    }
}
