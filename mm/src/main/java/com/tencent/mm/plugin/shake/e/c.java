package com.tencent.mm.plugin.shake.e;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.LinkedList;
import java.util.Map;

public final class c {

    public static class a {
        public LinkedList<a> CUx;
        public String field_id;
        public String field_playstatid;
        public String field_playurl;
        public String field_shareurl;
        public String field_source;
        public String field_subtitle;
        public String field_thumburl;
        public String field_title;
        public String field_topic;
        public String field_xml;
    }

    public static a aNu(String str) {
        AppMethodBeat.i(28622);
        if (str == null) {
            AppMethodBeat.o(28622);
            return null;
        }
        Map<String, String> parseXml = XmlParser.parseXml(str, "tv", null);
        if (parseXml == null) {
            AppMethodBeat.o(28622);
            return null;
        }
        a aVar = new a();
        aVar.field_id = Util.nullAsNil(parseXml.get("" + ".tv.id"));
        aVar.field_topic = Util.nullAsNil(parseXml.get("" + ".tv.topic"));
        aVar.field_title = Util.nullAsNil(parseXml.get("" + ".tv.title"));
        aVar.field_subtitle = Util.nullAsNil(parseXml.get("" + ".tv.subtitle"));
        aVar.field_thumburl = Util.nullAsNil(parseXml.get("" + ".tv.thumburl"));
        aVar.field_shareurl = Util.nullAsNil(parseXml.get("" + ".tv.shareurl"));
        aVar.field_playurl = Util.nullAsNil(parseXml.get("" + ".tv.playurl"));
        aVar.field_playstatid = Util.nullAsNil(parseXml.get("" + ".tv.playurl$statid"));
        aVar.field_source = Util.nullAsNil(parseXml.get("" + ".tv.source"));
        aVar.CUx = a.o(parseXml, "" + ".tv");
        aVar.field_xml = str;
        AppMethodBeat.o(28622);
        return aVar;
    }

    public static String b(a aVar) {
        AppMethodBeat.i(28623);
        StringBuilder sb = new StringBuilder(256);
        sb.append("<tv>");
        if (!Util.isNullOrNil(aVar.field_id)) {
            sb.append("<id>" + Util.escapeStringForXml(aVar.field_id) + "</id>");
        }
        sb.append("<title>" + Util.escapeStringForXml(aVar.field_title) + "</title>");
        sb.append("<subtitle>" + Util.escapeStringForXml(aVar.field_subtitle) + "</subtitle>");
        sb.append("<topic>" + Util.escapeStringForXml(aVar.field_topic) + "</topic>");
        sb.append("<thumburl>" + Util.escapeStringForXml(aVar.field_thumburl) + "</thumburl>");
        sb.append("<shareurl>" + Util.escapeStringForXml(aVar.field_shareurl) + "</shareurl>");
        if (!Util.isNullOrNil(aVar.field_playstatid)) {
            sb.append("<playurl statid=\"" + aVar.field_playstatid + "\">" + Util.escapeStringForXml(aVar.field_playurl) + "</playurl>");
        } else {
            sb.append("<playurl>" + Util.escapeStringForXml(aVar.field_playurl) + "</playurl>");
        }
        sb.append("<source>" + Util.escapeStringForXml(aVar.field_source) + "</source>");
        sb.append("</tv>");
        String sb2 = sb.toString();
        AppMethodBeat.o(28623);
        return sb2;
    }

    public static String a(Context context, a aVar) {
        AppMethodBeat.i(28624);
        k.b bVar = new k.b();
        bVar.title = aVar.field_title;
        if (!Util.isNullOrNil(aVar.field_topic)) {
            bVar.description = aVar.field_topic;
        } else {
            bVar.description = aVar.field_subtitle;
        }
        bVar.type = 20;
        bVar.url = aVar.field_shareurl;
        bVar.action = "";
        if (com.tencent.mm.plugin.shake.d.a.k.eUk()) {
            bVar.appName = context.getString(R.string.gea);
            bVar.appId = "wxaf060266bfa9a35c";
        }
        bVar.thumburl = aVar.field_thumburl;
        bVar.ixk = b(aVar);
        String a2 = k.b.a(bVar, null, null);
        AppMethodBeat.o(28624);
        return a2;
    }
}
