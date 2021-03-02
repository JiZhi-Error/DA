package com.tencent.mm.plugin.exdevice.c;

import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.exdevice.f.e;

public abstract class c {
    public long pkb = -1;
    public short rxx = -1;
    public e rxy = null;
    protected a rxz = null;

    public abstract short cKg();

    public abstract short cKh();

    public abstract byte[] cKi();

    /* access modifiers changed from: protected */
    public final e aQ(int i2, String str) {
        this.rxy = new e();
        this.rxy.rBL = i2;
        this.rxy.rBM = str;
        return this.rxy;
    }
}
