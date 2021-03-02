package com.tencent.liteav.renderer;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.google.android.gms.gcm.Task;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveConstants;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public static int f1147a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static int f1148b = 2;

    /* renamed from: c  reason: collision with root package name */
    private int f1149c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f1150d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f1151e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f1152f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f1153g = f1148b;

    /* renamed from: h  reason: collision with root package name */
    private int f1154h = 0;

    /* renamed from: i  reason: collision with root package name */
    private boolean f1155i = false;

    /* renamed from: j  reason: collision with root package name */
    private float[] f1156j = new float[16];
    private float[] k = new float[16];
    private float l = 1.0f;
    private float m = 1.0f;
    private boolean n = false;
    private boolean o = true;
    private final float[] p = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    private FloatBuffer q;
    private float[] r = new float[16];
    private float[] s = new float[16];
    private int t;
    private int u = -12345;
    private int v = -12345;
    private int w;
    private int x;
    private int y;
    private int z;

    public void a(int i2, int i3) {
        AppMethodBeat.i(16906);
        if (i2 == this.f1149c && i3 == this.f1150d) {
            AppMethodBeat.o(16906);
            return;
        }
        TXCLog.i("TXTweenFilter", "Output resolution change: " + this.f1149c + "*" + this.f1150d + " -> " + i2 + "*" + i3);
        this.f1149c = i2;
        this.f1150d = i3;
        Matrix.orthoM(this.f1156j, 0, -1.0f, 1.0f, -1.0f, 1.0f, -1.0f, 1.0f);
        this.l = 1.0f;
        this.m = 1.0f;
        this.n = true;
        AppMethodBeat.o(16906);
    }

    public void b(int i2, int i3) {
        AppMethodBeat.i(16907);
        if (i2 == this.f1151e && i3 == this.f1152f) {
            AppMethodBeat.o(16907);
            return;
        }
        TXCLog.i("TXTweenFilter", "Input resolution change: " + this.f1151e + "*" + this.f1152f + " -> " + i2 + "*" + i3);
        this.f1151e = i2;
        this.f1152f = i3;
        AppMethodBeat.o(16907);
    }

    public boolean a() {
        return this.o;
    }

    public void a(int i2) {
        this.f1153g = i2;
    }

    public void b(int i2) {
        this.f1154h = i2;
    }

    private void b(float[] fArr) {
        AppMethodBeat.i(16908);
        if (this.f1150d == 0 || this.f1149c == 0) {
            AppMethodBeat.o(16908);
            return;
        }
        int i2 = this.f1151e;
        int i3 = this.f1152f;
        if (this.f1154h == 270 || this.f1154h == 90) {
            i2 = this.f1152f;
            i3 = this.f1151e;
        }
        float f2 = (((float) this.f1149c) * 1.0f) / ((float) i2);
        float f3 = (((float) this.f1150d) * 1.0f) / ((float) i3);
        if (this.f1153g != f1147a ? ((float) i3) * f2 <= ((float) this.f1150d) : ((float) i3) * f2 > ((float) this.f1150d)) {
            f3 = f2;
        }
        Matrix.setIdentityM(this.k, 0);
        if (this.f1155i) {
            if (this.f1154h % TXLiveConstants.RENDER_ROTATION_180 == 0) {
                Matrix.scaleM(this.k, 0, -1.0f, 1.0f, 1.0f);
            } else {
                Matrix.scaleM(this.k, 0, 1.0f, -1.0f, 1.0f);
            }
        }
        Matrix.scaleM(this.k, 0, ((((float) i2) * f3) / ((float) this.f1149c)) * 1.0f, ((((float) i3) * f3) / ((float) this.f1150d)) * 1.0f, 1.0f);
        Matrix.rotateM(this.k, 0, (float) this.f1154h, 0.0f, 0.0f, -1.0f);
        Matrix.multiplyMM(fArr, 0, this.f1156j, 0, this.k, 0);
        AppMethodBeat.o(16908);
    }

    public h(Boolean bool) {
        AppMethodBeat.i(16909);
        this.o = bool.booleanValue();
        this.q = ByteBuffer.allocateDirect(this.p.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.q.put(this.p).position(0);
        Matrix.setIdentityM(this.s, 0);
        AppMethodBeat.o(16909);
    }

    public void a(boolean z2) {
        this.f1155i = z2;
    }

    public void a(float[] fArr) {
        this.s = fArr;
    }

    public void c(int i2) {
        AppMethodBeat.i(16910);
        GLES20.glViewport(0, 0, this.f1149c, this.f1150d);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16640);
        GLES20.glUseProgram(this.t);
        a("glUseProgram");
        if (this.o) {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(36197, i2);
        } else {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i2);
        }
        this.q.position(0);
        GLES20.glVertexAttribPointer(this.y, 3, 5126, false, 20, (Buffer) this.q);
        a("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(this.y);
        a("glEnableVertexAttribArray maPositionHandle");
        this.q.position(3);
        GLES20.glVertexAttribPointer(this.z, 2, 5126, false, 20, (Buffer) this.q);
        a("glVertexAttribPointer maTextureHandle");
        GLES20.glEnableVertexAttribArray(this.z);
        a("glEnableVertexAttribArray maTextureHandle");
        Matrix.setIdentityM(this.r, 0);
        b(this.r);
        GLES20.glUniformMatrix4fv(this.w, 1, false, this.r, 0);
        GLES20.glUniformMatrix4fv(this.x, 1, false, this.s, 0);
        a("glDrawArrays");
        GLES20.glDrawArrays(5, 0, 4);
        a("glDrawArrays");
        if (this.o) {
            GLES20.glBindTexture(36197, 0);
            AppMethodBeat.o(16910);
            return;
        }
        GLES20.glBindTexture(3553, 0);
        AppMethodBeat.o(16910);
    }

    public int d(int i2) {
        AppMethodBeat.i(16911);
        d();
        if (this.v == -12345) {
            TXCLog.d("TXTweenFilter", "invalid frame buffer id");
            AppMethodBeat.o(16911);
            return i2;
        }
        GLES20.glBindFramebuffer(36160, this.v);
        c(i2);
        GLES20.glBindFramebuffer(36160, 0);
        int i3 = this.u;
        AppMethodBeat.o(16911);
        return i3;
    }

    public void b() {
        AppMethodBeat.i(16912);
        if (this.o) {
            this.t = a("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
        } else {
            this.t = a("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "varying highp vec2 vTextureCoord;\n \nuniform sampler2D sTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(sTexture, vTextureCoord);\n}");
        }
        if (this.t == 0) {
            TXCLog.e("TXTweenFilter", "failed creating program");
            AppMethodBeat.o(16912);
            return;
        }
        this.y = GLES20.glGetAttribLocation(this.t, "aPosition");
        a("glGetAttribLocation aPosition");
        if (this.y == -1) {
            TXCLog.e("TXTweenFilter", "Could not get attrib location for aPosition");
            AppMethodBeat.o(16912);
            return;
        }
        this.z = GLES20.glGetAttribLocation(this.t, "aTextureCoord");
        a("glGetAttribLocation aTextureCoord");
        if (this.z == -1) {
            TXCLog.e("TXTweenFilter", "Could not get attrib location for aTextureCoord");
            AppMethodBeat.o(16912);
            return;
        }
        this.w = GLES20.glGetUniformLocation(this.t, "uMVPMatrix");
        a("glGetUniformLocation uMVPMatrix");
        if (this.w == -1) {
            TXCLog.e("TXTweenFilter", "Could not get attrib location for uMVPMatrix");
            AppMethodBeat.o(16912);
            return;
        }
        this.x = GLES20.glGetUniformLocation(this.t, "uSTMatrix");
        a("glGetUniformLocation uSTMatrix");
        if (this.x == -1) {
            TXCLog.e("TXTweenFilter", "Could not get attrib location for uSTMatrix");
            AppMethodBeat.o(16912);
            return;
        }
        AppMethodBeat.o(16912);
    }

    private void d() {
        AppMethodBeat.i(16913);
        if (!this.n) {
            AppMethodBeat.o(16913);
            return;
        }
        TXCLog.i("TXTweenFilter", "reloadFrameBuffer. size = " + this.f1149c + "*" + this.f1150d);
        e();
        int[] iArr = new int[1];
        int[] iArr2 = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.u = iArr[0];
        this.v = iArr2[0];
        TXCLog.d("TXTweenFilter", "frameBuffer id = " + this.v + ", texture id = " + this.u);
        GLES20.glBindTexture(3553, this.u);
        a("glBindTexture mFrameBufferTextureID");
        GLES20.glTexImage2D(3553, 0, NativeBitmapStruct.GLFormat.GL_RGBA, this.f1149c, this.f1150d, 0, NativeBitmapStruct.GLFormat.GL_RGBA, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, Task.EXTRAS_LIMIT_BYTES, 9729.0f);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        a("glTexParameter");
        GLES20.glBindFramebuffer(36160, this.v);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.u, 0);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
        this.n = false;
        AppMethodBeat.o(16913);
    }

    public void c() {
        AppMethodBeat.i(16914);
        GLES20.glDeleteProgram(this.t);
        e();
        AppMethodBeat.o(16914);
    }

    private void e() {
        AppMethodBeat.i(16915);
        if (this.v != -12345) {
            GLES20.glDeleteFramebuffers(1, new int[]{this.v}, 0);
            this.v = -12345;
        }
        if (this.u != -12345) {
            GLES20.glDeleteTextures(1, new int[]{this.u}, 0);
            this.u = -12345;
        }
        AppMethodBeat.o(16915);
    }

    private int a(int i2, String str) {
        int i3 = 0;
        AppMethodBeat.i(16916);
        int glCreateShader = GLES20.glCreateShader(i2);
        a("glCreateShader type=".concat(String.valueOf(i2)));
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            TXCLog.e("TXTweenFilter", "Could not compile shader " + i2 + ":");
            TXCLog.e("TXTweenFilter", " " + GLES20.glGetShaderInfoLog(glCreateShader));
            GLES20.glDeleteShader(glCreateShader);
        } else {
            i3 = glCreateShader;
        }
        AppMethodBeat.o(16916);
        return i3;
    }

    private int a(String str, String str2) {
        int i2 = 0;
        AppMethodBeat.i(16917);
        int a2 = a(35633, str);
        if (a2 == 0) {
            AppMethodBeat.o(16917);
        } else {
            int a3 = a(35632, str2);
            if (a3 == 0) {
                AppMethodBeat.o(16917);
            } else {
                int glCreateProgram = GLES20.glCreateProgram();
                a("glCreateProgram");
                if (glCreateProgram == 0) {
                    TXCLog.e("TXTweenFilter", "Could not create program");
                }
                GLES20.glAttachShader(glCreateProgram, a2);
                a("glAttachShader");
                GLES20.glAttachShader(glCreateProgram, a3);
                a("glAttachShader");
                GLES20.glLinkProgram(glCreateProgram);
                int[] iArr = new int[1];
                GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
                if (iArr[0] != 1) {
                    TXCLog.e("TXTweenFilter", "Could not link program: ");
                    TXCLog.e("TXTweenFilter", GLES20.glGetProgramInfoLog(glCreateProgram));
                    GLES20.glDeleteProgram(glCreateProgram);
                } else {
                    i2 = glCreateProgram;
                }
                AppMethodBeat.o(16917);
            }
        }
        return i2;
    }

    private void a(String str) {
        AppMethodBeat.i(16918);
        while (true) {
            int glGetError = GLES20.glGetError();
            if (glGetError != 0) {
                TXCLog.e("TXTweenFilter", str + ": glError " + glGetError);
            } else {
                AppMethodBeat.o(16918);
                return;
            }
        }
    }
}
