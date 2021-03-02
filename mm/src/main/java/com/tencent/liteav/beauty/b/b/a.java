package com.tencent.liteav.beauty.b.b;

import com.tencent.liteav.beauty.b.b;
import com.tencent.liteav.beauty.b.r;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class a extends b {
    private b r = null;
    private r s = null;
    private String t = "TXCBeauty3Filter";
    private float u = 0.0f;
    private float v = 0.0f;
    private float w = 0.0f;
    private float x = 0.0f;

    @Override // com.tencent.liteav.beauty.b.b
    public boolean c(int i2, int i3) {
        AppMethodBeat.i(15002);
        boolean d2 = d(i2, i3);
        AppMethodBeat.o(15002);
        return d2;
    }

    @Override // com.tencent.liteav.basic.c.h
    public void a(int i2, int i3) {
        AppMethodBeat.i(15003);
        if (this.f304e == i2 && this.f305f == i3) {
            AppMethodBeat.o(15003);
            return;
        }
        this.f304e = i2;
        this.f305f = i3;
        d(i2, i3);
        AppMethodBeat.o(15003);
    }

    private boolean d(int i2, int i3) {
        AppMethodBeat.i(15004);
        if (this.r == null) {
            this.r = new b();
            this.r.a(true);
            if (!this.r.a()) {
                AppMethodBeat.o(15004);
                return false;
            }
        }
        this.r.a(i2, i3);
        if (this.s == null) {
            this.s = new r();
            this.s.a(true);
            if (!this.s.a()) {
                AppMethodBeat.o(15004);
                return false;
            }
        }
        this.s.a(i2, i3);
        AppMethodBeat.o(15004);
        return true;
    }

    @Override // com.tencent.liteav.basic.c.h
    public int b(int i2) {
        AppMethodBeat.i(15005);
        if (this.u > 0.0f || this.v > 0.0f || this.w > 0.0f) {
            i2 = this.r.b(i2);
        }
        if (this.x > 0.0f) {
            i2 = this.s.b(i2);
        }
        AppMethodBeat.o(15005);
        return i2;
    }

    @Override // com.tencent.liteav.beauty.b.b
    public void c(int i2) {
        AppMethodBeat.i(15006);
        this.u = ((float) i2) / 10.0f;
        if (this.r != null) {
            this.r.a(this.u);
        }
        AppMethodBeat.o(15006);
    }

    @Override // com.tencent.liteav.beauty.b.b
    public void d(int i2) {
        AppMethodBeat.i(15007);
        this.v = ((float) i2) / 10.0f;
        if (this.r != null) {
            this.r.b(this.v);
        }
        AppMethodBeat.o(15007);
    }

    @Override // com.tencent.liteav.beauty.b.b
    public void e(int i2) {
        AppMethodBeat.i(15008);
        this.w = ((float) i2) / 10.0f;
        if (this.r != null) {
            this.r.c(this.w);
        }
        AppMethodBeat.o(15008);
    }

    @Override // com.tencent.liteav.beauty.b.b
    public void f(int i2) {
        AppMethodBeat.i(15009);
        float f2 = ((float) i2) / 20.0f;
        if (((double) Math.abs(this.x - f2)) < 0.001d) {
            AppMethodBeat.o(15009);
            return;
        }
        this.x = f2;
        if (this.s != null) {
            this.s.a(this.x);
        }
        AppMethodBeat.o(15009);
    }

    /* access modifiers changed from: package-private */
    public void q() {
        AppMethodBeat.i(15010);
        if (this.r != null) {
            this.r.e();
            this.r = null;
        }
        if (this.s != null) {
            this.s.e();
            this.s = null;
        }
        AppMethodBeat.o(15010);
    }

    @Override // com.tencent.liteav.basic.c.h
    public void e() {
        AppMethodBeat.i(15011);
        super.e();
        q();
        AppMethodBeat.o(15011);
    }
}
