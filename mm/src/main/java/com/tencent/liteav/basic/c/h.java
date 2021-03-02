package com.tencent.liteav.basic.c;

import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.LinkedList;

public class h {

    /* renamed from: a  reason: collision with root package name */
    protected int f300a;

    /* renamed from: b  reason: collision with root package name */
    protected int f301b;

    /* renamed from: c  reason: collision with root package name */
    protected int f302c;

    /* renamed from: d  reason: collision with root package name */
    protected int f303d;

    /* renamed from: e  reason: collision with root package name */
    protected int f304e;

    /* renamed from: f  reason: collision with root package name */
    protected int f305f;

    /* renamed from: g  reason: collision with root package name */
    protected boolean f306g;

    /* renamed from: h  reason: collision with root package name */
    protected FloatBuffer f307h;

    /* renamed from: i  reason: collision with root package name */
    protected FloatBuffer f308i;

    /* renamed from: j  reason: collision with root package name */
    protected float[] f309j;
    protected float[] k;
    protected a l;
    protected int m;
    protected int n;
    protected boolean o;
    protected boolean p;
    protected boolean q;
    private final LinkedList<Runnable> r;
    private final String s;
    private final String t;
    private boolean u;
    private int v;
    private float[] w;

    public interface a {
        void a(int i2);
    }

