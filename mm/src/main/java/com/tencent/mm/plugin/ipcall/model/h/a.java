package com.tencent.mm.plugin.ipcall.model.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class a {
    private static String TAG = "MicroMsg.IPCallActivityMsgInfo";
    public String Desc = "";
    public String ImgUrl = "";
    public String Title = "";
    public int oUv = 0;
    public String ysC = "";

    public static a aBT(String str) {
        AppMethodBeat.i(25530);
        Log.d(TAG, "getIPCallActivityMsgInfoFromXML:".concat(String.valueOf(str)));
        a aVar = new a();
        int indexOf = str.indexOf("<ActivityInfo");
        if (indexOf == -1) {
            Log.e(TAG, "msgContent not start with <ActivityInfo");
            AppMethodBeat.o(25530);
            return aVar;
        }
        Map<String, String> parseXml = XmlParser.parseXml(str.substring(indexOf), "ActivityInfo", null);
        if (parseXml == null) {
            Log.e(TAG, "XmlParser values is null, xml %s", str);
            AppMethodBeat.o(25530);
            return null;
        }
        if (parseXml.containsKey(".ActivityInfo.Title")) {
            aVar.Title = parseXml.get(".ActivityInfo.Title");
        }
        if (parseXml.containsKey(".ActivityInfo.Desc")) {
            aVar.Desc = parseXml.get(".ActivityInfo.Desc");
        }
        if (parseXml.containsKey(".ActivityInfo.ImgUrl")) {
            aVar.ImgUrl = parseXml.get(".ActivityInfo.ImgUrl");
        }
        if (parseXml.containsKey(".ActivityInfo.StartBtnText")) {
            aVar.ysC = parseXml.get(".ActivityInfo.StartBtnText");
        }
        if (parseXml.containsKey(".ActivityInfo.ActivityType")) {
            aVar.oUv = Util.getInt(parseXml.get(".ActivityInfo.ActivityType"), 0);
        }
        Log.d(TAG, "msgInfo:", aVar.toString());
        AppMethodBeat.o(25530);
        return aVar;
    }
}
