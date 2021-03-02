package com.tencent.liteav.videoencoder;

import android.opengl.GLES20;
import android.os.Bundle;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.liteav.basic.d.c;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.f;
import com.tencent.liteav.basic.util.g;
import com.tencent.liteav.beauty.b.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveConstants;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
import javax.microedition.khronos.egl.EGLContext;

public class b extends com.tencent.liteav.basic.module.a {
    private static Integer r = 1;
    private static final String u = b.class.getSimpleName();
    private static int v = 0;

    /* renamed from: a  reason: collision with root package name */
    private d f1265a = null;

    /* renamed from: b  reason: collision with root package name */
    private e f1266b = null;

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<com.tencent.liteav.basic.b.b> f1267c = null;

    /* renamed from: d  reason: collision with root package name */
    private int f1268d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f1269e = 2;

    /* renamed from: f  reason: collision with root package name */
    private a f1270f = a.HW_ENCODER_264;

    /* renamed from: g  reason: collision with root package name */
    private Timer f1271g = null;

    /* renamed from: h  reason: collision with root package name */
    private TimerTask f1272h = null;

    /* renamed from: i  reason: collision with root package name */
    private LinkedList<Runnable> f1273i = new LinkedList<>();

    /* renamed from: j  reason: collision with root package name */
    private TXSVideoEncoderParam f1274j;
    private float k = 0.0f;
    private float l = 0.0f;
    private float m = 0.0f;
    private int n = 0;
    private int o = 0;
    private com.tencent.liteav.basic.c.b p;
    private g q;
    private boolean s;
    private k t;

    public enum a {
        HW_ENCODER_264(1),
        SOFT_ENCODER_264(2),
        HW_ENCODER_HEVC(3),
        SOFT_ENCODER_HEVC(4);
        
        private final int value;

        public static a valueOf(String str) {
            AppMethodBeat.i(259843);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(259843);
            return aVar;
        }

        static {
            AppMethodBeat.i(259844);
            AppMethodBeat.o(259844);
        }

        private a(int i2) {
            this.value = i2;
        }

        public final int a() {
            return this.value;
        }
    }

    static /* synthetic */ void a(b bVar, int i2, String str) {
        AppMethodBeat.i(14815);
        bVar.a(i2, str);
        AppMethodBeat.o(14815);
    }

    static /* synthetic */ int k(b bVar) {
        int i2 = bVar.n + 1;
        bVar.n = i2;
        return i2;
    }

    static /* synthetic */ void o(b bVar) {
        AppMethodBeat.i(14816);
        bVar.i();
        AppMethodBeat.o(14816);
    }

    static /* synthetic */ void p(b bVar) {
        AppMethodBeat.i(14817);
        bVar.h();
        AppMethodBeat.o(14817);
    }

    static {
        AppMethodBeat.i(14818);
        AppMethodBeat.o(14818);
    }

