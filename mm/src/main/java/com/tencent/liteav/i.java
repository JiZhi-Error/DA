package com.tencent.liteav;

import android.content.Context;
import com.tencent.liteav.basic.a.c;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.util.d;
import com.tencent.liteav.basic.util.f;
import com.tencent.liteav.screencapture.a;
import com.tencent.liteav.screencapture.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tavkit.component.TAVExporter;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import javax.microedition.khronos.egl.EGLContext;

public class i implements k, b {

    /* renamed from: a  reason: collision with root package name */
    private final a f800a;

    /* renamed from: b  reason: collision with root package name */
    private l f801b;

    /* renamed from: c  reason: collision with root package name */
    private EGLContext f802c = null;

    /* renamed from: d  reason: collision with root package name */
    private WeakReference<com.tencent.liteav.basic.b.b> f803d = null;

    /* renamed from: e  reason: collision with root package name */
    private int f804e;

    /* renamed from: f  reason: collision with root package name */
    private d f805f;

    /* renamed from: g  reason: collision with root package name */
    private int f806g;

    /* renamed from: h  reason: collision with root package name */
    private int f807h;

    /* renamed from: i  reason: collision with root package name */
    private String f808i = "";

    /* renamed from: j  reason: collision with root package name */
    private int f809j = 0;
    private long k;
    private long l;
    private long m;
    private boolean n;
    private final Queue<Runnable> o = new LinkedList();

    public i(Context context, g gVar, a.AbstractC0160a aVar) {
        AppMethodBeat.i(221602);
        this.f800a = new a(context, gVar.V, aVar);
        this.f800a.a((b) this);
        gVar.a();
        this.f805f = c(gVar.f777a, gVar.f778b);
        this.f804e = gVar.f784h;
        this.f806g = gVar.f777a;
        this.f807h = gVar.f778b;
        TXCLog.i("TXCScreenCaptureSource", "capture size: %s, encode size: %dx%d", this.f805f, Integer.valueOf(this.f806g), Integer.valueOf(this.f807h));
        AppMethodBeat.o(221602);
    }

    private d c(int i2, int i3) {
        int i4;
        int i5 = TAVExporter.VIDEO_EXPORT_WIDTH;
        AppMethodBeat.i(221603);
        boolean z = i2 > i3;
        d dVar = new d();
        if (i2 > 1280 || i3 > 1280) {
            dVar.f460a = z ? Math.max(i2, i3) : Math.min(i2, i3);
            dVar.f461b = z ? Math.min(i2, i3) : Math.max(i2, i3);
        } else {
            if (z) {
                i4 = 1280;
            } else {
                i4 = 720;
            }
            dVar.f460a = i4;
            if (!z) {
                i5 = 1280;
            }
            dVar.f461b = i5;
        }
        AppMethodBeat.o(221603);
        return dVar;
    }

    @Override // com.tencent.liteav.k
    public void a() {
        AppMethodBeat.i(221604);
        Monitor.a(2, String.format("VideoCapture[%d]: start screen", Integer.valueOf(hashCode())), "", 0);
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = true;
        this.f800a.a(this.f805f.f460a, this.f805f.f461b, this.f804e);
        AppMethodBeat.o(221604);
    }

    @Override // com.tencent.liteav.k
    public void a(boolean z) {
        AppMethodBeat.i(221605);
        Monitor.a(2, String.format("VideoCapture[%d]: stop screen", Integer.valueOf(hashCode())), "", 0);
        this.f800a.a((Object) null);
        AppMethodBeat.o(221605);
    }

    @Override // com.tencent.liteav.k
    public void a(String str) {
        this.f808i = str;
    }

    @Override // com.tencent.liteav.k
    public void c() {
        AppMethodBeat.i(221606);
        this.f800a.a(false);
        AppMethodBeat.o(221606);
    }

    @Override // com.tencent.liteav.k
    public void b() {
        AppMethodBeat.i(221607);
        this.f800a.a(true);
        AppMethodBeat.o(221607);
    }

    @Override // com.tencent.liteav.k
    public void b(boolean z) {
        AppMethodBeat.i(221608);
        d c2 = c(this.f806g, this.f807h);
        if (!c2.equals(this.f805f)) {
            this.f805f = c2;
            this.f800a.a(c2.f460a, c2.f461b);
            TXCLog.i("TXCScreenCaptureSource", "capture size: %s, encode size: %dx%d", this.f805f, Integer.valueOf(this.f806g), Integer.valueOf(this.f807h));
        }
        AppMethodBeat.o(221608);
    }

    @Override // com.tencent.liteav.k
    public boolean d() {
        return true;
    }

    @Override // com.tencent.liteav.k
    public int e() {
        return 0;
    }

    @Override // com.tencent.liteav.k
    public EGLContext f() {
        return this.f802c;
    }

    @Override // com.tencent.liteav.k
    public boolean a(int i2) {
        return false;
    }

    @Override // com.tencent.liteav.k
    public void a(int i2, int i3) {
    }

    @Override // com.tencent.liteav.k
    public void a(float f2) {
    }

    @Override // com.tencent.liteav.k
    public void b(int i2) {
    }

    @Override // com.tencent.liteav.k
    public void c(int i2) {
    }

    @Override // com.tencent.liteav.k
    public void d(int i2) {
    }

    @Override // com.tencent.liteav.k
    public void a(l lVar) {
        this.f801b = lVar;
    }

    @Override // com.tencent.liteav.k
    public void c(boolean z) {
    }

    @Override // com.tencent.liteav.k
    public boolean d(boolean z) {
        return false;
    }

