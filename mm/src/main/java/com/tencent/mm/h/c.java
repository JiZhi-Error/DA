package com.tencent.mm.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;
import org.json.JSONObject;

public final class c {
    public String Title;
    public int dDF;
    public int dDG;
    public int dDH;
    public String desc;
    public String gpn;
    public String gpo;
    public int gpp;
    public String url;

    public static c Dm(String str) {
        AppMethodBeat.i(134108);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(134108);
            return null;
        }
        c cVar = new c();
        Map<String, String> parseXml = XmlParser.parseXml(str, "e", null);
        if (parseXml == null) {
            Log.d("MicroMsg.BroadcastEntity", "this is not errmsg");
            AppMethodBeat.o(134108);
            return null;
        }
        cVar.desc = parseXml.get(".e.Content");
        cVar.url = parseXml.get(".e.Url");
        cVar.Title = parseXml.get(".e.Title");
        cVar.dDH = Util.getInt(parseXml.get(".e.Action"), 0);
        cVar.dDG = Util.getInt(parseXml.get(".e.ShowType"), 0);
        cVar.dDF = Util.getInt(parseXml.get(".e.DispSec"), 30);
        cVar.gpn = parseXml.get(".e.Ok");
        cVar.gpo = parseXml.get(".e.Cancel");
        cVar.gpp = Util.getInt(parseXml.get("e.Countdown"), 0);
        if (oe(cVar.dDG)) {
            AppMethodBeat.o(134108);
            return cVar;
        }
        try {
            JSONObject jSONObject = new JSONObject(parseXml.get(".e"));
            cVar.desc = jSONObject.getString("Content");
            cVar.url = jSONObject.getString("Url");
            cVar.Title = jSONObject.getString("Title");
            cVar.dDH = Util.getInt(jSONObject.getString("Action"), 0);
            cVar.dDG = Util.getInt(jSONObject.getString("ShowType"), 0);
            cVar.dDF = Util.getInt(jSONObject.getString("DispSec"), 30);
            cVar.gpn = parseXml.get(".e.Ok");
            cVar.gpo = parseXml.get(".e.Cancel");
            cVar.gpp = Util.getInt(parseXml.get("e.Countdown"), 0);
            if (oe(cVar.dDG)) {
                AppMethodBeat.o(134108);
                return cVar;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.BroadcastEntity", e2, "", new Object[0]);
        }
        AppMethodBeat.o(134108);
        return null;
    }

    private static boolean oe(int i2) {
        if (i2 == 4 || i2 == 1 || i2 == 5 || i2 == 3 || i2 == 8) {
            return true;
        }
        return false;
    }
}
