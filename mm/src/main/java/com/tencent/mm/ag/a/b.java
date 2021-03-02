package com.tencent.mm.ag.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class b {
    public String appId;
    public String content;
    public String cyr;
    private String iBd;
    public int iBe;
    public int iBf;
    public String path;
    public String title;
    public int type;
    public String username;

    public static b HM(String str) {
        AppMethodBeat.i(2615);
        Map<String, String> parseXml = XmlParser.parseXml(str, "sysmsg", null);
        b bVar = new b();
        if (parseXml == null) {
            AppMethodBeat.o(2615);
            return bVar;
        }
        bVar.iBd = parseXml.get(".sysmsg.subscribesysmsg.content_template.template");
        bVar.title = parseXml.get(".sysmsg.subscribesysmsg.content_template.link_list.link.title");
        bVar.content = bVar.iBd.replace("$wxaapp_view$", bVar.title);
        bVar.appId = parseXml.get(".sysmsg.subscribesysmsg.content_template.link_list.link.appid");
        bVar.username = parseXml.get(".sysmsg.subscribesysmsg.content_template.link_list.link.username");
        bVar.path = parseXml.get(".sysmsg.subscribesysmsg.content_template.link_list.link.path");
        bVar.type = Util.getInt(parseXml.get(".sysmsg.subscribesysmsg.content_template.link_list.link.type"), 0);
        bVar.cyr = parseXml.get(".sysmsg.subscribesysmsg.content_template.link_list.link.share_key");
        bVar.iBe = Util.getInt(parseXml.get(".sysmsg.subscribesysmsg.content_template.link_list.link.forbids"), 0);
        bVar.iBf = Util.getInt(parseXml.get(".sysmsg.subscribesysmsg.content_template.link_list.link.wxaapp_type"), 1);
        AppMethodBeat.o(2615);
        return bVar;
    }
}
