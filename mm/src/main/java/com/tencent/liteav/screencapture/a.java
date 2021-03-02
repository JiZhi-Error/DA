package com.tencent.liteav.screencapture;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import android.view.WindowManager;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.liteav.basic.c.i;
import com.tencent.liteav.basic.c.j;
import com.tencent.liteav.basic.c.k;
import com.tencent.liteav.basic.c.l;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.e;
import com.tencent.liteav.basic.util.f;
import com.tencent.liteav.screencapture.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.tavkit.component.TAVExporter;
import java.lang.ref.WeakReference;
import java.util.Locale;
import javax.microedition.khronos.egl.EGLContext;

public class a {

    /* renamed from: a  reason: collision with root package name */
    protected final Handler f1157a;

    /* renamed from: b  reason: collision with root package name */
    protected volatile HandlerThread f1158b = null;

    /* renamed from: c  reason: collision with root package name */
    protected volatile b f1159c = null;

    /* renamed from: d  reason: collision with root package name */
    protected volatile WeakReference<b> f1160d = null;

    /* renamed from: e  reason: collision with root package name */
    protected volatile int f1161e = 0;

    /* renamed from: f  reason: collision with root package name */
    protected int f1162f = TAVExporter.VIDEO_EXPORT_WIDTH;

    /* renamed from: g  reason: collision with root package name */
    protected int f1163g = TAVExporter.VIDEO_EXPORT_HEIGHT;

    /* renamed from: h  reason: collision with root package name */
    protected int f1164h = 20;

    /* renamed from: i  reason: collision with root package name */
    protected boolean f1165i = true;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f1166j;
    private final Context k;
    private Object l = null;
    private int m = this.f1162f;
    private int n = this.f1163g;
    private WeakReference<com.tencent.liteav.basic.b.b> o = null;
    private WeakReference<AbstractC0160a> p;
    private c.b q = new c.b() {
        /* class com.tencent.liteav.screencapture.a.AnonymousClass1 */

        @Override // com.tencent.liteav.screencapture.c.b
        public void a(boolean z, boolean z2) {
            AppMethodBeat.i(221422);
            if (z) {
                a.this.b(106);
                AppMethodBeat.o(221422);
                return;
            }
            a.this.p = null;
            f.a(a.this.o, -1308, "Failed to share screen");
            AppMethodBeat.o(221422);
        }

        @Override // com.tencent.liteav.screencapture.c.b
        public void a() {
            AppMethodBeat.i(221423);
            f.a(a.this.o, (int) TXLiteAVCode.ERR_SCREEN_CAPTURE_STOPPED, "Screen recording stopped. It may be preempted by other apps");
            AbstractC0160a b2 = a.b(a.this);
            a.this.p = null;
            if (b2 != null) {
                b2.onScreenCaptureStopped(1);
            }
            AppMethodBeat.o(221423);
        }

        @Override // com.tencent.liteav.screencapture.c.b
        public void a(boolean z) {
            AppMethodBeat.i(221424);
            if (a.this.f1166j) {
                a.this.b(z);
                a.this.b(105, a.this.m, a.this.n);
            }
            AppMethodBeat.o(221424);
        }
    };

    /* renamed from: com.tencent.liteav.screencapture.a$a  reason: collision with other inner class name */
    public interface AbstractC0160a {
        void onScreenCapturePaused();

        void onScreenCaptureResumed();

        void onScreenCaptureStarted();

        void onScreenCaptureStopped(int i2);
    }

    static /* synthetic */ AbstractC0160a b(a aVar) {
        AppMethodBeat.i(221419);
        AbstractC0160a d2 = aVar.d();
        AppMethodBeat.o(221419);
        return d2;
    }

    public a(Context context, boolean z, AbstractC0160a aVar) {
        AppMethodBeat.i(221408);
        this.p = new WeakReference<>(aVar);
        this.k = context.getApplicationContext();
        this.f1157a = new Handler(Looper.getMainLooper());
        this.f1166j = z;
        AppMethodBeat.o(221408);
    }

    public int a(int i2, int i3, int i4) {
        AppMethodBeat.i(16505);
        this.f1164h = i4;
        if (Build.VERSION.SDK_INT < 21) {
            c(20000004);
            AppMethodBeat.o(16505);
            return 20000004;
        }
        c(i2, i3);
        a();
        TXCLog.i("TXCScreenCapture", "start screen capture");
        AppMethodBeat.o(16505);
        return 0;
    }

