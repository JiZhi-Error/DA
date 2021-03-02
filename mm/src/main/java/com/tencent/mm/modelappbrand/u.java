package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.hr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.util.HashMap;
import java.util.Map;

public final class u {
    private static Map<String, Long> iIv = new HashMap();
    private static Map<String, Long> iIw = new HashMap();
    private static Map<String, Long> iIx = new HashMap();
    private static Map<String, Long> iIy = new HashMap();
    private static Map<String, a> iIz = new HashMap();

    public static final class a {
        public String dNI;
        public String iIA;
        public int iIB;
        public boolean iIC;
        public int serviceType;
    }

    static {
        AppMethodBeat.i(76390);
        AppMethodBeat.o(76390);
    }

    public static void Ls(String str) {
        AppMethodBeat.i(76378);
        a aVar = iIz.get(str);
        if (aVar != null) {
            if (aVar.iIC) {
                i("SearchWidgetStartTrace", "do not report draw succ agagin", new Object[0]);
                AppMethodBeat.o(76378);
                return;
            }
            aVar.iIC = true;
        }
        v.pl(20);
        hr vt = new hr().vt(Lv(str));
        vt.eBS = (long) Lt(str);
        vt.eMi = 12;
        vt.eMk = 1;
        hr vs = vt.vs(str);
        vs.eMj = System.currentTimeMillis();
        vs.vu(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bfK();
        AppMethodBeat.o(76378);
    }

    public static void a(String str, int i2, String str2, String str3, int i3) {
        AppMethodBeat.i(76379);
        a aVar = iIz.get(str);
        if (aVar == null) {
            aVar = new a();
        }
        aVar.dNI = str2;
        aVar.serviceType = i2;
        aVar.iIB = i3;
        aVar.iIA = str3;
        iIz.put(str, aVar);
        AppMethodBeat.o(76379);
    }

    public static int Lt(String str) {
        AppMethodBeat.i(76380);
        a aVar = iIz.get(str);
        if (aVar != null) {
            int i2 = aVar.serviceType;
            AppMethodBeat.o(76380);
            return i2;
        }
        AppMethodBeat.o(76380);
        return 0;
    }

    public static boolean Lu(String str) {
        AppMethodBeat.i(76381);
        boolean containsKey = iIz.containsKey(str);
        AppMethodBeat.o(76381);
        return containsKey;
    }

    public static String Lv(String str) {
        AppMethodBeat.i(76382);
        a aVar = iIz.get(str);
        if (aVar != null) {
            String str2 = aVar.iIA;
            AppMethodBeat.o(76382);
            return str2;
        }
        AppMethodBeat.o(76382);
        return str;
    }

    public static int Lw(String str) {
        AppMethodBeat.i(76383);
        a aVar = iIz.get(str);
        if (aVar != null) {
            int i2 = aVar.iIB;
            AppMethodBeat.o(76383);
            return i2;
        }
        AppMethodBeat.o(76383);
        return 0;
    }

    public static void v(String str, String str2, Object... objArr) {
        AppMethodBeat.i(76384);
        Log.i("SearchWidgetStartTrace", "widget trace - " + str + "-" + str2, objArr);
        AppMethodBeat.o(76384);
    }

    public static void i(String str, String str2, Object... objArr) {
        AppMethodBeat.i(76385);
        Log.i("SearchWidgetStartTrace", "widget trace - " + str + "-" + str2, objArr);
        AppMethodBeat.o(76385);
    }

    public static void e(String str, String str2, Object... objArr) {
        AppMethodBeat.i(76386);
        Log.e("SearchWidgetStartTrace", "widget trace - " + str + "-" + str2, objArr);
        AppMethodBeat.o(76386);
    }

    public static void Lx(String str) {
        AppMethodBeat.i(76387);
        Log.i("SearchWidgetStartTrace", "realInsert %s", str);
        AppMethodBeat.o(76387);
    }

    public static void J(String str, boolean z) {
        AppMethodBeat.i(76388);
        Log.i("SearchWidgetStartTrace", "drawEnd %s,succ %s", str, Boolean.valueOf(z));
        if (z) {
            if ((iIv.containsKey(str) ? iIv.get(str).longValue() : 0) > 0) {
                System.currentTimeMillis();
                AppMethodBeat.o(76388);
                return;
            }
            Log.e("SearchWidgetStartTrace", "can't find widget Recv timestamp for appid %s", str);
        }
        AppMethodBeat.o(76388);
    }

    public static void aXS() {
        AppMethodBeat.i(76389);
        Log.i("SearchWidgetStartTrace", "hasInitData %s", Boolean.TRUE);
        AppMethodBeat.o(76389);
    }
}
