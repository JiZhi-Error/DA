package com.tencent.liteav.basic.c;

import android.opengl.EGLContext;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tavkit.component.TAVExporter;

public class g extends e {

    /* renamed from: a  reason: collision with root package name */
    public int f288a = TAVExporter.VIDEO_EXPORT_WIDTH;

    /* renamed from: b  reason: collision with root package name */
    public int f289b = TAVExporter.VIDEO_EXPORT_HEIGHT;

    /* renamed from: c  reason: collision with root package name */
    public Surface f290c = null;

    /* renamed from: d  reason: collision with root package name */
    public boolean f291d = false;

    /* renamed from: e  reason: collision with root package name */
    public c f292e = null;

    /* renamed from: f  reason: collision with root package name */
    public EGLContext f293f = null;

    /* renamed from: g  reason: collision with root package name */
    public b f294g = null;

    /* renamed from: h  reason: collision with root package name */
    public javax.microedition.khronos.egl.EGLContext f295h = null;

    /* renamed from: i  reason: collision with root package name */
    private a f296i = null;

    /* access modifiers changed from: package-private */
    public interface a {
        void c();

        void d();

        void e();
    }

    public static void a(final Handler handler, final HandlerThread handlerThread) {
        AppMethodBeat.i(222246);
        if (handler == null || handlerThread == null) {
            AppMethodBeat.o(222246);
            return;
        }
        Message message = new Message();
        message.what = 101;
        message.obj = new Runnable() {
            /* class com.tencent.liteav.basic.c.g.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(222245);
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    /* class com.tencent.liteav.basic.c.g.AnonymousClass1.AnonymousClass1 */

                    public void run() {
                        AppMethodBeat.i(222310);
                        if (handler != null) {
                            handler.removeCallbacksAndMessages(null);
                        }
                        if (handlerThread != null) {
                            if (Build.VERSION.SDK_INT >= 18) {
                                handlerThread.quitSafely();
                                AppMethodBeat.o(222310);
                                return;
                            }
                            handlerThread.quit();
                        }
                        AppMethodBeat.o(222310);
                    }
                });
                AppMethodBeat.o(222245);
            }
        };
        handler.sendMessage(message);
        AppMethodBeat.o(222246);
    }

    public g(Looper looper) {
        super(looper);
    }

    public void a(a aVar) {
        this.f296i = aVar;
    }

    public javax.microedition.khronos.egl.EGLContext a() {
        AppMethodBeat.i(222247);
        if (this.f294g != null) {
            javax.microedition.khronos.egl.EGLContext d2 = this.f294g.d();
            AppMethodBeat.o(222247);
            return d2;
        }
        AppMethodBeat.o(222247);
        return null;
    }

    public Surface b() {
        return this.f290c;
    }

    public void c() {
        AppMethodBeat.i(222248);
        if (this.f294g != null) {
            this.f294g.a();
        }
        if (this.f292e != null) {
            this.f292e.d();
        }
        AppMethodBeat.o(222248);
    }

    public void d() {
        AppMethodBeat.i(222249);
        if (this.f294g != null) {
            this.f294g.b();
        }
        if (this.f292e != null) {
            this.f292e.b();
        }
        AppMethodBeat.o(222249);
    }

    public void handleMessage(Message message) {
        AppMethodBeat.i(222250);
        if (message == null) {
            AppMethodBeat.o(222250);
            return;
        }
        switch (message.what) {
            case 100:
                a(message);
                break;
            case 101:
                b(message);
                break;
            case 102:
                c(message);
                break;
        }
        if (!(message == null || message.obj == null)) {
            ((Runnable) message.obj).run();
        }
        AppMethodBeat.o(222250);
    }

    private void a(Message message) {
        AppMethodBeat.i(222251);
        try {
            e();
            AppMethodBeat.o(222251);
        } catch (Exception e2) {
            TXCLog.e("TXGLThreadHandler", "surface-render: init egl context exception " + this.f290c);
            this.f290c = null;
            AppMethodBeat.o(222251);
        }
    }

    private void b(Message message) {
        AppMethodBeat.i(222252);
        f();
        AppMethodBeat.o(222252);
    }

    private void c(Message message) {
        AppMethodBeat.i(222253);
        try {
            if (this.f296i != null) {
                this.f296i.d();
            }
            AppMethodBeat.o(222253);
        } catch (Exception e2) {
            TXCLog.e("TXGLThreadHandler", "onMsgRend Exception " + e2.getMessage());
            AppMethodBeat.o(222253);
        }
    }

    private boolean e() {
        AppMethodBeat.i(222254);
        TXCLog.i("TXGLThreadHandler", String.format("init egl size[%d/%d]", Integer.valueOf(this.f288a), Integer.valueOf(this.f289b)));
        if (!this.f291d) {
            this.f294g = b.a(null, this.f295h, this.f290c, this.f288a, this.f289b);
        } else {
            this.f292e = c.a(null, this.f293f, this.f290c, this.f288a, this.f289b);
        }
        if (this.f294g == null && this.f292e == null) {
            AppMethodBeat.o(222254);
            return false;
        }
        TXCLog.w("TXGLThreadHandler", "surface-render: create egl context " + this.f290c);
        if (this.f296i != null) {
            this.f296i.c();
        }
        AppMethodBeat.o(222254);
        return true;
    }

    private void f() {
        AppMethodBeat.i(222255);
        TXCLog.w("TXGLThreadHandler", "surface-render: destroy egl context " + this.f290c);
        if (this.f296i != null) {
            this.f296i.e();
        }
        if (this.f294g != null) {
            this.f294g.c();
            this.f294g = null;
        }
        if (this.f292e != null) {
            this.f292e.c();
            this.f292e = null;
        }
        this.f290c = null;
        AppMethodBeat.o(222255);
    }
}
