package com.tencent.mm.audio.b;

public abstract class f {
    protected a dzD;
    protected int dzZ = 0;
    protected int dzk = -123456789;
    protected boolean mIsPause = false;

    public interface a {
        void d(int i2, byte[] bArr);
    }

    public abstract boolean aai();

    public abstract void de(boolean z);

    public abstract void stopRecord();

    public final void a(a aVar) {
        this.dzD = aVar;
    }

    public final void jl(int i2) {
        this.dzk = i2;
    }

    public final int aal() {
        return this.dzZ;
    }
}
