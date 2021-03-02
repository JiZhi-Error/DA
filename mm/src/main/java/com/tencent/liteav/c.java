package com.tencent.liteav;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.liteav.basic.b.b;
import com.tencent.liteav.basic.c.m;
import com.tencent.liteav.basic.c.n;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.util.f;
import com.tencent.liteav.capturer.a;
import com.tencent.liteav.renderer.TXCGLSurfaceView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.lang.ref.WeakReference;
import java.util.List;
import javax.microedition.khronos.egl.EGLContext;

public class c implements b, n, com.tencent.liteav.capturer.b, k {

    /* renamed from: a  reason: collision with root package name */
    WeakReference<b> f643a;

    /* renamed from: b  reason: collision with root package name */
    private Context f644b;

    /* renamed from: c  reason: collision with root package name */
    private final a f645c = new a();

    /* renamed from: d  reason: collision with root package name */
    private l f646d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f647e;

    /* renamed from: f  reason: collision with root package name */
    private g f648f;

    /* renamed from: g  reason: collision with root package name */
    private int f649g = 0;

    /* renamed from: h  reason: collision with root package name */
    private m f650h = null;

    /* renamed from: i  reason: collision with root package name */
    private boolean f651i = false;

    /* renamed from: j  reason: collision with root package name */
    private long f652j = 0;
    private long k;
    private long l = 0;
    private int m = 0;
    private Object n = new Object();
    private HandlerThread o = null;
    private Handler p = null;
    private String q = "";
    private boolean r = true;

    static /* synthetic */ boolean b(c cVar) {
        AppMethodBeat.i(221777);
        boolean o2 = cVar.o();
        AppMethodBeat.o(221777);
        return o2;
    }

    public c(Context context, g gVar, m mVar, boolean z) {
        AppMethodBeat.i(221757);
        try {
            this.f648f = (g) gVar.clone();
        } catch (CloneNotSupportedException e2) {
            this.f648f = new g();
        }
        this.f644b = context;
        this.f650h = mVar;
        this.f650h.setSurfaceTextureListener(this);
        this.f648f.W = z;
        this.f645c.b(this.f648f.U);
        AppMethodBeat.o(221757);
    }

    @Override // com.tencent.liteav.k
    public void a() {
        boolean z = true;
        AppMethodBeat.i(16173);
        Monitor.a(2, String.format("VideoCapture[%d]: start camera", Integer.valueOf(hashCode())), "", 0);
        TXCLog.i("CameraCapture", "start->enter with getSurfaceTexture:" + this.f650h.getSurfaceTexture());
        m mVar = this.f650h;
        int i2 = this.f648f.f784h;
        if (this.f648f.W) {
            z = false;
        }
        mVar.a(i2, z);
        c(this.f650h.getSurfaceTexture());
        AppMethodBeat.o(16173);
    }

    @Override // com.tencent.liteav.k
    public void a(boolean z) {
        AppMethodBeat.i(16113);
        Monitor.a(2, String.format("VideoCapture[%d]: stop camera", Integer.valueOf(hashCode())), "", 0);
        c();
        this.f650h.a();
        synchronized (this.n) {
            try {
                if (this.p != null) {
                    this.p.removeCallbacksAndMessages(null);
                }
                if (this.o != null) {
                    TXCLog.w("CameraCapture", "stop camera monitor ");
                    this.o.quit();
                    this.o = null;
                    this.p = null;
                }
            } finally {
                AppMethodBeat.o(16113);
            }
        }
    }

    @Override // com.tencent.liteav.k
    public void a(String str) {
        AppMethodBeat.i(16137);
        this.q = str;
        AppMethodBeat.o(16137);
    }

    @Override // com.tencent.liteav.k
    public void b() {
        AppMethodBeat.i(221758);
        TXCLog.i("CameraCapture", "startCapture->enter with getSurfaceTexture:" + this.f650h.getSurfaceTexture());
        c(this.f650h.getSurfaceTexture());
        AppMethodBeat.o(221758);
    }

