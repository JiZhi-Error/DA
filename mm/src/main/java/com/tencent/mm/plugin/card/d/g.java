package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.d;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class g {
    public static d ajZ(String str) {
        AppMethodBeat.i(113797);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(113797);
            return null;
        }
        d dVar = new d();
        Map<String, String> parseXml = XmlParser.parseXml(str, "msg", null);
        if (parseXml == null) {
            AppMethodBeat.o(113797);
            return dVar;
        }
        dVar.pPy = parseXml.get(".msg.appmsg.carditem.from_username");
        dVar.eaO = parseXml.get(".msg.appmsg.carditem.card_id");
        dVar.nHh = akb(parseXml.get(".msg.appmsg.carditem.card_type"));
        dVar.eaQ = akb(parseXml.get(".msg.appmsg.carditem.from_scene"));
        dVar.ixw = parseXml.get(".msg.appmsg.carditem.color");
        dVar.pTn = parseXml.get(".msg.appmsg.carditem.card_type_name");
        dVar.gTG = parseXml.get(".msg.appmsg.carditem.brand_name");
        dVar.eaP = parseXml.get(".msg.appmsg.carditem.card_ext");
        dVar.pTo = akb(parseXml.get(".msg.appmsg.carditem.is_recommend"));
        dVar.pTp = parseXml.get(".msg.appmsg.carditem.recommend_card_id");
        AppMethodBeat.o(113797);
        return dVar;
    }

    public static String aka(String str) {
        AppMethodBeat.i(113798);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(113798);
            return null;
        }
        Map<String, String> parseXml = XmlParser.parseXml(str, "msg", null);
        if (parseXml == null) {
            AppMethodBeat.o(113798);
            return null;
        }
        String str2 = parseXml.get(".msg.appmsg.fromusername");
        AppMethodBeat.o(113798);
        return str2;
    }

    private static int akb(String str) {
        AppMethodBeat.i(113799);
        if (TextUtils.isEmpty(str) || !l.isNumeric(str)) {
            AppMethodBeat.o(113799);
            return 0;
        }
        int i2 = Util.getInt(str, 0);
        AppMethodBeat.o(113799);
        return i2;
    }

    public static String a(d dVar) {
        AppMethodBeat.i(113800);
        StringBuilder sb = new StringBuilder();
        sb.append("<from_username>").append(dVar.pPy).append("</from_username>");
        sb.append("<card_id>").append(dVar.eaO).append("</card_id>");
        sb.append("<card_type>").append(dVar.nHh).append("</card_type>");
        sb.append("<from_scene>").append(dVar.eaQ).append("</from_scene>");
        sb.append("<color>").append(dVar.ixw).append("</color>");
        sb.append("<card_type_name>").append(dVar.pTn).append("</card_type_name>");
        sb.append("<brand_name>").append(dVar.gTG).append("</brand_name>");
        if (TextUtils.isEmpty(dVar.eaP)) {
            sb.append("<card_ext></card_ext>");
        } else {
            sb.append("<card_ext>").append(dVar.eaP).append("</card_ext>");
        }
        sb.append("<is_recommend>").append(dVar.pTo).append("</is_recommend>");
        sb.append("<recommend_card_id>").append(dVar.pTp).append("</recommend_card_id>");
        String sb2 = sb.toString();
        AppMethodBeat.o(113800);
        return sb2;
    }
}
