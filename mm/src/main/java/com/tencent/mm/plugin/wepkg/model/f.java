package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.utils.a;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.WebResourceResponse;
import java.util.HashMap;
import java.util.Map;

public final class f {
    private Map<String, h> JMX = new HashMap();
    private int qhk = 1;

    public f() {
        AppMethodBeat.i(110678);
        AppMethodBeat.o(110678);
    }

    public final void bcA(String str) {
        AppMethodBeat.i(110679);
        if (this.qhk > 3) {
            Log.i("MicroMsg.Wepkg.SupportIframe", "more than 3 wepkgs");
            AppMethodBeat.o(110679);
            return;
        }
        String bcO = d.bcO(str);
        if (!Util.isNullOrNil(bcO) && this.JMX.get(bcO) == null) {
            this.qhk++;
            h bcc = com.tencent.mm.plugin.wepkg.d.bcc(bcO);
            if (bcc != null) {
                this.JMX.put(bcO, bcc);
                AppMethodBeat.o(110679);
                return;
            }
            h cU = com.tencent.mm.plugin.wepkg.d.cU(str, true);
            if (!(cU == null || cU.JNh == null)) {
                this.JMX.put(bcO, cU);
                a.b("EnterWeb", str, cU.JNh.hhD, cU.JNh.version, 1, 0, null);
                Log.i("MicroMsg.Wepkg.SupportIframe", "load wepkg: %s", bcO);
            }
        }
        AppMethodBeat.o(110679);
    }

    public final WebResourceResponse bcB(String str) {
        AppMethodBeat.i(110680);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(110680);
            return null;
        }
        for (h hVar : this.JMX.values()) {
            WebResourceResponse bcB = hVar.bcB(str);
            if (bcB != null) {
                Log.i("MicroMsg.Wepkg.SupportIframe", "hit rid: %s", str);
                AppMethodBeat.o(110680);
                return bcB;
            }
        }
        AppMethodBeat.o(110680);
        return null;
    }
}
