package com.tencent.mm.aw;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.platformtools.WeChatSomeFeatureSwitch;
import com.tencent.mm.storage.RegionCodeDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

public final class b {
    private static Map<String, a> jbU = null;
    private static Map<String, String> jbV = null;
    private static String jbW = null;

    public static class a {
        public String jbX;
        public String jbY;
        public String jbZ;
        public String jca;
        public int jcb;

        public a(String str, String str2, String str3, String str4, int i2) {
            this.jbX = str;
            this.jbY = str2;
            this.jbZ = str3;
            this.jca = str4;
            this.jcb = i2;
        }
    }

    public static boolean bdC() {
        AppMethodBeat.i(43008);
        if (LocaleUtil.isChineseAppLang() || LocaleUtil.getApplicationLanguage().equals(LocaleUtil.ENGLISH)) {
            AppMethodBeat.o(43008);
            return false;
        }
        AppMethodBeat.o(43008);
        return true;
    }

    public static boolean bdE() {
        AppMethodBeat.i(43010);
        if (z.aTX() != 0 || !Util.isOverseasUser(MMApplicationContext.getContext())) {
            AppMethodBeat.o(43010);
            return true;
        }
        AppMethodBeat.o(43010);
        return false;
    }

    public static boolean bdF() {
        return false;
    }

    public static boolean bdG() {
        AppMethodBeat.i(43011);
        if (!LocaleUtil.getApplicationLanguage().equals(LocaleUtil.CHINA)) {
            AppMethodBeat.o(43011);
            return true;
        }
        if (TimeZone.getDefault().getRawOffset() != TimeZone.getTimeZone("GMT+08:00").getRawOffset()) {
            AppMethodBeat.o(43011);
            return true;
        }
        AppMethodBeat.o(43011);
        return false;
    }

    public static boolean isOverseasUser() {
        AppMethodBeat.i(259835);
        boolean isOverseasUser = Util.isOverseasUser(MMApplicationContext.getContext());
        AppMethodBeat.o(259835);
        return isOverseasUser;
    }

    private static void Pe(String str) {
        a aVar;
        AppMethodBeat.i(43013);
        jbU = new HashMap();
        jbV = new HashMap();
        String[] split = Util.nullAsNil(str).trim().split(",");
        for (int i2 = 0; i2 < split.length; i2++) {
            String[] split2 = split[i2].trim().split(":");
            if (split2.length < 4) {
                Log.e("MicroMsg.InternationaPluginlLogic", "this country item has problem %s", split[i2].trim());
            } else {
                RegionCodeDecoder.gEm();
                String locName = RegionCodeDecoder.getLocName(split2[0]);
                if (Util.isNullOrNil(locName)) {
                    locName = split2[2];
                }
                if (!LocaleUtil.isTraditionalChineseAppLang()) {
                    aVar = new a(split2[0], split2[1], locName, split2[3], split2[3].charAt(0));
                } else {
                    aVar = new a(split2[0], split2[1], locName, split2[3], a.Pd(locName));
                }
                jbU.put(aVar.jbX + aVar.jbY, aVar);
                jbV.put(aVar.jbX, aVar.jbY);
            }
        }
        if (WeChatSomeFeatureSwitch.onlyUSMobile()) {
            a aVar2 = jbU.get("US" + "1");
            HashMap hashMap = new HashMap();
            jbU = hashMap;
            hashMap.put("US" + "1", aVar2);
            HashMap hashMap2 = new HashMap();
            jbV = hashMap2;
            hashMap2.put(aVar2.jbX, aVar2.jbY);
        }
        AppMethodBeat.o(43013);
    }

    public static a bs(String str, String str2) {
        String str3 = null;
        AppMethodBeat.i(43014);
        try {
            str3 = LocaleUtil.getApplicationLanguage();
            if (str3 == null || !str3.equals(jbW)) {
                jbU = null;
            }
        } catch (Exception e2) {
        }
        if (jbU == null || jbV == null) {
            jbW = str3;
            Pe(str2);
        }
        a aVar = jbU.get(str.toUpperCase() + jbV.get(str.toUpperCase()));
        if (WeChatSomeFeatureSwitch.onlyUSMobile()) {
            aVar = jbU.get("US" + jbV.get("US"));
        }
        AppMethodBeat.o(43014);
        return aVar;
    }

