package com.tencent.liteav.screencapture;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.hardware.display.VirtualDisplay;
import android.media.projection.MediaProjection;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.WindowManager;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.e;
import com.tencent.liteav.basic.util.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.video.TXScreenCapture;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@TargetApi(21)
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static volatile c f1188a = null;
    private byte _hellAccFlag_;

    /* renamed from: b  reason: collision with root package name */
    private final Context f1189b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f1190c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<Surface, a> f1191d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private boolean f1192e = false;

    /* renamed from: f  reason: collision with root package name */
    private MediaProjection f1193f;

    /* renamed from: g  reason: collision with root package name */
    private h f1194g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1195h;

    /* renamed from: i  reason: collision with root package name */
    private MediaProjection.Callback f1196i = new MediaProjection.Callback() {
        /* class com.tencent.liteav.screencapture.c.AnonymousClass1 */

        public void onStop() {
            AppMethodBeat.i(221395);
            TXCLog.e("VirtualDisplayManager", "MediaProjection session is no longer valid");
            HashMap hashMap = new HashMap(c.this.f1191d);
            c.this.f1191d.clear();
            for (a aVar : hashMap.values()) {
                if (aVar.f1204d != null) {
                    if (aVar.f1205e != null) {
                        aVar.f1204d.a();
                    } else {
                        aVar.f1204d.a(false, false);
                    }
                }
            }
            c.a(c.this, false);
            AppMethodBeat.o(221395);
        }
    };

    /* renamed from: j  reason: collision with root package name */
    private h.a f1197j = new h.a() {
        /* class com.tencent.liteav.screencapture.c.AnonymousClass2 */

        @Override // com.tencent.liteav.basic.util.h.a
        public void a() {
            AppMethodBeat.i(221420);
            boolean a2 = c.a(c.this, c.this.f1189b);
            if (c.this.f1195h == a2) {
                AppMethodBeat.o(221420);
                return;
            }
            c.this.f1195h = a2;
            for (a aVar : c.this.f1191d.values()) {
                if (aVar.f1204d != null) {
                    aVar.f1204d.a(a2);
                }
            }
            AppMethodBeat.o(221420);
        }
    };

    public interface b {
        void a();

        void a(boolean z);

        void a(boolean z, boolean z2);
    }

    static /* synthetic */ void a(c cVar, boolean z) {
        AppMethodBeat.i(221405);
        cVar.a(z);
        AppMethodBeat.o(221405);
    }

    static /* synthetic */ boolean a(c cVar, Context context) {
        AppMethodBeat.i(221406);
        boolean b2 = cVar.b(context);
        AppMethodBeat.o(221406);
        return b2;
    }

    public static c a(Context context) {
        AppMethodBeat.i(221397);
        if (f1188a == null) {
            synchronized (c.class) {
                try {
                    if (f1188a == null) {
                        f1188a = new c(context);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(221397);
                    throw th;
                }
            }
        }
        c cVar = f1188a;
        AppMethodBeat.o(221397);
        return cVar;
    }

    public c(Context context) {
        AppMethodBeat.i(221398);
        this.f1189b = context.getApplicationContext();
        this.f1190c = new e(Looper.getMainLooper());
        this.f1195h = b(context);
        AppMethodBeat.o(221398);
    }

    public void a(Surface surface, int i2, int i3, b bVar) {
        AppMethodBeat.i(221399);
        if (Looper.myLooper() != Looper.getMainLooper()) {
            IllegalStateException illegalStateException = new IllegalStateException("Must call this method in main thread!");
            AppMethodBeat.o(221399);
            throw illegalStateException;
        } else if (surface == null) {
            TXCLog.e("VirtualDisplayManager", "surface is null!");
            bVar.a(false, false);
            AppMethodBeat.o(221399);
        } else {
            a aVar = new a();
            aVar.f1201a = surface;
            aVar.f1202b = i2;
            aVar.f1203c = i3;
            aVar.f1204d = bVar;
            aVar.f1205e = null;
            this.f1191d.put(surface, aVar);
            if (this.f1193f != null) {
                a();
            } else if (!this.f1192e) {
                this.f1192e = true;
                Intent intent = new Intent(this.f1189b, TXScreenCapture.TXScreenCaptureAssistantActivity.class);
                intent.addFlags(268435456);
                Context context = this.f1189b;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/liteav/screencapture/c", "a", "(Landroid/view/Surface;IILcom/tencent/liteav/screencapture/c$b;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/liteav/screencapture/c", "a", "(Landroid/view/Surface;IILcom/tencent/liteav/screencapture/c$b;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(221399);
                return;
            }
            AppMethodBeat.o(221399);
        }
    }

    public void a(Surface surface) {
        AppMethodBeat.i(221400);
        if (Looper.myLooper() != Looper.getMainLooper()) {
            IllegalStateException illegalStateException = new IllegalStateException("Must call this at main thread!");
            AppMethodBeat.o(221400);
            throw illegalStateException;
        } else if (surface == null) {
            AppMethodBeat.o(221400);
        } else {
            a remove = this.f1191d.remove(surface);
            if (!(remove == null || remove.f1205e == null)) {
                remove.f1205e.release();
                TXCLog.i("VirtualDisplayManager", "VirtualDisplay released, " + remove.f1205e);
            }
            a(true);
            AppMethodBeat.o(221400);
        }
    }

    private void a() {
        AppMethodBeat.i(221401);
        for (a aVar : this.f1191d.values()) {
            if (aVar.f1205e == null) {
                aVar.f1205e = this.f1193f.createVirtualDisplay("TXCScreenCapture", aVar.f1202b, aVar.f1203c, 1, 1, aVar.f1201a, null, null);
                TXCLog.i("VirtualDisplayManager", "create VirtualDisplay " + aVar.f1205e);
                if (aVar.f1204d != null) {
                    aVar.f1204d.a(true, false);
                }
            }
        }
        AppMethodBeat.o(221401);
    }

    private void a(boolean z) {
        AppMethodBeat.i(221402);
        if (!this.f1191d.isEmpty()) {
            AppMethodBeat.o(221402);
        } else if (z) {
            this.f1190c.postDelayed(new Runnable() {
                /* class com.tencent.liteav.screencapture.c.AnonymousClass3 */

                public void run() {
                    AppMethodBeat.i(221396);
                    c.a(c.this, false);
                    AppMethodBeat.o(221396);
                }
            }, TimeUnit.SECONDS.toMillis(1));
            AppMethodBeat.o(221402);
        } else {
            TXCLog.i("VirtualDisplayManager", "stop media projection session " + this.f1193f);
            if (this.f1193f != null) {
                this.f1193f.unregisterCallback(this.f1196i);
                this.f1193f.stop();
                this.f1193f = null;
            }
            if (this.f1194g != null) {
                this.f1194g.a();
                this.f1194g = null;
            }
            AppMethodBeat.o(221402);
        }
    }

    public void a(MediaProjection mediaProjection) {
        AppMethodBeat.i(221403);
        this.f1192e = false;
        if (mediaProjection == null) {
            HashMap hashMap = new HashMap(this.f1191d);
            this.f1191d.clear();
            for (a aVar : hashMap.values()) {
                if (aVar.f1204d != null) {
                    aVar.f1204d.a(false, true);
                }
            }
            AppMethodBeat.o(221403);
            return;
        }
        TXCLog.i("VirtualDisplayManager", "Got session ".concat(String.valueOf(mediaProjection)));
        this.f1193f = mediaProjection;
        this.f1193f.registerCallback(this.f1196i, this.f1190c);
        a();
        this.f1194g = new h(Looper.getMainLooper(), this.f1197j);
        this.f1194g.a(50, 50);
        a(true);
        AppMethodBeat.o(221403);
    }

    private boolean b(Context context) {
        AppMethodBeat.i(221404);
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            AppMethodBeat.o(221404);
            return true;
        }
        int rotation = windowManager.getDefaultDisplay().getRotation();
        if (rotation == 0 || rotation == 2) {
            AppMethodBeat.o(221404);
            return true;
        }
        AppMethodBeat.o(221404);
        return false;
    }

    /* access modifiers changed from: package-private */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Surface f1201a;

        /* renamed from: b  reason: collision with root package name */
        public int f1202b;

        /* renamed from: c  reason: collision with root package name */
        public int f1203c;

        /* renamed from: d  reason: collision with root package name */
        public b f1204d;

        /* renamed from: e  reason: collision with root package name */
        public VirtualDisplay f1205e;

        private a() {
        }
    }
}