    @Override // com.tencent.liteav.k
    public void a(com.tencent.liteav.basic.structs.b bVar) {
    }

    @Override // com.tencent.liteav.k
    public void a(Runnable runnable) {
        AppMethodBeat.i(221609);
        if (this.f800a != null) {
            this.f800a.a(runnable);
        }
        AppMethodBeat.o(221609);
    }

    @Override // com.tencent.liteav.k
    public void a(com.tencent.liteav.basic.b.b bVar) {
        AppMethodBeat.i(221610);
        this.f803d = new WeakReference<>(bVar);
        if (this.f800a != null) {
            this.f800a.a(bVar);
        }
        AppMethodBeat.o(221610);
    }

    @Override // com.tencent.liteav.k
    public void e(int i2) {
    }

    @Override // com.tencent.liteav.k
    public void a(c cVar) {
    }

    @Override // com.tencent.liteav.k
    public void b(int i2, int i3) {
        this.f806g = i2;
        this.f807h = i3;
    }

    @Override // com.tencent.liteav.k
    public void f(int i2) {
        AppMethodBeat.i(221611);
        this.f804e = i2;
        this.f800a.a(i2);
        AppMethodBeat.o(221611);
    }

    @Override // com.tencent.liteav.k
    public void a(float f2, float f3) {
    }

    @Override // com.tencent.liteav.k
    public int g() {
        return this.f804e;
    }

    @Override // com.tencent.liteav.k
    public boolean h() {
        return false;
    }

    @Override // com.tencent.liteav.k
    public boolean i() {
        return false;
    }

    @Override // com.tencent.liteav.k
    public boolean j() {
        return false;
    }

    @Override // com.tencent.liteav.k
    public boolean k() {
        return false;
    }

    @Override // com.tencent.liteav.k
    public boolean l() {
        return false;
    }

    @Override // com.tencent.liteav.k
    public void g(int i2) {
        this.f809j = i2;
    }

    @Override // com.tencent.liteav.k
    public void e(boolean z) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(221612);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0028, code lost:
        r0.run();
        com.tencent.matrix.trace.core.AppMethodBeat.o(221612);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001b, code lost:
        if (r0 != null) goto L_0x0028;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(java.util.Queue<java.lang.Runnable> r4) {
        /*
            r3 = this;
            r1 = 0
            r2 = 221612(0x361ac, float:3.10545E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            monitor-enter(r4)
            boolean r0 = r4.isEmpty()     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0014
            monitor-exit(r4)     // Catch:{ all -> 0x0022 }
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            r0 = r1
        L_0x0013:
            return r0
        L_0x0014:
            java.lang.Object r0 = r4.poll()
            java.lang.Runnable r0 = (java.lang.Runnable) r0
            monitor-exit(r4)
            if (r0 != 0) goto L_0x0028
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            r0 = r1
            goto L_0x0013
        L_0x0022:
            r0 = move-exception
            monitor-exit(r4)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            throw r0
        L_0x0028:
            r0.run()
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0013
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.i.a(java.util.Queue):boolean");
    }

    @Override // com.tencent.liteav.screencapture.b
    public void a(int i2, EGLContext eGLContext, int i3, int i4, int i5, long j2) {
        AppMethodBeat.i(221613);
        this.f802c = eGLContext;
        do {
        } while (a(this.o));
        if (i2 != 0) {
            TXCLog.e("TXCScreenCaptureSource", "onScreenCaptureFrame failed");
            AppMethodBeat.o(221613);
            return;
        }
        if (this.n) {
            this.n = false;
            Monitor.a(2, String.format("VideoCapture[%d]: capture first frame", Integer.valueOf(hashCode())), "", 0);
            f.a(this.f803d, 1007, "First frame capture completed");
            TXCLog.i("TXCScreenCaptureSource", "on Got first frame");
        }
        this.k++;
        long currentTimeMillis = System.currentTimeMillis() - this.l;
        if (currentTimeMillis >= TimeUnit.SECONDS.toMillis(1)) {
            double d2 = (((double) (this.k - this.m)) * 1000.0d) / ((double) currentTimeMillis);
            this.m = this.k;
            this.l = System.currentTimeMillis();
            TXCStatus.a(this.f808i, 1001, this.f809j, Double.valueOf(d2));
        }
        if (this.f801b != null) {
            f(i4 < i5);
            com.tencent.liteav.basic.structs.b bVar = new com.tencent.liteav.basic.structs.b();
            bVar.f432e = i4;
            bVar.f433f = i5;
            bVar.f434g = this.f806g;
            bVar.f435h = this.f807h;
            bVar.f428a = i3;
            bVar.f429b = 0;
            bVar.f437j = 0;
            bVar.l = f.a(bVar.f432e, bVar.f433f, this.f806g, this.f807h);
            this.f801b.b(bVar);
        }
        AppMethodBeat.o(221613);
    }

    @Override // com.tencent.liteav.screencapture.b
    public void a(Object obj) {
        AppMethodBeat.i(221614);
        do {
        } while (a(this.o));
        if (this.f801b != null) {
            this.f801b.s();
        }
        AppMethodBeat.o(221614);
    }

    private void f(boolean z) {
        AppMethodBeat.i(221615);
        if (z) {
            if (this.f806g > this.f807h) {
                b(this.f807h, this.f806g);
                AppMethodBeat.o(221615);
                return;
            }
        } else if (this.f806g < this.f807h) {
            b(this.f807h, this.f806g);
        }
        AppMethodBeat.o(221615);
    }
}