    @Override // com.tencent.liteav.k
    public void c() {
        AppMethodBeat.i(221759);
        TXCLog.i("CameraCapture", "stopCapture->enter with null");
        this.f645c.a((com.tencent.liteav.capturer.b) null);
        this.f645c.g();
        this.f647e = false;
        AppMethodBeat.o(221759);
    }

    @Override // com.tencent.liteav.k
    public void b(boolean z) {
        boolean z2;
        AppMethodBeat.i(16122);
        if (this.f647e && this.f645c != null) {
            g gVar = this.f648f;
            if (z) {
                z2 = !this.f648f.m;
            } else {
                z2 = this.f648f.m;
            }
            gVar.m = z2;
            this.f645c.g();
            this.f650h.a(false);
            this.f645c.a(this.f648f.f784h);
            this.f645c.c(this.f648f.l);
            this.f645c.a(n());
            this.f645c.a(this.f648f.W, this.f648f.f777a, this.f648f.f778b);
            this.f645c.a(this);
            this.f645c.a(this.f650h.getSurfaceTexture());
            TXCLog.i("CameraCapture", String.format("vsize refreshCapture w*h:%d*%d orientation:%d", Integer.valueOf(this.f648f.f777a), Integer.valueOf(this.f648f.f778b), Integer.valueOf(this.f648f.l)));
            if (this.f645c.d(this.f648f.m) == 0) {
                this.f647e = true;
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(hashCode());
                objArr[1] = this.f648f.m ? "front" : "back";
                Monitor.a(2, String.format("VideoCapture[%d]: start %s camera successfully", objArr), "", 0);
                a(1003, "Enabled camera successfully");
            } else {
                this.f647e = false;
                a(-1301, "Failed to open the camera, please confirm whether the camera permission is turned on");
            }
            this.f651i = false;
        }
        AppMethodBeat.o(16122);
    }

    @Override // com.tencent.liteav.k
    public boolean d() {
        return this.f647e;
    }

    @Override // com.tencent.liteav.k
    public int e() {
        AppMethodBeat.i(16109);
        int f2 = this.f645c.f();
        AppMethodBeat.o(16109);
        return f2;
    }

    @Override // com.tencent.liteav.k
    public boolean a(int i2) {
        AppMethodBeat.i(221760);
        boolean b2 = this.f645c.b(i2);
        AppMethodBeat.o(221760);
        return b2;
    }

    @Override // com.tencent.liteav.k
    public void a(int i2, int i3) {
        AppMethodBeat.i(16126);
        this.f645c.a((float) i2, (float) i3);
        AppMethodBeat.o(16126);
    }

    @Override // com.tencent.liteav.k
    public void a(float f2) {
        AppMethodBeat.i(16142);
        this.f645c.a(f2);
        AppMethodBeat.o(16142);
    }

    @Override // com.tencent.liteav.k
    public void b(int i2) {
        AppMethodBeat.i(16107);
        this.f649g = i2;
        AppMethodBeat.o(16107);
    }

    @Override // com.tencent.liteav.k
    public void c(int i2) {
        AppMethodBeat.i(16108);
        if (this.f650h != null) {
            this.f650h.setRendMode(i2);
        }
        AppMethodBeat.o(16108);
    }

    @Override // com.tencent.liteav.k
    public void d(int i2) {
        AppMethodBeat.i(16117);
        if (this.f650h != null) {
            this.f650h.setRendMirror(i2);
        }
        AppMethodBeat.o(16117);
    }

    @Override // com.tencent.liteav.k
    public void a(l lVar) {
        AppMethodBeat.i(16105);
        this.f646d = lVar;
        AppMethodBeat.o(16105);
    }

