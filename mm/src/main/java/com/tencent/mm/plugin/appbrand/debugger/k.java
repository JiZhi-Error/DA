package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.t;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class k implements q {
    @Override // com.tencent.mm.plugin.messenger.foundation.a.q
    public final void onNewXmlReceived(String str, Map<String, String> map, h.a aVar) {
        AppMethodBeat.i(44951);
        if (map != null) {
            String str2 = map.get(".sysmsg.DebugAppCodeUpdated.OpenAppInfo.AppID");
            String str3 = map.get(".sysmsg.DebugAppCodeUpdated.OpenAppInfo.UserName");
            String str4 = map.get(".sysmsg.DebugAppCodeUpdated.OpenAppInfo.Path");
            String str5 = map.get(".sysmsg.DebugAppCodeUpdated.OpenAppInfo.URL");
            String str6 = map.get(".sysmsg.DebugAppCodeUpdated.OpenAppInfo.MD5");
            String str7 = map.get(".sysmsg.DebugAppCodeUpdated.OpenAppInfo.ExtInfo");
            Log.i("MicroMsg.RemoteDebugCodeUpdateSysCmdMsgListener", "onNewXmlReceived appId %s, userName %s, path %s, url %s, md5 %s, extInfo %s", str2, str3, str4, str5, str6, str7);
            if (Util.isNullOrNil(str2) || Util.isNullOrNil(str3) || Util.isNullOrNil(str5)) {
                Log.i("MicroMsg.RemoteDebugCodeUpdateSysCmdMsgListener", "appId = %s, username = %s, codeURL = %s, invalid, return", str2, str3, str5);
                AppMethodBeat.o(44951);
                return;
            }
            if (n.buL().a(str2, 1, str5, str6, 0, Util.nowSecond() + 7200)) {
                com.tencent.mm.plugin.appbrand.task.h.bWb().cl(str2, 1);
            }
            LaunchParamsOptional launchParamsOptional = new LaunchParamsOptional();
            launchParamsOptional.iIt = str7;
            ((t) n.W(t.class)).A(str2, 1, str7);
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = 1101;
            appBrandStatObject.dCw = str2 + ":" + str3;
            AppBrandLaunchProxyUI.a(MMApplicationContext.getContext(), str3, str4, 1, -1, appBrandStatObject, launchParamsOptional);
        }
        AppMethodBeat.o(44951);
    }
}
