package com.tencent.qbar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.qbar.QbarNative;
import com.tencent.qbar.WxQbarNative;
import com.tencent.qbar.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class e {
    private static e RKb = new e();
    private static int mEX = 0;
    private static int mEY = 0;
    private Object CCt = new Object();
    private ExecutorService CDQ = Executors.newSingleThreadExecutor();
    private Map<Long, String> RKc = new HashMap();
    private Map<Long, b> RKd = new HashMap();
    private Map<String, List<Long>> RKe = new HashMap();
    private g lQo = new g("WxFileDecodeQueue");

    public interface b {
        void a(long j2, d dVar);
    }

    public static class c {
        public boolean dXw = false;
        public int dXx = 0;
    }

    public static class d {
        public List<a.C2180a> CGY;
        public List<QbarNative.QBarPoint> RKj;
        public List<WxQbarNative.QBarReportMsg> RKk;
        public Point RKl;
        public int dXx;
    }

    public e() {
        AppMethodBeat.i(91154);
        AppMethodBeat.o(91154);
    }

    static {
        AppMethodBeat.i(91156);
        AppMethodBeat.o(91156);
    }

    public static e hki() {
        return RKb;
    }

    public final void a(Context context, long j2, String str, Bitmap bitmap, b bVar, int[] iArr, c cVar) {
        AppMethodBeat.i(194825);
        synchronized (this.CCt) {
            try {
                int size = this.RKc.size();
                if (size < 9) {
                    Log.i("WxFileDecodeQueue", "addDecodeTask submit decode task %d, fileMap: %d", Long.valueOf(j2), Integer.valueOf(size));
                    this.RKc.put(Long.valueOf(j2), str);
                    if (bVar != null) {
                        this.RKd.put(Long.valueOf(j2), bVar);
                    }
                    if (!this.RKe.containsKey(str)) {
                        this.RKe.put(str, new ArrayList());
                        this.CDQ.execute(new a(str, bitmap, com.tencent.scanlib.a.lb(context), iArr, cVar));
                    }
                    this.RKe.get(str).add(Long.valueOf(j2));
                } else {
                    Log.w("WxFileDecodeQueue", "too many files are waiting and ignore: %d", Long.valueOf(j2));
                    bVar.a(j2, null);
                }
            } finally {
                AppMethodBeat.o(194825);
            }
        }
    }

    public final void a(Context context, long j2, String str, b bVar, int[] iArr) {
        AppMethodBeat.i(194826);
        a(context, j2, str, null, bVar, iArr, null);
        AppMethodBeat.o(194826);
    }

    public final void a(Context context, long j2, String str, b bVar) {
        AppMethodBeat.i(194827);
        a(context, j2, str, bVar, new int[]{0});
        AppMethodBeat.o(194827);
    }

    /* access modifiers changed from: package-private */
    public class a implements Runnable {
        private QbarNative.QbarAiModelParam RKf;
        private int[] RKg = {0};
        private c RKh;
        private Bitmap bitmap;
        private String filePath;

        public a(String str, Bitmap bitmap2, QbarNative.QbarAiModelParam qbarAiModelParam, int[] iArr, c cVar) {
            AppMethodBeat.i(194823);
            this.filePath = str;
            this.bitmap = bitmap2;
            this.RKf = qbarAiModelParam;
            if (iArr != null && iArr.length > 0) {
                this.RKg = iArr;
            }
            this.RKh = cVar;
            AppMethodBeat.o(194823);
        }

        private boolean hkj() {
            for (int i2 = 0; i2 < this.RKg.length; i2++) {
                if (this.RKg[i2] == 3 || this.RKg[i2] == 0) {
                    return true;
                }
            }
            return false;
        }

        private Bitmap hkk() {
            int exifOrientation;
            int i2 = 0;
            AppMethodBeat.i(194824);
            Bitmap bitmap2 = null;
            if (this.bitmap == null || this.bitmap.isRecycled()) {
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapUtil.decodeFile(this.filePath, options);
                    BitmapFactory.Options options2 = new BitmapFactory.Options();
                    if (options.outWidth <= 4 || options.outHeight <= 4) {
                        AppMethodBeat.o(194824);
                        return null;
                    }
                    if (options.outWidth * options.outHeight * 3 > 10485760) {
                        Log.i("WxFileDecodeQueue", "bitmap too large %d x %d, sample", Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight));
                        options2.inSampleSize = 2;
                    }
                    int i3 = options.outWidth;
                    int i4 = options.outHeight;
                    if (e.mEX == 0 || e.mEY == 0) {
                        int unused = e.mEX = com.tencent.mm.cb.a.jn(MMApplicationContext.getContext());
                        int unused2 = e.mEY = com.tencent.mm.cb.a.jo(MMApplicationContext.getContext());
                    }
                    Log.v("WxFileDecodeQueue", "alvinluo needSampleImage image: %d, %d, screen: %d, %d", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(e.mEX), Integer.valueOf(e.mEY));
                    if (i3 > i4) {
                        if (i3 > ((int) (((float) e.mEX) * 2.0f))) {
                            i2 = com.tencent.qbar.b.a.calculateInSampleSize(i3, i4, (int) (((float) e.mEX) * 2.0f), i4);
                        }
                    } else if (i4 > ((int) (((float) e.mEY) * 2.0f))) {
                        i2 = com.tencent.qbar.b.a.calculateInSampleSize(i3, i4, i3, (int) (((float) e.mEX) * 2.0f));
                    }
                    Log.v("WxFileDecodeQueue", "decodeFile inSampleSize: %d, computeSampleSize: %d", Integer.valueOf(options2.inSampleSize), Integer.valueOf(i2));
                    if (options2.inSampleSize < i2) {
                        options2.inSampleSize = i2;
                    }
                    bitmap2 = BitmapUtil.decodeFile(this.filePath, options2);
                    if (this.RKh != null && this.RKh.dXw && ((exifOrientation = BackwardSupportUtil.ExifHelper.getExifOrientation(this.filePath)) == 90 || exifOrientation == 270)) {
                        Log.i("WxFileDecodeQueue", "decodeBitmap needRotate: %d", Integer.valueOf(exifOrientation));
                        bitmap2 = BitmapUtil.rotate(bitmap2, (float) exifOrientation);
                    }
                } catch (Exception e2) {
                    Log.e("WxFileDecodeQueue", "decode file to bitmap error! " + e2.getMessage());
                }
            } else {
                Log.i("WxFileDecodeQueue", "decodeFile use bitmap");
                bitmap2 = this.bitmap;
            }
            AppMethodBeat.o(194824);
            return bitmap2;
        }

        public final void run() {
            boolean z;
            int size;
            WxQbarNative.QBarReportMsg qBarReportMsg;
            AppMethodBeat.i(91153);
            Bitmap hkk = hkk();
            synchronized (e.this.lQo) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!e.this.lQo.hasInited()) {
                        e.this.lQo.a(1, this.RKf);
                    }
                    if (e.this.lQo.hasInited()) {
                        e.this.lQo.T(this.RKg);
                    }
                    d dVar = new d();
                    if (hkk != null) {
                        Log.i("WxFileDecodeQueue", "decodeFile image size: %d, %d", Integer.valueOf(hkk.getWidth()), Integer.valueOf(hkk.getHeight()));
                        int[] iArr = new int[(hkk.getWidth() * hkk.getHeight())];
                        hkk.getPixels(iArr, 0, hkk.getWidth(), 0, 0, hkk.getWidth(), hkk.getHeight());
                        ad.b JW = ad.aVe().JW("basescanui@datacenter");
                        PointF pointF = null;
                        if (JW == null) {
                            z = false;
                        } else if (JW.getBoolean("key_basescanui_screen_position", false)) {
                            pointF = new PointF(((Float) JW.get("key_basescanui_screen_x", Float.valueOf(0.0f))).floatValue(), ((Float) JW.get("key_basescanui_screen_y", Float.valueOf(0.0f))).floatValue());
                            z = false;
                        } else {
                            pointF = new PointF(((Float) JW.get("key_basescanui_touch_normalize_x", Float.valueOf(0.0f))).floatValue(), ((Float) JW.get("key_basescanui_touch_normalize_y", Float.valueOf(0.0f))).floatValue());
                            z = true;
                        }
                        dVar.RKj = new ArrayList();
                        dVar.RKk = new ArrayList();
                        dVar.RKl = new Point(hkk.getWidth(), hkk.getHeight());
                        dVar.CGY = e.this.lQo.a(iArr, dVar.RKl, pointF, dVar.RKj, dVar.RKk, this.RKh != null && this.RKh.dXw);
                        dVar.dXx = this.RKh != null ? this.RKh.dXx : 0;
                        Object[] objArr = new Object[3];
                        if (dVar.CGY == null) {
                            size = 0;
                        } else {
                            size = dVar.CGY.size();
                        }
                        objArr[0] = Integer.valueOf(size);
                        objArr[1] = Boolean.valueOf(z);
                        objArr[2] = pointF;
                        Log.i("WxFileDecodeQueue", "alvinluo decodeFile get %d decode results, isFingerPositionNormalize: %b, finger: %s", objArr);
                        int currentTimeMillis2 = (int) (System.currentTimeMillis() - currentTimeMillis);
                        c.RJF.hkh();
                        c.RJF.Ov((long) currentTimeMillis2);
                        c.RJF.mr(hkk.getWidth(), hkk.getHeight());
                        c.RJF.RJW = hkj();
                        if (dVar.CGY != null && !dVar.CGY.isEmpty()) {
                            for (a.C2180a aVar : dVar.CGY) {
                                Log.i("WxFileDecodeQueue", "decodeFile result " + aVar.typeName + "," + aVar.data);
                            }
                            c.RJF.hkg();
                            c.RJF.Ow((long) currentTimeMillis2);
                            c cVar = c.RJF;
                            String str = dVar.CGY.get(0).typeName;
                            String str2 = dVar.CGY.get(0).data;
                            String str3 = dVar.CGY.get(0).charset;
                            if (dVar.RKk.isEmpty()) {
                                qBarReportMsg = null;
                            } else {
                                qBarReportMsg = dVar.RKk.get(0);
                            }
                            cVar.a(str, str2, str3, qBarReportMsg, dVar.CGY.size(), dVar.RKk);
                        }
                        c.RJF.bUV();
                        this.bitmap = null;
                    }
                    synchronized (e.this.CCt) {
                        try {
                            if (e.this.RKe.containsKey(this.filePath)) {
                                for (Long l : (List) e.this.RKe.get(this.filePath)) {
                                    long longValue = l.longValue();
                                    if (e.this.RKd.containsKey(Long.valueOf(longValue))) {
                                        ((b) e.this.RKd.get(Long.valueOf(longValue))).a(longValue, dVar);
                                        e.this.RKd.remove(Long.valueOf(longValue));
                                    }
                                    e.this.RKc.remove(Long.valueOf(longValue));
                                }
                                e.this.RKe.remove(this.filePath);
                            }
                            if (e.this.RKe.isEmpty()) {
                                Log.i("WxFileDecodeQueue", "release QBar");
                                e.this.lQo.release();
                            }
                        } finally {
                            AppMethodBeat.o(91153);
                        }
                    }
                } finally {
                    AppMethodBeat.o(91153);
                }
            }
        }
    }
}
