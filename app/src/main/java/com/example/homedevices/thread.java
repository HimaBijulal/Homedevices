package com.example.homedevices;

import java.io.Serializable;

public class thread implements Runnable, Serializable {
    Appliance a;
    thread(Appliance appliance){
        a = appliance;
    }

    public void run() {
        while(a.isPlugged()){
            a.incCounter();
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
