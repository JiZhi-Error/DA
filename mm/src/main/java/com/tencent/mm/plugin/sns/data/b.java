package com.tencent.mm.plugin.sns.data;

public final class b {
    public String dJX;
    public boolean isAd = false;
    public int jkU;
    public int scene;
    public String userName;

    public b(boolean z, String str, String str2, int i2) {
        this.isAd = z;
        this.userName = str;
        this.dJX = str2;
        this.scene = i2;
        this.jkU = -1;
    }

    public b(boolean z, String str, String str2, int i2, int i3) {
        this.isAd = z;
        this.userName = str;
        this.dJX = str2;
        this.scene = i2;
        this.jkU = i3;
    }
}
