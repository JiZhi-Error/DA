package com.tencent.mm.model;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ci;
import com.tencent.recovery.wx.util.WXUtil;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class z {
    private static int iCB = -1;

    public static boolean Im(String str) {
        AppMethodBeat.i(42789);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(42789);
            return false;
        }
        String aTY = aTY();
        if (aTY == null || aTY.length() <= 0) {
            Log.e("MicroMsg.ConfigStorageLogic", "get userinfo fail");
            AppMethodBeat.o(42789);
            return false;
        }
        boolean equals = aTY.equals(str);
        AppMethodBeat.o(42789);
        return equals;
    }

    public static int aTX() {
        AppMethodBeat.i(42790);
        g.aAi();
        Integer num = (Integer) g.aAh().azQ().get(9, (Object) null);
        if (num == null) {
            AppMethodBeat.o(42790);
            return 0;
        }
        int intValue = num.intValue();
        AppMethodBeat.o(42790);
        return intValue;
    }

    public static String getUserBindEmail() {
        AppMethodBeat.i(42791);
        g.aAi();
        String nullAsNil = Util.nullAsNil((String) g.aAh().azQ().get(5, (Object) null));
        AppMethodBeat.o(42791);
        return nullAsNil;
    }

    public static String aTY() {
        AppMethodBeat.i(42792);
        g.aAi();
        String str = (String) g.aAh().azQ().get(2, (Object) null);
        AppMethodBeat.o(42792);
        return str;
    }

    public static String aTZ() {
        AppMethodBeat.i(42793);
        g.aAi();
        String str = (String) g.aAh().azQ().get(42, (Object) null);
        AppMethodBeat.o(42793);
        return str;
    }

    public static String aUa() {
        AppMethodBeat.i(42794);
        g.aAi();
        String nullAsNil = Util.nullAsNil((String) g.aAh().azQ().get(4, (Object) null));
        AppMethodBeat.o(42794);
        return nullAsNil;
    }

    public static String aUb() {
        AppMethodBeat.i(42795);
        String aTZ = aTZ();
        if (!Util.isNullOrNil(aTZ)) {
            AppMethodBeat.o(42795);
            return aTZ;
        }
        String aTY = aTY();
        AppMethodBeat.o(42795);
        return aTY;
    }

    public static int aUc() {
        AppMethodBeat.i(42796);
        g.aAi();
        Integer num = (Integer) g.aAh().azQ().get(7, (Object) null);
        if (num == null) {
            AppMethodBeat.o(42796);
            return 0;
        }
        int intValue = num.intValue();
        AppMethodBeat.o(42796);
        return intValue;
    }

    public static long aUd() {
        AppMethodBeat.i(42797);
        g.aAi();
        Long l = (Long) g.aAh().azQ().get(147457, (Object) null);
        if (l == null) {
            AppMethodBeat.o(42797);
            return 0;
        }
        long longValue = l.longValue();
        AppMethodBeat.o(42797);
        return longValue;
    }

    public static int aUe() {
        AppMethodBeat.i(42798);
        g.aAi();
        Integer num = (Integer) g.aAh().azQ().get(40, (Object) null);
        if (num == null) {
            AppMethodBeat.o(42798);
            return 0;
        }
        int intValue = num.intValue();
        AppMethodBeat.o(42798);
        return intValue;
    }

    public static int aUf() {
        AppMethodBeat.i(42799);
        g.aAi();
        Integer num = (Integer) g.aAh().azQ().get(339975, (Object) null);
        if (num == null) {
            AppMethodBeat.o(42799);
            return 0;
        }
        int intValue = num.intValue();
        AppMethodBeat.o(42799);
        return intValue;
    }

    public static String aUg() {
        AppMethodBeat.i(163507);
        g.aAi();
        String obj = g.aAh().azQ().get(ar.a.USERINFO_MY_FINDER_USERNAME_STRING_SYNC, "").toString();
        AppMethodBeat.o(163507);
        return obj;
    }

    public static void rO(int i2) {
        AppMethodBeat.i(225914);
        Log.printInfoStack("MicroMsg.ConfigStorageLogic", "[setAuthDeviceFlag] flag=%s", Integer.valueOf(i2));
        iCB = i2;
        AppMethodBeat.o(225914);
    }

    public static boolean In(String str) {
        AppMethodBeat.i(225915);
        boolean equals = aUg().equals(str);
        AppMethodBeat.o(225915);
        return equals;
    }

    public static boolean aqE() {
        AppMethodBeat.i(225916);
        boolean rP = rP(aUe());
        AppMethodBeat.o(225916);
        return rP;
    }

    public static boolean rP(int i2) {
        return (i2 & 8192) != 0;
    }

    public static boolean aUi() {
        AppMethodBeat.i(42800);
        if ((aUe() & 16384) != 0) {
            AppMethodBeat.o(42800);
            return true;
        }
        AppMethodBeat.o(42800);
        return false;
    }

    public static boolean aUj() {
        AppMethodBeat.i(42801);
        if ((aUe() & 32768) != 0) {
            AppMethodBeat.o(42801);
            return true;
        }
        AppMethodBeat.o(42801);
        return false;
    }

    public static void aUk() {
        AppMethodBeat.i(42802);
        g.aAi();
        g.aAh().azQ().set(40, Integer.valueOf(aUe() | 32768));
        AppMethodBeat.o(42802);
    }

    public static int aUl() {
        AppMethodBeat.i(42803);
        g.aAi();
        Integer num = (Integer) g.aAh().azQ().get(34, (Object) null);
        if (num == null) {
            AppMethodBeat.o(42803);
            return 0;
        }
        int intValue = num.intValue();
        AppMethodBeat.o(42803);
        return intValue;
    }

    public static boolean aUm() {
        AppMethodBeat.i(42804);
        if ((aUc() & 64) != 0) {
            AppMethodBeat.o(42804);
            return true;
        }
        AppMethodBeat.o(42804);
        return false;
    }

    public static boolean aUn() {
        boolean z;
        AppMethodBeat.i(42805);
        if ((aUc() & TPMediaCodecProfileLevel.HEVCMainTierLevel52) != 0) {
            z = true;
        } else {
            z = false;
        }
        Log.i("MicroMsg.ConfigStorageLogic", "isGooglePay: %s  User Status: %d", Boolean.valueOf(z), Integer.valueOf(aUc()));
        AppMethodBeat.o(42805);
        return z;
    }

    public static boolean aUo() {
        AppMethodBeat.i(42806);
        g.aAi();
        g.aAh().azQ().gBI();
        if (aUf() == 1) {
            AppMethodBeat.o(42806);
            return true;
        }
        AppMethodBeat.o(42806);
        return false;
    }

    public static boolean aUp() {
        AppMethodBeat.i(42807);
        g.aAi();
        g.aAh().azQ().gBI();
        if (aUf() == 2) {
            AppMethodBeat.o(42807);
            return true;
        }
        AppMethodBeat.o(42807);
        return false;
    }

    public static boolean aUq() {
        AppMethodBeat.i(42808);
        g.aAi();
        g.aAh().azQ().gBI();
        if (aUf() == 4) {
            AppMethodBeat.o(42808);
            return true;
        }
        AppMethodBeat.o(42808);
        return false;
    }

    public static boolean aUr() {
        AppMethodBeat.i(225917);
        if (aUf() == 0) {
            AppMethodBeat.o(225917);
            return true;
        }
        AppMethodBeat.o(225917);
        return false;
    }

    public static boolean aUs() {
        AppMethodBeat.i(225918);
        g.aAi();
        int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, (Object) -1)).intValue();
        Log.i("MicroMsg.ConfigStorageLogic", "isCNPayWalletRegion() walletRegion:%s", Integer.valueOf(intValue));
        if (intValue == 0 || intValue == 1) {
            AppMethodBeat.o(225918);
            return true;
        }
        AppMethodBeat.o(225918);
        return false;
    }

    public static boolean aUt() {
        AppMethodBeat.i(42809);
        if ((aUl() & 32) == 0) {
            AppMethodBeat.o(42809);
            return true;
        }
        AppMethodBeat.o(42809);
        return false;
    }

    public static boolean aUu() {
        AppMethodBeat.i(42810);
        if ((aUc() & 4096) != 0) {
            AppMethodBeat.o(42810);
            return true;
        }
        AppMethodBeat.o(42810);
        return false;
    }

    public static boolean aUv() {
        AppMethodBeat.i(42811);
        ci aEY = ((l) g.af(l.class)).aSW().aEY("@t.qq.com");
        if (aEY == null || !aEY.isEnable()) {
            AppMethodBeat.o(42811);
            return false;
        }
        AppMethodBeat.o(42811);
        return true;
    }

    public static boolean aUw() {
        AppMethodBeat.i(42812);
        if ((aUl() & 2) == 0) {
            AppMethodBeat.o(42812);
            return true;
        }
        AppMethodBeat.o(42812);
        return false;
    }

    public static boolean aUx() {
        AppMethodBeat.i(42813);
        if ((aUl() & 16) == 0) {
            AppMethodBeat.o(42813);
            return true;
        }
        AppMethodBeat.o(42813);
        return false;
    }

    public static boolean aUy() {
        AppMethodBeat.i(42814);
        if ((aUl() & 128) == 0) {
            AppMethodBeat.o(42814);
            return true;
        }
        AppMethodBeat.o(42814);
        return false;
    }

    public static boolean aUz() {
        AppMethodBeat.i(225919);
        g.aAi();
        boolean nullAsFalse = Util.nullAsFalse((Boolean) g.aAh().azQ().get(8200, (Object) null));
        AppMethodBeat.o(225919);
        return nullAsFalse;
    }

    public static boolean aUA() {
        AppMethodBeat.i(42815);
        if ((aUl() & 524288) == 0) {
            AppMethodBeat.o(42815);
            return true;
        }
        AppMethodBeat.o(42815);
        return false;
    }

    public static boolean aUB() {
        AppMethodBeat.i(42816);
        if ((aUl() & TPMediaCodecProfileLevel.HEVCMainTierLevel52) == 0) {
            AppMethodBeat.o(42816);
            return true;
        }
        AppMethodBeat.o(42816);
        return false;
    }

    public static boolean aUC() {
        AppMethodBeat.i(42817);
        if ((aUl() & 8192) == 0) {
            AppMethodBeat.o(42817);
            return true;
        }
        AppMethodBeat.o(42817);
        return false;
    }

    public static boolean aUD() {
        AppMethodBeat.i(42818);
        if ((aUl() & 65536) == 0) {
            AppMethodBeat.o(42818);
            return true;
        }
        AppMethodBeat.o(42818);
        return false;
    }

    public static boolean aUE() {
        AppMethodBeat.i(42819);
        if ((aUl() & 134217728) == 0) {
            AppMethodBeat.o(42819);
            return true;
        }
        AppMethodBeat.o(42819);
        return false;
    }

    public static boolean aUF() {
        AppMethodBeat.i(42820);
        g.aAi();
        String str = (String) g.aAh().azQ().get(65825, (Object) null);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(42820);
            return false;
        } else if (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            AppMethodBeat.o(42820);
            return false;
        } else {
            try {
                if (Util.nullAsNil(Long.valueOf(Util.getLong(str, 0))) == 0) {
                    AppMethodBeat.o(42820);
                    return false;
                }
                AppMethodBeat.o(42820);
                return true;
            } catch (Exception e2) {
                AppMethodBeat.o(42820);
                return false;
            }
        }
    }

    public static boolean aUG() {
        AppMethodBeat.i(225920);
        g.aAi();
        if (Util.nullAsNil((Integer) g.aAh().azQ().get(17, (Object) null)) == 1) {
            AppMethodBeat.o(225920);
            return true;
        }
        AppMethodBeat.o(225920);
        return false;
    }

    public static boolean aUH() {
        AppMethodBeat.i(42821);
        if ((aUl() & 1) == 0) {
            AppMethodBeat.o(42821);
            return true;
        }
        AppMethodBeat.o(42821);
        return false;
    }

    public static boolean aUI() {
        AppMethodBeat.i(42822);
        if ((aUc() & 131072) == 0) {
            AppMethodBeat.o(42822);
            return true;
        }
        AppMethodBeat.o(42822);
        return false;
    }

    public static int aUJ() {
        AppMethodBeat.i(225921);
        g.aAi();
        int nullAs = Util.nullAs((Integer) g.aAh().azQ().get(8201, (Object) null), 22);
        AppMethodBeat.o(225921);
        return nullAs;
    }

    public static int aUK() {
        AppMethodBeat.i(225922);
        g.aAi();
        int nullAs = Util.nullAs((Integer) g.aAh().azQ().get(8208, (Object) null), 8);
        AppMethodBeat.o(225922);
        return nullAs;
    }

    public static as aUL() {
        AppMethodBeat.i(42823);
        as Kn = ((l) g.af(l.class)).aSN().Kn(aTY());
        if (Kn == null || ((int) Kn.gMZ) <= 0) {
            as asVar = new as();
            g.aAi();
            String str = (String) g.aAh().azQ().get(2, (Object) null);
            g.aAi();
            asVar.setUsername(str);
            asVar.setNickname((String) g.aAh().azQ().get(4, (Object) null));
            ((l) g.af(l.class)).aSN().ap(asVar);
            as Kn2 = ((l) g.af(l.class)).aSN().Kn(str);
            AppMethodBeat.o(42823);
            return Kn2;
        }
        AppMethodBeat.o(42823);
        return Kn;
    }

    public static k.b Io(String str) {
        AppMethodBeat.i(225923);
        com.tencent.mm.ba.k kVar = new com.tencent.mm.ba.k(str);
        ((l) g.af(l.class)).aSM().d(kVar);
        AppMethodBeat.o(225923);
        return kVar;
    }

    public static boolean aUM() {
        AppMethodBeat.i(42825);
        g.aAi();
        if (new p(Util.nullAsNil((Integer) g.aAh().azQ().get(9, (Object) null))).longValue() != 0) {
            AppMethodBeat.o(42825);
            return true;
        }
        AppMethodBeat.o(42825);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ad  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean f(java.lang.String r8, java.lang.String r9, boolean r10) {
        /*
        // Method dump skipped, instructions count: 299
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.model.z.f(java.lang.String, java.lang.String, boolean):boolean");
    }

    public static void aH(String str, String str2) {
        AppMethodBeat.i(225924);
        HashMap hashMap = new HashMap();
        z(hashMap);
        hashMap.put(str, str2);
        y(hashMap);
        AppMethodBeat.o(225924);
    }

    public static String Ip(String str) {
        AppMethodBeat.i(225925);
        HashMap hashMap = new HashMap();
        z(hashMap);
        if (hashMap.containsKey(str)) {
            String str2 = (String) hashMap.get(str);
            AppMethodBeat.o(225925);
            return str2;
        }
        AppMethodBeat.o(225925);
        return null;
    }

    private static void y(Map<String, String> map) {
        AppMethodBeat.i(42827);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(String.format(Locale.US, "%s\n%s\n", entry.getKey(), entry.getValue()));
        }
        g.aAi();
        if (g.aAh() != null) {
            g.aAi();
            if (g.aAh().azQ() != null) {
                g.aAi();
                g.aAh().azQ().set(327682, sb.toString());
            }
        }
        AppMethodBeat.o(42827);
    }

    private static void z(Map<String, String> map) {
        AppMethodBeat.i(42828);
        map.clear();
        g.aAi();
        if (g.aAh() != null) {
            g.aAi();
            if (g.aAh().azQ() != null) {
                g.aAi();
                String str = (String) g.aAh().azQ().get(327682, (Object) null);
                if (str == null) {
                    AppMethodBeat.o(42828);
                    return;
                }
                String[] split = str.split("\n");
                if (split.length % 2 != 0) {
                    Log.e("MicroMsg.ConfigStorageLogic", "key and value not match, len: " + String.valueOf(split.length));
                    AppMethodBeat.o(42828);
                    return;
                }
                for (int i2 = 0; i2 < split.length; i2 += 2) {
                    map.put(split[i2], split[i2 + 1]);
                }
                AppMethodBeat.o(42828);
                return;
            }
        }
        Log.d("MicroMsg.ConfigStorageLogic", "acc stg is null");
        AppMethodBeat.o(42828);
    }

    public static void aUN() {
        AppMethodBeat.i(225926);
        g.aAi();
        g.aAh().azQ().set(348167, (Object) 1);
        AppMethodBeat.o(225926);
    }

    public static void aUO() {
        AppMethodBeat.i(225927);
        g.aAi();
        g.aAh().azQ().set(348169, (Object) 1);
        AppMethodBeat.o(225927);
    }

    public static int aUP() {
        AppMethodBeat.i(225928);
        g.aAi();
        int intValue = ((Integer) g.aAh().azQ().get(348169, (Object) 0)).intValue();
        AppMethodBeat.o(225928);
        return intValue;
    }

    public static Boolean aUQ() {
        String str;
        AppMethodBeat.i(42829);
        if (!g.aAc()) {
            Log.e("MicroMsg.ConfigStorageLogic", "mmcore has not ready");
            Boolean bool = Boolean.FALSE;
            AppMethodBeat.o(42829);
            return bool;
        }
        g.aAi();
        String str2 = (String) g.aAh().azQ().get(6, (Object) null);
        g.aAi();
        if (!Util.nullAsFalse((Boolean) g.aAh().azQ().get(340241, (Object) null)) || Util.isNullOrNil(str2)) {
            Boolean bool2 = Boolean.FALSE;
            AppMethodBeat.o(42829);
            return bool2;
        }
        if (str2.startsWith("+")) {
            str = PhoneFormater.extractCountryCode(str2);
        } else {
            str = "86";
        }
        if (str == "86") {
            Boolean bool3 = Boolean.FALSE;
            AppMethodBeat.o(42829);
            return bool3;
        }
        Boolean bool4 = Boolean.TRUE;
        AppMethodBeat.o(42829);
        return bool4;
    }

    public static void aUR() {
        AppMethodBeat.i(225929);
        g.aAi();
        g.aAh().azQ().set(40, Integer.valueOf(aUe() & -32769));
        AppMethodBeat.o(225929);
    }

    public static Map<String, String> aUS() {
        AppMethodBeat.i(42830);
        HashMap hashMap = new HashMap();
        hashMap.put(WXUtil.LAST_LOGIN_WEXIN_USERNAME, aTY());
        g.aAi();
        hashMap.put(WXUtil.LAST_LOGIN_USERNAME, (String) g.aAh().azQ().get(ar.a.USERINFO_LAST_LOGIN_USERNAME_STRING, (Object) null));
        g.aAi();
        hashMap.put("last_avatar_path", (String) g.aAh().azQ().get(ar.a.USERINFO_LAST_LOGIN_AVATAR_PATH_STRING, (Object) null));
        g.aAi();
        hashMap.put("last_login_bind_mobile", (String) g.aAh().azQ().get(6, (Object) null));
        g.aAi();
        hashMap.put("last_login_bind_email", (String) g.aAh().azQ().get(5, (Object) null));
        g.aAi();
        hashMap.put("last_login_bind_qq", String.valueOf(g.aAh().azQ().get(9, (Object) null)));
        g.aAi();
        hashMap.put("last_login_use_voice", String.valueOf(g.aAh().azQ().get(40, (Object) null)));
        hashMap.put("last_bind_info", bf.iDu.aA("last_bind_info", ""));
        AppMethodBeat.o(42830);
        return hashMap;
    }

    public static int aUT() {
        AppMethodBeat.i(178863);
        int i2 = ((a) g.af(a.class)).aqJ().getInt("AssociateChatRoomDisableFuncFlag", 31);
        AppMethodBeat.o(178863);
        return i2;
    }

    public static boolean aUh() {
        char c2 = 65535;
        int i2 = iCB;
        if (-1 != i2) {
            if ((i2 & 1) != 0) {
                c2 = 0;
            } else {
                c2 = 1;
            }
        }
        return c2 == 0;
    }
}
