package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.c.a;
import com.tencent.liteav.basic.c.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class p extends h {
    private a r;

    @Override // com.tencent.liteav.basic.c.h
    public int b(int i2) {
        AppMethodBeat.i(14968);
        if (this.r == null) {
            this.r = new a();
            this.r.f220a = 0;
            this.r.f221b = 0;
            this.r.f222c = this.f304e;
            this.r.f223d = this.f305f;
        }
        GLES20.glViewport(this.r.f220a, this.r.f221b, this.r.f222c, this.r.f223d);
        int b2 = super.b(i2);
        AppMethodBeat.o(14968);
        return b2;
    }
}
