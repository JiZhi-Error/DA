package com.tencent.mm.plugin.scanner.b.a;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.qbar.WxQbarNative;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class b {
    public static float CDN = 1.15f;
    private static b CDS = new b();
    public Object CCt = new Object();
    public Map CDO = new HashMap();
    public Object CDP = new Object();
    public Rect CDR = new Rect();
    public ExecutorService CDT = Executors.newSingleThreadExecutor();
    public long CDU;
    public a CDV;
    public boolean CDW;
    public int CDX;
    public volatile boolean gKM;
    public Rect iiw = new Rect();

    public interface a {
        void a(long j2, Bundle bundle);

        void aj(long j2, long j3);
    }

    public b() {
        AppMethodBeat.i(118323);
        AppMethodBeat.o(118323);
    }

    static /* synthetic */ int g(b bVar) {
        int i2 = bVar.CDX;
        bVar.CDX = i2 + 1;
        return i2;
    }

    static {
        AppMethodBeat.i(118326);
        AppMethodBeat.o(118326);
    }

    public static b ePG() {
        return CDS;
    }

    public final void release() {
        AppMethodBeat.i(118324);
        Log.i("MicroMsg.BankCardDetectQueue", "release");
        long j2 = this.CDU;
        synchronized (this.CCt) {
            try {
                if (this.CDU == j2) {
                    this.CDU = 0;
                    this.CDX = 0;
                    this.CDV = null;
                    this.CDO.clear();
                }
            } finally {
                AppMethodBeat.o(118324);
            }
        }
        synchronized (this.CDP) {
            try {
                if (this.gKM) {
                    WxQbarNative.focusedEngineRelease();
                }
                this.gKM = false;
            } finally {
                AppMethodBeat.o(118324);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.b.a.b$b  reason: collision with other inner class name */
    public class RunnableC1664b implements Runnable {
        private byte[] CDY;
        private Point CDZ;
        private long dDZ;
        private int sRI;

        public RunnableC1664b(long j2) {
            this.dDZ = j2;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0095, code lost:
            r10 = r13.CEa.CDP;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x009b, code lost:
            monitor-enter(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
            r0 = new byte[(((r13.CEa.iiw.width() * r13.CEa.iiw.height()) * 3) / 2)];
            r1 = com.tencent.qbar.WxQbarNative.QIPUtilYUVCrop(r0, r13.CDY, r13.CDZ.x, r13.CDZ.y, r13.CEa.iiw.left, r13.CEa.iiw.top, r13.CEa.iiw.width(), r13.CEa.iiw.height());
            com.tencent.mm.plugin.scanner.b.a.b.g(r13.CEa);
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.BankCardDetectQueue", "yuv crop ret %d", java.lang.Integer.valueOf(r1));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0101, code lost:
            if (r1 != 0) goto L_0x01d4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0107, code lost:
            if (com.tencent.qbar.WxQbarNative.focusedEngineProcess(r0) != 1) goto L_0x01c3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0109, code lost:
            r0 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x010a, code lost:
            com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.BankCardDetectQueue", "isBest %s", java.lang.Boolean.valueOf(r0));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x011d, code lost:
            if (r0 == false) goto L_0x01d4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x011f, code lost:
            r0 = new android.graphics.YuvImage(r13.CDY, 17, r13.CDZ.x, r13.CDZ.y, null);
            r1 = new java.io.ByteArrayOutputStream();
            r0.compressToJpeg(r13.CEa.iiw, 80, r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0145, code lost:
            if ((r13.sRI % com.tencent.rtmp.TXLiveConstants.RENDER_ROTATION_180) == 0) goto L_0x01c6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0147, code lost:
            r0 = 448.0f / ((float) r13.CEa.iiw.height());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0154, code lost:
            r0 = com.tencent.mm.sdk.platformtools.BitmapUtil.rotateAndScale(com.tencent.mm.sdk.platformtools.BitmapUtil.decodeByteArray(r1.toByteArray()), (float) r13.sRI, r0, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0163, code lost:
            if (r0 == null) goto L_0x01d4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0165, code lost:
            r1 = new android.os.Bundle();
            r1.putParcelable("param_card_bitmap", r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0176, code lost:
            if (r13.CEa.CDV == null) goto L_0x0183;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0178, code lost:
            r13.CEa.CDV.a(r13.dDZ, r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0183, code lost:
            r13.CEa.CDW = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0189, code lost:
            monitor-exit(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x01c3, code lost:
            r0 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x01c6, code lost:
            r0 = 448.0f / ((float) r13.CEa.iiw.width());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x01d4, code lost:
            r13.CEa.CDW = false;
            com.tencent.mm.plugin.scanner.b.a.b.h(r13.CEa);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x01df, code lost:
            monitor-exit(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x01e0, code lost:
            com.tencent.matrix.trace.core.AppMethodBeat.o(118322);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x01e4, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x01e6, code lost:
            com.tencent.matrix.trace.core.AppMethodBeat.o(118322);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x01e9, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            // Method dump skipped, instructions count: 490
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.scanner.b.a.b.RunnableC1664b.run():void");
        }
    }

    static /* synthetic */ void h(b bVar) {
        AppMethodBeat.i(118325);
        if (bVar.CDO.isEmpty() || bVar.CDU == 0) {
            if (bVar.CDV != null) {
                bVar.CDV.aj(bVar.CDU, 0);
            }
            AppMethodBeat.o(118325);
            return;
        }
        Log.i("MicroMsg.BankCardDetectQueue", "%d decode hit cache", Long.valueOf(bVar.CDU));
        ThreadPool.post(new RunnableC1664b(bVar.CDU), "BankCardDetectQueue_detect_task");
        AppMethodBeat.o(118325);
    }
}
