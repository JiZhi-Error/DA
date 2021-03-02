package com.tencent.mm.plugin.appbrand.utils;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class c {
    private static final String iIN;
    private static ConcurrentMap<String, Boolean> mJI = new ConcurrentHashMap();
    private static Map<String, List<a>> mJJ = new HashMap();

    public interface a {
        void Wz(String str);
    }

    static {
        AppMethodBeat.i(135346);
        String aKJ = b.aKJ();
        if (!aKJ.endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
            aKJ = aKJ + FilePathGenerator.ANDROID_DIR_SEP;
        }
        String str = aKJ + "wxacache/";
        iIN = str;
        FilePathGenerator.checkMkdir(str);
        AppMethodBeat.o(135346);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.tencent.mm.plugin.appbrand.jsapi.f r7, final java.lang.String r8, final java.lang.String r9, final com.tencent.mm.plugin.appbrand.utils.c.a r10) {
        /*
        // Method dump skipped, instructions count: 202
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.utils.c.a(com.tencent.mm.plugin.appbrand.jsapi.f, java.lang.String, java.lang.String, com.tencent.mm.plugin.appbrand.utils.c$a):void");
    }

    private static void b(a aVar) {
        AppMethodBeat.i(135338);
        if (aVar != null) {
            aVar.Wz(null);
        }
        AppMethodBeat.o(135338);
    }

    private static boolean b(f fVar, String str, String str2, a aVar) {
        AppMethodBeat.i(135339);
        Log.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, url:%s", str);
        if (fVar == null) {
            Log.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, component is null");
            AppMethodBeat.o(135339);
            return false;
        } else if (!(fVar instanceof k)) {
            Log.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, can not get runtime from component");
            AppMethodBeat.o(135339);
            return false;
        } else {
            AppBrandRuntime runtime = ((k) fVar).getRuntime();
            if (runtime == null) {
                Log.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, runtime is null");
                AppMethodBeat.o(135339);
                return false;
            }
            String afG = afG(str);
            Log.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, localPath:%s", afG);
            o oVar = new o(afG);
            if (!oVar.exists()) {
                Bitmap k = z.k(runtime, str);
                if (k == null || k.isRecycled()) {
                    Log.e("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, no bitmap in the given url");
                    AppMethodBeat.o(135339);
                    return false;
                }
                try {
                    BitmapUtil.saveBitmapToImage(k, 100, Bitmap.CompressFormat.PNG, afG, true);
                    if (k != null && !k.isRecycled()) {
                        Log.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "bitmap recycle %s", k);
                        k.recycle();
                    }
                } catch (IOException e2) {
                    Log.e("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, fail to compress bitmap to file", e2);
                    if (k != null && !k.isRecycled()) {
                        Log.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "bitmap recycle %s", k);
                        k.recycle();
                    }
                    AppMethodBeat.o(135339);
                    return false;
                } catch (Throwable th) {
                    if (k != null && !k.isRecycled()) {
                        Log.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "bitmap recycle %s", k);
                        k.recycle();
                    }
                    AppMethodBeat.o(135339);
                    throw th;
                }
            }
            if (!dX(str2, afG)) {
                Log.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, file exists but md5 not valid, deleted:%b", Boolean.valueOf(oVar.delete()));
            } else if (aVar != null) {
                aVar.Wz(afG);
                AppMethodBeat.o(135339);
                return true;
            }
            AppMethodBeat.o(135339);
            return false;
        }
    }

    private static void dW(final String str, final String str2) {
        AppMethodBeat.i(135340);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.utils.c.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(135336);
                c.dY(str, str2);
                AppMethodBeat.o(135336);
            }
        });
        AppMethodBeat.o(135340);
    }

    private static String afG(String str) {
        AppMethodBeat.i(135341);
        String format = String.format("%s%s", iIN, LI(str));
        AppMethodBeat.o(135341);
        return format;
    }

    private static String LI(String str) {
        AppMethodBeat.i(135342);
        String str2 = null;
        if (!Util.isNullOrNil(str)) {
            str2 = g.getMessageDigest(str.getBytes());
        }
        AppMethodBeat.o(135342);
        return str2;
    }

    private static boolean dX(String str, String str2) {
        AppMethodBeat.i(135343);
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "isMd5Valid target nil, no check");
            AppMethodBeat.o(135343);
            return true;
        }
        String md5 = g.getMD5(str2);
        Log.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "isMd5Valid file:%s target:%s", md5, str);
        boolean equals = str.equals(md5);
        AppMethodBeat.o(135343);
        return equals;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x011f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void O(java.lang.String r10, java.lang.String r11, java.lang.String r12) {
        /*
        // Method dump skipped, instructions count: 337
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.utils.c.O(java.lang.String, java.lang.String, java.lang.String):void");
    }

    static /* synthetic */ void dY(String str, String str2) {
        AppMethodBeat.i(135345);
        Log.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "doCallback url:%s, localPath:%s", str, str2);
        List<a> list = mJJ.get(str);
        if (list == null || list.size() == 0) {
            Log.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "doCallback callbacks nil");
            AppMethodBeat.o(135345);
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            list.get(i2).Wz(str2);
        }
        mJJ.remove(str);
        AppMethodBeat.o(135345);
    }
}
