package com.tencent.mm.plugin.appbrand.keylogger.base;

public class e implements a, d {
    private final String HP;
    private final String mDesc;
    private final String mName;
    private final boolean mPA;
    private final int mPB;
    private final int mPC;
    private final String mProcessName;
    private final boolean mPz;
    private final int mType;

    public e(String str, String str2, boolean z, boolean z2, String str3, int i2, int i3, int i4, String str4) {
        this.mProcessName = str;
        this.mName = str2;
        this.mPz = z;
        this.mPA = z2;
        this.mDesc = str3;
        this.mType = i2;
        this.mPB = i3;
        this.mPC = i4;
        this.HP = str4;
    }

    @Override // com.tencent.mm.plugin.appbrand.keylogger.base.a
    public final String bMU() {
        return this.mProcessName;
    }

    @Override // com.tencent.mm.plugin.appbrand.keylogger.base.a
    public final String name() {
        return this.mName;
    }

    @Override // com.tencent.mm.plugin.appbrand.keylogger.base.a
    public final boolean bMV() {
        return this.mPz;
    }

    @Override // com.tencent.mm.plugin.appbrand.keylogger.base.a
    public final boolean FI() {
        return this.mPA;
    }

    @Override // com.tencent.mm.plugin.appbrand.keylogger.base.a
    public final String bMW() {
        return this.mDesc;
    }

    @Override // com.tencent.mm.plugin.appbrand.keylogger.base.d
    public final String category() {
        return this.HP;
    }

    @Override // com.tencent.mm.plugin.appbrand.keylogger.base.d
    public final int getType() {
        return this.mType;
    }

    @Override // com.tencent.mm.plugin.appbrand.keylogger.base.d
    public final int bMY() {
        return this.mPC;
    }

    @Override // com.tencent.mm.plugin.appbrand.keylogger.base.d
    public final int bMZ() {
        return this.mPB;
    }
}