    public void a(Object obj) {
        AppMethodBeat.i(16506);
        TXCLog.i("TXCScreenCapture", "stop encode: ".concat(String.valueOf(obj)));
        this.l = obj;
        b();
        AppMethodBeat.o(16506);
    }

    public void a(final boolean z) {
        AppMethodBeat.i(16507);
        synchronized (this) {
            try {
                AnonymousClass2 r0 = new Runnable() {
                    /* class com.tencent.liteav.screencapture.a.AnonymousClass2 */

                    public void run() {
                        AppMethodBeat.i(221425);
                        AbstractC0160a b2 = a.b(a.this);
                        if (!(a.this.f1165i == z || b2 == null)) {
                            if (z) {
                                b2.onScreenCaptureResumed();
                            } else {
                                b2.onScreenCapturePaused();
                            }
                        }
                        a.this.f1165i = z;
                        AppMethodBeat.o(221425);
                    }
                };
                if (this.f1159c != null) {
                    this.f1159c.post(r0);
                } else {
                    r0.run();
                }
            } finally {
                AppMethodBeat.o(16507);
            }
        }
    }

    public void a(b bVar) {
        AppMethodBeat.i(221409);
        this.f1160d = new WeakReference<>(bVar);
        AppMethodBeat.o(221409);
    }

    public void a(com.tencent.liteav.basic.b.b bVar) {
        AppMethodBeat.i(221410);
        this.o = new WeakReference<>(bVar);
        AppMethodBeat.o(221410);
    }

    public void a(int i2) {
        AppMethodBeat.i(16515);
        this.f1164h = i2;
        b(103, i2);
        AppMethodBeat.o(16515);
    }

    public void a(int i2, int i3) {
        AppMethodBeat.i(221411);
        c(i2, i3);
        b(105, i2, i3);
        AppMethodBeat.o(221411);
    }

    private void c(int i2, int i3) {
        AppMethodBeat.i(221412);
        if (this.f1166j) {
            int rotation = ((WindowManager) this.k.getSystemService("window")).getDefaultDisplay().getRotation();
            if (rotation == 0 || rotation == 2) {
                if (i2 > i3) {
                    this.f1162f = i3;
                    this.f1163g = i2;
                } else {
                    this.f1162f = i2;
                    this.f1163g = i3;
                }
            } else if (i2 < i3) {
                this.f1162f = i3;
                this.f1163g = i2;
            } else {
                this.f1162f = i2;
                this.f1163g = i3;
            }
        } else {
            this.f1162f = i2;
            this.f1163g = i3;
        }
        this.m = this.f1162f;
        this.n = this.f1163g;
        AppMethodBeat.o(221412);
    }

    public synchronized void a(Runnable runnable) {
        AppMethodBeat.i(16510);
        if (this.f1159c != null) {
            this.f1159c.post(runnable);
        }
        AppMethodBeat.o(16510);
    }

    /* access modifiers changed from: protected */
    public void a() {
        AppMethodBeat.i(16511);
        b();
        synchronized (this) {
            try {
                this.f1158b = new HandlerThread("ScreenCaptureGLThread");
                this.f1158b.start();
                this.f1159c = new b(this.f1158b.getLooper(), this);
                this.f1161e++;
                this.f1159c.f1174a = this.f1161e;
                this.f1159c.f1178e = this.m;
                this.f1159c.f1179f = this.n;
                this.f1159c.f1180g = this.f1164h <= 0 ? 1 : this.f1164h;
            } catch (Throwable th) {
                AppMethodBeat.o(16511);
                throw th;
            }
        }
        b(100);
        AppMethodBeat.o(16511);
    }

    /* access modifiers changed from: protected */
    public void b() {
        AppMethodBeat.i(16512);
        synchronized (this) {
            try {
                this.f1161e++;
                if (this.f1159c != null) {
                    final HandlerThread handlerThread = this.f1158b;
                    final b bVar = this.f1159c;
                    a(101, new Runnable() {
                        /* class com.tencent.liteav.screencapture.a.AnonymousClass3 */

                        public void run() {
                            AppMethodBeat.i(16525);
                            a.this.f1157a.post(new Runnable() {
                                /* class com.tencent.liteav.screencapture.a.AnonymousClass3.AnonymousClass1 */

                                public void run() {
                                    AppMethodBeat.i(16539);
                                    if (bVar != null) {
                                        bVar.removeCallbacksAndMessages(null);
                                    }
                                    if (handlerThread != null) {
                                        if (Build.VERSION.SDK_INT >= 18) {
                                            handlerThread.quitSafely();
                                            AppMethodBeat.o(16539);
                                            return;
                                        }
                                        handlerThread.quit();
                                    }
                                    AppMethodBeat.o(16539);
                                }
                            });
                            AppMethodBeat.o(16525);
                        }
                    });
                }
                this.f1159c = null;
                this.f1158b = null;
            } finally {
                AppMethodBeat.o(16512);
            }
        }
    }

