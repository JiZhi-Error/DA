package com.tencent.mm.plugin.appbrand.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.a.c;
import com.tencent.mm.ak.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.modelappbrand.m;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.ca;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.util.Map;

public enum d implements p {
    INSTANCE;

    public static d valueOf(String str) {
        AppMethodBeat.i(47712);
        d dVar = (d) Enum.valueOf(d.class, str);
        AppMethodBeat.o(47712);
        return dVar;
    }

    static {
        AppMethodBeat.i(47714);
        AppMethodBeat.o(47714);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.p
    public final h.b a(String str, Map<String, String> map, h.a aVar) {
        AppMethodBeat.i(47713);
        if (str == null || !str.equals("subscribesysmsg")) {
            Log.e("MicroMsg.WxaSubscribeSysmsgHandler", "subType is err, return");
            AppMethodBeat.o(47713);
            return null;
        }
        String str2 = map.get(".sysmsg.subscribesysmsg.content_template.link_list.link.share_key");
        if (Util.isNullOrNil(str2)) {
            Log.e("MicroMsg.WxaSubscribeSysmsgHandler", "shareKey is null, return");
            AppMethodBeat.o(47713);
            return null;
        }
        Log.i("MicroMsg.WxaSubscribeSysmsgHandler", "consumeNewXml subType:%s", str);
        c Lq = ((m) g.af(m.class)).Lq(str2);
        if (Lq == null) {
            Log.e("MicroMsg.WxaSubscribeSysmsgHandler", "shareKey:%s wxaUpdateableMsg is null, ingore", str2);
            AppMethodBeat.o(47713);
            return null;
        } else if (Lq.field_btnState != 2 || Lq.field_msgState != 0) {
            Log.e("MicroMsg.WxaSubscribeSysmsgHandler", "shareKey:%s btnState:%d msgState:%d ingore", str2, Integer.valueOf(Lq.field_btnState), Integer.valueOf(Lq.field_msgState));
            AppMethodBeat.o(47713);
            return null;
        } else if (aVar == null || aVar.heO == null) {
            Log.e("MicroMsg.WxaSubscribeSysmsgHandler", "addMsgInfo or addMsgInfo.addMsg is null! should not happen");
            AppMethodBeat.o(47713);
            return null;
        } else {
            de deVar = aVar.heO;
            String a2 = z.a(deVar.KHn);
            String a3 = z.a(deVar.KHl);
            String a4 = z.a(deVar.KHm);
            ca aJ = ((l) g.af(l.class)).eiy().aJ(a3, deVar.Brn);
            boolean z = false;
            if (aJ.field_msgId > 0) {
                z = true;
            }
            aJ.yF(deVar.Brn);
            if (!aVar.iLV || !aVar.iLX) {
                aJ.setCreateTime(bp.C(a3, (long) deVar.CreateTime));
            }
            aJ.setType(603979825);
            aJ.setContent(a2);
            aJ.nv(0);
            aJ.setStatus(3);
            if (a3.equals(com.tencent.mm.model.z.aTY())) {
                aJ.Cy(a4);
            } else {
                aJ.Cy(a3);
            }
            aJ.BB(deVar.KHq);
            bp.a(aJ, aVar);
            if (!z) {
                bp.x(aJ);
            } else {
                ((l) g.af(l.class)).eiy().b(deVar.Brn, aJ);
            }
            az bjY = ((l) g.af(l.class)).aST().bjY(aJ.field_talker);
            if (bjY != null) {
                bjY.oT(TPMediaCodecProfileLevel.HEVCHighTierLevel62);
                Log.d("MicroMsg.WxaSubscribeSysmsgHandler", "username:%s ok:%b", aJ.field_talker, Integer.valueOf(((l) g.af(l.class)).aST().a(bjY, aJ.field_talker)));
            } else {
                Log.d("MicroMsg.WxaSubscribeSysmsgHandler", "conv is null");
            }
            AppMethodBeat.o(47713);
            return null;
        }
    }
}
