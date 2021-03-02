package com.tencent.mm.cn;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import java.util.Arrays;
import java.util.List;

public final class a {
    public static final WeChatBrands.AppInfo.WhichApp RwA;
    public static final List<WeChatBrands.AppInfo.WhichApp> RwB = Arrays.asList(Rwz, Rwx, Rwy);
    public static final WeChatBrands.AppInfo.WhichApp Rwx = new WeChatBrands.AppInfo.WhichApp("com.wechat.mm", "WeChatUSApp", 3);
    public static final WeChatBrands.AppInfo.WhichApp Rwy = new WeChatBrands.AppInfo.WhichApp("com.wechatus.im", "WeChatUSApp", 3);
    public static final WeChatBrands.AppInfo.WhichApp Rwz;

    static {
        AppMethodBeat.i(200985);
        WeChatBrands.AppInfo.WhichApp whichApp = new WeChatBrands.AppInfo.WhichApp("com.tencent.mm", "Weixin", 0);
        Rwz = whichApp;
        RwA = whichApp;
        AppMethodBeat.o(200985);
    }
}
