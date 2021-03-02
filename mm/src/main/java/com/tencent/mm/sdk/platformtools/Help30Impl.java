package com.tencent.mm.sdk.platformtools;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES10;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public class Help30Impl {
    private static final String GPU_TAG = "MicroMsg.GPU_TAG";
    private static final int MIN_TEXTURE_SIZE = 2048;
    private EGLContext mEGLContext;
    private EGLDisplay mEGLDisplay;
    private EGLSurface mEGLSurface;
    private int maxTextureSize;

    private Help30Impl() {
        AppMethodBeat.i(157557);
        this.maxTextureSize = 2048;
        Log.i(GPU_TAG, "pennqin, init Help30Impl.");
        AppMethodBeat.o(157557);
    }

    /* access modifiers changed from: package-private */
    public static class Singleton {
        static Help30Impl instance = new Help30Impl();

        private Singleton() {
        }

        static {
            AppMethodBeat.i(157556);
            AppMethodBeat.o(157556);
        }
    }

    public static Help30Impl getInstance() {
        return Singleton.instance;
    }

    public void updateTextureMaxSize() {
        int i2 = 2048;
        AppMethodBeat.i(230300);
        Log.i(GPU_TAG, "pennqin, updateTextureMaxSize, before: %s.", Integer.valueOf(this.maxTextureSize));
        try {
            eglSetup();
            int[] iArr = new int[1];
            GLES10.glGetIntegerv(3379, iArr, 0);
            if (iArr[0] > 2048) {
                i2 = iArr[0];
            }
            this.maxTextureSize = i2;
            Log.i(GPU_TAG, "pennqin, get max texture size: %s %s.", Integer.valueOf(iArr[0]), Integer.valueOf(this.maxTextureSize));
            ForceGpuUtil.canGetTextureSize = false;
            try {
                release();
                AppMethodBeat.o(230300);
            } catch (Throwable th) {
                Log.printErrStackTrace(GPU_TAG, th, "release err: %s", th.getMessage());
                AppMethodBeat.o(230300);
            }
        } catch (Throwable th2) {
            Log.printErrStackTrace(GPU_TAG, th2, "release err: %s", th2.getMessage());
            AppMethodBeat.o(230300);
        }
    }

    public int getMaxTextureSize() {
        return this.maxTextureSize;
    }

    public void setLayerType(View view) {
        AppMethodBeat.i(230301);
        if (view.getLayerType() == 1) {
            AppMethodBeat.o(230301);
            return;
        }
        view.setLayerType(1, null);
        AppMethodBeat.o(230301);
    }

    public void decideLayerType(View view, int i2, int i3) {
        int i4 = 0;
        AppMethodBeat.i(230302);
        Log.d(GPU_TAG, "decideLayerType maxTextureSize %s.", Integer.valueOf(this.maxTextureSize));
        if (i2 >= this.maxTextureSize || i3 >= this.maxTextureSize) {
            i4 = 1;
        }
        if (view.getLayerType() != i4) {
            view.setLayerType(i4, null);
        }
        AppMethodBeat.o(230302);
    }

    public boolean canUseHardwareAcceleration(int i2, int i3) {
        AppMethodBeat.i(230303);
        Log.d(GPU_TAG, "canUseHardwareAcceleration maxTextureSize %s w %s h %s.", Integer.valueOf(this.maxTextureSize), Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 >= this.maxTextureSize || i3 >= this.maxTextureSize) {
            AppMethodBeat.o(230303);
            return false;
        }
        AppMethodBeat.o(230303);
        return true;
    }

    private void eglSetup() {
        AppMethodBeat.i(230304);
        this.mEGLDisplay = EGL14.eglGetDisplay(0);
        if (this.mEGLDisplay == EGL14.EGL_NO_DISPLAY) {
            Log.e(GPU_TAG, "EGL_NO_DISPLAY");
            AppMethodBeat.o(230304);
            return;
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(this.mEGLDisplay, iArr, 0, iArr, 1)) {
            Log.e(GPU_TAG, "eglInitialize");
            AppMethodBeat.o(230304);
            return;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        EGLDisplay eGLDisplay = this.mEGLDisplay;
        EGL14.eglChooseConfig(eGLDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0);
        this.mEGLContext = EGL14.eglCreateContext(this.mEGLDisplay, eGLConfigArr[0], EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
        this.mEGLSurface = EGL14.eglCreatePbufferSurface(this.mEGLDisplay, eGLConfigArr[0], new int[]{12344}, 0);
        EGL14.eglMakeCurrent(this.mEGLDisplay, this.mEGLSurface, this.mEGLSurface, this.mEGLContext);
        AppMethodBeat.o(230304);
    }

    private void release() {
        AppMethodBeat.i(185117);
        if (EGL14.EGL_NO_DISPLAY != this.mEGLDisplay) {
            EGLDisplay eGLDisplay = this.mEGLDisplay;
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroySurface(this.mEGLDisplay, this.mEGLSurface);
            EGL14.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.mEGLDisplay);
        }
        this.mEGLDisplay = EGL14.EGL_NO_DISPLAY;
        this.mEGLContext = EGL14.EGL_NO_CONTEXT;
        this.mEGLSurface = EGL14.EGL_NO_SURFACE;
        AppMethodBeat.o(185117);
    }
}
