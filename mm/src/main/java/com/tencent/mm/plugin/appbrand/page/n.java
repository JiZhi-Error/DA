package com.tencent.mm.plugin.appbrand.page;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.f;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import java.util.HashMap;

public class n extends s {
    private static final int CTRL_INDEX = 49;
    public static final String NAME = "onAppEnterBackground";

    public final void ae(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(134999);
        HashMap hashMap = new HashMap(1);
        h.d Uc = h.Uc(appBrandRuntime.mAppId);
        String str = MessengerShareContentUtility.SHARE_BUTTON_HIDE;
        switch (Uc) {
            case CLOSE:
                str = "close";
                break;
            case BACK:
                str = "back";
                break;
            case LAUNCH_NATIVE_PAGE:
            case HOME_PRESSED:
            case HIDE:
                str = MessengerShareContentUtility.SHARE_BUTTON_HIDE;
                break;
            case HANG:
                str = "hang";
                break;
            case LAUNCH_MINI_PROGRAM:
                str = f.NAME;
                break;
        }
        hashMap.put("mode", str);
        L(hashMap).g(appBrandRuntime.NY()).bEo();
        AppMethodBeat.o(134999);
    }
}
