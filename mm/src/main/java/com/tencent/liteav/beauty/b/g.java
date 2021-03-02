package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.google.android.gms.gcm.Task;
import com.tencent.liteav.basic.c.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class g extends h {
    protected List<h> r;
    protected List<h> s;
    private int[] t;
    private int[] u;
    private h v;

    @Override // com.tencent.liteav.basic.c.h
    public boolean b() {
        AppMethodBeat.i(15093);
        boolean b2 = super.b();
        if (b2) {
            for (h hVar : this.r) {
                hVar.a();
                if (!hVar.m()) {
                    break;
                }
            }
            b2 = this.v.a();
        }
        if (!b2 || GLES20.glGetError() != 0) {
            AppMethodBeat.o(15093);
            return false;
        }
        AppMethodBeat.o(15093);
        return true;
    }

    @Override // com.tencent.liteav.basic.c.h
    public void e() {
        AppMethodBeat.i(15094);
        super.e();
        for (h hVar : this.r) {
            hVar.d();
        }
        AppMethodBeat.o(15094);
    }

    @Override // com.tencent.liteav.basic.c.h
    public void f() {
        AppMethodBeat.i(15095);
        super.f();
        if (this.u != null) {
            GLES20.glDeleteTextures(2, this.u, 0);
            this.u = null;
        }
        if (this.t != null) {
            GLES20.glDeleteFramebuffers(2, this.t, 0);
            this.t = null;
        }
        AppMethodBeat.o(15095);
    }

    @Override // com.tencent.liteav.basic.c.h
    public void a(int i2, int i3) {
        AppMethodBeat.i(15096);
        if (this.f304e == i2 && this.f305f == i3) {
            AppMethodBeat.o(15096);
            return;
        }
        if (this.t != null) {
            f();
        }
        super.a(i2, i3);
        int size = this.s.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.s.get(i4).a(i2, i3);
        }
        this.v.a(i2, i3);
        if (this.s != null && this.s.size() > 0) {
            this.s.size();
            this.t = new int[2];
            this.u = new int[2];
            for (int i5 = 0; i5 < 2; i5++) {
                GLES20.glGenFramebuffers(1, this.t, i5);
                GLES20.glGenTextures(1, this.u, i5);
                GLES20.glBindTexture(3553, this.u[i5]);
                GLES20.glTexImage2D(3553, 0, NativeBitmapStruct.GLFormat.GL_RGBA, i2, i3, 0, NativeBitmapStruct.GLFormat.GL_RGBA, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
                GLES20.glTexParameterf(3553, Task.EXTRAS_LIMIT_BYTES, 9729.0f);
                GLES20.glTexParameterf(3553, 10241, 9729.0f);
                GLES20.glTexParameterf(3553, 10242, 33071.0f);
                GLES20.glTexParameterf(3553, 10243, 33071.0f);
                GLES20.glBindFramebuffer(36160, this.t[i5]);
                GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.u[i5], 0);
                GLES20.glBindTexture(3553, 0);
                GLES20.glBindFramebuffer(36160, 0);
            }
        }
        AppMethodBeat.o(15096);
    }

    @Override // com.tencent.liteav.basic.c.h
    public int a(int i2, int i3, int i4) {
        int a2;
        boolean z;
        AppMethodBeat.i(15097);
        int size = this.s.size();
        k();
        int i5 = 0;
        boolean z2 = false;
        while (i5 < size) {
            h hVar = this.s.get(i5);
            if (z2) {
                a2 = hVar.a(i2, i3, i4);
            } else {
                a2 = hVar.a(i2, this.t[0], this.u[0]);
            }
            if (z2) {
                z = false;
            } else {
                z = true;
            }
            i5++;
            z2 = z;
            i2 = a2;
        }
        if (z2) {
            this.v.a(i2, i3, i4);
        }
        AppMethodBeat.o(15097);
        return i4;
    }
}
