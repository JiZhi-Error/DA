package com.tencent.liteav.trtc.impl;

import android.opengl.GLES20;
import android.os.Build;
import android.os.HandlerThread;
import com.tencent.liteav.basic.c.g;
import com.tencent.liteav.basic.c.h;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.b.k;
import com.tencent.liteav.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tavkit.component.TAVExporter;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.wxmm.v2helper;
import java.util.concurrent.CountDownLatch;

public class TRTCCustomTextureUtil {
    private static final String TAG = "TRTCCustomTextureUtil";
    private d mCaptureAndEnc;
    private Object mEGLContext = null;
    private HandlerThread mEGLThread = null;
    private g mGLThreadHandler = null;
    private k mI4202RGBAFilter = null;
    private long mLastGLThreadId;
    private h mRotateFilter;

    static /* synthetic */ int access$000(TRTCCustomTextureUtil tRTCCustomTextureUtil, int i2, TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        AppMethodBeat.i(222436);
        int checkRotate = tRTCCustomTextureUtil.checkRotate(i2, tRTCVideoFrame);
        AppMethodBeat.o(222436);
        return checkRotate;
    }

    static /* synthetic */ void access$300(TRTCCustomTextureUtil tRTCCustomTextureUtil, String str) {
        AppMethodBeat.i(222437);
        tRTCCustomTextureUtil.apiLog(str);
        AppMethodBeat.o(222437);
    }

    public TRTCCustomTextureUtil(d dVar) {
        this.mCaptureAndEnc = dVar;
    }

    public void release() {
        AppMethodBeat.i(15589);
        stopThread();
        AppMethodBeat.o(15589);
    }

    public void sendCustomTexture(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        AppMethodBeat.i(15590);
        checkEGLContext(tRTCVideoFrame);
        sendCustomTextureInternal(tRTCVideoFrame);
        AppMethodBeat.o(15590);
    }

    private void sendCustomTextureInternal(final TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        AppMethodBeat.i(15591);
        synchronized (this) {
            try {
                if (this.mGLThreadHandler != null) {
                    GLES20.glFinish();
                    final g gVar = this.mGLThreadHandler;
                    this.mGLThreadHandler.post(new Runnable() {
                        /* class com.tencent.liteav.trtc.impl.TRTCCustomTextureUtil.AnonymousClass1 */

                        public void run() {
                            int i2 = 3;
                            AppMethodBeat.i(15662);
                            gVar.d();
                            if (gVar.f291d) {
                                if (tRTCVideoFrame.texture != null) {
                                    tRTCVideoFrame.texture.textureId = TRTCCustomTextureUtil.access$000(TRTCCustomTextureUtil.this, tRTCVideoFrame.texture.textureId, tRTCVideoFrame);
                                    TRTCCustomTextureUtil.this.mCaptureAndEnc.a(tRTCVideoFrame.texture.textureId, tRTCVideoFrame.width, tRTCVideoFrame.height, gVar.f292e.e(), tRTCVideoFrame.timestamp, tRTCVideoFrame.rotation);
                                    AppMethodBeat.o(15662);
                                    return;
                                }
                            } else if (tRTCVideoFrame.texture != null) {
                                tRTCVideoFrame.texture.textureId = TRTCCustomTextureUtil.access$000(TRTCCustomTextureUtil.this, tRTCVideoFrame.texture.textureId, tRTCVideoFrame);
                                TRTCCustomTextureUtil.this.mCaptureAndEnc.a(tRTCVideoFrame.texture.textureId, tRTCVideoFrame.width, tRTCVideoFrame.height, gVar.f294g.d(), tRTCVideoFrame.timestamp, tRTCVideoFrame.rotation);
                                AppMethodBeat.o(15662);
                                return;
                            } else {
                                if (tRTCVideoFrame.pixelFormat == 1) {
                                    i2 = 1;
                                } else if (tRTCVideoFrame.pixelFormat == 4) {
                                }
                                if (TRTCCustomTextureUtil.this.mI4202RGBAFilter == null) {
                                    k kVar = new k(i2);
                                    kVar.a(true);
                                    if (!kVar.a()) {
                                        TXCLog.e(TRTCCustomTextureUtil.TAG, "mI4202RGBAFilter init failed!!, break init");
                                    }
                                    kVar.a(tRTCVideoFrame.width, tRTCVideoFrame.height);
                                    TRTCCustomTextureUtil.this.mI4202RGBAFilter = kVar;
                                }
                                k kVar2 = TRTCCustomTextureUtil.this.mI4202RGBAFilter;
                                if (kVar2 != null) {
                                    GLES20.glViewport(0, 0, tRTCVideoFrame.width, tRTCVideoFrame.height);
                                    kVar2.a(tRTCVideoFrame.data);
                                    TRTCCustomTextureUtil.this.mCaptureAndEnc.a(TRTCCustomTextureUtil.access$000(TRTCCustomTextureUtil.this, kVar2.q(), tRTCVideoFrame), tRTCVideoFrame.width, tRTCVideoFrame.height, gVar.f294g.d(), tRTCVideoFrame.timestamp, tRTCVideoFrame.rotation);
                                    AppMethodBeat.o(15662);
                                    return;
                                }
                                TRTCCustomTextureUtil.this.mCaptureAndEnc.a(tRTCVideoFrame.data, i2, tRTCVideoFrame.width, tRTCVideoFrame.height, gVar.f294g.d(), tRTCVideoFrame.timestamp, tRTCVideoFrame.rotation);
                            }
                            AppMethodBeat.o(15662);
                        }
                    });
                }
            } finally {
                AppMethodBeat.o(15591);
            }
        }
    }