    @Override // com.tencent.liteav.k
    public void c(final boolean z) {
        AppMethodBeat.i(182264);
        a(new Runnable() {
            /* class com.tencent.liteav.c.AnonymousClass1 */

            public void run() {
                AppMethodBeat.i(16669);
                c.this.f648f.S = z;
                AppMethodBeat.o(16669);
            }
        });
        AppMethodBeat.o(182264);
    }

    @Override // com.tencent.liteav.k
    public boolean d(boolean z) {
        AppMethodBeat.i(16132);
        boolean a2 = this.f645c.a(z);
        AppMethodBeat.o(16132);
        return a2;
    }

    @Override // com.tencent.liteav.k
    public void a(com.tencent.liteav.basic.structs.b bVar) {
        AppMethodBeat.i(221761);
        if (this.f650h != null) {
            this.f650h.a(bVar.f428a, bVar.f436i, this.f649g, bVar.f432e, bVar.f433f, this.f645c.i());
        }
        AppMethodBeat.o(221761);
    }

    @Override // com.tencent.liteav.k
    public void a(Runnable runnable) {
        AppMethodBeat.i(221762);
        this.f650h.a(runnable);
        AppMethodBeat.o(221762);
    }

    @Override // com.tencent.liteav.k
    public EGLContext f() {
        AppMethodBeat.i(221763);
        EGLContext gLContext = this.f650h.getGLContext();
        AppMethodBeat.o(221763);
        return gLContext;
    }

    @Override // com.tencent.liteav.basic.b.b
    public void onNotifyEvent(int i2, Bundle bundle) {
        AppMethodBeat.i(16170);
        f.a(this.f643a, i2, bundle);
        AppMethodBeat.o(16170);
    }

    @Override // com.tencent.liteav.k
    public void a(b bVar) {
        AppMethodBeat.i(221764);
        this.f643a = new WeakReference<>(bVar);
        AppMethodBeat.o(221764);
    }

    @Override // com.tencent.liteav.k
    public void e(int i2) {
        AppMethodBeat.i(16119);
        this.f648f.l = i2;
        this.f645c.c(this.f648f.l);
        this.r = true;
        TXCLog.i("CameraCapture", String.format("vsize setCaptureOrientation w*h:%d*%d orientation:%d", Integer.valueOf(this.f648f.f777a), Integer.valueOf(this.f648f.f778b), Integer.valueOf(this.f648f.l)));
        AppMethodBeat.o(16119);
    }

    @Override // com.tencent.liteav.k
    public void a(com.tencent.liteav.basic.a.c cVar) {
        this.f648f.k = cVar;
        this.r = true;
    }

    @Override // com.tencent.liteav.k
    public void b(int i2, int i3) {
        AppMethodBeat.i(16153);
        this.f648f.f777a = i2;
        this.f648f.f778b = i3;
        this.r = true;
        TXCLog.i("CameraCapture", String.format("vsize setVideoEncSize w*h:%d*%d orientation:%d", Integer.valueOf(this.f648f.f777a), Integer.valueOf(this.f648f.f778b), Integer.valueOf(this.f648f.l)));
        AppMethodBeat.o(16153);
    }

    @Override // com.tencent.liteav.k
    public void f(int i2) {
        AppMethodBeat.i(16124);
        this.f648f.f784h = i2;
        if (this.f645c != null) {
            this.f645c.a(i2);
        }
        if (this.f650h != null && (this.f650h instanceof TXCGLSurfaceView)) {
            ((TXCGLSurfaceView) this.f650h).setFPS(i2);
        }
        AppMethodBeat.o(16124);
    }

    @Override // com.tencent.liteav.k
    public void a(float f2, float f3) {
        AppMethodBeat.i(16196);
        if (this.f645c != null && this.f648f.K) {
            this.f645c.a(f2, f3);
        }
        AppMethodBeat.o(16196);
    }

    @Override // com.tencent.liteav.k
    public int g() {
        return this.f648f.f784h;
    }

