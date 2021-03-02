package com.tencent.mm.plugin.lite.b;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.h.d;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import com.tencent.mm.plugin.lite.launch.a;
import com.tencent.mm.plugin.lite.storage.LiteAppContentProvider;
import com.tencent.mm.plugin.lite.storage.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tenpay.android.wechat.PayuSecureEncrypt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class f {
    public static f yEM;
    public HashMap<String, k> yEN = new HashMap<>();

    private f() {
        AppMethodBeat.i(198872);
        AppMethodBeat.o(198872);
    }

    public static f ecC() {
        AppMethodBeat.i(198873);
        if (yEM == null) {
            synchronized (f.class) {
                try {
                    yEM = new f();
                } catch (Throwable th) {
                    AppMethodBeat.o(198873);
                    throw th;
                }
            }
        }
        f fVar = yEM;
        AppMethodBeat.o(198873);
        return fVar;
    }

    public static Uri getUri() {
        AppMethodBeat.i(198874);
        Uri parse = Uri.parse("content://" + LiteAppContentProvider.AUTHORITY + FilePathGenerator.ANDROID_DIR_SEP);
        AppMethodBeat.o(198874);
        return parse;
    }

    public static List<WxaLiteAppInfo> ecD() {
        AppMethodBeat.i(198875);
        Bundle call = MMApplicationContext.getContext().getContentResolver().call(getUri(), "getLiteAppList", (String) null, (Bundle) null);
        if (call == null || !call.containsKey("LiteAppList")) {
            AppMethodBeat.o(198875);
            return null;
        }
        ArrayList parcelableArrayList = call.getParcelableArrayList("LiteAppList");
        AppMethodBeat.o(198875);
        return parcelableArrayList;
    }

    public static WxaLiteAppInfo aCT(String str) {
        Bundle bundle;
        AppMethodBeat.i(198876);
        try {
            bundle = MMApplicationContext.getContext().getContentResolver().call(getUri(), "getLiteAppInfo", str, (Bundle) null);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.LiteApp.LiteAppLogic", e2, "", new Object[0]);
            bundle = null;
        }
        if (bundle == null) {
            Log.i("MicroMsg.LiteApp.LiteAppLogic", "null == bundle, appId:".concat(String.valueOf(str)));
            AppMethodBeat.o(198876);
            return null;
        }
        bundle.setClassLoader(WxaLiteAppInfo.class.getClassLoader());
        WxaLiteAppInfo wxaLiteAppInfo = (WxaLiteAppInfo) bundle.getParcelable("LiteApp");
        AppMethodBeat.o(198876);
        return wxaLiteAppInfo;
    }

    public static c aCU(String str) {
        Bundle bundle;
        AppMethodBeat.i(198877);
        try {
            bundle = MMApplicationContext.getContext().getContentResolver().call(getUri(), "getLiteAppAuthInfo", str, (Bundle) null);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.LiteApp.LiteAppLogic", e2, "", new Object[0]);
            bundle = null;
        }
        if (bundle == null) {
            AppMethodBeat.o(198877);
            return null;
        }
        c cVar = new c();
        cVar.field_host = bundle.getString("host");
        cVar.field_param = bundle.getString("param");
        cVar.field_paramMap = bundle.getString("paramMap");
        cVar.field_headerMap = bundle.getString("headerMap");
        cVar.field_updateTime = bundle.getLong(ch.COL_UPDATETIME);
        AppMethodBeat.o(198877);
        return cVar;
    }

    public static void b(WxaLiteAppInfo wxaLiteAppInfo) {
        AppMethodBeat.i(198878);
        if (Util.isNullOrNil(wxaLiteAppInfo.path)) {
            Log.e("MicroMsg.LiteApp.LiteAppLogic", "app path is empty.");
            AppMethodBeat.o(198878);
        } else if (!new o(wxaLiteAppInfo.path).exists()) {
            Log.e("MicroMsg.LiteApp.LiteAppLogic", "app file isn't exist.");
            AppMethodBeat.o(198878);
        } else {
            String aw = h.aw(wxaLiteAppInfo.appId, wxaLiteAppInfo.cri, wxaLiteAppInfo.md5);
            if (!aw.equalsIgnoreCase(wxaLiteAppInfo.path)) {
                Log.i("MicroMsg.LiteApp.LiteAppLogic", "rename app folder from %s to %s", wxaLiteAppInfo.path, aw);
                s.cL(wxaLiteAppInfo.path, aw);
                wxaLiteAppInfo.path = aw;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable("LiteApp", wxaLiteAppInfo);
            try {
                MMApplicationContext.getContext().getContentResolver().call(getUri(), "insertLiteAppInfo", wxaLiteAppInfo.appId, bundle);
                AppMethodBeat.o(198878);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.LiteApp.LiteAppLogic", e2, "", new Object[0]);
                AppMethodBeat.o(198878);
            }
        }
    }

    public static void c(WxaLiteAppInfo wxaLiteAppInfo) {
        AppMethodBeat.i(198879);
        if (wxaLiteAppInfo.appId.equalsIgnoreCase("wxalitecce81f5fba338df4dd5f74df8229c600")) {
            MultiProcessMMKV multiDefault = MultiProcessMMKV.getMultiDefault();
            multiDefault.putString("wxa_lite_app_game_center_version", wxaLiteAppInfo.cri);
            multiDefault.commit();
        }
        AppMethodBeat.o(198879);
    }

    public static WxaLiteAppInfo ecE() {
        AppMethodBeat.i(198880);
        ecC();
        WxaLiteAppInfo aCT = aCT(LiteAppCenter.LITE_APP_BASE_LIB);
        AppMethodBeat.o(198880);
        return aCT;
    }

    public final void ecF() {
        AppMethodBeat.i(198881);
        final WxaLiteAppInfo ecE = ecE();
        ecC().a(LiteAppCenter.LITE_APP_BASE_LIB, new a() {
            /* class com.tencent.mm.plugin.lite.b.f.AnonymousClass1 */

            /* JADX WARNING: Code restructure failed: missing block: B:8:0x0026, code lost:
                if (com.tencent.mm.plugin.lite.b.f.aCR(com.tencent.mm.plugin.lite.LiteAppCenter.LITE_APP_BASE_LIB) != false) goto L_0x0028;
             */
            @Override // com.tencent.mm.plugin.lite.launch.a
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void a(com.tencent.liteapp.storage.WxaLiteAppInfo r5) {
                /*
                    r4 = this;
                    r3 = 198870(0x308d6, float:2.78676E-40)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                    if (r5 != 0) goto L_0x000c
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                L_0x000b:
                    return
                L_0x000c:
                    com.tencent.liteapp.storage.WxaLiteAppInfo r0 = r0
                    if (r0 == 0) goto L_0x0028
                    com.tencent.liteapp.storage.WxaLiteAppInfo r0 = r0
                    java.lang.String r0 = r0.path
                    java.lang.String r1 = r5.path
                    boolean r0 = r0.equals(r1)
                    if (r0 != 0) goto L_0x0053
                    com.tencent.mm.plugin.lite.b.f.ecC()
                    java.lang.String r0 = "wxalitebaselibrary"
                    boolean r0 = com.tencent.mm.plugin.lite.b.f.aCR(r0)
                    if (r0 == 0) goto L_0x0053
                L_0x0028:
                    android.content.Intent r0 = new android.content.Intent
                    r0.<init>()
                    android.content.Context r1 = com.tencent.mm.sdk.platformtools.MMApplicationContext.getContext()
                    java.lang.Class<com.tencent.mm.plugin.lite.LiteAppTaskPreloadReceiver> r2 = com.tencent.mm.plugin.lite.LiteAppTaskPreloadReceiver.class
                    r0.setClass(r1, r2)
                    r1 = 268435456(0x10000000, float:2.5243549E-29)
                    r0.addFlags(r1)
                    java.lang.String r1 = "task"
                    java.lang.String r2 = "updateBaseLibPath"
                    r0.putExtra(r1, r2)
                    java.lang.String r1 = "path"
                    java.lang.String r2 = r5.path
                    r0.putExtra(r1, r2)
                    android.content.Context r1 = com.tencent.mm.sdk.platformtools.MMApplicationContext.getContext()
                    r1.sendBroadcast(r0)
                L_0x0053:
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                    goto L_0x000b
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.lite.b.f.AnonymousClass1.a(com.tencent.liteapp.storage.WxaLiteAppInfo):void");
            }

            @Override // com.tencent.mm.plugin.lite.launch.a
            public final void dTu() {
            }
        });
        AppMethodBeat.o(198881);
    }

    public final void a(final String str, final a aVar) {
        String str2;
        AppMethodBeat.i(198882);
        Log.i("MicroMsg.LiteApp.LiteAppLogic", "checkLiteApp appId:%s", str);
        final WxaLiteAppInfo aCT = aCT(str);
        if (d(aCT)) {
            if (aCT == null || aCT.cri == null || aCT.cri.isEmpty()) {
                str2 = "";
            } else {
                str2 = aCT.cri;
            }
            Log.i("MicroMsg.LiteApp.LiteAppLogic", "begin to checkLiteApp:%s patchId:%s", str, str2);
            ((com.tencent.mm.plugin.boots.a.c) g.af(com.tencent.mm.plugin.boots.a.c.class)).a(str, str, str2, new com.tencent.mm.plugin.boots.a.f() {
                /* class com.tencent.mm.plugin.lite.b.f.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.boots.a.f
                public final void a(com.tencent.mm.plugin.boots.a.g gVar) {
                    AppMethodBeat.i(198871);
                    if (!Util.isNullOrNil(gVar.pkK)) {
                        Log.i("MicroMsg.LiteApp.LiteAppLogic", "start to download liteapp:" + str + ", url:" + gVar.pkK);
                        e.INSTANCE.a(gVar, "release", aVar);
                        AppMethodBeat.o(198871);
                        return;
                    }
                    Log.i("MicroMsg.LiteApp.LiteAppLogic", "checkLiteApp, url is null, appId:" + str);
                    if (aVar != null) {
                        if (aCT != null) {
                            aVar.a(aCT);
                            AppMethodBeat.o(198871);
                            return;
                        }
                        aVar.dTu();
                    }
                    AppMethodBeat.o(198871);
                }
            });
            AppMethodBeat.o(198882);
            return;
        }
        Log.i("MicroMsg.LiteApp.LiteAppLogic", "no need download, local pkg is debug");
        if (aVar != null) {
            aVar.a(aCT);
        }
        AppMethodBeat.o(198882);
    }

    private static boolean d(WxaLiteAppInfo wxaLiteAppInfo) {
        AppMethodBeat.i(198883);
        if (wxaLiteAppInfo == null) {
            AppMethodBeat.o(198883);
            return true;
        } else if (wxaLiteAppInfo.KB()) {
            AppMethodBeat.o(198883);
            return false;
        } else {
            AppMethodBeat.o(198883);
            return true;
        }
    }

    public static boolean ecx() {
        AppMethodBeat.i(198884);
        com.tencent.mm.plugin.expansions.a.cMr();
        if (((b) g.af(b.class)).a(b.a.clicfg_global_liteapp_enable, 1) == 1) {
            AppMethodBeat.o(198884);
            return true;
        }
        AppMethodBeat.o(198884);
        return false;
    }

    public static boolean aCR(String str) {
        AppMethodBeat.i(198885);
        String format = String.format("clicfg_liteapp_%s_enable", str);
        String format2 = String.format("clicfg_liteapp_%s_max_crash", str);
        if (!MMApplicationContext.isMainProcess() || !ecx()) {
            Log.i("MicroMsg.LiteApp.LiteAppLogic", "can no get 'isLiteAppOpen' value when is no mm process.");
            AppMethodBeat.o(198885);
            return false;
        }
        boolean equalsIgnoreCase = d.cRY().gA(format, AppEventsConstants.EVENT_PARAM_VALUE_NO).equalsIgnoreCase("1");
        int i2 = Util.getInt(d.cRY().gA(format2, PayuSecureEncrypt.ENCRYPT_VERSION_DEFAULT), 10);
        WxaLiteAppInfo aCT = aCT(str);
        String str2 = aCT == null ? "" : aCT.cri;
        int i3 = MultiProcessMMKV.getMultiDefault().getInt(String.format("liteapp_%s_%s", str, str2), 0);
        Log.i("MicroMsg.LiteApp.LiteAppLogic", "isLiteAppOpen appId%s version%s enable:%b, crashCount:%d", str, str2, Boolean.valueOf(equalsIgnoreCase), Integer.valueOf(i3));
        if (!equalsIgnoreCase) {
            h.INSTANCE.n(1293, 102, 1);
        } else if (i3 < i2) {
            h.INSTANCE.n(1293, 100, 1);
            AppMethodBeat.o(198885);
            return true;
        } else {
            h.INSTANCE.n(1293, 101, 1);
        }
        AppMethodBeat.o(198885);
        return false;
    }
}
