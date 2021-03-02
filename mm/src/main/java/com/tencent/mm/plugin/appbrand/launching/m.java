package com.tencent.mm.plugin.appbrand.launching;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.luggage.h.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.h;
import com.tencent.mm.plugin.appbrand.ac.d;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;

public final class m {
    public static WxaPkgWrappingInfo abZ(String str) {
        AppMethodBeat.i(261633);
        WxaPkgWrappingInfo bS = bS(str, 1);
        AppMethodBeat.o(261633);
        return bS;
    }

    public static WxaPkgWrappingInfo bS(String str, int i2) {
        AppMethodBeat.i(47158);
        int[] Vt = n.buL().Vt(str);
        if (Vt != null && Vt.length > i2) {
            while (true) {
                int i3 = i2 + 1;
                Pair<WxaPkgIntegrityChecker.a, WxaPkgWrappingInfo> D = WxaPkgIntegrityChecker.D(str, 0, Vt[i2]);
                if (D.first == WxaPkgIntegrityChecker.a.APP_READY && D.second != null) {
                    WxaPkgWrappingInfo wxaPkgWrappingInfo = (WxaPkgWrappingInfo) D.second;
                    AppMethodBeat.o(47158);
                    return wxaPkgWrappingInfo;
                } else if (i3 >= Vt.length) {
                    break;
                } else {
                    i2 = i3;
                }
            }
        }
        AppMethodBeat.o(47158);
        return null;
    }

    public static WxaPkgWrappingInfo bT(String str, int i2) {
        WxaPkgWrappingInfo wxaPkgWrappingInfo;
        AppMethodBeat.i(227076);
        int[] Vt = n.buL().Vt(str);
        if (Vt == null || Vt.length <= 0) {
            AppMethodBeat.o(227076);
            return null;
        }
        int abs = Math.abs(i2 - Vt[0]);
        int abs2 = Math.abs(i2 - Vt[Vt.length - 1]);
        if (abs <= abs2) {
            abs = abs2;
        }
        Log.d("MicroMsg.AppBrand.Launching.CheckPkgLogic", "findAvailablePluginPkg appId:%s,versionArray:%s", str, Arrays.toString(Vt));
        int length = Vt.length;
        int i3 = 0;
        WxaPkgWrappingInfo wxaPkgWrappingInfo2 = null;
        int i4 = abs;
        while (i3 < length) {
            int i5 = Vt[i3];
            int abs3 = Math.abs(i2 - i5);
            Pair<WxaPkgIntegrityChecker.a, WxaPkgWrappingInfo> D = WxaPkgIntegrityChecker.D(str, 0, i5);
            if (D.first != WxaPkgIntegrityChecker.a.APP_READY || D.second == null || abs3 > i4) {
                wxaPkgWrappingInfo = wxaPkgWrappingInfo2;
                abs3 = i4;
            } else {
                wxaPkgWrappingInfo = (WxaPkgWrappingInfo) D.second;
            }
            i3++;
            wxaPkgWrappingInfo2 = wxaPkgWrappingInfo;
            i4 = abs3;
        }
        if (wxaPkgWrappingInfo2 != null) {
            Log.i("MicroMsg.AppBrand.Launching.CheckPkgLogic", "findAvailablePluginPkg leastStep:%d,desireVersion:%d,localVersion:%d", Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(wxaPkgWrappingInfo2.pkgVersion));
        }
        AppMethodBeat.o(227076);
        return wxaPkgWrappingInfo2;
    }

    static boolean ed(String str, String str2) {
        boolean z = true;
        AppMethodBeat.i(47159);
        if (Util.isNullOrNil(str) || !s.YS(str)) {
            AppMethodBeat.o(47159);
            return false;
        }
        WxaPkg wxaPkg = new WxaPkg(str);
        try {
            if (!wxaPkg.bvf()) {
                return false;
            }
            if (Util.isNullOrNil(str2)) {
                wxaPkg.close();
                AppMethodBeat.o(47159);
                return true;
            }
            String UP = e.UP(l.dM(str2));
            if (Util.isNullOrNil(UP)) {
                wxaPkg.close();
                AppMethodBeat.o(47159);
                return true;
            }
            InputStream UR = wxaPkg.UR(UP);
            if (UR != null) {
                Util.qualityClose(UR);
            } else {
                String convertStreamToString = d.convertStreamToString(wxaPkg.UR("app-config.json"));
                if (!Util.isNullOrNil(convertStreamToString)) {
                    try {
                        JSONArray jSONArray = h.FE(convertStreamToString).getJSONArray("pages");
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            String string = jSONArray.getString(i2);
                            if (!Util.isNullOrNil(string) && UP.startsWith(e.UP(string))) {
                                wxaPkg.close();
                                AppMethodBeat.o(47159);
                                return true;
                            }
                        }
                        z = false;
                    } catch (Exception e2) {
                        Log.e("MicroMsg.AppBrand.Launching.CheckPkgLogic", "isFilePathExistsInPkg, parse app-config.json, pkgPath(%s), queryPath(%s), e = %s", str, UP, e2);
                    }
                }
                z = false;
            }
            wxaPkg.close();
            AppMethodBeat.o(47159);
            return z;
        } finally {
            wxaPkg.close();
            AppMethodBeat.o(47159);
        }
    }

    static bd a(ad adVar, int i2, int i3, String[] strArr) {
        AppMethodBeat.i(227077);
        List<bd> a2 = n.buL().a(adVar, i2, bh.a.DESC);
        if (a2 != null) {
            for (bd bdVar : a2) {
                if (bdVar.field_version != i3) {
                    String Vn = WxaPkgIntegrityChecker.Vn(bdVar.field_pkgPath);
                    for (String str : strArr) {
                        if (!TextUtils.isEmpty(str) && str.equals(Vn)) {
                            AppMethodBeat.o(227077);
                            return bdVar;
                        }
                    }
                    continue;
                }
            }
        }
        AppMethodBeat.o(227077);
        return null;
    }
}
