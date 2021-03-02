package com.tencent.mm.plugin.sns.ad.widget.living;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.a.g;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.bz;
import org.json.JSONObject;

public final class a {
    public static bz[] q(SnsInfo snsInfo) {
        bz[] bzVarArr = null;
        AppMethodBeat.i(202407);
        if (snsInfo == null || snsInfo.getAdXml() == null || snsInfo.getAdXml().adLiveInfo == null) {
            AppMethodBeat.o(202407);
        } else {
            g gVar = snsInfo.getAdXml().adLiveInfo;
            if (gVar.liveType == 0) {
                bzVarArr = new bz[1];
                try {
                    bz bzVar = new bz();
                    bzVar.pTI = 2;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.putOpt("liveParams", gVar.DrY);
                    bzVar.data = jSONObject.toString();
                    bzVarArr[0] = bzVar;
                } catch (Throwable th) {
                }
            }
            AppMethodBeat.o(202407);
        }
        return bzVarArr;
    }
}
