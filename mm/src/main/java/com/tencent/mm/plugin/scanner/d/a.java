package com.tencent.mm.plugin.scanner.d;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.d.b;
import com.tencent.mm.plugin.scanner.model.ae;
import com.tencent.mm.plugin.scanner.model.x;
import com.tencent.mm.plugin.scanner.model.y;
import com.tencent.mm.plugin.scanner.ui.ScanUIRectView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.rtmp.TXLiveConstants;
import java.util.HashMap;
import java.util.Map;

public final class a {
    private static a CEj = new a();
    public final Object CCt = new Object();
    private Map CDO = new HashMap();
    public long CDU;
    private boolean CDW;
    public final Object CEk = new Object();
    public AbstractC1668a CEl;
    public boolean gKM;
    private int xlg = 0;
    private int xlh = 0;

    /* renamed from: com.tencent.mm.plugin.scanner.d.a$a  reason: collision with other inner class name */
    public interface AbstractC1668a extends b.a {
        void a(ae aeVar);
    }

    public interface c extends ScanUIRectView.a {
        void H(long j2, String str);
    }

    public a() {
        AppMethodBeat.i(51576);
        AppMethodBeat.o(51576);
    }

    static {
        AppMethodBeat.i(51584);
        AppMethodBeat.o(51584);
    }

    public static a ePJ() {
        return CEj;
    }

