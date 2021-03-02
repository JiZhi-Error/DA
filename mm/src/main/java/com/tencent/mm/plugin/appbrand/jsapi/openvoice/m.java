package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.permission.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;

public final class m extends s {
    public static final int CTRL_INDEX = 518;
    public static final String NAME = "onVoIPChatMembersChanged";

    public m() {
        AppMethodBeat.i(180260);
        c.aem(NAME);
        AppMethodBeat.o(180260);
    }

    /* access modifiers changed from: package-private */
    public final void R(Map<String, Object> map) {
        AppMethodBeat.i(226943);
        Log.i("MicroMsg.OpenVoice.onVoIPChatMembersChangedJsEvent", "hy: dispatch member change");
        L(map).bEo();
        AppMethodBeat.o(226943);
    }
}
