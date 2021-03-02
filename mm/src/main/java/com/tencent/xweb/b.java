package com.tencent.xweb;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.a;
import com.tencent.xweb.f;
import com.tencent.xweb.internal.a;
import com.tencent.xweb.internal.l;
import java.util.HashMap;
import java.util.Set;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class b extends a {
    static b SyL;

    private static synchronized b hsj() {
        b bVar;
        synchronized (b.class) {
            AppMethodBeat.i(156707);
            if (SyL == null) {
                b bVar2 = new b();
                SyL = bVar2;
                bVar2.hse();
            }
            bVar = SyL;
            AppMethodBeat.o(156707);
        }
        return bVar;
    }

    public static synchronized void hsk() {
        synchronized (b.class) {
            AppMethodBeat.i(161632);
            Log.i("CommandCfgPlugin", "resetCommandCfgPlugin ");
            SyL = null;
            hsj();
            AppMethodBeat.o(161632);
        }
    }

    @Override // com.tencent.xweb.a
    public final SharedPreferences hsd() {
        AppMethodBeat.i(156708);
        SharedPreferences mMKVSharedPreferences = XWalkEnvironment.getMMKVSharedPreferences("XWEB.CMDCFG.PLUGIN");
        AppMethodBeat.o(156708);
        return mMKVSharedPreferences;
    }

    public static String getAbstractInfo() {
        AppMethodBeat.i(156709);
        try {
            String hsf = hsj().hsf();
            AppMethodBeat.o(156709);
            return hsf;
        } catch (Exception e2) {
            Log.e("CommandCfgPlugin", "getAbstractInfo error ", e2);
            AppMethodBeat.o(156709);
            return "";
        }
    }

    @Override // com.tencent.xweb.a
    public final synchronized String hsf() {
        String sb;
        AppMethodBeat.i(156710);
        StringBuilder sb2 = new StringBuilder(512);
        Set<String> keySet = this.SyH.keySet();
        if (keySet == null) {
            sb = "";
            AppMethodBeat.o(156710);
        } else {
            for (String str : keySet) {
                if (!TextUtils.isEmpty(str)) {
                    String cs = cs(brD(str));
                    if (cs == null) {
                        cs = "";
                    }
                    sb2.append(" ");
                    sb2.append(str);
                    sb2.append(" : ");
                    sb2.append(cs);
                    sb2.append("\n");
                }
            }
            sb = sb2.toString();
            AppMethodBeat.o(156710);
        }
        return sb;
    }

    public static void a(a.C2231a[] aVarArr, String str) {
        AppMethodBeat.i(156711);
        hsj().b(aVarArr, str, false);
        AppMethodBeat.o(156711);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.xweb.a
    public final void b(a.C2231a[] aVarArr, String str, boolean z) {
        AppMethodBeat.i(156712);
        if (str == null) {
            AppMethodBeat.o(156712);
            return;
        }
        HashMap hashMap = new HashMap();
        if (aVarArr == null || aVarArr.length == 0) {
            ac(str, hashMap);
            AppMethodBeat.o(156712);
            return;
        }
        for (int i2 = 0; i2 < aVarArr.length; i2++) {
            if (aVarArr[i2] != null && ((!z || !brK(aVarArr[i2].SCF)) && aVarArr[i2].SCE.htw())) {
                a.C2230a aVar = (a.C2230a) l.g(WebView.c.WV_KIND_CW).excute("STR_CMD_EXXCUTE_CMD_FROM_CONFIG", new Object[]{aVarArr[i2]});
                if ((aVar == null || !aVar.SyJ) && aVarArr[i2].SCG != null && aVarArr[i2].SCH != null && !aVarArr[i2].SCH.isEmpty()) {
                    a(aVarArr[i2], hashMap, aVarArr[i2].SCH.split(","));
                }
            }
        }
        ac(str, hashMap);
        AppMethodBeat.o(156712);
    }

    public static String brJ(String str) {
        AppMethodBeat.i(156713);
        String curStrModule = WebView.getCurStrModule();
        if (TextUtils.isEmpty(curStrModule)) {
            curStrModule = "tools";
        }
        String nS = nS(str, curStrModule);
        AppMethodBeat.o(156713);
        return nS;
    }

    public static synchronized String nS(String str, String str2) {
        String nU;
        synchronized (b.class) {
            AppMethodBeat.i(156714);
            nU = hsj().nU(str, str2);
            AppMethodBeat.o(156714);
        }
        return nU;
    }

    public static int hsl() {
        AppMethodBeat.i(218990);
        try {
            String nS = nS("setPluginConfigPeriod", "tools");
            if (nS == null || nS.isEmpty()) {
                AppMethodBeat.o(218990);
                return -1;
            }
            int parseInt = Integer.parseInt(nS);
            if (parseInt < 30) {
                AppMethodBeat.o(218990);
                return -1;
            }
            int i2 = parseInt * 60 * 1000;
            AppMethodBeat.o(218990);
            return i2;
        } catch (Exception e2) {
            Log.e("CommandCfgPlugin", "getCmdPluginUpdatePeriod error: ", e2);
            AppMethodBeat.o(218990);
            return -1;
        }
    }

    public static boolean hsm() {
        AppMethodBeat.i(218991);
        try {
            String nS = nS("download_when_not_install", hso());
            if (nS == null || nS.isEmpty()) {
                AppMethodBeat.o(218991);
                return false;
            }
            boolean parseBoolean = Boolean.parseBoolean(nS);
            AppMethodBeat.o(218991);
            return parseBoolean;
        } catch (Exception e2) {
            Log.e("CommandCfgPlugin", "canDownloadWhenNotInstall error: ", e2);
            AppMethodBeat.o(218991);
            return false;
        }
    }

    public static boolean hsn() {
        AppMethodBeat.i(218992);
        try {
            String nS = nS("download_when_x5_fail", hso());
            if (nS == null || nS.isEmpty()) {
                AppMethodBeat.o(218992);
                return false;
            }
            boolean parseBoolean = Boolean.parseBoolean(nS);
            AppMethodBeat.o(218992);
            return parseBoolean;
        } catch (Exception e2) {
            Log.e("CommandCfgPlugin", "canDownloadWhenX5Fail error: ", e2);
            AppMethodBeat.o(218992);
            return false;
        }
    }

    public static HashMap<String, String> brQ(String str) {
        String[] split;
        AppMethodBeat.i(218993);
        try {
            String nS = nS("param_".concat(String.valueOf(str)), "tools");
            if (nS == null || nS.isEmpty()) {
                AppMethodBeat.o(218993);
                return null;
            }
            String[] split2 = nS.split(",");
            if (split2 == null) {
                AppMethodBeat.o(218993);
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            for (String str2 : split2) {
                if (str2 != null && !str2.isEmpty() && (split = str2.split("_")) != null && split.length == 2) {
                    hashMap.put(split[0], split[1]);
                }
            }
            AppMethodBeat.o(218993);
            return hashMap;
        } catch (Exception e2) {
            Log.e("CommandCfgPlugin", "getCmdPluginParam error: ", e2);
            AppMethodBeat.o(218993);
            return null;
        }
    }

    public static f.c nV(String str, String str2) {
        AppMethodBeat.i(218994);
        f.c brS = brS(nS("use_office_reader_" + str.toLowerCase(), str2));
        AppMethodBeat.o(218994);
        return brS;
    }

    public static f.c brR(String str) {
        AppMethodBeat.i(218995);
        f.c nV = nV(str, XWalkEnvironment.getSafeModuleForCommand("tools"));
        AppMethodBeat.o(218995);
        return nV;
    }

    public static f.c brS(String str) {
        AppMethodBeat.i(218996);
        f.c cVar = f.c.none;
        if (str == null || str.isEmpty()) {
            AppMethodBeat.o(218996);
        } else {
            try {
                cVar = f.c.valueOf(str);
            } catch (Exception e2) {
                cVar = f.c.none;
            }
            AppMethodBeat.o(218996);
        }
        return cVar;
    }

    public static f.a nW(String str, String str2) {
        AppMethodBeat.i(218997);
        f.a brU = brU(nS("fr_" + str.toLowerCase(), str2));
        AppMethodBeat.o(218997);
        return brU;
    }

    public static f.a brT(String str) {
        AppMethodBeat.i(156715);
        f.a nW = nW(str, hso());
        AppMethodBeat.o(156715);
        return nW;
    }

    public static f.a brU(String str) {
        AppMethodBeat.i(156716);
        f.a aVar = f.a.NONE;
        if (str == null || str.isEmpty()) {
            AppMethodBeat.o(156716);
        } else {
            try {
                aVar = f.a.valueOf(str);
            } catch (Exception e2) {
                aVar = f.a.NONE;
            }
            AppMethodBeat.o(156716);
        }
        return aVar;
    }

    private static String hso() {
        AppMethodBeat.i(218998);
        if ("appbrand".equalsIgnoreCase(XWalkEnvironment.getSafeModuleForCommand("tools"))) {
            Log.i("CommandCfgPlugin", "getSafeModuleForFileReader use module appbrand");
            AppMethodBeat.o(218998);
            return "appbrand";
        }
        Log.i("CommandCfgPlugin", "getSafeModuleForFileReader use module tools");
        AppMethodBeat.o(218998);
        return "tools";
    }
}
