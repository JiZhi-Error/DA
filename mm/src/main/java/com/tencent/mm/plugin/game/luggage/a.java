package com.tencent.mm.plugin.game.luggage;

import android.os.Build;
import android.os.PowerManager;
import android.webkit.WebResourceResponse;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.d;
import com.tencent.mm.plugin.webview.ui.tools.game.BatteryManager;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import java.io.ByteArrayInputStream;
import java.util.HashMap;

@Deprecated
public final class a {
    public static WebResourceResponse pH(boolean z) {
        boolean z2;
        String replaceFirst;
        String str;
        AppMethodBeat.i(186825);
        Log.i("MicroMsg.GameScriptManager", "getGameScriptResponse");
        if (Build.VERSION.SDK_INT < 21) {
            AppMethodBeat.o(186825);
            return null;
        }
        String afA = d.afA("game.js");
        if (!Util.isNullOrNil(afA)) {
            String replaceFirst2 = afA.replaceFirst("#__usewepkg__#", String.valueOf(z));
            PowerManager powerManager = (PowerManager) MMApplicationContext.getContext().getSystemService("power");
            if (powerManager == null || Build.VERSION.SDK_INT < 21) {
                z2 = false;
            } else {
                z2 = powerManager.isPowerSaveMode();
            }
            String replaceFirst3 = replaceFirst2.replaceFirst("#__lowPowerMode__#", String.valueOf(z2)).replaceFirst("#__lowPower__#", String.valueOf(BatteryManager.xvy));
            if (com.tencent.mm.plugin.game.luggage.i.a.dTW() != null) {
                StringBuilder sb = new StringBuilder("\"");
                com.tencent.mm.plugin.game.luggage.i.a.dTW();
                switch (r0.xzp) {
                    case initing:
                        str = "initing";
                        break;
                    case inited:
                        str = "inited";
                        break;
                    case failed:
                        str = StateEvent.ProcessResult.FAILED;
                        break;
                    case stopped:
                        str = "stopped";
                        break;
                    case destroyed:
                        str = "destroyed";
                        break;
                    default:
                        str = "none";
                        break;
                }
                replaceFirst = replaceFirst3.replaceFirst("#__jscore_state__#", sb.append(str).append("\"").toString());
            } else {
                replaceFirst = replaceFirst3.replaceFirst("#__jscore_state__#", "\"none\"");
            }
            try {
                WebResourceResponse webResourceResponse = new WebResourceResponse("application/javascript", ProtocolPackage.ServerEncoding, new ByteArrayInputStream(replaceFirst.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET)));
                HashMap hashMap = new HashMap();
                hashMap.put("Cache-Control", "no-cache, no-store, must-revalidate");
                hashMap.put("Pragma", "no-cache");
                hashMap.put("Expires", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                webResourceResponse.setResponseHeaders(hashMap);
                Log.i("MicroMsg.GameScriptManager", "getGameScriptResponse end");
                AppMethodBeat.o(186825);
                return webResourceResponse;
            } catch (Exception e2) {
                Log.printDebugStack("MicroMsg.GameScriptManager", "", e2);
            }
        }
        AppMethodBeat.o(186825);
        return null;
    }
}
