package com.tencent.mm.plugin.lite;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.plugin.lite.a.a;
import com.tencent.mm.plugin.lite.b.f;
import com.tencent.mm.plugin.lite.launch.WxaLiteAppLaunchInfo;
import com.tencent.mm.plugin.lite.ui.WxaLiteAppListUI;
import com.tencent.mm.plugin.lite.ui.WxaLiteAppProxyUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class b implements a {
    private static long yDQ = 0;

    static /* synthetic */ void b(Context context, Bundle bundle, WxaLiteAppInfo wxaLiteAppInfo) {
        AppMethodBeat.i(198791);
        a(context, bundle, wxaLiteAppInfo);
        AppMethodBeat.o(198791);
    }

    @Override // com.tencent.mm.plugin.lite.a.a
    public final void a(Context context, Bundle bundle, boolean z, a.AbstractC1459a aVar) {
        boolean z2;
        AppMethodBeat.i(198784);
        if (!bundle.containsKey("appId")) {
            Log.e("MicroMsg.LiteApp.LiteAppService", "appId is required");
            AppMethodBeat.o(198784);
            return;
        }
        Log.i("MicroMsg.LiteApp.LiteAppService", "startLiteApp:".concat(String.valueOf(bundle.getString("appId"))));
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis <= yDQ || currentTimeMillis - yDQ > 500) {
            yDQ = currentTimeMillis;
            z2 = false;
        } else {
            Log.w("MicroMsg.LiteApp.LiteAppService", "reduplicate request, lasttime:%d, now:%d", Long.valueOf(yDQ), Long.valueOf(currentTimeMillis));
            h.INSTANCE.n(1293, 105, 1);
            StringBuilder sb = new StringBuilder();
            sb.append(bundle.getString("appId")).append(",").append(yDQ).append(",").append(currentTimeMillis);
            h.INSTANCE.kvStat(21018, sb.toString());
            z2 = true;
        }
        if (z2) {
            AppMethodBeat.o(198784);
            return;
        }
        h.INSTANCE.n(1293, 90, 1);
        String string = bundle.getString("appId");
        if (z) {
            h.INSTANCE.n(1293, 91, 1);
            a(context, bundle, string, aVar);
            AppMethodBeat.o(198784);
            return;
        }
        f.ecC();
        WxaLiteAppInfo aCT = f.aCT(string);
        if (aCT != null) {
            if (aVar != null) {
                aVar.dTt();
            }
            a(context, bundle, aCT);
            AppMethodBeat.o(198784);
            return;
        }
        Log.w("MicroMsg.LiteApp.LiteAppService", "get info return null, appid:".concat(String.valueOf(string)));
        h.INSTANCE.n(1293, 92, 1);
        h.INSTANCE.kvStat(20979, string);
        a(context, bundle, string, aVar);
        AppMethodBeat.o(198784);
    }

    private void a(final Context context, final Bundle bundle, final String str, final a.AbstractC1459a aVar) {
        AppMethodBeat.i(198785);
        f.ecC().a(str, new com.tencent.mm.plugin.lite.launch.a() {
            /* class com.tencent.mm.plugin.lite.b.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.lite.launch.a
            public final void a(WxaLiteAppInfo wxaLiteAppInfo) {
                AppMethodBeat.i(198782);
                if (aVar != null) {
                    aVar.dTt();
                }
                b.b(context, bundle, wxaLiteAppInfo);
                AppMethodBeat.o(198782);
            }

            @Override // com.tencent.mm.plugin.lite.launch.a
            public final void dTu() {
                AppMethodBeat.i(198783);
                if (aVar != null) {
                    aVar.dTu();
                }
                Log.w("MicroMsg.LiteApp.LiteAppService", "checkLiteApp fail:" + str);
                AppMethodBeat.o(198783);
            }
        });
        AppMethodBeat.o(198785);
    }

    private static void a(Context context, Bundle bundle, WxaLiteAppInfo wxaLiteAppInfo) {
        AppMethodBeat.i(198786);
        Log.i("MicroMsg.LiteApp.LiteAppService", "startLiteApp appid:" + wxaLiteAppInfo.appId + ", patchid:" + wxaLiteAppInfo.cri + ", updatetime:" + wxaLiteAppInfo.crj);
        h.INSTANCE.n(1293, 0, 1);
        WxaLiteAppLaunchInfo wxaLiteAppLaunchInfo = new WxaLiteAppLaunchInfo();
        wxaLiteAppLaunchInfo.setAppId(wxaLiteAppInfo.appId);
        wxaLiteAppLaunchInfo.pkgPath = wxaLiteAppInfo.path;
        wxaLiteAppLaunchInfo.crh = wxaLiteAppInfo.crh;
        wxaLiteAppLaunchInfo.startTime = System.currentTimeMillis();
        if (bundle.containsKey("path")) {
            wxaLiteAppLaunchInfo.path = bundle.getString("path");
        }
        if (bundle.containsKey(SearchIntents.EXTRA_QUERY)) {
            wxaLiteAppLaunchInfo.query = bundle.getString(SearchIntents.EXTRA_QUERY);
        }
        if (bundle.containsKey("qr_url_query_string")) {
            wxaLiteAppLaunchInfo.yEx = bundle.getString("qr_url_query_string");
        }
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setClass(MMApplicationContext.getContext(), WxaLiteAppProxyUI.class);
        intent.putExtra("WxaLiteAppLaunchInfo", wxaLiteAppLaunchInfo);
        intent.putExtra("bundle", bundle);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/lite/LiteAppService", "openLiteApp", "(Landroid/content/Context;Landroid/os/Bundle;Lcom/tencent/liteapp/storage/WxaLiteAppInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/lite/LiteAppService", "openLiteApp", "(Landroid/content/Context;Landroid/os/Bundle;Lcom/tencent/liteapp/storage/WxaLiteAppInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(198786);
    }

    @Override // com.tencent.mm.plugin.lite.a.a
    public final boolean ecx() {
        AppMethodBeat.i(198787);
        f.ecC();
        boolean ecx = f.ecx();
        AppMethodBeat.o(198787);
        return ecx;
    }

    @Override // com.tencent.mm.plugin.lite.a.a
    public final boolean aCR(String str) {
        AppMethodBeat.i(198788);
        f.ecC();
        boolean aCR = f.aCR(str);
        AppMethodBeat.o(198788);
        return aCR;
    }

    @Override // com.tencent.mm.plugin.lite.a.a
    public final void gr(Context context) {
        AppMethodBeat.i(198789);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(context, WxaLiteAppListUI.class));
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/lite/LiteAppService", "startLiteAppListUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/lite/LiteAppService", "startLiteAppListUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(198789);
    }

    @Override // com.tencent.mm.plugin.lite.a.a
    public final void iw(String str, String str2) {
        k kVar;
        AppMethodBeat.i(198790);
        f ecC = f.ecC();
        Log.i("MicroMsg.LiteApp.LiteAppLogic", "cpan offline registerOfflineResourceCallback clazzName:%s processName:%s", str2, str);
        if (Util.isNullOrNil(str2)) {
            Log.e("MicroMsg.LiteApp.LiteAppLogic", "get clazzName null.");
            AppMethodBeat.o(198790);
            return;
        }
        try {
            kVar = (k) Class.forName(str2).newInstance();
        } catch (ClassNotFoundException e2) {
            Log.e("MicroMsg.LiteApp.LiteAppLogic", "registerOfflineResourceCallback fail. %s", e2.toString());
            kVar = null;
        } catch (IllegalAccessException e3) {
            Log.e("MicroMsg.LiteApp.LiteAppLogic", "registerOfflineResourceCallback fail. %s", e3.toString());
            kVar = null;
        } catch (InstantiationException e4) {
            Log.e("MicroMsg.LiteApp.LiteAppLogic", "registerOfflineResourceCallback fail. %s", e4.toString());
            kVar = null;
        }
        if (kVar != null) {
            Log.i("MicroMsg.LiteApp.LiteAppLogic", "cpan offline registerOfflineResourceCallback success.");
            ecC.yEN.put(str, kVar);
        }
        AppMethodBeat.o(198790);
    }
}