    /* access modifiers changed from: protected */
    public b c() {
        AppMethodBeat.i(221413);
        if (this.f1160d == null) {
            AppMethodBeat.o(221413);
            return null;
        }
        b bVar = this.f1160d.get();
        AppMethodBeat.o(221413);
        return bVar;
    }

    /* access modifiers changed from: protected */
    public void a(int i2, long j2) {
        AppMethodBeat.i(16514);
        synchronized (this) {
            try {
                if (this.f1159c != null) {
                    this.f1159c.sendEmptyMessageDelayed(i2, j2);
                }
            } finally {
                AppMethodBeat.o(16514);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void b(int i2) {
        AppMethodBeat.i(16520);
        synchronized (this) {
            try {
                if (this.f1159c != null) {
                    this.f1159c.sendEmptyMessage(i2);
                }
            } finally {
                AppMethodBeat.o(16520);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void b(int i2, int i3) {
        AppMethodBeat.i(221414);
        synchronized (this) {
            try {
                if (this.f1159c != null) {
                    Message message = new Message();
                    message.what = i2;
                    message.arg1 = i3;
                    this.f1159c.sendMessage(message);
                }
            } finally {
                AppMethodBeat.o(221414);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void b(int i2, int i3, int i4) {
        AppMethodBeat.i(16516);
        synchronized (this) {
            try {
                if (this.f1159c != null) {
                    Message message = new Message();
                    message.what = i2;
                    message.arg1 = i3;
                    message.arg2 = i4;
                    this.f1159c.sendMessage(message);
                }
            } finally {
                AppMethodBeat.o(16516);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(int i2, Runnable runnable) {
        AppMethodBeat.i(16517);
        synchronized (this) {
            try {
                if (this.f1159c != null) {
                    Message message = new Message();
                    message.what = i2;
                    message.obj = runnable;
                    this.f1159c.sendMessage(message);
                }
            } finally {
                AppMethodBeat.o(16517);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void c(int i2) {
        AppMethodBeat.i(221415);
        AbstractC0160a d2 = d();
        if (d2 != null && i2 == 0) {
            d2.onScreenCaptureStarted();
        }
        AppMethodBeat.o(221415);
    }

    /* access modifiers changed from: protected */
    public void a(int i2, EGLContext eGLContext, int i3, int i4, int i5, long j2) {
        AppMethodBeat.i(221416);
        b c2 = c();
        if (c2 != null) {
            c2.a(i2, eGLContext, i3, i4, i5, j2);
        }
        AppMethodBeat.o(221416);
    }

    /* access modifiers changed from: protected */
    public void b(boolean z) {
        AppMethodBeat.i(221417);
        if (z) {
            this.m = this.f1162f < this.f1163g ? this.f1162f : this.f1163g;
            this.n = this.f1162f < this.f1163g ? this.f1163g : this.f1162f;
        } else {
            this.m = this.f1162f < this.f1163g ? this.f1163g : this.f1162f;
            this.n = this.f1162f < this.f1163g ? this.f1162f : this.f1163g;
        }
        TXCLog.i("TXCScreenCapture", String.format(Locale.ENGLISH, "reset screen capture isPortrait[%b] output size[%d/%d]", Boolean.valueOf(z), Integer.valueOf(this.m), Integer.valueOf(this.n)));
        AppMethodBeat.o(221417);
    }

    private AbstractC0160a d() {
        AppMethodBeat.i(221418);
        WeakReference<AbstractC0160a> weakReference = this.p;
        if (weakReference != null) {
            AbstractC0160a aVar = weakReference.get();
            AppMethodBeat.o(221418);
            return aVar;
        }
        AppMethodBeat.o(221418);
        return null;
    }

    /* access modifiers changed from: protected */
    public class b extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public int f1174a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int[] f1175b = null;

        /* renamed from: c  reason: collision with root package name */
        public Surface f1176c = null;

        /* renamed from: d  reason: collision with root package name */
        public SurfaceTexture f1177d = null;

        /* renamed from: e  reason: collision with root package name */
        public int f1178e = TAVExporter.VIDEO_EXPORT_WIDTH;

        /* renamed from: f  reason: collision with root package name */
        public int f1179f = TAVExporter.VIDEO_EXPORT_HEIGHT;

        /* renamed from: g  reason: collision with root package name */
        public int f1180g = 25;

        /* renamed from: h  reason: collision with root package name */
        protected boolean f1181h = false;

        /* renamed from: i  reason: collision with root package name */
        protected long f1182i = 0;

        /* renamed from: j  reason: collision with root package name */
        protected long f1183j = 0;
        protected com.tencent.liteav.basic.c.b k = null;
        protected i l = null;
        float[] m = new float[16];
        private boolean o = true;

        public b(Looper looper, a aVar) {
            super(looper);
            AppMethodBeat.i(221384);
            TXCLog.i("TXCScreenCapture", "TXCScreenCaptureGLThreadHandler inited. hashCode: %d", Integer.valueOf(hashCode()));
            AppMethodBeat.o(221384);
        }

        public void handleMessage(Message message) {
            AppMethodBeat.i(221385);
            if (message == null) {
                AppMethodBeat.o(221385);
            } else if (this.f1174a == a.this.f1161e || 101 == message.what) {
                switch (message.what) {
                    case 100:
                        a(message);
                        break;
                    case 101:
                        b(message);
                        break;
                    case 102:
                        try {
                            c(message);
                            break;
                        } catch (Exception e2) {
                            TXCLog.e("TXCScreenCapture", "render failed.", e2);
                            break;
                        }
                    case 103:
                        d(message);
                        break;
                    case 105:
                        e(message);
                        break;
                    case 106:
                        a();
                        break;
                }
                if (!(message == null || message.obj == null)) {
                    ((Runnable) message.obj).run();
                }
                AppMethodBeat.o(221385);
            } else {
                AppMethodBeat.o(221385);
            }
        }

        /* access modifiers changed from: protected */
        public void a(Message message) {
            AppMethodBeat.i(221386);
            this.f1182i = 0;
            this.f1183j = 0;
            if (!b()) {
                c();
                a.this.b();
                a.this.c(20000003);
            }
            AppMethodBeat.o(221386);
        }

        /* access modifiers changed from: protected */
        public void a() {
            AppMethodBeat.i(221387);
            if (this.o && this.k != null) {
                Bundle bundle = new Bundle();
                bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "Screen recording started successfully");
                f.a(a.this.o, 1004, bundle);
                a.this.c(0);
            }
            this.o = false;
            AppMethodBeat.o(221387);
        }

        /* access modifiers changed from: protected */
        public void b(Message message) {
            AppMethodBeat.i(221388);
            a.this.f1165i = false;
            AbstractC0160a b2 = a.b(a.this);
            if (b2 != null) {
                b2.onScreenCaptureStopped(0);
            }
            b c2 = a.this.c();
            if (c2 != null) {
                c2.a(a.this.l);
            }
            c();
            AppMethodBeat.o(221388);
        }

        /* access modifiers changed from: protected */
        public void c(Message message) {
            AppMethodBeat.i(221389);
            a.this.a(102, 5L);
            if (!a.this.f1165i) {
                AppMethodBeat.o(221389);
            } else if (this.k == null) {
                TXCLog.e("TXCScreenCapture", "eglhelper is null");
                AppMethodBeat.o(221389);
            } else if (!this.f1181h) {
                this.f1182i = 0;
                this.f1183j = System.nanoTime();
                AppMethodBeat.o(221389);
            } else {
                long nanoTime = System.nanoTime();
                if (nanoTime < this.f1183j + ((((this.f1182i * 1000) * 1000) * 1000) / ((long) this.f1180g))) {
                    AppMethodBeat.o(221389);
                    return;
                }
                if (this.f1183j == 0) {
                    this.f1183j = nanoTime;
                } else if (nanoTime > this.f1183j + 1000000000) {
                    this.f1182i = 0;
                    this.f1183j = nanoTime;
                }
                this.f1182i++;
                if (this.f1177d == null || this.f1175b == null) {
                    AppMethodBeat.o(221389);
                    return;
                }
                this.f1177d.getTransformMatrix(this.m);
                try {
                    this.f1177d.updateTexImage();
                } catch (Exception e2) {
                    TXCLog.e("TXCScreenCapture", "onMsgRend Exception " + e2.getMessage());
                }
                this.l.a(this.m);
                GLES20.glViewport(0, 0, this.f1178e, this.f1179f);
                a.this.a(0, this.k.d(), this.l.b(this.f1175b[0]), this.f1178e, this.f1179f, TXCTimeUtil.getTimeTick());
                AppMethodBeat.o(221389);
            }
        }

        /* access modifiers changed from: protected */
        public void d(Message message) {
            if (message != null) {
                this.f1180g = message.arg1 <= 0 ? 1 : message.arg1;
                this.f1182i = 0;
                this.f1183j = 0;
            }
        }

        /* access modifiers changed from: protected */
        public void e(Message message) {
            AppMethodBeat.i(221390);
            if (message == null) {
                AppMethodBeat.o(221390);
                return;
            }
            this.f1178e = message.arg1;
            this.f1179f = message.arg2;
            d();
            this.l.a(this.f1178e, this.f1179f);
            e();
            TXCLog.i("TXCScreenCapture", String.format("set screen capture size[%d/%d]", Integer.valueOf(a.this.m), Integer.valueOf(a.this.n)));
            AppMethodBeat.o(221390);
        }

        /* access modifiers changed from: protected */
        public boolean b() {
            AppMethodBeat.i(221391);
            TXCLog.i("TXCScreenCapture", String.format("init egl size[%d/%d]", Integer.valueOf(this.f1178e), Integer.valueOf(this.f1179f)));
            this.k = com.tencent.liteav.basic.c.b.a(null, null, null, this.f1178e, this.f1179f);
            if (this.k == null) {
                AppMethodBeat.o(221391);
                return false;
            }
            this.l = new i();
            if (!this.l.a()) {
                AppMethodBeat.o(221391);
                return false;
            }
            this.l.a(true);
            this.l.a(this.f1178e, this.f1179f);
            this.l.a(l.f344e, l.a(k.NORMAL, false, false));
            e();
            AppMethodBeat.o(221391);
            return true;
        }

        /* access modifiers changed from: protected */
        public void c() {
            AppMethodBeat.i(221392);
            d();
            if (this.l != null) {
                this.l.d();
                this.l = null;
            }
            if (this.k != null) {
                this.k.c();
                this.k = null;
            }
            AppMethodBeat.o(221392);
        }

        /* access modifiers changed from: protected */
        public void d() {
            AppMethodBeat.i(221393);
            new e(Looper.getMainLooper()).a(new Runnable() {
                /* class com.tencent.liteav.screencapture.a.b.AnonymousClass1 */

                public void run() {
                    AppMethodBeat.i(221426);
                    c.a(a.this.k).a(b.this.f1176c);
                    AppMethodBeat.o(221426);
                }
            });
            if (this.f1176c != null) {
                this.f1176c.release();
                this.f1176c = null;
            }
            if (this.f1177d != null) {
                this.f1177d.setOnFrameAvailableListener(null);
                this.f1177d.release();
                this.f1181h = false;
                this.f1177d = null;
            }
            if (this.f1175b != null) {
                GLES20.glDeleteTextures(1, this.f1175b, 0);
                this.f1175b = null;
            }
            AppMethodBeat.o(221393);
        }

        /* access modifiers changed from: protected */
        public void e() {
            AppMethodBeat.i(221394);
            this.f1175b = new int[1];
            this.f1175b[0] = j.b();
            if (this.f1175b[0] <= 0) {
                this.f1175b = null;
                AppMethodBeat.o(221394);
                return;
            }
            this.f1177d = new SurfaceTexture(this.f1175b[0]);
            this.f1176c = new Surface(this.f1177d);
            this.f1177d.setDefaultBufferSize(this.f1178e, this.f1179f);
            this.f1177d.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() {
                /* class com.tencent.liteav.screencapture.a.b.AnonymousClass2 */

                public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                    AppMethodBeat.i(221421);
                    a.this.a(104, new Runnable() {
                        /* class com.tencent.liteav.screencapture.a.b.AnonymousClass2.AnonymousClass1 */

                        public void run() {
                            AppMethodBeat.i(221407);
                            b.this.f1181h = true;
                            a.this.b(102);
                            AppMethodBeat.o(221407);
                        }
                    });
                    surfaceTexture.setOnFrameAvailableListener(null);
                    AppMethodBeat.o(221421);
                }
            });
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.tencent.liteav.screencapture.a.b.AnonymousClass3 */

                public void run() {
                    AppMethodBeat.i(221427);
                    c.a(a.this.k).a(b.this.f1176c, b.this.f1178e, b.this.f1179f, a.this.q);
                    AppMethodBeat.o(221427);
                }
            });
            AppMethodBeat.o(221394);
        }
    }
}
