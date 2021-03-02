package com.tencent.mm.plugin.appbrand.appcache;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.abe;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ac.h;
import com.tencent.mm.plugin.appbrand.api.e;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import com.tencent.mm.plugin.appbrand.appcache.a.b;
import com.tencent.mm.plugin.appbrand.appcache.ae;
import com.tencent.mm.plugin.appbrand.appcache.j;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.Collection;
import java.util.Set;

public final class bj {
    private static volatile bj kNT = null;
    private final h<String, a> kKy = new h<>();
    public final az kNU = new az();

    public interface a extends b.a<b, WxaPkgLoadProgress> {
    }

    public bj() {
        AppMethodBeat.i(90644);
        AppMethodBeat.o(90644);
    }

    public static bj bwA() {
        AppMethodBeat.i(90645);
        if (((e) g.af(e.class)).bub() == null) {
            kNT = null;
            AppMethodBeat.o(90645);
            return null;
        }
        if (kNT == null) {
            synchronized (bj.class) {
                try {
                    if (kNT == null) {
                        kNT = new bj();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(90645);
                    throw th;
                }
            }
        }
        bj bjVar = kNT;
        AppMethodBeat.o(90645);
        return bjVar;
    }

    public static void shutdown() {
        bj bjVar;
        AppMethodBeat.i(90646);
        synchronized (bj.class) {
            try {
                bjVar = kNT;
                kNT = null;
            } finally {
                AppMethodBeat.o(90646);
            }
        }
        if (bjVar != null) {
            bjVar.kNU.kML.shutdown();
        }
    }

    public static boolean a(String str, int i2, a aVar) {
        AppMethodBeat.i(90647);
        boolean c2 = c("@LibraryAppId", 0, i2, str, aVar);
        AppMethodBeat.o(90647);
        return c2;
    }

    static void a(String str, Collection<a> collection) {
        bj bwA;
        AppMethodBeat.i(230565);
        if (Util.isNullOrNil(str) || collection == null || collection.isEmpty() || (bwA = bwA()) == null) {
            AppMethodBeat.o(230565);
            return;
        }
        bwA.kKy.b(str, collection);
        AppMethodBeat.o(230565);
    }

    static void a(String str, a aVar) {
        bj bwA;
        AppMethodBeat.i(90648);
        if (Util.isNullOrNil(str) || aVar == null || (bwA = bwA()) == null) {
            AppMethodBeat.o(90648);
            return;
        }
        bwA.kKy.r(str, aVar);
        AppMethodBeat.o(90648);
    }

    static Collection<a> Vu(String str) {
        AppMethodBeat.i(230566);
        Collection<a> ah = ah(str, true);
        AppMethodBeat.o(230566);
        return ah;
    }

    private static Collection<a> ah(String str, boolean z) {
        bj bwA;
        AppMethodBeat.i(230567);
        if (Util.isNullOrNil(str) || (bwA = bwA()) == null) {
            AppMethodBeat.o(230567);
            return null;
        }
        if (z) {
            Log.i("MicroMsg.AppBrand.WxaPkgUpdater", "removeCallbacks, key[%s]", str);
        }
        Set<a> cN = bwA.kKy.cN(str);
        AppMethodBeat.o(230567);
        return cN;
    }

    static void cu(String str, String str2) {
        AppMethodBeat.i(90652);
        a(str, str2, b.a.EnumC0543a.ENV_ERR, (b) null);
        AppMethodBeat.o(90652);
    }

    static void a(String str, WxaPkgLoadProgress wxaPkgLoadProgress) {
        Set<a> set;
        bj bwA;
        AppMethodBeat.i(90653);
        Log.i("MicroMsg.AppBrand.WxaPkgUpdater", "hy: urlkey: %s, onProgressUpdate %s", str, wxaPkgLoadProgress);
        if (Util.isNullOrNil(str) || (bwA = bwA()) == null) {
            set = null;
        } else {
            set = bwA.kKy.cM(str);
        }
        if (set != null) {
            for (a aVar : set) {
                if (aVar != null) {
                    aVar.cr(wxaPkgLoadProgress);
                }
            }
            AppMethodBeat.o(90653);
            return;
        }
        Log.d("MicroMsg.AppBrand.WxaPkgUpdater", "callback progress, null callback urlKey = %s", str);
        AppMethodBeat.o(90653);
    }

    static boolean a(com.tencent.mm.plugin.appbrand.appcache.a.a aVar, a aVar2) {
        AppMethodBeat.i(90654);
        if (bwA() == null) {
            Log.e("MicroMsg.AppBrand.WxaPkgUpdater", "startDownloadPkg, get null updater instance!!!");
            AppMethodBeat.o(90654);
            return false;
        } else if (aVar == null) {
            AppMethodBeat.o(90654);
            return false;
        } else {
            a(aVar.JYs, aVar2);
            int c2 = bwA().kNU.c(aVar);
            if (c2 == 0 || c2 == 2) {
                AppMethodBeat.o(90654);
                return true;
            }
            a(aVar.JYs, aVar.appId, b.a.EnumC0543a.ENV_ERR, (b) null);
            AppMethodBeat.o(90654);
            return false;
        }
    }

    private static boolean b(String str, int i2, int i3, String str2, a aVar) {
        com.tencent.mm.plugin.appbrand.appcache.a.a aVar2;
        boolean z;
        AppMethodBeat.i(230568);
        if (bwA() == null) {
            Log.e("MicroMsg.AppBrand.WxaPkgUpdater", "startDownloadPkg, get null updater instance!!!");
            AppMethodBeat.o(230568);
            return false;
        }
        if (!Util.isNullOrNil(str) && !Util.isNullOrNil(str2)) {
            switch (i2) {
                case 0:
                case 6:
                case 12:
                case 13:
                    aVar2 = new ba(str, i2, i3, str2);
                    break;
                case 1:
                case 2:
                case 999:
                    aVar2 = new av(str, str2, i2);
                    break;
                case 10000:
                case 10001:
                case 10002:
                case 10100:
                case 10101:
                case 10102:
                    aVar2 = new br(str2, str, i3, i2);
                    break;
                default:
                    aVar2 = null;
                    break;
            }
        } else {
            aVar2 = null;
        }
        if (aVar2 == null) {
            aVar2 = null;
        } else {
            if ("@LibraryAppId".equals(str)) {
                z = false;
            } else if (i2 != 0) {
                z = false;
            } else {
                z = true;
            }
            aVar2.kOB = z;
        }
        if (aVar2 == null) {
            Log.e("MicroMsg.AppBrand.WxaPkgUpdater", "startDownloadPkg, create Null request, appId %s, pkgType %d, pkgVersion %d, url %s", str, Integer.valueOf(i2), Integer.valueOf(i3), str2);
            AppMethodBeat.o(230568);
            return false;
        }
        boolean a2 = a(aVar2, aVar);
        Log.i("MicroMsg.AppBrand.WxaPkgUpdater", "startDownloadPkg, request.urlKey[%s], ret[%b]", aVar2.JYs, Boolean.valueOf(a2));
        AppMethodBeat.o(230568);
        return a2;
    }

    public static boolean c(String str, int i2, int i3, String str2, a aVar) {
        AppMethodBeat.i(90656);
        boolean b2 = b(str, i2, i3, str2, aVar);
        AppMethodBeat.o(90656);
        return b2;
    }

    public static boolean a(String str, int i2, String str2, a aVar) {
        AppMethodBeat.i(90657);
        boolean c2 = c(str, i2, 1, str2, aVar);
        AppMethodBeat.o(90657);
        return c2;
    }

    public static boolean a(String str, int i2, String str2, a aVar, a.AbstractC0542a aVar2) {
        AppMethodBeat.i(90658);
        if (bwA() == null) {
            Log.e("MicroMsg.AppBrand.WxaPkgUpdater", "startDownloadDebugPkg with keyGen, get null updater instance!!!");
            AppMethodBeat.o(90658);
            return false;
        }
        boolean a2 = a(new av(str, str2, i2, aVar2), aVar);
        AppMethodBeat.o(90658);
        return a2;
    }

    static void a(String str, String str2, b.a.EnumC0543a aVar, b bVar) {
        AppMethodBeat.i(90659);
        Collection<a> ah = ah(str, false);
        if (ah != null) {
            for (a aVar2 : ah) {
                if (aVar2 != null) {
                    aVar2.a(str2, aVar, bVar);
                }
            }
            AppMethodBeat.o(90659);
            return;
        }
        Log.d("MicroMsg.AppBrand.WxaPkgUpdater", "callback, null callback appId = %s", str2);
        AppMethodBeat.o(90659);
    }

    static void a(String str, String str2, b.a.EnumC0543a aVar) {
        AppMethodBeat.i(90660);
        if (bwA() == null) {
            Log.e("MicroMsg.AppBrand.WxaPkgUpdater", "onDownloadFail, get instance null !!!");
            AppMethodBeat.o(90660);
            return;
        }
        a(str, str2, aVar, (b) null);
        AppMethodBeat.o(90660);
    }

    static void a(String str, String str2, String str3, int i2, int i3, ae.a aVar) {
        boolean z;
        AppMethodBeat.i(90661);
        boolean sE = j.a.sE(i3);
        if (bwA() == null) {
            Log.e("MicroMsg.AppBrand.WxaPkgUpdater", "onDownloadComplete, get instance null !!!");
            AppMethodBeat.o(90661);
        } else if (Util.isNullOrNil(str3)) {
            Log.e("MicroMsg.AppBrand.WxaPkgUpdater", "onDownloadComplete, filePath is null or nil");
            a(str, str2, b.a.EnumC0543a.LOCAL_FILE_NOT_FOUND, (b) null);
            aVar.bvn();
            AppMethodBeat.o(90661);
        } else if (!new o(str3).exists()) {
            Log.e("MicroMsg.AppBrand.WxaPkgUpdater", "onDownloadComplete, pkg file not exists");
            a(str, str2, b.a.EnumC0543a.LOCAL_FILE_NOT_FOUND, (b) null);
            aVar.bvn();
            AppMethodBeat.o(90661);
        } else if (((e) g.af(e.class)).bub() == null) {
            Log.e("MicroMsg.AppBrand.WxaPkgUpdater", "onDownloadComplete, WxaPkgStorage is null");
            cu(str, str2);
            AppMethodBeat.o(90661);
        } else {
            int i4 = !sE ? i2 : 1;
            bd a2 = ((e) g.af(e.class)).bub().a(str2, i4, i3, new String[0]);
            if (a2 == null) {
                Log.e("MicroMsg.AppBrand.WxaPkgUpdater", "onDownloadComplete, no manifest record!!! with given appId(%s) version(%d) debugType(%d)", str2, Integer.valueOf(i2), Integer.valueOf(i3));
                a(str, str2, b.a.EnumC0543a.FAILED, (b) null);
                AppMethodBeat.o(90661);
                return;
            }
            aVar.bvo();
            if (!Util.isNullOrNil(str2)) {
                z = a(new o(str3), new String[]{a2.field_versionMd5, a2.field_NewMd5}, str2, "onDownloadComplete");
            } else {
                z = false;
            }
            aVar.gE(z);
            if (!z) {
                s.deleteFile(str3);
                a(str, str2, b.a.EnumC0543a.PKG_INVALID, (b) null);
                AppMethodBeat.o(90661);
                return;
            }
            Log.i("MicroMsg.AppBrand.WxaPkgUpdater", "onDownloadComplete, update ret = %b, appId = %s, debugType = %d, pkgVersion = %d, String filePath = %s", Boolean.valueOf(((e) g.af(e.class)).bub().e(str2, i3, i4, str3)), str2, Integer.valueOf(i3), Integer.valueOf(i4), str3);
            a(str, str2, b.a.EnumC0543a.OK, new b(str2, str3, i2, i3));
            abe abe = new abe();
            abe.eiw.appId = str2;
            abe.eiw.filePath = str3;
            abe.eiw.version = i2;
            abe.eiw.eix = i3;
            abe.eiw.md5 = a2.field_versionMd5;
            EventCenter.instance.publish(abe);
            AppMethodBeat.o(90661);
        }
    }

    public static final class b {
        public final String appId;
        public final int eix;
        public final String filePath;
        public final int version;

        public b(String str, String str2, int i2, int i3) {
            this.appId = str;
            this.filePath = str2;
            this.version = i2;
            this.eix = i3;
        }
    }

    public static boolean a(o oVar, String[] strArr, String str, String str2) {
        AppMethodBeat.i(230569);
        String Vn = WxaPkgIntegrityChecker.Vn(aa.z(oVar.her()));
        for (int i2 = 0; i2 < 2; i2++) {
            String str3 = strArr[i2];
            if (!TextUtils.isEmpty(str3) && str3.equals(Vn)) {
                Log.i("MicroMsg.AppBrand.WxaPkgUpdater", "[%s]verifyPkg, appId[%s] verify ok with checksumMd5[%s]", str2, str, str3);
                AppMethodBeat.o(230569);
                return true;
            }
        }
        Log.e("MicroMsg.AppBrand.WxaPkgUpdater", "[%s]verifyPkg, appId[%s] checksumMd5List[%s] != file.md5[%s]", str2, str, org.apache.commons.b.g.a(strArr, ","), Vn);
        AppMethodBeat.o(230569);
        return false;
    }
}
