package com.tencent.mm.plugin.profile;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cg;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.profile.b.e;
import com.tencent.mm.plugin.profile.ui.newbizinfo.d.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;
import java.util.Map;

public final class d implements bd {
    private static HashMap<Integer, h.b> baseDBFactories = new HashMap<>();
    private volatile a BcF;
    private q BcG = new q() {
        /* class com.tencent.mm.plugin.profile.d.AnonymousClass2 */

        @Override // com.tencent.mm.plugin.messenger.foundation.a.q
        public final void onNewXmlReceived(String str, Map<String, String> map, h.a aVar) {
            AppMethodBeat.i(26859);
            if (Util.nullAsNil(str).equals("NewXmlOpenIMFriReqAcceptedInWxWork")) {
                new e(map).ben();
            }
            AppMethodBeat.o(26859);
        }
    };

    public d() {
        AppMethodBeat.i(26860);
        AppMethodBeat.o(26860);
    }

    static {
        AppMethodBeat.i(26866);
        b.a(new com.tencent.mm.plugin.profile.ui.newbizinfo.a.a(), "//usenewprofile");
        baseDBFactories.put(Integer.valueOf("NEW_BIZINFO_PROFILE_INFO_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.profile.d.AnonymousClass1 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return a.iBh;
            }
        });
        AppMethodBeat.o(26866);
    }

    @Override // com.tencent.mm.model.bd
    public final HashMap<Integer, h.b> getBaseDBFactories() {
        return baseDBFactories;
    }

    public static a eDO() {
        AppMethodBeat.i(26861);
        g.aAf().azk();
        if (eDP().BcF == null) {
            d eDP = eDP();
            bg.aVF();
            eDP.BcF = new a(c.getDataDB());
        }
        a aVar = eDP().BcF;
        AppMethodBeat.o(26861);
        return aVar;
    }

    private static d eDP() {
        AppMethodBeat.i(26862);
        bg.aVz();
        d dVar = (d) cg.KG("plugin.profile");
        if (dVar == null) {
            Log.w("MicroMsg.SubCoreProfile", "not found in MMCore, new one");
            dVar = new d();
            bg.aVz().a("plugin.freewifi", dVar);
        }
        AppMethodBeat.o(26862);
        return dVar;
    }

    @Override // com.tencent.mm.model.bd
    public final void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountPostReset(boolean z) {
        AppMethodBeat.i(26863);
        ((s) g.ah(s.class)).getSysCmdMsgExtension().a("NewXmlOpenIMFriReqAcceptedInWxWork", this.BcG);
        AppMethodBeat.o(26863);
    }

    @Override // com.tencent.mm.model.bd
    public final void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountRelease() {
        AppMethodBeat.i(26864);
        ((s) g.ah(s.class)).getSysCmdMsgExtension().b("NewXmlOpenIMFriReqAcceptedInWxWork", this.BcG);
        AppMethodBeat.o(26864);
    }

    public static int aP(Intent intent) {
        AppMethodBeat.i(26865);
        if (intent != null) {
            int intExtra = intent.getIntExtra("CONTACT_INFO_UI_SOURCE", 0);
            Log.d("MicroMsg.SubCoreProfile", "[getPrefixAddScene] source:".concat(String.valueOf(intExtra)));
            AppMethodBeat.o(26865);
            return intExtra;
        }
        AppMethodBeat.o(26865);
        return 0;
    }
}
