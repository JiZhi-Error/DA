package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cj;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ar;
import java.util.Map;

public final class d implements cj.a {
    @Override // com.tencent.mm.model.cj.a
    public final void a(h.a aVar) {
        AppMethodBeat.i(95177);
        Log.i("MicroMsg.NewYearSNSAmountLevelCtrl2016NotifyLsn", "receivemsg NewYearSNSAmountLevelCtrl2016NotifyLsn");
        b.pl(67);
        if (aVar == null || aVar.heO == null) {
            Log.e("MicroMsg.NewYearSNSAmountLevelCtrl2016NotifyLsn", "onPreAddMessage cmdAM is null");
            AppMethodBeat.o(95177);
            return;
        }
        e eVar = new e();
        String a2 = z.a(aVar.heO.KHn);
        eVar.sb = new StringBuffer();
        Map<String, String> parseXml = XmlParser.parseXml(a2, "sysmsg", null);
        eVar.level = 0;
        if (parseXml == null) {
            Log.i("MicroMsg.NewYearSnsAmountLevel", "errr for paser %s", a2);
            b.pl(68);
        } else {
            eVar.level = Util.safeParseInt(parseXml.get(".sysmsg.NewYearSNSAmountLevelCtrl2016.Level"));
            Log.i("MicroMsg.NewYearSnsAmountLevel", "get level %d", Integer.valueOf(eVar.level));
            if (eVar.level == 0) {
                b.pl(69);
            } else if (eVar.level == 1) {
                b.pl(70);
            } else if (eVar.level == 2) {
                b.pl(71);
            } else if (eVar.level == 3) {
                b.pl(72);
            } else if (eVar.level == 4) {
                b.pl(73);
            }
        }
        Log.i("MicroMsg.NewYearSnsAmountLevel", "dump NewYearSnsAmountLevel " + eVar.sb.toString());
        g.aAi();
        g.aAh().azQ().set(ar.a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_LEVELCTRL_STRING_SYNC, a2);
        g.aAi();
        g.aAh().azQ().gBI();
        AppMethodBeat.o(95177);
    }

    @Override // com.tencent.mm.model.cj.a
    public final void a(h.c cVar) {
    }
}
