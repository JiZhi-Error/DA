package com.tencent.mm.plugin.appbrand.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.g;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Map;

public final class h {
    public volatile boolean isRunning = false;
    String jEY;
    Map<String, String> jEZ;
    String mFileName;
    String mMimeType;
    String mName;
    int mTimeout;
    String mUrl;
    String niG;
    Map<String, String> niH;
    g.a niI;
    ArrayList<String> nis;
    int nit = 15;
    HttpURLConnection niv = null;
    String nix;
    private long startTime;

    h(String str, String str2, String str3, String str4, int i2, String str5, g.a aVar) {
        AppMethodBeat.i(144356);
        this.niG = str;
        this.mUrl = str2;
        this.niI = aVar;
        this.mName = str3;
        this.mFileName = str4;
        this.mTimeout = i2;
        this.mMimeType = str5;
        this.startTime = System.currentTimeMillis();
        AppMethodBeat.o(144356);
    }

    public final int bPz() {
        AppMethodBeat.i(144357);
        int currentTimeMillis = (int) (System.currentTimeMillis() - this.startTime);
        AppMethodBeat.o(144357);
        return currentTimeMillis;
    }
}
