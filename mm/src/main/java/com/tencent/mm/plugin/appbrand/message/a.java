package com.tencent.mm.plugin.appbrand.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.ca;
import java.util.Map;

public enum a implements p {
    INSTANCE;

    public static a valueOf(String str) {
        AppMethodBeat.i(227187);
        a aVar = (a) Enum.valueOf(a.class, str);
        AppMethodBeat.o(227187);
        return aVar;
    }

    static {
        AppMethodBeat.i(227189);
        AppMethodBeat.o(227189);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.p
    public final h.b a(String str, Map<String, String> map, h.a aVar) {
        String str2;
        AppMethodBeat.i(227188);
        if (str == null || !str.equals("weapp_pushmsg")) {
            Log.e("MicroMsg.WxaAppBrandNotifyMsgHandler", "subType is err, return");
            AppMethodBeat.o(227188);
            return null;
        }
        Log.i("MicroMsg.WxaAppBrandNotifyMsgHandler", "consumeNewXml subType:%s", str);
        String str3 = map.get(".sysmsg.weapp_pushmsg.title");
        if (Util.isNullOrNil(str3)) {
            Log.e("MicroMsg.WxaAppBrandNotifyMsgHandler", "title is null, return");
            AppMethodBeat.o(227188);
            return null;
        } else if (Util.isNullOrNil(map.get(".sysmsg.weapp_pushmsg.wxa_nickname"))) {
            Log.e("MicroMsg.WxaAppBrandNotifyMsgHandler", "nickname is null, return");
            AppMethodBeat.o(227188);
            return null;
        } else {
            String str4 = map.get(".sysmsg.weapp_pushmsg.busi_msgid");
            if (Util.isNullOrNil(str4)) {
                Log.e("MicroMsg.WxaAppBrandNotifyMsgHandler", "msgId is null, return");
                AppMethodBeat.o(227188);
                return null;
            } else if (aVar == null || aVar.heO == null) {
                Log.e("MicroMsg.WxaAppBrandNotifyMsgHandler", "addMsgInfo or addMsgInfo.addMsg is null! should not happen");
                AppMethodBeat.o(227188);
                return null;
            } else {
                String str5 = map.get(".sysmsg.weapp_pushmsg.weappinfo.appid");
                if (Util.isNullOrNil(str5)) {
                    Log.w("MicroMsg.WxaAppBrandNotifyMsgHandler", "appId is null");
                }
                String str6 = map.get(".sysmsg.weapp_pushmsg.weappinfo.pagepath");
                if (Util.isNullOrNil(str6)) {
                    Log.w("MicroMsg.WxaAppBrandNotifyMsgHandler", "pagePath is null");
                }
                de deVar = aVar.heO;
                String a2 = z.a(deVar.KHn);
                String a3 = z.a(deVar.KHl);
                ca aJ = ((l) g.af(l.class)).eiy().aJ(a3, deVar.Brn);
                boolean z = false;
                if (aJ.field_msgId > 0) {
                    z = true;
                }
                aJ.yF(deVar.Brn);
                aJ.setCreateTime(bp.C(a3, (long) deVar.CreateTime));
                aJ.setType(872415281);
                aJ.setContent(a2);
                aJ.nv(0);
                aJ.setStatus(3);
                aJ.Cy("appbrand_notify_message");
                aJ.BB(deVar.KHq);
                aJ.ean = String.valueOf(System.currentTimeMillis());
                aJ.fqk = true;
                if (bp.Ku("appbrand_notify_message") == 0) {
                    Log.i("MicroMsg.WxaAppBrandNotifyMsgHandler", "empty appbrand notify message, insert tips message");
                    ca caVar = new ca();
                    caVar.setType(872415281);
                    caVar.Cy("appbrand_notify_message");
                    caVar.setContent("");
                    caVar.setCreateTime(aJ.field_createTime - 1);
                    caVar.nv(2);
                    caVar.setStatus(4);
                    bp.x(caVar);
                }
                bp.a(aJ, aVar);
                if (!z) {
                    bp.x(aJ);
                } else {
                    ((l) g.af(l.class)).eiy().b(deVar.Brn, aJ);
                }
                az bjY = ((l) g.af(l.class)).aST().bjY("appbrand_notify_message");
                if (bjY != null) {
                    bjY.oT(134217728);
                    Log.d("MicroMsg.WxaAppBrandNotifyMsgHandler", "username:%s ok:%b", aJ.field_talker, Integer.valueOf(((l) g.af(l.class)).aST().a(bjY, "appbrand_notify_message")));
                } else {
                    Log.d("MicroMsg.WxaAppBrandNotifyMsgHandler", "conv is null");
                }
                com.tencent.mm.plugin.appbrand.service.g gVar = (com.tencent.mm.plugin.appbrand.service.g) g.af(com.tencent.mm.plugin.appbrand.service.g.class);
                if (gVar != null) {
                    str2 = gVar.bul();
                } else {
                    str2 = null;
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(19724, 3, 0, 0, 0, 0, null, 0, 0, 0, str5, str6, null, str4, 0, null, com.tencent.mm.ag.a.a.HL(str3), 0, null, null, str2);
                AppMethodBeat.o(227188);
                return null;
            }
        }
    }
}
