package com.tencent.liteav.beauty.b.c;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class a extends b {
    private d r = null;
    private d s = null;
    private b t = null;
    private c u = null;
    private d v = null;
    private d w = null;
    private float x = 0.2f;
    private float y = 0.2f;
    private float z = 0.2f;

    @Override // com.tencent.liteav.beauty.b.b
    public boolean c(int i2, int i3) {
        AppMethodBeat.i(221452);
        this.f304e = i2;
        this.f305f = i3;
        boolean d2 = d(i2, i3);
        AppMethodBeat.o(221452);
        return d2;
    }

    @Override // com.tencent.liteav.basic.c.h
    public void a(int i2, int i3) {
        AppMethodBeat.i(221453);
        super.a(i2, i3);
        this.f304e = i2;
        this.f305f = i3;
        this.r.a(i2, i3);
        this.s.a(i2, i3);
        this.t.a(i2, i3);
        this.v.a(i2, i3);
        this.w.a(i2, i3);
        this.u.a(i2, i3);
        AppMethodBeat.o(221453);
    }

    private boolean d(int i2, int i3) {
        AppMethodBeat.i(221454);
        if (this.r == null) {
            this.r = new d(true);
            this.r.a(true);
            if (!this.r.a()) {
                TXCLog.e("TXCBeauty4Filter", "mSkinBlurFilterVertical init failed!!, break init");
                AppMethodBeat.o(221454);
                return false;
            }
        }
        if (this.s == null) {
            this.s = new d(false);
            this.s.a(true);
            if (!this.s.a()) {
                TXCLog.e("TXCBeauty4Filter", "mSkinBlurFilterHorizontal init failed!!, break init");
                AppMethodBeat.o(221454);
                return false;
            }
        }
        if (this.t == null) {
            this.t = new b();
            this.t.a(true);
            if (!this.t.a()) {
                TXCLog.e("TXCBeauty4Filter", "mBorderFilter init failed!!, break init");
                AppMethodBeat.o(221454);
                return false;
            }
        }
        if (this.v == null) {
            this.v = new d(true);
            this.v.a(true);
            if (!this.v.a()) {
                TXCLog.e("TXCBeauty4Filter", "mBorderBlurFilterVertical init failed!!, break init");
                AppMethodBeat.o(221454);
                return false;
            }
        }
        if (this.w == null) {
            this.w = new d(false);
            this.w.a(true);
            if (!this.w.a()) {
                TXCLog.e("TXCBeauty4Filter", "mBorderBlurFilterHorizontal init failed!!, break init");
                AppMethodBeat.o(221454);
                return false;
            }
        }
        if (this.u == null) {
            this.u = new c();
            this.u.a(true);
            if (!this.u.a()) {
                TXCLog.e("TXCBeauty4Filter", "mSmoothFilter init failed!!, break init");
                AppMethodBeat.o(221454);
                return false;
            }
        }
        this.u.a(360.0f, 640.0f);
        this.u.a(this.x);
        this.u.b(this.y);
        this.u.c(this.z);
        a(i2, i3);
        AppMethodBeat.o(221454);
        return true;
    }

    @Override // com.tencent.liteav.basic.c.h
    public int b(int i2) {
        AppMethodBeat.i(221455);
        if (this.x > 0.0f || this.y > 0.0f || this.z > 0.0f) {
            int b2 = this.s.b(this.r.b(i2));
            i2 = this.u.a(i2, b2, this.w.b(this.v.b(this.t.c(i2, b2))));
        }
        AppMethodBeat.o(221455);
        return i2;
    }

    @Override // com.tencent.liteav.beauty.b.b
    public void c(int i2) {
        AppMethodBeat.i(221456);
        this.x = ((float) i2) / 10.0f;
        if (this.u != null) {
            this.u.a(this.x);
        }
        AppMethodBeat.o(221456);
    }

    @Override // com.tencent.liteav.beauty.b.b
    public void d(int i2) {
        AppMethodBeat.i(221457);
        this.y = ((float) i2) / 10.0f;
        if (this.u != null) {
            this.u.b(this.y);
        }
        AppMethodBeat.o(221457);
    }

    @Override // com.tencent.liteav.beauty.b.b
    public void e(int i2) {
        AppMethodBeat.i(221458);
        this.z = ((float) i2) / 10.0f;
        if (this.u != null) {
            this.u.c(this.z);
        }
        AppMethodBeat.o(221458);
    }

    @Override // com.tencent.liteav.beauty.b.b
    public void f(int i2) {
        AppMethodBeat.i(221459);
        this.u.d(((float) i2) / 10.0f);
        AppMethodBeat.o(221459);
    }

    /* access modifiers changed from: package-private */
    public void q() {
        AppMethodBeat.i(221460);
        if (this.r != null) {
            this.r.e();
            this.r = null;
        }
        if (this.s != null) {
            this.s.e();
            this.s = null;
        }
        if (this.t != null) {
            this.t.e();
            this.t = null;
        }
        if (this.u != null) {
            this.u.e();
            this.u = null;
        }
        if (this.v != null) {
            this.v.e();
            this.v = null;
        }
        if (this.w != null) {
            this.w.e();
            this.w = null;
        }
        AppMethodBeat.o(221460);
    }

    @Override // com.tencent.liteav.basic.c.h
    public void e() {
        AppMethodBeat.i(221461);
        super.e();
        q();
        AppMethodBeat.o(221461);
    }
}
