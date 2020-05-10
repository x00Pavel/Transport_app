/**
 * File: ija/src/sample/Clock.java
 *
 * Author: Pavel Yadlouski (xyadlo00)
 *         Oleksii Korniienko (xkorni02)
 *
 * Date: 04.2020
 *
 * Description: Implementation of Clock object with its functionality.
 *              Clock object represents inner clock for program
 */


package src.sample;

import javafx.application.Platform;
import javafx.scene.control.TextField;

import java.util.Arrays;
import java.util.List;

public class Clock implements Runnable{

    private int speed;
    private int hours;
    private int minutes;
    private int seconds;
    private String hours_for_print;
    private String minutes_for_print;
    private String seconds_for_print;
    private final TextField clock_text;

    public Clock(int new_speed, TextField clock_){
        clock_text = clock_;
        speed = new_speed;
    }

    public void setSpeed(int s){
        speed = s;
    }

    public int getSpeed(){
        return speed;
    }

    @Override
    public void run() {
        while(true){
            seconds++;
            if(seconds == 60){
                minutes++;
                seconds = 0;
            }
            if(seconds < 10){
                seconds_for_print = "0" + seconds;
            }else{
                seconds_for_print = Integer.toString(seconds);
            }
            if(minutes == 60){
                hours++;
                minutes = 0;
            }
            if(minutes < 10){
                minutes_for_print = "0" + minutes;
            }else{
                minutes_for_print = Integer.toString(minutes);
            }
            if(hours == 24){
                hours = 0;
            }
            if(hours < 10){
                hours_for_print = "0" + Integer.toString(hours);
            }else{
                hours_for_print = Integer.toString(hours);
            }

            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    clock_text.setText(Clock.this.hours_for_print+":"+Clock.this.minutes_for_print+":"+Clock.this.seconds_for_print);
                }
            });

            // clock_text.setText(hours_for_print+":"+minutes_for_print+":"+seconds_for_print);
            System.out.println(this.hours_for_print+":"+this.minutes_for_print+":"+this.seconds_for_print);
            // System.out.println("Clock speed: "+this.speed);
            try {
                Thread.sleep(getSpeed());
            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//                System.out.println("Clock interupted");
                e.printStackTrace();
            }
        }
    }

    public List<Integer> getTime() {
        return Arrays.asList(hours, minutes, seconds);
    }

    public void setTime( int hour, int minute, int second){
        hours = hour;
        if(hours < 0 || hours > 24){
            System.out.println("[ERROR] Hours should be in interval 0->24");
            System.exit(-1);
        }
        minutes = minute;
        if(minutes < 0 || minutes > 60){
            System.out.println("[ERROR] Minutes should be in interval 0->60");
            System.exit(-1);
        }
        seconds = second;
        if(seconds < 0 || seconds > 60){
            System.out.println("[ERROR] Seconds should be in interval 0->60");
            System.exit(-1);
        }
    }
}
