package com.tencent.youtu.ytagreflectlivecheck.jni.model;

import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleRequester;
import java.util.ArrayList;

public class PersonLive {
    private String app_id = "";
    public String client_version;
    private String color_data;
    private ArrayList<FaceFrame> frames;
    private int platform;
    private ReflectColorData reflect_data;
    public LiveStyleRequester.SeleceData select_data;

    public ReflectColorData getReflect_data() {
        return this.reflect_data;
    }

    public void setReflect_data(ReflectColorData reflectColorData) {
        this.reflect_data = reflectColorData;
    }

    public String getColor_data() {
        return this.color_data;
    }

    public void setColor_data(String str) {
        this.color_data = str;
    }

    public int getPlatform() {
        return this.platform;
    }

    public void setPlatform(int i2) {
        this.platform = i2;
    }

    public ArrayList<FaceFrame> getFrames() {
        return this.frames;
    }

    public void setFrames(ArrayList<FaceFrame> arrayList) {
        this.frames = arrayList;
    }
}
