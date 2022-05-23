package com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.TEST;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test2 {
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String timeStamp = dtf.format(now);
        System.out.println(timeStamp);
    }
}
