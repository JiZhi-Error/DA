package com.tencent.mm.plugin.scanner.b.a;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.licence.model.LibCardRecog;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class c {
    private static c CEb = new c();
    public Object CCt = new Object();
    public Map CDO = new HashMap();
    public Object CDP = new Object();
    public ExecutorService CDQ = Executors.newSingleThreadExecutor();
    public Rect CDR = new Rect();
    public long CDU;
    public boolean CDW;
    public int CDX;
    public b CEc;
    public volatile boolean gKM;
    public Rect iiw = new Rect();
    public int ixW;

    public interface b {
        void a(long j2, Bundle bundle);

        void aj(long j2, long j3);

        void b(long j2, Bundle bundle);
    }

    public c() {
        AppMethodBeat.i(118329);
        AppMethodBeat.o(118329);
    }

    static /* synthetic */ int g(c cVar) {
        int i2 = cVar.CDX;
        cVar.CDX = i2 + 1;
        return i2;
    }

    static {
        AppMethodBeat.i(118332);
        AppMethodBeat.o(118332);
    }

    public static c ePH() {
        return CEb;
    }

    public final void a(int i2, long j2, b bVar) {
        synchronized (this.CCt) {
            this.ixW = i2;
            this.CDU = j2;
            this.CDX = 0;
            this.CEc = bVar;
        }
    }

    public final void release() {
        AppMethodBeat.i(118330);
        Log.i("MicroMsg.LicenseCardDecodeQueue", "release");
        synchronized (this.CDP) {
            try {
                if (this.gKM) {
                    LibCardRecog.recognizeCardRelease();
                }
                this.gKM = false;
            } finally {
                AppMethodBeat.o(118330);
            }
        }
    }

    public class a implements Runnable {
        private byte[] CDY;
        private Point CDZ;
        private boolean[] CEd = new boolean[4];
        private long dDZ;
        private int sRI;

        public a(long j2) {
            AppMethodBeat.i(118327);
            this.dDZ = j2;
            AppMethodBeat.o(118327);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0089, code lost:
            r0 = 0;
            r7 = new com.tencent.mm.plugin.licence.model.CardInfo(r14.CEe.iiw.width(), r14.CEe.iiw.height());
            r9 = r14.CEe.CDP;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x00a9, code lost:
            monitor-enter(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x00ac, code lost:
            if (r14.CDY == null) goto L_0x0145;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x00b1, code lost:
            if (r14.CDY.length <= 0) goto L_0x0145;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x00b3, code lost:
            r10 = java.lang.System.currentTimeMillis();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x00bb, code lost:
            if ((r14.sRI % com.tencent.rtmp.TXLiveConstants.RENDER_ROTATION_180) == 0) goto L_0x01f0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x00bd, code lost:
            r0 = new byte[(((r14.CDZ.x * r14.CDZ.y) * 3) / 2)];
            com.tencent.qbar.d.a(r0, r14.CDY, r14.CDZ.x, r14.CDZ.y);
            r0 = com.tencent.mm.plugin.licence.model.LibCardRecog.recognizeCardProcess(r0, r14.CDZ.x, r14.CDZ.y, r14.CEe.iiw.left, r14.CEe.iiw.top, r14.CEe.iiw.height(), r14.CEe.iiw.width(), r7, r14.CEd);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x010b, code lost:
            com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.LicenseCardDecodeQueue", "recognizeProcess, ret %d, cost %d", java.lang.Integer.valueOf(r0), java.lang.Long.valueOf(java.lang.System.currentTimeMillis() - r10));
            com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.LicenseCardDecodeQueue", "mRecogRectEdge: %s", java.util.Arrays.toString(r14.CEd));
            com.tencent.mm.plugin.scanner.b.a.c.g(r14.CEe);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0145, code lost:
            monitor-exit(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x014a, code lost:
            if ((r14.sRI % com.tencent.rtmp.TXLiveConstants.RENDER_ROTATION_180) == 0) goto L_0x0174;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x014c, code lost:
            r1 = r14.CEd[0];
            r14.CEd[0] = r14.CEd[2];
            r14.CEd[2] = r1;
            r1 = r14.CEd[1];
            r14.CEd[1] = r14.CEd[3];
            r14.CEd[3] = r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0174, code lost:
            r1 = r14.CEe.CCt;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x017a, code lost:
            monitor-enter(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0185, code lost:
            if (r14.dDZ != r14.CEe.CDU) goto L_0x02aa;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0187, code lost:
            r2 = new android.os.Bundle();
            r2.putBooleanArray("param_card_edge", r14.CEd);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x019a, code lost:
            if (r14.CEe.CEc == null) goto L_0x01a7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x019c, code lost:
            r14.CEe.CEc.b(r14.dDZ, r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x01a7, code lost:
            com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.LicenseCardDecodeQueue", "scan card retCode:%d, bitmap len %d", java.lang.Integer.valueOf(r0), java.lang.Integer.valueOf(r7.bitmapLen));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x01c4, code lost:
            if (r0 == 1) goto L_0x022f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x01c6, code lost:
            r14.CEe.CDW = false;
            com.tencent.mm.plugin.scanner.b.a.c.h(r14.CEe);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x01d1, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x01f0, code lost:
            r0 = com.tencent.mm.plugin.licence.model.LibCardRecog.recognizeCardProcess(r14.CDY, r14.CDZ.y, r14.CDZ.x, r14.CEe.iiw.left, r14.CEe.iiw.top, r14.CEe.iiw.height(), r14.CEe.iiw.width(), r7, r14.CEd);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0226, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0228, code lost:
            com.tencent.matrix.trace.core.AppMethodBeat.o(118328);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x022e, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x022f, code lost:
            r0 = new android.graphics.BitmapFactory.Options();
            r0.inSampleSize = 1;
            r0 = android.graphics.BitmapFactory.decodeByteArray(r7.bitmapData, 0, r7.bitmapLen, r0).copy(android.graphics.Bitmap.Config.ARGB_8888, true);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x0247, code lost:
            if (r0 != null) goto L_0x025d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x0249, code lost:
            r14.CEe.CDW = false;
            com.tencent.mm.plugin.scanner.b.a.c.h(r14.CEe);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x0254, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x0255, code lost:
            com.tencent.matrix.trace.core.AppMethodBeat.o(118328);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x025d, code lost:
            com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.LicenseCardDecodeQueue", "scan license card success width %d height %d", java.lang.Integer.valueOf(r0.getWidth()), java.lang.Integer.valueOf(r0.getHeight()));
            r2 = new android.os.Bundle();
            r2.putByteArray("param_card_bitmap", com.tencent.mm.sdk.platformtools.BitmapUtil.Bitmap2Bytes(r0, 80));
            r14.CEe.CEc.a(r14.dDZ, r2);
            r14.CEe.CDW = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x02a1, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x02a2, code lost:
            com.tencent.matrix.trace.core.AppMethodBeat.o(118328);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x02aa, code lost:
            r14.CEe.CDW = false;
            com.tencent.mm.plugin.scanner.b.a.c.h(r14.CEe);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x02b6, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x02b8, code lost:
            com.tencent.matrix.trace.core.AppMethodBeat.o(118328);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x02be, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            // Method dump skipped, instructions count: 703
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.scanner.b.a.c.a.run():void");
        }
    }

    static /* synthetic */ void h(c cVar) {
        AppMethodBeat.i(161726);
        if (cVar.CDO.isEmpty() || cVar.CDU == 0) {
            if (cVar.CEc != null) {
                cVar.CEc.aj(cVar.CDU, 0);
            }
            AppMethodBeat.o(161726);
            return;
        }
        Log.i("MicroMsg.LicenseCardDecodeQueue", "%d decode hit cache", Long.valueOf(cVar.CDU));
        ThreadPool.post(new a(cVar.CDU), "BankCardDecodeQueue_decode_task");
        AppMethodBeat.o(161726);
    }
}
