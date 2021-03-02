package com.tencent.mm.plugin.appbrand.appcache;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.api.e;
import com.tencent.mm.plugin.appbrand.appcache.ay;
import com.tencent.mm.plugin.appbrand.appcache.j;
import com.tencent.mm.plugin.appbrand.appstorage.MD5JNI;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import kotlin.g.a.b;

public enum WxaPkgIntegrityChecker {
    ;

    static {
        AppMethodBeat.i(90638);
        WxaPkgWrappingInfo.class.getClassLoader();
        j.Ed("appbrandcommon");
        AppMethodBeat.o(90638);
    }

    public static WxaPkgIntegrityChecker valueOf(String str) {
        AppMethodBeat.i(90629);
        WxaPkgIntegrityChecker wxaPkgIntegrityChecker = (WxaPkgIntegrityChecker) Enum.valueOf(WxaPkgIntegrityChecker.class, str);
        AppMethodBeat.o(90629);
        return wxaPkgIntegrityChecker;
    }

    public enum a {
        APP_READY,
        APP_MANIFEST_NULL,
        PKG_EXPIRED,
        APP_NOT_INSTALLED,
        APP_BROKEN,
        ENV_ERR;

        public static a valueOf(String str) {
            AppMethodBeat.i(90625);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(90625);
            return aVar;
        }

        static {
            AppMethodBeat.i(90627);
            AppMethodBeat.o(90627);
        }

        public final int bwv() {
            AppMethodBeat.i(90626);
            int ordinal = super.ordinal();
            AppMethodBeat.o(90626);
            return ordinal;
        }
    }

