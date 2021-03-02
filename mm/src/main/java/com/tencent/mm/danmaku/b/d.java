package com.tencent.mm.danmaku.b;

import com.tencent.mm.danmaku.c.a;
import com.tencent.mm.danmaku.c.i;
import com.tencent.mm.danmaku.e.e;

public abstract class d<DATA, CONFIG extends i> extends a<DATA, CONFIG> {
    private float[] gPi = null;
    public float gPj;
    public float mLeft = 0.0f;
    public float mTop = -1.0f;

    public d(a aVar) {
        super(aVar);
    }

    @Override // com.tencent.mm.danmaku.b.a
    public final float asv() {
        return -this.gPj;
    }

    @Override // com.tencent.mm.danmaku.b.a
    public final void asy() {
        super.asy();
        this.gPj = ((float) ((int) (((float) a.asO().mScreenWidth) + this.gOP))) / ((float) this.gOL.mValue);
    }

    @Override // com.tencent.mm.danmaku.b.a
    public final void a(float f2, long j2, long j3) {
        if (!yY(j2)) {
            e.d("BaseDanmaku", "onLayout, Y = " + f2 + ", danmaku = " + toString());
            this.mLeft = zf(j3);
            if (!isShown()) {
                this.mTop = f2;
                setVisibility(true);
                return;
            }
            return;
        }
        setVisibility(false);
    }

    @Override // com.tencent.mm.danmaku.b.a
    public final void zb(long j2) {
        this.mLeft = zf(j2);
    }

    private float zf(long j2) {
        return ((float) a.asO().mScreenWidth) - (((float) (j2 - this.gOK)) * this.gPj);
    }

    @Override // com.tencent.mm.danmaku.b.a
    public final float[] zc(long j2) {
        if (!asx()) {
            return null;
        }
        float zf = zf(j2);
        if (this.gPi == null) {
            this.gPi = new float[4];
        }
        this.gPi[0] = zf - a.asO().gPK;
        this.gPi[1] = this.mTop;
        this.gPi[2] = zf + this.gOP + this.gOR;
        this.gPi[3] = this.mTop + this.gOQ;
        return this.gPi;
    }

    @Override // com.tencent.mm.danmaku.b.a
    public final float[] zd(long j2) {
        if (!asx()) {
            return null;
        }
        float zf = zf(j2);
        if (this.gPi == null) {
            this.gPi = new float[4];
        }
        this.gPi[0] = zf;
        this.gPi[1] = this.mTop;
        this.gPi[2] = zf + this.gOP;
        this.gPi[3] = this.mTop + this.gOQ;
        return this.gPi;
    }

    @Override // com.tencent.mm.danmaku.b.a
    public final float getLeft() {
        return this.mLeft;
    }

    @Override // com.tencent.mm.danmaku.b.a
    public final float getTop() {
        return this.mTop;
    }

    @Override // com.tencent.mm.danmaku.b.a
    public final float getRight() {
        return this.mLeft + this.gOP;
    }

    @Override // com.tencent.mm.danmaku.b.a
    public final float getBottom() {
        return this.mTop + this.gOQ;
    }
}
