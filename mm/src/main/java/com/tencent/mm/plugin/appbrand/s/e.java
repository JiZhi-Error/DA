package com.tencent.mm.plugin.appbrand.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.d;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Map;

public final class e {
    String csu;
    String jEY;
    Map<String, String> jEZ;
    boolean jFh = false;
    boolean jFi = false;
    byte[] mPostData;
    Runnable mRunnable = null;
    int mTimeout;
    String mUrl;
    boolean niA = true;
    d.a nir;
    ArrayList<String> nis;
    int nit = 15;
    String niu;
    HttpURLConnection niv;
    String niw;
    String nix;
    boolean niy = false;
    boolean niz = false;
    private long startTime;

    public e(String str, byte[] bArr, int i2, d.a aVar, String str2, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(144336);
        this.mUrl = str;
        this.mPostData = bArr;
        this.nir = aVar;
        this.mTimeout = i2;
        this.csu = str2;
        this.startTime = System.currentTimeMillis();
        this.jFh = z;
        this.jFi = z2;
        this.niz = z3;
        AppMethodBeat.o(144336);
    }

    public final int bPz() {
        AppMethodBeat.i(144337);
        int currentTimeMillis = (int) (System.currentTimeMillis() - this.startTime);
        AppMethodBeat.o(144337);
        return currentTimeMillis;
    }

    public final long getDataSize() {
        if (this.mPostData != null) {
            return (long) this.mPostData.length;
        }
        return 0;
    }
}