    private static WxaPkgWrappingInfo aU(String str, int i2) {
        AppMethodBeat.i(90630);
        if (!"@LibraryAppId".equals(str) || (i2 >= 0 && ay.VERSION < i2)) {
            AppMethodBeat.o(90630);
            return null;
        }
        Log.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "use local library version = %d | query appId = %s, debugType = %d, pkgVersion = %d", Integer.valueOf(ay.VERSION), str, 0, Integer.valueOf(i2));
        WxaPkgWrappingInfo bwf = ay.bwf();
        AppMethodBeat.o(90630);
        return bwf;
    }

    public static Pair<a, WxaPkgWrappingInfo> gJ(boolean z) {
        AppMethodBeat.i(90631);
        Pair<a, WxaPkgWrappingInfo> r = r(z, false);
        AppMethodBeat.o(90631);
        return r;
    }

    public static Pair<a, WxaPkgWrappingInfo> r(boolean z, boolean z2) {
        bh bub;
        AppMethodBeat.i(90632);
        if (z && (!z2 || ay.kMy != ay.a.DEVELOP)) {
            e eVar = (e) g.af(e.class);
            if (eVar == null || (bub = eVar.bub()) == null) {
                Pair<a, WxaPkgWrappingInfo> create = Pair.create(a.APP_READY, ay.bwf());
                AppMethodBeat.o(90632);
                return create;
            }
            int aY = bub.aY("@LibraryAppId", 0);
            WxaPkgWrappingInfo aU = aU("@LibraryAppId", aY);
            if (aU != null) {
                Log.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "checkLibrary, dbMax %d, local %d, use local", Integer.valueOf(aY), Integer.valueOf(ay.VERSION));
                Pair<a, WxaPkgWrappingInfo> create2 = Pair.create(a.APP_READY, aU);
                AppMethodBeat.o(90632);
                return create2;
            }
        }
        Pair<a, WxaPkgWrappingInfo> D = D("@LibraryAppId", z ? 0 : 999, -1);
        Log.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "checkLibrary, release %b, skipLocalDevPack %b, localPackMode %s, checkRecordResult %s", Boolean.valueOf(z), Boolean.valueOf(z2), ay.kMy, D.first);
        AppMethodBeat.o(90632);
        return D;
    }

    public static Pair<a, WxaPkgWrappingInfo> D(final String str, int i2, int i3) {
        bd a2;
        int i4;
        AppMethodBeat.i(90633);
        if (!g.aAf().hpY || ((e) g.af(e.class)).bub() == null) {
            Log.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "get null storage, appId = %s, debugType = %d, version = %d", str, Integer.valueOf(i2), Integer.valueOf(i3));
            Pair<a, WxaPkgWrappingInfo> create = Pair.create(a.ENV_ERR, null);
            AppMethodBeat.o(90633);
            return create;
        }
        String[] strArr = {"pkgPath", "versionMd5", "NewMd5", "version", "createTime", "startTime", "endTime"};
        if (!j.a.vP(i2) || i3 <= 0) {
            a2 = ((e) g.af(e.class)).bub().a(str, i2, strArr);
        } else {
            a2 = ((e) g.af(e.class)).bub().a(str, i3, i2, strArr);
        }
        if (a2 == null) {
            Log.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "get null record, appId = %s, debugType = %d, version = %d", str, Integer.valueOf(i2), Integer.valueOf(i3));
            Pair<a, WxaPkgWrappingInfo> create2 = Pair.create(a.APP_MANIFEST_NULL, null);
            AppMethodBeat.o(90633);
            return create2;
        }
        if (i2 == 999) {
            Log.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "checkPkg for dev_lib, time_scope[%d, %d]", Long.valueOf(a2.field_startTime), Long.valueOf(a2.field_endTime));
            if (a2.field_endTime > 0 && a2.field_endTime <= Util.nowSecond()) {
                Pair<a, WxaPkgWrappingInfo> create3 = Pair.create(a.PKG_EXPIRED, null);
                AppMethodBeat.o(90633);
                return create3;
            }
        }
        String str2 = a2.field_pkgPath;
        if (i3 < 0) {
            i4 = a2.field_version;
        } else {
            i4 = i3;
        }
        long j2 = a2.field_createTime;
        if (Util.isNullOrNil(str2) || !s.YS(str2)) {
            Log.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "file not exists, pkgPath = %s, appId = %s, debugType = %d, version = %d", str2, str, Integer.valueOf(i2), Integer.valueOf(i4));
            Pair<a, WxaPkgWrappingInfo> create4 = Pair.create(a.APP_BROKEN, null);
            AppMethodBeat.o(90633);
            return create4;
        }
        final String Vn = Vn(str2);
        if (!new b<String[], Boolean>() {
            /* class com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ Boolean invoke(String[] strArr) {
                AppMethodBeat.i(230563);
                Boolean n = n(strArr);
                AppMethodBeat.o(230563);
                return n;
            }

            public final Boolean n(String[] strArr) {
                AppMethodBeat.i(230562);
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str) && str.equals(Vn)) {
                        Boolean bool = Boolean.TRUE;
                        AppMethodBeat.o(230562);
                        return bool;
                    }
                }
                Log.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "checkPkg, appId[%s] checksumMd5List[%s] != file.md5[%s]", str, org.apache.commons.b.g.a(strArr, ","), Vn);
                Boolean bool2 = Boolean.FALSE;
                AppMethodBeat.o(230562);
                return bool2;
            }
        }.n(new String[]{a2.field_versionMd5, a2.field_NewMd5}).booleanValue()) {
            Pair<a, WxaPkgWrappingInfo> create5 = Pair.create(a.APP_BROKEN, null);
            AppMethodBeat.o(90633);
            return create5;
        }
        WxaPkgWrappingInfo wxaPkgWrappingInfo = new WxaPkgWrappingInfo();
        wxaPkgWrappingInfo.pkgVersion = i4;
        wxaPkgWrappingInfo.kNX = j2;
        wxaPkgWrappingInfo.pkgPath = str2;
        wxaPkgWrappingInfo.kNY = false;
        wxaPkgWrappingInfo.kNW = i2;
        wxaPkgWrappingInfo.md5 = Vn;
        Log.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "check ok, params: appId = %s, debugType = %d, version = %d, pkgVersion = %d, return %s", str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), wxaPkgWrappingInfo);
        Pair<a, WxaPkgWrappingInfo> create6 = Pair.create(a.APP_READY, wxaPkgWrappingInfo);
        AppMethodBeat.o(90633);
        return create6;
    }

    private static boolean openMD5JNICheck() {
        AppMethodBeat.i(90634);
        boolean a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_appbrand_wxapkg_md5_check_use_jni_openssl, true);
        AppMethodBeat.o(90634);
        return a2;
    }

    private static String n(o oVar) {
        AppMethodBeat.i(176908);
        long currentTicks = Util.currentTicks();
        boolean openMD5JNICheck = openMD5JNICheck();
        try {
            if (!oVar.exists() || oVar.isDirectory()) {
                Log.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "[getFileMD5] fileName[%s] invalid", oVar.getName());
                Log.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "[getFileMD5] fileName[%s] length[%.2fKB] cost[%dms] openJNI[%b]", oVar.getName(), Float.valueOf(((float) oVar.length()) / 1024.0f), Long.valueOf(Util.currentTicks() - currentTicks), Boolean.valueOf(openMD5JNICheck));
                AppMethodBeat.o(176908);
                return null;
            }
            if (openMD5JNICheck) {
                try {
                    String checkFileMD5JNI = checkFileMD5JNI(oVar);
                    Log.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "[getFileMD5] fileName[%s] length[%.2fKB] cost[%dms] openJNI[%b]", oVar.getName(), Float.valueOf(((float) oVar.length()) / 1024.0f), Long.valueOf(Util.currentTicks() - currentTicks), Boolean.valueOf(openMD5JNICheck));
                    AppMethodBeat.o(176908);
                    return checkFileMD5JNI;
                } catch (IOException e2) {
                    Log.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "[getFileMD5] JNI exception = %s", e2);
                    openMD5JNICheck = false;
                }
            }
            String o = o(oVar);
            Log.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "[getFileMD5] fileName[%s] length[%.2fKB] cost[%dms] openJNI[%b]", oVar.getName(), Float.valueOf(((float) oVar.length()) / 1024.0f), Long.valueOf(Util.currentTicks() - currentTicks), Boolean.valueOf(openMD5JNICheck));
            AppMethodBeat.o(176908);
            return o;
        } catch (Throwable th) {
            Log.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "[getFileMD5] fileName[%s] length[%.2fKB] cost[%dms] openJNI[%b]", oVar.getName(), Float.valueOf(((float) oVar.length()) / 1024.0f), Long.valueOf(Util.currentTicks() - currentTicks), Boolean.valueOf(openMD5JNICheck));
            AppMethodBeat.o(176908);
            throw th;
        }
    }

    public static String Vn(String str) {
        AppMethodBeat.i(90635);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(90635);
            return null;
        }
        String n = n(new o(str));
        AppMethodBeat.o(90635);
        return n;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String o(com.tencent.mm.vfs.o r7) {
        /*
            r1 = 0
            r6 = 176909(0x2b30d, float:2.47902E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
            java.io.InputStream r3 = com.tencent.mm.vfs.s.ao(r7)     // Catch:{ IOException -> 0x0031 }
            r0 = 16384(0x4000, float:2.2959E-41)
            java.lang.String r0 = com.tencent.mm.b.g.b(r3, r0)     // Catch:{ Throwable -> 0x001a, all -> 0x004f }
            if (r3 == 0) goto L_0x0016
            r3.close()
        L_0x0016:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
        L_0x0019:
            return r0
        L_0x001a:
            r2 = move-exception
            r0 = 176909(0x2b30d, float:2.47902E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r0)     // Catch:{ all -> 0x0022 }
            throw r2     // Catch:{ all -> 0x0022 }
        L_0x0022:
            r0 = move-exception
        L_0x0023:
            if (r3 == 0) goto L_0x002a
            if (r2 == 0) goto L_0x004b
            r3.close()     // Catch:{ Throwable -> 0x0046 }
        L_0x002a:
            r2 = 176909(0x2b30d, float:2.47902E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            throw r0
        L_0x0031:
            r0 = move-exception
            java.lang.String r2 = "MicroMsg.AppBrandWxaPkgIntegrityChecker"
            java.lang.String r3 = "checkFileMD5Legacy IOException = %s"
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r5 = 0
            r4[r5] = r0
            com.tencent.mm.sdk.platformtools.Log.e(r2, r3, r4)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            r0 = r1
            goto L_0x0019
        L_0x0046:
            r3 = move-exception
            r2.addSuppressed(r3)
            goto L_0x002a
        L_0x004b:
            r3.close()
            goto L_0x002a
        L_0x004f:
            r0 = move-exception
            r2 = r1
            goto L_0x0023
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker.o(com.tencent.mm.vfs.o):java.lang.String");
    }

    private static String checkFileMD5JNI(o oVar) {
        AppMethodBeat.i(176910);
        String[] strArr = new String[1];
        int mD5String = MD5JNI.getMD5String(s.k(aa.z(oVar.her()), false), strArr);
        if (mD5String == 0) {
            String str = strArr[0];
            AppMethodBeat.o(176910);
            return str;
        }
        IOException iOException = new IOException("MD5JNI ret=".concat(String.valueOf(mD5String)));
        AppMethodBeat.o(176910);
        throw iOException;
    }
}
