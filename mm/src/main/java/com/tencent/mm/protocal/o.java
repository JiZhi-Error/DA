package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class o {
    public String host = "";
    private int port = 80;
    private int type = 0;
    public String yFq = "";

    public o() {
    }

    public o(int i2, String str, int i3, String str2) {
        this.type = i2;
        this.yFq = str;
        this.port = i3;
        this.host = str2;
    }

    public final String toString() {
        AppMethodBeat.i(133102);
        String str = this.type + "," + this.yFq + "," + this.port + "," + this.host;
        AppMethodBeat.o(133102);
        return str;
    }

    private static o bgc(String str) {
        AppMethodBeat.i(133103);
        String[] split = str.split(",");
        if (split.length < 4) {
            AppMethodBeat.o(133103);
            return null;
        }
        o oVar = new o();
        try {
            oVar.type = Util.getInt(split[0], 0);
            oVar.yFq = Util.nullAsNil(split[1]);
            oVar.port = Util.getInt(split[2], 0);
            oVar.host = Util.nullAsNil(split[3]);
            AppMethodBeat.o(133103);
            return oVar;
        } catch (NumberFormatException e2) {
            Log.e("MicroMsg.MMBuiltInIP", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(133103);
            return null;
        }
    }

    public static String iz(List<o> list) {
        AppMethodBeat.i(133104);
        String str = "";
        Iterator<o> it = list.iterator();
        while (it.hasNext()) {
            str = str + it.next().toString() + "|";
        }
        AppMethodBeat.o(133104);
        return str;
    }

    public static List<o> bgd(String str) {
        AppMethodBeat.i(133105);
        LinkedList linkedList = new LinkedList();
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(133105);
        } else {
            try {
                for (String str2 : str.split("\\|")) {
                    o bgc = bgc(str2);
                    if (bgc != null) {
                        linkedList.add(bgc);
                    }
                }
            } catch (Exception e2) {
                Log.d("MicroMsg.MMBuiltInIP", "unserialize split failed str[%s]", str);
                Log.e("MicroMsg.MMBuiltInIP", "exception:%s", Util.stackTraceToString(e2));
            }
            AppMethodBeat.o(133105);
        }
        return linkedList;
    }

    public static a mJ(String str, String str2) {
        AppMethodBeat.i(133106);
        Log.d("MicroMsg.MMBuiltInIP", "parsing network control params:");
        Log.d("MicroMsg.MMBuiltInIP", "ports = ".concat(String.valueOf(str)));
        Log.d("MicroMsg.MMBuiltInIP", "timeouts = ".concat(String.valueOf(str2)));
        int[] splitToIntArray = Util.splitToIntArray(str);
        int[] splitToIntArray2 = Util.splitToIntArray(str2);
        if (splitToIntArray2 == null || splitToIntArray2.length < 2) {
            splitToIntArray2 = new int[]{0, 0};
            Log.e("MicroMsg.MMBuiltInIP", "invalid timeouts");
        }
        a aVar = new a(splitToIntArray, (int) (((long) splitToIntArray2[0]) * 1000), (int) (((long) splitToIntArray2[1]) * 1000));
        AppMethodBeat.o(133106);
        return aVar;
    }

    public static class a {
        public final int[] KzK = null;
        public final int[] KzL;
        public final int KzM;
        public final int KzN;

        public a(int[] iArr, int i2, int i3) {
            this.KzL = iArr;
            this.KzM = i2;
            this.KzN = i3;
        }
    }
}
