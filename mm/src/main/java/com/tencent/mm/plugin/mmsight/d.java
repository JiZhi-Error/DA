package com.tencent.mm.plugin.mmsight;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.hardware.Camera;
import android.os.Build;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.model.j;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.ao;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public final class d {
    private static float zsr = 0.01f;
    private static boolean zss = false;
    private static int zst = 0;
    private static int zsu = 0;
    private static ConcurrentHashMap<String, Long> zsv = new ConcurrentHashMap<>();

    static {
        AppMethodBeat.i(89312);
        AppMethodBeat.o(89312);
    }

    public static void a(com.tencent.mm.plugin.mmsight.model.a.d dVar, SightParams sightParams) {
        AppMethodBeat.i(89285);
        String str = sightParams.zsK;
        String str2 = sightParams.zsI;
        String str3 = sightParams.zsJ;
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2) || Util.isNullOrNil(str3)) {
            String aFj = aFj(CaptureMMProxy.getInstance().getAccVideoPath());
            String aFl = aFl(aFj);
            Log.i("MicroMsg.MMSightUtil", "setMMSightRecorderPathDefault, filePath: %s, thumbPath: %s", aFj, aFl);
            dVar.setFilePath(aFj);
            dVar.HA(aFl);
        } else {
            Log.i("MicroMsg.MMSightUtil", "setMMSightRecorderPathByTalker, fileName: %s, filePath: %s, thumbPath: %s", str, str2, str3);
            dVar.setFilePath(str2);
            dVar.HA(str3);
        }
        String subCoreImageFullPath = CaptureMMProxy.getInstance().getSubCoreImageFullPath("capture_" + System.currentTimeMillis());
        Log.i("MicroMsg.MMSightUtil", "captureImagePath %s", subCoreImageFullPath);
        dVar.HB(subCoreImageFullPath);
        AppMethodBeat.o(89285);
    }

    public static String aFj(final String str) {
        AppMethodBeat.i(89286);
        int i2 = zst;
        zst = i2 + 1;
        o oVar = new o(String.format("%s/tempvideo%s.mp4", str, Integer.valueOf(i2)));
        if (oVar.exists()) {
            oVar.delete();
        }
        o oVar2 = new o(aa.z(oVar.her()) + ".remux");
        if (oVar2.exists()) {
            oVar2.delete();
        }
        o oVar3 = new o(oVar.hes() + ".thumb");
        if (oVar3.exists()) {
            oVar3.delete();
        }
        o oVar4 = new o(oVar.hes() + ".soundmp4");
        if (oVar4.exists()) {
            oVar4.delete();
        }
        final int i3 = zst - 3;
        j.aj(new Runnable() {
            /* class com.tencent.mm.plugin.mmsight.d.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(89284);
                for (int i2 = d.zsu; i2 < i3; i2++) {
                    o oVar = new o(String.format("%s/tempvideo%s.mp4", str, Integer.valueOf(i2)));
                    if (oVar.exists()) {
                        oVar.delete();
                    }
                    o oVar2 = new o(aa.z(oVar.her()) + ".remux");
                    if (oVar2.exists()) {
                        oVar2.delete();
                    }
                    o oVar3 = new o(oVar.hes() + ".thumb");
                    if (oVar3.exists()) {
                        oVar3.delete();
                    }
                }
                int unused = d.zsu = Math.max(i3, 0);
                AppMethodBeat.o(89284);
            }
        });
        String z = aa.z(oVar.her());
        AppMethodBeat.o(89286);
        return z;
    }

    public static String aFk(String str) {
        AppMethodBeat.i(89287);
        o oVar = new o(String.format("%s/%s.mp4", str, Long.valueOf(System.currentTimeMillis())));
        if (oVar.exists()) {
            oVar.delete();
        }
        String z = aa.z(oVar.her());
        AppMethodBeat.o(89287);
        return z;
    }

    public static String eK(String str, int i2) {
        AppMethodBeat.i(177006);
        o oVar = new o(String.format("%s/%s.mp4", str, new StringBuilder().append(i2).append(System.currentTimeMillis()).toString()));
        if (oVar.exists()) {
            oVar.delete();
        }
        String z = aa.z(oVar.her());
        AppMethodBeat.o(177006);
        return z;
    }

    public static String aFl(String str) {
        AppMethodBeat.i(89288);
        String str2 = Util.nullAs(str, "") + ".thumb";
        AppMethodBeat.o(89288);
        return str2;
    }

    public static void rb(boolean z) {
        zss = z;
    }

    public static Point gx(Context context) {
        AppMethodBeat.i(89289);
        Point az = ao.az(context);
        if (!zss && ao.aA(context)) {
            az.y -= ao.aD(context);
        }
        AppMethodBeat.o(89289);
        return az;
    }

    public static Point ejr() {
        AppMethodBeat.i(89290);
        Point az = ao.az(MMApplicationContext.getContext());
        AppMethodBeat.o(89290);
        return az;
    }

    public static boolean a(Context context, Point point, boolean z) {
        AppMethodBeat.i(89291);
        Point gx = gx(context);
        float f2 = ((float) gx.y) / ((float) gx.x);
        float f3 = z ? ((float) point.x) / ((float) point.y) : ((float) point.y) / ((float) point.x);
        float abs = Math.abs(f2 - f3);
        Log.i("MicroMsg.MMSightUtil", "checkIfNeedUsePreviewLarge: previewSize: %s, displaySize: %s, displayRatio: %s, previewRatio: %s, diff: %s", point, gx, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(abs));
        if (abs > zsr) {
            AppMethodBeat.o(89291);
            return true;
        }
        AppMethodBeat.o(89291);
        return false;
    }

    public static Point a(Point point, Point point2, boolean z) {
        AppMethodBeat.i(89292);
        Point a2 = a(point, point2, z, false);
        AppMethodBeat.o(89292);
        return a2;
    }

    public static Point a(Point point, Point point2, boolean z, boolean z2) {
        int i2;
        AppMethodBeat.i(89293);
        int i3 = point2.x;
        int i4 = point2.y;
        int i5 = z ? point.y : point.x;
        int i6 = z ? point.x : point.y;
        int i7 = (int) (((float) i3) * (((float) i6) / ((float) i5)));
        if (i7 % 2 != 0) {
            i7--;
        }
        int i8 = (int) ((((float) i5) / ((float) i6)) * ((float) i4));
        if (z2) {
            i2 = gZ(i7, point2.y);
        } else {
            i2 = i7;
        }
        Log.i("MicroMsg.MMSightUtil", "getCropPreviewSizeWithHeight, previewSize: %s, displaySize: %s, width: %s, newHeight: %s makeMediaCodecHappy %s, newWidth: %s, isRoate: %s", point2, point, Integer.valueOf(i3), Integer.valueOf(i2), Boolean.valueOf(z2), Integer.valueOf(i8), Boolean.valueOf(z));
        if (i2 > point2.y || i3 > point2.x) {
            Log.i("MicroMsg.MMSightUtil", "can not adapt to screen");
            AppMethodBeat.o(89293);
            return null;
        }
        Point point3 = new Point(i3, i2);
        AppMethodBeat.o(89293);
        return point3;
    }

    public static Point b(Point point, Point point2, boolean z) {
        AppMethodBeat.i(89294);
        Point b2 = b(point, point2, z, false);
        AppMethodBeat.o(89294);
        return b2;
    }

    public static Point b(Point point, Point point2, boolean z, boolean z2) {
        AppMethodBeat.i(89295);
        int i2 = point2.x;
        int i3 = point2.y;
        int i4 = (int) ((((float) (z ? point.y : point.x)) / ((float) (z ? point.x : point.y))) * ((float) i3));
        if (i4 % 2 != 0) {
            i4++;
        }
        if (z2) {
            i4 = gZ(i4, point2.y);
        }
        Log.i("MicroMsg.MMSightUtil", "getCropPreviewSizeWithHeight, previewSize: %s, displaySize: %s, width: %s, newWidth: %s, makeMediaCodecHappy %s, , isRoate: %s", point2, point, Integer.valueOf(i2), Integer.valueOf(i4), Boolean.valueOf(z2), Boolean.valueOf(z));
        if (i4 <= point2.x) {
            Point point3 = new Point(i4, i3);
            AppMethodBeat.o(89295);
            return point3;
        }
        Log.i("MicroMsg.MMSightUtil", "can not adapt to screen");
        AppMethodBeat.o(89295);
        return null;
    }

    public static String fx(List<Camera.Size> list) {
        AppMethodBeat.i(89296);
        StringBuffer stringBuffer = new StringBuffer();
        for (Camera.Size size : list) {
            stringBuffer.append("size: " + size.height + "," + size.width + ";");
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(89296);
        return stringBuffer2;
    }

    public static String fy(List<Camera.Size> list) {
        AppMethodBeat.i(89297);
        StringBuffer stringBuffer = new StringBuffer();
        for (Camera.Size size : list) {
            stringBuffer.append("size: " + size.height + "," + size.width + " " + ((((double) size.height) * 1.0d) / ((double) size.width)) + "||");
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(89297);
        return stringBuffer2;
    }

    public static String a(Size[] sizeArr) {
        AppMethodBeat.i(89298);
        StringBuffer stringBuffer = new StringBuffer();
        for (Size size : sizeArr) {
            stringBuffer.append("size: " + size.getHeight() + "," + size.getWidth() + " " + ((((double) size.getHeight()) * 1.0d) / ((double) size.getWidth())) + "||");
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(89298);
        return stringBuffer2;
    }

    public static ArrayList<Camera.Size> c(Camera.Parameters parameters) {
        AppMethodBeat.i(89299);
        ArrayList<Camera.Size> arrayList = new ArrayList<>(parameters.getSupportedPreviewSizes());
        Collections.sort(arrayList, new a((byte) 0));
        AppMethodBeat.o(89299);
        return arrayList;
    }

    static class a implements Comparator<Camera.Size> {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(Camera.Size size, Camera.Size size2) {
            Camera.Size size3 = size;
            Camera.Size size4 = size2;
            int i2 = size3.height * size3.width;
            int i3 = size4.height * size4.width;
            if (i3 < i2) {
                return -1;
            }
            if (i3 > i2) {
                return 1;
            }
            return 0;
        }
    }

    public static String aFm(String str) {
        AppMethodBeat.i(89300);
        try {
            String aFm = e.aFm(str);
            AppMethodBeat.o(89300);
            return aFm;
        } catch (Exception e2) {
            Log.e("MicroMsg.MMSightUtil", "getMediaInfo error: %s", e2.getMessage());
            AppMethodBeat.o(89300);
            return null;
        }
    }

    public static String getExportImagePath(String str) {
        AppMethodBeat.i(89301);
        StringBuilder append = new StringBuilder().append(AndroidMediaUtil.getSysCameraDirPath());
        Object[] objArr = new Object[3];
        objArr[0] = WeChatBrands.AppInfo.current().isMainland() ? "wx_camera_" : "w_camera_";
        objArr[1] = Long.valueOf(System.currentTimeMillis());
        objArr[2] = str;
        String sb = append.append(String.format("%s%d.%s", objArr)).toString();
        AppMethodBeat.o(89301);
        return sb;
    }

    public static void aFn(String str) {
        AppMethodBeat.i(89302);
        Log.i("MicroMsg.MMSightUtil", "setTime key %s %s", str, Util.getStack().toString());
        zsv.put(str, Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(89302);
    }

    public static long aFo(String str) {
        AppMethodBeat.i(89303);
        if (zsv.containsKey(str)) {
            long currentTimeMillis = System.currentTimeMillis() - zsv.get(str).longValue();
            AppMethodBeat.o(89303);
            return currentTimeMillis;
        }
        AppMethodBeat.o(89303);
        return 0;
    }

    public static int gy(Context context) {
        double d2;
        AppMethodBeat.i(89304);
        if (Build.VERSION.SDK_INT >= 16) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getMemoryInfo(memoryInfo);
            int i2 = (int) (((double) memoryInfo.totalMem) / 1024.0d);
            AppMethodBeat.o(89304);
            return i2;
        }
        try {
            InputStream openRead = s.openRead("/proc/meminfo");
            try {
                d2 = (double) parseFileForValue("MemTotal", openRead);
                if (d2 > 0.0d) {
                    d2 /= 1024.0d;
                }
                try {
                    openRead.close();
                } catch (IOException e2) {
                }
                int i3 = (int) d2;
                AppMethodBeat.o(89304);
                return i3;
            } catch (Throwable th) {
                openRead.close();
                AppMethodBeat.o(89304);
                throw th;
            }
        } catch (IOException e3) {
            d2 = 0.0d;
        }
    }

    private static int parseFileForValue(String str, InputStream inputStream) {
        AppMethodBeat.i(89305);
        byte[] bArr = new byte[1024];
        try {
            int read = inputStream.read(bArr);
            int i2 = 0;
            while (i2 < read) {
                if (bArr[i2] == 10 || i2 == 0) {
                    if (bArr[i2] == 10) {
                        i2++;
                    }
                    int i3 = i2;
                    while (i3 < read) {
                        int i4 = i3 - i2;
                        if (bArr[i3] != str.charAt(i4)) {
                            continue;
                            break;
                        } else if (i4 == str.length() - 1) {
                            while (i3 < 1024 && bArr[i3] != 10) {
                                if (Character.isDigit(bArr[i3])) {
                                    int i5 = i3 + 1;
                                    while (i5 < 1024 && Character.isDigit(bArr[i5])) {
                                        i5++;
                                    }
                                    int safeParseInt = Util.safeParseInt(new String(bArr, 0, i3, i5 - i3));
                                    AppMethodBeat.o(89305);
                                    return safeParseInt;
                                }
                                i3++;
                            }
                            AppMethodBeat.o(89305);
                            return 0;
                        } else {
                            i3++;
                        }
                    }
                    continue;
                }
                i2++;
            }
        } catch (IOException | NumberFormatException e2) {
        }
        AppMethodBeat.o(89305);
        return 0;
    }

    public static Bitmap ba(String str, long j2) {
        boolean z;
        int i2;
        int i3;
        AppMethodBeat.i(89306);
        if (Util.isNullOrNil(str) || !s.YS(str)) {
            Log.e("MicroMsg.MMSightUtil", "getVideoThumb, %s not exist!!", str);
            AppMethodBeat.o(89306);
            return null;
        }
        Log.i("MicroMsg.MMSightUtil", "getVideoThumb, %s", str);
        if (ae.gKA == null || ae.gKA.gJr != 1) {
            z = true;
        } else {
            z = false;
        }
        try {
            int mp4RotateVFS = SightVideoJNI.getMp4RotateVFS(str);
            if (z) {
                com.tencent.mm.compatible.i.d dVar = new com.tencent.mm.compatible.i.d();
                dVar.setDataSource(s.k(str, false));
                i3 = Util.getInt(dVar.extractMetadata(18), -1);
                int i4 = Util.getInt(dVar.extractMetadata(19), -1);
                Log.i("MicroMsg.MMSightUtil", "getVideoThumb, width: %s, height: %s, rotate: %s", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(mp4RotateVFS));
                Bitmap frameAtTime = dVar.getFrameAtTime(j2, 2);
                Log.i("MicroMsg.MMSightUtil", "retriever.getFrameAtTime finish");
                dVar.release();
                if (frameAtTime != null) {
                    Log.i("MicroMsg.MMSightUtil", "use MediaMetadataRetriever, success! ");
                    AppMethodBeat.o(89306);
                    return frameAtTime;
                }
                i2 = i4;
            } else {
                i2 = 0;
                i3 = 0;
            }
            Log.i("MicroMsg.MMSightUtil", "use MediaMetadataRetriever failed, try ffmpeg");
            if (i3 <= 0 || i2 <= 0) {
                String simpleMp4InfoVFS = SightVideoJNI.getSimpleMp4InfoVFS(str);
                Log.i("MicroMsg.MMSightUtil", "getSimpleMp4Info: %s", simpleMp4InfoVFS);
                JSONObject jSONObject = new JSONObject(simpleMp4InfoVFS);
                i3 = jSONObject.getInt("videoWidth");
                i2 = jSONObject.getInt("videoHeight");
            }
            byte[] videoThumbVFS = MP4MuxerJNI.getVideoThumbVFS(str, i3, i2);
            if (videoThumbVFS == null) {
                Log.e("MicroMsg.MMSightUtil", "getVideoThumb, error, can not get rgb byte!!");
                AppMethodBeat.o(89306);
                return null;
            }
            ByteBuffer wrap = ByteBuffer.wrap(videoThumbVFS);
            Bitmap createBitmap = Bitmap.createBitmap(i3, i2, Bitmap.Config.ARGB_8888);
            createBitmap.copyPixelsFromBuffer(wrap);
            if (mp4RotateVFS > 0) {
                createBitmap = BitmapUtil.rotate(createBitmap, (float) mp4RotateVFS);
            }
            AppMethodBeat.o(89306);
            return createBitmap;
        } catch (Exception e2) {
            Log.e("MicroMsg.MMSightUtil", "get video thumb error!");
            Log.printErrStackTrace("MicroMsg.MMSightUtil", e2, "get video thumb error! %s", e2.getMessage());
            AppMethodBeat.o(89306);
            return null;
        }
    }

    public static Bitmap PF(String str) {
        AppMethodBeat.i(89307);
        Bitmap ba = ba(str, 0);
        AppMethodBeat.o(89307);
        return ba;
    }

    public static byte[] e(byte[] bArr, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        AppMethodBeat.i(89308);
        if (i4 == 0) {
            AppMethodBeat.o(89308);
            return bArr;
        }
        byte[] h2 = k.zwi.h(Integer.valueOf(bArr.length));
        int i9 = i2 * i3;
        boolean z = i4 % TXLiveConstants.RENDER_ROTATION_180 != 0;
        boolean z2 = i4 % 270 != 0;
        boolean z3 = i4 >= 180;
        for (int i10 = 0; i10 < i3; i10++) {
            for (int i11 = 0; i11 < i2; i11++) {
                int i12 = (i10 * i2) + i11;
                int i13 = ((i10 >> 1) * i2) + i9 + (i11 & -2);
                int i14 = i13 + 1;
                if (z) {
                    i5 = i3;
                } else {
                    i5 = i2;
                }
                if (z) {
                    i6 = i2;
                } else {
                    i6 = i3;
                }
                if (z) {
                    i7 = i10;
                } else {
                    i7 = i11;
                }
                if (z) {
                    i8 = i11;
                } else {
                    i8 = i10;
                }
                if (z2) {
                    i7 = (i5 - i7) - 1;
                }
                if (z3) {
                    i8 = (i6 - i8) - 1;
                }
                int i15 = (i8 * i5) + i7;
                int i16 = ((i8 >> 1) * i5) + i9 + (i7 & -2);
                h2[i15] = (byte) (bArr[i12] & 255);
                h2[i16] = (byte) (bArr[i13] & 255);
                h2[i16 + 1] = (byte) (bArr[i14] & 255);
            }
        }
        k.zwi.k(bArr);
        AppMethodBeat.o(89308);
        return h2;
    }

    public static boolean a(int i2, int i3, int i4, PInt pInt, PInt pInt2) {
        int i5;
        int i6;
        boolean z;
        AppMethodBeat.i(89309);
        if (i4 <= 0 || Math.min(i2, i3) <= i4) {
            i5 = i3;
            i6 = i2;
            z = false;
        } else {
            if (i2 < i3) {
                i5 = (int) (((float) i3) / ((((float) i2) * 1.0f) / ((float) i4)));
                i6 = i4;
            } else {
                i6 = (int) (((float) i2) / ((((float) i3) * 1.0f) / ((float) i4)));
                i5 = i4;
            }
            z = true;
        }
        pInt.value = i6;
        pInt2.value = i5;
        Log.d("MicroMsg.MMSightUtil", "check bitmap size result[%b] raw[%d %d] minSize[%d] out[%d %d]", Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value));
        AppMethodBeat.o(89309);
        return z;
    }

    public static int QH(int i2) {
        if (i2 % 16 != 0) {
            while (i2 % 16 != 0) {
                i2++;
            }
        }
        return i2;
    }

    public static boolean QI(int i2) {
        return i2 % 16 == 0;
    }

    public static int QJ(int i2) {
        AppMethodBeat.i(89310);
        int gZ = gZ(i2, Integer.MAX_VALUE);
        AppMethodBeat.o(89310);
        return gZ;
    }

    public static int gZ(int i2, int i3) {
        int i4 = i2 % 16;
        if (i4 == 0) {
            return i2;
        }
        int i5 = (16 - i4) + i2;
        return i5 < i3 ? i5 : i2 - i4;
    }

    public static int QK(int i2) {
        AppMethodBeat.i(89311);
        int i3 = i2 % 32;
        if (i3 == 0) {
            AppMethodBeat.o(89311);
            return i2;
        }
        int min = i2 - Math.min(32, i3);
        if (min < Integer.MAX_VALUE) {
            AppMethodBeat.o(89311);
            return min;
        }
        int i4 = i2 - i3;
        AppMethodBeat.o(89311);
        return i4;
    }
}