    @Override // com.tencent.liteav.k
    public boolean h() {
        AppMethodBeat.i(221765);
        if (this.f645c != null) {
            boolean b2 = this.f645c.b();
            AppMethodBeat.o(221765);
            return b2;
        }
        AppMethodBeat.o(221765);
        return false;
    }

    @Override // com.tencent.liteav.k
    public boolean i() {
        AppMethodBeat.i(221766);
        if (this.f645c != null) {
            boolean c2 = this.f645c.c();
            AppMethodBeat.o(221766);
            return c2;
        }
        AppMethodBeat.o(221766);
        return false;
    }

    @Override // com.tencent.liteav.k
    public boolean j() {
        AppMethodBeat.i(221767);
        if (this.f645c != null) {
            boolean d2 = this.f645c.d();
            AppMethodBeat.o(221767);
            return d2;
        }
        AppMethodBeat.o(221767);
        return false;
    }

    @Override // com.tencent.liteav.k
    public boolean k() {
        AppMethodBeat.i(221768);
        if (this.f645c != null) {
            boolean e2 = this.f645c.e();
            AppMethodBeat.o(221768);
            return e2;
        }
        AppMethodBeat.o(221768);
        return false;
    }

    @Override // com.tencent.liteav.k
    public boolean l() {
        AppMethodBeat.i(221769);
        if (this.f645c != null) {
            boolean i2 = this.f645c.i();
            AppMethodBeat.o(221769);
            return i2;
        }
        AppMethodBeat.o(221769);
        return false;
    }

    private void c(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(221770);
        if (!(surfaceTexture == null || this.f647e || this.f645c == null)) {
            this.f645c.a(this);
            this.f645c.a(surfaceTexture);
            this.f645c.a(this.f648f.f784h);
            this.f645c.c(this.f648f.l);
            this.f645c.c(this.f648f.K);
            this.f645c.a(n());
            this.f645c.a(this.f648f.W, this.f648f.f777a, this.f648f.f778b);
            TXCLog.i("CameraCapture", String.format("vsize startCapture w*h:%d*%d orientation:%d", Integer.valueOf(this.f648f.f777a), Integer.valueOf(this.f648f.f778b), Integer.valueOf(this.f648f.l)));
            if (this.f645c.d(this.f648f.m) == 0) {
                this.f647e = true;
                this.k = System.currentTimeMillis();
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(hashCode());
                objArr[1] = this.f648f.m ? "front" : "back";
                Monitor.a(2, String.format("VideoCapture[%d]: start %s camera successfully", objArr), "", 0);
                a(1003, "Enabled camera successfully");
                this.f651i = false;
                AppMethodBeat.o(221770);
                return;
            }
            this.f647e = false;
            a(-1301, "Failed to open camera, please confirm whether the camera permission is turned on");
        }
        AppMethodBeat.o(221770);
    }

    private void a(int i2, String str) {
        AppMethodBeat.i(16158);
        f.a(this.f643a, i2, str);
        AppMethodBeat.o(16158);
    }

    @Override // com.tencent.liteav.basic.c.n
    public void a(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(16174);
        TXCLog.i("CameraCapture", "onSurfaceTextureAvailable->enter with mListener:" + this.f646d);
        c(surfaceTexture);
        if (this.f646d != null) {
            this.f646d.a(surfaceTexture);
        }
        AppMethodBeat.o(16174);
    }

    @Override // com.tencent.liteav.basic.c.n
    public void b(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(221771);
        c();
        TXCLog.i("CameraCapture", "onSurfaceTextureDestroy->enter with mListener:" + this.f646d);
        if (this.f646d != null) {
            this.f646d.s();
        }
        AppMethodBeat.o(221771);
    }

    @Override // com.tencent.liteav.basic.c.n
    public int a(int i2, float[] fArr) {
        AppMethodBeat.i(221772);
        a(i2, null, fArr, 4);
        AppMethodBeat.o(221772);
        return 0;
    }