    private void checkEGLContext(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        boolean z;
        AppMethodBeat.i(15592);
        if (tRTCVideoFrame == null) {
            AppMethodBeat.o(15592);
            return;
        }
        if (this.mLastGLThreadId != Thread.currentThread().getId()) {
            apiLog("CustomCapture eglContext's thread change!");
            z = true;
        } else if (tRTCVideoFrame.texture != null) {
            if (tRTCVideoFrame.texture.eglContext10 != null) {
                z = !tRTCVideoFrame.texture.eglContext10.equals(this.mEGLContext);
                if (z) {
                    apiLog("CustomCapture egl10Context change!");
                }
            } else {
                z = false;
            }
            if (tRTCVideoFrame.texture.eglContext14 != null) {
                if (!tRTCVideoFrame.texture.eglContext14.equals(this.mEGLContext)) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    apiLog("CustomCapture egl14Context change!");
                }
            }
        } else {
            z = false;
        }
        this.mLastGLThreadId = Thread.currentThread().getId();
        if (tRTCVideoFrame.texture != null) {
            if (tRTCVideoFrame.texture.eglContext10 != null) {
                this.mEGLContext = tRTCVideoFrame.texture.eglContext10;
            } else {
                this.mEGLContext = tRTCVideoFrame.texture.eglContext14;
            }
        }
        if (z) {
            stopThread();
            startThread(tRTCVideoFrame);
        }
        AppMethodBeat.o(15592);
    }

    private void startThread(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        AppMethodBeat.i(15593);
        if (tRTCVideoFrame == null) {
            AppMethodBeat.o(15593);
            return;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        synchronized (this) {
            try {
                if (this.mEGLThread == null) {
                    this.mEGLThread = new HandlerThread("customCaptureGLThread");
                    this.mEGLThread.start();
                    this.mGLThreadHandler = new g(this.mEGLThread.getLooper());
                    if (tRTCVideoFrame.texture == null) {
                        apiLog("CustomCapture buffer start egl10 thread");
                        this.mGLThreadHandler.f291d = false;
                        this.mGLThreadHandler.f295h = null;
                        this.mGLThreadHandler.f288a = TAVExporter.VIDEO_EXPORT_HEIGHT;
                        this.mGLThreadHandler.f289b = TAVExporter.VIDEO_EXPORT_WIDTH;
                        this.mGLThreadHandler.sendEmptyMessage(100);
                    } else if (tRTCVideoFrame.texture.eglContext10 != null) {
                        apiLog("CustomCapture texture start egl10 thread");
                        this.mGLThreadHandler.f291d = false;
                        this.mGLThreadHandler.f295h = tRTCVideoFrame.texture.eglContext10;
                        this.mGLThreadHandler.f288a = TAVExporter.VIDEO_EXPORT_HEIGHT;
                        this.mGLThreadHandler.f289b = TAVExporter.VIDEO_EXPORT_WIDTH;
                        this.mGLThreadHandler.sendEmptyMessage(100);
                    } else if (tRTCVideoFrame.texture.eglContext14 != null && Build.VERSION.SDK_INT >= 17) {
                        apiLog("CustomCapture texture start egl14 thread");
                        this.mGLThreadHandler.f291d = true;
                        this.mGLThreadHandler.f293f = tRTCVideoFrame.texture.eglContext14;
                        this.mGLThreadHandler.f288a = TAVExporter.VIDEO_EXPORT_HEIGHT;
                        this.mGLThreadHandler.f289b = TAVExporter.VIDEO_EXPORT_WIDTH;
                        this.mGLThreadHandler.sendEmptyMessage(100);
                    }
                    this.mGLThreadHandler.post(new Runnable() {
                        /* class com.tencent.liteav.trtc.impl.TRTCCustomTextureUtil.AnonymousClass2 */

                        public void run() {
                            AppMethodBeat.i(15729);
                            TXCLog.i(TRTCCustomTextureUtil.TAG, "GLContext create finished!");
                            countDownLatch.countDown();
                            AppMethodBeat.o(15729);
                        }
                    });
                } else {
                    countDownLatch.countDown();
                }
            } catch (Throwable th) {
                AppMethodBeat.o(15593);
                throw th;
            }
        }
        try {
            countDownLatch.await();
            AppMethodBeat.o(15593);
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            AppMethodBeat.o(15593);
        }
    }

    private synchronized void stopThread() {
        AppMethodBeat.i(15594);
        if (this.mGLThreadHandler != null) {
            final h hVar = this.mRotateFilter;
            this.mRotateFilter = null;
            final k kVar = this.mI4202RGBAFilter;
            this.mI4202RGBAFilter = null;
            this.mGLThreadHandler.post(new Runnable() {
                /* class com.tencent.liteav.trtc.impl.TRTCCustomTextureUtil.AnonymousClass3 */

                public void run() {
                    AppMethodBeat.i(222396);
                    if (hVar != null) {
                        hVar.d();
                    }
                    if (kVar != null) {
                        kVar.d();
                    }
                    if (TRTCCustomTextureUtil.this.mCaptureAndEnc != null) {
                        TRTCCustomTextureUtil.access$300(TRTCCustomTextureUtil.this, "CustomCapture release");
                        TRTCCustomTextureUtil.this.mCaptureAndEnc.r();
                    }
                    AppMethodBeat.o(222396);
                }
            });
            g.a(this.mGLThreadHandler, this.mEGLThread);
            apiLog("CustomCapture destroy egl thread");
        }
        this.mGLThreadHandler = null;
        this.mEGLThread = null;
        AppMethodBeat.o(15594);
    }

    private void apiLog(String str) {
        AppMethodBeat.i(15595);
        TXCLog.i(TAG, "trtc_api ".concat(String.valueOf(str)));
        AppMethodBeat.o(15595);
    }

    private int checkRotate(int i2, TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        AppMethodBeat.i(15596);
        if (tRTCVideoFrame == null || tRTCVideoFrame.rotation == 0) {
            AppMethodBeat.o(15596);
        } else {
            int i3 = tRTCVideoFrame.rotation * 90;
            if (this.mRotateFilter == null) {
                h hVar = new h();
                hVar.a();
                hVar.a(true);
                hVar.a(tRTCVideoFrame.width, tRTCVideoFrame.height);
                this.mRotateFilter = hVar;
            }
            h hVar2 = this.mRotateFilter;
            if (hVar2 != null) {
                GLES20.glViewport(0, 0, tRTCVideoFrame.width, tRTCVideoFrame.height);
                int i4 = (720 - i3) % v2helper.VOIP_ENC_HEIGHT_LV1;
                hVar2.a(tRTCVideoFrame.width, tRTCVideoFrame.height);
                hVar2.a(tRTCVideoFrame.width, tRTCVideoFrame.height, i4, null, ((float) tRTCVideoFrame.width) / ((float) tRTCVideoFrame.height), false, false);
                hVar2.b(i2);
                i2 = hVar2.l();
                int i5 = (i4 == 90 || i4 == 270) ? tRTCVideoFrame.height : tRTCVideoFrame.width;
                int i6 = (i4 == 90 || i4 == 270) ? tRTCVideoFrame.width : tRTCVideoFrame.height;
                tRTCVideoFrame.width = i5;
                tRTCVideoFrame.height = i6;
            }
            AppMethodBeat.o(15596);
        }
        return i2;
    }
}