    public b(int i2) {
        AppMethodBeat.i(14790);
        this.f1269e = i2;
        AppMethodBeat.o(14790);
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x0171  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a(com.tencent.liteav.videoencoder.TXSVideoEncoderParam r15) {
        /*
        // Method dump skipped, instructions count: 395
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoencoder.b.a(com.tencent.liteav.videoencoder.TXSVideoEncoderParam):int");
    }

    @Override // com.tencent.liteav.basic.module.a
    public void setID(String str) {
        AppMethodBeat.i(14792);
        super.setID(str);
        if (this.f1265a != null) {
            this.f1265a.setID(str);
        }
        setStatusValue(WearableStatusCodes.UNKNOWN_CAPABILITY, Long.valueOf((long) this.f1270f.a()));
        AppMethodBeat.o(14792);
    }

    public EGLContext a(final int i2, final int i3) {
        AppMethodBeat.i(14793);
        if (!this.s) {
            this.s = true;
            synchronized (r) {
                try {
                    StringBuilder sb = new StringBuilder("CVGLThread");
                    Integer num = r;
                    r = Integer.valueOf(r.intValue() + 1);
                    this.q = new g(sb.append(num).toString());
                } catch (Throwable th) {
                    AppMethodBeat.o(14793);
                    throw th;
                }
            }
            final boolean[] zArr = new boolean[1];
            this.q.a(new Runnable() {
                /* class com.tencent.liteav.videoencoder.b.AnonymousClass1 */

                public void run() {
                    boolean z;
                    AppMethodBeat.i(14899);
                    b.this.p = com.tencent.liteav.basic.c.b.a(null, null, null, i2, i3);
                    boolean[] zArr = zArr;
                    if (b.this.p != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    zArr[0] = z;
                    AppMethodBeat.o(14899);
                }
            });
            if (zArr[0]) {
                EGLContext d2 = this.p.d();
                AppMethodBeat.o(14793);
                return d2;
            }
            AppMethodBeat.o(14793);
            return null;
        } else if (this.p != null) {
            EGLContext d3 = this.p.d();
            AppMethodBeat.o(14793);
            return d3;
        } else {
            AppMethodBeat.o(14793);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void a(Runnable runnable) {
        AppMethodBeat.i(14794);
        synchronized (this.f1273i) {
            try {
                this.f1273i.add(runnable);
            } finally {
                AppMethodBeat.o(14794);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(14795);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
        r0.run();
        com.tencent.matrix.trace.core.AppMethodBeat.o(14795);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        if (r0 != null) goto L_0x0027;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(java.util.Queue<java.lang.Runnable> r4) {
        /*
            r3 = this;
            r1 = 0
            r2 = 14795(0x39cb, float:2.0732E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            monitor-enter(r4)
            boolean r0 = r4.isEmpty()     // Catch:{ all -> 0x0021 }
            if (r0 == 0) goto L_0x0013
            monitor-exit(r4)     // Catch:{ all -> 0x0021 }
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            r0 = r1
        L_0x0012:
            return r0
        L_0x0013:
            java.lang.Object r0 = r4.poll()
            java.lang.Runnable r0 = (java.lang.Runnable) r0
            monitor-exit(r4)
            if (r0 != 0) goto L_0x0027
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            r0 = r1
            goto L_0x0012
        L_0x0021:
            r0 = move-exception
            monitor-exit(r4)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            throw r0
        L_0x0027:
            r0.run()
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0012
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoencoder.b.a(java.util.Queue):boolean");
    }

    public long a(final byte[] bArr, final int i2, final int i3, final int i4, final long j2) {
        AppMethodBeat.i(14796);
        if (this.p == null) {
            AppMethodBeat.o(14796);
            return -1;
        }
        this.q.b(new Runnable() {
            /* class com.tencent.liteav.videoencoder.b.AnonymousClass2 */

            public void run() {
                AppMethodBeat.i(14782);
                if (!(b.this.t != null && b.this.t.n() == i3 && b.this.t.o() == i4)) {
                    if (b.this.t != null) {
                        b.this.t.d();
                        b.this.t = null;
                    }
                    b.this.t = new k(i2);
                    if (!b.this.t.a()) {
                        if (b.this.p != null) {
                            b.this.p.c();
                            b.this.p = null;
                        }
                        b.this.t = null;
                        AppMethodBeat.o(14782);
                        return;
                    }
                    b.this.t.a(true);
                    b.this.t.a(i3, i4);
                }
                b.this.t.a(bArr);
                GLES20.glViewport(0, 0, i3, i4);
                int q = b.this.t.q();
                GLES20.glFlush();
                b.this.a(q, i3, i4, j2);
                AppMethodBeat.o(14782);
            }
        });
        AppMethodBeat.o(14796);
        return 0;
    }

    public void a() {
        AppMethodBeat.i(14797);
        if (this.q != null) {
            final com.tencent.liteav.basic.c.b bVar = this.p;
            this.q.b(new Runnable() {
                /* class com.tencent.liteav.videoencoder.b.AnonymousClass3 */

                public void run() {
                    AppMethodBeat.i(14856);
                    b.this.f1273i.clear();
                    if (b.this.f1265a != null) {
                        b.this.f1265a.stop();
                    }
                    if (b.this.t != null) {
                        b.this.t.d();
                        b.this.t = null;
                    }
                    if (bVar != null) {
                        bVar.c();
                    }
                    AppMethodBeat.o(14856);
                }
            });
            this.q = null;
            this.p = null;
        } else {
            this.f1273i.clear();
            if (this.f1265a != null) {
                this.f1265a.stop();
            }
        }
        if (this.f1269e == 3) {
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 0.0f;
            this.n = 0;
            h();
        }
        this.f1266b = null;
        this.f1268d = 0;
        AppMethodBeat.o(14797);
    }

    public void a(int i2) {
        AppMethodBeat.i(14798);
        if (this.f1265a != null) {
            this.f1265a.setRotation(i2);
        }
        AppMethodBeat.o(14798);
    }

    public void a(boolean z) {
        AppMethodBeat.i(221371);
        if (this.f1265a != null) {
            this.f1265a.setXMirror(z);
        }
        AppMethodBeat.o(221371);
    }

    public long a(int i2, int i3, int i4, long j2) {
        AppMethodBeat.i(14799);
        long j3 = 10000002;
        do {
        } while (a(this.f1273i));
        if (this.f1265a != null) {
            setStatusValue(4002, Long.valueOf(d()));
            setStatusValue(4001, this.f1274j.streamType, Double.valueOf(c()));
            if (this.f1270f == a.HW_ENCODER_264 || this.f1270f == a.HW_ENCODER_HEVC) {
                setStatusValue(TXLiteAVCode.EVT_ROOM_CONNECT_SUCC, this.f1274j.streamType, Integer.valueOf(e()));
            }
            j3 = this.f1265a.pushVideoFrame(i2, i3, i4, j2);
        }
        AppMethodBeat.o(14799);
        return j3;
    }

    public boolean b(int i2) {
        AppMethodBeat.i(14800);
        if (this.f1265a != null) {
            this.f1265a.setFPS(i2);
            AppMethodBeat.o(14800);
            return true;
        }
        AppMethodBeat.o(14800);
        return false;
    }

    public void b() {
        AppMethodBeat.i(221372);
        if (this.f1265a != null) {
            this.f1265a.restartIDR();
        }
        AppMethodBeat.o(221372);
    }

    public void a(com.tencent.liteav.basic.b.b bVar) {
        AppMethodBeat.i(221373);
        this.f1267c = new WeakReference<>(bVar);
        AppMethodBeat.o(221373);
    }

    public void a(e eVar) {
        AppMethodBeat.i(259849);
        this.f1266b = eVar;
        a(new Runnable() {
            /* class com.tencent.liteav.videoencoder.b.AnonymousClass4 */

            public void run() {
                AppMethodBeat.i(14819);
                if (b.this.f1265a != null) {
                    b.this.f1265a.setListener(b.this.f1266b);
                }
                AppMethodBeat.o(14819);
            }
        });
        AppMethodBeat.o(259849);
    }

    public void c(int i2) {
        AppMethodBeat.i(14803);
        this.f1268d = i2;
        a(new Runnable() {
            /* class com.tencent.liteav.videoencoder.b.AnonymousClass5 */

            public void run() {
                AppMethodBeat.i(14786);
                if (b.this.f1265a != null) {
                    b.this.f1265a.setBitrate(b.this.f1268d);
                }
                AppMethodBeat.o(14786);
            }
        });
        AppMethodBeat.o(14803);
    }

    public boolean b(int i2, int i3) {
        AppMethodBeat.i(14804);
        if (this.f1265a != null) {
            this.f1268d = i2;
            this.f1265a.setBitrateFromQos(i2, i3);
            AppMethodBeat.o(14804);
            return true;
        }
        AppMethodBeat.o(14804);
        return false;
    }

    public boolean d(int i2) {
        AppMethodBeat.i(14805);
        if (this.f1265a != null) {
            this.f1265a.setEncodeIdrFpsFromQos(i2);
            AppMethodBeat.o(14805);
            return true;
        }
        AppMethodBeat.o(14805);
        return false;
    }

    public void e(final int i2) {
        AppMethodBeat.i(14806);
        a(new Runnable() {
            /* class com.tencent.liteav.videoencoder.b.AnonymousClass6 */

            public void run() {
                AppMethodBeat.i(14783);
                if (b.this.f1265a != null) {
                    b.this.f1265a.enableNearestRPS(i2);
                }
                AppMethodBeat.o(14783);
            }
        });
        AppMethodBeat.o(14806);
    }

    public double c() {
        AppMethodBeat.i(221374);
        double d2 = 0.0d;
        if (this.f1265a != null) {
            d2 = this.f1265a.getRealFPS();
        }
        AppMethodBeat.o(221374);
        return d2;
    }

    public long d() {
        AppMethodBeat.i(221375);
        long j2 = 0;
        if (this.f1265a != null) {
            j2 = this.f1265a.getRealBitrate();
        }
        AppMethodBeat.o(221375);
        return j2;
    }

    public int e() {
        AppMethodBeat.i(221376);
        int i2 = 0;
        if (this.f1265a != null) {
            i2 = this.f1265a.getEncodeCost();
        }
        AppMethodBeat.o(221376);
        return i2;
    }

    private void g() {
        AppMethodBeat.i(14814);
        if (this.f1272h == null) {
            this.f1272h = new C0161b(this);
        }
        this.f1271g = new Timer();
        this.f1271g.schedule(this.f1272h, 1000, 1000);
        AppMethodBeat.o(14814);
    }

    private void h() {
        AppMethodBeat.i(221377);
        if (this.f1271g != null) {
            this.f1271g.cancel();
            this.f1271g = null;
        }
        if (this.f1272h != null) {
            this.f1272h = null;
        }
        AppMethodBeat.o(221377);
    }

    private void a(int i2, String str) {
        AppMethodBeat.i(14812);
        if (this.f1267c == null) {
            AppMethodBeat.o(14812);
            return;
        }
        com.tencent.liteav.basic.b.b bVar = this.f1267c.get();
        if (bVar == null) {
            AppMethodBeat.o(14812);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("EVT_ID", i2);
        bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
        bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, str);
        bVar.onNotifyEvent(i2, bundle);
        AppMethodBeat.o(14812);
    }

    private void a(int i2, String str, int i3, int i4) {
        AppMethodBeat.i(259850);
        if (this.f1267c == null) {
            AppMethodBeat.o(259850);
            return;
        }
        com.tencent.liteav.basic.b.b bVar = this.f1267c.get();
        if (bVar == null) {
            AppMethodBeat.o(259850);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("EVT_ID", i2);
        bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
        bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, str);
        bundle.putInt("EVT_PARAM1", i3);
        bundle.putInt("EVT_STREAM_TYPE", i4);
        bVar.onNotifyEvent(i2, bundle);
        AppMethodBeat.o(259850);
    }

    private void i() {
        AppMethodBeat.i(259851);
        a(new Runnable() {
            /* class com.tencent.liteav.videoencoder.b.AnonymousClass7 */

            public void run() {
                AppMethodBeat.i(14821);
                b.a(b.this, 1107, "Switches from software encoding to hardware encoding");
                if (b.this.f1265a != null) {
                    b.this.f1265a.setListener(null);
                    b.this.f1265a.stop();
                }
                b.this.f1265a = new a();
                TXCLog.w("TXCVideoEncoder", "create hw encoder");
                b.this.f1270f = a.HW_ENCODER_264;
                if (b.this.f1274j.isHEVCEncoderEnabled) {
                    TXCLog.w(b.u, "can not switch from 265 sw to hw!");
                    b.this.f1274j.isHEVCEncoderEnabled = false;
                }
                b.this.setStatusValue(WearableStatusCodes.UNKNOWN_CAPABILITY, Long.valueOf((long) b.this.f1270f.a()));
                b.this.f1265a.start(b.this.f1274j);
                if (b.this.f1266b != null) {
                    b.this.f1265a.setListener(b.this.f1266b);
                }
                if (b.this.f1268d != 0) {
                    b.this.f1265a.setBitrate(b.this.f1268d);
                }
                b.this.f1265a.setID(b.this.getID());
                AppMethodBeat.o(14821);
            }
        });
        TXCLog.w("TXCVideoEncoder", "switchSWToHW");
        AppMethodBeat.o(259851);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.liteav.videoencoder.b$b  reason: collision with other inner class name */
    public static class C0161b extends TimerTask {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<b> f1297a;

        public C0161b(b bVar) {
            AppMethodBeat.i(259838);
            this.f1297a = new WeakReference<>(bVar);
            AppMethodBeat.o(259838);
        }

        public void run() {
            AppMethodBeat.i(259839);
            if (this.f1297a == null) {
                AppMethodBeat.o(259839);
                return;
            }
            b bVar = this.f1297a.get();
            if (bVar == null) {
                AppMethodBeat.o(259839);
            } else if (bVar.n < bVar.o) {
                int[] a2 = f.a();
                b.k(bVar);
                bVar.k += (float) (a2[0] / 10);
                bVar.l = ((float) (a2[1] / 10)) + bVar.l;
                bVar.m = (float) (((double) bVar.m) + ((bVar.c() * 100.0d) / ((double) bVar.f1274j.fps)));
                AppMethodBeat.o(259839);
            } else {
                if (c.a().a(bVar.k / ((float) bVar.o), bVar.l / ((float) bVar.o), bVar.m / ((float) bVar.o)) && c.a().d() != 0) {
                    String str = "VideoEncoder: Insufficient performance, switching software encoding to hardware encoding [appCPU:" + bVar.k + "][sysCPU:" + bVar.l + "][fps:" + bVar.m + "][checkCount:" + bVar.o + "]";
                    Monitor.a(2, str, "", 0);
                    TXCLog.i(b.u, str);
                    b.o(bVar);
                }
                b.p(bVar);
                AppMethodBeat.o(259839);
            }
        }
    }
}
