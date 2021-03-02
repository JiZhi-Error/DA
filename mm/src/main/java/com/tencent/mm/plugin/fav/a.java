package com.tencent.mm.plugin.fav;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;

public final class a implements p {
    @Override // com.tencent.mm.plugin.messenger.foundation.a.p
    public final h.b a(String str, Map<String, String> map, h.a aVar) {
        AppMethodBeat.i(101532);
        Log.i("MicroMsg.Fav.FavNewXmlConsumer", "consumeNewXml subtype: %s values: %s", str, map.toString());
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1938535405:
                if (str.equals("resendfavitem")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1648140403:
                if (str.equals("uploadfavitem")) {
                    c2 = 0;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                hb hbVar = new hb();
                hbVar.dLm.type = 38;
                hbVar.dLm.dLv = map.get(".sysmsg.favids");
                EventCenter.instance.asyncPublish(hbVar, Looper.getMainLooper());
                com.tencent.mm.plugin.fav.a.h.HT(1);
                break;
            case 1:
                hb hbVar2 = new hb();
                hbVar2.dLm.type = 39;
                hbVar2.dLm.dLv = map.get(".sysmsg.favitem.favid");
                hbVar2.dLm.dLw = map.get(".sysmsg.favitem.dataidlist");
                EventCenter.instance.asyncPublish(hbVar2, Looper.getMainLooper());
                com.tencent.mm.plugin.fav.a.h.HT(0);
                break;
        }
        AppMethodBeat.o(101532);
        return null;
    }
}
