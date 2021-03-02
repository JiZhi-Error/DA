package com.tencent.mm.plugin.voip.video.c;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.c;
import com.tencent.mm.media.g.d;
import com.tencent.mm.plugin.voip.video.b.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public final class a {
    private d[] HlF = new d[3];
    private int[] HlG = new int[3];
    private FloatBuffer HlH;
    public float[] HlR = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    public float[] HlS = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    private float[] HlT = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    private float[] HlU = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    private int mPositionHandle = -1;
    private int mProgram = 0;
    private FloatBuffer mVertexBuffer;
    private int outputHeight = 0;
    private int outputWidth = 0;
    private int surfaceHeight = 0;
    private int surfaceWidth = 0;

    public a() {
        AppMethodBeat.i(235906);
        fLF();
        fLI();
        AppMethodBeat.o(235906);
    }

    public final void a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i2, int i3) {
        AppMethodBeat.i(235908);
        a(byteBuffer, i2, i3, 0);
        a(byteBuffer2, i2 / 2, i3 / 2, 1);
        a(byteBuffer3, i2 / 2, i3 / 2, 2);
        AppMethodBeat.o(235908);
    }

    private void a(ByteBuffer byteBuffer, int i2, int i3, int i4) {
        AppMethodBeat.i(235909);
        this.HlF[i4].a(i2, i3, 6409, byteBuffer, 9729, 33071);
        AppMethodBeat.o(235909);
    }

    public final void d(float[] fArr, float[] fArr2) {
        AppMethodBeat.i(235910);
        if (this.mVertexBuffer == null || this.mVertexBuffer.capacity() != fArr.length) {
            this.mVertexBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        }
        this.mVertexBuffer.put(fArr);
        this.mVertexBuffer.position(0);
        if (this.HlH == null || this.HlH.capacity() != fArr2.length) {
            this.HlH = ByteBuffer.allocateDirect(fArr2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        }
        this.HlH.put(fArr2);
        this.HlH.position(0);
        AppMethodBeat.o(235910);
    }

    private void fLI() {
        AppMethodBeat.i(235911);
        this.mProgram = f.createProgram("attribute vec4 vPosition;attribute vec2 vTexCoord;varying vec2 tc;void main() {  gl_Position = vPosition;  tc = vTexCoord;}", "precision highp float;uniform sampler2D samplerY;uniform sampler2D samplerU;uniform sampler2D samplerV;uniform sampler2D samplerUV;uniform int yuvType;varying vec2 tc;void main() {  vec4 c = vec4((texture2D(samplerY, tc).r - 16./255.) * 1.164);  vec4 U; vec4 V; if (yuvType == 0 || yuvType == 1){      U = vec4(texture2D(samplerU, tc).r - 128./255.);      V = vec4(texture2D(samplerV, tc).r - 128./255.);  } else {      U = vec4(texture2D(samplerUV, tc).a - 128./255.);      V = vec4(texture2D(samplerUV, tc).r - 128./255.);  }   c += V * vec4(1.596, -0.813, 0, 0);  c += U * vec4(0, -0.392, 2.017, 0);  c.a = 1.0;  gl_FragColor = c;}");
        for (int i2 = 0; i2 < this.HlF.length; i2++) {
            this.HlF[i2] = c.a(true, 14);
        }
        this.mPositionHandle = GLES20.glGetAttribLocation(this.mProgram, "vPosition");
        AppMethodBeat.o(235911);
    }

    public final synchronized void fLF() {
        synchronized (this) {
            AppMethodBeat.i(235912);
            Log.i("MicroMsg.VoipGLSProgram", "%s do destroy", Integer.valueOf(hashCode()));
            d[] dVarArr = this.HlF;
            for (d dVar : dVarArr) {
                if (dVar != null) {
                    dVar.close();
                }
            }
            GLES20.glDeleteProgram(this.mProgram);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(16640);
            GLES20.glFinish();
            if (this.HlH != null) {
                this.HlH.clear();
            }
            if (this.mVertexBuffer != null) {
                this.mVertexBuffer.clear();
            }
            this.mVertexBuffer = null;
            this.HlH = null;
            this.mProgram = 0;
            AppMethodBeat.o(235912);
        }
    }

    public final void fLO() {
        AppMethodBeat.i(235907);
        GLES20.glUseProgram(this.mProgram);
        this.mPositionHandle = GLES20.glGetAttribLocation(this.mProgram, "vPosition");
        GLES20.glEnableVertexAttribArray(this.mPositionHandle);
        GLES20.glVertexAttribPointer(this.mPositionHandle, 2, 5126, false, 8, (Buffer) this.mVertexBuffer);
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.mProgram, "vTexCoord");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        GLES20.glVertexAttribPointer(glGetAttribLocation, 2, 5126, false, 8, (Buffer) this.HlH);
        this.HlG[0] = GLES20.glGetUniformLocation(this.mProgram, "samplerY");
        this.HlG[1] = GLES20.glGetUniformLocation(this.mProgram, "samplerU");
        this.HlG[2] = GLES20.glGetUniformLocation(this.mProgram, "samplerV");
        for (int i2 = 0; i2 < 3; i2++) {
            GLES20.glActiveTexture(33984 + i2);
            GLES20.glBindTexture(3553, this.HlF[i2].igv);
            GLES20.glUniform1i(this.HlG[i2], i2);
        }
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.mProgram, "yuvType");
        if (glGetUniformLocation >= 0) {
            GLES20.glUniform1i(glGetUniformLocation, 0);
        }
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glFinish();
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glUseProgram(0);
        AppMethodBeat.o(235907);
    }
}
