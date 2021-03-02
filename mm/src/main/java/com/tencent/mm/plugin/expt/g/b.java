package com.tencent.mm.plugin.expt.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;

public final class b {
    private static b sKh;
    private String name = null;

    public static b cRt() {
        AppMethodBeat.i(122358);
        if (sKh == null) {
            sKh = new b();
        }
        b bVar = sKh;
        AppMethodBeat.o(122358);
        return bVar;
    }

    private b() {
    }

    /* access modifiers changed from: package-private */
    public final MultiProcessMMKV VQ() {
        AppMethodBeat.i(122359);
        int azs = a.azs();
        if (azs == 0) {
            AppMethodBeat.o(122359);
            return null;
        }
        String str = azs + "_WxPageFlow";
        if (!Util.isEqual(this.name, str)) {
            Log.i("MicroMsg.MMPageFlowMMKV", "get mmkv change uin old[%s] new[%s]", this.name, str);
            this.name = str;
        }
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV(this.name);
        AppMethodBeat.o(122359);
        return mmkv;
    }

    public final void remove(String str) {
        AppMethodBeat.i(122360);
        MultiProcessMMKV VQ = VQ();
        if (VQ == null) {
            AppMethodBeat.o(122360);
            return;
        }
        VQ.remove(str);
        AppMethodBeat.o(122360);
    }

    public final String get(String str, String str2) {
        AppMethodBeat.i(122361);
        MultiProcessMMKV VQ = VQ();
        if (VQ == null) {
            AppMethodBeat.o(122361);
            return str2;
        }
        String string = VQ.getString(str, str2);
        AppMethodBeat.o(122361);
        return string;
    }

    public final String[] allKeys() {
        AppMethodBeat.i(122362);
        MultiProcessMMKV VQ = VQ();
        if (VQ == null) {
            AppMethodBeat.o(122362);
            return null;
        }
        String[] allKeys = VQ.allKeys();
        AppMethodBeat.o(122362);
        return allKeys;
    }
}
