package com.tencent.mm.plugin.webview.ui.tools.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public final class d {
    private static final Map<String, Map<Integer, Object>> Jqm = new HashMap();

    static {
        AppMethodBeat.i(80872);
        AppMethodBeat.o(80872);
    }

    public enum a {
        ;
        
        public static int Jqn = 21;
        public static int Jqo = 22;
        public static int Jqp = 23;
        public static int Jqq = 24;
        public static int Jqr = 25;
        public static int Jqs = 26;
        public static int Jqt = 27;
        public static int Jqu = 28;
        public static int Jqv = 29;

        public static a valueOf(String str) {
            AppMethodBeat.i(80866);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(80866);
            return aVar;
        }
    }

    public enum b {
        ;
        
        public static int JqA = 32;
        public static int JqB = 33;
        public static int JqC = 34;
        public static int JqD = 38;
        public static int JqE = 39;
        public static int JqF = 40;
        public static int JqG = 41;
        public static int JqH = 42;
        public static int JqI = 43;
        public static int JqJ = 44;
        public static int JqK = 45;
        public static int JqL = 49;
        public static int JqM = 50;
        public static int JqN = 51;
        public static int JqO = 52;
        public static int JqP = 53;
        public static int JqQ = 54;
        public static int JqR = 55;
        public static int JqS = 56;
        public static int Jqx = 1000;
        public static int Jqy = 30;
        public static int Jqz = 31;

        public static b valueOf(String str) {
            AppMethodBeat.i(80868);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(80868);
            return bVar;
        }
    }

    public static void S(String str, Map<Integer, Object> map) {
        AppMethodBeat.i(80869);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(80869);
            return;
        }
        Map<Integer, Object> map2 = Jqm.get(str);
        if (map2 != null) {
            map2.putAll(map);
            AppMethodBeat.o(80869);
            return;
        }
        Jqm.put(str, map);
        AppMethodBeat.o(80869);
    }

    public static void a(String str, e eVar) {
        boolean z;
        AppMethodBeat.i(211314);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(211314);
            return;
        }
        TreeMap treeMap = new TreeMap(new Comparator<Integer>() {
            /* class com.tencent.mm.plugin.webview.ui.tools.game.d.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(Integer num, Integer num2) {
                AppMethodBeat.i(211313);
                int compareTo = num.compareTo(num2);
                AppMethodBeat.o(211313);
                return compareTo;
            }
        });
        if (eVar != null) {
            treeMap.putAll(eVar.dTR());
            treeMap.putAll(eVar.dTS());
        }
        Map<Integer, Object> remove = Jqm.remove(str);
        if (remove != null) {
            remove.putAll(treeMap);
            treeMap = remove;
        }
        if (treeMap.containsKey(Integer.valueOf(b.Jqx))) {
            z = ((Boolean) treeMap.remove(Integer.valueOf(b.Jqx))).booleanValue();
        } else {
            z = true;
        }
        String bP = bP(treeMap);
        Log.i("MicroMsg.GameWebReport", "report web performance. isReportNow: %b, reportData: [%s]", Boolean.valueOf(z), bP);
        h.INSTANCE.a(16142, bP, z, false);
        AppMethodBeat.o(211314);
    }

    public static String bP(Map<Integer, Object> map) {
        AppMethodBeat.i(80871);
        if (map == null || map.isEmpty()) {
            AppMethodBeat.o(80871);
            return "";
        }
        int intValue = ((Integer) Collections.max(map.keySet())).intValue();
        int min = Math.min(intValue, 200);
        StringBuffer stringBuffer = new StringBuffer();
        for (int intValue2 = ((Integer) Collections.min(map.keySet())).intValue(); intValue2 <= min; intValue2++) {
            Object obj = map.get(Integer.valueOf(intValue2));
            if (obj != null) {
                stringBuffer.append(obj);
            }
            stringBuffer.append(",");
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(80871);
        return stringBuffer2;
    }
}
