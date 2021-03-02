package com.tencent.mm.plugin.scanner.util;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.LinkedList;
import java.util.Map;

public final class n {
    public static String am(Context context, int i2) {
        AppMethodBeat.i(52063);
        if (context == null || i2 < 0) {
            AppMethodBeat.o(52063);
            return "";
        }
        if (i2 == 0) {
            context.getString(R.string.gdw);
        } else if (i2 == 1) {
            context.getString(R.string.gdp);
        } else if (i2 == 2) {
            context.getString(R.string.gdv);
        } else if (i2 == 3) {
            context.getString(R.string.gdq);
        }
        String string = context.getString(R.string.gdw);
        AppMethodBeat.o(52063);
        return string;
    }

    public static int aMS(String str) {
        AppMethodBeat.i(52064);
        if (str == null) {
            AppMethodBeat.o(52064);
            return 0;
        }
        String trim = str.trim();
        if (trim.startsWith("<user")) {
            AppMethodBeat.o(52064);
            return 1;
        } else if (trim.startsWith("<url")) {
            AppMethodBeat.o(52064);
            return 2;
        } else if (trim.startsWith("<product")) {
            AppMethodBeat.o(52064);
            return 3;
        } else if (trim.startsWith("<search")) {
            AppMethodBeat.o(52064);
            return 4;
        } else {
            AppMethodBeat.o(52064);
            return 0;
        }
    }

    public static class c {
        public String nickname;
        public String username;

        public c(String str, String str2) {
            this.username = str;
            this.nickname = str2;
        }
    }

    public static class b {
        public String link;

        public b(String str) {
            this.link = str;
        }
    }

    public static class a {
        public LinkedList<com.tencent.mm.plugin.scanner.model.b> CUx;
        public C1680a CUy;
        public String field_certification;
        public String field_certificationurl;
        public String field_detailurl;
        public String field_exposeurl;
        public String field_extinfo;
        public String field_feedbackurl;
        public int field_functionType;
        public int field_getaction;
        public String field_headerbackgroundurl;
        public String field_headermask;
        public String field_introlink;
        public String field_introtitle;
        public String field_playurl;
        public String field_productid;
        public String field_shareurl;
        public String field_source;
        public String field_subtitle;
        public String field_thumburl;
        public String field_title;
        public int field_type;
        public String field_xml;
        public int field_xmlType;

        /* renamed from: com.tencent.mm.plugin.scanner.util.n$a$a  reason: collision with other inner class name */
        public static class C1680a {
            public LinkedList<b> CUA;
            public LinkedList<C1681a> CUz;

            /* renamed from: com.tencent.mm.plugin.scanner.util.n$a$a$a  reason: collision with other inner class name */
            public static class C1681a {
                public String link;
            }

            /* renamed from: com.tencent.mm.plugin.scanner.util.n$a$a$b */
            public static class b {
                public String desc;
                public String title;
            }
        }

        public final void q(Map<String, String> map, String str) {
            AppMethodBeat.i(52062);
            if (map != null) {
                this.CUy = new C1680a();
                this.CUy.CUz = new LinkedList<>();
                String str2 = str + ".bannerlist.banner";
                int i2 = 0;
                while (i2 < 1000) {
                    String str3 = map.get((str2 + (i2 > 0 ? Integer.valueOf(i2) : "")) + ".link");
                    if (Util.isNullOrNil(str3)) {
                        break;
                    }
                    C1680a.C1681a aVar = new C1680a.C1681a();
                    aVar.link = str3;
                    this.CUy.CUz.add(aVar);
                    i2++;
                }
                this.CUy.CUA = new LinkedList<>();
                String str4 = str + ".detaillist.detail";
                int i3 = 0;
                while (i3 < 1000) {
                    String str5 = str4 + (i3 > 0 ? Integer.valueOf(i3) : "");
                    String str6 = map.get(str5 + ".title");
                    String str7 = map.get(str5 + ".desc");
                    if (Util.isNullOrNil(str6) && Util.isNullOrNil(str7)) {
                        break;
                    }
                    C1680a.b bVar = new C1680a.b();
                    bVar.title = str6;
                    bVar.desc = str7;
                    this.CUy.CUA.add(bVar);
                    i3++;
                }
            }
            AppMethodBeat.o(52062);
        }
    }

