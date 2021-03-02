package com.tencent.mm.plugin.d.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class h {
    public static String phH = "00002902-0000-1000-8000-00805f9b34fb";
    public static String phI = "0000fee7-0000-1000-8000-00805f9b34fb";
    public static String phJ = "0000fec7-0000-1000-8000-00805f9b34fb";
    public static String phK = "0000fec8-0000-1000-8000-00805f9b34fb";
    public static String phL = "0000fea1-0000-1000-8000-00805f9b34fb";
    public static String phM = "0000fea2-0000-1000-8000-00805f9b34fb";
    public static String phN = "0000feb1-0000-1000-8000-00805f9b34fb";
    public static String phO = "0000feb2-0000-1000-8000-00805f9b34fb";
    public static String phP = "0000feb3-0000-1000-8000-00805f9b34fb";
    public static String phQ = "0000feb4-0000-1000-8000-00805f9b34fb";
    public static String phR = "0000181d-0000-1000-8000-00805f9b34fb";
    public static String phS = "00002a9e-0000-1000-8000-00805f9b34fb";
    public static String phT = "00002a9d-0000-1000-8000-00805f9b34fb";
    public static String phU = "0000180d-0000-1000-8000-00805f9b34fb";
    public static String phV = "00002a37-0000-1000-8000-00805f9b34fb";
    public static String phW = "00002a38-0000-1000-8000-00805f9b34fb";
    public static String phX = "00002a39-0000-1000-8000-00805f9b34fb";
    public static String phY = "00001810-0000-1000-8000-00805f9b34fb";
    public static String phZ = "00002a35-0000-1000-8000-00805f9b34fb";
    public static String pia = "00002a36-0000-1000-8000-00805f9b34fb";
    public static String pib = "00002a49-0000-1000-8000-00805f9b34fb";
    public static HashMap<String, String> pic;

    static {
        AppMethodBeat.i(22567);
        HashMap<String, String> hashMap = new HashMap<>();
        pic = hashMap;
        hashMap.put(phJ, "airsync send characteristic. permission: (write)");
        pic.put(phK, "airsync recv characteristic. permission: (indicate)");
        pic.put(phL, "simple step measurement characteristic. permission: ((read)(indicate|notify))");
        pic.put(phM, "airsync recv characteristic. permission: [(read)[write][indicate]]");
        AppMethodBeat.o(22567);
    }
}
