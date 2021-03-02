package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

@TargetApi(17)
public final class DummySurface extends Surface {
    private static boolean bHN;
    private static boolean bHO;
    private final a bHP;
    private boolean bHQ;
    public final boolean bsY;

    /* synthetic */ DummySurface(a aVar, SurfaceTexture surfaceTexture, boolean z, byte b2) {
        this(aVar, surfaceTexture, z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
        if (r2 != false) goto L_0x002e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean ak(android.content.Context r6) {
        /*
        // Method dump skipped, instructions count: 106
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.DummySurface.ak(android.content.Context):boolean");
    }

    private DummySurface(a aVar, SurfaceTexture surfaceTexture, boolean z) {
        super(surfaceTexture);
        this.bHP = aVar;
        this.bsY = z;
    }

    public final void release() {
        AppMethodBeat.i(93265);
        super.release();
        synchronized (this.bHP) {
            try {
                if (!this.bHQ) {
                    this.bHP.handler.sendEmptyMessage(3);
                    this.bHQ = true;
                }
            } finally {
                AppMethodBeat.o(93265);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class a extends HandlerThread implements SurfaceTexture.OnFrameAvailableListener, Handler.Callback {
        private final int[] bHR = new int[1];
        private EGLDisplay bHS;
        private EGLContext bHT;
        private EGLSurface bHU;
        private Error bHV;
        private RuntimeException bHW;
        private DummySurface bHX;
        Handler handler;
        private SurfaceTexture surfaceTexture;

        public a() {
            super("dummySurface");
            AppMethodBeat.i(93259);
            AppMethodBeat.o(93259);
        }

        public final DummySurface aX(boolean z) {
            boolean z2 = false;
            AppMethodBeat.i(93260);
            start();
            this.handler = new Handler(getLooper(), this);
            synchronized (this) {
                try {
                    this.handler.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
                    while (this.bHX == null && this.bHW == null && this.bHV == null) {
                        try {
                            wait();
                        } catch (InterruptedException e2) {
                            z2 = true;
                        }
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(93260);
                    throw th;
                }
            }
            if (z2) {
                Thread.currentThread().interrupt();
            }
            if (this.bHW != null) {
                RuntimeException runtimeException = this.bHW;
                AppMethodBeat.o(93260);
                throw runtimeException;
            } else if (this.bHV != null) {
                Error error = this.bHV;
                AppMethodBeat.o(93260);
                throw error;
            } else {
                DummySurface dummySurface = this.bHX;
                AppMethodBeat.o(93260);
                return dummySurface;
            }
        }

        public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
            AppMethodBeat.i(93261);
            this.handler.sendEmptyMessage(2);
            AppMethodBeat.o(93261);
        }

        /* JADX INFO: finally extract failed */
        public final boolean handleMessage(Message message) {
            boolean z;
            int[] iArr;
            boolean z2;
            int[] iArr2;
            boolean z3;
            AppMethodBeat.i(93262);
            switch (message.what) {
                case 1:
                    try {
                        if (message.arg1 != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        this.bHS = EGL14.eglGetDisplay(0);
                        com.google.android.exoplayer2.i.a.checkState(this.bHS != null, "eglGetDisplay failed");
                        int[] iArr3 = new int[2];
                        com.google.android.exoplayer2.i.a.checkState(EGL14.eglInitialize(this.bHS, iArr3, 0, iArr3, 1), "eglInitialize failed");
                        EGLConfig[] eGLConfigArr = new EGLConfig[1];
                        int[] iArr4 = new int[1];
                        com.google.android.exoplayer2.i.a.checkState(EGL14.eglChooseConfig(this.bHS, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344}, 0, eGLConfigArr, 0, 1, iArr4, 0) && iArr4[0] > 0 && eGLConfigArr[0] != null, "eglChooseConfig failed");
                        EGLConfig eGLConfig = eGLConfigArr[0];
                        if (z) {
                            iArr = new int[]{12440, 2, 12992, 1, 12344};
                        } else {
                            iArr = new int[]{12440, 2, 12344};
                        }
                        this.bHT = EGL14.eglCreateContext(this.bHS, eGLConfig, EGL14.EGL_NO_CONTEXT, iArr, 0);
                        if (this.bHT != null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        com.google.android.exoplayer2.i.a.checkState(z2, "eglCreateContext failed");
                        if (z) {
                            iArr2 = new int[]{12375, 1, 12374, 1, 12992, 1, 12344};
                        } else {
                            iArr2 = new int[]{12375, 1, 12374, 1, 12344};
                        }
                        this.bHU = EGL14.eglCreatePbufferSurface(this.bHS, eGLConfig, iArr2, 0);
                        if (this.bHU != null) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        com.google.android.exoplayer2.i.a.checkState(z3, "eglCreatePbufferSurface failed");
                        com.google.android.exoplayer2.i.a.checkState(EGL14.eglMakeCurrent(this.bHS, this.bHU, this.bHU, this.bHT), "eglMakeCurrent failed");
                        GLES20.glGenTextures(1, this.bHR, 0);
                        this.surfaceTexture = new SurfaceTexture(this.bHR[0]);
                        this.surfaceTexture.setOnFrameAvailableListener(this);
                        this.bHX = new DummySurface(this, this.surfaceTexture, z, (byte) 0);
                        synchronized (this) {
                            try {
                                notify();
                            } finally {
                                AppMethodBeat.o(93262);
                            }
                        }
                    } catch (RuntimeException e2) {
                        this.bHW = e2;
                        synchronized (this) {
                            notify();
                        }
                    } catch (Error e3) {
                        this.bHV = e3;
                        synchronized (this) {
                            notify();
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.o(93262);
                        throw th;
                    }
                    break;
                case 2:
                    this.surfaceTexture.updateTexImage();
                    AppMethodBeat.o(93262);
                    break;
                case 3:
                    try {
                        if (this.surfaceTexture != null) {
                            this.surfaceTexture.release();
                            GLES20.glDeleteTextures(1, this.bHR, 0);
                        }
                        try {
                            if (this.bHU != null) {
                                EGL14.eglDestroySurface(this.bHS, this.bHU);
                            }
                            if (this.bHT != null) {
                                EGL14.eglDestroyContext(this.bHS, this.bHT);
                            }
                            this.bHU = null;
                            this.bHT = null;
                            this.bHS = null;
                            this.bHX = null;
                            this.surfaceTexture = null;
                            quit();
                        } catch (Throwable th2) {
                            quit();
                            AppMethodBeat.o(93262);
                            throw th2;
                        }
                        AppMethodBeat.o(93262);
                        break;
                    } catch (Throwable th3) {
                        if (this.bHU != null) {
                            EGL14.eglDestroySurface(this.bHS, this.bHU);
                        }
                        if (this.bHT != null) {
                            EGL14.eglDestroyContext(this.bHS, this.bHT);
                        }
                        this.bHU = null;
                        this.bHT = null;
                        this.bHS = null;
                        this.bHX = null;
                        this.surfaceTexture = null;
                        AppMethodBeat.o(93262);
                        throw th3;
                    }
                default:
                    AppMethodBeat.o(93262);
                    break;
            }
            return true;
        }
    }

    public static DummySurface j(Context context, boolean z) {
        AppMethodBeat.i(93264);
        if (x.SDK_INT < 17) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Unsupported prior to API level 17");
            AppMethodBeat.o(93264);
            throw unsupportedOperationException;
        }
        com.google.android.exoplayer2.i.a.checkState(!z || ak(context));
        DummySurface aX = new a().aX(z);
        AppMethodBeat.o(93264);
        return aX;
    }
}
