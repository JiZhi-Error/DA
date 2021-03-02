package com.tencent.mm.plugin.appbrand.appcache;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.luggage.sdk.g.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.j;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.fch;
import com.tencent.mm.protocal.protobuf.fcs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.vfs.s;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public final class bh implements j {
    public static final String[] kNI = {MAutoStorage.getCreateSQLs(bd.iBg, "AppBrandWxaPkgManifestRecord")};
    public final ISQLiteDatabaseEx kNJ;
    public final b kNK;

    static /* synthetic */ Object a(bh bhVar, kotlin.g.a.a aVar) {
        AppMethodBeat.i(229816);
        Object r = bhVar.r(aVar);
        AppMethodBeat.o(229816);
        return r;
    }

    static /* synthetic */ boolean a(bh bhVar, bd bdVar) {
        AppMethodBeat.i(229817);
        boolean c2 = bhVar.c(bdVar);
        AppMethodBeat.o(229817);
        return c2;
    }

    static {
        AppMethodBeat.i(146044);
        AppMethodBeat.o(146044);
    }

    public enum a {
        DESC,
        ASC;

        public static a valueOf(String str) {
            AppMethodBeat.i(146010);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(146010);
            return aVar;
        }

        static {
            AppMethodBeat.i(146011);
            AppMethodBeat.o(146011);
        }
    }

    public bh(ISQLiteDatabaseEx iSQLiteDatabaseEx) {
        AppMethodBeat.i(146012);
        this.kNJ = iSQLiteDatabaseEx;
        this.kNK = new b(iSQLiteDatabaseEx);
        AppMethodBeat.o(146012);
    }

    public final int[] Vs(String str) {
        AppMethodBeat.i(263564);
        int[] Vt = Vt(str);
        AppMethodBeat.o(263564);
        return Vt;
    }

    public final int[] Vt(String str) {
        AppMethodBeat.i(146014);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(146014);
            return null;
        } else if (!j.a.vP(0)) {
            AppMethodBeat.o(146014);
            return null;
        } else {
            List<bd> a2 = a(str, 0, a.DESC, "version");
            if (Util.isNullOrNil(a2)) {
                AppMethodBeat.o(146014);
                return null;
            }
            int[] iArr = new int[a2.size()];
            int i2 = 0;
            for (bd bdVar : a2) {
                iArr[i2] = bdVar.field_version;
                i2++;
            }
            AppMethodBeat.o(146014);
            return iArr;
        }
    }

    /* access modifiers changed from: package-private */
    public final List<bd> a(String str, int i2, a aVar, String... strArr) {
        AppMethodBeat.i(146015);
        if (Util.isNullOrNil(str)) {
            List<bd> emptyList = Collections.emptyList();
            AppMethodBeat.o(146015);
            return emptyList;
        }
        Cursor query = this.kNJ.query("AppBrandWxaPkgManifestRecord", strArr, String.format(Locale.US, "%s=? and %s=? ", "appId", "debugType"), new String[]{str, String.valueOf(i2)}, null, null, "version " + aVar.name(), 2);
        if (query == null) {
            List<bd> emptyList2 = Collections.emptyList();
            AppMethodBeat.o(146015);
            return emptyList2;
        } else if (!query.moveToFirst()) {
            query.close();
            List<bd> emptyList3 = Collections.emptyList();
            AppMethodBeat.o(146015);
            return emptyList3;
        } else {
            LinkedList linkedList = new LinkedList();
            do {
                bd bdVar = new bd();
                bdVar.convertFrom(query);
                bdVar.field_appId = str;
                bdVar.field_debugType = i2;
                linkedList.add(bdVar);
            } while (query.moveToNext());
            query.close();
            AppMethodBeat.o(146015);
            return linkedList;
        }
    }

    /* access modifiers changed from: package-private */
    public final List<bd> b(String str, int i2, a aVar, String... strArr) {
        AppMethodBeat.i(146016);
        if (Util.isNullOrNil(str)) {
            List<bd> emptyList = Collections.emptyList();
            AppMethodBeat.o(146016);
            return emptyList;
        }
        Cursor query = this.kNJ.query("AppBrandWxaPkgManifestRecord", strArr, String.format(Locale.US, "%s=? and %s=? ", "appId", "version"), new String[]{str, String.valueOf(i2)}, null, null, "version " + aVar.name(), 2);
        if (query == null) {
            List<bd> emptyList2 = Collections.emptyList();
            AppMethodBeat.o(146016);
            return emptyList2;
        } else if (!query.moveToFirst()) {
            query.close();
            List<bd> emptyList3 = Collections.emptyList();
            AppMethodBeat.o(146016);
            return emptyList3;
        } else {
            LinkedList linkedList = new LinkedList();
            do {
                bd bdVar = new bd();
                bdVar.convertFrom(query);
                bdVar.field_appId = str;
                bdVar.field_version = i2;
                linkedList.add(bdVar);
            } while (query.moveToNext());
            query.close();
            AppMethodBeat.o(146016);
            return linkedList;
        }
    }

    public final bd a(String str, int i2, int i3, String... strArr) {
        bd bdVar = null;
        AppMethodBeat.i(146017);
        StringBuilder sb = new StringBuilder();
        for (String str2 : bd.kNu) {
            sb.append(str2).append("=? and ");
        }
        sb.append("1=1");
        if (j.a.sE(i3)) {
            i2 = 1;
        }
        Cursor query = this.kNJ.query("AppBrandWxaPkgManifestRecord", Util.isNullOrNil(strArr) ? null : strArr, sb.toString(), new String[]{str, String.valueOf(i2), String.valueOf(i3)}, null, null, null, 2);
        if (query == null) {
            AppMethodBeat.o(146017);
        } else {
            if (query.moveToFirst()) {
                bdVar = new bd();
                bdVar.convertFrom(query);
                bdVar.field_appId = str;
                if (i2 > 0) {
                    bdVar.field_version = i2;
                }
            }
            query.close();
            AppMethodBeat.o(146017);
        }
        return bdVar;
    }

    public final bd a(String str, int i2, String... strArr) {
        String str2;
        String format;
        String[] strArr2;
        String[] strArr3;
        bd bdVar = null;
        AppMethodBeat.i(146018);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(146018);
        } else {
            if (j.a.vP(i2)) {
                str2 = "version desc";
                format = String.format(Locale.US, "%s=? and %s=?", "appId", "debugType");
                strArr2 = new String[]{str, String.valueOf(i2)};
            } else if (j.a.sE(i2)) {
                str2 = "createTime desc";
                format = String.format(Locale.US, "%s=? and %s=? and %s=?", "appId", "debugType", "version");
                strArr2 = new String[]{str, String.valueOf(i2), "1"};
            } else {
                RuntimeException runtimeException = new RuntimeException("Illegal pkgType ".concat(String.valueOf(i2)));
                AppMethodBeat.o(146018);
                throw runtimeException;
            }
            ISQLiteDatabaseEx iSQLiteDatabaseEx = this.kNJ;
            if (Util.isNullOrNil(strArr)) {
                strArr3 = null;
            } else {
                strArr3 = strArr;
            }
            Cursor query = iSQLiteDatabaseEx.query("AppBrandWxaPkgManifestRecord", strArr3, format, strArr2, null, null, str2);
            if (query == null) {
                AppMethodBeat.o(146018);
            } else {
                if (query.moveToFirst()) {
                    bdVar = new bd();
                    bdVar.convertFrom(query);
                    bdVar.field_appId = str;
                    bdVar.field_debugType = i2;
                }
                query.close();
                AppMethodBeat.o(146018);
            }
        }
        return bdVar;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(fch fch, PInt pInt) {
        AppMethodBeat.i(146020);
        if (fch.version < 0 || Util.isNullOrNil(fch.url) || Util.isNullOrNil(fch.md5)) {
            Log.e("MicroMsg.AppBrandWxaPkgStorage", "flushLibPkgVersionInfo, invalid resp: version( %d ), url( %s ), md5( %s )", Integer.valueOf(fch.version), fch.url, fch.md5);
            AppMethodBeat.o(146020);
            return false;
        }
        if (fch.MKJ > 0) {
            int delete = this.kNJ.delete("AppBrandWxaPkgManifestRecord", String.format("%s=? and %s=? and %s>?", "appId", "debugType", "version"), new String[]{"@LibraryAppId", AppEventsConstants.EVENT_PARAM_VALUE_NO, String.valueOf(fch.version)});
            Log.i("MicroMsg.AppBrandWxaPkgStorage", "flushLibPkgVersionInfo, delete manifest.version > %d, ret = %d", Integer.valueOf(fch.version), Integer.valueOf(delete));
            pInt.value = delete;
        }
        boolean d2 = d("@LibraryAppId", 0, fch.version, fch.md5, fch.url);
        AppMethodBeat.o(146020);
        return d2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.tencent.mm.plugin.appbrand.appcache.bd> a(com.tencent.mm.plugin.appbrand.appcache.ad r12, int r13, com.tencent.mm.plugin.appbrand.appcache.bh.a r14) {
        /*
        // Method dump skipped, instructions count: 199
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.appcache.bh.a(com.tencent.mm.plugin.appbrand.appcache.ad, int, com.tencent.mm.plugin.appbrand.appcache.bh$a):java.util.List");
    }

    public final boolean aW(String str, int i2) {
        AppMethodBeat.i(146022);
        if (Util.isNullOrNil(str) || i2 < 0) {
            AppMethodBeat.o(146022);
            return false;
        }
        Cursor query = this.kNJ.query("AppBrandWxaPkgManifestRecord", new String[]{"version"}, String.format(Locale.US, "%s=? and %s=?", "appId", "debugType"), new String[]{str, String.valueOf(i2)}, null, null, null, 2);
        if (query == null) {
            AppMethodBeat.o(146022);
            return false;
        }
        boolean moveToFirst = query.moveToFirst();
        query.close();
        AppMethodBeat.o(146022);
        return moveToFirst;
    }

    public final boolean a(String str, int i2, String str2, String str3, long j2, long j3) {
        AppMethodBeat.i(146023);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.AppBrandWxaPkgStorage", "flushWxaDebugAppVersionInfo, null or nil appId");
            AppMethodBeat.o(146023);
            return false;
        }
        Log.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaDebugAppVersionInfo, appId %s, type %d, url %s, md5 %s, lifespan[%d, %d]", str, Integer.valueOf(i2), str2, str3, Long.valueOf(j2), Long.valueOf(j3));
        if (i2 == 999) {
            str = "@LibraryAppId";
        }
        bd a2 = a(str, 1, i2, new String[0]);
        if (a2 == null) {
            bd bdVar = new bd();
            bdVar.field_appId = str;
            bdVar.field_version = 1;
            bdVar.field_debugType = i2;
            bdVar.field_downloadURL = str2;
            bdVar.field_versionMd5 = str3;
            bdVar.field_startTime = j2;
            bdVar.field_endTime = j3;
            bdVar.field_createTime = Util.nowSecond();
            d(bdVar);
            AppMethodBeat.o(146023);
            return true;
        }
        boolean z = !Util.isNullOrNil(str3) && !Util.isNullOrNil(a2.field_versionMd5) && !str3.equals(a2.field_versionMd5);
        boolean z2 = !Util.nullAsNil(str2).equals(Util.nullAsNil(a2.field_downloadURL));
        if (z) {
            a2.field_downloadURL = str2;
            s.deleteFile(a2.field_pkgPath);
            a2.field_pkgPath = null;
            a2.field_createTime = Util.nowSecond();
            a2.field_versionMd5 = str3;
            a2.field_startTime = j2;
            a2.field_endTime = j3;
            a2.field_createTime = Util.nowSecond();
            e(a2);
            if (Util.isNullOrNil(str.split("$"))) {
                G(str, i2, 1);
            }
            AppMethodBeat.o(146023);
            return true;
        } else if (z2) {
            a2.field_downloadURL = str2;
            a2.field_startTime = j2;
            a2.field_endTime = j3;
            e(a2);
            AppMethodBeat.o(146023);
            return false;
        } else {
            AppMethodBeat.o(146023);
            return false;
        }
    }

    public final boolean a(bd bdVar) {
        AppMethodBeat.i(146024);
        boolean z = !Util.isNullOrNil(bdVar.field_appId) && this.kNK.delete(bdVar, bd.kNu);
        if (z) {
            G(bdVar.field_appId, bdVar.field_debugType, bdVar.field_version);
        }
        AppMethodBeat.o(146024);
        return z;
    }

    public final String aX(String str, int i2) {
        AppMethodBeat.i(146026);
        bd a2 = a(str, i2, "downloadURL");
        if (a2 == null) {
            AppMethodBeat.o(146026);
            return "";
        }
        String str2 = a2.field_downloadURL;
        AppMethodBeat.o(146026);
        return str2;
    }

    public final int aY(String str, int i2) {
        AppMethodBeat.i(146027);
        if (Util.isNullOrNil(str) || !j.a.vP(i2)) {
            AppMethodBeat.o(146027);
            return 0;
        }
        bd a2 = a(str, i2, "version");
        if (a2 == null) {
            AppMethodBeat.o(146027);
            return 0;
        }
        int i3 = a2.field_version;
        AppMethodBeat.o(146027);
        return i3;
    }

    public final boolean d(String str, int i2, int i3, String str2, String str3) {
        boolean z;
        AppMethodBeat.i(146028);
        if (!j.a.vP(i2)) {
            AppMethodBeat.o(146028);
            return false;
        }
        Log.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo for release, appId %s, type %d, version %d, md5 %s, url %s", str, Integer.valueOf(i2), Integer.valueOf(i3), str2, str3);
        if (!"@LibraryAppId".equals(str) || i3 != ay.VERSION) {
            bd a2 = a(str, i3, i2, new String[0]);
            boolean z2 = false;
            if (a2 == null) {
                bd bdVar = new bd();
                bdVar.field_appId = str;
                bdVar.field_version = i3;
                bdVar.field_versionMd5 = str2;
                bdVar.field_NewMd5 = null;
                bdVar.field_downloadURL = str3;
                bdVar.field_debugType = i2;
                boolean d2 = d(bdVar);
                Log.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo, insert record %b, appId %s, version %d, url %s, md5 %s", Boolean.valueOf(d2), str, Integer.valueOf(bdVar.field_version), bdVar.field_downloadURL, bdVar.field_versionMd5);
                AppMethodBeat.o(146028);
                return d2;
            }
            String str4 = a2.field_downloadURL;
            String str5 = a2.field_versionMd5;
            if (!Util.nullAsNil(a2.field_versionMd5).equals(str2)) {
                a2.field_versionMd5 = str2;
                a2.field_NewMd5 = null;
                a2.field_version = i3;
                a2.field_downloadURL = str3;
                z = true;
            } else if (Util.isNullOrNil(str3) || str3.equals(a2.field_downloadURL)) {
                z = false;
            } else {
                a2.field_downloadURL = str3;
                z = true;
            }
            if (z) {
                z2 = e(a2);
            }
            Object[] objArr = new Object[8];
            objArr[0] = Boolean.valueOf(z && z2);
            objArr[1] = str;
            objArr[2] = Integer.valueOf(i3);
            objArr[3] = Integer.valueOf(i3);
            objArr[4] = str4;
            objArr[5] = str3;
            objArr[6] = str5;
            objArr[7] = str2;
            Log.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo, update record %b, appId %s, oldVersion %d, newVersion %d, oldURL %s, newURL %s, oldMd5 %s, newMd5 %s", objArr);
            if (!z || !z2) {
                AppMethodBeat.o(146028);
                return false;
            }
            AppMethodBeat.o(146028);
            return true;
        }
        Log.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo, given version == local library version %d, skip", Integer.valueOf(ay.VERSION));
        AppMethodBeat.o(146028);
        return false;
    }

    public final boolean a(String str, fcs fcs, int i2) {
        AppMethodBeat.i(146029);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.AppBrandWxaPkgStorage", "flushWxaAppVersionInfo, args invalid appId = %s, vInfo = %s", str, fcs);
            AppMethodBeat.o(146029);
            return false;
        }
        boolean d2 = d(str, i2, fcs.KSa, fcs.NyE, fcs.NyF);
        AppMethodBeat.o(146029);
        return d2;
    }

    public final boolean r(String str, int i2, String str2) {
        AppMethodBeat.i(146030);
        boolean d2 = d(str, 0, i2, str2, null);
        AppMethodBeat.o(146030);
        return d2;
    }

    public final boolean a(final String str, final WxaAttributes.WxaVersionInfo wxaVersionInfo) {
        AppMethodBeat.i(229812);
        final AnonymousClass1 r0 = new kotlin.g.a.a<Boolean>() {
            /* class com.tencent.mm.plugin.appbrand.appcache.bh.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ Boolean invoke() {
                AppMethodBeat.i(182781);
                if (Util.isNullOrNil(str) || wxaVersionInfo == null) {
                    Log.e("MicroMsg.AppBrandWxaPkgStorage", "flushWxaAppVersionInfoV2, args invalid appId = %s, vInfo = %s", str, wxaVersionInfo);
                    Boolean bool = Boolean.FALSE;
                    AppMethodBeat.o(182781);
                    return bool;
                }
                bh.this.a(str, 0, wxaVersionInfo.appVersion, wxaVersionInfo.moduleList);
                bh.this.be(wxaVersionInfo.lgV);
                if (!Util.isNullOrNil(wxaVersionInfo.lha) && wxaVersionInfo.lgV != null && wxaVersionInfo.lgV.size() > 0) {
                    bh.this.b(str, ModulePkgInfo.MODULE_WITHOUT_PLUGIN_CODE, wxaVersionInfo.appVersion, 0, wxaVersionInfo.lha, 12);
                }
                bh.this.a(str, wxaVersionInfo.appVersion, 0, "", wxaVersionInfo.jmL);
                Boolean valueOf = Boolean.valueOf(bh.this.d(str, 0, wxaVersionInfo.appVersion, wxaVersionInfo.lgS, null));
                AppMethodBeat.o(182781);
                return valueOf;
            }
        };
        boolean booleanValue = ((Boolean) Objects.requireNonNull(c.a("flushWxaAppVersionInfoV2 ".concat(String.valueOf(str)), new kotlin.g.a.a<Boolean>() {
            /* class com.tencent.mm.plugin.appbrand.appcache.bh.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ Boolean invoke() {
                AppMethodBeat.i(229808);
                Boolean bool = (Boolean) bh.a(bh.this, r0);
                AppMethodBeat.o(229808);
                return bool;
            }
        }))).booleanValue();
        AppMethodBeat.o(229812);
        return booleanValue;
    }

    public final void b(String str, String str2, int i2, int i3, String str3, int i4) {
        AppMethodBeat.i(146032);
        if (Util.isNullOrNil(str3)) {
            Log.e("MicroMsg.AppBrandWxaPkgStorage", "updateWithoutPluginCodeInfo withoutLibMd5 null appid:%s,modulename:%s!", str, str2);
            AppMethodBeat.o(146032);
            return;
        }
        String adVar = new ad(str, str2, i4).toString();
        if (i3 == 0) {
            d(adVar, i3, i2, str3, null);
            AppMethodBeat.o(146032);
            return;
        }
        a(adVar, i3, "", str3, 0, 0);
        AppMethodBeat.o(146032);
    }

    public final void be(List<WxaAttributes.WxaPluginCodeInfo> list) {
        AppMethodBeat.i(146033);
        if (list != null && list.size() > 0) {
            Log.i("MicroMsg.AppBrandWxaPkgStorage", "updatePluginCodeList size:%s", Integer.valueOf(list.size()));
            for (WxaAttributes.WxaPluginCodeInfo wxaPluginCodeInfo : list) {
                String str = wxaPluginCodeInfo.provider;
                String str2 = wxaPluginCodeInfo.md5;
                int i2 = wxaPluginCodeInfo.version;
                if (!Util.isNullOrNil(str) && !Util.isNullOrNil(str2)) {
                    q(str, str2, i2);
                }
            }
        }
        AppMethodBeat.o(146033);
    }

    private boolean q(String str, String str2, int i2) {
        AppMethodBeat.i(182783);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            AppMethodBeat.o(182783);
            return false;
        }
        boolean d2 = d(new ad(str, ModulePkgInfo.PLUGIN_CODE).toString(), 0, i2, str2, null);
        AppMethodBeat.o(182783);
        return d2;
    }

    public final boolean b(final bd bdVar) {
        AppMethodBeat.i(182784);
        if (j.a.sE(bdVar.field_debugType)) {
            bdVar.field_version = 1;
        }
        boolean booleanValue = ((Boolean) r(new kotlin.g.a.a<Boolean>() {
            /* class com.tencent.mm.plugin.appbrand.appcache.bh.AnonymousClass3 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ Boolean invoke() {
                AppMethodBeat.i(229809);
                if (bh.a(bh.this, bdVar)) {
                    Boolean valueOf = Boolean.valueOf(bh.this.kNK.update(bdVar, bd.kNu));
                    AppMethodBeat.o(229809);
                    return valueOf;
                }
                Boolean valueOf2 = Boolean.valueOf(bh.this.kNK.insert(bdVar));
                AppMethodBeat.o(229809);
                return valueOf2;
            }
        })).booleanValue();
        AppMethodBeat.o(182784);
        return booleanValue;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0066, code lost:
        if (r3.getInt(0) > 0) goto L_0x0068;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean c(com.tencent.mm.plugin.appbrand.appcache.bd r10) {
        /*
        // Method dump skipped, instructions count: 148
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.appcache.bh.c(com.tencent.mm.plugin.appbrand.appcache.bd):boolean");
    }

    private synchronized <T> T r(kotlin.g.a.a<T> aVar) {
        T invoke;
        AppMethodBeat.i(229813);
        long beginTransaction = this.kNJ.beginTransaction(Thread.currentThread().getId());
        invoke = aVar.invoke();
        this.kNJ.endTransaction(beginTransaction);
        AppMethodBeat.o(229813);
        return invoke;
    }

    public final void a(String str, int i2, int i3, String str2, List<WxaAttributes.WxaWidgetInfo> list) {
        AppMethodBeat.i(177313);
        if (list != null && list.size() > 0) {
            for (WxaAttributes.WxaWidgetInfo wxaWidgetInfo : list) {
                int i4 = wxaWidgetInfo.packageType;
                String str3 = wxaWidgetInfo.lhj;
                String adVar = new ad(str, str2, i4).toString();
                Log.i("MicroMsg.AppBrandWxaPkgStorage", "multiPkg updatePkgInfoList pkgInfoKey:%s,pkgType:%d,codeType:%d", adVar, Integer.valueOf(i4), Integer.valueOf(i3));
                if (i3 == 0) {
                    d(adVar, i3, i2, str3, null);
                } else {
                    a(adVar, i3, "", str3, 0, 0);
                }
            }
        }
        AppMethodBeat.o(177313);
    }

    private boolean d(bd bdVar) {
        AppMethodBeat.i(146034);
        Log.i("MicroMsg.AppBrandWxaPkgStorage", "insertManifest, appId %s, type %d, version %d", bdVar.field_appId, Integer.valueOf(bdVar.field_debugType), Integer.valueOf(bdVar.field_version));
        boolean insert = this.kNK.insert(bdVar);
        AppMethodBeat.o(146034);
        return insert;
    }

    /* access modifiers changed from: package-private */
    public final int E(String str, int i2, int i3) {
        AppMethodBeat.i(229814);
        if (j.a.vP(i2)) {
            Log.i("MicroMsg.AppBrandWxaPkgStorage", "deletePkgsBelowVersion, appId %s, versionType %d, pkgVersion %d", str, Integer.valueOf(i2), Integer.valueOf(i3));
            int delete = this.kNJ.delete("AppBrandWxaPkgManifestRecord", String.format("%s=? and %s=? and %s<?", "appId", "debugType", "version"), new String[]{str, String.valueOf(i2), String.valueOf(i3)});
            AppMethodBeat.o(229814);
            return delete;
        }
        AppMethodBeat.o(229814);
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final int F(String str, int i2, int i3) {
        AppMethodBeat.i(229815);
        if (j.a.vP(i2)) {
            Log.i("MicroMsg.AppBrandWxaPkgStorage", "deleteModuleListBelowVersion appId[%s] versionType[%d] pkgVersion[%d]", str, Integer.valueOf(i2), Integer.valueOf(i3));
            int delete = this.kNJ.delete("AppBrandWxaPkgManifestRecord", String.format(Locale.US, "%s like %s and %s != %s and %s=? and %s<?", "appId", "'" + str + '$' + "%%'", "appId", "'" + str + '$' + "__PLUGINCODE__'", "debugType", "version"), new String[]{String.valueOf(i2), String.valueOf(i3)});
            AppMethodBeat.o(229815);
            return delete;
        }
        AppMethodBeat.o(229815);
        return 0;
    }

    @SuppressLint({"DefaultLocale"})
    public final boolean e(String str, int i2, int i3, String str2) {
        AppMethodBeat.i(146037);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(146037);
            return false;
        }
        if (j.a.sE(i2)) {
            i3 = 1;
        }
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("pkgPath", str2);
        if (this.kNJ.update("AppBrandWxaPkgManifestRecord", contentValues, String.format("%s=? and %s=? and %s=?", "appId", "debugType", "version"), new String[]{str, String.valueOf(i2), String.valueOf(i3)}) > 0) {
            AppMethodBeat.o(146037);
            return true;
        }
        AppMethodBeat.o(146037);
        return false;
    }

    private boolean e(bd bdVar) {
        AppMethodBeat.i(146038);
        Log.i("MicroMsg.AppBrandWxaPkgStorage", "updateManifest, appId %s, version %d, pkgType %d", bdVar.field_appId, Integer.valueOf(bdVar.field_version), Integer.valueOf(bdVar.field_debugType));
        boolean update = this.kNK.update(bdVar, bd.kNu);
        AppMethodBeat.o(146038);
        return update;
    }

    public final void f(List<String> list, List<Integer> list2) {
        AppMethodBeat.i(146039);
        if (list.size() <= 0 || list2.size() <= 0 || list.size() != list2.size()) {
            AppMethodBeat.o(146039);
            return;
        }
        Log.i("MicroMsg.AppBrandWxaPkgStorage", "batchDeleteAppPkg, size %d", Integer.valueOf(list.size()));
        long beginTransaction = this.kNJ.beginTransaction(Thread.currentThread().getId());
        for (int i2 = 0; i2 < list.size(); i2++) {
            aZ(list.get(i2), list2.get(i2).intValue());
        }
        this.kNJ.endTransaction(beginTransaction);
        AppMethodBeat.o(146039);
    }

    public final int aZ(String str, int i2) {
        AppMethodBeat.i(146040);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(146040);
            return 0;
        }
        Log.i("MicroMsg.AppBrandWxaPkgStorage", "deleteAppPkg, appId %s, debugType %d", str, Integer.valueOf(i2));
        String format = String.format("%s=? and %s=?", "appId", "debugType");
        String[] strArr = {str, String.valueOf(i2)};
        Cursor query = this.kNJ.query("AppBrandWxaPkgManifestRecord", new String[]{"pkgPath"}, format, strArr, null, null, null, 2);
        if (query == null) {
            AppMethodBeat.o(146040);
            return 0;
        } else if (!query.moveToFirst()) {
            query.close();
            AppMethodBeat.o(146040);
            return 0;
        } else {
            LinkedList<String> linkedList = new LinkedList();
            do {
                linkedList.add(query.getString(0));
            } while (query.moveToNext());
            query.close();
            for (String str2 : linkedList) {
                s.deleteFile(str2);
            }
            int delete = this.kNJ.delete("AppBrandWxaPkgManifestRecord", format, strArr);
            G(str, i2, -1);
            AppMethodBeat.o(146040);
            return delete;
        }
    }

    public static final class b extends MAutoStorage<bd> {
        public b(ISQLiteDatabase iSQLiteDatabase) {
            super(iSQLiteDatabase, bd.iBg, "AppBrandWxaPkgManifestRecord", bd.INDEX_CREATE);
        }
    }

    public final void f(bd bdVar) {
        AppMethodBeat.i(146041);
        this.kNK.replace(bdVar);
        AppMethodBeat.o(146041);
    }

    public final boolean a(String str, int i2, int i3, List<WxaAttributes.WxaVersionModuleInfo> list) {
        int i4;
        AppMethodBeat.i(146042);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(list)) {
            AppMethodBeat.o(146042);
            return false;
        }
        if (!j.a.vP(i2)) {
            i4 = 1;
        } else {
            i4 = i3;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        for (WxaAttributes.WxaVersionModuleInfo wxaVersionModuleInfo : list) {
            sb.append(',').append(wxaVersionModuleInfo.name).append("::").append(wxaVersionModuleInfo.md5);
        }
        sb.append('}');
        Log.i("MicroMsg.AppBrandWxaPkgStorage", "updateModuleList, appId %s, type %d, version %d, list %s", str, Integer.valueOf(i2), Integer.valueOf(i4), sb.toString());
        for (WxaAttributes.WxaVersionModuleInfo wxaVersionModuleInfo2 : list) {
            String adVar = new ad(str, wxaVersionModuleInfo2.name).toString();
            if (j.a.vP(i2)) {
                d(adVar, i2, i4, wxaVersionModuleInfo2.md5, null);
            } else {
                a(adVar, i2, null, wxaVersionModuleInfo2.md5, 0, 0);
            }
            String str2 = wxaVersionModuleInfo2.lha;
            if (!Util.isNullOrNil(wxaVersionModuleInfo2.name) && !Util.isNullOrNil(str2)) {
                b(str, wxaVersionModuleInfo2.name, i4, i2, str2, 13);
            }
            a(str, i4, i2, wxaVersionModuleInfo2.name, wxaVersionModuleInfo2.lhh);
        }
        AppMethodBeat.o(146042);
        return true;
    }

    public final boolean G(String str, int i2, int i3) {
        AppMethodBeat.i(146043);
        Locale locale = Locale.US;
        Object[] objArr = new Object[5];
        objArr[0] = "appId";
        objArr[1] = str;
        objArr[2] = "debugType";
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = i3 > 0 ? "version=".concat(String.valueOf(i3)) : "1=1";
        String format = String.format(Locale.US, "delete from %s %s", "AppBrandWxaPkgManifestRecord", String.format(locale, "where %s like '%s$%%' and %s=%d and %s", objArr));
        Log.i("MicroMsg.AppBrandWxaPkgStorage", "deleteModuleList, appId %s, type %d, version %d", str, Integer.valueOf(i2), Integer.valueOf(i3));
        boolean execSQL = this.kNJ.execSQL("AppBrandWxaPkgManifestRecord", format);
        AppMethodBeat.o(146043);
        return execSQL;
    }
}
