package com.tencent.mm.plugin.freewifi.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class a {
    public String bssid;
    public String ssid;
    public String type;
    public long uin;
    public String wOq;
    public String wOr;
    public long wOs;
    public String wOt;
    public long wOu;

    private a() {
    }

    public static a axQ(String str) {
        AppMethodBeat.i(24759);
        Log.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "It starts to parse msgContent for FreeWifiSchemaMsg. msgContent=%s", str);
        if (m.eP(str)) {
            Log.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "msgCoentent is empty. return.");
            AppMethodBeat.o(24759);
            return null;
        }
        Log.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "Shorten msgContent into one line. msgContent=%s", str);
        Map<String, String> parseXml = XmlParser.parseXml(str, "sysmsg", null);
        if (parseXml == null || parseXml.size() == 0) {
            Log.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "Parsing xml failed");
            AppMethodBeat.o(24759);
            return null;
        }
        Log.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "Parsed values = " + parseXml.toString());
        if (!"freewifi".equalsIgnoreCase(parseXml.get(".sysmsg.$type"))) {
            Log.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "sysmsg type is not freewifi. return.");
            AppMethodBeat.o(24759);
            return null;
        }
        a aVar = new a();
        aVar.type = parseXml.get(".sysmsg.type");
        Log.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.type=" + aVar.type);
        if (!"schemamsg".equals(aVar.type)) {
            Log.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.type is not schemamsg. return.");
            AppMethodBeat.o(24759);
            return null;
        }
        boolean l = m.l(parseXml, "MicroMsg.FreeWifi.FreeWifiSchemaMsg");
        Log.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "checkMsgPushedVersion=".concat(String.valueOf(l)));
        if (!l) {
            Log.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "version not matched. return.");
            AppMethodBeat.o(24759);
            return null;
        }
        aVar.uin = Util.getLong(parseXml.get(".sysmsg.uin"), 0);
        Log.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.uin=" + aVar.uin);
        aVar.ssid = parseXml.get(".sysmsg.schemamsg.ssid");
        Log.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.ssid=" + aVar.ssid);
        if (m.eP(aVar.ssid)) {
            Log.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "scemaMsg.ssid is empty. return.");
            AppMethodBeat.o(24759);
            return null;
        }
        aVar.bssid = m.axL(parseXml.get(".sysmsg.schemamsg.bssid"));
        Log.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.bssid=" + aVar.bssid);
        aVar.wOq = parseXml.get(".sysmsg.schemamsg.mobilemac");
        Log.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.mobilemac=" + aVar.wOq);
        if (m.eP(aVar.wOq)) {
            Log.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "scemaMsg.mobilemac is empty. return.");
            AppMethodBeat.o(24759);
            return null;
        }
        aVar.wOr = parseXml.get(".sysmsg.schemamsg.mpappid");
        Log.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.mpappid=" + aVar.wOr);
        aVar.wOs = Util.getLong(parseXml.get(".sysmsg.schemamsg.mpshopid"), 0);
        Log.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.mpshopid=" + aVar.wOs);
        aVar.wOt = parseXml.get(".sysmsg.schemamsg.schemaurl");
        Log.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.schemaurl=" + aVar.wOt);
        if (m.eP(aVar.wOt)) {
            Log.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "scemaMsg.schemaurl is empty. return.");
            AppMethodBeat.o(24759);
            return null;
        }
        aVar.wOu = Util.getLong(parseXml.get(".sysmsg.schemamsg.expiredseconds"), 0);
        Log.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schema.expiredseconds=" + aVar.wOu);
        AppMethodBeat.o(24759);
        return aVar;
    }
}