    @Override // com.tencent.liteav.basic.c.n
    public void a(byte[] bArr, float[] fArr) {
        AppMethodBeat.i(221773);
        a(-1, bArr, fArr, 3);
        AppMethodBeat.o(221773);
    }

    private void a(int i2, byte[] bArr, float[] fArr, int i3) {
        AppMethodBeat.i(221774);
        if (!this.f647e) {
            AppMethodBeat.o(221774);
            return;
        }
        if (!this.f651i) {
            Monitor.a(2, String.format("VideoCapture[%d]: capture first frame", Integer.valueOf(hashCode())), "", 0);
            f.a(this.f643a, 1007, "First frame capture completed");
            this.f651i = true;
            this.r = true;
            TXCLog.i("CameraCapture", "trtc_render: render first frame");
        }
        com.tencent.liteav.basic.structs.b bVar = new com.tencent.liteav.basic.structs.b();
        bVar.f432e = this.f645c.j();
        bVar.f433f = this.f645c.k();
        bVar.f434g = this.f648f.f777a;
        bVar.f435h = this.f648f.f778b;
        bVar.f437j = this.f645c.h();
        bVar.f436i = this.f645c.i() ? !this.f648f.S : this.f648f.S;
        bVar.f428a = i2;
        bVar.f430c = fArr;
        bVar.f431d = this.f648f.W;
        bVar.m = bArr;
        bVar.f429b = i3;
        if (bVar.f437j == 0 || bVar.f437j == 180) {
            bVar.f434g = this.f648f.f778b;
            bVar.f435h = this.f648f.f777a;
        } else {
            bVar.f434g = this.f648f.f777a;
            bVar.f435h = this.f648f.f778b;
        }
        bVar.l = f.a(bVar.f432e, bVar.f433f, this.f648f.f778b, this.f648f.f777a);
        if (this.f646d != null) {
            this.f646d.b(bVar);
        }
        if (this.r) {
            this.r = false;
            TXCLog.i("CameraCapture", String.format("vsize onCaptureFrame w*h:%d*%d angle:%d", Integer.valueOf(bVar.f434g), Integer.valueOf(bVar.f435h), Integer.valueOf(bVar.f437j)));
        }
        this.f652j++;
        long currentTimeMillis = System.currentTimeMillis() - this.k;
        if (currentTimeMillis >= 1000) {
            TXCStatus.a(this.q, 1001, this.m, Double.valueOf((((double) (this.f652j - this.l)) * 1000.0d) / ((double) currentTimeMillis)));
            this.l = this.f652j;
            this.k = currentTimeMillis + this.k;
        }
        AppMethodBeat.o(221774);
    }

    private a.EnumC0158a n() {
        AppMethodBeat.i(221775);
        if (this.f648f.T) {
            a.EnumC0158a aVar = a.EnumC0158a.RESOLUTION_HIGHEST;
            AppMethodBeat.o(221775);
            return aVar;
        }
        switch (this.f648f.k) {
            case RESOLUTION_TYPE_INVALID:
                a.EnumC0158a aVar2 = a.EnumC0158a.RESOLUTION_INVALID;
                AppMethodBeat.o(221775);
                return aVar2;
            case RESOLUTION_TYPE_360_640:
                a.EnumC0158a aVar3 = a.EnumC0158a.RESOLUTION_360_640;
                AppMethodBeat.o(221775);
                return aVar3;
            case RESOLUTION_TYPE_540_960:
                a.EnumC0158a aVar4 = a.EnumC0158a.RESOLUTION_540_960;
                AppMethodBeat.o(221775);
                return aVar4;
            case RESOLUTION_TYPE_1080_1920:
                a.EnumC0158a aVar5 = a.EnumC0158a.RESOLUTION_1080_1920;
                AppMethodBeat.o(221775);
                return aVar5;
            case RESOLUTION_TYPE_320_480:
                a.EnumC0158a aVar6 = a.EnumC0158a.RESOLUTION_320_480;
                AppMethodBeat.o(221775);
                return aVar6;
            default:
                a.EnumC0158a aVar7 = a.EnumC0158a.RESOLUTION_720_1280;
                AppMethodBeat.o(221775);
                return aVar7;
        }
    }

