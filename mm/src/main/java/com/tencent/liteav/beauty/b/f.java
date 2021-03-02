package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.google.android.gms.gcm.Task;
import com.tencent.liteav.basic.c.h;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class f extends h {
    private int[] A;
    private float B = 4.0f;
    int r;
    int s;
    boolean t;
    private d u;
    private h v;
    private c w;
    private a x;
    private b y;
    private int[] z;

    static class c extends t {
        int r;
        int s;
        float t = 1.5f;

        public c() {
            super(null, null);
        }

        @Override // com.tencent.liteav.basic.c.h
        public boolean a() {
            AppMethodBeat.i(15055);
            NativeLoad.getInstance();
            this.f300a = NativeLoad.nativeLoadGLProgram(2);
            if (this.f300a == 0 || !b()) {
                this.f306g = false;
            } else {
                this.f306g = true;
            }
            c();
            boolean z = this.f306g;
            AppMethodBeat.o(15055);
            return z;
        }

        @Override // com.tencent.liteav.beauty.b.t, com.tencent.liteav.basic.c.h
        public boolean b() {
            AppMethodBeat.i(15056);
            if (super.b()) {
                this.r = GLES20.glGetUniformLocation(this.f300a, "texelWidthOffset");
                this.s = GLES20.glGetUniformLocation(this.f300a, "texelHeightOffset");
                AppMethodBeat.o(15056);
                return true;
            }
            AppMethodBeat.o(15056);
            return false;
        }

        /* access modifiers changed from: package-private */
        public void a(float f2) {
            AppMethodBeat.i(15057);
            this.t = f2;
            a(this.r, this.t / ((float) this.f304e));
            a(this.s, this.t / ((float) this.f305f));
            AppMethodBeat.o(15057);
        }

        @Override // com.tencent.liteav.basic.c.h
        public void a(int i2, int i3) {
            AppMethodBeat.i(15058);
            super.a(i2, i3);
            a(this.t);
            AppMethodBeat.o(15058);
        }
    }

    static class a extends t {
        public a(String str) {
            super(str);
        }

        @Override // com.tencent.liteav.beauty.b.t, com.tencent.liteav.basic.c.h
        public boolean b() {
            AppMethodBeat.i(15108);
            if (super.b()) {
                AppMethodBeat.o(15108);
                return true;
            }
            AppMethodBeat.o(15108);
            return false;
        }
    }

    static class b extends s {
        public b(String str) {
            super(str);
        }

        @Override // com.tencent.liteav.basic.c.h, com.tencent.liteav.beauty.b.s
        public boolean b() {
            AppMethodBeat.i(15021);
            if (super.b()) {
                AppMethodBeat.o(15021);
                return true;
            }
            AppMethodBeat.o(15021);
            return false;
        }
    }

    @Override // com.tencent.liteav.basic.c.h
    public boolean b() {
        AppMethodBeat.i(15119);
        boolean b2 = super.b();
        if (b2) {
            this.u = new d();
            if (b2) {
                b2 = this.u.a();
            }
            this.w = new c();
            if (b2) {
                b2 = this.w.a();
            }
            this.x = new a("precision highp float;  \nuniform sampler2D inputImageTexture;  \nuniform sampler2D inputImageTexture2;  \nvarying vec2 textureCoordinate;  \nvarying vec2 textureCoordinate2;  \nvoid main()  \n{  \n\tgl_FragColor = texture2D(inputImageTexture2, textureCoordinate2) - texture2D(inputImageTexture, textureCoordinate) * texture2D(inputImageTexture2, textureCoordinate2);  \n}  \n");
            if (b2) {
                b2 = this.x.a();
            }
            this.y = new b("precision highp float;   \nuniform sampler2D inputImageTexture;   \nuniform sampler2D inputImageTexture2;  \nuniform sampler2D inputImageTexture3;   \nvarying vec2 textureCoordinate;   \nvarying vec2 textureCoordinate2;  \nvarying vec2 textureCoordinate3;    \nvoid main()   \n{   \n\tgl_FragColor = texture2D(inputImageTexture, textureCoordinate) * texture2D(inputImageTexture3, textureCoordinate3) + texture2D(inputImageTexture2, textureCoordinate2);   \n}   \n");
            if (b2) {
                b2 = this.y.a();
            }
            this.v = new h();
            this.v.a(true);
            if (b2) {
                b2 = this.v.a();
            }
            if (b2) {
                AppMethodBeat.o(15119);
                return true;
            }
        }
        d();
        AppMethodBeat.o(15119);
        return false;
    }

    @Override // com.tencent.liteav.basic.c.h
    public void a(int i2, int i3) {
        AppMethodBeat.i(15120);
        if (this.f305f == i3 && this.f304e == i2) {
            AppMethodBeat.o(15120);
            return;
        }
        super.a(i2, i3);
        if (!this.t) {
            if (i2 < i3) {
                if (i2 < 540) {
                    this.B = 1.0f;
                } else {
                    this.B = 4.0f;
                }
            } else if (i3 < 540) {
                this.B = 1.0f;
            } else {
                this.B = 4.0f;
            }
        }
        this.r = (int) (((float) i2) / this.B);
        this.s = (int) (((float) i3) / this.B);
        this.v.a(this.r, this.s);
        this.w.a(this.r, this.s);
        this.x.a(this.r, this.s);
        this.y.a(i2, i3);
        this.u.a(this.r, this.s);
        if (this.z != null) {
            GLES20.glDeleteFramebuffers(this.z.length, this.z, 0);
            GLES20.glDeleteTextures(this.z.length, this.A, 0);
            this.z = null;
            this.A = null;
        }
        this.z = new int[8];
        this.A = new int[this.z.length];
        GLES20.glGenFramebuffers(this.z.length, this.z, 0);
        GLES20.glGenTextures(this.z.length, this.A, 0);
        for (int i4 = 0; i4 < this.z.length; i4++) {
            GLES20.glBindTexture(3553, this.A[i4]);
            if (i4 >= 5) {
                GLES20.glTexImage2D(3553, 0, NativeBitmapStruct.GLFormat.GL_RGBA, i2, i3, 0, NativeBitmapStruct.GLFormat.GL_RGBA, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
            } else {
                GLES20.glTexImage2D(3553, 0, NativeBitmapStruct.GLFormat.GL_RGBA, this.r, this.s, 0, NativeBitmapStruct.GLFormat.GL_RGBA, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
            }
            GLES20.glTexParameterf(3553, Task.EXTRAS_LIMIT_BYTES, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glBindFramebuffer(36160, this.z[i4]);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.A[i4], 0);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindFramebuffer(36160, 0);
        }
        AppMethodBeat.o(15120);
    }

    @Override // com.tencent.liteav.basic.c.h
    public int b(int i2) {
        int i3;
        AppMethodBeat.i(15121);
        if (this.B != 1.0f) {
            GLES20.glViewport(0, 0, this.r, this.s);
            i3 = this.v.b(i2);
        } else {
            i3 = i2;
        }
        int a2 = this.u.a(i3, this.z[4], this.A[4]);
        int a3 = this.w.a(i3, a2, this.z[0], this.A[0]);
        int a4 = this.x.a(a3, a2, this.z[1], this.A[1]);
        int a5 = this.u.a(a3, this.z[2], this.A[2]);
        int a6 = this.u.a(a4, this.z[3], this.A[3]);
        if (this.B != 1.0f) {
            GLES20.glViewport(0, 0, this.f304e, this.f305f);
            a5 = this.v.a(a5, this.z[5], this.A[5]);
            a6 = this.v.a(a6, this.z[6], this.A[6]);
        }
        int a7 = this.y.a(a5, a6, i2, this.z[7], this.A[7]);
        AppMethodBeat.o(15121);
        return a7;
    }

    @Override // com.tencent.liteav.basic.c.h
    public void e() {
        AppMethodBeat.i(15122);
        if (this.f306g) {
            super.e();
            this.u.d();
            this.w.d();
            this.x.d();
            this.y.d();
            this.v.d();
            if (this.z != null) {
                GLES20.glDeleteFramebuffers(this.z.length, this.z, 0);
                GLES20.glDeleteTextures(this.z.length, this.A, 0);
                this.z = null;
            }
            this.A = null;
        }
        AppMethodBeat.o(15122);
    }
}
