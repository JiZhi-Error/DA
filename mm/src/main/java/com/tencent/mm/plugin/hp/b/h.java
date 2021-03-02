package com.tencent.mm.plugin.hp.b;

import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.model.cj;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tinkerboots.sdk.a;
import java.util.Map;

public final class h implements cj.a {
    @Override // com.tencent.mm.model.cj.a
    public final void a(h.c cVar) {
    }

    @Override // com.tencent.mm.model.cj.a
    public final void a(h.a aVar) {
        AppMethodBeat.i(117441);
        de deVar = aVar.heO;
        if (deVar.xKb == 10002) {
            String a2 = z.a(deVar.KHn);
            if (Util.isNullOrNil(a2)) {
                Log.w("MicroMsg.Tinker.TinkerBootsSysCmdMsgListener", "msg content is null");
                AppMethodBeat.o(117441);
                return;
            }
            Log.i("MicroMsg.Tinker.TinkerBootsSysCmdMsgListener", "onReciveMsg :%s", a2);
            Map<String, String> parseXml = XmlParser.parseXml(a2, "sysmsg", null);
            if (parseXml != null && parseXml.size() > 0) {
                String str = parseXml.get(".sysmsg.$type");
                if (!Util.isNullOrNil(str) && str.equalsIgnoreCase("prconfignotify")) {
                    int safeParseInt = Util.safeParseInt(parseXml.get(".sysmsg.boots.ignorenetwork"));
                    String nullAs = Util.nullAs(parseXml.get(".sysmsg.boots.xmlkey"), "");
                    Log.i("MicroMsg.Tinker.TinkerBootsSysCmdMsgListener", "ignore:%s md5 %s start checkout tinker update. try to do update.", Integer.valueOf(safeParseInt), nullAs);
                    a.hvX().ol(OpenSDKTool4Assistant.EXTRA_UIN, String.valueOf(((long) com.tencent.mm.kernel.a.azs()) & Util.MAX_32BIT_VALUE)).ol(TencentLocation.NETWORK_PROVIDER, String.valueOf((NetStatusUtil.isWifi(MMApplicationContext.getContext()) || safeParseInt == 1) ? 3 : 2));
                    if (!Util.isNullOrNil(nullAs)) {
                        a.hvX().ol("xmlkey", nullAs);
                    }
                    a.hvX().Ey(true);
                }
            }
        }
        AppMethodBeat.o(117441);
    }
}
