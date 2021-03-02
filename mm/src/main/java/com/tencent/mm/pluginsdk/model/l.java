package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.r.a.a;
import com.tencent.mm.pluginsdk.model.app.aa;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class l implements u {
    public static boolean JUZ = false;
    private static l JVa;
    public a JVb;

    public interface a {
        void a(o oVar);
    }

    public static class b {
        public String JVc;
    }

    private l() {
    }

    public static l gms() {
        AppMethodBeat.i(30989);
        if (JVa == null) {
            JVa = new l();
        }
        l lVar = JVa;
        AppMethodBeat.o(30989);
        return lVar;
    }

    public final void gmt() {
        AppMethodBeat.i(30990);
        if (!bg.aAc()) {
            AppMethodBeat.o(30990);
            return;
        }
        ao.eAV().a(14, this);
        JUZ = true;
        AppMethodBeat.o(30990);
    }

    @Override // com.tencent.mm.pluginsdk.model.app.u
    public final void a(int i2, int i3, String str, aa aaVar) {
        AppMethodBeat.i(30991);
        if (!bg.aAc()) {
            AppMethodBeat.o(30991);
            return;
        }
        Log.d("MicroMsg.GetUserInfoInAppLogic", "onSceneEnd errType=%s errCode=%s", Integer.valueOf(i2), Integer.valueOf(i3));
        if (aaVar == null) {
            Log.e("MicroMsg.GetUserInfoInAppLogic", "scene == null");
            AppMethodBeat.o(30991);
            return;
        }
        if (i2 == 0 && i3 == 0) {
            switch (aaVar.getType()) {
                case 14:
                    if (MMApplicationContext.getContext() != null && a.C1616a.eAZ() != null) {
                        Log.e("MicroMsg.GetUserInfoInAppLogic", "NetSceneGetUserInfoInApp come back", Integer.valueOf(i2), Integer.valueOf(i3));
                        o oVar = (o) aaVar;
                        if (this.JVb != null) {
                            this.JVb.a(oVar);
                            break;
                        }
                    } else {
                        Log.e("MicroMsg.GetUserInfoInAppLogic", "wrong environment");
                        AppMethodBeat.o(30991);
                        return;
                    }
                    break;
            }
        }
        AppMethodBeat.o(30991);
    }

    public static b bdq(String str) {
        AppMethodBeat.i(30992);
        if (str == null) {
            AppMethodBeat.o(30992);
            return null;
        }
        Map<String, String> parseXml = XmlParser.parseXml(str, "PersonalAppSetting", null);
        if (parseXml == null) {
            AppMethodBeat.o(30992);
            return null;
        }
        String str2 = parseXml.get(".PersonalAppSetting.OpenID");
        if (Util.isNullOrNil(str2)) {
            AppMethodBeat.o(30992);
            return null;
        }
        b bVar = new b();
        bVar.JVc = str2;
        AppMethodBeat.o(30992);
        return bVar;
    }
}
