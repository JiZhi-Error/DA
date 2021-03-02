package com.tencent.mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import org.json.JSONObject;

public final class e {
    private static e rbj;
    public String rbk = ((String) g.aAh().azQ().get(ar.a.USERINFO_EMOJI_STORE_EXPT_MAIN_TAB_CONFIG_STRING, ""));
    public String rbl = ((String) g.aAh().azQ().get(ar.a.USERINFO_EMOJI_STORE_EXPT_CONFIG_STRING, ""));
    public boolean rbm = false;
    public boolean rbn = false;
    public String rbo;
    public String rbp;

    public static synchronized e cFX() {
        e eVar;
        synchronized (e.class) {
            AppMethodBeat.i(179053);
            if (rbj == null) {
                rbj = new e();
            }
            eVar = rbj;
            AppMethodBeat.o(179053);
        }
        return eVar;
    }

    public e() {
        AppMethodBeat.i(179054);
        cFY();
        AppMethodBeat.o(179054);
    }

    public final void cFY() {
        AppMethodBeat.i(179055);
        Log.i("MicroMsg.EmojiStoreExpt", "updateExpt: %s %s", this.rbl, this.rbk);
        try {
            if (!Util.isNullOrNil(this.rbl)) {
                this.rbm = Util.isEqual(h.FE(this.rbl).optString("second_strategy", "None"), "Paid");
            }
            if (!Util.isNullOrNil(this.rbk)) {
                JSONObject FE = h.FE(this.rbk);
                this.rbn = Util.isEqual(FE.optString("strategy", "Recommend"), "FriendDownloads");
                this.rbo = FE.optString("tab_wording");
                this.rbp = FE.optString("list_wording");
            }
            AppMethodBeat.o(179055);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.EmojiStoreExpt", e2, "", new Object[0]);
            this.rbm = false;
            this.rbn = false;
            AppMethodBeat.o(179055);
        }
    }
}
