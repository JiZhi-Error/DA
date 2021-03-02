package com.tencent.xweb;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.JsRuntime;
import com.tencent.xweb.WebView;
import com.tencent.xweb.internal.a;
import com.tencent.xweb.internal.i;
import com.tencent.xweb.internal.j;
import com.tencent.xweb.internal.l;
import com.tencent.xweb.util.e;
import com.tencent.xweb.util.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public class a {
    private static a SyD;
    static boolean SyE = false;
    static String SyF = "";
    static int SyG = 0;
    static String[] SyI = {"disable_url_watchdog"};
    Map<String, Object> SyH = new HashMap();

    /* renamed from: com.tencent.xweb.a$a  reason: collision with other inner class name */
    public static class C2230a {
        public boolean SyJ = false;
        public Object SyK = null;
    }

    public a() {
        AppMethodBeat.i(156676);
        AppMethodBeat.o(156676);
    }

    public static synchronized a hsb() {
        a aVar;
        synchronized (a.class) {
            AppMethodBeat.i(156677);
            if (SyD == null) {
                a aVar2 = new a();
                SyD = aVar2;
                aVar2.hse();
            }
            aVar = SyD;
            AppMethodBeat.o(156677);
        }
        return aVar;
    }

    public static synchronized void hsc() {
        synchronized (a.class) {
            AppMethodBeat.i(185165);
            SyD = null;
            Log.i("CommandCfg", "resetCommandCfg ");
            hsb();
            AppMethodBeat.o(185165);
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void hse() {
        boolean z;
        Map brP;
        AppMethodBeat.i(156679);
        this.SyH.clear();
        SharedPreferences hsd = hsd();
        SyF = hsd.getString("cStrTAGConfigVer", "");
        String string = hsd.getString("cStrTAGConfigSdkVer", "");
        int intValue = !TextUtils.isEmpty(string) ? e.bsD(string).intValue() : 0;
        SyG = intValue;
        if (intValue < 200502) {
            XWalkEnvironment.addXWalkInitializeLog("config sdk ver is old , use deserized from old");
            z = true;
        } else {
            z = false;
        }
        Map<String, ?> all = hsd.getAll();
        if (all == null || all.size() == 0) {
            AppMethodBeat.o(156679);
        } else {
            for (Map.Entry<String, ?> entry : all.entrySet()) {
                String key = entry.getKey();
                String string2 = hsd.getString(key, "");
                if (!(key == null || string2 == null)) {
                    if (z) {
                        brP = new HashMap();
                        if (string2 != null && !string2.isEmpty()) {
                            String[] split = string2.split(";");
                            for (String str : split) {
                                if (str != null && !str.isEmpty()) {
                                    String[] split2 = str.split(":");
                                    if (!(split2.length != 2 || split2[0] == null || split2[1] == null)) {
                                        brP.put(split2[0], split2[1]);
                                    }
                                }
                            }
                        }
                    } else {
                        brP = brP(string2);
                    }
                    if (brP.size() == 0) {
                        this.SyH.put(key, string2);
                    } else {
                        this.SyH.put(key, brP);
                    }
                }
            }
            AppMethodBeat.o(156679);
        }
    }

    public synchronized String hsf() {
        String sb;
        AppMethodBeat.i(156681);
        StringBuilder sb2 = new StringBuilder(512);
        Set<String> keySet = this.SyH.keySet();
        sb2.append("strConfig ver = " + SyF + "\n");
        sb2.append("strConfig sdk ver = " + SyG + "\n");
        if (keySet == null) {
            sb = sb2.toString();
            AppMethodBeat.o(156681);
        } else {
            for (String str : keySet) {
                if (!TextUtils.isEmpty(str)) {
                    String cs = cs(brD(str));
                    if (cs == null) {
                        cs = "";
                    }
                    sb2.append(str + " : ");
                    sb2.append(cs);
                    sb2.append("\n");
                }
            }
            sb = sb2.toString();
            AppMethodBeat.o(156681);
        }
        return sb;
    }

    public static void asP(int i2) {
        AppMethodBeat.i(156682);
        XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit().putInt("cStrSpKeyConfigPeriod", i2).commit();
        AppMethodBeat.o(156682);
    }

    public static int hsg() {
        AppMethodBeat.i(156683);
        int i2 = XWalkEnvironment.getSharedPreferencesForUpdateConfig().getInt("cStrSpKeyConfigPeriod", -1);
        if (i2 <= 30) {
            AppMethodBeat.o(156683);
            return -1;
        }
        int i3 = i2 * 60 * 1000;
        AppMethodBeat.o(156683);
        return i3;
    }

    public final synchronized Map<String, String> brD(String str) {
        Map<String, String> ab;
        AppMethodBeat.i(156684);
        ab = ab(str, this.SyH);
        AppMethodBeat.o(156684);
        return ab;
    }

    public static String brJ(String str) {
        AppMethodBeat.i(156691);
        String curStrModule = WebView.getCurStrModule();
        if (TextUtils.isEmpty(curStrModule)) {
            curStrModule = "tools";
        }
        String nS = nS(str, curStrModule);
        AppMethodBeat.o(156691);
        return nS;
    }

    public final synchronized int av(String str, String str2, int i2) {
        AppMethodBeat.i(218986);
        String nU = nU(str, str2);
        if (TextUtils.isEmpty(nU)) {
            AppMethodBeat.o(218986);
        } else {
            e.a bsD = e.bsD(nU);
            if (!bsD.SEF) {
                AppMethodBeat.o(218986);
            } else {
                i2 = bsD.intValue();
                AppMethodBeat.o(218986);
            }
        }
        return i2;
    }

    public final synchronized boolean nT(String str, String str2) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(218987);
            String nU = nU(str, str2);
            if (TextUtils.isEmpty(nU)) {
                AppMethodBeat.o(218987);
            } else if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(nU)) {
                z = true;
                AppMethodBeat.o(218987);
            } else if ("false".equalsIgnoreCase(nU)) {
                AppMethodBeat.o(218987);
            } else {
                AppMethodBeat.o(218987);
            }
        }
        return z;
    }

    /* access modifiers changed from: protected */
    public final synchronized String nU(String str, String str2) {
        String str3;
        String str4;
        String[] split;
        i bsy;
        AppMethodBeat.i(218988);
        Map<String, String> brD = brD(str);
        if (TextUtils.isEmpty(str2)) {
            str2 = WebView.getCurStrModule();
            if (TextUtils.isEmpty(str2)) {
                str2 = "tools";
            }
        }
        if (brD == null || str2 == null) {
            str3 = "";
            AppMethodBeat.o(218988);
        } else {
            str3 = brD.get(str2);
            if (!TextUtils.isEmpty(str3) && str3.contains("[") && str3.contains("]")) {
                double htS = e.htS();
                String[] split2 = TextUtils.split(str3, "]");
                int length = split2.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        str3 = "";
                        AppMethodBeat.o(218988);
                        break;
                    }
                    String str5 = split2[i2];
                    if (!TextUtils.isEmpty(str5)) {
                        String trim = str5.trim();
                        if (trim.startsWith(";")) {
                            str4 = trim.substring(1);
                        } else {
                            str4 = trim;
                        }
                        int indexOf = str4.indexOf(91);
                        str3 = str4.substring(0, indexOf);
                        String substring = str4.substring(indexOf + 1);
                        ArrayList arrayList = new ArrayList();
                        if (!(TextUtils.isEmpty(substring) || (split = substring.split(";")) == null || split.length == 0)) {
                            e.htS();
                            for (String str6 : split) {
                                if (!TextUtils.isEmpty(str6) && (bsy = i.bsy(str6)) != null) {
                                    arrayList.add(bsy);
                                }
                            }
                        }
                        j.a aVar = new j.a((byte) 0);
                        aVar.dZc = str3;
                        aVar.SDP = arrayList;
                        if (aVar.I(htS)) {
                            AppMethodBeat.o(218988);
                            break;
                        }
                    }
                    i2++;
                }
            } else {
                AppMethodBeat.o(218988);
            }
        }
        return str3;
    }

    protected static boolean brK(String str) {
        AppMethodBeat.i(156694);
        if ("revertToVersion".equals(str)) {
            AppMethodBeat.o(156694);
            return true;
        }
        AppMethodBeat.o(156694);
        return false;
    }

    public static void a(a.C2231a[] aVarArr, String str) {
        AppMethodBeat.i(156695);
        a(aVarArr, str, false);
        AppMethodBeat.o(156695);
    }

    public static synchronized void a(a.C2231a[] aVarArr, String str, boolean z) {
        synchronized (a.class) {
            AppMethodBeat.i(156696);
            hsb().b(aVarArr, str, z);
            AppMethodBeat.o(156696);
        }
    }

    protected static void a(a.C2231a aVar, Map<String, Object> map, String[] strArr) {
        HashMap hashMap;
        AppMethodBeat.i(156698);
        String str = aVar.SCF;
        String str2 = aVar.SCG;
        if (aVar.SCF.equals("executeCommand")) {
            String[] brL = brL(aVar.SCG);
            if (brL == null || brL.length < 2) {
                AppMethodBeat.o(156698);
                return;
            } else {
                str = brL[0];
                str2 = brL[1];
            }
        }
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(156698);
            return;
        }
        Map<String, String> ab = ab(str, map);
        if (ab == null || ab.isEmpty()) {
            HashMap hashMap2 = new HashMap();
            map.put(str, hashMap2);
            hashMap = hashMap2;
        } else {
            hashMap = ab;
        }
        for (String str3 : strArr) {
            String trim = str3.trim();
            if (trim != null && !trim.isEmpty() && !hashMap.containsKey(trim)) {
                hashMap.put(trim, str2);
            }
        }
        AppMethodBeat.o(156698);
    }

    public static String[] brL(String str) {
        AppMethodBeat.i(156699);
        String[] strArr = new String[2];
        if (str == null || !str.contains(":")) {
            AppMethodBeat.o(156699);
            return null;
        }
        int indexOf = str.indexOf(58);
        strArr[0] = str.substring(0, indexOf);
        if (str.length() - 1 <= indexOf) {
            strArr[1] = "";
        } else {
            strArr[1] = str.substring(indexOf + 1);
        }
        AppMethodBeat.o(156699);
        return strArr;
    }

    private static WebView.c brM(String str) {
        AppMethodBeat.i(156700);
        if (str == null || str.isEmpty()) {
            WebView.c cVar = WebView.c.WV_KIND_NONE;
            AppMethodBeat.o(156700);
            return cVar;
        }
        WebView.c cVar2 = WebView.c.WV_KIND_NONE;
        try {
            cVar2 = WebView.c.valueOf(str);
        } catch (Exception e2) {
        }
        AppMethodBeat.o(156700);
        return cVar2;
    }

    private static JsRuntime.JsRuntimeType brN(String str) {
        AppMethodBeat.i(156701);
        if (str == null || str.isEmpty()) {
            JsRuntime.JsRuntimeType jsRuntimeType = JsRuntime.JsRuntimeType.RT_TYPE_AUTO;
            AppMethodBeat.o(156701);
            return jsRuntimeType;
        }
        JsRuntime.JsRuntimeType jsRuntimeType2 = JsRuntime.JsRuntimeType.RT_TYPE_AUTO;
        try {
            jsRuntimeType2 = JsRuntime.JsRuntimeType.valueOf(str);
        } catch (Exception e2) {
        }
        AppMethodBeat.o(156701);
        return jsRuntimeType2;
    }

    private static WebView.a brO(String str) {
        AppMethodBeat.i(156702);
        if (str == null || str.isEmpty()) {
            WebView.a aVar = WebView.a.HOOK_EVALUTE_JS;
            AppMethodBeat.o(156702);
            return aVar;
        }
        WebView.a aVar2 = WebView.a.HOOK_EVALUTE_JS;
        try {
            aVar2 = WebView.a.valueOf(str);
        } catch (Exception e2) {
        }
        AppMethodBeat.o(156702);
        return aVar2;
    }

    static String cs(Map<String, String> map) {
        AppMethodBeat.i(156703);
        if (map == null) {
            AppMethodBeat.o(156703);
            return "";
        }
        StringBuilder sb = new StringBuilder(128);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (sb.length() != 0) {
                sb.append("~~~");
            }
            sb.append(entry.getKey());
            sb.append("```");
            sb.append(entry.getValue());
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(156703);
        return sb2;
    }

    private static Map<String, String> brP(String str) {
        AppMethodBeat.i(218989);
        HashMap hashMap = new HashMap();
        if (str == null || str.isEmpty()) {
            AppMethodBeat.o(218989);
        } else {
            String[] split = str.split("~~~");
            for (String str2 : split) {
                if (str2 != null && !str2.isEmpty()) {
                    String[] split2 = str2.split("```");
                    if (!(split2.length != 2 || split2[0] == null || split2[1] == null)) {
                        hashMap.put(split2[0], split2[1]);
                    }
                }
            }
            AppMethodBeat.o(218989);
        }
        return hashMap;
    }

    private synchronized void hsh() {
        AppMethodBeat.i(156705);
        Map<String, ?> all = hsd().getAll();
        if (all == null || all.size() == 0) {
            AppMethodBeat.o(156705);
        } else {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, ?> entry : all.entrySet()) {
                arrayList.add(entry.getKey());
            }
            SharedPreferences.Editor edit = hsd().edit();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (!"cStrTAGConfigVer".equalsIgnoreCase(str) && !"cStrTAGConfigSdkVer".equalsIgnoreCase(str)) {
                    edit.remove(str);
                }
            }
            edit.commit();
            AppMethodBeat.o(156705);
        }
    }

    private synchronized void hsi() {
        Object value;
        AppMethodBeat.i(156706);
        hsh();
        SharedPreferences.Editor edit = hsd().edit();
        edit.putString("cStrTAGConfigVer", SyF);
        edit.putString("cStrTAGConfigSdkVer", "201201");
        for (Map.Entry<String, Object> entry : this.SyH.entrySet()) {
            if (!(entry.getKey() == null || entry.getKey().isEmpty() || (value = entry.getValue()) == null)) {
                if (value instanceof Map) {
                    try {
                        Map map = (Map) value;
                        if (map != null) {
                            edit.putString(entry.getKey(), cs(map));
                        }
                    } catch (Exception e2) {
                        edit.putString(entry.getKey(), value.toString());
                    }
                } else {
                    edit.putString(entry.getKey(), value.toString());
                }
            }
        }
        edit.commit();
        XWalkEnvironment.addXWalkInitializeLog(hsf());
        AppMethodBeat.o(156706);
    }

    public SharedPreferences hsd() {
        AppMethodBeat.i(156678);
        SharedPreferences mMKVSharedTransportOld = XWalkEnvironment.getMMKVSharedTransportOld("XWEB.CMDCFG");
        AppMethodBeat.o(156678);
        return mMKVSharedTransportOld;
    }

    public static String getAbstractInfo() {
        AppMethodBeat.i(156680);
        hsb();
        String hsf = hsb().hsf();
        AppMethodBeat.o(156680);
        return hsf;
    }

    private static Map<String, String> ab(String str, Map<String, Object> map) {
        AppMethodBeat.i(156685);
        hsb();
        if (str == null || str.isEmpty()) {
            HashMap hashMap = new HashMap();
            AppMethodBeat.o(156685);
            return hashMap;
        }
        Object obj = map.get(str);
        if (obj instanceof HashMap) {
            Map<String, String> map2 = (Map) obj;
            AppMethodBeat.o(156685);
            return map2;
        }
        HashMap hashMap2 = new HashMap();
        AppMethodBeat.o(156685);
        return hashMap2;
    }

    public static WebView.c brE(String str) {
        AppMethodBeat.i(156686);
        hsb();
        String nS = nS("setwebtype", str);
        hsb();
        WebView.c brM = brM(nS);
        AppMethodBeat.o(156686);
        return brM;
    }

    public static JsRuntime.JsRuntimeType brF(String str) {
        AppMethodBeat.i(156687);
        hsb();
        String nS = nS("setjscore", str);
        hsb();
        JsRuntime.JsRuntimeType brN = brN(nS);
        AppMethodBeat.o(156687);
        return brN;
    }

    public static WebView.a brG(String str) {
        AppMethodBeat.i(156688);
        hsb();
        String nS = nS("setfullscreenvideo", str);
        hsb();
        WebView.a brO = brO(nS);
        AppMethodBeat.o(156688);
        return brO;
    }

    public static int brH(String str) {
        AppMethodBeat.i(156689);
        hsb();
        String nS = nS("setTraceSampleRatioInTenThousand", str);
        if (TextUtils.isEmpty(nS) || !TextUtils.isDigitsOnly(nS)) {
            AppMethodBeat.o(156689);
            return 0;
        }
        int parseInt = Integer.parseInt(nS);
        AppMethodBeat.o(156689);
        return parseInt;
    }

    public static String brI(String str) {
        AppMethodBeat.i(156690);
        hsb();
        String nS = nS("setEnabledTraceCategory", str);
        AppMethodBeat.o(156690);
        return nS;
    }

    public static synchronized String nS(String str, String str2) {
        String nU;
        synchronized (a.class) {
            AppMethodBeat.i(156692);
            hsb();
            nU = hsb().nU(str, str2);
            AppMethodBeat.o(156692);
        }
        return nU;
    }

    /* access modifiers changed from: protected */
    public void b(a.C2231a[] aVarArr, String str, boolean z) {
        AppMethodBeat.i(156697);
        hsb();
        if (str == null) {
            AppMethodBeat.o(156697);
            return;
        }
        XWalkEnvironment.addXWalkInitializeLog("apply command config version is ".concat(String.valueOf(str)));
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        HashMap hashMap5 = new HashMap();
        Map<String, Object> hashMap6 = new HashMap<>();
        hashMap6.put("setwebtype", hashMap);
        hashMap6.put("setjscore", hashMap2);
        hashMap6.put("setfullscreenvideo", hashMap3);
        hashMap6.put("setTraceSampleRatioInTenThousand", hashMap4);
        hashMap6.put("setEnabledTraceCategory", hashMap5);
        if (aVarArr == null || aVarArr.length == 0) {
            ac(str, hashMap6);
            AppMethodBeat.o(156697);
            return;
        }
        int i2 = -1;
        for (int i3 = 0; i3 < aVarArr.length; i3++) {
            if (aVarArr[i3] != null && ((!z || !brK(aVarArr[i3].SCF)) && aVarArr[i3].SCE.htw())) {
                C2230a aVar = (C2230a) l.g(WebView.c.WV_KIND_CW).excute("STR_CMD_EXXCUTE_CMD_FROM_CONFIG", new Object[]{aVarArr[i3]});
                if ((aVar == null || !aVar.SyJ) && aVarArr[i3].SCG != null) {
                    if (aVarArr[i3].SCF.equals("setConfigPeriod")) {
                        try {
                            i2 = Integer.parseInt(aVarArr[i3].SCG);
                        } catch (Exception e2) {
                            Log.e("CommandCfg", "parse pariod cmdvalue to int failed , value is " + aVarArr[i3].SCG);
                        }
                    }
                    if (aVarArr[i3].SCH != null && !aVarArr[i3].SCH.isEmpty()) {
                        String[] split = aVarArr[i3].SCH.split(",");
                        if (aVarArr[i3].SCF.equals("setwebtype")) {
                            boolean z2 = false;
                            for (String str2 : split) {
                                String trim = str2.trim();
                                if (trim != null && !trim.isEmpty() && !hashMap.containsKey(trim)) {
                                    hashMap.put(trim, aVarArr[i3].SCG);
                                    z2 = true;
                                }
                            }
                            if (z2 && aVarArr[i3].SCE.SDa > 0) {
                                h.OQ(199);
                            }
                        } else if (aVarArr[i3].SCF.equals("setjscore")) {
                            for (String str3 : split) {
                                String trim2 = str3.trim();
                                if (trim2 != null && !trim2.isEmpty() && !hashMap2.containsKey(trim2)) {
                                    hashMap2.put(trim2, aVarArr[i3].SCG);
                                }
                            }
                        } else if (aVarArr[i3].SCF.equals("setfullscreenvideo")) {
                            for (String str4 : split) {
                                String trim3 = str4.trim();
                                if (trim3 != null && !trim3.isEmpty() && !hashMap3.containsKey(trim3)) {
                                    hashMap3.put(trim3, aVarArr[i3].SCG);
                                }
                            }
                        } else if (aVarArr[i3].SCF.equals("setTraceSampleRatioInTenThousand")) {
                            for (String str5 : split) {
                                String trim4 = str5.trim();
                                if (trim4 != null && !trim4.isEmpty() && !hashMap4.containsKey(trim4)) {
                                    hashMap4.put(trim4, aVarArr[i3].SCG);
                                }
                            }
                        } else if (aVarArr[i3].SCF.equals("setEnabledTraceCategory")) {
                            for (String str6 : split) {
                                String trim5 = str6.trim();
                                if (trim5 != null && !trim5.isEmpty() && !hashMap5.containsKey(trim5)) {
                                    hashMap5.put(trim5, aVarArr[i3].SCG);
                                }
                            }
                        } else {
                            a(aVarArr[i3], hashMap6, split);
                        }
                    }
                }
            }
        }
        asP(i2);
        ac(str, hashMap6);
        AppMethodBeat.o(156697);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void ac(String str, Map<String, Object> map) {
        AppMethodBeat.i(156704);
        SyF = str;
        this.SyH = map;
        hsi();
        AppMethodBeat.o(156704);
    }
}