    public static a fp(String str, int i2) {
        Map<String, String> parseXml;
        boolean z;
        AppMethodBeat.i(52065);
        if (str == null) {
            AppMethodBeat.o(52065);
            return null;
        }
        String str2 = "";
        if (str.startsWith("<productInfo")) {
            str2 = ".productInfo";
            z = true;
            parseXml = XmlParser.parseXml(str, "productInfo", null);
        } else {
            parseXml = XmlParser.parseXml(str, "product", null);
            z = false;
        }
        if (parseXml == null) {
            AppMethodBeat.o(52065);
            return null;
        }
        a aVar = new a();
        if (!Util.isNullOrNil(parseXml.get(str2 + ".product.$type"))) {
            aVar.field_type = Util.getInt(parseXml.get(str2 + ".product.$type"), 0);
        } else {
            aVar.field_type = 0;
        }
        aVar.field_productid = Util.nullAsNil(parseXml.get(str2 + ".product.id"));
        aVar.field_subtitle = Util.nullAsNil(parseXml.get(str2 + ".product.subtitle"));
        aVar.field_shareurl = Util.nullAsNil(parseXml.get(str2 + ".product.shareurl"));
        aVar.field_playurl = Util.nullAsNil(parseXml.get(str2 + ".product.playurl"));
        aVar.field_xmlType = 3;
        aVar.field_title = Util.nullAsNil(parseXml.get(str2 + ".product.title"));
        aVar.field_thumburl = Util.nullAsNil(parseXml.get(str2 + ".product.thumburl"));
        aVar.field_source = Util.nullAsNil(parseXml.get(str2 + ".product.source"));
        aVar.field_feedbackurl = Util.nullAsNil(parseXml.get(str2 + ".product.feedbackurl"));
        aVar.field_extinfo = Util.nullAsNil(parseXml.get(str2 + ".product.extinfo"));
        aVar.field_introtitle = Util.nullAsNil(parseXml.get(str2 + ".product.introtitle"));
        aVar.field_introlink = Util.nullAsNil(parseXml.get(str2 + ".product.introlink"));
        aVar.field_getaction = Util.getInt(parseXml.get(str2 + ".product.getaction"), 0);
        aVar.field_certification = Util.nullAsNil(parseXml.get(str2 + ".product.certification"));
        aVar.field_headerbackgroundurl = Util.nullAsNil(parseXml.get(str2 + ".product.headerbackgroundurl"));
        aVar.field_headermask = Util.nullAsNil(parseXml.get(str2 + ".product.headermask"));
        aVar.field_detailurl = Util.nullAsNil(parseXml.get(str2 + ".product.detailurl"));
        aVar.field_certificationurl = Util.nullAsNil(parseXml.get(str2 + ".product.certificationurl"));
        aVar.field_exposeurl = Util.nullAsNil(parseXml.get(str2 + ".product.exposeurl"));
        aVar.CUx = com.tencent.mm.plugin.scanner.model.b.o(parseXml, str2 + ".product");
        aVar.q(parseXml, str2 + ".product");
        String str3 = parseXml.get(str2 + ".functionType");
        if (!Util.isNullOrNil(str3)) {
            aVar.field_functionType = Util.getInt(str3, 0);
        } else {
            aVar.field_functionType = i2;
        }
        if (z) {
            aVar.field_xml = str;
        } else {
            StringBuilder sb = new StringBuilder(256);
            sb.append("<productInfo>");
            sb.append(str);
            sb.append("<functionType>" + aVar.field_functionType + "</functionType>");
            sb.append("</productInfo>");
            aVar.field_xml = sb.toString();
        }
        AppMethodBeat.o(52065);
        return aVar;
    }

    public static a aMT(String str) {
        AppMethodBeat.i(52066);
        if (str == null) {
            AppMethodBeat.o(52066);
            return null;
        }
        Map<String, String> parseXml = XmlParser.parseXml(str, "search", null);
        if (parseXml == null) {
            AppMethodBeat.o(52066);
            return null;
        }
        a aVar = new a();
        aVar.field_xmlType = 4;
        aVar.field_xml = str;
        aVar.CUx = com.tencent.mm.plugin.scanner.model.b.o(parseXml, ".search");
        AppMethodBeat.o(52066);
        return aVar;
    }

    public static String c(a aVar) {
        AppMethodBeat.i(52067);
        StringBuilder sb = new StringBuilder(256);
        if (!Util.isNullOrNil(aVar.field_productid)) {
            sb.append("<productInfo><product type=\"" + aVar.field_type + "\">");
            sb.append("<id>" + Util.escapeStringForXml(aVar.field_productid) + "</id>");
            sb.append("<title>" + Util.escapeStringForXml(aVar.field_title) + "</title>");
            sb.append("<subtitle>" + Util.escapeStringForXml(aVar.field_subtitle) + "</subtitle>");
            sb.append("<thumburl>" + Util.escapeStringForXml(aVar.field_thumburl) + "</thumburl>");
            sb.append("<source>" + Util.escapeStringForXml(aVar.field_source) + "</source>");
            sb.append("<shareurl>" + Util.escapeStringForXml(aVar.field_shareurl) + "</shareurl>");
            sb.append("<playurl>" + Util.escapeStringForXml(aVar.field_playurl) + "</playurl>");
            sb.append("<extinfo>" + Util.escapeStringForXml(aVar.field_extinfo) + "</extinfo>");
            sb.append("<getaction>" + Util.escapeStringForXml(new StringBuilder().append(aVar.field_getaction).toString()) + "</getaction>");
            sb.append("<certification>" + Util.escapeStringForXml(aVar.field_certification) + "</certification>");
            sb.append("<headerbackgroundurl>" + Util.escapeStringForXml(aVar.field_headerbackgroundurl) + "</headerbackgroundurl>");
            sb.append("<headermask>" + Util.escapeStringForXml(aVar.field_headermask) + "</headermask>");
            sb.append("<detailurl>" + Util.escapeStringForXml(aVar.field_detailurl) + "</detailurl>");
            sb.append("<certificationurl>" + Util.escapeStringForXml(aVar.field_certificationurl) + "</certificationurl>");
            sb.append("</product>");
            sb.append("<functionType>" + aVar.field_functionType + "</functionType>");
            sb.append("</productInfo>");
        } else if (aVar.field_xml == null) {
            Log.e("MicroMsg.Scanner.ScanXmlHelper", "product.field_xml == null in getProductInfoXml()");
            AppMethodBeat.o(52067);
            return "";
        } else if (aVar.field_xml.startsWith("<productInfo")) {
            String str = aVar.field_xml;
            AppMethodBeat.o(52067);
            return str;
        } else {
            sb.append("<productInfo>");
            sb.append(aVar.field_xml);
            sb.append("<functionType>" + aVar.field_functionType + "</functionType>");
            sb.append("</productInfo>");
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(52067);
        return sb2;
    }
}
