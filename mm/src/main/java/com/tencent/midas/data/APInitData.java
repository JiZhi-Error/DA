package com.tencent.midas.data;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class APInitData {
    private static APInitData gInstance = null;
    private static int initdataCount = 0;
    private String initGUID = "";
    private long initInterfaceTime = 0;

    private APInitData() {
        initdataCount = 0;
        this.initInterfaceTime = 0;
        this.initGUID = "";
    }

    public static APInitData singleton() {
        AppMethodBeat.i(193000);
        if (gInstance == null) {
            gInstance = new APInitData();
        }
        APInitData aPInitData = gInstance;
        AppMethodBeat.o(193000);
        return aPInitData;
    }

    public static void init() {
        AppMethodBeat.i(193001);
        gInstance = new APInitData();
        AppMethodBeat.o(193001);
    }

    public long getInitInterfaceTime() {
        return this.initInterfaceTime;
    }

    public void setInitInterfaceTime(long j2) {
        this.initInterfaceTime = j2;
    }

    public String getInitGUID() {
        return this.initGUID;
    }

    public void setInitGUID(String str) {
        this.initGUID = str;
    }

    public static int getInitdataCount() {
        int i2 = initdataCount;
        initdataCount = i2 + 1;
        return i2;
    }

    public static void setInitdataCount(int i2) {
        initdataCount = i2;
    }
}
