package com.tencent.mm.plugin.voip.video.b;

import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.google.android.gms.gcm.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.a;
import com.tencent.mm.media.g.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;

public final class b {
    FloatBuffer HlA;
    byte[] HlB;
    private int Hle;
    private int Hlf;
    private int Hlg;
    private int Hlh;
    private int Hli;
    private int Hlj;
    int Hlk = 0;
    int Hll = 0;
    int Hlm = 0;
    private a Hln = null;
    private d Hlo = null;
    FloatBuffer Hlp;
    private FloatBuffer Hlq;
    private FloatBuffer Hlr;
    private int Hls;
    private int Hlt;
    ByteBuffer Hlu;
    private int Hlv;
    private int Hlw;
    float[] Hlx = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    float[] Hly = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    private int Hlz = 0;
    public int outputHeight = 0;
    public int outputWidth = 0;
    public int surfaceHeight;
    public int surfaceWidth;

    public b() {
        AppMethodBeat.i(115717);
        AppMethodBeat.o(115717);
    }

    public final void rl(int i2) {
        AppMethodBeat.i(235894);
        Log.i("MicroMsg.VoipGLSProgram", "set input texture:%s", Integer.valueOf(i2));
        this.Hlm = i2;
        AppMethodBeat.o(235894);
    }

    public final void jJ(int i2, int i3) {
        AppMethodBeat.i(115718);
        Log.i("MicroMsg.VoipGLSProgram", "initOutputFrameBuffer, width:%s, height:%s, frameBufferTextureOutput:%s, frameBufferOutput:%s", Integer.valueOf(i2), Integer.valueOf(i3), this.Hlo, this.Hln);
        if (this.Hln != null) {
            this.Hln.close();
        }
        if (this.Hlo != null) {
            this.Hlo.close();
        }
        this.Hlv = i2;
        this.Hlw = i3;
        this.Hlo = f.fLz();
        this.Hln = f.fLA();
        GLES20.glBindTexture(3553, this.Hlo.igv);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, Task.EXTRAS_LIMIT_BYTES, 9729);
        GLES20.glTexParameteri(3553, 10242, 10497);
        GLES20.glTexParameteri(3553, 10243, 10497);
        GLES20.glTexImage2D(3553, 0, NativeBitmapStruct.GLFormat.GL_RGBA, this.Hlv, this.Hlw, 0, NativeBitmapStruct.GLFormat.GL_RGBA, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
        GLES20.glBindTexture(3553, 0);
        AppMethodBeat.o(115718);
    }

