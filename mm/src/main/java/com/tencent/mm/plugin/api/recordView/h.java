package com.tencent.mm.plugin.api.recordView;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.HandlerThread;
import com.tencent.f.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.api.recordView.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class h {
    private final String TAG = "MicroMsg.YUVDateRenderToRBGBufferThread";
    EGLDisplay eglDisplay = null;
    EGLSurface eglSurface = null;
    private boolean hki = false;
    HandlerThread igZ = d.hC("YUVDateRenderToRBGBufferThread", 5);
    MMHandler iha;
    int[] ilp = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12610, 1, 12344};
    EGLContext ilv = null;
    int iqx;
    int kxW;
    int kxX;
    i kza;
    i.a kzb = null;
    int kzc;
    int kzd;

    public h() {
        AppMethodBeat.i(89273);
        AppMethodBeat.o(89273);
    }

    public final void b(final EGLContext eGLContext) {
        AppMethodBeat.i(89274);
        Log.d("MicroMsg.YUVDateRenderToRBGBufferThread", "start context : " + eGLContext + "  hasStart : " + this.hki);
        if (this.hki || eGLContext == null) {
            AppMethodBeat.o(89274);
            return;
        }
        this.hki = true;
        this.igZ.start();
        this.iha = new MMHandler(this.igZ.getLooper());
        M(new Runnable() {
            /* class com.tencent.mm.plugin.api.recordView.h.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(89270);
                h hVar = h.this;
                EGLContext eGLContext = eGLContext;
                int i2 = h.this.kxW;
                int i3 = h.this.kxX;
                hVar.eglDisplay = EGL14.eglGetDisplay(0);
                if (hVar.eglDisplay == EGL14.EGL_NO_DISPLAY) {
                    RuntimeException runtimeException = new RuntimeException("unable to get EGL14 display");
                    AppMethodBeat.o(89270);
                    throw runtimeException;
                }
                int[] iArr = new int[2];
                if (!EGL14.eglInitialize(hVar.eglDisplay, iArr, 0, iArr, 1)) {
                    hVar.eglDisplay = null;
                    RuntimeException runtimeException2 = new RuntimeException("eglInitialize failed");
                    AppMethodBeat.o(89270);
                    throw runtimeException2;
                }
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                EGL14.eglChooseConfig(hVar.eglDisplay, hVar.ilp, 0, eGLConfigArr, 0, 1, new int[1], 0);
                if (eGLConfigArr[0] == null) {
                    RuntimeException runtimeException3 = new RuntimeException("chooseConfig failed");
                    AppMethodBeat.o(89270);
                    throw runtimeException3;
                }
                hVar.ilv = EGL14.eglCreateContext(hVar.eglDisplay, eGLConfigArr[0], eGLContext, new int[]{12440, 2, 12344}, 0);
                if (hVar.ilv == EGL14.EGL_NO_CONTEXT) {
                    RuntimeException runtimeException4 = new RuntimeException("EGL error " + EGL14.eglGetError());
                    AppMethodBeat.o(89270);
                    throw runtimeException4;
                }
                h.TP("eglCreateContext");
                int[] iArr2 = {12375, i2, 12374, i3, 12344};
                hVar.eglSurface = null;
                try {
                    hVar.eglSurface = EGL14.eglCreatePbufferSurface(hVar.eglDisplay, eGLConfigArr[0], iArr2, 0);
                } catch (IllegalArgumentException e2) {
                    Log.e("MicroMsg.YUVDateRenderToRBGBufferThread", "eglCreateWindowSurface", e2);
                }
                h.TP("eglCreatePbufferSurface");
                if ((hVar.eglSurface == null || hVar.eglSurface == EGL14.EGL_NO_SURFACE) && EGL14.eglGetError() == 12299) {
                    Log.e("MicroMsg.YUVDateRenderToRBGBufferThread", "makeMyEGLCurrentSurface:returned EGL_BAD_NATIVE_WINDOW.");
                }
                if (!EGL14.eglMakeCurrent(hVar.eglDisplay, hVar.eglSurface, hVar.eglSurface, hVar.ilv)) {
                    Log.w("MicroMsg.YUVDateRenderToRBGBufferThread", "eglMakeCurrent:" + EGL14.eglGetError());
                }
                h hVar2 = h.this;
                int i4 = h.this.kzc;
                int i5 = h.this.kzd;
                hVar2.kza = new i(i4, i5);
                hVar2.kza.onSurfaceCreated(null, null);
                hVar2.kza.onSurfaceChanged(null, i4, i5);
                if (hVar2.kzb != null) {
                    hVar2.kza.buffer = hVar2.kzb.getBuffer();
                }
                AppMethodBeat.o(89270);
            }
        });
        AppMethodBeat.o(89274);
    }

    public final void E(final byte[] bArr, final int i2) {
        AppMethodBeat.i(89275);
        if (this.hki || this.kza != null) {
            M(new Runnable() {
                /* class com.tencent.mm.plugin.api.recordView.h.AnonymousClass2 */

                public final void run() {
                    boolean z;
                    AppMethodBeat.i(89271);
                    i iVar = h.this.kza;
                    byte[] bArr = bArr;
                    int i2 = h.this.kxW;
                    int i3 = h.this.kxX;
                    int i4 = h.this.iqx;
                    int i5 = i2;
                    try {
                        if (iVar.kxX == i3 && iVar.kxW == i2 && iVar.dYT == i4 && iVar.kyf == i5) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (z) {
                            Log.d("MicroMsg.YUVDateRenderToRGBBufferRenderer", "setDrawFrame, frameData: %s, frameWidth: %s, frameHeight: %s, rotate: %s, isLandScape, frameSizeChange: %s, this %s", bArr, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(iVar.iqo), Boolean.TRUE, iVar);
                        }
                        if (iVar.frameData == null || iVar.frameData.length != bArr.length) {
                            iVar.frameData = new byte[bArr.length];
                        }
                        System.arraycopy(bArr, 0, iVar.frameData, 0, bArr.length);
                        iVar.kxW = i2;
                        iVar.kxX = i3;
                        iVar.dYT = i4;
                        iVar.kyf = i5;
                        if (z) {
                            iVar.ikI = ByteBuffer.allocateDirect(i3 * i2);
                            iVar.ikP = ByteBuffer.allocateDirect((i2 * i3) / 2);
                            iVar.ikI.order(ByteOrder.nativeOrder());
                            iVar.ikP.order(ByteOrder.nativeOrder());
                            if (iVar.kyd != null) {
                                iVar.hDU.put(iVar.kyd);
                                iVar.hDU.position(0);
                            }
                        }
                        if (!(iVar.ikI == null || iVar.ikP == null)) {
                            iVar.ikI.put(iVar.frameData, 0, i2 * i3);
                            iVar.ikI.position(0);
                            iVar.ikP.put(iVar.frameData, i2 * i3, (i2 * i3) / 2);
                            iVar.ikP.position(0);
                        }
                    } catch (Exception e2) {
                        Log.e("MicroMsg.YUVDateRenderToRGBBufferRenderer", "setDrawFrame error: %s", e2.getMessage());
                    }
                    h.this.kza.onDrawFrame(null);
                    h.this.kzb.bqT();
                    AppMethodBeat.o(89271);
                }
            });
            AppMethodBeat.o(89275);
            return;
        }
        AppMethodBeat.o(89275);
    }

    public final void a(i.a aVar) {
        this.kzb = aVar;
    }

    public final void i(int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(89276);
        Log.i("MicroMsg.YUVDateRenderToRBGBufferThread", "setFrameInfo, width: %s, height: %s, rotate: %s ,targetWidth:%d ,targetHeight:%d , this: %s ", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), this);
        if (!(i2 == this.kxW && i3 == this.kxX && i4 == this.iqx)) {
            this.kxW = i2;
            this.kxX = i3;
            this.iqx = i4;
        }
        this.kzc = i5;
        this.kzd = i6;
        AppMethodBeat.o(89276);
    }

    private void M(Runnable runnable) {
        AppMethodBeat.i(89277);
        if (this.igZ.isAlive()) {
            this.iha.post(runnable);
        }
        AppMethodBeat.o(89277);
    }

    public final void release() {
        AppMethodBeat.i(89278);
        M(new Runnable() {
            /* class com.tencent.mm.plugin.api.recordView.h.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(89272);
                i iVar = h.this.kza;
                if (iVar.kzh != 0) {
                    GLES20.glDeleteTextures(1, new int[]{iVar.kzh}, 0);
                }
                if (iVar.kzi != 0) {
                    GLES20.glDeleteFramebuffers(1, new int[]{iVar.kzi}, 0);
                }
                EGLDisplay eGLDisplay = h.this.eglDisplay;
                EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
                if (!(h.this.eglSurface == null || h.this.ilv == null || h.this.eglDisplay == null)) {
                    EGL14.eglDestroySurface(h.this.eglDisplay, h.this.eglSurface);
                    EGL14.eglDestroyContext(h.this.eglDisplay, h.this.ilv);
                    EGL14.eglReleaseThread();
                    EGL14.eglTerminate(h.this.eglDisplay);
                    h.this.ilv = null;
                    h.this.eglDisplay = null;
                    h.this.eglSurface = null;
                }
                h.this.iha.removeCallbacksAndMessages(null);
                h.this.igZ.quitSafely();
                AppMethodBeat.o(89272);
            }
        });
        AppMethodBeat.o(89278);
    }

    static boolean TP(String str) {
        AppMethodBeat.i(89279);
        int eglGetError = EGL14.eglGetError();
        if (eglGetError != 12288) {
            Log.printInfoStack("MicroMsg.YUVDateRenderToRBGBufferThread", str + ": EGL error: 0x" + Integer.toHexString(eglGetError), new Object[0]);
            AppMethodBeat.o(89279);
            return true;
        }
        AppMethodBeat.o(89279);
        return false;
    }
}
