package com.tencent.youtu.ytagreflectlivecheck.worker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.HashMap;
import java.util.Iterator;

public class TimeCounter {
    private static String TAG = "TimeCounter";
    private static HashMap<String, TimeCounter> allMap;
    private float average = 0.0f;
    private long beginTime = 0;
    private int count = 0;
    private float last = 0.0f;
    private float max = 0.0f;
    private float min = 0.0f;
    private String name;
    private float sum = 0.0f;

    TimeCounter(String str) {
        this.name = str;
    }

    private static long getCurrentTime() {
        AppMethodBeat.i(43418);
        long currentTimeMillis = System.currentTimeMillis() * 1000;
        AppMethodBeat.o(43418);
        return currentTimeMillis;
    }

    public static TimeCounter ins(String str) {
        AppMethodBeat.i(43419);
        if (allMap == null) {
            allMap = new HashMap<>();
        }
        if (allMap.get(str) == null) {
            allMap.put(str, new TimeCounter(str));
        }
        TimeCounter timeCounter = allMap.get(str);
        AppMethodBeat.o(43419);
        return timeCounter;
    }

    public static void clearIns() {
        AppMethodBeat.i(43420);
        allMap.clear();
        allMap = null;
        AppMethodBeat.o(43420);
    }

    public static String printAll() {
        AppMethodBeat.i(43421);
        String str = "";
        Iterator<String> it = allMap.keySet().iterator();
        while (it.hasNext()) {
            str = str + "\n" + allMap.get(it.next()).print();
        }
        AppMethodBeat.o(43421);
        return str;
    }

    public void begin() {
        AppMethodBeat.i(43422);
        this.beginTime = getCurrentTime();
        AppMethodBeat.o(43422);
    }

    public void end() {
        AppMethodBeat.i(43423);
        end(true);
        AppMethodBeat.o(43423);
    }

    public void end(boolean z) {
        AppMethodBeat.i(43424);
        float currentTime = ((float) (getCurrentTime() - this.beginTime)) / 1000.0f;
        this.sum += currentTime;
        this.count++;
        this.average = this.sum / ((float) this.count);
        if (this.count == 1) {
            this.min = currentTime;
            this.max = currentTime;
        } else {
            if (currentTime < this.min) {
                this.min = currentTime;
            }
            if (currentTime > this.max) {
                this.max = currentTime;
            }
        }
        this.last = currentTime;
        if (z) {
            print();
        }
        AppMethodBeat.o(43424);
    }

    public void reset() {
        this.sum = 0.0f;
        this.average = 0.0f;
        this.min = 0.0f;
        this.max = 0.0f;
        this.last = 0.0f;
        this.beginTime = 0;
    }

    public String print() {
        AppMethodBeat.i(43425);
        String str = this.name + " count:" + this.count + " avg:" + this.average + "ms max:" + this.max + "ms min:" + this.min + "ms last:" + this.last + LocaleUtil.MALAY;
        AppMethodBeat.o(43425);
        return str;
    }
}
