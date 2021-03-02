package com.tencent.liteav.renderer;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.google.android.gms.gcm.Task;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f1092a = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: b  reason: collision with root package name */
    private final float[] f1093b = {1.0f, -1.0f, 0.0f, 1.0f, 1.0f, -1.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 0.0f};

    /* renamed from: c  reason: collision with root package name */
    private FloatBuffer f1094c;

    /* renamed from: d  reason: collision with root package name */
    private float[] f1095d = new float[16];

    /* renamed from: e  reason: collision with root package name */
    private float[] f1096e = new float[16];

    /* renamed from: f  reason: collision with root package name */
    private int f1097f;

    /* renamed from: g  reason: collision with root package name */
    private int f1098g = -12345;

    /* renamed from: h  reason: collision with root package name */
    private int f1099h;

    /* renamed from: i  reason: collision with root package name */
    private int f1100i;

    /* renamed from: j  reason: collision with root package name */
    private int f1101j;
    private int k;
    private boolean l = false;
    private boolean m = true;
    private boolean n = false;
    private int o = -1;
    private int p = 0;
    private int q = 0;

    public c(boolean z) {
        AppMethodBeat.i(16731);
        this.m = z;
        if (this.m) {
            this.f1094c = ByteBuffer.allocateDirect(this.f1092a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.f1094c.put(this.f1092a).position(0);
        } else {
            this.f1094c = ByteBuffer.allocateDirect(this.f1093b.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.f1094c.put(this.f1093b).position(0);
        }
        Matrix.setIdentityM(this.f1096e, 0);
        AppMethodBeat.o(16731);
    }

    public int a() {
        return this.f1098g;
    }

    public void a(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(16732);
        if (surfaceTexture == null) {
            AppMethodBeat.o(16732);
            return;
        }
        a("onDrawFrame start");
        surfaceTexture.getTransformMatrix(this.f1096e);
        b(36197, this.f1098g);
        AppMethodBeat.o(16732);
    }

    public void a(int i2, int i3) {
        this.p = i2;
        this.q = i3;
    }

    public void a(int i2, boolean z, int i3) {
        AppMethodBeat.i(16733);
        if (!(this.n == z && this.o == i3)) {
            this.n = z;
            this.o = i3;
            float[] fArr = new float[20];
            for (int i4 = 0; i4 < 20; i4++) {
                fArr[i4] = this.f1093b[i4];
            }
            if (this.n) {
                fArr[0] = -fArr[0];
                fArr[5] = -fArr[5];
                fArr[10] = -fArr[10];
                fArr[15] = -fArr[15];
            }
            int i5 = i3 / 90;
            for (int i6 = 0; i6 < i5; i6++) {
                float f2 = fArr[3];
                float f3 = fArr[4];
                fArr[3] = fArr[8];
                fArr[4] = fArr[9];
                fArr[8] = fArr[18];
                fArr[9] = fArr[19];
                fArr[18] = fArr[13];
                fArr[19] = fArr[14];
                fArr[13] = f2;
                fArr[14] = f3;
            }
            this.f1094c.clear();
            this.f1094c.put(fArr).position(0);
        }
        b(3553, i2);
        AppMethodBeat.o(16733);
    }

    private void b(int i2, int i3) {
        AppMethodBeat.i(16734);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16640);
        if (this.l) {
            this.l = false;
            AppMethodBeat.o(16734);
            return;
        }
        GLES20.glUseProgram(this.f1097f);
        a("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(i2, i3);
        this.f1094c.position(0);
        GLES20.glVertexAttribPointer(this.f1101j, 3, 5126, false, 20, (Buffer) this.f1094c);
        a("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(this.f1101j);
        a("glEnableVertexAttribArray maPositionHandle");
        this.f1094c.position(3);
        GLES20.glVertexAttribPointer(this.k, 2, 5126, false, 20, (Buffer) this.f1094c);
        a("glVertexAttribPointer maTextureHandle");
        GLES20.glEnableVertexAttribArray(this.k);
        a("glEnableVertexAttribArray maTextureHandle");
        Matrix.setIdentityM(this.f1095d, 0);
        GLES20.glUniformMatrix4fv(this.f1099h, 1, false, this.f1095d, 0);
        if (this.p % 8 != 0) {
            Matrix.scaleM(this.f1096e, 0, (((float) (this.p - 1)) * 1.0f) / ((float) (((this.p + 7) / 8) * 8)), 1.0f, 1.0f);
        }
        if (this.q % 8 != 0) {
            Matrix.scaleM(this.f1096e, 0, 1.0f, (((float) (this.q - 1)) * 1.0f) / ((float) (((this.q + 7) / 8) * 8)), 1.0f);
        }
        GLES20.glUniformMatrix4fv(this.f1100i, 1, false, this.f1096e, 0);
        GLES20.glDrawArrays(5, 0, 4);
        a("glDrawArrays");
        GLES20.glFinish();
        AppMethodBeat.o(16734);
    }

    public void b() {
        AppMethodBeat.i(16735);
        if (this.m) {
            this.f1097f = a("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
        } else {
            this.f1097f = a("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "varying highp vec2 vTextureCoord;\n \nuniform sampler2D sTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(sTexture, vTextureCoord);\n}");
        }
        if (this.f1097f == 0) {
            TXCLog.e("TXCOesTextureRender", "failed creating program");
            AppMethodBeat.o(16735);
            return;
        }
        this.f1101j = GLES20.glGetAttribLocation(this.f1097f, "aPosition");
        a("glGetAttribLocation aPosition");
        if (this.f1101j == -1) {
            TXCLog.e("TXCOesTextureRender", "Could not get attrib location for aPosition");
            AppMethodBeat.o(16735);
            return;
        }
        this.k = GLES20.glGetAttribLocation(this.f1097f, "aTextureCoord");
        a("glGetAttribLocation aTextureCoord");
        if (this.k == -1) {
            TXCLog.e("TXCOesTextureRender", "Could not get attrib location for aTextureCoord");
            AppMethodBeat.o(16735);
            return;
        }
        this.f1099h = GLES20.glGetUniformLocation(this.f1097f, "uMVPMatrix");
        a("glGetUniformLocation uMVPMatrix");
        if (this.f1099h == -1) {
            TXCLog.e("TXCOesTextureRender", "Could not get attrib location for uMVPMatrix");
            AppMethodBeat.o(16735);
            return;
        }
        this.f1100i = GLES20.glGetUniformLocation(this.f1097f, "uSTMatrix");
        a("glGetUniformLocation uSTMatrix");
        if (this.f1100i == -1) {
            TXCLog.e("TXCOesTextureRender", "Could not get attrib location for uSTMatrix");
            AppMethodBeat.o(16735);
            return;
        }
        if (this.m) {
            d();
        }
        GLES20.glTexParameterf(36197, 10241, 9729.0f);
        GLES20.glTexParameterf(36197, Task.EXTRAS_LIMIT_BYTES, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        a("glTexParameter");
        AppMethodBeat.o(16735);
    }

    public void c() {
        AppMethodBeat.i(16736);
        if (this.f1097f != 0) {
            GLES20.glDeleteProgram(this.f1097f);
        }
        GLES20.glDeleteTextures(1, new int[]{this.f1098g}, 0);
        this.f1098g = -1;
        AppMethodBeat.o(16736);
    }

    private void d() {
        AppMethodBeat.i(16737);
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.f1098g = iArr[0];
        GLES20.glBindTexture(36197, this.f1098g);
        a("glBindTexture mTextureID");
        AppMethodBeat.o(16737);
    }

    private int a(int i2, String str) {
        int i3 = 0;
        AppMethodBeat.i(16738);
        int glCreateShader = GLES20.glCreateShader(i2);
        a("glCreateShader type=".concat(String.valueOf(i2)));
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            TXCLog.e("TXCOesTextureRender", "Could not compile shader " + i2 + ":");
            TXCLog.e("TXCOesTextureRender", " " + GLES20.glGetShaderInfoLog(glCreateShader));
            GLES20.glDeleteShader(glCreateShader);
        } else {
            i3 = glCreateShader;
        }
        AppMethodBeat.o(16738);
        return i3;
    }

    private int a(String str, String str2) {
        int i2 = 0;
        AppMethodBeat.i(16739);
        int a2 = a(35633, str);
        if (a2 == 0) {
            AppMethodBeat.o(16739);
        } else {
            int a3 = a(35632, str2);
            if (a3 == 0) {
                AppMethodBeat.o(16739);
            } else {
                int glCreateProgram = GLES20.glCreateProgram();
                a("glCreateProgram");
                if (glCreateProgram == 0) {
                    TXCLog.e("TXCOesTextureRender", "Could not create program");
                }
                GLES20.glAttachShader(glCreateProgram, a2);
                a("glAttachShader");
                GLES20.glAttachShader(glCreateProgram, a3);
                a("glAttachShader");
                GLES20.glLinkProgram(glCreateProgram);
                int[] iArr = new int[1];
                GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
                if (iArr[0] != 1) {
                    TXCLog.e("TXCOesTextureRender", "Could not link program: ");
                    TXCLog.e("TXCOesTextureRender", GLES20.glGetProgramInfoLog(glCreateProgram));
                    GLES20.glDeleteProgram(glCreateProgram);
                } else {
                    i2 = glCreateProgram;
                }
                AppMethodBeat.o(16739);
            }
        }
        return i2;
    }

    public void a(String str) {
        AppMethodBeat.i(16740);
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            TXCLog.e("TXCOesTextureRender", str + ": glError " + glGetError);
            AppMethodBeat.o(16740);
            return;
        }
        AppMethodBeat.o(16740);
    }
}
