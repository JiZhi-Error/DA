package com.tencent.mm.plugin.scanner.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.wcdb.FileUtils;
import java.io.ByteArrayOutputStream;

public final class f {
    private static final int[] CTG = {480, FileUtils.S_IRWXU, 320, 240};

    public interface a {
        void a(boolean z, byte[] bArr);
    }

    public static byte[] aMR(String str) {
        AppMethodBeat.i(240824);
        byte[] a2 = a(str, -1, null);
        AppMethodBeat.o(240824);
        return a2;
    }

    public static byte[] a(String str, int i2, a aVar) {
        AppMethodBeat.i(240825);
        byte[] bArr = null;
        int[] iArr = CTG;
        int length = iArr.length;
        int i3 = 0;
        while (true) {
            if (i3 < length) {
                bArr = a(str, iArr[i3], i2, aVar);
                if (bArr == null) {
                    break;
                } else if (bArr.length <= 122880) {
                    AppMethodBeat.o(240825);
                    break;
                } else {
                    i3++;
                }
            } else {
                break;
            }
        }
        AppMethodBeat.o(240825);
        return bArr;
    }

    private static byte[] a(String str, int i2, int i3, a aVar) {
        int i4;
        int i5 = -1;
        AppMethodBeat.i(240826);
        try {
            Bitmap fo = fo(str, i2);
            if (fo != null && !fo.isRecycled()) {
                if (Math.min(fo.getWidth(), fo.getHeight()) < i2) {
                    i4 = 100;
                } else {
                    i4 = 70;
                }
                byte[] k = k(fo, i4);
                if (i3 > 0 && i4 == 100 && k != null && k.length > i3) {
                    k = k(fo, 70);
                }
                Object[] objArr = new Object[5];
                objArr[0] = Integer.valueOf(fo.getWidth());
                objArr[1] = Integer.valueOf(fo.getHeight());
                objArr[2] = Integer.valueOf(i4);
                objArr[3] = Integer.valueOf(k != null ? k.length : -1);
                objArr[4] = Integer.valueOf(i2);
                Log.i("MicroMsg.ScanImageCompressUtils", "alvinluo compressImage decode bitmap width: %d, height: %d, firstCompressQuality: %d, data: %d, targetSize: %d", objArr);
                if (k != null && k.length > 122880 && !fo.isRecycled()) {
                    k = k(fo, 50);
                    Object[] objArr2 = new Object[1];
                    if (k != null) {
                        i5 = k.length;
                    }
                    objArr2[0] = Integer.valueOf(i5);
                    Log.i("MicroMsg.ScanImageCompressUtils", "alvinluo compressImage compressed data: %d", objArr2);
                }
                fo.recycle();
                if (aVar != null) {
                    aVar.a(true, k);
                }
                AppMethodBeat.o(240826);
                return k;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ScanImageCompressUtils", e2, "alvinluo compressImage exception", new Object[0]);
        }
        if (aVar != null) {
            aVar.a(false, null);
        }
        AppMethodBeat.o(240826);
        return null;
    }

    private static byte[] k(Bitmap bitmap, int i2) {
        AppMethodBeat.i(240827);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            AppMethodBeat.o(240827);
            return byteArray;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ScanImageCompressUtils", e2, "compressImageByQuality exception", new Object[0]);
            AppMethodBeat.o(240827);
            return null;
        }
    }

    private static Bitmap fo(String str, int i2) {
        int i3;
        int i4;
        AppMethodBeat.i(240828);
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapUtil.decodeFile(str, options);
            int i5 = options.outWidth;
            int i6 = options.outHeight;
            if (i5 > i6) {
                i4 = (int) (((((float) i5) * 1.0f) * ((float) i2)) / ((float) i6));
                i3 = i2;
            } else {
                i3 = (int) (((((float) i6) * 1.0f) * ((float) i2)) / ((float) i5));
                i4 = i2;
            }
            Point point = new Point(i4, i3);
            int i7 = point.x;
            int i8 = point.y;
            options.inSampleSize = BitmapUtil.calculateInSampleSize(options.outWidth, options.outHeight, i7, i8);
            options.inJustDecodeBounds = false;
            Log.i("MicroMsg.ScanImageCompressUtils", "alvinluo resizeImage width: %d, height: %d, targetWidth: %d, targetHeight: %d, sampleSize: %d", Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(options.inSampleSize));
            Bitmap decodeFile = BitmapUtil.decodeFile(str, options);
            if (decodeFile != null && !decodeFile.isRecycled() && decodeFile.getWidth() > i7) {
                decodeFile = BitmapUtil.extractThumbNail(decodeFile, i8, i7, false, true);
            }
            AppMethodBeat.o(240828);
            return decodeFile;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ScanImageCompressUtils", e2, "alvinluo resizeImage exception", new Object[0]);
            AppMethodBeat.o(240828);
            return null;
        }
    }
}
