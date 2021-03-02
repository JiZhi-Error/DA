package com.tencent.liteav.beauty.b;

import android.content.res.AssetFileDescriptor;
import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.os.Handler;
import android.os.Looper;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class w {

    /* renamed from: b  reason: collision with root package name */
    private static final String f536b = w.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    SurfaceTexture.OnFrameAvailableListener f537a;

    /* renamed from: c  reason: collision with root package name */
    private SurfaceTexture f538c;

    /* renamed from: d  reason: collision with root package name */
    private int f539d = -1;

    /* renamed from: e  reason: collision with root package name */
    private boolean f540e = false;

    /* renamed from: f  reason: collision with root package name */
    private MediaExtractor f541f;

    /* renamed from: g  reason: collision with root package name */
    private AssetFileDescriptor f542g;

    /* renamed from: h  reason: collision with root package name */
    private int f543h = -1;

    /* renamed from: i  reason: collision with root package name */
    private int f544i = -1;

    /* renamed from: j  reason: collision with root package name */
    private int f545j = -1;
    private int k = -1;
    private long l;
    private MediaCodec m;
    private boolean n = false;
    private boolean o;
    private Handler p;
    private Object q = new Object();

    static /* synthetic */ void b(w wVar) {
        AppMethodBeat.i(15045);
        wVar.c();
        AppMethodBeat.o(15045);
    }

    w() {
        AppMethodBeat.i(15041);
        AppMethodBeat.o(15041);
    }

    /* access modifiers changed from: package-private */
    public synchronized void a() {
        AppMethodBeat.i(15042);
        synchronized (this.q) {
            try {
                if (this.p != null) {
                    if (Looper.myLooper() == this.p.getLooper()) {
                        c();
                    } else {
                        AnonymousClass1 r0 = new Runnable() {
                            /* class com.tencent.liteav.beauty.b.w.AnonymousClass1 */

                            public void run() {
                                AppMethodBeat.i(15109);
                                synchronized (w.this.q) {
                                    try {
                                        w.b(w.this);
                                        w.this.q.notify();
                                    } finally {
                                        AppMethodBeat.o(15109);
                                    }
                                }
                            }
                        };
                        this.p.removeCallbacksAndMessages(null);
                        this.p.post(r0);
                        this.p.getLooper().quitSafely();
                        while (true) {
                            try {
                                this.q.wait();
                                break;
                            } catch (InterruptedException e2) {
                            }
                        }
                    }
                }
            } finally {
                AppMethodBeat.o(15042);
            }
        }
    }

    private void b() {
        AppMethodBeat.i(15043);
        if (this.f540e) {
            this.f540e = false;
            if (this.f541f != null) {
                this.f541f.release();
                this.f541f = null;
            }
            try {
                this.m.stop();
                try {
                    this.m.release();
                } catch (Exception e2) {
                    TXCLog.e(f536b, "release decoder exception: " + e2.toString());
                } finally {
                    this.m = null;
                    AppMethodBeat.o(15043);
                }
            } catch (Exception e3) {
                TXCLog.e(f536b, "stop decoder Exception: " + e3.toString());
                try {
                    this.m.release();
                } catch (Exception e4) {
                    TXCLog.e(f536b, "release decoder exception: " + e4.toString());
                } finally {
                    this.m = null;
                    AppMethodBeat.o(15043);
                }
            } catch (Throwable th) {
                try {
                    this.m.release();
                    this.m = null;
                } catch (Exception e5) {
                    TXCLog.e(f536b, "release decoder exception: " + e5.toString());
                    this.m = null;
                } catch (Throwable th2) {
                    this.m = null;
                    AppMethodBeat.o(15043);
                    throw th2;
                }
                AppMethodBeat.o(15043);
                throw th;
            }
        } else {
            AppMethodBeat.o(15043);
        }
    }

    private void c() {
        AppMethodBeat.i(15044);
        b();
        this.f537a = null;
        this.l = 0;
        this.o = false;
        if (this.f538c != null) {
            this.f538c.release();
            this.f538c = null;
        }
        synchronized (this.q) {
            try {
                if (this.p != null) {
                    this.p.removeCallbacksAndMessages(null);
                    this.p.getLooper().quit();
                    this.p = null;
                    this.q.notify();
                }
            } finally {
                AppMethodBeat.o(15044);
            }
        }
        if (this.f542g != null) {
            try {
                this.f542g.close();
            } catch (Exception e2) {
            }
            this.f542g = null;
        }
    }

    static {
        AppMethodBeat.i(15046);
        AppMethodBeat.o(15046);
    }
}
