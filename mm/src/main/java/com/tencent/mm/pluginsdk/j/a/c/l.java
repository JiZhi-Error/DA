package com.tencent.mm.pluginsdk.j.a.c;

import com.tencent.mm.hardcoder.g;
import com.tencent.mm.pluginsdk.j.a.c.f;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class l implements f.b {
    final int JYA;
    public final String JYs;
    private final String JZK;
    protected final Map<String, String> JZZ = new HashMap();
    protected volatile int Kaa = 15000;
    protected volatile int connectTimeout = 15000;
    private final String filePath;
    private final String groupId;
    private final String method;
    final int networkType;
    final int priority;
    protected volatile int readTimeout = g.sHCENCODEVIDEOTIMEOUT;
    public final String url;

    public l(String str, String str2, String str3, String str4, String str5, String str6, int i2, int i3, int i4) {
        this.JYs = str;
        this.filePath = str2;
        this.JZK = str3;
        this.groupId = str4;
        this.url = str5;
        this.method = str6;
        this.JYA = i2;
        this.networkType = i3;
        this.priority = Math.max(i4, 0);
    }

    public boolean gnI() {
        return false;
    }

    public String avy() {
        return this.groupId;
    }

    public String getFilePath() {
        return this.filePath;
    }

    @Override // com.tencent.mm.pluginsdk.j.a.c.f.b
    public final String gnA() {
        return this.JYs;
    }

    public final String getURL() {
        return this.url;
    }

    public final Map<String, String> getRequestHeaders() {
        if (this.JZZ.size() == 0) {
            return null;
        }
        return Collections.unmodifiableMap(this.JZZ);
    }

    public final void setConnectTimeout(int i2) {
        this.connectTimeout = i2;
    }

    public final int getConnectTimeout() {
        return this.connectTimeout;
    }

    public final void setReadTimeout(int i2) {
        this.readTimeout = i2;
    }

    public final int getReadTimeout() {
        return this.readTimeout;
    }

    public final int gnW() {
        return this.Kaa;
    }
}
