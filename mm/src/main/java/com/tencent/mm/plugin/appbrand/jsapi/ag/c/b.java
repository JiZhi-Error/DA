package com.tencent.mm.plugin.appbrand.jsapi.ag.c;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.zip.ZipInputStream;

public final class b {
    private static final String iIN;
    private static ConcurrentMap<String, Boolean> mJI = new ConcurrentHashMap();
    private static Map<String, List<a>> mJJ = new HashMap();

    public interface a {
        void Wz(String str);
    }

    static {
        AppMethodBeat.i(139476);
        String aKJ = com.tencent.mm.loader.j.b.aKJ();
        if (!aKJ.endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
            aKJ = aKJ + FilePathGenerator.ANDROID_DIR_SEP;
        }
        String str = aKJ + "wxacache/";
        iIN = str;
        FilePathGenerator.checkMkdir(str);
        AppMethodBeat.o(139476);
    }

    public static void a(f fVar, String str, String str2, a aVar) {
        AppMethodBeat.i(139468);
        a(fVar, str, false, str2, aVar);
        AppMethodBeat.o(139468);
    }

    public static void a(f fVar, String str, boolean z, String str2, a aVar) {
        AppMethodBeat.i(215839);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(215839);
        } else if (aVar == null) {
            AppMethodBeat.o(215839);
        } else {
            if (str.startsWith("wxfile://")) {
                if (!b(fVar, str, z, str2, aVar)) {
                    a(aVar);
                    AppMethodBeat.o(215839);
                    return;
                }
            } else if (str.startsWith(HttpWrapperBase.PROTOCAL_HTTP) || str.startsWith(HttpWrapperBase.PROTOCAL_HTTPS)) {
                d(fVar, str, z, str2, aVar);
                AppMethodBeat.o(215839);
                return;
            } else if (!c(fVar, str, z, str2, aVar)) {
                a(aVar);
            }
            AppMethodBeat.o(215839);
        }
    }

    private static void a(a aVar) {
        AppMethodBeat.i(139469);
        if (aVar != null) {
            aVar.Wz(null);
        }
        AppMethodBeat.o(139469);
    }

    private static boolean b(f fVar, String str, boolean z, String str2, a aVar) {
        AppMethodBeat.i(215840);
        Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "handleWxfile, url:%s", str);
        if (fVar == null) {
            Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "handleWxfile, component is null");
            AppMethodBeat.o(215840);
            return false;
        } else if (z) {
            boolean b2 = b(fVar, str, str2, aVar);
            AppMethodBeat.o(215840);
            return b2;
        } else {
            boolean c2 = c(fVar, str, str2, aVar);
            AppMethodBeat.o(215840);
            return c2;
        }
    }

    private static boolean b(f fVar, String str, String str2, a aVar) {
        Throwable th;
        AppMethodBeat.i(215841);
        f fVar2 = f.mJR;
        o k = f.k(fVar, str);
        if (k == null) {
            AppMethodBeat.o(215841);
            return false;
        }
        InputStream inputStream = null;
        try {
            InputStream Wc = fVar.getFileSystem().Wc(str);
            if (Wc == null) {
                Util.qualityClose(Wc);
                AppMethodBeat.o(215841);
                return false;
            } else if (!d(str2, Wc)) {
                Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "handleWxfileZip, md5 is invalid");
                Util.qualityClose(Wc);
                AppMethodBeat.o(215841);
                return false;
            } else {
                f fVar3 = f.mJR;
                if (!f.F(k)) {
                    Util.qualityClose(Wc);
                    InputStream Wc2 = fVar.getFileSystem().Wc(str);
                    if (Wc2 == null) {
                        Util.qualityClose(Wc2);
                        AppMethodBeat.o(215841);
                        return false;
                    }
                    try {
                        Wc = new ZipInputStream(Wc2);
                        f fVar4 = f.mJR;
                        if (f.a((ZipInputStream) Wc, k) == null) {
                            Util.qualityClose(Wc);
                            AppMethodBeat.o(215841);
                            return false;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = Wc2;
                        Util.qualityClose(inputStream);
                        AppMethodBeat.o(215841);
                        throw th;
                    }
                }
                if (aVar != null) {
                    aVar.Wz(aa.z(k.her()));
                    Util.qualityClose(Wc);
                    AppMethodBeat.o(215841);
                    return true;
                }
                Util.qualityClose(Wc);
                AppMethodBeat.o(215841);
                return false;
            }
        } catch (Throwable th3) {
            th = th3;
            Util.qualityClose(inputStream);
            AppMethodBeat.o(215841);
            throw th;
        }
    }

    private static boolean c(f fVar, String str, String str2, a aVar) {
        AppMethodBeat.i(215842);
        o VY = fVar.getFileSystem().VY(str);
        if (VY == null) {
            AppMethodBeat.o(215842);
            return false;
        }
        if (VY.exists()) {
            String z = aa.z(VY.her());
            Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "handleWxfile, localPath:%s", z);
            if (dX(str2, z) && aVar != null) {
                aVar.Wz(z);
                AppMethodBeat.o(215842);
                return true;
            }
        }
        AppMethodBeat.o(215842);
        return false;
    }

    private static boolean c(f fVar, String str, boolean z, String str2, a aVar) {
        AppMethodBeat.i(215843);
        if (z) {
            boolean d2 = d(fVar, str, str2, aVar);
            AppMethodBeat.o(215843);
            return d2;
        }
        boolean e2 = e(fVar, str, str2, aVar);
        AppMethodBeat.o(215843);
        return e2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean d(com.tencent.mm.plugin.appbrand.jsapi.f r8, java.lang.String r9, java.lang.String r10, com.tencent.mm.plugin.appbrand.jsapi.ag.c.b.a r11) {
        /*
        // Method dump skipped, instructions count: 230
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.ag.c.b.d(com.tencent.mm.plugin.appbrand.jsapi.f, java.lang.String, java.lang.String, com.tencent.mm.plugin.appbrand.jsapi.ag.c.b$a):boolean");
    }

    private static boolean e(f fVar, String str, String str2, a aVar) {
        AppMethodBeat.i(139470);
        Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, url:%s", str);
        AppBrandRuntime H = H(fVar);
        if (H == null) {
            Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, runtime is null");
            AppMethodBeat.o(139470);
            return false;
        }
        String Wd = n.Wd(str);
        if (Util.isNullOrNil(Wd)) {
            Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, url is empty");
            AppMethodBeat.o(139470);
            return false;
        }
        String format = String.format("%s%s", iIN, abM(Wd));
        Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, localPath:%s", format);
        if (!new o(format).exists()) {
            InputStream f2 = bg.f(H, Wd);
            if (f2 != null) {
                try {
                    if (f2.available() > 0) {
                        if (!d(str2, f2)) {
                            Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, md5 is invalid");
                            if (f2 != null) {
                                Util.qualityClose(f2);
                            }
                            AppMethodBeat.o(139470);
                            return false;
                        }
                        Bitmap k = z.k(H, Wd);
                        if (k == null || k.isRecycled()) {
                            Log.e("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, no bitmap in the given url");
                            if (f2 != null) {
                                Util.qualityClose(f2);
                            }
                            AppMethodBeat.o(139470);
                            return false;
                        }
                        try {
                            BitmapUtil.saveBitmapToImage(k, 100, Bitmap.CompressFormat.PNG, format, true);
                            if (k != null && !k.isRecycled()) {
                                Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "bitmap recycle %s", k);
                                k.recycle();
                            }
                            if (f2 != null) {
                                Util.qualityClose(f2);
                            }
                        } catch (IOException e2) {
                            Log.e("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, fail to compress bitmap to file", e2);
                            if (k != null && !k.isRecycled()) {
                                Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "bitmap recycle %s", k);
                                k.recycle();
                            }
                            if (f2 != null) {
                                Util.qualityClose(f2);
                            }
                            AppMethodBeat.o(139470);
                            return false;
                        } catch (Throwable th) {
                            if (k != null && !k.isRecycled()) {
                                Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "bitmap recycle %s", k);
                                k.recycle();
                            }
                            AppMethodBeat.o(139470);
                            throw th;
                        }
                    }
                } catch (Exception e3) {
                    Log.w("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, fail since ".concat(String.valueOf(e3)));
                    if (f2 != null) {
                        Util.qualityClose(f2);
                    }
                    AppMethodBeat.o(139470);
                    return false;
                } catch (Throwable th2) {
                    if (f2 != null) {
                        Util.qualityClose(f2);
                    }
                    AppMethodBeat.o(139470);
                    throw th2;
                }
            }
            Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, stream is illegal");
            if (f2 != null) {
                Util.qualityClose(f2);
            }
            AppMethodBeat.o(139470);
            return false;
        }
        if (aVar != null) {
            aVar.Wz(format);
            AppMethodBeat.o(139470);
            return true;
        }
        AppMethodBeat.o(139470);
        return false;
    }

    private static void d(final f fVar, final String str, final boolean z, final String str2, final a aVar) {
        AppMethodBeat.i(215845);
        Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "handleNetworkFile, url:%s", str);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.ag.c.b.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(139465);
                if (!b.mJJ.containsKey(str)) {
                    b.mJJ.put(str, new ArrayList());
                }
                ((List) b.mJJ.get(str)).add(aVar);
                AppMethodBeat.o(139465);
            }
        });
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.ag.c.b.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(139466);
                if (z) {
                    b.d(fVar, str, str2);
                    AppMethodBeat.o(139466);
                    return;
                }
                b.dY(str, str2);
                AppMethodBeat.o(139466);
            }
        }, "AppBrandLiveFileLoadHelperThread");
        AppMethodBeat.o(215845);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x006d A[Catch:{ Exception -> 0x00b5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x009c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.tencent.mm.vfs.o c(com.tencent.mm.plugin.appbrand.jsapi.f r9, java.lang.String r10, java.lang.String r11) {
        /*
        // Method dump skipped, instructions count: 210
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.ag.c.b.c(com.tencent.mm.plugin.appbrand.jsapi.f, java.lang.String, java.lang.String):com.tencent.mm.vfs.o");
    }

    private static void c(String str, o oVar) {
        Exception e2;
        HttpURLConnection httpURLConnection;
        OutputStream outputStream;
        BufferedInputStream bufferedInputStream;
        Throwable th;
        AppMethodBeat.i(215847);
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                InputStream inputStream = httpURLConnection2.getInputStream();
                outputStream = s.ap(oVar);
                try {
                    bufferedInputStream = new BufferedInputStream(inputStream);
                } catch (Exception e3) {
                    e2 = e3;
                    httpURLConnection = httpURLConnection2;
                    bufferedInputStream = null;
                    try {
                        oVar.delete();
                        Log.printErrStackTrace("MicroMsg.AppBrandLiveFileLoadHelper", e2, "download file url %s ", str);
                        try {
                            httpURLConnection.getInputStream().close();
                        } catch (Exception e4) {
                            Log.e("MicroMsg.AppBrandLiveFileLoadHelper", e4.getMessage());
                        }
                        Util.qualityClose(outputStream);
                        Util.qualityClose(bufferedInputStream);
                        httpURLConnection.disconnect();
                        AppMethodBeat.o(215847);
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            httpURLConnection.getInputStream().close();
                        } catch (Exception e5) {
                            Log.e("MicroMsg.AppBrandLiveFileLoadHelper", e5.getMessage());
                        }
                        Util.qualityClose(outputStream);
                        Util.qualityClose(bufferedInputStream);
                        httpURLConnection.disconnect();
                        AppMethodBeat.o(215847);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    httpURLConnection = httpURLConnection2;
                    bufferedInputStream = null;
                    httpURLConnection.getInputStream().close();
                    Util.qualityClose(outputStream);
                    Util.qualityClose(bufferedInputStream);
                    httpURLConnection.disconnect();
                    AppMethodBeat.o(215847);
                    throw th;
                }
            } catch (Exception e6) {
                e2 = e6;
                httpURLConnection = httpURLConnection2;
                outputStream = null;
                bufferedInputStream = null;
                oVar.delete();
                Log.printErrStackTrace("MicroMsg.AppBrandLiveFileLoadHelper", e2, "download file url %s ", str);
                httpURLConnection.getInputStream().close();
                Util.qualityClose(outputStream);
                Util.qualityClose(bufferedInputStream);
                httpURLConnection.disconnect();
                AppMethodBeat.o(215847);
            } catch (Throwable th4) {
                th = th4;
                httpURLConnection = httpURLConnection2;
                outputStream = null;
                bufferedInputStream = null;
                httpURLConnection.getInputStream().close();
                Util.qualityClose(outputStream);
                Util.qualityClose(bufferedInputStream);
                httpURLConnection.disconnect();
                AppMethodBeat.o(215847);
                throw th;
            }
            try {
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = bufferedInputStream.read(bArr, 0, 16384);
                    if (read == -1) {
                        break;
                    }
                    outputStream.write(bArr, 0, read);
                }
                outputStream.flush();
                try {
                    httpURLConnection2.getInputStream().close();
                } catch (Exception e7) {
                    Log.e("MicroMsg.AppBrandLiveFileLoadHelper", e7.getMessage());
                }
                Util.qualityClose(outputStream);
                Util.qualityClose(bufferedInputStream);
                httpURLConnection2.disconnect();
                AppMethodBeat.o(215847);
            } catch (Exception e8) {
                e2 = e8;
                httpURLConnection = httpURLConnection2;
                oVar.delete();
                Log.printErrStackTrace("MicroMsg.AppBrandLiveFileLoadHelper", e2, "download file url %s ", str);
                httpURLConnection.getInputStream().close();
                Util.qualityClose(outputStream);
                Util.qualityClose(bufferedInputStream);
                httpURLConnection.disconnect();
                AppMethodBeat.o(215847);
            } catch (Throwable th5) {
                th = th5;
                httpURLConnection = httpURLConnection2;
                httpURLConnection.getInputStream().close();
                Util.qualityClose(outputStream);
                Util.qualityClose(bufferedInputStream);
                httpURLConnection.disconnect();
                AppMethodBeat.o(215847);
                throw th;
            }
        } catch (Exception e9) {
            e2 = e9;
            httpURLConnection = null;
            outputStream = null;
            bufferedInputStream = null;
            oVar.delete();
            Log.printErrStackTrace("MicroMsg.AppBrandLiveFileLoadHelper", e2, "download file url %s ", str);
            httpURLConnection.getInputStream().close();
            Util.qualityClose(outputStream);
            Util.qualityClose(bufferedInputStream);
            httpURLConnection.disconnect();
            AppMethodBeat.o(215847);
        } catch (Throwable th6) {
            th = th6;
            httpURLConnection = null;
            outputStream = null;
            bufferedInputStream = null;
            httpURLConnection.getInputStream().close();
            Util.qualityClose(outputStream);
            Util.qualityClose(bufferedInputStream);
            httpURLConnection.disconnect();
            AppMethodBeat.o(215847);
            throw th;
        }
    }

    private static void dW(final String str, final String str2) {
        AppMethodBeat.i(139471);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.ag.c.b.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(139467);
                b.dZ(str, str2);
                AppMethodBeat.o(139467);
            }
        });
        AppMethodBeat.o(139471);
    }

    private static String abM(String str) {
        AppMethodBeat.i(215848);
        String str2 = null;
        if (!Util.isNullOrNil(str)) {
            str2 = g.getMessageDigest(str.getBytes());
        }
        AppMethodBeat.o(215848);
        return str2;
    }

    private static boolean dX(String str, String str2) {
        AppMethodBeat.i(139473);
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "isMd5Valid target nil, no check");
            AppMethodBeat.o(139473);
            return true;
        }
        String md5 = g.getMD5(str2);
        Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "isMd5Valid file:%s target:%s", md5, str);
        boolean equals = str.equals(md5);
        AppMethodBeat.o(139473);
        return equals;
    }

    private static boolean d(String str, InputStream inputStream) {
        AppMethodBeat.i(215849);
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "isMd5Valid target nil, no check");
            AppMethodBeat.o(215849);
            return true;
        }
        String b2 = g.b(inputStream, 4096);
        Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "isMd5Valid file:%s target:%s", b2, str);
        boolean equals = str.equals(b2);
        AppMethodBeat.o(215849);
        return equals;
    }

    private static AppBrandRuntime H(f fVar) {
        AppBrandRuntime appBrandRuntime = null;
        AppMethodBeat.i(215850);
        if (fVar == null) {
            Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "getRuntime, component is null");
            AppMethodBeat.o(215850);
        } else if (!(fVar instanceof k)) {
            Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "getRuntime, can not get runtime from component");
            AppMethodBeat.o(215850);
        } else {
            appBrandRuntime = ((k) fVar).getRuntime();
            if (appBrandRuntime == null) {
                Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "getRuntime, runtime is null");
            }
            AppMethodBeat.o(215850);
        }
        return appBrandRuntime;
    }

    static /* synthetic */ void d(f fVar, String str, String str2) {
        AppMethodBeat.i(215851);
        if (mJI.containsKey(str)) {
            Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "download ing: %s", str);
            AppMethodBeat.o(215851);
            return;
        }
        mJI.put(str, Boolean.TRUE);
        o c2 = c(fVar, str, str2);
        mJI.remove(str);
        if (c2 != null) {
            dW(str, aa.z(c2.her()));
            AppMethodBeat.o(215851);
            return;
        }
        dW(str, null);
        AppMethodBeat.o(215851);
    }

    static /* synthetic */ void dY(String str, String str2) {
        AppMethodBeat.i(139475);
        String format = String.format("%s%s", iIN, abM(str));
        Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "handleNetworkFile, localPath:%s", format);
        o oVar = new o(format);
        if (oVar.exists()) {
            Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "download already exists: %s", str);
            if (dX(str2, format)) {
                dW(str, format);
                AppMethodBeat.o(139475);
                return;
            }
            Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "download already exists, but md5 not valid. deleted:%b", Boolean.valueOf(oVar.delete()));
        }
        if (mJI.containsKey(str)) {
            Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "download ing: %s", str);
            AppMethodBeat.o(139475);
            return;
        }
        mJI.put(str, Boolean.TRUE);
        c(str, oVar);
        Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "download done");
        mJI.remove(str);
        if (dX(str2, format)) {
            dW(str, format);
            AppMethodBeat.o(139475);
            return;
        }
        Log.w("MicroMsg.AppBrandLiveFileLoadHelper", "download md5 not valid");
        dW(str, null);
        AppMethodBeat.o(139475);
    }

    static /* synthetic */ void dZ(String str, String str2) {
        AppMethodBeat.i(215852);
        Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "doCallback url:%s, localPath:%s", str, str2);
        List<a> list = mJJ.get(str);
        if (list == null || list.size() == 0) {
            Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "doCallback callbacks nil");
            AppMethodBeat.o(215852);
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            list.get(i2).Wz(str2);
        }
        mJJ.remove(str);
        AppMethodBeat.o(215852);
    }
}
