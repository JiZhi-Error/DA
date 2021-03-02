package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.model.cj;
import com.tencent.mm.modelsns.n;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.ad.timeline.b.e;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.model.a;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.dkg;
import com.tencent.mm.protocal.protobuf.eaq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.math.BigInteger;

public final class l implements cj.a {
    @Override // com.tencent.mm.model.cj.a
    public final void a(h.c cVar) {
    }

    @Override // com.tencent.mm.model.cj.a
    public final void a(h.a aVar) {
        AppMethodBeat.i(95187);
        if (aVar == null || aVar.heO == null || aVar.heO.KHn == null) {
            Log.i("MicroMsg.SimpleExperimentLsn", "recv null msg");
            AppMethodBeat.o(95187);
            return;
        }
        String a2 = z.a(aVar.heO.KHn);
        Log.d("MicroMsg.SimpleExperimentLsn", "recv addMsg ".concat(String.valueOf(a2)));
        String aK = aK(a2, "<TimelineObject", "</TimelineObject>");
        if (Util.isNullOrNil(aK)) {
            Log.i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  timelineObj tag");
            AppMethodBeat.o(95187);
            return;
        }
        String aK2 = aK(a2, "<RecXml", "</RecXml>");
        if (Util.isNullOrNil(aK2)) {
            Log.i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  RecXml tag");
            AppMethodBeat.o(95187);
            return;
        }
        String aK3 = aK(a2, "<ADInfo", "</ADInfo>");
        if (Util.isNullOrNil(aK3)) {
            Log.i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  ADInfo tag");
            AppMethodBeat.o(95187);
            return;
        }
        TimeLineObject PM = n.PM(aK);
        dkg dkg = new dkg();
        dkg.MOg = z.Su(aK3);
        eaq eaq = new eaq();
        dkg.MOf = eaq;
        eaq.Nad = z.Su(aK2);
        SnsObject snsObject = new SnsObject();
        snsObject.Id = new BigInteger(PM.Id).longValue();
        snsObject.CreateTime = PM.CreateTime;
        snsObject.Username = PM.UserName;
        snsObject.ObjectDesc = z.aC(aK.getBytes());
        eaq.MYH = snsObject;
        a.b(dkg);
        boolean aOd = k.aOd(aK2);
        ADXml aDXml = new ADXml(aK2);
        Log.i("MicroMsg.SimpleExperimentLsn", "isUsePreferedInfo=" + aOd + ", adXml.usePreferedInfo" + aDXml.usePreferedInfo);
        try {
            if (PM.ContentObj.LoV != null && PM.ContentObj.LoV.size() > 0) {
                PM.ContentObj.LoV.get(0).isAd = true;
            }
        } catch (Exception e2) {
            Log.i("MicroMsg.SimpleExperimentLsn", "onRecieveMsg, exp=" + e2.toString());
        }
        e.a(PM, aDXml, 2);
        AppMethodBeat.o(95187);
    }

    private static String aK(String str, String str2, String str3) {
        AppMethodBeat.i(95188);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2) || Util.isNullOrNil(str3)) {
            AppMethodBeat.o(95188);
            return "";
        }
        int indexOf = str.indexOf(str2);
        int indexOf2 = indexOf >= 0 ? str.indexOf(str3) : -1;
        if (indexOf < 0 || indexOf2 <= indexOf) {
            AppMethodBeat.o(95188);
            return "";
        }
        String substring = str.substring(indexOf, indexOf2 + str3.length());
        AppMethodBeat.o(95188);
        return substring;
    }
}
