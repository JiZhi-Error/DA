package com.tencent.tav.decoder;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Build;
import android.text.TextUtils;
import android.view.Surface;
import com.google.android.gms.gcm.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.logger.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RenderContext implements IDecoderTrack.SurfaceCreator {
    private static final int EGL_OPENGL_ES2_BIT = 4;
    private static final int EGL_RECORDABLE_ANDROID = 12610;
    private static final String TAG = "RenderContext";
    private EGLContext _eglContext;
    private HashMap<Surface, String> activeSurfaceCache;
    private EGLDisplay eglDisplay;
    private EGLSurface eglSurface;
    private HashMap<String, Surface> freeSurfaceCache;
    private CGRect glViewportRect;
    private int height;
    private boolean isSharedContext;
    private boolean pBufferEnable;
    private RenderContextParams params;
    private volatile boolean released;
    private List<Surface> releasingSurfaceCache;
    private Surface surface;
    private long threadId;
    private HashMap<Surface, VideoTexture> videoTextureMap;
    private int width;

    public EGLContext eglContext() {
        return this._eglContext;
    }

    public int width() {
        return this.width;
    }

    public int height() {
        return this.height;
    }

    public RenderContext(int i2, int i3) {
        this(i2, i3, null);
    }

    public RenderContext(int i2, int i3, Surface surface2) {
        this(i2, i3, surface2, null);
    }

    public RenderContext(int i2, int i3, Surface surface2, EGLContext eGLContext) {
        AppMethodBeat.i(218260);
        this.isSharedContext = false;
        this.released = false;
        this.threadId = -1;
        this.pBufferEnable = false;
        this.videoTextureMap = new HashMap<>();
        this.activeSurfaceCache = new HashMap<>();
        this.freeSurfaceCache = new HashMap<>();
        this.releasingSurfaceCache = new ArrayList();
        this.surface = surface2;
        this.width = i2;
        this.height = i3;
        eglSetup(eGLContext);
        makeCurrent();
        AppMethodBeat.o(218260);
    }

    public RenderContextParams getParams() {
        return this.params;
    }

    public CGRect getGlViewportRect() {
        return this.glViewportRect;
    }

    public void setParams(RenderContextParams renderContextParams) {
        this.params = renderContextParams;
    }

    public void updateViewport(CGRect cGRect) {
        AppMethodBeat.i(218261);
        if (cGRect == null || cGRect.origin == null || cGRect.size == null) {
            AppMethodBeat.o(218261);
            return;
        }
        this.glViewportRect = cGRect;
        updateViewport((int) cGRect.origin.x, (int) cGRect.origin.y, (int) cGRect.size.width, (int) cGRect.size.height);
        AppMethodBeat.o(218261);
    }

    public void updateViewport(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(218262);
        makeCurrent();
        GLES20.glViewport(i2, i3, i4, i5);
        AppMethodBeat.o(218262);
    }

    private synchronized void eglSetup(EGLContext eGLContext) {
        AppMethodBeat.i(218263);
        this.threadId = Thread.currentThread().getId();
        if (this.released) {
            AppMethodBeat.o(218263);
        } else {
            try {
                this.eglDisplay = EGL14.eglGetDisplay(0);
                if (this.eglDisplay == EGL14.EGL_NO_DISPLAY) {
                    new RuntimeException("unable to get EGL14 display");
                    AppMethodBeat.o(218263);
                } else {
                    int[] iArr = new int[2];
                    if (!EGL14.eglInitialize(this.eglDisplay, iArr, 0, iArr, 1)) {
                        this.eglDisplay = null;
                        new RuntimeException("unable to initialize EGL14");
                        AppMethodBeat.o(218263);
                    } else {
                        EGLConfig[] eGLConfigArr = new EGLConfig[1];
                        if (!EGL14.eglChooseConfig(this.eglDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12352, 4, EGL_RECORDABLE_ANDROID, 1, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                            new RuntimeException("unable to find RGB888+recordable ES2 EGL config");
                            AppMethodBeat.o(218263);
                        } else {
                            int[] iArr2 = {12440, 2, 12344};
                            if (eGLContext != null) {
                                this.isSharedContext = true;
                                this._eglContext = EGL14.eglCreateContext(this.eglDisplay, eGLConfigArr[0], eGLContext, iArr2, 0);
                                checkEglError("eglCreateContext");
                                if (this._eglContext == null) {
                                    new RuntimeException("null context");
                                    AppMethodBeat.o(218263);
                                }
                            } else {
                                this._eglContext = EGL14.eglCreateContext(this.eglDisplay, eGLConfigArr[0], EGL14.EGL_NO_CONTEXT, iArr2, 0);
                                checkEglError("eglCreateContext");
                                if (this._eglContext == null) {
                                    new RuntimeException("null context");
                                    AppMethodBeat.o(218263);
                                }
                            }
                            if (this.surface != null) {
                                this.eglSurface = EGL14.eglCreateWindowSurface(this.eglDisplay, eGLConfigArr[0], this.surface, new int[]{12344}, 0);
                            } else {
                                this.eglSurface = EGL14.eglCreatePbufferSurface(this.eglDisplay, eGLConfigArr[0], new int[]{12375, this.width, 12374, this.height, 12344}, 0);
                            }
                            if (checkEglActionSuccess("eglCreateWindowSurface")) {
                                this.pBufferEnable = true;
                            }
                            if (this.eglSurface == null) {
                                new RuntimeException("surface was null");
                            }
                            AppMethodBeat.o(218263);
                        }
                    }
                }
            } catch (Error | Exception e2) {
                AppMethodBeat.o(218263);
            }
        }
    }

    public void setWidth(int i2) {
        this.width = i2;
    }

    public void setHeight(int i2) {
        this.height = i2;
    }

    private void checkThread() {
        AppMethodBeat.i(218264);
        if (this.threadId != Thread.currentThread().getId()) {
            Logger.e(TAG, "线程不对，注意EGL相关的泄露问题！threadId = " + this.threadId + ", Thread.currentThread() name = " + Thread.currentThread().getName(), new RuntimeException());
        }
        AppMethodBeat.o(218264);
    }

    public long getEglSurfaceHandle() {
        AppMethodBeat.i(218265);
        if (this.eglSurface == null) {
            AppMethodBeat.o(218265);
            return 0;
        } else if (Build.VERSION.SDK_INT >= 21) {
            long nativeHandle = this.eglSurface.getNativeHandle();
            AppMethodBeat.o(218265);
            return nativeHandle;
        } else {
            long handle = (long) this.eglSurface.getHandle();
            AppMethodBeat.o(218265);
            return handle;
        }
    }

    public boolean isPBufferEnable() {
        return this.pBufferEnable;
    }

    public synchronized void makeCurrent() {
        AppMethodBeat.i(218266);
        checkThread();
        if (this.released) {
            AppMethodBeat.o(218266);
        } else {
            if (!EGL14.eglMakeCurrent(this.eglDisplay, this.eglSurface, this.eglSurface, this._eglContext)) {
                checkEglError("eglMakeCurrent failed");
            }
            AppMethodBeat.o(218266);
        }
    }

    public synchronized boolean swapBuffers() {
        boolean eglSwapBuffers;
        AppMethodBeat.i(218267);
        checkThread();
        if (this.released) {
            eglSwapBuffers = false;
            AppMethodBeat.o(218267);
        } else {
            eglSwapBuffers = EGL14.eglSwapBuffers(this.eglDisplay, this.eglSurface);
            AppMethodBeat.o(218267);
        }
        return eglSwapBuffers;
    }

    public synchronized void setPresentationTime(long j2) {
        AppMethodBeat.i(218268);
        if (this.released) {
            AppMethodBeat.o(218268);
        } else {
            if (this.surface != null) {
                EGLExt.eglPresentationTimeANDROID(this.eglDisplay, this.eglSurface, 1000 * j2);
            }
            AppMethodBeat.o(218268);
        }
    }

    public static void checkEglError(String str) {
        AppMethodBeat.i(218269);
        checkEglActionSuccess(str);
        AppMethodBeat.o(218269);
    }

    public static boolean checkEglActionSuccess(String str) {
        AppMethodBeat.i(218270);
        StringBuilder sb = new StringBuilder("");
        boolean z = false;
        while (true) {
            int eglGetError = EGL14.eglGetError();
            if (eglGetError == 12288) {
                break;
            }
            Logger.e(TAG, str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
            sb.append(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
            z = true;
        }
        if (z) {
            new RuntimeException("EGL error encountered (see log): " + sb.toString());
        }
        if (!z) {
            AppMethodBeat.o(218270);
            return true;
        }
        AppMethodBeat.o(218270);
        return false;
    }

    private synchronized int loadShader(int i2, String str) {
        int i3 = 0;
        synchronized (this) {
            AppMethodBeat.i(218271);
            if (this.released) {
                AppMethodBeat.o(218271);
            } else {
                int glCreateShader = GLES20.glCreateShader(i2);
                checkEglError("glCreateShader type=".concat(String.valueOf(i2)));
                GLES20.glShaderSource(glCreateShader, str);
                GLES20.glCompileShader(glCreateShader);
                int[] iArr = new int[1];
                GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
                if (iArr[0] == 0) {
                    Logger.e(TAG, "Could not compile shader " + i2 + ":");
                    Logger.e(TAG, " " + GLES20.glGetShaderInfoLog(glCreateShader));
                    GLES20.glDeleteShader(glCreateShader);
                } else {
                    i3 = glCreateShader;
                }
                AppMethodBeat.o(218271);
            }
        }
        return i3;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack.SurfaceCreator
    public synchronized Surface createOutputSurface(int i2, int i3, int i4) {
        Surface surface2;
        AppMethodBeat.i(218272);
        if (this.released) {
            surface2 = null;
            AppMethodBeat.o(218272);
        } else {
            checkThread();
            releaseReleadingSurface();
            String str = i2 + "*" + i3 + "-" + i4;
            if (!this.freeSurfaceCache.containsKey(str) || (surface2 = this.freeSurfaceCache.remove(str)) == null) {
                makeCurrent();
                VideoTexture videoTexture = new VideoTexture(i2, i3, 36197, i4);
                videoTexture.setRenderContext(this);
                surface2 = new Surface(videoTexture.surfaceTexture());
                this.videoTextureMap.put(surface2, videoTexture);
                this.activeSurfaceCache.put(surface2, str);
                AppMethodBeat.o(218272);
            } else {
                this.activeSurfaceCache.put(surface2, str);
                AppMethodBeat.o(218272);
            }
        }
        return surface2;
    }

    private void releaseReleadingSurface() {
        AppMethodBeat.i(218273);
        checkThread();
        for (int i2 = 0; i2 < this.releasingSurfaceCache.size(); i2++) {
            release(this.releasingSurfaceCache.remove(i2));
        }
        AppMethodBeat.o(218273);
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack.SurfaceCreator
    public synchronized void free(Surface surface2) {
        AppMethodBeat.i(218274);
        Logger.i(TAG, "free " + Thread.currentThread().getId());
        if (surface2 == null) {
            AppMethodBeat.o(218274);
        } else {
            String remove = this.activeSurfaceCache.remove(surface2);
            if (!TextUtils.isEmpty(remove)) {
                this.freeSurfaceCache.containsKey(remove);
            }
            this.releasingSurfaceCache.add(surface2);
            AppMethodBeat.o(218274);
        }
    }

    private synchronized void release(Surface surface2) {
        AppMethodBeat.i(218275);
        checkThread();
        if (surface2 == null) {
            AppMethodBeat.o(218275);
        } else {
            if (this.videoTextureMap.containsKey(surface2)) {
                this.videoTextureMap.remove(surface2).release();
            }
            surface2.release();
            AppMethodBeat.o(218275);
        }
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack.SurfaceCreator
    public synchronized VideoTexture videoTextureForSurface(Surface surface2) {
        VideoTexture videoTexture;
        AppMethodBeat.i(218276);
        videoTexture = this.videoTextureMap.get(surface2);
        AppMethodBeat.o(218276);
        return videoTexture;
    }

    @Override // com.tencent.tav.decoder.IDecoderTrack.SurfaceCreator
    public synchronized void release() {
        AppMethodBeat.i(218277);
        checkThread();
        if (this.released) {
            AppMethodBeat.o(218277);
        } else {
            makeCurrent();
            this.released = true;
            releaseReleadingSurface();
            for (Surface surface2 : this.videoTextureMap.keySet()) {
                surface2.release();
            }
            for (VideoTexture videoTexture : this.videoTextureMap.values()) {
                videoTexture.release();
            }
            this.videoTextureMap.clear();
            try {
                if (EGL14.eglGetCurrentContext().equals(this._eglContext)) {
                    EGLDisplay eGLDisplay = this.eglDisplay;
                    EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                    EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
                }
                EGL14.eglDestroySurface(this.eglDisplay, this.eglSurface);
                if (!this.isSharedContext) {
                    EGL14.eglDestroyContext(this.eglDisplay, this._eglContext);
                }
            } catch (Exception e2) {
                Logger.e(TAG, "release", e2);
            } catch (Error e3) {
                Logger.e(TAG, "release", e3);
            }
            this.eglDisplay = null;
            this._eglContext = null;
            this.eglSurface = null;
            this.surface = null;
            AppMethodBeat.o(218277);
        }
    }

    public static int createTexture(int i2) {
        AppMethodBeat.i(218278);
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i3 = iArr[0];
        GLES20.glBindTexture(i2, i3);
        checkEglError("glBindTexture mTextureID");
        GLES20.glTexParameterf(i2, 10241, 9729.0f);
        GLES20.glTexParameterf(i2, Task.EXTRAS_LIMIT_BYTES, 9729.0f);
        GLES20.glTexParameteri(i2, 10242, 33071);
        GLES20.glTexParameteri(i2, 10243, 33071);
        checkEglError("glTexParameter");
        AppMethodBeat.o(218278);
        return i3;
    }

    public String toString() {
        AppMethodBeat.i(218279);
        String str = "RenderContext{_eglContext=" + this._eglContext + ", isSharedContext=" + this.isSharedContext + ", released=" + this.released + '}';
        AppMethodBeat.o(218279);
        return str;
    }
}