    public final void a(final byte[] bArr, final Point point, final int i2, final int i3, final boolean z) {
        AppMethodBeat.i(240712);
        Log.v("MicroMsg.AiScanImageDecodeQueueNew", "alvinluo addDecodeTask resolution: %s, previewData length: %d, cameraRotation: %d, previewFormat: %d", point, Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3));
        x.a(new y() {
            /* class com.tencent.mm.plugin.scanner.d.a.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(51572);
                a.a(a.this, bArr, point, i2, i3, z);
                AppMethodBeat.o(51572);
            }
        });
        AppMethodBeat.o(240712);
    }

    private y ePK() {
        AppMethodBeat.i(51579);
        b bVar = new b(this.CDU);
        AppMethodBeat.o(51579);
        return bVar;
    }

    public final void Iv(long j2) {
        AppMethodBeat.i(51580);
        synchronized (this.CCt) {
            try {
                if (this.CDU == j2) {
                    this.CDU = 0;
                    this.CEl = null;
                    this.CDO.clear();
                }
            } finally {
                AppMethodBeat.o(51580);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class b implements y {
        private byte[] CDY;
        private Point CDZ;
        private long dDZ;
        private int pixelFormat;
        private int sRI;

        public b(long j2) {
            this.dDZ = j2;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x008c, code lost:
            monitor-enter(r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0093, code lost:
            if (r13.CEr.gKM == false) goto L_0x028b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0097, code lost:
            if (r13.CDY == null) goto L_0x028b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0099, code lost:
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AiScanImageDecodeQueueNew", "alvinluo processFrame session: %d, curSession: %d, resolution: %s, pixelFormat: %d, cameraRotation: %d, len: %d", java.lang.Long.valueOf(r13.dDZ), java.lang.Long.valueOf(r13.CEr.CDU), r13.CDZ, java.lang.Integer.valueOf(r13.pixelFormat), java.lang.Integer.valueOf(r13.sRI), java.lang.Integer.valueOf(r13.CDY.length));
            r5 = com.tencent.mm.plugin.scanner.model.x.process(r13.CDY, r13.pixelFormat, r13.sRI);
            r0 = com.tencent.mm.plugin.scanner.model.x.ePX();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x00ea, code lost:
            if (r0 == null) goto L_0x00fd;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x00f2, code lost:
            if (r13.CEr.CEl == null) goto L_0x00fd;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x00f4, code lost:
            r13.CEr.CEl.a(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x00fd, code lost:
            if (r5 == null) goto L_0x023a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0101, code lost:
            if (r5.bestImageData == null) goto L_0x023a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0105, code lost:
            if (r5.width <= 0) goto L_0x023a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0109, code lost:
            if (r5.height <= 0) goto L_0x023a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x010b, code lost:
            r0 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x010c, code lost:
            if (r0 == false) goto L_0x028b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0110, code lost:
            if (r5.result <= 0) goto L_0x023d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0116, code lost:
            if ((r5.result & 2) == 0) goto L_0x023d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0118, code lost:
            r7 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0119, code lost:
            r1 = r5.bestImageData;
            r6 = r5.bestImageId;
            r3 = r5.width;
            r4 = r5.height;
            r10 = new java.lang.Object[6];
            r10[0] = java.lang.Integer.valueOf(r5.result);
            r10[1] = 2;
            r10[2] = java.lang.Boolean.valueOf(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0143, code lost:
            if (r1 == null) goto L_0x0240;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0145, code lost:
            r0 = r1.length;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0146, code lost:
            r10[3] = java.lang.Integer.valueOf(r0);
            r10[4] = java.lang.Integer.valueOf(r3);
            r10[5] = java.lang.Integer.valueOf(r4);
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AiScanImageDecodeQueueNew", "alvinluo processFrame result: %d, outputClearFlag: %d, isBest: %b, bestImage length: %d, finalWidth: %d, finalHeight: %d", r10);
            r0 = new android.graphics.YuvImage(r1, 17, r3, r4, null);
            r1 = new android.graphics.Rect(0, 0, r3, r4);
            r2 = java.lang.System.currentTimeMillis();
            r4 = new java.io.ByteArrayOutputStream();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
            r0.compressToJpeg(r1, 70, r4);
            r4.flush();
            r4.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x023a, code lost:
            r0 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x023d, code lost:
            r7 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:0x0240, code lost:
            r0 = -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x0243, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:0x0244, code lost:
            com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.AiScanImageDecodeQueueNew", r0, "alvinluo compressToJpeg exception %s", r0.getMessage());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:0x0259, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:73:0x025b, code lost:
            com.tencent.matrix.trace.core.AppMethodBeat.o(51575);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:0x025e, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:0x028b, code lost:
            r0 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0085, code lost:
            r3 = null;
            r8 = r13.CEr.CEk;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            // Method dump skipped, instructions count: 654
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.scanner.d.a.b.run():void");
        }
    }

    static /* synthetic */ void a(a aVar, byte[] bArr, Point point, int i2, int i3, boolean z) {
        int i4;
        AppMethodBeat.i(240713);
        if (!aVar.gKM) {
            synchronized (aVar.CEk) {
                try {
                    aVar.gKM = x.d(point.x, point.y, i2, z) == 0;
                } catch (Throwable th) {
                    AppMethodBeat.o(240713);
                    throw th;
                }
            }
            if (i2 % TXLiveConstants.RENDER_ROTATION_180 != 0) {
                aVar.xlg = point.y;
                aVar.xlh = point.x;
            } else {
                aVar.xlg = point.x;
                aVar.xlh = point.y;
            }
        }
        if (aVar.gKM) {
            switch (i3) {
                case 17:
                    i4 = 3;
                    break;
                case 842094169:
                    i4 = 4;
                    break;
                default:
                    i4 = -1;
                    break;
            }
            synchronized (aVar.CCt) {
                try {
                    aVar.CDO.clear();
                    aVar.CDO.put("param_preview_data", bArr);
                    aVar.CDO.put("param_camera_resolution", point);
                    aVar.CDO.put("param_camera_rotation", Integer.valueOf(i2));
                    aVar.CDO.put("param_pixel_format", Integer.valueOf(i4));
                    if (!aVar.CDW && aVar.CDU != 0) {
                        x.a(aVar.ePK());
                    }
                } finally {
                    AppMethodBeat.o(240713);
                }
            }
            return;
        }
        AppMethodBeat.o(240713);
    }

    static /* synthetic */ void f(a aVar) {
        AppMethodBeat.i(240714);
        if (aVar.CDO.isEmpty() || aVar.CDU == 0) {
            if (aVar.CEl != null) {
                aVar.CEl.Iw(aVar.CDU);
            }
            AppMethodBeat.o(240714);
            return;
        }
        Log.i("MicroMsg.AiScanImageDecodeQueueNew", "%d decode hit cache", Long.valueOf(aVar.CDU));
        x.a(aVar.ePK());
        AppMethodBeat.o(240714);
    }
}