    private void a(int i2, int i3, FloatBuffer floatBuffer, FloatBuffer floatBuffer2, boolean z) {
        AppMethodBeat.i(115719);
        GLES20.glUseProgram(i2);
        this.Hls = GLES20.glGetAttribLocation(i2, "vPosition");
        GLES20.glEnableVertexAttribArray(this.Hls);
        GLES20.glVertexAttribPointer(this.Hls, 2, 5126, false, 8, (Buffer) floatBuffer);
        this.Hlt = GLES20.glGetAttribLocation(i2, "vTexCoord");
        GLES20.glEnableVertexAttribArray(this.Hlt);
        GLES20.glVertexAttribPointer(this.Hlt, 2, 5126, false, 8, (Buffer) floatBuffer2);
        if (z) {
            this.Hle = GLES20.glGetUniformLocation(i2, "smoothDegree");
            GLES20.glUniform1f(this.Hle, 0.5f);
            this.Hlf = GLES20.glGetUniformLocation(i2, "showCounter");
            GLES20.glUniform1i(this.Hlf, 0);
            this.Hlg = GLES20.glGetUniformLocation(i2, "showMode");
            GLES20.glUniform1i(this.Hlg, 2);
            this.Hlh = GLES20.glGetUniformLocation(i2, "brightness");
            GLES20.glUniform1f(this.Hlh, 0.8f);
            this.Hli = GLES20.glGetUniformLocation(i2, "texelWidth");
            GLES20.glUniform1f(this.Hli, (float) this.Hlv);
            this.Hlj = GLES20.glGetUniformLocation(i2, "texelHeight");
            GLES20.glUniform1f(this.Hlj, (float) this.Hlw);
        }
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i3);
        GLES20.glUniform1i(GLES20.glGetAttribLocation(i2, "inputImageTexture"), 0);
        AppMethodBeat.o(115719);
    }

    public final void fLD() {
        AppMethodBeat.i(235895);
        if (this.Hln == null || this.Hlv <= 0 || this.Hlw <= 0) {
            jJ(this.outputWidth, this.outputHeight);
        }
        O(this.Hln.igo, this.Hlo.igv, this.Hlv, this.Hlw);
        a(this.Hlk, this.Hlm, this.Hlp, this.HlA, true);
        xy(true);
        O(0, 0, 0, 0);
        a(this.Hll, this.Hlo.igv, this.Hlr, this.Hlq, false);
        xy(false);
        AppMethodBeat.o(235895);
    }

    public final void c(float[] fArr, float[] fArr2) {
        AppMethodBeat.i(235896);
        if (!(fArr2 == null || fArr == null)) {
            float[] copyOf = Arrays.copyOf(fArr2, fArr2.length);
            q(copyOf);
            if (this.Hlq == null || this.Hlq.capacity() < copyOf.length) {
                this.Hlq = ByteBuffer.allocateDirect(copyOf.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            }
            this.Hlq.put(copyOf);
            this.Hlq.position(0);
            float[] copyOf2 = Arrays.copyOf(fArr, fArr.length);
            if (this.Hlr == null || this.Hlr.capacity() < copyOf2.length) {
                this.Hlr = ByteBuffer.allocateDirect(copyOf2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            }
            this.Hlr.put(copyOf2);
            this.Hlr.position(0);
        }
        AppMethodBeat.o(235896);
    }

    static void q(float[] fArr) {
        AppMethodBeat.i(115720);
        swap(fArr, 0, 6);
        swap(fArr, 1, 7);
        swap(fArr, 2, 4);
        swap(fArr, 3, 5);
        AppMethodBeat.o(115720);
    }

    private static void swap(float[] fArr, int i2, int i3) {
        float f2 = fArr[i2];
        fArr[i2] = fArr[i3];
        fArr[i3] = f2;
    }

    private void xy(boolean z) {
        AppMethodBeat.i(115721);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16640);
        if (z) {
            GLES20.glViewport(0, 0, this.outputWidth, this.outputHeight);
            GLES20.glDrawArrays(5, 0, 4);
            fLE();
        } else {
            GLES20.glViewport(0, 0, this.surfaceWidth, this.surfaceHeight);
            GLES20.glDrawArrays(5, 0, 4);
        }
        GLES20.glUseProgram(0);
        GLES20.glDisableVertexAttribArray(this.Hls);
        GLES20.glDisableVertexAttribArray(this.Hlt);
        AppMethodBeat.o(115721);
    }

    private void fLE() {
        AppMethodBeat.i(235897);
        if (this.Hlu == null || this.Hlu.capacity() < this.outputHeight * this.outputWidth * 4) {
            this.Hlu = ByteBuffer.allocateDirect(this.outputHeight * this.outputWidth * 4).order(ByteOrder.nativeOrder());
        }
        this.Hlu.position(0);
        GLES20.glReadPixels(0, 0, this.outputWidth, this.outputHeight, NativeBitmapStruct.GLFormat.GL_RGBA, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, this.Hlu);
        this.Hlu.position(0);
        this.HlB = this.Hlu.array();
        O(0, 0, 0, 0);
        AppMethodBeat.o(235897);
    }

    private static void O(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(115722);
        GLES20.glBindFramebuffer(36160, i2);
        if (i2 > 0) {
            GLES20.glBindTexture(3553, i3);
            GLES20.glTexImage2D(3553, 0, NativeBitmapStruct.GLFormat.GL_RGBA, i4, i5, 0, NativeBitmapStruct.GLFormat.GL_RGBA, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, i3, 0);
            GLES20.glBindTexture(3553, 0);
        }
        AppMethodBeat.o(115722);
    }

    public final void fLF() {
        AppMethodBeat.i(115723);
        Log.i("MicroMsg.VoipGLSProgram", "%s do destroy", Integer.valueOf(hashCode()));
        if (this.Hln != null) {
            this.Hln.close();
        }
        if (this.Hlo != null) {
            this.Hlo.close();
        }
        GLES20.glDeleteProgram(this.Hlk);
        GLES20.glDeleteProgram(this.Hll);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16640);
        GLES20.glFinish();
        if (this.Hlq != null) {
            this.Hlq.clear();
        }
        if (this.Hlp != null) {
            this.Hlp.clear();
        }
        if (this.HlA != null) {
            this.HlA.clear();
        }
        this.HlA = null;
        this.Hlp = null;
        this.Hlq = null;
        this.Hlk = 0;
        this.Hll = 0;
        this.Hln = null;
        this.Hlo = null;
        this.surfaceWidth = 0;
        this.surfaceHeight = 0;
        this.Hlw = 0;
        this.Hlv = 0;
        this.outputHeight = 0;
        this.outputWidth = 0;
        AppMethodBeat.o(115723);
    }
}
