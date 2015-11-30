package com.javahelps.navigationdrawer;

import android.util.Log;
import android.widget.Button;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public enum ButtonValue {

    SAMSUNG_CHANNEL1,
    SAMSUNG_CHANNEL2,
    SAMSUNG_CHANNEL3,
    SAMSUNG_CHANNEL4,
    SAMSUNG_CHANNEL5,
    SAMSUNG_CHANNEL6,
    SAMSUNG_CHANNEL7,
    SAMSUNG_CHANNEL8,
    SAMSUNG_CHANNEL9,
    SAMSUNG_CHANNEL0,
    SAMSUNG_POWER,
    SAMSUNG_ENTER,
    SAMSUNG_CHANNELUP,
    SAMSUNG_CHANNELDOWN,
    SAMSUNG_VOLUMEUP,
    SAMSUNG_VOLUMEDOWN,
    SAMSUNG_MENU,
    SAMSUNG_UP,
    SAMSUNG_DOWN,
    SAMSUNG_LEFT,
    SAMSUNG_RIGHT,
    SAMSUNG_MUTE,
    SAMSUNG_INDEX,
    SAMSUNG_CAPTION,
    SAMSUNG_AUDIO,
    SAMSUNG_LINEIN,
    SAMSUNG_EXIT,
    SAMSUNG_100,
    SAMSUNG_PROG,
    SAMSUNG_THEME,
    SAMSUNG_GUIDE,
    SAMSUNG_INFO;

    public String getProperty(String keyOrCode) {
        Properties prop = new Properties();
        try {
            InputStream in = ButtonValue.class.getClassLoader().getResourceAsStream("buttons.properties");
            prop.load(in);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop.getProperty(this.name() + "." + keyOrCode);
    }

    public String getCode() {
        return getProperty("CODE");
    }

    public String getKey() {
        return getProperty("KEY");
    }

}
