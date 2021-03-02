package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/utils/WeChatUserAuthorizedHelper;", "Lcom/tencent/mm/plugin/appbrand/jsapi/IUserAuthorizedHelper;", "()V", "isUserAuthorized", "", "plugin-appbrand-integration_release"})
public final class al implements ai {
    @Override // com.tencent.mm.plugin.appbrand.jsapi.ai
    public final boolean bEm() {
        AppMethodBeat.i(180718);
        if (!ChannelUtil.shouldShowGprsAlert || !MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getBoolean("gprs_alert", true)) {
            AppMethodBeat.o(180718);
            return true;
        }
        AppMethodBeat.o(180718);
        return false;
    }
}
