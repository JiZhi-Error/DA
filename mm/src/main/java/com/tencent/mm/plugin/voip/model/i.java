package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class i {
    public static boolean akM() {
        AppMethodBeat.i(114863);
        if (Util.secondsToNow(Util.nullAs((Long) g.aAh().azQ().get(77828, (Object) null), 0)) * 1000 > 1800000) {
            AppMethodBeat.o(114863);
            return true;
        }
        AppMethodBeat.o(114863);
        return false;
    }

    public static class a {
        public int hitCount = 0;
        public int jgU = 0;

        public static String aV(Map<String, a> map) {
            AppMethodBeat.i(114861);
            StringBuilder sb = new StringBuilder();
            if (map != null) {
                try {
                    if (map.size() > 0) {
                        sb.append("<voiptenmin>");
                        for (Map.Entry<String, a> entry : map.entrySet()) {
                            String key = entry.getKey();
                            a value = entry.getValue();
                            sb.append("<".concat(String.valueOf(key)));
                            sb.append(" hitcount = \"");
                            sb.append(value.hitCount);
                            sb.append("\"");
                            sb.append(" sendcount = \"");
                            sb.append(value.jgU);
                            sb.append("\"");
                            sb.append("/>");
                        }
                        sb.append("</voiptenmin>");
                    }
                } catch (Exception e2) {
                    Log.e("PostTaskTenMinutesLogicState", "exception:%s", Util.stackTraceToString(e2));
                    AppMethodBeat.o(114861);
                    return null;
                }
            }
            Log.d("PostTaskTenMinutesLogicState", "mapToXml " + sb.toString());
            String sb2 = sb.toString();
            AppMethodBeat.o(114861);
            return sb2;
        }

        public static Map<String, a> aUx(String str) {
            Map.Entry<String, String> next;
            String key;
            a aVar;
            HashMap hashMap = null;
            AppMethodBeat.i(114862);
            Log.d("PostTaskTenMinutesLogicState", "xml ".concat(String.valueOf(str)));
            if (str != null) {
                try {
                    Map<String, String> parseXml = XmlParser.parseXml(str, "voiptenmin", null);
                    if (parseXml != null && parseXml.size() > 0) {
                        HashMap hashMap2 = new HashMap();
                        try {
                            Iterator<Map.Entry<String, String>> it = parseXml.entrySet().iterator();
                            while (it.hasNext() && (key = (next = it.next()).getKey()) != null) {
                                String[] split = key.split("\\.");
                                Log.d("PostTaskTenMinutesLogicState", "key is ".concat(String.valueOf(key)));
                                Log.d("PostTaskTenMinutesLogicState", "array is " + split.length);
                                if (key != null && split.length >= 4) {
                                    Log.d("PostTaskTenMinutesLogicState", "getValue is " + next.getValue() + "array[1] " + split[2]);
                                    if (hashMap2.containsKey(split[2])) {
                                        aVar = hashMap2.get(split[2]);
                                    } else {
                                        aVar = new a();
                                    }
                                    if (key.contains("hitcount")) {
                                        aVar.hitCount = Util.getInt(next.getValue(), 0);
                                    } else if (key.contains("sendcount")) {
                                        aVar.jgU = Util.getInt(next.getValue(), 0);
                                    }
                                    Log.d("PostTaskTenMinutesLogicState", "hitCount " + aVar.hitCount + "sendCount " + aVar.jgU);
                                    hashMap2.put(split[2], aVar);
                                }
                            }
                            hashMap = hashMap2;
                        } catch (Exception e2) {
                            e = e2;
                            hashMap = hashMap2;
                            Log.e("PostTaskTenMinutesLogicState", "exception:%s", Util.stackTraceToString(e));
                            AppMethodBeat.o(114862);
                            return hashMap;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    Log.e("PostTaskTenMinutesLogicState", "exception:%s", Util.stackTraceToString(e));
                    AppMethodBeat.o(114862);
                    return hashMap;
                }
            }
            AppMethodBeat.o(114862);
            return hashMap;
        }
    }
}
