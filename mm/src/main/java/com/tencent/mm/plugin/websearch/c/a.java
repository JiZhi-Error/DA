package com.tencent.mm.plugin.websearch.c;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.c.d;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.c;
import com.tencent.mm.ui.ao;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import java.util.HashMap;
import java.util.Map;

public final class a {
    public static String bd(Map<String, String> map) {
        AppMethodBeat.i(116763);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("file://");
        stringBuffer.append(ai.afw(3));
        stringBuffer.append("/app.html?");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            stringBuffer.append("&");
            stringBuffer.append(entry.getKey());
            stringBuffer.append("=");
            stringBuffer.append(entry.getValue());
        }
        if (!map.containsKey("sessionId")) {
            stringBuffer.append("&");
            stringBuffer.append("sessionId");
            stringBuffer.append("=");
            stringBuffer.append(ai.afq(Util.safeParseInt(map.get("scene"))));
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(116763);
        return stringBuffer2;
    }

    public static Map<String, String> br(int i2, boolean z) {
        AppMethodBeat.i(116764);
        Map<String, String> a2 = a(i2, z, 64, "");
        AppMethodBeat.o(116764);
        return a2;
    }

    public static Map<String, String> a(int i2, boolean z, int i3, String str) {
        boolean z2;
        AppMethodBeat.i(116765);
        HashMap hashMap = new HashMap();
        hashMap.put("scene", String.valueOf(i2));
        hashMap.put("type", String.valueOf(i3));
        hashMap.put("lang", LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()));
        hashMap.put(TPDownloadProxyEnum.USER_PLATFORM, "android");
        hashMap.put("version", String.valueOf(ai.aft(3)));
        hashMap.put("isHomePage", z ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        if (ao.isDarkMode()) {
            hashMap.put("isDarkMode", "1");
        }
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("extParams", str);
        }
        c Fu = d.aXu().Fu("100192");
        if (!Fu.isValid() || !"1".equals(Fu.gzz().get("openSearchSuggestion"))) {
            z2 = false;
        } else {
            z2 = true;
        }
        Log.i("MicroMsg.WxaFTSExportLogic", "genFTSParams scene = %d, isHomePage = %b, type = %d, isSug = %b", Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), Boolean.valueOf(z2));
        if (z2) {
            hashMap.put("isSug", "1");
        }
        AppMethodBeat.o(116765);
        return hashMap;
    }
}
