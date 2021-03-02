package com.tencent.mm.platformtools;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.HashMap;
import java.util.Map;

public final class i {
    public static i jMH = new i();
    private Map<String, String> jMI;

    static {
        AppMethodBeat.i(127692);
        AppMethodBeat.o(127692);
    }

    public final Map<String, String> dq(Context context) {
        AppMethodBeat.i(127691);
        try {
            String streamToString = Util.streamToString(context.getAssets().open("config/EmailAddress.xml"));
            if (Util.isNullOrNil(streamToString)) {
                AppMethodBeat.o(127691);
                return null;
            }
            Map<String, String> parseXml = XmlParser.parseXml(streamToString, "config", null);
            if (parseXml == null || parseXml.isEmpty()) {
                Log.d("MicroMsg.EmailFormater", "values null");
                AppMethodBeat.o(127691);
                return null;
            } else if (this.jMI == null) {
                this.jMI = new HashMap();
                int i2 = 0;
                while (true) {
                    String str = ".config.format" + (i2 == 0 ? "" : Integer.valueOf(i2));
                    if (parseXml.get(str) != null) {
                        String str2 = str + ".loginpage";
                        String str3 = parseXml.get(str + ".emaildomain");
                        String str4 = parseXml.get(str2);
                        if (!Util.isNullOrNil(str3) && !Util.isNullOrNil(str4)) {
                            this.jMI.put(str3, str4);
                        }
                        i2++;
                    } else {
                        Map<String, String> map = this.jMI;
                        AppMethodBeat.o(127691);
                        return map;
                    }
                }
            } else {
                Map<String, String> map2 = this.jMI;
                AppMethodBeat.o(127691);
                return map2;
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.EmailFormater", "parse email failed:[%s]", e2.getMessage());
            AppMethodBeat.o(127691);
            return null;
        }
    }
}