    @Override // com.tencent.liteav.capturer.b
    public void a(byte[] bArr) {
        AppMethodBeat.i(221776);
        if (this.f650h != null) {
            this.f650h.a(bArr);
        }
        AppMethodBeat.o(221776);
    }

    @Override // com.tencent.liteav.capturer.b
    public void m() {
        AppMethodBeat.i(16129);
        if (this.f645c.l() != null) {
            this.f645c.g();
        }
        synchronized (this.n) {
            try {
                if (this.o == null) {
                    this.o = new HandlerThread("cameraMonitorThread");
                    this.o.start();
                    this.p = new Handler(this.o.getLooper());
                    TXCLog.w("CameraCapture", "start camera monitor ");
                }
                if (this.p != null) {
                    this.p.postDelayed(new Runnable() {
                        /* class com.tencent.liteav.c.AnonymousClass2 */

                        public void run() {
                            AppMethodBeat.i(15501);
                            try {
                                if (!c.this.d() || !c.b(c.this) || c.this.f645c.l() != null) {
                                    if (c.this.p != null) {
                                        c.this.p.postDelayed(this, 2000);
                                    }
                                    AppMethodBeat.o(15501);
                                    return;
                                }
                                TXCLog.w("CameraCapture", "camera monitor restart capture");
                                c.this.f645c.g();
                                c.this.f650h.a(false);
                                c.this.f645c.a(c.this.f648f.f784h);
                                c.this.f645c.a(c.this.f648f.W, c.this.f648f.f777a, c.this.f648f.f778b);
                                c.this.f645c.a(c.this.f650h.getSurfaceTexture());
                                c.this.f645c.d(c.this.f648f.m);
                                AppMethodBeat.o(15501);
                            } catch (Exception e2) {
                                TXCLog.w("CameraCapture", "camera monitor exception ");
                                AppMethodBeat.o(15501);
                            }
                        }
                    }, 2000);
                }
            } finally {
                AppMethodBeat.o(16129);
            }
        }
    }

    @Override // com.tencent.liteav.k
    public void g(int i2) {
        AppMethodBeat.i(16130);
        this.m = i2;
        AppMethodBeat.o(16130);
    }

    @Override // com.tencent.liteav.k
    public void e(boolean z) {
        AppMethodBeat.i(16138);
        this.f648f.U = z;
        this.f645c.b(z);
        this.r = true;
        AppMethodBeat.o(16138);
    }

    private boolean o() {
        AppMethodBeat.i(16148);
        try {
            if (this.f644b != null) {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.f644b.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getRunningAppProcesses();
                if (runningAppProcesses == null) {
                    TXCLog.w("CameraCapture", "List of RunningAppProcessInfo is null");
                    AppMethodBeat.o(16148);
                    return false;
                }
                for (int i2 = 0; i2 < runningAppProcesses.size(); i2++) {
                    ActivityManager.RunningAppProcessInfo runningAppProcessInfo = runningAppProcesses.get(i2);
                    if (runningAppProcessInfo == null) {
                        TXCLog.w("CameraCapture", "ActivityManager.RunningAppProcessInfo is null");
                    } else if (runningAppProcessInfo.processName.equals(this.f644b.getPackageName()) && runningAppProcessInfo.importance == 100) {
                        AppMethodBeat.o(16148);
                        return true;
                    }
                }
            }
        } catch (Exception e2) {
        }
        AppMethodBeat.o(16148);
        return false;
    }
}
