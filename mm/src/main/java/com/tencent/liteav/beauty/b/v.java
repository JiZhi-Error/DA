package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.c.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class v extends u {
    protected float u;

    @Override // com.tencent.liteav.basic.c.h, com.tencent.liteav.beauty.b.g
    public boolean b() {
        AppMethodBeat.i(15098);
        if (!super.b() || GLES20.glGetError() != 0) {
            AppMethodBeat.o(15098);
            return false;
        }
        AppMethodBeat.o(15098);
        return true;
    }

    /* access modifiers changed from: protected */
    public void s() {
        AppMethodBeat.i(15099);
        float r = r();
        h hVar = (h) this.r.get(0);
        int glGetUniformLocation = GLES20.glGetUniformLocation(hVar.p(), "texelWidthOffset");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(hVar.p(), "texelHeightOffset");
        hVar.a(glGetUniformLocation, r / ((float) this.f304e));
        hVar.a(glGetUniformLocation2, 0.0f);
        float q = q();
        h hVar2 = (h) this.r.get(1);
        int glGetUniformLocation3 = GLES20.glGetUniformLocation(hVar2.p(), "texelWidthOffset");
        int glGetUniformLocation4 = GLES20.glGetUniformLocation(hVar2.p(), "texelHeightOffset");
        hVar2.a(glGetUniformLocation3, 0.0f);
        hVar2.a(glGetUniformLocation4, q / ((float) this.f305f));
        AppMethodBeat.o(15099);
    }

    @Override // com.tencent.liteav.basic.c.h, com.tencent.liteav.beauty.b.g
    public void a(int i2, int i3) {
        AppMethodBeat.i(15100);
        super.a(i2, i3);
        s();
        AppMethodBeat.o(15100);
    }

    public float q() {
        return this.u;
    }

    public float r() {
        return this.u;
    }
}
