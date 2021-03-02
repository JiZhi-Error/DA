package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/CopyType;", "", "(Ljava/lang/String;I)V", "MP_SHORT_LINK", "PAGE_PATH", "luggage-wechat-full-sdk_release"})
public enum ad {
    MP_SHORT_LINK,
    PAGE_PATH;

    static {
        AppMethodBeat.i(230058);
        AppMethodBeat.o(230058);
    }

    public static ad valueOf(String str) {
        AppMethodBeat.i(230060);
        ad adVar = (ad) Enum.valueOf(ad.class, str);
        AppMethodBeat.o(230060);
        return adVar;
    }
}
