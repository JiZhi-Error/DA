package com.tencent.mm.plugin.wepkg.downloader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.g;

public final class f {
    public String JMA;
    public long JMB;
    boolean JMC;
    int JMD = g.sHCENCODEVIDEOTIMEOUT;
    int JME = g.sHCENCODEVIDEOTIMEOUT;
    boolean JMF = true;
    a JMG;
    public String JMH;
    String JMx;
    public String JMy;
    String JMz;
    String lAl;
    String mFilePath;
    public long mStartTime = System.currentTimeMillis();
    public String mUrl;
    public int qIG;
    int rxM = 3;

    public f(String str, int i2, String str2, String str3, String str4, String str5, String str6, String str7, long j2, String str8, boolean z, a aVar) {
        AppMethodBeat.i(110619);
        this.JMx = str;
        this.qIG = i2;
        this.JMy = str2;
        this.JMz = str3;
        this.JMA = str4;
        this.mUrl = str6;
        this.mFilePath = str7;
        this.JMB = j2;
        this.lAl = str8;
        this.JMC = z;
        this.JMG = aVar;
        this.JMH = str5;
        AppMethodBeat.o(110619);
    }
}
