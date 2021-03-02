package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.permission.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;

public final class n extends s {
    public static final int CTRL_INDEX = 519;
    public static final String NAME = "onVoIPChatSpeakersChanged";

    public n() {
        AppMethodBeat.i(180261);
        c.aem(NAME);
        AppMethodBeat.o(180261);
    }

    /* access modifiers changed from: package-private */
    public final void R(Map<String, Object> map) {
        AppMethodBeat.i(226944);
        Log.i("MicroMsg.OpenVoice.onVoIPChatMembersChangedJsEvent", "hy: speaker changed.");
        L(map).bEo();
        AppMethodBeat.o(226944);
    }
}
