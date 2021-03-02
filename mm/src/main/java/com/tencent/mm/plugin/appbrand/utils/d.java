package com.tencent.mm.plugin.appbrand.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.luggage.e.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.l;
import com.tencent.mm.plugin.performance.watchdogs.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.io.OutputStream;

public enum d {
    ;

    public static d valueOf(String str) {
        AppMethodBeat.i(107811);
        d dVar = (d) Enum.valueOf(d.class, str);
        AppMethodBeat.o(107811);
        return dVar;
    }

    @Deprecated
    public static boolean d(BitmapFactory.Options options) {
        AppMethodBeat.i(107812);
        boolean d2 = a.d(options);
        AppMethodBeat.o(107812);
        return d2;
    }

    private static boolean createThumbNail(String str, int i2, int i3, Bitmap.CompressFormat compressFormat, int i4, String str2) {
        AppMethodBeat.i(107813);
        BitmapFactory.Options imageOptions = BitmapUtil.getImageOptions(str);
        if (imageOptions == null || imageOptions.outWidth <= 0 || imageOptions.outHeight <= 0) {
            AppMethodBeat.o(107813);
            return false;
        }
        boolean a2 = a(str, imageOptions.outWidth, imageOptions.outHeight, i2, i3, compressFormat, i4, str2);
        AppMethodBeat.o(107813);
        return a2;
    }

    private static Bitmap b(String str, BitmapFactory.Options options) {
        AppMethodBeat.i(107814);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Bitmap a2 = l.aRY().a(str, options);
            Log.d("MicroMsg.AppBrandImgUtil", "decodeWithRotateByExif used %dms bitmap: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), a2);
            AppMethodBeat.o(107814);
            return a2;
        } catch (OutOfMemoryError e2) {
            Log.e("MicroMsg.AppBrandImgUtil", "%s", c.eCH().S(true, 0));
            Log.e("MicroMsg.AppBrandImgUtil", "OutOfMemoryError e " + e2.getMessage());
            AppMethodBeat.o(107814);
            return null;
        }
    }

    private static boolean a(String str, int i2, int i3, int i4, int i5, Bitmap.CompressFormat compressFormat, int i6, String str2) {
        Bitmap b2;
        int ceil;
        int i7;
        int i8;
        int i9;
        AppMethodBeat.i(107815);
        OutputStream outputStream = null;
        try {
            Log.i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScale, srcWidth: %s, srcHeight: %s, width: %s, height: %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i5), Integer.valueOf(i4));
            BitmapFactory.Options options = new BitmapFactory.Options();
            double d2 = (((double) i3) * 1.0d) / ((double) i4);
            double d3 = (((double) i2) * 1.0d) / ((double) i5);
            if (i2 == i5 && i3 == i4) {
                b2 = b(str, options);
            } else {
                options.inSampleSize = 1;
                if (i3 > i4 || i2 > i5) {
                    options.inSampleSize = (int) (d2 < d3 ? d3 : d2);
                    if (options.inSampleSize <= 1) {
                        options.inSampleSize = 1;
                    }
                }
                while (((i3 * i2) / options.inSampleSize) / options.inSampleSize > 2764800) {
                    options.inSampleSize++;
                }
                Log.i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScale, sampleSize: %s", Integer.valueOf(options.inSampleSize));
                b2 = b(str, options);
            }
            Log.i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScale, result bm: %s", b2);
            if (b2 == null) {
                AppMethodBeat.o(107815);
                return false;
            }
            Log.i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScale, bm.width: %s, bm.height: %s", Integer.valueOf(b2.getWidth()), Integer.valueOf(b2.getHeight()));
            if (d2 < d3) {
                i7 = (int) Math.ceil(((((double) i5) * 1.0d) * ((double) i3)) / ((double) i2));
                ceil = i5;
            } else {
                ceil = (int) Math.ceil(((((double) i4) * 1.0d) * ((double) i2)) / ((double) i3));
                i7 = i4;
            }
            int exifOrientation = BackwardSupportUtil.ExifHelper.getExifOrientation(str);
            if (exifOrientation == 90 || exifOrientation == 270) {
                b2 = BitmapUtil.rotate(b2, (float) exifOrientation);
                i9 = i7;
                i8 = ceil;
            } else {
                i9 = ceil;
                i8 = i7;
            }
            if (exifOrientation == 180) {
                b2 = BitmapUtil.rotate(b2, (float) exifOrientation);
            }
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(b2, i9, i8, true);
            if (createScaledBitmap == null) {
                createScaledBitmap = b2;
            } else if (b2 != createScaledBitmap) {
                l.aRY().x(b2);
            }
            Log.i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScalebyUpload, degree %d, bm.width: %s, bm.height: %s", Integer.valueOf(exifOrientation), Integer.valueOf(createScaledBitmap.getWidth()), Integer.valueOf(createScaledBitmap.getHeight()));
            OutputStream dw = s.dw(str2, false);
            BitmapUtil.saveBitmapToStream(createScaledBitmap, i6, compressFormat, dw, false);
            l.aRY().x(createScaledBitmap);
            dw.close();
            AppMethodBeat.o(107815);
            return true;
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.AppBrandImgUtil", e2, "create thumbnail from orig failed: %s", str2);
            if (0 != 0) {
                try {
                    outputStream.close();
                } catch (IOException e3) {
                }
            }
            AppMethodBeat.o(107815);
            return false;
        }
    }

    public static boolean eN(String str, String str2) {
        AppMethodBeat.i(107816);
        boolean f2 = f(str, str2, -1, -1);
        AppMethodBeat.o(107816);
        return f2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0073 A[SYNTHETIC, Splitter:B:24:0x0073] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x011d A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01ac  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean f(java.lang.String r12, java.lang.String r13, int r14, int r15) {
        /*
        // Method dump skipped, instructions count: 1206
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.utils.d.f(java.lang.String, java.lang.String, int, int):boolean");
    }
}
