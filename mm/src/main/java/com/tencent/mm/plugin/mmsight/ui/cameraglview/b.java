package com.tencent.mm.plugin.mmsight.ui.cameraglview;

import android.graphics.Point;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.google.android.gms.gcm.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class b implements GLSurfaceView.Renderer {
    static float[] ilm = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    private static final float[] iln = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    static float[] kxU = {-1.0f, -0.5f, 1.0f, -0.5f, -1.0f, 0.5f, 1.0f, 0.5f};
    private int dYT = 0;
    private byte[] frameData = null;
    private FloatBuffer hDT;
    private FloatBuffer hDU;
    private int hEy;
    private int hEz;
    private int ikE;
    ByteBuffer ikI;
    private int ikO;
    ByteBuffer ikP;
    private boolean iqo = false;
    boolean kxV = false;
    private int kxW = 0;
    private int kxX = 0;
    private int kxY;
    private int kxZ;
    private int kya;
    private float[] kyb = new float[16];
    boolean kyc = false;
    private float[] kyd = ilm;
    private int programId;
    private int surfaceHeight = 0;
    private int surfaceWidth = 0;

    public b() {
        AppMethodBeat.i(94767);
        Point ejr = d.ejr();
        float f2 = (((float) ejr.x) / ((float) ejr.y)) / 2.0f;
        kxU = new float[]{-1.0f, -f2, 1.0f, -f2, -1.0f, f2, 1.0f, f2};
        AppMethodBeat.o(94767);
    }

    public final void b(byte[] bArr, int i2, int i3, int i4, boolean z) {
        boolean z2;
        AppMethodBeat.i(94768);
        try {
            if (this.kxX == i3 && this.kxW == i2 && this.dYT == i4 && this.iqo == z) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                Log.d("MicroMsg.MMSightCameraGLRenderer", "setDrawFrame, frameData: %s, frameWidth: %s, frameHeight: %s, rotate: %s, isLandScape, frameSizeChange: %s, this %s", bArr, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), Boolean.TRUE, this);
            }
            this.frameData = bArr;
            this.kxW = i2;
            this.kxX = i3;
            this.dYT = i4;
            this.iqo = z;
            if (z2) {
                this.ikI = ByteBuffer.allocateDirect(i3 * i2);
                this.ikP = ByteBuffer.allocateDirect((i2 * i3) / 2);
                this.ikI.order(ByteOrder.nativeOrder());
                this.ikP.order(ByteOrder.nativeOrder());
                if (!z) {
                    this.kyd = ilm;
                } else {
                    this.kyd = kxU;
                }
                if (this.kyd != null) {
                    this.hDU.put(this.kyd);
                    this.hDU.position(0);
                }
            }
            if (!(this.ikI == null || this.ikP == null)) {
                this.ikI.put(bArr, 0, i2 * i3);
                this.ikI.position(0);
                this.ikP.put(bArr, i2 * i3, (i2 * i3) / 2);
                this.ikP.position(0);
            }
            AppMethodBeat.o(94768);
        } catch (Exception e2) {
            Log.e("MicroMsg.MMSightCameraGLRenderer", "setDrawFrame error: %s", e2.getMessage());
            AppMethodBeat.o(94768);
        }
    }

    public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        AppMethodBeat.i(94769);
        Log.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated this %s", this);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glDisable(2929);
        this.programId = com.tencent.mm.plugin.api.recordView.b.aB("attribute vec4 a_position;                         \nattribute vec2 a_texCoord;                         \nvarying vec2 v_texCoord;                           \nuniform mat4 uMatrix;                              \nvoid main() {                                      \n   gl_Position = uMatrix * a_position;             \n   v_texCoord = a_texCoord;                        \n}                                                  \n", "#ifdef GL_ES                                       \nprecision highp float;                             \n#endif                                             \nvarying vec2 v_texCoord;                           \nuniform sampler2D y_texture;                       \nuniform sampler2D uv_texture;                      \nvoid main (void) {                                 \n   float r, g, b, y, u, v;                         \n   y = texture2D(y_texture, v_texCoord).r;         \n   u = texture2D(uv_texture, v_texCoord).a;        \n   v = texture2D(uv_texture, v_texCoord).r;        \n   u = u - 0.5;                                    \n   v = v - 0.5;                                    \n   r = y + 1.370705 * v;                           \n   g = y - 0.337633 * u - 0.698001 * v;            \n   b = y + 1.732446 * u;                           \n   gl_FragColor = vec4(r, g, b, 1.0);              \n}                                                  \n");
        if (this.programId == 0) {
            Log.e("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated, load program failed!");
        }
        this.hEy = GLES20.glGetAttribLocation(this.programId, "a_position");
        this.hEz = GLES20.glGetAttribLocation(this.programId, "a_texCoord");
        this.ikE = GLES20.glGetUniformLocation(this.programId, "y_texture");
        this.ikO = GLES20.glGetUniformLocation(this.programId, "uv_texture");
        this.kya = GLES20.glGetUniformLocation(this.programId, "uMatrix");
        this.kxY = com.tencent.mm.plugin.api.recordView.b.aMZ();
        this.kxZ = com.tencent.mm.plugin.api.recordView.b.aMZ();
        this.hDU = ByteBuffer.allocateDirect(this.kyd.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.hDU.put(this.kyd);
        this.hDU.position(0);
        this.hDT = ByteBuffer.allocateDirect(iln.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.hDT.put(iln);
        this.hDT.position(0);
        Log.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated, yTextureId: %s, uvTextureId: %s this %s", Integer.valueOf(this.kxY), Integer.valueOf(this.kxZ), this);
        AppMethodBeat.o(94769);
    }

    public final void onSurfaceChanged(GL10 gl10, int i2, int i3) {
        AppMethodBeat.i(94770);
        Log.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceChanged, surfaceWidth: %s, height: %s this %s", Integer.valueOf(i2), Integer.valueOf(i3), this);
        if (!(i2 == this.surfaceWidth && i3 == this.surfaceHeight)) {
            Log.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceChanged change viewpoint");
            GLES20.glViewport(0, 0, i2, i3);
            this.surfaceWidth = i2;
            this.surfaceHeight = i3;
        }
        AppMethodBeat.o(94770);
    }

    public final void onDrawFrame(GL10 gl10) {
        AppMethodBeat.i(94771);
        Util.currentTicks();
        this.kxV = true;
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16640);
        if (this.kyc) {
            Log.i("MicroMsg.MMSightCameraGLRenderer", "clearFrameRequest");
            this.kyc = false;
            this.kxV = false;
            this.frameData = null;
            this.kxW = -1;
            this.kxX = -1;
            AppMethodBeat.o(94771);
            return;
        }
        if (!(this.programId == 0 || this.kxY == -1 || this.kxZ == -1 || this.kxW <= 0 || this.kxX <= 0 || this.frameData == null)) {
            GLES20.glUseProgram(this.programId);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.kxY);
            GLES20.glTexImage2D(3553, 0, 6409, this.kxW, this.kxX, 0, 6409, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, this.ikI);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, Task.EXTRAS_LIMIT_BYTES, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glUniform1i(this.ikE, 0);
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, this.kxZ);
            GLES20.glTexImage2D(3553, 0, 6410, this.kxW / 2, this.kxX / 2, 0, 6410, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, this.ikP);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, Task.EXTRAS_LIMIT_BYTES, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glUniform1i(this.ikO, 1);
            Matrix.setIdentityM(this.kyb, 0);
            Matrix.setRotateM(this.kyb, 0, (float) this.dYT, 0.0f, 0.0f, -1.0f);
            GLES20.glUniformMatrix4fv(this.kya, 1, false, this.kyb, 0);
            this.hDU.position(0);
            GLES20.glVertexAttribPointer(this.hEy, 2, 5126, false, 0, (Buffer) this.hDU);
            GLES20.glEnableVertexAttribArray(this.hEy);
            this.hDT.position(0);
            GLES20.glVertexAttribPointer(this.hEz, 2, 5126, false, 0, (Buffer) this.hDT);
            GLES20.glEnableVertexAttribArray(this.hEz);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(this.hEy);
            GLES20.glDisableVertexAttribArray(this.hEz);
            GLES20.glBindTexture(3553, 0);
        }
        this.kxV = false;
        AppMethodBeat.o(94771);
    }
}
