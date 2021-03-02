package com.tencent.mm.ag.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class a {
    public String appId;
    public String dCx;
    public String iBb;
    public String iBc;
    public String iconUrl;
    public String msgId;
    public String nickname;
    public int op;
    public String title;
    public int type;
    public String username;
    public int version;

    public static a HK(String str) {
        AppMethodBeat.i(187115);
        Map<String, String> parseXml = XmlParser.parseXml(str, "sysmsg", null);
        a aVar = new a();
        if (parseXml == null) {
            Log.i("AppBrandNotifyMsgContent", "values map is null.");
            AppMethodBeat.o(187115);
            return aVar;
        }
        aVar.title = parseXml.get(".sysmsg.weapp_pushmsg.title");
        aVar.nickname = parseXml.get(".sysmsg.weapp_pushmsg.wxa_nickname");
        aVar.op = Util.getInt(parseXml.get(".sysmsg.weapp_pushmsg.op"), 0);
        aVar.msgId = parseXml.get(".sysmsg.weapp_pushmsg.busi_msgid");
        aVar.username = parseXml.get(".sysmsg.weapp_pushmsg.weappinfo.username");
        aVar.appId = parseXml.get(".sysmsg.weapp_pushmsg.weappinfo.appid");
        aVar.type = Util.getInt(parseXml.get(".sysmsg.weapp_pushmsg.weappinfo.type"), 0);
        aVar.version = Util.getInt(parseXml.get(".sysmsg.weapp_pushmsg.weappinfo.version"), 0);
        aVar.iconUrl = parseXml.get(".sysmsg.weapp_pushmsg.weappinfo.weappiconurl");
        aVar.dCx = parseXml.get(".sysmsg.weapp_pushmsg.weappinfo.pagepath");
        aVar.iBb = parseXml.get(".sysmsg.weapp_pushmsg.weappinfo.appservicetype");
        aVar.iBc = parseXml.get(".sysmsg.weapp_pushmsg.weappinfo.pkginfo.type");
        AppMethodBeat.o(187115);
        return aVar;
    }

    public static String HL(String str) {
        AppMethodBeat.i(187116);
        String replaceAll = Util.nullAsNil(str).replaceAll("[_a-zA-Z0-9]", "*");
        AppMethodBeat.o(187116);
        return replaceAll;
    }
}