    public static List<a> Pf(String str) {
        String str2 = null;
        AppMethodBeat.i(43015);
        try {
            str2 = LocaleUtil.getApplicationLanguage();
            if (str2 == null || !str2.equals(jbW)) {
                jbU = null;
            }
        } catch (Exception e2) {
        }
        if (jbU == null) {
            jbW = str2;
            Pe(str);
        }
        ArrayList arrayList = new ArrayList(jbU.values());
        AppMethodBeat.o(43015);
        return arrayList;
    }

    public static boolean Pg(String str) {
        AppMethodBeat.i(43016);
        if (str == null || str.length() <= 1 || !str.startsWith("+") || str.startsWith("+86")) {
            AppMethodBeat.o(43016);
            return false;
        }
        AppMethodBeat.o(43016);
        return true;
    }

    public static String Ph(String str) {
        AppMethodBeat.i(43017);
        if (str.startsWith("+886") || str.startsWith("+86")) {
            AppMethodBeat.o(43017);
            return "zh-TW";
        } else if (str.startsWith("+852") || str.startsWith("+853")) {
            AppMethodBeat.o(43017);
            return "zh-HK";
        } else if (str.startsWith("+81")) {
            AppMethodBeat.o(43017);
            return LocaleUtil.JAPANESE;
        } else if (str.startsWith("+82")) {
            AppMethodBeat.o(43017);
            return LocaleUtil.KOREAN;
        } else if (str.startsWith("+66")) {
            AppMethodBeat.o(43017);
            return LocaleUtil.THAI;
        } else if (str.startsWith("+84")) {
            AppMethodBeat.o(43017);
            return LocaleUtil.VIETNAMESE;
        } else if (str.startsWith("+62")) {
            AppMethodBeat.o(43017);
            return "id";
        } else if (str.startsWith("+55")) {
            AppMethodBeat.o(43017);
            return LocaleUtil.PORTUGUESE;
        } else if (str.startsWith("+34")) {
            AppMethodBeat.o(43017);
            return "es-419";
        } else {
            AppMethodBeat.o(43017);
            return LocaleUtil.ENGLISH;
        }
    }

    public static String bt(String str, String str2) {
        String str3 = null;
        AppMethodBeat.i(43018);
        try {
            str3 = LocaleUtil.getApplicationLanguage();
            if (str3 == null || !str3.equals(jbW)) {
                jbU = null;
            }
        } catch (Exception e2) {
        }
        if (jbU == null) {
            jbW = str3;
            Pe(str2);
        }
        for (a aVar : jbU.values()) {
            if (aVar.jbY.equals(str)) {
                String str4 = aVar.jbZ;
                AppMethodBeat.o(43018);
                return str4;
            }
        }
        AppMethodBeat.o(43018);
        return "";
    }

    public static String bu(String str, String str2) {
        String str3 = null;
        AppMethodBeat.i(43019);
        try {
            str3 = LocaleUtil.getApplicationLanguage();
            if (str3 == null || !str3.equals(jbW)) {
                jbU = null;
            }
        } catch (Exception e2) {
        }
        if (jbU == null) {
            jbW = str3;
            Pe(str2);
        }
        for (a aVar : jbU.values()) {
            if (aVar.jbY.equals(str)) {
                String str4 = aVar.jbX;
                AppMethodBeat.o(43019);
                return str4;
            }
        }
        AppMethodBeat.o(43019);
        return "";
    }

    public static boolean Pi(String str) {
        AppMethodBeat.i(43020);
        if (Util.isNullOrNil(str) || !new HashSet(Arrays.asList("AT,BE,BG,CY,CZ,HR,DK,EE,FI,FR,DE,GR,HU,IE,IT,LV,RO,LT,LU,MT,NL,PL,PT,SK,SI,ES,SE,GB,IS,LI,NO,CH,TR".split(","))).contains(str.toUpperCase())) {
            AppMethodBeat.o(43020);
            return false;
        }
        AppMethodBeat.o(43020);
        return true;
    }

    public static boolean Pj(String str) {
        AppMethodBeat.i(43021);
        if (Util.isNullOrNil(str) || !new HashSet(Arrays.asList("43,32,359,357,420,385,45,372,358,33,49,30,36,353,39,371,40,370,352,356,31,48,351,421,386,34,46,44,354,423,47,41,90".split(","))).contains(str)) {
            AppMethodBeat.o(43021);
            return false;
        }
        AppMethodBeat.o(43021);
        return true;
    }

    public static boolean bdD() {
        AppMethodBeat.i(258024);
        if (!Util.isOverseasUser(MMApplicationContext.getContext()) || !WeChatBrands.AppInfo.current().isMainland()) {
            AppMethodBeat.o(258024);
            return false;
        }
        AppMethodBeat.o(258024);
        return true;
    }
}
