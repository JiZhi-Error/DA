package com.tencent.qbar;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.qbar.QbarNative;
import com.tencent.qbar.WxQbarNative;
import com.tencent.qbar.a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class h {
    private static h RKq = new h();
    private Object CCt = new Object();
    private Map CDO = new HashMap();
    private long CDU;
    private boolean CDW;
    public int CDX;
    private long CHf = 0;
    public boolean CJM = false;
    private int[] RKg = this.RKs;
    public com.tencent.mm.plugin.scanner.f.c RKr = new com.tencent.mm.plugin.scanner.f.b();
    private int[] RKs = {0};
    private c RKt;
    private long RKu = 1000;
    private Runnable RKv = null;
    private ScanDecodeFrameData RKw = null;
    private boolean RKx = false;
    private int RKy = 2;
    private int RKz = 0;
    private boolean aYc = false;
    public g lQo = new g("MicroMsg.WxScanDecodeQueue");

    public interface c {
        void a(long j2, List<a.C2180a> list, List<QbarNative.QBarPoint> list2, List<WxQbarNative.QBarReportMsg> list3, Bundle bundle);

        void aj(long j2, long j3);

        void b(long j2, Bundle bundle);
    }

    public h() {
        AppMethodBeat.i(91175);
        AppMethodBeat.o(91175);
    }

    static /* synthetic */ int h(h hVar) {
        int i2 = hVar.CDX;
        hVar.CDX = i2 + 1;
        return i2;
    }

    static /* synthetic */ int j(h hVar) {
        int i2 = hVar.RKz;
        hVar.RKz = i2 + 1;
        return i2;
    }

    static {
        AppMethodBeat.i(91183);
        AppMethodBeat.o(91183);
    }

    public static h hkp() {
        return RKq;
    }

    public final void init(Context context) {
        boolean z;
        AppMethodBeat.i(91176);
        synchronized (this.lQo) {
            try {
                if (!this.lQo.hasInited()) {
                    this.lQo.a(0, com.tencent.scanlib.a.lb(context));
                    if (this.lQo.hasInited()) {
                        this.lQo.hko();
                        this.lQo.T(this.RKg);
                    }
                }
            } catch (Throwable th) {
                AppMethodBeat.o(91176);
                throw th;
            }
        }
        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_scan_code_multi_code_show_success_image_when_zooming, 0);
        if (a2 != 0 || BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG) {
            z = true;
        } else {
            z = false;
        }
        this.RKx = z;
        this.RKu = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_scan_code_zoom_duration, 1000L);
        this.RKy = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_scan_code_multi_code_zoom_ignore_frame_num, 2);
        Log.i("MicroMsg.WxScanDecodeQueue", "alvinluo initScanDecodeQueue configValue: %d, needShowSuccessFrameWhenZoom: %b, zoomDuration: %d, ignoreFrameNum: %d", Integer.valueOf(a2), Boolean.valueOf(this.RKx), Long.valueOf(this.RKu), Integer.valueOf(this.RKy));
        AppMethodBeat.o(91176);
    }

    public final void S(int[] iArr) {
        AppMethodBeat.i(91177);
        if (iArr == null || iArr.length <= 0) {
            AppMethodBeat.o(91177);
            return;
        }
        synchronized (this.lQo) {
            try {
                this.RKg = iArr;
                if (this.lQo.hasInited()) {
                    this.lQo.T(this.RKg);
                }
            } finally {
                AppMethodBeat.o(91177);
            }
        }
    }

    public final void a(long j2, c cVar) {
        AppMethodBeat.i(91178);
        synchronized (this.CCt) {
            try {
                c.RJE.reset();
                c.RJE.CHf = System.currentTimeMillis();
                c.RJE.aqw(c.RJy);
                c.RJE.setTabType(c.RJB);
                this.CDU = j2;
                this.RKt = cVar;
                this.CDX = 0;
                this.CHf = System.currentTimeMillis();
            } finally {
                AppMethodBeat.o(91178);
            }
        }
        synchronized (this.lQo) {
            try {
                if (this.lQo.hasInited()) {
                    this.lQo.reset(false);
                }
            } finally {
                AppMethodBeat.o(91178);
            }
        }
    }

    public final void a(byte[] bArr, Point point, int i2, Rect rect) {
        AppMethodBeat.i(91179);
        synchronized (this.CCt) {
            try {
                Log.d("MicroMsg.WxScanDecodeQueue", "%d submit crop gray", Long.valueOf(this.CDU));
                if (this.CDU != 0) {
                    ThreadPool.post(new a(this.CDU, bArr, point, i2, rect), "WxScanDecodeQueue_Crop_Gray");
                }
                if (this.aYc && this.RKx) {
                    this.RKw = new ScanDecodeFrameData(bArr, point.x, point.y, i2);
                }
            } finally {
                AppMethodBeat.o(91179);
            }
        }
    }

    public final void Iv(long j2) {
        AppMethodBeat.i(91180);
        synchronized (this.CCt) {
            try {
                if (this.CDU == j2) {
                    this.CDU = 0;
                    this.CDX = 0;
                    this.RKt = null;
                    this.CDO.clear();
                    this.aYc = false;
                    this.CHf = 0;
                }
            } catch (Throwable th) {
                AppMethodBeat.o(91180);
                throw th;
            }
        }
        hkq();
        AppMethodBeat.o(91180);
    }

    public final void release() {
        AppMethodBeat.i(91181);
        Log.i("MicroMsg.WxScanDecodeQueue", "release QBar");
        this.RKg = this.RKs;
        Iv(this.CDU);
        synchronized (this.lQo) {
            try {
                this.lQo.release();
            } catch (Throwable th) {
                AppMethodBeat.o(91181);
                throw th;
            }
        }
        c.RJE.RJT = 1.0f;
        hkq();
        AppMethodBeat.o(91181);
    }

    /* access modifiers changed from: package-private */
    public class a implements Runnable {
        private byte[] CDY;
        private Point CDZ;
        private long dDZ;
        private Rect iiw;
        private int sRI;

        a(long j2, byte[] bArr, Point point, int i2, Rect rect) {
            this.dDZ = j2;
            this.CDY = bArr;
            this.CDZ = point;
            this.sRI = i2;
            this.iiw = rect;
        }

        public final void run() {
            byte[] a2;
            AppMethodBeat.i(91173);
            int[] iArr = new int[2];
            synchronized (h.this.lQo) {
                try {
                    a2 = h.this.lQo.a(this.CDY, this.CDZ, this.sRI, this.iiw, iArr);
                } finally {
                    AppMethodBeat.o(91173);
                }
            }
            synchronized (h.this.CCt) {
                if (a2 != null) {
                    try {
                        if (this.dDZ == h.this.CDU) {
                            h.this.CDO.put("param_gray_data", a2);
                            h.this.CDO.put("param_out_size", new Point(iArr[0], iArr[1]));
                            if (!h.this.CDW) {
                                Log.i("MicroMsg.WxScanDecodeQueue", "%d submit decode gray", Long.valueOf(h.this.CDU));
                                ThreadPool.post(new b(this.dDZ), "WxScanDecodeQueue_Decode_Gray");
                            }
                            if (h.this.RKt != null) {
                                h.this.RKt.aj(h.this.CDU, 10);
                            }
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.o(91173);
                        throw th;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class b implements Runnable {
        private byte[] RKB;
        private Point RKC;
        private long dDZ;

        b(long j2) {
            this.dDZ = j2;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:100:0x036e, code lost:
            com.tencent.qbar.h.r(r15.RKA);
            com.tencent.qbar.h.s(r15.RKA);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:101:0x0378, code lost:
            com.tencent.qbar.h.g(r15.RKA);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:102:0x037e, code lost:
            r15.RKA.CDW = false;
            com.tencent.qbar.h.g(r15.RKA);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:103:0x038a, code lost:
            r1 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:104:0x038d, code lost:
            r2 = "";
         */
        /* JADX WARNING: Code restructure failed: missing block: B:107:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:108:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:109:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0076, code lost:
            if (r15.RKB == null) goto L_0x01e9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x007a, code lost:
            if (r15.RKC == null) goto L_0x01e9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x007c, code lost:
            r7 = r15.RKA.lQo;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0082, code lost:
            monitor-enter(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x008d, code lost:
            if (r15.RKA.lQo.hasInited() == false) goto L_0x01cd;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x008f, code lost:
            com.tencent.qbar.h.h(r15.RKA);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x009a, code lost:
            if (r15.RKA.aYc == false) goto L_0x00c4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x009c, code lost:
            com.tencent.qbar.h.j(r15.RKA);
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WxScanDecodeQueue", "alvinluo decodeGrayData isZooming and reset, currentFrameNumWhenZooming: %d", java.lang.Integer.valueOf(r15.RKA.RKz));
            r15.RKA.lQo.reset(true);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x00c4, code lost:
            r3 = r15.RKA.lQo.a(r15.RKB, r15.RKC.x, r15.RKC.y, r4, r5);
            r1 = r15.RKA.lQo.hlb();
            r13 = r15.RKA.lQo.hkn();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x00f0, code lost:
            if (com.tencent.mm.plugin.scanner.util.d.eRT() == false) goto L_0x038d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00f2, code lost:
            r2 = r15.RKA.lQo.jS();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x00fd, code lost:
            monitor-exit(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0104, code lost:
            if (r15.RKA.RKr == null) goto L_0x0118;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x010c, code lost:
            if (r15.RKA.CJM == false) goto L_0x0118;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x010e, code lost:
            r3 = r15.RKA.RKr.gC(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0118, code lost:
            r6 = (int) (java.lang.System.currentTimeMillis() - r8);
            com.tencent.qbar.c.RJE.hkh();
            com.tencent.qbar.c.RJE.Ov((long) r6);
            com.tencent.qbar.c.RJE.mr(r15.RKC.x, r15.RKC.y);
            com.tencent.qbar.c.RJE.RJW = com.tencent.qbar.h.n(r15.RKA);
            r14 = r15.RKA.CCt;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0146, code lost:
            monitor-enter(r14);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0151, code lost:
            if (r15.dDZ != r15.RKA.CDU) goto L_0x037e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0153, code lost:
            r9 = new java.lang.Object[2];
            r9[0] = com.tencent.qbar.a.getVersion();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0164, code lost:
            if (r3 != null) goto L_0x01fb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0166, code lost:
            r0 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0167, code lost:
            r9[1] = java.lang.Integer.valueOf(r0);
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WxScanDecodeQueue", "qbar version %s, get %d decode results", r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0170, code lost:
            if (r3 == null) goto L_0x0201;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0172, code lost:
            r7 = r3.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x017a, code lost:
            if (r7.hasNext() == false) goto L_0x0201;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x017c, code lost:
            r0 = r7.next();
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WxScanDecodeQueue", "result " + r0.typeName + "," + r0.data);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x01a8, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x01aa, code lost:
            com.tencent.matrix.trace.core.AppMethodBeat.o(91174);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x01b0, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x01cd, code lost:
            r15.RKA.CDW = false;
            com.tencent.qbar.h.g(r15.RKA);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x01d8, code lost:
            monitor-exit(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x01d9, code lost:
            com.tencent.matrix.trace.core.AppMethodBeat.o(91174);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x01e0, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x01e2, code lost:
            com.tencent.matrix.trace.core.AppMethodBeat.o(91174);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x01e8, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x01e9, code lost:
            r15.RKA.CDW = false;
            com.tencent.qbar.h.g(r15.RKA);
            com.tencent.matrix.trace.core.AppMethodBeat.o(91174);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x01fb, code lost:
            r0 = r3.size();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x0201, code lost:
            r7 = new android.os.Bundle();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x0207, code lost:
            if (r1 == null) goto L_0x038a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x0209, code lost:
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WxScanDecodeQueue", "isZoom %b, zoomFactor %f", java.lang.Boolean.valueOf(r1.isZoom), java.lang.Float.valueOf(r1.zoomFactor));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x0227, code lost:
            if (r3 == null) goto L_0x0233;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x022d, code lost:
            if (r3.isEmpty() == false) goto L_0x038a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:0x0231, code lost:
            if (r1.isZoom == false) goto L_0x038a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:0x0233, code lost:
            r7.putFloat("param_zoom_ratio", r1.zoomFactor);
            r1 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:73:0x023d, code lost:
            r8 = com.tencent.qbar.h.a(r15.RKA, r3);
            r11 = new java.lang.Object[3];
            r11[0] = java.lang.Boolean.valueOf(r8);
            r11[1] = java.lang.Boolean.valueOf(r15.RKA.aYc);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:0x0261, code lost:
            if (r3 != null) goto L_0x0354;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:0x0263, code lost:
            r0 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:0x0264, code lost:
            r11[2] = java.lang.Integer.valueOf(r0);
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WxScanDecodeQueue", "alvinluo decodeGrayData ignoreResult: %b, isZooming: %b, result size: %d", r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x0271, code lost:
            if (r7.isEmpty() != false) goto L_0x027e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x0273, code lost:
            r15.RKA.RKt.b(r15.dDZ, r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:79:0x027e, code lost:
            if (r3 == null) goto L_0x0364;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:81:0x0284, code lost:
            if (r3.isEmpty() != false) goto L_0x0364;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:82:0x0286, code lost:
            if (r8 != false) goto L_0x0364;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:0x0288, code lost:
            com.tencent.qbar.c.RJE.hkg();
            com.tencent.qbar.c.RJE.Ow((long) r6);
            r6 = com.tencent.qbar.c.RJE;
            r7 = r3.get(0).typeName;
            r8 = r3.get(0).data;
            r9 = r3.get(0).charset;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:84:0x02b4, code lost:
            if (r5.isEmpty() == false) goto L_0x035a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:85:0x02b6, code lost:
            r10 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:86:0x02b7, code lost:
            r6.a(r7, r8, r9, r10, r3.size(), r5);
            com.tencent.qbar.c.RJE.RJV = r13;
            com.tencent.mm.sdk.platformtools.Log.v("MicroMsg.QBarEngineReporter", "alvinluo setWaitingFrameCount: %d", java.lang.Integer.valueOf(r13));
            com.tencent.qbar.c.RJE.bUV();
            r6 = new android.os.Bundle();
            com.tencent.mm.sdk.platformtools.Log.v("MicroMsg.WxScanDecodeQueue", "alvinluo decodeSuccess result size: %d, isZooming: %b", java.lang.Integer.valueOf(r3.size()), java.lang.Boolean.valueOf(r15.RKA.aYc));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:87:0x0309, code lost:
            if (r3.size() <= 1) goto L_0x031f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:89:0x0311, code lost:
            if (r15.RKA.aYc == false) goto L_0x031f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:90:0x0313, code lost:
            r6.putParcelable("decode_success_frame_data", r15.RKA.RKw);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:0x031f, code lost:
            r6.putString("decode_debug_string", r2);
            r6.putLong("decode_success_cost_time", java.lang.System.currentTimeMillis() - r15.RKA.CHf);
            r15.RKA.RKt.a(r15.RKA.CDU, r3, r4, r5, r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:92:0x0345, code lost:
            r15.RKA.CDW = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:93:0x034b, code lost:
            monitor-exit(r14);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:95:0x0354, code lost:
            r0 = r3.size();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:96:0x035a, code lost:
            r10 = (com.tencent.qbar.WxQbarNative.QBarReportMsg) r5.get(0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:97:0x0364, code lost:
            if (r1 == false) goto L_0x0378;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:99:0x036c, code lost:
            if (r15.RKA.RKx == false) goto L_0x0378;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0063, code lost:
            r8 = java.lang.System.currentTimeMillis();
            r5 = new java.util.ArrayList();
            r4 = new java.util.ArrayList();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            // Method dump skipped, instructions count: 912
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.qbar.h.b.run():void");
        }
    }

    private void hkq() {
        AppMethodBeat.i(194835);
        if (this.RKv != null) {
            MMHandlerThread.removeRunnable(this.RKv);
        }
        AppMethodBeat.o(194835);
    }

    static /* synthetic */ void g(h hVar) {
        AppMethodBeat.i(91182);
        if (hVar.CDO.isEmpty() || hVar.CDU == 0) {
            if (hVar.RKt != null) {
                hVar.RKt.aj(hVar.CDU, 0);
            }
            AppMethodBeat.o(91182);
            return;
        }
        Log.i("MicroMsg.WxScanDecodeQueue", "%d decode hit cache", Long.valueOf(hVar.CDU));
        ThreadPool.post(new b(hVar.CDU), "WxScanDecodeQueue_Decode_Gray");
        AppMethodBeat.o(91182);
    }

    static /* synthetic */ boolean n(h hVar) {
        for (int i2 = 0; i2 < hVar.RKg.length; i2++) {
            if (hVar.RKg[i2] == 3 || hVar.RKg[i2] == 0) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ boolean a(h hVar, List list) {
        AppMethodBeat.i(194836);
        if (!hVar.aYc || list == null || list.isEmpty() || list.size() <= 1 || hVar.RKz > hVar.RKy) {
            AppMethodBeat.o(194836);
            return false;
        }
        AppMethodBeat.o(194836);
        return true;
    }

    static /* synthetic */ void r(h hVar) {
        AppMethodBeat.i(194837);
        Log.i("MicroMsg.WxScanDecodeQueue", "alvinluo onZoomStart");
        hVar.aYc = true;
        hVar.RKz = 0;
        AppMethodBeat.o(194837);
    }

    static /* synthetic */ void s(h hVar) {
        AppMethodBeat.i(194838);
        Log.i("MicroMsg.WxScanDecodeQueue", "alvinluo triggerZoomFinishTimer zoomDuration: %d", Long.valueOf(hVar.RKu));
        hVar.hkq();
        if (hVar.RKv == null) {
            hVar.RKv = new Runnable() {
                /* class com.tencent.qbar.h.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(194834);
                    h.t(h.this);
                    AppMethodBeat.o(194834);
                }
            };
        }
        MMHandlerThread.postToMainThreadDelayed(hVar.RKv, hVar.RKu);
        AppMethodBeat.o(194838);
    }

    static /* synthetic */ void t(h hVar) {
        AppMethodBeat.i(194839);
        synchronized (hVar.CCt) {
            try {
                Log.i("MicroMsg.WxScanDecodeQueue", "alvinluo onZoomEnd");
                hVar.aYc = false;
            } finally {
                AppMethodBeat.o(194839);
            }
        }
    }
}
