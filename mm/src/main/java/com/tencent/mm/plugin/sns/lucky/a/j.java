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

public final class j implements cj.a {
    public static String TAG = "MicroMsg.NewYearSnsTips2016NotifyLsn";

    @Override // com.tencent.mm.model.cj.a
    public final void a(h.a aVar) {
        AppMethodBeat.i(95185);
        Log.i(TAG, "receivemsg NewYearSnsTips2016NotifyLsn");
        b.pl(74);
        if (aVar == null || aVar.heO == null) {
            Log.e(TAG, "onPreAddMessage cmdAM is null");
            AppMethodBeat.o(95185);
            return;
        }
        i iVar = new i();
        String a2 = z.a(aVar.heO.KHn);
        iVar.sb = new StringBuffer();
        Map<String, String> parseXml = XmlParser.parseXml(a2, "sysmsg", null);
        iVar.DGb.clear();
        if (parseXml == null) {
            Log.i("MicroMsg.NewYearSnsTips", "errr for paser %s", a2);
            b.pl(75);
        } else {
            int i2 = 0;
            while (true) {
                Object[] objArr = new Object[2];
                objArr[0] = i2 == 0 ? "" : String.valueOf(i2);
                objArr[1] = "BeginTime";
                long safeParseLong = Util.safeParseLong(parseXml.get(String.format(".sysmsg.NewYearSNSTips2016.Tips%s.%s", objArr)));
                iVar.sb.append("BeginTime:" + safeParseLong + ";");
                Object[] objArr2 = new Object[2];
                objArr2[0] = i2 == 0 ? "" : String.valueOf(i2);
                objArr2[1] = "EndTime";
                long safeParseLong2 = Util.safeParseLong(parseXml.get(String.format(".sysmsg.NewYearSNSTips2016.Tips%s.%s", objArr2)));
                iVar.sb.append("EndTime:" + safeParseLong2 + ";");
                Object[] objArr3 = new Object[2];
                objArr3[0] = i2 == 0 ? "" : String.valueOf(i2);
                objArr3[1] = "ActionID";
                String nullAs = Util.nullAs(parseXml.get(String.format(".sysmsg.NewYearSNSTips2016.Tips%s.%s", objArr3)), "");
                iVar.sb.append("ActionID:" + nullAs + ";");
                if (Util.isNullOrNil(nullAs)) {
                    break;
                }
                Object[] objArr4 = new Object[2];
                objArr4[0] = i2 == 0 ? "" : String.valueOf(i2);
                objArr4[1] = "TipsMessage";
                String nullAs2 = Util.nullAs(parseXml.get(String.format(".sysmsg.NewYearSNSTips2016.Tips%s.%s", objArr4)), "");
                iVar.sb.append("TipsMessage:" + nullAs2 + ";\n");
                h hVar = new h();
                hVar.DFY = nullAs;
                hVar.jfo = safeParseLong;
                hVar.oUH = safeParseLong2;
                hVar.DFZ = nullAs2;
                iVar.DGb.add(hVar);
                i2++;
            }
            if (iVar.DGb.size() == 0) {
                b.pl(76);
            }
        }
        Log.i("MicroMsg.NewYearSnsTips", "dump NewYearSnsTips " + iVar.sb.toString());
        g.aAi();
        g.aAh().azQ().set(ar.a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_TIP_STRING_SYNC, a2);
        g.aAi();
        g.aAh().azQ().gBI();
        AppMethodBeat.o(95185);
    }

    @Override // com.tencent.mm.model.cj.a
    public final void a(h.c cVar) {
    }
}
