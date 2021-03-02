package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.liteav.basic.c.h;
import com.tencent.liteav.basic.c.j;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.FloatBuffer;

public class k extends h {
    private static String y = "YUV420pToRGBFilter";
    private byte[] r = null;
    private int s = 1;
    private int[] t = null;
    private int[] u = null;
    private int v = 0;
    private int w = 0;
    private int[] x = null;

    public k(int i2) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        AppMethodBeat.i(15110);
        this.s = i2;
        TXCLog.i(y, "yuv Type ".concat(String.valueOf(i2)));
        AppMethodBeat.o(15110);
    }

    @Override // com.tencent.liteav.basic.c.h
    public boolean a() {
        int i2 = 7;
        AppMethodBeat.i(15111);
        if (this.s != 1) {
            if (this.s == 3) {
                i2 = 9;
            } else if (this.s == 2) {
                boolean a2 = super.a();
                AppMethodBeat.o(15111);
                return a2;
            } else {
                TXCLog.e(y, "don't support yuv format " + this.s);
            }
        }
        NativeLoad.getInstance();
        this.f300a = NativeLoad.nativeLoadGLProgram(i2);
        if (this.f300a == 0 || !b()) {
            this.f306g = false;
        } else {
            this.f306g = true;
        }
        c();
        boolean z = this.f306g;
        AppMethodBeat.o(15111);
        return z;
    }

    @Override // com.tencent.liteav.basic.c.h
    public void a(int i2, int i3) {
        AppMethodBeat.i(15112);
        if (this.f305f == i3 && this.f304e == i2) {
            AppMethodBeat.o(15112);
            return;
        }
        s();
        if (this.t == null) {
            this.t = new int[1];
            this.t[0] = j.a(i2, i3, 6409, 6409, this.t);
        }
        this.v = GLES20.glGetUniformLocation(p(), "yTexture");
        this.w = GLES20.glGetUniformLocation(p(), "uvTexture");
        if (1 == this.s) {
            GLES20.glActiveTexture(33984);
            GLES20.glActiveTexture(33985);
            this.u = new int[1];
            this.u[0] = j.a(i2, i3 / 2, 6409, 6409, this.u);
            GLES20.glUniform1i(this.v, 0);
            GLES20.glUniform1i(this.w, 1);
        } else if (3 == this.s) {
            GLES20.glActiveTexture(33984);
            GLES20.glActiveTexture(33985);
            this.v = GLES20.glGetUniformLocation(p(), "yTexture");
            this.w = GLES20.glGetUniformLocation(p(), "uvTexture");
            this.u = new int[1];
            this.u[0] = j.a(i2 / 2, i3 / 2, 6410, 6410, this.u);
            GLES20.glUniform1i(this.v, 0);
            GLES20.glUniform1i(this.w, 1);
        } else if (2 == this.s && this.x == null) {
            this.x = new int[1];
            this.x[0] = j.a(i2, i3, (int) NativeBitmapStruct.GLFormat.GL_RGBA, (int) NativeBitmapStruct.GLFormat.GL_RGBA, this.x);
        }
        super.a(i2, i3);
        AppMethodBeat.o(15112);
    }

    public void a(byte[] bArr) {
        this.r = bArr;
    }

    @Override // com.tencent.liteav.basic.c.h
    public void i() {
        int[] iArr;
        AppMethodBeat.i(15113);
        super.i();
        if (this.f304e % 4 != 0) {
            int[] iArr2 = new int[1];
            GLES20.glGetIntegerv(3317, iArr2, 0);
            GLES20.glPixelStorei(3317, 1);
            iArr = iArr2;
        } else {
            iArr = null;
        }
        if (1 == this.s) {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.t[0]);
            GLES20.glUniform1i(this.v, 0);
            NativeLoad.getInstance();
            NativeLoad.nativeglTexImage2D(3553, 0, 6409, this.f304e, this.f305f, 0, 6409, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, this.r, 0);
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, this.u[0]);
            GLES20.glUniform1i(this.w, 1);
            NativeLoad.getInstance();
            NativeLoad.nativeglTexImage2D(3553, 0, 6409, this.f304e, this.f305f / 2, 0, 6409, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, this.r, this.f304e * this.f305f);
        } else if (3 == this.s) {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.t[0]);
            GLES20.glUniform1i(this.v, 0);
            NativeLoad.getInstance();
            NativeLoad.nativeglTexImage2D(3553, 0, 6409, this.f304e, this.f305f, 0, 6409, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, this.r, 0);
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, this.u[0]);
            GLES20.glUniform1i(this.w, 1);
            NativeLoad.getInstance();
            NativeLoad.nativeglTexImage2D(3553, 0, 6410, this.f304e / 2, this.f305f / 2, 0, 6410, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, this.r, this.f305f * this.f304e);
        } else if (2 == this.s) {
            r();
        }
        if (this.f304e % 4 != 0) {
            if (iArr == null || iArr[0] <= 0) {
                GLES20.glPixelStorei(3317, 4);
            } else {
                GLES20.glPixelStorei(3317, iArr[0]);
                AppMethodBeat.o(15113);
                return;
            }
        }
        AppMethodBeat.o(15113);
    }

    public int q() {
        AppMethodBeat.i(15114);
        if (2 == this.s) {
            int r2 = r();
            GLES20.glBindTexture(3553, 0);
            AppMethodBeat.o(15114);
            return r2;
        }
        int b2 = super.b(-1);
        AppMethodBeat.o(15114);
        return b2;
    }

    private int r() {
        AppMethodBeat.i(15115);
        GLES20.glBindTexture(3553, this.x[0]);
        if (this.r != null) {
            NativeLoad.getInstance();
            NativeLoad.nativeglTexImage2D(3553, 0, NativeBitmapStruct.GLFormat.GL_RGBA, this.f304e, this.f305f, 0, NativeBitmapStruct.GLFormat.GL_RGBA, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, this.r, 0);
        }
        int i2 = this.x[0];
        AppMethodBeat.o(15115);
        return i2;
    }

    @Override // com.tencent.liteav.basic.c.h
    public void a(int i2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        AppMethodBeat.i(15116);
        super.a(-1, floatBuffer, floatBuffer2);
        AppMethodBeat.o(15116);
    }

    private void s() {
        AppMethodBeat.i(15117);
        if (this.t != null && this.t[0] > 0) {
            GLES20.glDeleteTextures(1, this.t, 0);
            this.t = null;
        }
        if (this.u != null && this.u[0] > 0) {
            GLES20.glDeleteTextures(1, this.u, 0);
            this.u = null;
        }
        if (this.x != null && this.x[0] > 0) {
            GLES20.glDeleteTextures(1, this.x, 0);
            this.x = null;
        }
        AppMethodBeat.o(15117);
    }

    @Override // com.tencent.liteav.basic.c.h
    public void e() {
        AppMethodBeat.i(15118);
        super.e();
        s();
        AppMethodBeat.o(15118);
    }
}
