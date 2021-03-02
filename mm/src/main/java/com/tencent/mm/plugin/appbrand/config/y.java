package com.tencent.mm.plugin.appbrand.config;

import android.content.ContentValues;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.sdk.config.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.b;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.j;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.appusage.u;
import com.tencent.mm.plugin.appbrand.backgroundfetch.a;
import com.tencent.mm.plugin.appbrand.bh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Locale;
import org.json.JSONObject;

public final class y extends r {
    private static volatile y lfS;

    public static y bAj() {
        AppMethodBeat.i(44883);
        if (n.buC() == null) {
            b bVar = new b();
            AppMethodBeat.o(44883);
            throw bVar;
        }
        if (lfS == null) {
            synchronized (y.class) {
                try {
                    if (lfS == null) {
                        lfS = new y();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(44883);
                    throw th;
                }
            }
        }
        y yVar = lfS;
        AppMethodBeat.o(44883);
        return yVar;
    }

    public static void release() {
        synchronized (y.class) {
            lfS = null;
        }
    }

    private y() {
    }

    public static boolean k(String str, int i2, boolean z) {
        AppMethodBeat.i(44888);
        boolean k = n.buC().k(str, i2, z);
        AppMethodBeat.o(44888);
        return k;
    }

    public static ae Xr(String str) {
        AppMethodBeat.i(44889);
        if (Util.isNullOrNil(str) || !g.aAc()) {
            AppMethodBeat.o(44889);
            return null;
        }
        WxaAttributes d2 = n.buC().d(str, "appId", "nickname", "signature", "brandIconURL", "dynamicInfo", "versionInfo", "appInfo", "registerSource", "bindWxaInfo");
        if (d2 != null) {
            ae aeVar = new ae();
            aeVar.username = str;
            aeVar.appId = d2.field_appId;
            aeVar.nickname = d2.field_nickname;
            aeVar.signature = d2.field_signature;
            aeVar.dMf = d2.field_brandIconURL;
            aeVar.lgE = d2.bAo().lgE;
            aeVar.cyu = d2.bAp() == null ? -1 : d2.bAp().cyu;
            aeVar.lgr = d2.bAq();
            aeVar.leb = d2.bAo().lgD.leb;
            aeVar.lec = d2.bAo().lgD.lec;
            try {
                aeVar.cyo = d2.bAn().serviceType;
                aeVar.originalFlag = d2.bAn().originalFlag;
                aeVar.ldJ = d2.bAn().ldJ;
            } catch (NullPointerException e2) {
                Log.e("MicroMsg.WxaAttrStorageHelper", "assembleProfileAttrs, NULL appInfo, username = %s", str);
            }
            try {
                aeVar.diA = Util.isNullOrNil(d2.field_registerSource) ? "" : new JSONObject(d2.field_registerSource).optString("RegisterBody", "");
            } catch (Exception e3) {
            }
            AppMethodBeat.o(44889);
            return aeVar;
        }
        AppMethodBeat.o(44889);
        return null;
    }

    public static AppBrandRecentTaskInfo a(String str, String str2, int i2, long j2) {
        AppMethodBeat.i(44890);
        AppBrandRecentTaskInfo a2 = a(str, str2, i2, j2, false, "");
        AppMethodBeat.o(44890);
        return a2;
    }

    public static AppBrandRecentTaskInfo a(String str, String str2, int i2, long j2, boolean z, String str3) {
        int i3;
        int i4;
        long j3;
        String str4;
        boolean z2;
        long j4;
        AppMethodBeat.i(226474);
        z buC = n.buC();
        if (buC == null || !buC.bAh()) {
            Log.e("MicroMsg.WxaAttrStorageHelper", "assembleRecentInfo invalid storage with username(%s)", str2);
            AppMethodBeat.o(226474);
            return null;
        }
        WxaAttributes d2 = buC.d(str2, "appId", "nickname", "shortNickname", "smallHeadURL", "appInfo", "versionInfo", "dynamicInfo");
        int i5 = 0;
        if (d2 == null) {
            i3 = 0;
        } else {
            try {
                i3 = d2.bAn().serviceType;
            } catch (NullPointerException e2) {
                Log.e("MicroMsg.WxaAttrStorageHelper", "assembleRecentInfo, NULL appInfo, username = %s", str2);
            }
        }
        i5 = i3;
        int i6 = 0;
        if (d2 == null) {
            i4 = 0;
        } else {
            try {
                i4 = d2.bAp().appVersion;
            } catch (NullPointerException e3) {
            }
        }
        i6 = i4;
        long j5 = 0;
        if (d2 == null) {
            j3 = 0;
        } else {
            try {
                j3 = d2.bAn().czf;
            } catch (NullPointerException e4) {
            }
        }
        j5 = j3;
        long j6 = 0;
        if (j.a.vP(i2)) {
            if (d2 == null) {
                j4 = 0;
            } else {
                try {
                    j4 = d2.bAn().kWb;
                } catch (NullPointerException e5) {
                }
            }
            j6 = j4;
        }
        u uVar = (u) n.W(u.class);
        if (uVar == null) {
            Log.w("MicroMsg.WxaAttrStorageHelper", "assembleRecentInfo by username(%s) but NULL starAppStorage, maybe account released", str2);
        }
        String valueOf = String.valueOf(str);
        if (d2 == null) {
            str4 = "";
        } else {
            str4 = d2.field_appId;
        }
        String str5 = d2 == null ? "" : d2.field_nickname;
        String str6 = d2 == null ? "" : d2.field_shortNickname;
        String str7 = d2 == null ? "" : d2.field_smallHeadURL;
        boolean z3 = uVar != null && uVar.bj(str2, i2);
        boolean z4 = d2 != null && e.hP(d2.bAo().lgD.leb);
        if (d2 == null || !e.hO(d2.bAo().lgD.lec)) {
            z2 = false;
        } else {
            z2 = true;
        }
        AppBrandRecentTaskInfo appBrandRecentTaskInfo = new AppBrandRecentTaskInfo(valueOf, str2, str4, str5, str6, str7, i5, i2, i6, j5, j6, z3, j2, z4, z, str3, z2);
        AppMethodBeat.o(226474);
        return appBrandRecentTaskInfo;
    }

    public static a Xs(String str) {
        WxaAttributes d2;
        AppMethodBeat.i(44891);
        if (n.buC() == null || (d2 = n.buC().d(str, new String[0])) == null) {
            AppMethodBeat.o(44891);
            return null;
        }
        a aVar = new a();
        aVar.kXI = d2.bAo().lgD.kXI;
        aVar.kXJ = d2.bAo().lgD.kXJ;
        aVar.kXK = d2.bAo().lgD.kXK;
        aVar.kXL = d2.bAo().lgD.kXL;
        AppMethodBeat.o(44891);
        return aVar;
    }

    public static boolean Xt(String str) {
        WxaAttributes d2;
        AppMethodBeat.i(44893);
        if (n.buC() == null || (d2 = n.buC().d(str, "appInfo")) == null) {
            AppMethodBeat.o(44893);
            return false;
        } else if (d2.bAn() == null || !d2.bAn().bAt()) {
            AppMethodBeat.o(44893);
            return false;
        } else {
            AppMethodBeat.o(44893);
            return true;
        }
    }

    public static AppBrandSysConfigWC Xu(String str) {
        AppMethodBeat.i(44894);
        WxaAttributes e2 = n.buC().e(str, new String[0]);
        if (e2 != null) {
            AppBrandSysConfigWC e3 = e(e2);
            AppMethodBeat.o(44894);
            return e3;
        }
        AppMethodBeat.o(44894);
        return null;
    }

    private static AppBrandSysConfigWC e(WxaAttributes wxaAttributes) {
        AppBrandSysConfigWC appBrandSysConfigWC;
        AppMethodBeat.i(44895);
        if (wxaAttributes != null) {
            try {
                AppBrandSysConfigLU appBrandSysConfigLU = (AppBrandSysConfigLU) new bh.a<AppBrandSysConfigWC>() {
                    /* class com.tencent.mm.plugin.appbrand.config.y.AnonymousClass1 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // com.tencent.mm.plugin.appbrand.bh.a
                    public final /* synthetic */ AppBrandSysConfigWC newInstance() {
                        AppMethodBeat.i(44882);
                        AppBrandSysConfigWC appBrandSysConfigWC = new AppBrandSysConfigWC();
                        AppMethodBeat.o(44882);
                        return appBrandSysConfigWC;
                    }
                }.newInstance();
                appBrandSysConfigLU.brandName = wxaAttributes.field_nickname;
                appBrandSysConfigLU.jyi = wxaAttributes.field_smallHeadURL;
                appBrandSysConfigLU.appId = wxaAttributes.field_appId;
                appBrandSysConfigLU.lex = wxaAttributes.bAo().lgD.lex;
                appBrandSysConfigLU.cyJ = wxaAttributes.bAo().lgD.cyJ;
                appBrandSysConfigLU.cyM = wxaAttributes.bAo().lgD.cyM;
                appBrandSysConfigLU.cyN = wxaAttributes.bAo().lgD.cyN;
                appBrandSysConfigLU.cyO = wxaAttributes.bAo().lgD.cyO;
                appBrandSysConfigLU.cyP = wxaAttributes.bAo().lgD.cyP;
                appBrandSysConfigLU.cyQ = wxaAttributes.bAo().lgD.cyQ;
                appBrandSysConfigLU.cyL = wxaAttributes.bAo().lgD.cyL;
                appBrandSysConfigLU.cyK = wxaAttributes.bAo().lgD.cyK;
                appBrandSysConfigLU.cyR = (long) wxaAttributes.bAo().lgD.lgH;
                appBrandSysConfigLU.cyS = wxaAttributes.bAo().lgD.lgI;
                appBrandSysConfigLU.cyT = (ArrayList) com.tencent.luggage.h.b.c(new ArrayList(), wxaAttributes.bAn().lgv);
                appBrandSysConfigLU.cyU = (ArrayList) com.tencent.luggage.h.b.c(new ArrayList(), wxaAttributes.bAn().lgw);
                appBrandSysConfigLU.cyW = (ArrayList) com.tencent.luggage.h.b.c(new ArrayList(), wxaAttributes.bAn().lgy);
                appBrandSysConfigLU.cyV = (ArrayList) com.tencent.luggage.h.b.c(new ArrayList(), wxaAttributes.bAn().lgx);
                appBrandSysConfigLU.cyX = (ArrayList) com.tencent.luggage.h.b.c(new ArrayList(), wxaAttributes.bAn().lgz);
                appBrandSysConfigLU.czf = wxaAttributes.bAn().czf;
                appBrandSysConfigLU.leC = wxaAttributes.bAo().lgD.leC;
                appBrandSysConfigLU.leD = wxaAttributes.bAo().lgD.leD;
                appBrandSysConfigLU.cyY = wxaAttributes.bAo().lgD.cyY;
                appBrandSysConfigLU.cze = new String[]{wxaAttributes.field_roundedSquareIconURL, wxaAttributes.field_brandIconURL, wxaAttributes.field_bigHeadURL};
                appBrandSysConfigLU.cza = wxaAttributes.bAo().lgD.cza;
                appBrandSysConfigLU.czb = wxaAttributes.bAo().lgD.lgF;
                appBrandSysConfigLU.cyC = m.Xc(appBrandSysConfigLU.appId);
                appBrandSysConfigWC = (AppBrandSysConfigWC) appBrandSysConfigLU;
            } catch (Exception e2) {
                Log.e("MicroMsg.WxaAttrStorageHelper", "assembleSysConfig, <init> e = %s", e2);
                AppMethodBeat.o(44895);
                return null;
            }
        } else {
            appBrandSysConfigWC = null;
        }
        if (appBrandSysConfigWC != null) {
            appBrandSysConfigWC.cyZ = ((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("ClientBenchmarkLevel", -1);
            appBrandSysConfigWC.cyD = "1".equals(n.NL().get(appBrandSysConfigWC.appId + "_PerformancePanelEnabled", AppEventsConstants.EVENT_PARAM_VALUE_NO));
            appBrandSysConfigWC.leb = wxaAttributes.bAo().lgD.leb;
            appBrandSysConfigWC.lec = wxaAttributes.bAo().lgD.lec;
        }
        AppMethodBeat.o(44895);
        return appBrandSysConfigWC;
    }

    public static String[] Xv(String str) {
        AppMethodBeat.i(44897);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(44897);
            return null;
        }
        WxaAttributes d2 = n.buC().d(str, "roundedSquareIconURL", "bigHeadURL");
        if (d2 == null) {
            AppMethodBeat.o(44897);
            return null;
        }
        String[] strArr = {d2.field_roundedSquareIconURL, d2.field_bigHeadURL};
        AppMethodBeat.o(44897);
        return strArr;
    }

    public static String Xw(String str) {
        AppMethodBeat.i(44898);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(44898);
            return null;
        }
        WxaAttributes d2 = n.buC().d(str, "appId");
        if (d2 == null) {
            AppMethodBeat.o(44898);
            return null;
        }
        String str2 = d2.field_appId;
        AppMethodBeat.o(44898);
        return str2;
    }

    public static String Xx(String str) {
        AppMethodBeat.i(44899);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(44899);
            return null;
        }
        WxaAttributes e2 = n.buC().e(str, "nickname");
        if (e2 == null) {
            AppMethodBeat.o(44899);
            return null;
        }
        String str2 = e2.field_nickname;
        AppMethodBeat.o(44899);
        return str2;
    }

    public static String Xy(String str) {
        AppMethodBeat.i(44900);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(44900);
            return null;
        }
        WxaAttributes e2 = n.buC().e(str, ch.COL_USERNAME);
        if (e2 == null) {
            AppMethodBeat.o(44900);
            return null;
        }
        String str2 = e2.field_username;
        AppMethodBeat.o(44900);
        return str2;
    }

    public static void Xz(String str) {
        AppMethodBeat.i(44901);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(44901);
            return;
        }
        z buC = n.buC();
        if (!Util.isNullOrNil(str)) {
            ContentValues contentValues = new ContentValues(2);
            contentValues.put("syncVersion", "");
            contentValues.put("syncTimeSecond", (Long) 0L);
            ((x) buC).db.update(buC.getTableName(), contentValues, String.format(Locale.US, "%s=?", ch.COL_USERNAME), new String[]{str});
        }
        AppMethodBeat.o(44901);
    }

    public static void XA(String str) {
        AppMethodBeat.i(44902);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(44902);
            return;
        }
        WxaAttributes wxaAttributes = new WxaAttributes();
        wxaAttributes.field_username = str;
        n.buC().delete(wxaAttributes, ch.COL_USERNAME);
        AppMethodBeat.o(44902);
    }
}
