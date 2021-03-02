package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.f.e.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.r.a.a;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.List;

public final class h {

    public interface a {
        void a(g gVar);
    }

    public static g gE(String str, int i2) {
        g gVar = null;
        AppMethodBeat.i(151687);
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.AppInfoLogic", "getAppInfo, appId is null");
            AppMethodBeat.o(151687);
        } else if (a.C1616a.eAZ() == null) {
            Log.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
            AppMethodBeat.o(151687);
        } else {
            gVar = a.C1616a.eAZ().aJw(str);
            if (a(gVar, i2)) {
                a.C1616a.eAZ().aJz(str);
            }
            AppMethodBeat.o(151687);
        }
        return gVar;
    }

    public static g cX(String str, boolean z) {
        AppMethodBeat.i(151688);
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.AppInfoLogic", "getAppInfo, appId is null");
            AppMethodBeat.o(151688);
            return null;
        }
        com.tencent.mm.plugin.r.a.a eAZ = a.C1616a.eAZ();
        if (eAZ == null) {
            Log.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
            AppMethodBeat.o(151688);
            return null;
        } else if (z) {
            g aJx = eAZ.aJx(str);
            AppMethodBeat.o(151688);
            return aJx;
        } else {
            g aJw = eAZ.aJw(str);
            if (aJw == null) {
                g aJx2 = eAZ.aJx(str);
                AppMethodBeat.o(151688);
                return aJx2;
            }
            eAZ.aJz(str);
            AppMethodBeat.o(151688);
            return aJw;
        }
    }

    public static void a(final String str, final String str2, final a aVar) {
        AppMethodBeat.i(151689);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2) || aVar == null) {
            Log.e("MicroMsg.AppInfoLogic", "getAppInfoASync, appId is null");
            if (aVar != null) {
                aVar.a(null);
            }
            AppMethodBeat.o(151689);
            return;
        }
        com.tencent.f.h.RTc.b(new Runnable() {
            /* class com.tencent.mm.pluginsdk.model.app.h.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(151679);
                MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("key_open_sdk_pkg");
                if (singleMMKV == null) {
                    aVar.a(null);
                    AppMethodBeat.o(151679);
                    return;
                }
                singleMMKV.encode(str, str2);
                aVar.a(h.cX(str, true));
                AppMethodBeat.o(151679);
            }
        }, "GetAppInfoASyncThread");
        AppMethodBeat.o(151689);
    }

    public static g o(String str, boolean z, boolean z2) {
        g gVar = null;
        AppMethodBeat.i(184265);
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.AppInfoLogic", "getAppInfo, appId is null");
            AppMethodBeat.o(184265);
        } else if (a.C1616a.eAZ() == null) {
            Log.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
            AppMethodBeat.o(184265);
        } else {
            gVar = a.C1616a.eAZ().aJw(str);
            if (z && (j(gVar) || (z2 && i(gVar)))) {
                a.C1616a.eAZ().aJz(str);
            }
            AppMethodBeat.o(184265);
        }
        return gVar;
    }

    public static boolean i(g gVar) {
        AppMethodBeat.i(184266);
        if (!Util.isNullOrNil(gVar.field_packageName)) {
            AppMethodBeat.o(184266);
            return true;
        }
        AppMethodBeat.o(184266);
        return false;
    }

    private static boolean j(g gVar) {
        AppMethodBeat.i(151691);
        if (gVar == null || gVar.field_appName == null || gVar.field_appName.length() == 0) {
            AppMethodBeat.o(151691);
            return true;
        }
        AppMethodBeat.o(151691);
        return false;
    }

    private static boolean a(g gVar, int i2) {
        return gVar == null || gVar.field_appVersion < i2;
    }

    public static boolean bdy(String str) {
        AppMethodBeat.i(184267);
        if (Util.isEqual("wx485a97c844086dc9", str) || Util.isEqual("wxaf060266bfa9a35c", str)) {
            AppMethodBeat.o(184267);
            return true;
        }
        g o = o(str, true, false);
        if (o == null || Util.isNullOrNil(o.field_packageName) || Util.isNullOrNil(o.field_signature)) {
            AppMethodBeat.o(184267);
            return false;
        }
        AppMethodBeat.o(184267);
        return true;
    }

    public static Bitmap c(String str, int i2, float f2) {
        AppMethodBeat.i(151692);
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.AppInfoLogic", "getAppIcon, appId is null");
            AppMethodBeat.o(151692);
            return null;
        } else if (!g.aAf().azp()) {
            AppMethodBeat.o(151692);
            return null;
        } else if (g.aAh().isSDCardAvailable()) {
            Bitmap a2 = a.C1616a.eAZ().a(str, i2, f2);
            if (a2 == null) {
                Log.w("MicroMsg.AppInfoLogic", "getAppIcon, bm does not exist or has been recycled");
                a.C1616a.eAZ().eZ(str, i2);
                AppMethodBeat.o(151692);
                return null;
            } else if (a2.isRecycled()) {
                AppMethodBeat.o(151692);
                return null;
            } else {
                AppMethodBeat.o(151692);
                return a2;
            }
        } else if (MMApplicationContext.getContext() == null) {
            AppMethodBeat.o(151692);
            return null;
        } else if (MMApplicationContext.getContext().getResources() == null) {
            AppMethodBeat.o(151692);
            return null;
        } else {
            switch (i2) {
                case 1:
                case 3:
                case 4:
                case 5:
                    Bitmap decodeResource = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), R.drawable.bni);
                    if (decodeResource == null || decodeResource.isRecycled()) {
                        AppMethodBeat.o(151692);
                        return null;
                    }
                    AppMethodBeat.o(151692);
                    return decodeResource;
                case 2:
                    AppMethodBeat.o(151692);
                    return null;
                default:
                    Log.e("MicroMsg.AppInfoLogic", "getAppIcon, unknown iconType = ".concat(String.valueOf(i2)));
                    AppMethodBeat.o(151692);
                    return null;
            }
        }
    }

    public static List<g> b(Context context, long j2, boolean z) {
        AppMethodBeat.i(151693);
        ArrayList arrayList = new ArrayList();
        j eAS = com.tencent.mm.plugin.r.a.eAS();
        StringBuilder sb = new StringBuilder(256);
        sb.append("select * from AppInfo");
        sb.append(" where ");
        sb.append(" ( appSupportContentType & ").append(j2).append(" ) != 0");
        sb.append(" and  ( svrAppSupportContentType & ").append(j2).append(" ) != 0");
        sb.append(" and  ( appInfoFlag & 8192").append(" ) != 0");
        sb.append(" and status != 4");
        if (!z) {
            sb.append(" and  ( appInfoFlag & 16384").append(" ) == 0");
        }
        Log.v("MicroMsg.AppInfoStorage", "getAppInfoByContentFlag sql %s", sb.toString());
        Cursor rawQuery = eAS.rawQuery(sb.toString(), new String[0]);
        if (rawQuery == null) {
            Log.e("MicroMsg.AppInfoStorage", "getAppByStatus : cursor is null");
            rawQuery = null;
        }
        if (rawQuery == null) {
            AppMethodBeat.o(151693);
        } else {
            while (rawQuery.moveToNext()) {
                g gVar = new g();
                gVar.convertFrom(rawQuery);
                if (gVar.field_status == 1) {
                    if (!s(context, gVar.field_appId)) {
                        gVar.field_status = 4;
                        a.C1616a.eAZ().g(gVar);
                    } else if (!Util.isNullOrNil(gVar.field_signature)) {
                        arrayList.add(gVar);
                    }
                } else if (gVar.field_signature != null) {
                    arrayList.add(gVar);
                }
            }
            rawQuery.close();
            AppMethodBeat.o(151693);
        }
        return arrayList;
    }

    public static boolean s(Context context, long j2) {
        AppMethodBeat.i(151694);
        if (b(context, j2, true).size() == 0) {
            AppMethodBeat.o(151694);
            return false;
        }
        AppMethodBeat.o(151694);
        return true;
    }

    public static boolean ay(Context context, int i2) {
        AppMethodBeat.i(151695);
        Long bcU = e.a.bcU(String.valueOf(i2));
        if (bcU == null) {
            AppMethodBeat.o(151695);
            return false;
        } else if (b(context, bcU.longValue(), true).size() == 0) {
            AppMethodBeat.o(151695);
            return false;
        } else {
            AppMethodBeat.o(151695);
            return true;
        }
    }

    public static List<g> a(Context context, boolean z, int i2) {
        AppMethodBeat.i(151697);
        List<g> arrayList = new ArrayList<>();
        if (a.C1616a.eAZ() == null) {
            Log.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
            AppMethodBeat.o(151697);
        } else {
            arrayList = ahK(i2);
            int[] iArr = null;
            if (z) {
                iArr = new int[]{5};
            }
            if (iArr == null) {
                AppMethodBeat.o(151697);
            } else {
                Cursor H = a.C1616a.eAZ().H(iArr);
                if (H != null) {
                    while (H.moveToNext()) {
                        g gVar = new g();
                        gVar.convertFrom(H);
                        if (gVar.field_status == 1) {
                            if (!s(context, gVar.field_appId)) {
                                gVar.field_status = 4;
                                a.C1616a.eAZ().g(gVar);
                            } else if (!Util.isNullOrNil(gVar.field_signature)) {
                                arrayList.add(gVar);
                            }
                        } else if (gVar.field_signature != null) {
                            arrayList.add(gVar);
                        }
                    }
                    H.close();
                }
                AppMethodBeat.o(151697);
            }
        }
        return arrayList;
    }

    private static List<g> ahK(int i2) {
        AppMethodBeat.i(223745);
        ArrayList arrayList = new ArrayList();
        if (a.C1616a.eAZ() == null) {
            Log.e("MicroMsg.AppInfoLogic", "getServiceByAppInfoFlagAndShowFlag, getISubCorePluginBase() == null");
            AppMethodBeat.o(223745);
        } else {
            Cursor hG = a.C1616a.eAZ().hG(1, i2);
            if (hG == null) {
                AppMethodBeat.o(223745);
            } else {
                while (hG.moveToNext()) {
                    g gVar = new g();
                    gVar.convertFrom(hG);
                    arrayList.add(gVar);
                }
                hG.close();
                Log.i("MicroMsg.AppInfoLogic", "getServiceByAppInfoFlagAndShowFlag: size is %s", Integer.valueOf(arrayList.size()));
                AppMethodBeat.o(223745);
            }
        }
        return arrayList;
    }

    public static List<g> gmU() {
        AppMethodBeat.i(151700);
        ArrayList arrayList = new ArrayList();
        if (a.C1616a.eAZ() == null) {
            Log.e("MicroMsg.AppInfoLogic", "getAllServices, getISubCorePluginBase() == null");
            AppMethodBeat.o(151700);
        } else {
            Cursor eAY = a.C1616a.eAZ().eAY();
            if (eAY == null) {
                AppMethodBeat.o(151700);
            } else {
                while (eAY.moveToNext()) {
                    g gVar = new g();
                    gVar.convertFrom(eAY);
                    if (!Util.isNullOrNil(gVar.field_openId)) {
                        arrayList.add(gVar);
                    }
                }
                eAY.close();
                AppMethodBeat.o(151700);
            }
        }
        return arrayList;
    }

    public static boolean s(Context context, String str) {
        AppMethodBeat.i(151701);
        if (context == null || str == null || str.length() == 0) {
            Log.e("MicroMsg.AppInfoLogic", "isAppInstalled, invalid arguments");
            AppMethodBeat.o(151701);
            return false;
        }
        boolean a2 = a(context, o(str, true, false));
        AppMethodBeat.o(151701);
        return a2;
    }

    public static boolean a(Context context, g gVar) {
        AppMethodBeat.i(151702);
        if (gVar == null) {
            Log.w("MicroMsg.AppInfoLogic", "app is null");
            AppMethodBeat.o(151702);
            return false;
        } else if (gVar.field_packageName == null || gVar.field_packageName.length() == 0) {
            Log.w("MicroMsg.AppInfoLogic", "field_packageName is null");
            AppMethodBeat.o(151702);
            return false;
        } else {
            boolean s = q.s(context, gVar.field_packageName);
            AppMethodBeat.o(151702);
            return s;
        }
    }

    public static boolean gp(String str) {
        AppMethodBeat.i(151703);
        if (str == null || str.trim().length() == 0 || str.equals("weixinfile") || str.equals("invalid_appname")) {
            AppMethodBeat.o(151703);
            return false;
        }
        AppMethodBeat.o(151703);
        return true;
    }

    public static String q(Context context, String str, int i2) {
        AppMethodBeat.i(151704);
        String a2 = a(context, gE(str, i2), (String) null);
        AppMethodBeat.o(151704);
        return a2;
    }

    public static String c(Context context, g gVar) {
        AppMethodBeat.i(263523);
        String a2 = a(context, gVar, (String) null);
        AppMethodBeat.o(263523);
        return a2;
    }

    public static String a(Context context, g gVar, String str) {
        AppMethodBeat.i(151706);
        if (context == null || gVar == null) {
            AppMethodBeat.o(151706);
            return str;
        }
        String it = it(context);
        String str2 = null;
        if (it.equalsIgnoreCase(LocaleUtil.CHINA)) {
            str2 = gVar.field_appName;
        }
        if (it.equalsIgnoreCase(LocaleUtil.ENGLISH)) {
            str2 = Util.isNullOrNil(gVar.field_appName_en) ? gVar.field_appName : gVar.field_appName_en;
        }
        if (it.equalsIgnoreCase(LocaleUtil.TAIWAN) || it.equalsIgnoreCase(LocaleUtil.HONGKONG)) {
            if (it.equalsIgnoreCase(LocaleUtil.HONGKONG)) {
                str2 = Util.isNullOrNil(gVar.field_appName_hk) ? gVar.field_appName_tw : gVar.field_appName_hk;
            }
            if (Util.isNullOrNil(str2)) {
                str2 = Util.isNullOrNil(gVar.field_appName_tw) ? gVar.field_appName : gVar.field_appName_tw;
            }
        }
        if (Util.isNullOrNil(str2)) {
            str2 = Util.isNullOrNil(gVar.field_appName_en) ? gVar.field_appName : gVar.field_appName_en;
        }
        if (Util.isNullOrNil(str2)) {
            AppMethodBeat.o(151706);
            return str;
        }
        AppMethodBeat.o(151706);
        return str2;
    }

    public static String b(Context context, g gVar, String str) {
        AppMethodBeat.i(151707);
        if (context == null || gVar == null) {
            AppMethodBeat.o(151707);
            return str;
        }
        String it = it(context);
        String str2 = null;
        if (it.equalsIgnoreCase(LocaleUtil.CHINA)) {
            str2 = gVar.field_appName;
        }
        if (it.equalsIgnoreCase(LocaleUtil.ENGLISH)) {
            str2 = Util.isNullOrNil(gVar.field_appName_en) ? gVar.field_appName : gVar.field_appName_en;
        }
        if (it.equalsIgnoreCase(LocaleUtil.TAIWAN) || it.equalsIgnoreCase(LocaleUtil.HONGKONG)) {
            if (it.equalsIgnoreCase(LocaleUtil.HONGKONG)) {
                str2 = Util.isNullOrNil(gVar.field_appName_hk) ? gVar.field_appName_tw : gVar.field_appName_hk;
            }
            if (Util.isNullOrNil(str2)) {
                str2 = Util.isNullOrNil(gVar.field_appName_tw) ? gVar.field_appName : gVar.field_appName_tw;
            }
        }
        if (Util.isNullOrNil(str2)) {
            AppMethodBeat.o(151707);
            return str;
        }
        AppMethodBeat.o(151707);
        return str2;
    }

    public static String it(Context context) {
        AppMethodBeat.i(151708);
        String loadApplicationLanguage = LocaleUtil.loadApplicationLanguage(context.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), context);
        if (loadApplicationLanguage == null || loadApplicationLanguage.length() == 0 || loadApplicationLanguage.equalsIgnoreCase(LocaleUtil.CHINA)) {
            AppMethodBeat.o(151708);
            return LocaleUtil.CHINA;
        }
        AppMethodBeat.o(151708);
        return loadApplicationLanguage;
    }

    public static boolean gq(String str) {
        AppMethodBeat.i(151709);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(151709);
            return false;
        }
        g o = o(str, false, false);
        if (o == null) {
            Log.w("MicroMsg.AppInfoLogic", "app is null, appId = ".concat(String.valueOf(str)));
            AppMethodBeat.o(151709);
            return false;
        }
        boolean NA = o.NA();
        AppMethodBeat.o(151709);
        return NA;
    }

    public static boolean k(g gVar) {
        AppMethodBeat.i(151710);
        if (gVar == null || Util.isNullOrNil(gVar.field_appId)) {
            AppMethodBeat.o(151710);
            return false;
        } else if ((gVar.field_appInfoFlag & 1) > 0) {
            AppMethodBeat.o(151710);
            return true;
        } else {
            AppMethodBeat.o(151710);
            return false;
        }
    }

    public static boolean l(g gVar) {
        if (gVar == null || (gVar.field_appInfoFlag & 2) == 0) {
            return true;
        }
        return false;
    }

    private static boolean m(g gVar) {
        AppMethodBeat.i(151711);
        if (gVar == null || Util.isNullOrNil(gVar.field_appId)) {
            AppMethodBeat.o(151711);
            return false;
        } else if (gVar.field_appId.equals("wx7fa037cc7dfabad5")) {
            AppMethodBeat.o(151711);
            return true;
        } else if ((gVar.field_appInfoFlag & 8) > 0) {
            AppMethodBeat.o(151711);
            return true;
        } else {
            AppMethodBeat.o(151711);
            return false;
        }
    }

    public static boolean bdz(String str) {
        AppMethodBeat.i(151712);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(151712);
            return false;
        }
        boolean m = m(o(str, true, false));
        AppMethodBeat.o(151712);
        return m;
    }

    public static boolean bdA(String str) {
        AppMethodBeat.i(223746);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(223746);
            return false;
        }
        boolean n = n(o(str, true, false));
        AppMethodBeat.o(223746);
        return n;
    }

    private static boolean n(g gVar) {
        boolean z;
        AppMethodBeat.i(223747);
        if (gVar == null || Util.isNullOrNil(gVar.field_appId)) {
            AppMethodBeat.o(223747);
            return false;
        }
        if ((gVar.field_appInfoFlag & 32) > 0) {
            z = true;
        } else {
            z = false;
        }
        Log.v("MicroMsg.AppInfoLogic", "canShowSNSTail, appid = %s, ret = %b", gVar.field_appId, Boolean.valueOf(z));
        AppMethodBeat.o(223747);
        return z;
    }

    public static boolean o(g gVar) {
        boolean z;
        AppMethodBeat.i(151713);
        if (gVar == null || Util.isNullOrNil(gVar.field_appId)) {
            AppMethodBeat.o(151713);
            return false;
        }
        if ((gVar.field_appInfoFlag & 64) > 0) {
            z = true;
        } else {
            z = false;
        }
        Log.v("MicroMsg.AppInfoLogic", "canReadMMMsg, appid = %s, ret = %b", gVar.field_appId, Boolean.valueOf(z));
        AppMethodBeat.o(151713);
        return z;
    }

    public static boolean b(g gVar, int i2) {
        boolean z;
        AppMethodBeat.i(151714);
        if (gVar == null || Util.isNullOrNil(gVar.field_appId)) {
            AppMethodBeat.o(151714);
            return false;
        }
        if ((gVar.field_appInfoFlag & i2) > 0) {
            z = true;
        } else {
            z = false;
        }
        Log.i("MicroMsg.AppInfoLogic", "isAppHasFlag, appid = %s, flag = %s, ret = %b", gVar.field_appId, Integer.valueOf(i2), Boolean.valueOf(z));
        Log.i("MicroMsg.AppInfoLogic", "appInfoFlag = " + gVar.field_appInfoFlag);
        AppMethodBeat.o(151714);
        return z;
    }

    public static boolean p(g gVar) {
        boolean z;
        AppMethodBeat.i(151715);
        if (gVar == null || Util.isNullOrNil(gVar.field_appId)) {
            AppMethodBeat.o(151715);
            return false;
        }
        if ((gVar.field_appInfoFlag & 128) > 0) {
            z = true;
        } else {
            z = false;
        }
        if (true == z) {
            String Ip = z.Ip(gVar.field_appId);
            if (Ip == null || Ip.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                AppMethodBeat.o(151715);
                return true;
            }
            AppMethodBeat.o(151715);
            return false;
        }
        AppMethodBeat.o(151715);
        return false;
    }

    public static boolean a(Context context, String str, WXMediaMessage wXMediaMessage, int i2, al alVar, Bundle bundle) {
        g cX;
        AppMethodBeat.i(151716);
        if (context == null) {
            Log.e("MicroMsg.AppInfoLogic", "launch app failed: context is null");
            if (alVar != null) {
                alVar.v(false, false);
            }
            AppMethodBeat.o(151716);
            return false;
        } else if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.AppInfoLogic", "launch app failed: appid is null or nil");
            if (alVar != null) {
                alVar.v(false, false);
            }
            AppMethodBeat.o(151716);
            return false;
        } else if (wXMediaMessage == null) {
            Log.e("MicroMsg.AppInfoLogic", "launch app failed: wxMsg is null");
            if (alVar != null) {
                alVar.v(false, false);
            }
            AppMethodBeat.o(151716);
            return false;
        } else {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                cX = gE(str, Integer.MAX_VALUE);
            } else {
                cX = cX(str, false);
            }
            if (cX == null) {
                Log.e("MicroMsg.AppInfoLogic", "get appinfo is null, appid is : [%s]", str);
                if (alVar != null) {
                    alVar.v(false, false);
                }
                AppMethodBeat.o(151716);
                return false;
            } else if (cX.field_status == 3) {
                Log.e("MicroMsg.AppInfoLogic", "requestAppShow fail, app is in blacklist, packageName = " + cX.field_packageName);
                if (alVar != null) {
                    alVar.v(false, false);
                }
                AppMethodBeat.o(151716);
                return false;
            } else {
                boolean a2 = a(context, cX.field_packageName, wXMediaMessage, str, cX.field_openId, i2, alVar, bundle);
                AppMethodBeat.o(151716);
                return a2;
            }
        }
    }

    public static boolean a(Context context, String str, WXMediaMessage wXMediaMessage, String str2, String str3, int i2, al alVar, Bundle bundle) {
        AppMethodBeat.i(151717);
        Log.d("MicroMsg.AppInfoLogic", "request pkg = " + str + ", openId = " + str3);
        boolean a2 = a(context, str, str2, c(context, wXMediaMessage, str3), i2, alVar, bundle);
        AppMethodBeat.o(151717);
        return a2;
    }

    public static boolean a(final Context context, final String str, String str2, final ShowMessageFromWX.Req req, int i2, final al alVar, Bundle bundle) {
        final String str3;
        final String str4;
        String string;
        final String str5;
        AppMethodBeat.i(151718);
        if (req == null) {
            Log.i("MicroMsg.AppInfoLogic", "launchApp failed, req is null.");
            if (alVar != null) {
                alVar.v(false, false);
            }
            AppMethodBeat.o(151718);
            return false;
        } else if (TextUtils.isEmpty(str) || !q.s(context, str)) {
            Log.i("MicroMsg.AppInfoLogic", "launchApp failed, pkg is null or application has not installed.");
            com.tencent.f.h.RTc.aV(new Runnable() {
                /* class com.tencent.mm.pluginsdk.model.app.h.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(151680);
                    com.tencent.mm.ui.base.h.cD(context, context.getString(R.string.b2f));
                    AppMethodBeat.o(151680);
                }
            });
            if (alVar != null) {
                alVar.v(false, false);
            }
            AppMethodBeat.o(151718);
            return false;
        } else {
            Log.i("MicroMsg.AppInfoLogic", "launchApp(pkg : %s) with appId(%s)", str, str2);
            if (Util.nullAsNil(MMApplicationContext.getPackageName()).equals(str)) {
                Log.i("MicroMsg.AppInfoLogic", "launchApp failed, can not launch wechat page.");
                if (alVar != null) {
                    alVar.v(false, false);
                }
                AppMethodBeat.o(151718);
                return false;
            }
            final AnonymousClass3 r6 = new Runnable() {
                /* class com.tencent.mm.pluginsdk.model.app.h.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(184258);
                    Bundle bundle = new Bundle();
                    req.toBundle(bundle);
                    q.bo(bundle);
                    q.bp(bundle);
                    MMessageActV2.Args args = new MMessageActV2.Args();
                    args.targetPkgName = str;
                    args.bundle = bundle;
                    boolean send = MMessageActV2.send(context, args);
                    if (alVar != null) {
                        alVar.v(send, false);
                    }
                    AppMethodBeat.o(184258);
                }
            };
            if (i2 == 2) {
                Log.i("MicroMsg.AppInfoLogic", "launchApp with show confirm dialog(%s).", str);
                r6.run();
                AppMethodBeat.o(151718);
                return true;
            }
            if (bundle != null) {
                str3 = bundle.getString("current_page_url", "");
                str4 = bundle.getString("current_page_appid", "");
            } else {
                str3 = "";
                str4 = "";
            }
            g o = o(str2, true, false);
            if (o == null || Util.isNullOrNil(a(context, o, (String) null))) {
                string = context.getString(R.string.ec5);
            } else {
                string = context.getString(R.string.ec6, a(context, o, (String) null));
            }
            if (str2 == null) {
                str5 = "";
            } else {
                str5 = str2;
            }
            bdB(str5);
            Log.i("MicroMsg.AppInfoLogic", "launchApp with args(showType : %s, pkg : %s)", Integer.valueOf(i2), str);
            final f.a aVar = new f.a(context);
            aVar.bow(string).boA(context.getString(R.string.ec4)).boB(context.getString(R.string.sz)).b(new f.c() {
                /* class com.tencent.mm.pluginsdk.model.app.h.AnonymousClass5 */

                @Override // com.tencent.mm.ui.widget.a.f.c
                public final void e(boolean z, String str) {
                    AppMethodBeat.i(184259);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(14102, 0, 1, "", 1, str, str3, str4);
                    if ("wx073f4a4daff0abe8".equalsIgnoreCase(str5)) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(15413, 2, "", "");
                    }
                    r6.run();
                    AppMethodBeat.o(184259);
                }
            }).a(new f.c() {
                /* class com.tencent.mm.pluginsdk.model.app.h.AnonymousClass4 */

                @Override // com.tencent.mm.ui.widget.a.f.c
                public final void e(boolean z, String str) {
                    AppMethodBeat.i(151682);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(14102, 0, 0, "", 0, str, str3, str4);
                    if ("wx073f4a4daff0abe8".equalsIgnoreCase(str5)) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(15413, 3, "", "");
                    }
                    if (alVar != null) {
                        alVar.v(false, true);
                    }
                    AppMethodBeat.o(151682);
                }
            });
            if (Looper.myLooper() == Looper.getMainLooper()) {
                aVar.show();
            } else {
                com.tencent.f.e.e.hmm().hmq().a(new com.tencent.f.e.a<e.a, Object>() {
                    /* class com.tencent.mm.pluginsdk.model.app.h.AnonymousClass6 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.tencent.f.e.a
                    public final /* synthetic */ Object bT(e.a aVar) {
                        AppMethodBeat.i(184260);
                        aVar.show();
                        AppMethodBeat.o(184260);
                        return null;
                    }
                }).take();
            }
            AppMethodBeat.o(151718);
            return true;
        }
    }

    public static boolean k(Context context, Uri uri) {
        AppMethodBeat.i(223748);
        if (context == null || uri == null) {
            Log.i("MicroMsg.AppInfoLogic", "launchApp failed, context or uri is null.");
            AppMethodBeat.o(223748);
            return false;
        }
        Log.i("MicroMsg.AppInfoLogic", "try to launchApp with uri.");
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        intent.addFlags(268435456);
        boolean a2 = a(context, intent, null, null, null);
        AppMethodBeat.o(223748);
        return a2;
    }

    public static boolean b(Context context, Intent intent, String str) {
        AppMethodBeat.i(151720);
        boolean a2 = a(context, intent, str, null, null);
        AppMethodBeat.o(151720);
        return a2;
    }

    public static boolean c(Context context, Intent intent, String str) {
        AppMethodBeat.i(223749);
        boolean a2 = a(context, intent, str, null, null);
        AppMethodBeat.o(223749);
        return a2;
    }

    public static boolean a(Context context, Intent intent, String str, al alVar, Bundle bundle) {
        AppMethodBeat.i(151722);
        boolean a2 = a(context, intent, str, 0, alVar, bundle);
        AppMethodBeat.o(151722);
        return a2;
    }

    public static boolean a(final Context context, final Intent intent, final String str, int i2, final al alVar, Bundle bundle) {
        final String str2;
        final String str3;
        final String str4;
        AppMethodBeat.i(151723);
        if (context == null || intent == null) {
            Log.i("MicroMsg.AppInfoLogic", "launchApp failed, context or intent is null.");
            if (alVar != null) {
                alVar.v(false, false);
            }
            AppMethodBeat.o(151723);
            return false;
        }
        if (bundle != null) {
            str2 = bundle.getString("current_page_url", "");
            str3 = bundle.getString("current_page_appid", "");
        } else {
            str2 = "";
            str3 = "";
        }
        List<ResolveInfo> queryIntentActivities = Util.queryIntentActivities(context, intent);
        if (queryIntentActivities == null || queryIntentActivities.isEmpty()) {
            Log.w("MicroMsg.AppInfoLogic", "launchApp failed, not activity can resolve the intent.");
            if (alVar != null) {
                alVar.v(false, false);
            }
            AppMethodBeat.o(151723);
            return false;
        }
        if (!TextUtils.isEmpty(intent.getPackage()) || queryIntentActivities.size() != 1) {
            str4 = intent.getPackage();
        } else {
            str4 = b(queryIntentActivities.get(0));
        }
        Log.d("MicroMsg.AppInfoLogic", "launchApp, wxpkg : %s.", MMApplicationContext.getPackageName());
        if (Util.nullAsNil(MMApplicationContext.getPackageName()).equals(str4)) {
            Log.i("MicroMsg.AppInfoLogic", "launchApp failed, can not launch wechat page.");
            if (alVar != null) {
                alVar.v(false, false);
            }
            AppMethodBeat.o(151723);
            return false;
        }
        Log.i("MicroMsg.AppInfoLogic", "launchApp(pkg : %s) by wechat with intent", str4);
        if (i2 == 2) {
            try {
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/pluginsdk/model/app/AppInfoLogic", "launchAppByWeChat", "(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;ILcom/tencent/mm/pluginsdk/model/app/OnLaunchAppCallback;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/pluginsdk/model/app/AppInfoLogic", "launchAppByWeChat", "(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;ILcom/tencent/mm/pluginsdk/model/app/OnLaunchAppCallback;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            } catch (Exception e2) {
                Log.i("MicroMsg.AppInfoLogic", e2.getMessage());
            }
            if (alVar != null) {
                alVar.v(true, false);
            }
            AppMethodBeat.o(151723);
            return true;
        }
        boolean booleanValue = com.tencent.f.e.e.hmm().hmq().a(new com.tencent.f.e.a<e.a, Boolean>() {
            /* class com.tencent.mm.pluginsdk.model.app.h.AnonymousClass7 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.f.e.a
            public final /* synthetic */ Boolean bT(e.a aVar) {
                String string;
                AppMethodBeat.i(184263);
                if (!TextUtils.isEmpty(str)) {
                    string = context.getString(R.string.ec6, str);
                } else {
                    string = context.getString(R.string.ec5);
                }
                new f.a(context).bow(string).boA(context.getString(R.string.ec4)).boB(context.getString(R.string.sz)).b(new f.c() {
                    /* class com.tencent.mm.pluginsdk.model.app.h.AnonymousClass7.AnonymousClass2 */

                    @Override // com.tencent.mm.ui.widget.a.f.c
                    public final void e(boolean z, String str) {
                        AppMethodBeat.i(184262);
                        try {
                            Context context = context;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/pluginsdk/model/app/AppInfoLogic$7$2", "onDialogClick", "(ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            context.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/pluginsdk/model/app/AppInfoLogic$7$2", "onDialogClick", "(ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        } catch (Exception e2) {
                            Log.i("MicroMsg.AppInfoLogic", e2.getMessage());
                        }
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(14102, 0, 1, "", 1, str4, str2, str3);
                        if (alVar != null) {
                            alVar.v(true, false);
                        }
                        AppMethodBeat.o(184262);
                    }
                }).a(new f.c() {
                    /* class com.tencent.mm.pluginsdk.model.app.h.AnonymousClass7.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.widget.a.f.c
                    public final void e(boolean z, String str) {
                        AppMethodBeat.i(184261);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(14102, 0, 0, "", 0, str4, str2, str3);
                        if (alVar != null) {
                            alVar.v(false, true);
                        }
                        AppMethodBeat.o(184261);
                    }
                }).show();
                Boolean bool = Boolean.TRUE;
                AppMethodBeat.o(184263);
                return bool;
            }
        }).take().booleanValue();
        AppMethodBeat.o(151723);
        return booleanValue;
    }

    public static ShowMessageFromWX.Req c(Context context, WXMediaMessage wXMediaMessage, String str) {
        AppMethodBeat.i(151724);
        ShowMessageFromWX.Req req = new ShowMessageFromWX.Req();
        if (context == null) {
            context = MMApplicationContext.getContext();
        }
        req.message = wXMediaMessage;
        req.transaction = com.tencent.mm.b.g.getMessageDigest(new StringBuilder().append(Util.nowMilliSecond()).toString().getBytes());
        req.openId = str;
        req.lang = LocaleUtil.loadApplicationLanguage(context.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), context);
        req.country = (String) g.aAh().azQ().get(274436, (Object) null);
        AppMethodBeat.o(151724);
        return req;
    }

    public static String b(ResolveInfo resolveInfo) {
        AppMethodBeat.i(151725);
        if (resolveInfo == null) {
            AppMethodBeat.o(151725);
            return null;
        }
        String str = resolveInfo.resolvePackageName;
        if (TextUtils.isEmpty(str) && resolveInfo.activityInfo != null) {
            str = resolveInfo.activityInfo.packageName;
        }
        AppMethodBeat.o(151725);
        return str;
    }

    public static boolean bdC(String str) {
        AppMethodBeat.i(223750);
        if (str != null) {
            try {
                o oVar = new o(str);
                if (!oVar.exists() || !oVar.canRead()) {
                    AppMethodBeat.o(223750);
                    return false;
                }
                AppMethodBeat.o(223750);
                return true;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.AppInfoLogic", e2, "isFileExistAndReadable exception", new Object[0]);
                AppMethodBeat.o(223750);
                return false;
            }
        } else {
            AppMethodBeat.o(223750);
            return false;
        }
    }

    public static boolean bdD(String str) {
        AppMethodBeat.i(223751);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(223751);
            return false;
        } else if (str.startsWith("content")) {
            if (!bdE(str) || !bdC(str)) {
                AppMethodBeat.o(223751);
                return false;
            }
            AppMethodBeat.o(223751);
            return true;
        } else if (!Util.isFilePathSafeToBeCopySrc(str) || !bdC(str)) {
            AppMethodBeat.o(223751);
            return false;
        } else {
            AppMethodBeat.o(223751);
            return true;
        }
    }

    private static boolean bdE(String str) {
        AppMethodBeat.i(223752);
        String authority = Uri.parse(str).getAuthority();
        if (authority == null || (!authority.contains("com.tencent.mm") && !authority.contains("com.tencent.wmpf") && !authority.contains(MMApplicationContext.getApplicationId()))) {
            AppMethodBeat.o(223752);
            return true;
        }
        Log.e("MicroMsg.AppInfoLogic", "checkContentUri not valid: %s", str);
        AppMethodBeat.o(223752);
        return false;
    }

    public static int ahL(int i2) {
        if (i2 == 1) {
            return 19;
        }
        return -1;
    }

    public static g aJw(String str) {
        AppMethodBeat.i(263522);
        g o = o(str, true, false);
        AppMethodBeat.o(263522);
        return o;
    }

    public static List<g> is(Context context) {
        AppMethodBeat.i(151696);
        ArrayList arrayList = new ArrayList();
        if (a.C1616a.eAZ() == null) {
            Log.e("MicroMsg.AppInfoLogic", "getISubCorePluginBase() == null");
            AppMethodBeat.o(151696);
        } else {
            Cursor eAW = a.C1616a.eAZ().eAW();
            if (eAW == null) {
                AppMethodBeat.o(151696);
            } else {
                while (eAW.moveToNext()) {
                    g gVar = new g();
                    gVar.convertFrom(eAW);
                    if (gVar.field_status == 1) {
                        if (!s(context, gVar.field_appId)) {
                            gVar.field_status = 4;
                            a.C1616a.eAZ().g(gVar);
                        } else if (!Util.isNullOrNil(gVar.field_signature)) {
                            arrayList.add(gVar);
                        }
                    } else if (gVar.field_signature != null) {
                        arrayList.add(gVar);
                    }
                }
                eAW.close();
                AppMethodBeat.o(151696);
            }
        }
        return arrayList;
    }

    public static String r(Context context, String str) {
        AppMethodBeat.i(151705);
        String a2 = a(context, o(str, true, false), (String) null);
        AppMethodBeat.o(151705);
        return a2;
    }

    private static void bdB(String str) {
        AppMethodBeat.i(151719);
        if ("wx073f4a4daff0abe8".equalsIgnoreCase(str)) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(15413, 1, "", "");
        }
        AppMethodBeat.o(151719);
    }
}
