package com.tencent.mm.plugin.appbrand.appusage;

public final class AppBrandRecentTaskInfo extends LocalUsageInfo {
    public final String appName;
    public final long crj;
    public final int cyo;
    public final String dCl;
    public final int eix;
    public final String gLc;
    public final String kVo;
    public final boolean kVp;
    public final boolean kVq;
    public final boolean kVr;

    public AppBrandRecentTaskInfo(String str, String str2, String str3, String str4, String str5, String str6, int i2, int i3, int i4, long j2, long j3, boolean z, long j4, boolean z2, boolean z3, String str7, boolean z4) {
        super(str2, str3, i3, i4, str4, str5, str6, z, j2, j3, z3, str7);
        this.gLc = str;
        this.dCl = str2;
        this.appName = str4;
        this.kVo = str6;
        this.cyo = i2;
        this.eix = i3;
        this.kVp = z;
        this.crj = j4;
        this.kVq = z2;
        this.kVr = z4;
    }
}
