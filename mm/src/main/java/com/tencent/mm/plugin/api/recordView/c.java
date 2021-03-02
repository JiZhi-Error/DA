package com.tencent.mm.plugin.api.recordView;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.google.android.gms.gcm.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

final class c extends Thread {
    private EGLDisplay gSA = EGL10.EGL_NO_DISPLAY;
    private EGLSurface gSB = EGL10.EGL_NO_SURFACE;
    private EGLContext gSD = EGL10.EGL_NO_CONTEXT;
    private EGL10 gSz;
    private SurfaceTexture ipT;
    private d kyk;
    volatile boolean kym;

    public c(SurfaceTexture surfaceTexture, d dVar) {
        this.ipT = surfaceTexture;
        this.kyk = dVar;
    }

    public final void run() {
        char c2;
        AppMethodBeat.i(89215);
        Log.i("MicroMsg.MMSightRecordTextureViewRenderThread", "start render thread");
        this.gSz = (EGL10) EGLContext.getEGL();
        this.gSA = this.gSz.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        if (this.gSA == EGL10.EGL_NO_DISPLAY) {
            Log.e("MicroMsg.MMSightRecordTextureViewRenderThread", "egl get display error: %s", GLUtils.getEGLErrorString(this.gSz.eglGetError()));
            c2 = 65535;
        } else {
            if (!this.gSz.eglInitialize(this.gSA, new int[2])) {
                Log.e("MicroMsg.MMSightRecordTextureViewRenderThread", "egl init error: %s", GLUtils.getEGLErrorString(this.gSz.eglGetError()));
                c2 = 65535;
            } else {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                if (!this.gSz.eglChooseConfig(this.gSA, new int[]{12324, 4, 12323, 4, 12322, 4, 12352, 4, 12344}, eGLConfigArr, 1, new int[1])) {
                    Log.e("MicroMsg.MMSightRecordTextureViewRenderThread", "egl choose config failed: %s", GLUtils.getEGLErrorString(this.gSz.eglGetError()));
                    c2 = 65535;
                } else {
                    this.gSD = this.gSz.eglCreateContext(this.gSA, eGLConfigArr[0], EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
                    this.gSB = this.gSz.eglCreateWindowSurface(this.gSA, eGLConfigArr[0], this.ipT, null);
                    if (this.gSB != EGL10.EGL_NO_SURFACE && this.gSD != EGL10.EGL_NO_CONTEXT) {
                        if (!this.gSz.eglMakeCurrent(this.gSA, this.gSB, this.gSB, this.gSD)) {
                            Log.e("MicroMsg.MMSightRecordTextureViewRenderThread", "eglMakeCurrent failed : %s", GLUtils.getEGLErrorString(this.gSz.eglGetError()));
                        }
                        c2 = 0;
                    } else if (this.gSz.eglGetError() == 12299) {
                        Log.e("MicroMsg.MMSightRecordTextureViewRenderThread", "eglCreateWindowSurface returned EGL_BAD_NATIVE_WINDOW. ");
                        c2 = 65535;
                    } else {
                        Log.e("MicroMsg.MMSightRecordTextureViewRenderThread", "eglCreateWindowSurface failed : %s", GLUtils.getEGLErrorString(this.gSz.eglGetError()));
                        c2 = 65535;
                    }
                }
            }
        }
        if (c2 < 0) {
            Log.e("MicroMsg.MMSightRecordTextureViewRenderThread", "init gl failed");
            AppMethodBeat.o(89215);
            return;
        }
        if (this.kyk != null) {
            d dVar = this.kyk;
            synchronized (d.lock) {
                try {
                    Log.i("MicroMsg.MMSightRecordTextureViewRenderer", "init this %s", dVar);
                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                    GLES20.glDisable(2929);
                    dVar.programId = b.aB("attribute vec4 a_position;                         \nattribute vec2 a_texCoord;                         \nvarying vec2 v_texCoord;                           \nuniform mat4 uMatrix;                              \nvoid main() {                                      \n   gl_Position = uMatrix * a_position;             \n   v_texCoord = a_texCoord;                        \n}                                                  \n", "#ifdef GL_ES                                       \nprecision highp float;                             \n#endif                                             \nvarying vec2 v_texCoord;                           \nuniform sampler2D y_texture;                       \nuniform sampler2D uv_texture;                      \nvoid main (void) {                                 \n   float r, g, b, y, u, v;                         \n   y = texture2D(y_texture, v_texCoord).r;         \n   u = texture2D(uv_texture, v_texCoord).a;        \n   v = texture2D(uv_texture, v_texCoord).r;        \n   u = u - 0.5;                                    \n   v = v - 0.5;                                    \n   r = y + 1.370705 * v;                           \n   g = y - 0.337633 * u - 0.698001 * v;            \n   b = y + 1.732446 * u;                           \n   gl_FragColor = vec4(r, g, b, 1.0);              \n}                                                  \n");
                    if (dVar.programId == 0) {
                        Log.e("MicroMsg.MMSightRecordTextureViewRenderer", "onSurfaceCreated, load program failed!");
                    }
                    dVar.hEy = GLES20.glGetAttribLocation(dVar.programId, "a_position");
                    dVar.hEz = GLES20.glGetAttribLocation(dVar.programId, "a_texCoord");
                    dVar.ikE = GLES20.glGetUniformLocation(dVar.programId, "y_texture");
                    dVar.ikO = GLES20.glGetUniformLocation(dVar.programId, "uv_texture");
                    dVar.kya = GLES20.glGetUniformLocation(dVar.programId, "uMatrix");
                    dVar.kxY = b.aMZ();
                    dVar.kxZ = b.aMZ();
                    dVar.hDU = ByteBuffer.allocateDirect(dVar.kyd.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
                    dVar.hDU.put(dVar.kyd);
                    dVar.hDU.position(0);
                    dVar.hDT = ByteBuffer.allocateDirect(d.iln.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
                    dVar.hDT.put(d.iln);
                    dVar.hDT.position(0);
                    Log.i("MicroMsg.MMSightRecordTextureViewRenderer", "onSurfaceCreated, yTextureId: %s, uvTextureId: %s this %s", Integer.valueOf(dVar.kxY), Integer.valueOf(dVar.kxZ), dVar);
                } catch (Throwable th) {
                    AppMethodBeat.o(89215);
                    throw th;
                }
            }
            Log.i("MicroMsg.MMSightRecordTextureViewRenderThread", "init renderer finish");
        }
        while (this.kym) {
            if (this.kyk != null) {
                if (!this.kyk.kyn) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e2) {
                        Log.printErrStackTrace("MicroMsg.MMSightRecordTextureViewRenderThread", e2, "", new Object[0]);
                    }
                }
                d dVar2 = this.kyk;
                Util.currentTicks();
                dVar2.kxV = true;
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                GLES20.glClear(16640);
                synchronized (d.lock) {
                    try {
                        if (dVar2.programId != -1 && dVar2.kxY != -1 && dVar2.kxZ != -1 && dVar2.kxW > 0 && dVar2.kxX > 0 && dVar2.ikP != null && dVar2.ikI != null && dVar2.ikP.limit() > 0 && dVar2.ikI.limit() > 0 && dVar2.ikP.position() == 0 && dVar2.ikI.position() == 0) {
                            GLES20.glUseProgram(dVar2.programId);
                            GLES20.glActiveTexture(33984);
                            GLES20.glBindTexture(3553, dVar2.kxY);
                            GLES20.glTexImage2D(3553, 0, 6409, dVar2.kxW, dVar2.kxX, 0, 6409, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, dVar2.ikI);
                            GLES20.glTexParameterf(3553, 10241, 9729.0f);
                            GLES20.glTexParameterf(3553, Task.EXTRAS_LIMIT_BYTES, 9729.0f);
                            GLES20.glTexParameterf(3553, 10242, 33071.0f);
                            GLES20.glTexParameterf(3553, 10243, 33071.0f);
                            GLES20.glUniform1i(dVar2.ikE, 0);
                            GLES20.glActiveTexture(33985);
                            GLES20.glBindTexture(3553, dVar2.kxZ);
                            GLES20.glTexImage2D(3553, 0, 6410, dVar2.kxW / 2, dVar2.kxX / 2, 0, 6410, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, dVar2.ikP);
                            GLES20.glTexParameterf(3553, 10241, 9729.0f);
                            GLES20.glTexParameterf(3553, Task.EXTRAS_LIMIT_BYTES, 9729.0f);
                            GLES20.glTexParameterf(3553, 10242, 33071.0f);
                            GLES20.glTexParameterf(3553, 10243, 33071.0f);
                            GLES20.glUniform1i(dVar2.ikO, 1);
                            Matrix.setIdentityM(dVar2.kyb, 0);
                            Matrix.setRotateM(dVar2.kyb, 0, (float) dVar2.dYT, 0.0f, 0.0f, -1.0f);
                            GLES20.glUniformMatrix4fv(dVar2.kya, 1, false, dVar2.kyb, 0);
                            dVar2.hDU.position(0);
                            GLES20.glVertexAttribPointer(dVar2.hEy, 2, 5126, false, 0, (Buffer) dVar2.hDU);
                            GLES20.glEnableVertexAttribArray(dVar2.hEy);
                            dVar2.hDT.position(0);
                            GLES20.glVertexAttribPointer(dVar2.hEz, 2, 5126, false, 0, (Buffer) dVar2.hDT);
                            GLES20.glEnableVertexAttribArray(dVar2.hEz);
                            GLES20.glDrawArrays(5, 0, 4);
                            GLES20.glDisableVertexAttribArray(dVar2.hEy);
                            GLES20.glDisableVertexAttribArray(dVar2.hEz);
                            GLES20.glBindTexture(3553, 0);
                        }
                    } catch (Throwable th2) {
                        AppMethodBeat.o(89215);
                        throw th2;
                    }
                }
                dVar2.kxV = false;
            }
            if (this.gSz != null) {
                this.gSz.eglSwapBuffers(this.gSA, this.gSB);
            }
        }
        Log.i("MicroMsg.MMSightRecordTextureViewRenderThread", "finish render loop, start destroy gl");
        if (this.kyk != null) {
            d dVar3 = this.kyk;
            synchronized (d.lock) {
                try {
                    if (dVar3.programId >= 0) {
                        GLES20.glDeleteProgram(dVar3.programId);
                        dVar3.programId = -1;
                    }
                    if (dVar3.kxZ >= 0) {
                        GLES20.glDeleteTextures(1, new int[]{dVar3.kxZ}, 0);
                        dVar3.kxZ = -1;
                    }
                    if (dVar3.kxY >= 0) {
                        GLES20.glDeleteTextures(1, new int[]{dVar3.kxY}, 0);
                        dVar3.kxY = -1;
                    }
                    dVar3.kxX = -1;
                    dVar3.kxW = -1;
                    dVar3.ife = true;
                    dVar3.ikI = null;
                    dVar3.ikP = null;
                } catch (Throwable th3) {
                    AppMethodBeat.o(89215);
                    throw th3;
                }
            }
        }
        if (!(this.gSz == null || this.gSD == null || this.gSB == null)) {
            this.gSz.eglDestroyContext(this.gSA, this.gSD);
            this.gSz.eglDestroySurface(this.gSA, this.gSB);
            this.gSD = EGL10.EGL_NO_CONTEXT;
            this.gSB = EGL10.EGL_NO_SURFACE;
        }
        if (this.ipT != null) {
            this.ipT.release();
        }
        Log.i("MicroMsg.MMSightRecordTextureViewRenderThread", "finish render loop, finish destroy gl");
        AppMethodBeat.o(89215);
    }
}
