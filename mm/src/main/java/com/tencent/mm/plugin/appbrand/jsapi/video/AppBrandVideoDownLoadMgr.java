package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.net.Uri;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.t;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.cdndownloader.h.a;
import com.tencent.mm.s.c;
import com.tencent.mm.s.d;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AppBrandVideoDownLoadMgr {
    public static final String mvD;
    private static HashMap<String, String> mvE = new HashMap<>();
    static final Map<String, a> mvF = new ConcurrentHashMap();
    public static AppBrandVideoDownLoadMgr mvG;
    static d mvH;

    static /* synthetic */ void au(String str, boolean z) {
        AppMethodBeat.i(46860);
        at(str, z);
        AppMethodBeat.o(46860);
    }

    static {
        AppMethodBeat.i(46861);
        mvG = null;
        mvH = null;
        if (mvG == null) {
            mvG = new AppBrandVideoDownLoadMgr();
        }
        String aKJ = b.aKJ();
        if (!aKJ.endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
            aKJ = aKJ + FilePathGenerator.ANDROID_DIR_SEP;
        }
        mvD = aKJ + "wagamefiles/";
        d.a(a.cyi());
        d dVar = new d();
        mvH = dVar;
        dVar.gRe = new c() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoDownLoadMgr.AnonymousClass1 */

            @Override // com.tencent.mm.s.c
            public final void onTaskSucc(String str, String str2, boolean z) {
                AppMethodBeat.i(46850);
                Log.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad downloadVideo onTaskSucc save_path = %s, url = %s, is_resume = %s", str2, str, Boolean.valueOf(z));
                AppBrandVideoDownLoadMgr appBrandVideoDownLoadMgr = AppBrandVideoDownLoadMgr.mvG;
                AppBrandVideoDownLoadMgr.au(str, true);
                if (AppBrandVideoDownLoadMgr.mvF == null || AppBrandVideoDownLoadMgr.mvF.get(str) == null || ((a) AppBrandVideoDownLoadMgr.mvF.get(str)).mvC == null) {
                    Log.e("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad downloadVideo onTaskSucc callback is null");
                    AppMethodBeat.o(46850);
                    return;
                }
                ((a) AppBrandVideoDownLoadMgr.mvF.get(str)).mvC.dN(str, str2);
                AppMethodBeat.o(46850);
            }

            @Override // com.tencent.mm.s.c
            public final void onTaskFail(String str, int i2, boolean z) {
                AppMethodBeat.i(46851);
                Log.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad downloadVideo onTaskFail err_code = %s, url = %s,is_resume = %s", Integer.valueOf(i2), str, Boolean.valueOf(z));
                AppBrandVideoDownLoadMgr appBrandVideoDownLoadMgr = AppBrandVideoDownLoadMgr.mvG;
                AppBrandVideoDownLoadMgr.au(str, false);
                if (AppBrandVideoDownLoadMgr.mvF == null || AppBrandVideoDownLoadMgr.mvF.get(str) == null || ((a) AppBrandVideoDownLoadMgr.mvF.get(str)).mvC == null) {
                    Log.e("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad downloadVideo onTaskFail callback is null");
                    AppMethodBeat.o(46851);
                    return;
                }
                ((a) AppBrandVideoDownLoadMgr.mvF.get(str)).mvC.bO(str, i2);
                AppMethodBeat.o(46851);
            }
        };
        AppMethodBeat.o(46861);
    }

    /* access modifiers changed from: package-private */
    @Keep
    public String genAdFileExist(String str, a aVar) {
        AppMethodBeat.i(46852);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(aVar.url)) {
            Log.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genAdFileExist error source or videoUrl = %s", aVar.url);
            AppMethodBeat.o(46852);
            return null;
        }
        String aaS = aaS(aVar.url);
        if (Util.isNullOrNil(aaS)) {
            Log.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genAdFileExist error urlFileMd5 = %s or videoUrl = %s", aaS, aVar.url);
            AppMethodBeat.o(46852);
            return null;
        } else if (!Util.isNullOrNil(aaR(aaS))) {
            AppMethodBeat.o(46852);
            return "downloading";
        } else {
            String str2 = VQ(str) + aaS + ".gad";
            o oVar = new o(str2);
            String bhK = s.bhK(aa.z(oVar.mUri));
            if (!oVar.exists() || (!aaS.startsWith("unverify") && (bhK == null || !bhK.equalsIgnoreCase(aaS)))) {
                AppMethodBeat.o(46852);
                return null;
            }
            aVar.mvA = 0;
            aVar.mvB = t.a.DownLoaded;
            AppMethodBeat.o(46852);
            return str2;
        }
    }

    /* access modifiers changed from: package-private */
    @Keep
    public String genAdFilePath(String str, a aVar) {
        String str2 = null;
        AppMethodBeat.i(46853);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(aVar.url)) {
            Log.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genAdFilePath error source or videoUrl = %s", aVar.url);
            AppMethodBeat.o(46853);
        } else {
            String aaS = aaS(aVar.url);
            if (Util.isNullOrNil(aaS)) {
                Log.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genAdFilePath error urlFileMd5 = %s or videoUrl = %s", aaS, aVar.url);
                AppMethodBeat.o(46853);
            } else if (!Util.isNullOrNil(aaR(aaS))) {
                AppMethodBeat.o(46853);
            } else {
                aVar.mvz = Util.currentTicks();
                aVar.mvB = t.a.DownLoading;
                str2 = VR(str) + aaS + ".gad";
                synchronized (mvE) {
                    try {
                        mvE.put(aaS, str2);
                    } finally {
                        AppMethodBeat.o(46853);
                    }
                }
            }
        }
        return str2;
    }

    static void at(String str, boolean z) {
        AppMethodBeat.i(46854);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(46854);
            return;
        }
        String aaS = aaS(str);
        synchronized (mvE) {
            try {
                if (mvE.containsKey(aaS)) {
                    mvE.remove(aaS);
                }
            } finally {
                AppMethodBeat.o(46854);
            }
        }
        a aVar = mvF.get(str);
        if (aVar != null) {
            if (aVar.url.equalsIgnoreCase(str) && aVar.mvz > 0) {
                aVar.mvA = Util.ticksToNow(aVar.mvz);
            }
            if (z) {
                aVar.mvB = t.a.DownLoaded;
                AppMethodBeat.o(46854);
                return;
            }
            aVar.mvB = t.a.DownLoadFail;
        }
    }

    private static String aaR(String str) {
        String str2;
        AppMethodBeat.i(46855);
        synchronized (mvE) {
            try {
                if (mvE.containsKey(str)) {
                    str2 = mvE.get(str);
                } else {
                    str2 = null;
                    AppMethodBeat.o(46855);
                }
            } finally {
                AppMethodBeat.o(46855);
            }
        }
        return str2;
    }

    private static String VQ(String str) {
        AppMethodBeat.i(46856);
        String str2 = mvD + str + FilePathGenerator.ANDROID_DIR_SEP;
        AppMethodBeat.o(46856);
        return str2;
    }

    private static String VR(String str) {
        AppMethodBeat.i(46857);
        String VQ = VQ(str);
        FilePathGenerator.checkMkdir(VQ);
        try {
            s.bpa(VQ + FilePathGenerator.NO_MEDIA_FILENAME);
        } catch (Exception e2) {
        }
        AppMethodBeat.o(46857);
        return VQ;
    }

    public final synchronized void report(String str) {
        AppMethodBeat.i(46858);
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad report error videoUrl is nil");
            AppMethodBeat.o(46858);
        } else {
            a aVar = mvF.get(str);
            if (aVar == null || aVar.mvA < 0 || !str.equalsIgnoreCase(aVar.url)) {
                Log.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad report error preLoadCostTime or videoUrl");
                AppMethodBeat.o(46858);
            } else {
                Log.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad report downLoadCostTime = %s,preLoadStatus = %s", Long.valueOf(aVar.mvA), aVar.mvB);
                t tVar = new t();
                tVar.ela = tVar.x("Url", str, true);
                tVar.elb = aVar.mvA;
                tVar.elc = aVar.mvB;
                tVar.bfK();
                AppMethodBeat.o(46858);
            }
        }
    }

    private static String aaS(String str) {
        AppMethodBeat.i(46859);
        String str2 = null;
        try {
            Uri parse = Uri.parse(str);
            if (parse.getHost().equalsIgnoreCase("wxsnsdy.wxs.qq.com")) {
                str2 = parse.getQueryParameter("m");
            } else {
                str2 = "unverify" + MD5Util.getMD5String(str);
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", e2, "leonlad:getUrlFileMd5 failed videoUrl:%s", str);
        }
        AppMethodBeat.o(46859);
        return str2;
    }
}
