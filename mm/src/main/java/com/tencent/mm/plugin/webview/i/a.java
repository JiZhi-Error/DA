package com.tencent.mm.plugin.webview.i;

import com.facebook.login.widget.ToolTipPopup;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.i.p;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage;
import com.tencent.mm.plugin.appbrand.jsapi.share.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class a {
    private static final Map<Integer, Integer> JcP;
    private static final Map<Integer, Integer> JcQ;
    private static final Map<Integer, Integer> JcR;
    private static final Map<String, Integer> JcS;

    static {
        AppMethodBeat.i(224508);
        HashMap hashMap = new HashMap();
        hashMap.put(-1, 5);
        hashMap.put(-2, 6);
        hashMap.put(-3, 7);
        hashMap.put(-4, 8);
        hashMap.put(-5, 9);
        hashMap.put(-6, 10);
        hashMap.put(-7, 11);
        hashMap.put(-8, 12);
        hashMap.put(-9, 13);
        hashMap.put(-10, 14);
        hashMap.put(-11, 15);
        hashMap.put(-12, 16);
        hashMap.put(-13, 17);
        hashMap.put(-14, 18);
        hashMap.put(-15, 19);
        JcP = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(-1, 4);
        hashMap2.put(-2, 5);
        hashMap2.put(-3, 6);
        hashMap2.put(-4, 7);
        hashMap2.put(-5, 8);
        hashMap2.put(-6, 9);
        JcQ = Collections.unmodifiableMap(hashMap2);
        HashMap hashMap3 = new HashMap();
        hashMap3.put(0, 0);
        hashMap3.put(1, 1);
        hashMap3.put(2, 2);
        JcR = Collections.unmodifiableMap(hashMap3);
        HashMap hashMap4 = new HashMap();
        hashMap4.put("imagePreview", 2);
        hashMap4.put(Scopes.PROFILE, 3);
        hashMap4.put("addContact", 4);
        hashMap4.put(l.NAME, 7);
        hashMap4.put("scanQRCode", 8);
        hashMap4.put("hideOptionMenu", 10);
        hashMap4.put("getBrandWCPayRequest", 11);
        hashMap4.put("editAddress", 12);
        hashMap4.put("getLatestAddress", 13);
        hashMap4.put("jumpWCMall", 14);
        hashMap4.put("geoLocation", 15);
        hashMap4.put("openProductView", 16);
        hashMap4.put("openProductViewWithPid", 16);
        hashMap4.put(p.NAME, 17);
        hashMap4.put("hideMenuItems", 19);
        hashMap4.put(JsApiStartRecordVoice.NAME, 21);
        hashMap4.put(JsApiChooseImage.NAME, 22);
        hashMap4.put("scanCover", 23);
        hashMap4.put("openGameWebView", 28);
        JcS = Collections.unmodifiableMap(hashMap4);
        AppMethodBeat.o(224508);
    }

    public static int agk(int i2) {
        AppMethodBeat.i(224503);
        Integer num = JcP.get(Integer.valueOf(i2));
        if (num == null) {
            num = JcP.get(-1);
        }
        int intValue = num.intValue();
        AppMethodBeat.o(224503);
        return intValue;
    }

    public static int agl(int i2) {
        AppMethodBeat.i(224504);
        Integer num = JcQ.get(Integer.valueOf(i2));
        if (num == null) {
            num = JcQ.get(-1);
        }
        int intValue = num.intValue();
        AppMethodBeat.o(224504);
        return intValue;
    }

    public static int agm(int i2) {
        AppMethodBeat.i(224505);
        Integer num = JcR.get(Integer.valueOf(i2));
        if (num == null) {
            num = -1;
        }
        int intValue = num.intValue();
        AppMethodBeat.o(224505);
        return intValue;
    }

    public static int aZM(String str) {
        AppMethodBeat.i(224506);
        Integer num = JcS.get(str);
        if (num == null) {
            num = -1;
        }
        int intValue = num.intValue();
        AppMethodBeat.o(224506);
        return intValue;
    }

    public static int Me(long j2) {
        if (j2 < 0) {
            return -1;
        }
        if (j2 <= 2000) {
            return 1;
        }
        if (j2 <= ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME) {
            return 2;
        }
        if (j2 <= 12000) {
            return 3;
        }
        if (j2 <= Util.MILLSECONDS_OF_MINUTE) {
            return 4;
        }
        return 5;
    }

    public static void agn(int i2) {
        AppMethodBeat.i(224507);
        h.INSTANCE.idkeyStat(1061, (long) i2, 1, false);
        AppMethodBeat.o(224507);
    }
}
