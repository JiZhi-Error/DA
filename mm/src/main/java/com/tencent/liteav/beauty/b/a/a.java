package com.tencent.liteav.beauty.b.a;

import android.opengl.GLES20;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.b.b;
import com.tencent.liteav.beauty.b.h;
import com.tencent.liteav.beauty.b.q;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class a extends b {
    private int A = 0;
    private float B = 1.0f;
    private final float C = 0.7f;
    private float D = 0.8f;
    private float E = 2.0f;
    private int F = 0;
    private int G = 0;
    private int H = 0;
    private int I = 0;
    private c r = null;
    private d s = null;
    private e t = null;
    private h u = null;
    private q v = null;
    private b w = null;
    private String x = "TXCBeauty2Filter";
    private int y = 0;
    private int z = 0;

    @Override // com.tencent.liteav.beauty.b.b
    public boolean c(int i2, int i3) {
        AppMethodBeat.i(14981);
        boolean d2 = d(i2, i3);
        AppMethodBeat.o(14981);
        return d2;
    }

    @Override // com.tencent.liteav.basic.c.h
    public void a(int i2, int i3) {
        AppMethodBeat.i(14982);
        if (this.f304e == i2 && this.f305f == i3) {
            AppMethodBeat.o(14982);
            return;
        }
        this.f304e = i2;
        this.f305f = i3;
        d(i2, i3);
        AppMethodBeat.o(14982);
    }

    @Override // com.tencent.liteav.beauty.b.b
    public void c(int i2) {
        AppMethodBeat.i(14983);
        if (this.t != null) {
            this.t.a(((float) i2) / 10.0f);
        }
        this.y = i2;
        g(i2);
        AppMethodBeat.o(14983);
    }

    @Override // com.tencent.liteav.beauty.b.b
    public void d(int i2) {
        AppMethodBeat.i(14984);
        if (this.w != null) {
            this.w.a(((float) i2) / 10.0f);
        }
        this.z = i2;
        AppMethodBeat.o(14984);
    }

    @Override // com.tencent.liteav.beauty.b.b
    public void e(int i2) {
        AppMethodBeat.i(14985);
        if (this.w != null) {
            this.w.b(((float) i2) / 10.0f);
        }
        this.A = i2;
        AppMethodBeat.o(14985);
    }

    private void g(int i2) {
        AppMethodBeat.i(14986);
        this.B = 1.0f - (((float) i2) / 50.0f);
        if (this.u != null) {
            this.u.a(this.B);
        }
        AppMethodBeat.o(14986);
    }

    @Override // com.tencent.liteav.beauty.b.b
    public void f(int i2) {
        AppMethodBeat.i(14987);
        float f2 = 0.7f + (((float) i2) / 12.0f);
        if (((double) Math.abs(this.D - f2)) < 0.001d) {
            AppMethodBeat.o(14987);
            return;
        }
        this.D = f2;
        TXCLog.i(this.x, "set mSharpenLevel ".concat(String.valueOf(i2)));
        if (this.v != null) {
            this.v.a(this.D);
        }
        AppMethodBeat.o(14987);
    }

    @Override // com.tencent.liteav.basic.c.h
    public int b(int i2) {
        AppMethodBeat.i(14988);
        if (1.0f != this.E) {
            GLES20.glViewport(0, 0, this.H, this.I);
        }
        int c2 = this.t.c(this.s.b(i2), i2);
        if (1.0f != this.E) {
            GLES20.glViewport(0, 0, this.F, this.G);
        }
        if (this.D > 0.7f) {
            c2 = this.v.b(c2);
        }
        int c3 = this.w.c(c2, i2);
        AppMethodBeat.o(14988);
        return c3;
    }

    private boolean d(int i2, int i3) {
        boolean z2;
        AppMethodBeat.i(14989);
        this.F = i2;
        this.G = i3;
        this.H = i2;
        this.I = i3;
        if (1.0f != this.E) {
            this.H = (int) (((float) this.H) / this.E);
            this.I = (int) (((float) this.I) / this.E);
        }
        TXCLog.i(this.x, "mResampleRatio " + this.E + " mResampleWidth " + this.H + " mResampleHeight " + this.I);
        if (this.w == null) {
            this.w = new b();
            this.w.a(true);
            if (!this.w.a()) {
                TXCLog.e(this.x, "mBeautyBlendFilter init failed!!, break init");
                AppMethodBeat.o(14989);
                return false;
            }
        }
        this.w.a(i2, i3);
        if (this.s == null) {
            this.s = new d();
            this.s.a(true);
            if (!this.s.a()) {
                TXCLog.e(this.x, "m_horizontalFilter init failed!!, break init");
                AppMethodBeat.o(14989);
                return false;
            }
        }
        this.s.a(this.H, this.I);
        if (this.t == null) {
            this.t = new e();
            this.t.a(true);
            if (1.0f == this.E) {
                z2 = false;
            } else {
                z2 = true;
            }
            this.t.b(z2);
            if (!this.t.a()) {
                TXCLog.e(this.x, "m_verticalFilter init failed!!, break init");
                AppMethodBeat.o(14989);
                return false;
            }
        }
        this.t.a(this.H, this.I);
        if (this.u == null) {
            this.u = new h(1.0f);
            this.u.a(true);
            if (!this.u.a()) {
                TXCLog.e(this.x, "m_gammaFilter init failed!!, break init");
                AppMethodBeat.o(14989);
                return false;
            }
        }
        this.u.a(this.H, this.I);
        if (this.v == null) {
            this.v = new q();
            this.v.a(true);
            if (!this.v.a()) {
                TXCLog.e(this.x, "mSharpenFilter init failed!!, break init");
                AppMethodBeat.o(14989);
                return false;
            }
        }
        this.v.a(i2, i3);
        AppMethodBeat.o(14989);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void q() {
        AppMethodBeat.i(14990);
        if (this.w != null) {
            this.w.d();
            this.w = null;
        }
        if (this.s != null) {
            this.s.d();
            this.s = null;
        }
        if (this.t != null) {
            this.t.d();
            this.t = null;
        }
        if (this.u != null) {
            this.u.d();
            this.u = null;
        }
        if (this.v != null) {
            this.v.d();
            this.v = null;
        }
        AppMethodBeat.o(14990);
    }

    @Override // com.tencent.liteav.basic.c.h
    public void e() {
        AppMethodBeat.i(14991);
        super.e();
        q();
        AppMethodBeat.o(14991);
    }
}