    public h() {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}", false);
    }

    public h(String str, String str2) {
        this(str, str2, false);
    }

    public h(String str, String str2, boolean z) {
        AppMethodBeat.i(222258);
        this.u = false;
        this.v = -1;
        this.w = null;
        this.m = -1;
        this.n = -1;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = new LinkedList<>();
        this.s = str;
        this.t = str2;
        this.q = z;
        if (true == z) {
            TXCLog.i("TXCGPUFilter", "set Oes fileter");
        }
        this.f307h = ByteBuffer.allocateDirect(l.f344e.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f309j = l.f344e;
        this.f307h.put(this.f309j).position(0);
        this.f308i = ByteBuffer.allocateDirect(l.f340a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.k = l.a(k.NORMAL, false, true);
        this.f308i.put(this.k).position(0);
        AppMethodBeat.o(222258);
    }

    public boolean a() {
        AppMethodBeat.i(222259);
        this.f300a = j.a(this.s, this.t);
        if (this.f300a == 0 || !b()) {
            this.f306g = false;
        } else {
            this.f306g = true;
        }
        c();
        boolean z = this.f306g;
        AppMethodBeat.o(222259);
        return z;
    }

    public void a(boolean z) {
        this.o = z;
    }

    public void b(boolean z) {
        AppMethodBeat.i(222260);
        this.p = z;
        TXCLog.i("TXCGPUFilter", "set Nearest model ".concat(String.valueOf(z)));
        AppMethodBeat.o(222260);
    }

    public void a(a aVar) {
        this.u = aVar != null;
        this.l = aVar;
    }

    public boolean b() {
        AppMethodBeat.i(222261);
        this.f301b = GLES20.glGetAttribLocation(this.f300a, "position");
        this.f302c = GLES20.glGetUniformLocation(this.f300a, "inputImageTexture");
        this.v = GLES20.glGetUniformLocation(this.f300a, "textureTransform");
        this.f303d = GLES20.glGetAttribLocation(this.f300a, "inputTextureCoordinate");
        AppMethodBeat.o(222261);
        return true;
    }

    public void c() {
    }

    public void d() {
        AppMethodBeat.i(222262);
        GLES20.glDeleteProgram(this.f300a);
        e();
        this.f306g = false;
        AppMethodBeat.o(222262);
    }

    public void e() {
        AppMethodBeat.i(222263);
        f();
        this.f305f = -1;
        this.f304e = -1;
        AppMethodBeat.o(222263);
    }

    private static float[] a(FloatBuffer floatBuffer) {
        AppMethodBeat.i(222264);
        if (floatBuffer.limit() <= 0) {
            AppMethodBeat.o(222264);
            return null;
        }
        float[] fArr = new float[floatBuffer.limit()];
        for (int i2 = 0; i2 < floatBuffer.limit(); i2++) {
            fArr[i2] = floatBuffer.get(i2);
        }
        AppMethodBeat.o(222264);
        return fArr;
    }

    public void f() {
        AppMethodBeat.i(222265);
        if (this.m != -1) {
            GLES20.glDeleteFramebuffers(1, new int[]{this.m}, 0);
            this.m = -1;
        }
        if (this.n != -1) {
            GLES20.glDeleteTextures(1, new int[]{this.n}, 0);
            this.n = -1;
        }
        AppMethodBeat.o(222265);
    }

    public void a(int i2, int i3) {
        AppMethodBeat.i(222266);
        if (this.f305f == i3 && this.f304e == i2) {
            AppMethodBeat.o(222266);
            return;
        }
        this.f304e = i2;
        this.f305f = i3;
        if (this.o) {
            if (this.m != -1) {
                f();
            }
            int[] iArr = new int[1];
            GLES20.glGenFramebuffers(1, iArr, 0);
            this.m = iArr[0];
            this.n = j.a(i2, i3, NativeBitmapStruct.GLFormat.GL_RGBA, NativeBitmapStruct.GLFormat.GL_RGBA);
            GLES20.glBindFramebuffer(36160, this.m);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.n, 0);
            GLES20.glBindFramebuffer(36160, 0);
        }
        AppMethodBeat.o(222266);
    }

    public void a(int i2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        AppMethodBeat.i(222267);
        GLES20.glUseProgram(this.f300a);
        k();
        if (!this.f306g) {
            AppMethodBeat.o(222267);
            return;
        }
        floatBuffer.position(0);
        GLES20.glVertexAttribPointer(this.f301b, 2, 5126, false, 0, (Buffer) floatBuffer);
        GLES20.glEnableVertexAttribArray(this.f301b);
        floatBuffer2.position(0);
        GLES20.glVertexAttribPointer(this.f303d, 2, 5126, false, 0, (Buffer) floatBuffer2);
        GLES20.glEnableVertexAttribArray(this.f303d);
        if (this.v >= 0 && this.w != null) {
            GLES20.glUniformMatrix4fv(this.v, 1, false, this.w, 0);
        }
        if (i2 != -1) {
            GLES20.glActiveTexture(33984);
            if (true == this.q) {
                GLES20.glBindTexture(36197, i2);
            } else {
                GLES20.glBindTexture(3553, i2);
            }
            GLES20.glUniform1i(this.f302c, 0);
        }
        i();
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.f301b);
        GLES20.glDisableVertexAttribArray(this.f303d);
        j();
        if (true == this.q) {
            GLES20.glBindTexture(36197, 0);
            AppMethodBeat.o(222267);
            return;
        }
        GLES20.glBindTexture(3553, 0);
        AppMethodBeat.o(222267);
    }

    public void a(float[] fArr) {
        this.w = fArr;
    }

    public void g() {
        AppMethodBeat.i(222268);
        if (this.k != null) {
            for (int i2 = 0; i2 < 8; i2 += 2) {
                this.k[i2] = 1.0f - this.k[i2];
            }
            a(this.f309j, this.k);
            AppMethodBeat.o(222268);
            return;
        }
        AppMethodBeat.o(222268);
    }

    public void h() {
        AppMethodBeat.i(222269);
        if (this.k != null) {
            for (int i2 = 1; i2 < 8; i2 += 2) {
                this.k[i2] = 1.0f - this.k[i2];
            }
            a(this.f309j, this.k);
            AppMethodBeat.o(222269);
            return;
        }
        AppMethodBeat.o(222269);
    }

    public int b(int i2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        AppMethodBeat.i(222270);
        if (!this.f306g) {
            AppMethodBeat.o(222270);
            return -1;
        }
        a(i2, floatBuffer, floatBuffer2);
        if (this.l instanceof a) {
            this.l.a(i2);
        }
        AppMethodBeat.o(222270);
        return 1;
    }

    public int a(int i2) {
        AppMethodBeat.i(222271);
        int b2 = b(i2, this.f307h, this.f308i);
        AppMethodBeat.o(222271);
        return b2;
    }

    /* access modifiers changed from: protected */
    public void i() {
    }

    /* access modifiers changed from: protected */
    public void j() {
    }

    /* access modifiers changed from: protected */
    public void k() {
        AppMethodBeat.i(222272);
        while (!this.r.isEmpty()) {
            this.r.removeFirst().run();
        }
        AppMethodBeat.o(222272);
    }

    public int a(int i2, int i3, int i4) {
        AppMethodBeat.i(222273);
        if (!this.f306g) {
            AppMethodBeat.o(222273);
            return -1;
        }
        GLES20.glBindFramebuffer(36160, i3);
        a(i2, this.f307h, this.f308i);
        if (this.l instanceof a) {
            this.l.a(i4);
        }
        GLES20.glBindFramebuffer(36160, 0);
        AppMethodBeat.o(222273);
        return i4;
    }

    public int b(int i2) {
        AppMethodBeat.i(222274);
        int a2 = a(i2, this.m, this.n);
        AppMethodBeat.o(222274);
        return a2;
    }

    public int l() {
        return this.n;
    }

    public void a(float[] fArr, float[] fArr2) {
        AppMethodBeat.i(222275);
        this.f309j = fArr;
        this.f307h = ByteBuffer.allocateDirect(l.f344e.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f307h.put(fArr).position(0);
        this.k = fArr2;
        this.f308i = ByteBuffer.allocateDirect(l.f340a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f308i.put(fArr2).position(0);
        AppMethodBeat.o(222275);
    }

    public float[] a(int i2, int i3, FloatBuffer floatBuffer, a aVar, int i4) {
        float[] a2;
        AppMethodBeat.i(222276);
        if (floatBuffer != null) {
            a2 = a(floatBuffer);
        } else if (4 == i4) {
            a2 = l.a(k.NORMAL, false, false);
        } else {
            a2 = l.a(k.NORMAL, false, true);
        }
        if (aVar != null) {
            float f2 = ((float) aVar.f220a) / (((float) i2) * 1.0f);
            float f3 = ((float) ((i2 - aVar.f220a) - aVar.f222c)) / (((float) i2) * 1.0f);
            float f4 = ((float) aVar.f221b) / (((float) i3) * 1.0f);
            float f5 = ((float) ((i3 - aVar.f221b) - aVar.f223d)) / (((float) i3) * 1.0f);
            for (int i5 = 0; i5 < a2.length / 2; i5++) {
                if (a2[i5 * 2] < 0.5f) {
                    int i6 = i5 * 2;
                    a2[i6] = a2[i6] + f2;
                } else {
                    int i7 = i5 * 2;
                    a2[i7] = a2[i7] - f3;
                }
                if (a2[(i5 * 2) + 1] < 0.5f) {
                    int i8 = (i5 * 2) + 1;
                    a2[i8] = a2[i8] + f4;
                } else {
                    int i9 = (i5 * 2) + 1;
                    a2[i9] = a2[i9] - f5;
                }
            }
        }
        AppMethodBeat.o(222276);
        return a2;
    }

    public void a(int i2, int i3, int i4, float[] fArr, float f2, boolean z, boolean z2) {
        int i5;
        int i6;
        AppMethodBeat.i(222277);
        if (fArr == null) {
            fArr = l.a(k.NORMAL, false, true);
        }
        if (((float) i2) / ((float) i3) > f2) {
            i6 = (int) (((float) i3) * f2);
            i5 = i3;
        } else if (((float) i2) / ((float) i3) < f2) {
            i5 = (int) (((float) i2) / f2);
            i6 = i2;
        } else {
            i5 = i3;
            i6 = i2;
        }
        float f3 = (1.0f - (((float) i6) / ((float) i2))) / 2.0f;
        float f4 = (1.0f - (((float) i5) / ((float) i3))) / 2.0f;
        for (int i7 = 0; i7 < fArr.length / 2; i7++) {
            if (fArr[i7 * 2] < 0.5f) {
                int i8 = i7 * 2;
                fArr[i8] = fArr[i8] + f3;
            } else {
                int i9 = i7 * 2;
                fArr[i9] = fArr[i9] - f3;
            }
            if (fArr[(i7 * 2) + 1] < 0.5f) {
                int i10 = (i7 * 2) + 1;
                fArr[i10] = fArr[i10] + f4;
            } else {
                int i11 = (i7 * 2) + 1;
                fArr[i11] = fArr[i11] - f4;
            }
        }
        int i12 = i4 / 90;
        for (int i13 = 0; i13 < i12; i13++) {
            float f5 = fArr[0];
            float f6 = fArr[1];
            fArr[0] = fArr[2];
            fArr[1] = fArr[3];
            fArr[2] = fArr[6];
            fArr[3] = fArr[7];
            fArr[6] = fArr[4];
            fArr[7] = fArr[5];
            fArr[4] = f5;
            fArr[5] = f6;
        }
        if (i12 == 0 || i12 == 2) {
            if (z) {
                fArr[0] = 1.0f - fArr[0];
                fArr[2] = 1.0f - fArr[2];
                fArr[4] = 1.0f - fArr[4];
                fArr[6] = 1.0f - fArr[6];
            }
            if (z2) {
                fArr[1] = 1.0f - fArr[1];
                fArr[3] = 1.0f - fArr[3];
                fArr[5] = 1.0f - fArr[5];
                fArr[7] = 1.0f - fArr[7];
            }
        } else {
            if (z2) {
                fArr[0] = 1.0f - fArr[0];
                fArr[2] = 1.0f - fArr[2];
                fArr[4] = 1.0f - fArr[4];
                fArr[6] = 1.0f - fArr[6];
            }
            if (z) {
                fArr[1] = 1.0f - fArr[1];
                fArr[3] = 1.0f - fArr[3];
                fArr[5] = 1.0f - fArr[5];
                fArr[7] = 1.0f - fArr[7];
            }
        }
        a((float[]) l.f344e.clone(), fArr);
        AppMethodBeat.o(222277);
    }

    public void a(int i2, FloatBuffer floatBuffer) {
        float[] a2;
        AppMethodBeat.i(222278);
        if (floatBuffer == null) {
            a2 = l.a(k.NORMAL, false, true);
        } else {
            a2 = a(floatBuffer);
        }
        int i3 = i2 / 90;
        for (int i4 = 0; i4 < i3; i4++) {
            float f2 = a2[0];
            float f3 = a2[1];
            a2[0] = a2[2];
            a2[1] = a2[3];
            a2[2] = a2[6];
            a2[3] = a2[7];
            a2[6] = a2[4];
            a2[7] = a2[5];
            a2[4] = f2;
            a2[5] = f3;
        }
        a((float[]) l.f344e.clone(), a2);
        AppMethodBeat.o(222278);
    }

    public boolean m() {
        return this.f306g;
    }

    public int n() {
        return this.f304e;
    }

    public int o() {
        return this.f305f;
    }

    public int p() {
        return this.f300a;
    }

    public void b(final int i2, final int i3) {
        AppMethodBeat.i(222279);
        a(new Runnable() {
            /* class com.tencent.liteav.basic.c.h.AnonymousClass1 */

            public void run() {
                AppMethodBeat.i(222192);
                GLES20.glUniform1i(i2, i3);
                AppMethodBeat.o(222192);
            }
        });
        AppMethodBeat.o(222279);
    }

    public void a(final int i2, final float f2) {
        AppMethodBeat.i(222280);
        a(new Runnable() {
            /* class com.tencent.liteav.basic.c.h.AnonymousClass2 */

            public void run() {
                AppMethodBeat.i(222208);
                GLES20.glUniform1f(i2, f2);
                AppMethodBeat.o(222208);
            }
        });
        AppMethodBeat.o(222280);
    }

    public void a(final int i2, final float[] fArr) {
        AppMethodBeat.i(222281);
        a(new Runnable() {
            /* class com.tencent.liteav.basic.c.h.AnonymousClass3 */

            public void run() {
                AppMethodBeat.i(222187);
                GLES20.glUniform2fv(i2, 1, FloatBuffer.wrap(fArr));
                AppMethodBeat.o(222187);
            }
        });
        AppMethodBeat.o(222281);
    }

    public void b(final int i2, final float[] fArr) {
        AppMethodBeat.i(222282);
        a(new Runnable() {
            /* class com.tencent.liteav.basic.c.h.AnonymousClass4 */

            public void run() {
                AppMethodBeat.i(222256);
                GLES20.glUniform3fv(i2, 1, FloatBuffer.wrap(fArr));
                AppMethodBeat.o(222256);
            }
        });
        AppMethodBeat.o(222282);
    }

    public void c(final int i2, final float[] fArr) {
        AppMethodBeat.i(222283);
        a(new Runnable() {
            /* class com.tencent.liteav.basic.c.h.AnonymousClass5 */

            public void run() {
                AppMethodBeat.i(222190);
                GLES20.glUniform4fv(i2, 1, FloatBuffer.wrap(fArr));
                AppMethodBeat.o(222190);
            }
        });
        AppMethodBeat.o(222283);
    }

    public void a(Runnable runnable) {
        AppMethodBeat.i(222284);
        synchronized (this.r) {
            try {
                this.r.addLast(runnable);
            } finally {
                AppMethodBeat.o(222284);
            }
        }
    }
}
