package com.tencent.scanlib.b;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qbar.a;
import com.tencent.stubs.logger.Log;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class c {
    private static c ROG = new c();
    public Object CCt = new Object();
    private Map CDO = new HashMap();
    private ExecutorService CDQ = Executors.newSingleThreadExecutor();
    public long CDU;
    private boolean CDW;
    public int CDX;
    public int[] RKg = {2, 1};
    public a ROF = new a("ScanDecodeQueue");
    public ExecutorService ROH = Executors.newSingleThreadExecutor();
    private AbstractC2187c ROI;

    /* renamed from: com.tencent.scanlib.b.c$c  reason: collision with other inner class name */
    public interface AbstractC2187c {
        void aj(long j2, long j3);

        void b(long j2, Bundle bundle);

        void b(long j2, List<a.C2180a> list);
    }

    static /* synthetic */ int i(c cVar) {
        int i2 = cVar.CDX;
        cVar.CDX = i2 + 1;
        return i2;
    }

    static {
        AppMethodBeat.i(3563);
        AppMethodBeat.o(3563);
    }

    private c() {
        AppMethodBeat.i(3560);
        AppMethodBeat.o(3560);
    }

    public static c hld() {
        return ROG;
    }

    public final void a(long j2, AbstractC2187c cVar) {
        synchronized (this.CCt) {
            this.CDU = j2;
            this.ROI = cVar;
            this.CDX = 0;
        }
    }

    public final void Iv(long j2) {
        AppMethodBeat.i(3561);
        synchronized (this.CCt) {
            try {
                if (this.CDU == j2) {
                    this.CDU = 0;
                    this.ROI = null;
                    this.CDX = 0;
                    this.CDO.clear();
                }
            } finally {
                AppMethodBeat.o(3561);
            }
        }
    }

    public class a implements Runnable {
        private byte[] CDY;
        private Point CDZ;
        private long dDZ;
        private Rect iiw;
        private int sRI;

        public a(long j2, byte[] bArr, Point point, int i2, Rect rect) {
            this.dDZ = j2;
            this.CDY = bArr;
            this.CDZ = point;
            this.sRI = i2;
            this.iiw = rect;
        }

        public final void run() {
            byte[] a2;
            AppMethodBeat.i(3558);
            int[] iArr = new int[2];
            synchronized (c.this.ROF) {
                try {
                    a2 = c.this.ROF.a(this.CDY, this.CDZ, this.sRI, this.iiw, iArr);
                } finally {
                    AppMethodBeat.o(3558);
                }
            }
            synchronized (c.this.CCt) {
                if (a2 != null) {
                    try {
                        if (this.dDZ == c.this.CDU) {
                            c.this.CDO.put("param_gray_data", a2);
                            c.this.CDO.put("param_out_size", new Point(iArr[0], iArr[1]));
                            if (!c.this.CDW) {
                                Log.i("ScanDecodeQueue", String.format("%d submit decode gray", Long.valueOf(c.this.CDU)));
                                c.this.CDQ.execute(new b(this.dDZ));
                            }
                            c.this.ROI.aj(c.this.CDU, 10);
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.o(3558);
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

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x006f, code lost:
            if (r13.RKB == null) goto L_0x0153;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0073, code lost:
            if (r13.RKC == null) goto L_0x0153;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0075, code lost:
            r4 = r13.ROJ.ROF;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x007b, code lost:
            monitor-enter(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0086, code lost:
            if (r13.ROJ.ROF.hasInited() == false) goto L_0x013d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0088, code lost:
            com.tencent.scanlib.b.c.i(r13.ROJ);
            r5 = r13.ROJ.ROF.U(r13.RKB, r13.RKC.x, r13.RKC.y);
            r6 = r13.ROJ.ROF.hlb();
            r13.ROJ.ROF.H(r2, r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x00b4, code lost:
            monitor-exit(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x00b5, code lost:
            r4 = r13.ROJ.CCt;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x00bb, code lost:
            monitor-enter(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x00c6, code lost:
            if (r13.dDZ != r13.ROJ.CDU) goto L_0x020f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x00c8, code lost:
            r9 = new java.lang.Object[2];
            r9[0] = com.tencent.qbar.a.getVersion();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x00d9, code lost:
            if (r5 != null) goto L_0x0161;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x00db, code lost:
            r0 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x00dc, code lost:
            r9[1] = java.lang.Integer.valueOf(r0);
            com.tencent.stubs.logger.Log.i("ScanDecodeQueue", java.lang.String.format("qbar version %s, get %d decode results", r9));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x00e9, code lost:
            if (r5 == null) goto L_0x0167;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x00eb, code lost:
            r1 = r5.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x00f3, code lost:
            if (r1.hasNext() == false) goto L_0x0167;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x00f5, code lost:
            r0 = r1.next();
            com.tencent.stubs.logger.Log.i("ScanDecodeQueue", "result " + r0.typeName + "," + r0.data);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0121, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0123, code lost:
            com.tencent.matrix.trace.core.AppMethodBeat.o(3559);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0126, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x013d, code lost:
            r13.ROJ.CDW = false;
            com.tencent.scanlib.b.c.h(r13.ROJ);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0148, code lost:
            monitor-exit(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0149, code lost:
            com.tencent.matrix.trace.core.AppMethodBeat.o(3559);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x014d, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x014f, code lost:
            com.tencent.matrix.trace.core.AppMethodBeat.o(3559);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x0152, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x0153, code lost:
            r13.ROJ.CDW = false;
            com.tencent.scanlib.b.c.h(r13.ROJ);
            com.tencent.matrix.trace.core.AppMethodBeat.o(3559);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x0161, code lost:
            r0 = r5.size();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x0167, code lost:
            r0 = new android.os.Bundle();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x016c, code lost:
            if (r6 == null) goto L_0x01a4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x016e, code lost:
            com.tencent.stubs.logger.Log.i("ScanDecodeQueue", java.lang.String.format("isZoom %b, zoomFactor %f", java.lang.Boolean.valueOf(r6.isZoom), java.lang.Float.valueOf(r6.zoomFactor)));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x0190, code lost:
            if (r5 == null) goto L_0x019c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x0196, code lost:
            if (r5.isEmpty() == false) goto L_0x01a4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x019a, code lost:
            if (r6.isZoom == false) goto L_0x01a4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x019c, code lost:
            r0.putFloat("param_zoom_ratio", r6.zoomFactor);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x01a4, code lost:
            com.tencent.stubs.logger.Log.i("ScanDecodeQueue", java.lang.String.format("detect %d codes", java.lang.Integer.valueOf(r2.size())));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x01c3, code lost:
            if (r2.size() <= 0) goto L_0x01d5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x01c5, code lost:
            r1 = com.tencent.scanlib.a.G(r2, r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x01cd, code lost:
            if (r1.isEmpty() != false) goto L_0x01d5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x01cf, code lost:
            r0.putParcelableArrayList("param_detect_codes", r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x01d9, code lost:
            if (r0.isEmpty() != false) goto L_0x01e6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:0x01db, code lost:
            r13.ROJ.ROI.b(r13.dDZ, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:0x01e6, code lost:
            if (r5 == null) goto L_0x0209;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:73:0x01ec, code lost:
            if (r5.isEmpty() != false) goto L_0x0209;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:0x01ee, code lost:
            r13.ROJ.ROI.b(r13.ROJ.CDU, r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:0x01fd, code lost:
            r13.ROJ.CDW = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:0x0203, code lost:
            monitor-exit(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x0209, code lost:
            com.tencent.scanlib.b.c.h(r13.ROJ);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:79:0x020f, code lost:
            r13.ROJ.CDW = false;
            com.tencent.scanlib.b.c.h(r13.ROJ);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:82:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:84:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0063, code lost:
            r2 = new java.util.ArrayList();
            r3 = new java.util.ArrayList();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            // Method dump skipped, instructions count: 539
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.scanlib.b.c.b.run():void");
        }
    }

    static /* synthetic */ void h(c cVar) {
        AppMethodBeat.i(3562);
        if (cVar.CDO.isEmpty() || cVar.CDU == 0) {
            if (cVar.ROI != null) {
                cVar.ROI.aj(cVar.CDU, 0);
            }
            AppMethodBeat.o(3562);
            return;
        }
        Log.i("ScanDecodeQueue", String.format("%d decode hit cache", Long.valueOf(cVar.CDU)));
        cVar.CDQ.execute(new b(cVar.CDU));
        AppMethodBeat.o(3562);
    }
}
