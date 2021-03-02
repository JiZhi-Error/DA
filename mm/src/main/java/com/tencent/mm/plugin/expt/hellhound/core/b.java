package com.tencent.mm.plugin.expt.hellhound.core;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c;
import com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e;
import com.tencent.mm.plugin.expt.hellhound.core.b.b.h;
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.protocal.protobuf.cyh;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vending.j.d;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.List;
import java.util.regex.Pattern;

public final class b {
    public static String syW = "com.tencent.mm.ui.conversation.MainUI";
    public static String syX = "com.tencent.mm.ui.contact.AddressUI.AddressUIFragment";
    public static String syY = "com.tencent.mm.ui.FindMoreFriendsUI";
    public static String syZ = "com.tencent.mm.ui.MoreTabUI";
    public static String sza = "com.tencent.mm.ui.chatting.ChattingUIFragment";
    public static String szb = "MainUI";
    public static String szc = "AddressUIFragment";
    public static String szd = "FindMoreFriendsUI";
    public static String sze = "MoreTabUI";
    public static String szf = "ChattingUIFragment";

    public static boolean aoy(String str) {
        AppMethodBeat.i(169258);
        boolean equals = "com.tencent.mm.ui.chatting.ChattingUI".equals(str);
        AppMethodBeat.o(169258);
        return equals;
    }

    public static boolean aoz(String str) {
        AppMethodBeat.i(169259);
        boolean equals = "com.tencent.mm.ui.LauncherUI".equals(str);
        AppMethodBeat.o(169259);
        return equals;
    }

    public static boolean aoA(String str) {
        AppMethodBeat.i(169260);
        boolean equals = "com.tencent.mm.ui.contact.GroupCardSelectUI".equals(str);
        AppMethodBeat.o(169260);
        return equals;
    }

    public static boolean aoB(String str) {
        AppMethodBeat.i(169261);
        boolean equals = "com.tencent.mm.ui.contact.SelectContactUI".equals(str);
        AppMethodBeat.o(169261);
        return equals;
    }

    public static boolean aoC(String str) {
        AppMethodBeat.i(169262);
        boolean equals = "com.tencent.mm.app.WeChatSplashActivity".equals(str);
        AppMethodBeat.o(169262);
        return equals;
    }

    public static boolean aoD(String str) {
        AppMethodBeat.i(169263);
        if (str == null || !str.startsWith("com.tencent.mm.splash.")) {
            AppMethodBeat.o(169263);
            return false;
        }
        AppMethodBeat.o(169263);
        return true;
    }

    public static boolean isMMProcess() {
        AppMethodBeat.i(121845);
        Context context = MMApplicationContext.getContext();
        String str = g.aAe().azG().mProcessName;
        if (str == null) {
            AppMethodBeat.o(121845);
            return false;
        }
        boolean equals = context.getPackageName().equals(str);
        AppMethodBeat.o(121845);
        return equals;
    }

    public static String aoE(String str) {
        AppMethodBeat.i(121846);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(121846);
            return null;
        }
        String replace = str.replace(FilePathGenerator.ANDROID_DIR_SEP, ".");
        int lastIndexOf = replace.lastIndexOf(".");
        if (lastIndexOf < 0 || lastIndexOf >= replace.length() - 1) {
            AppMethodBeat.o(121846);
            return replace;
        }
        String substring = replace.substring(lastIndexOf + 1);
        AppMethodBeat.o(121846);
        return substring;
    }

    public static String cNy() {
        AppMethodBeat.i(121847);
        d<String, Boolean, String> GS = e.GS(106);
        if (GS == null) {
            String cNW = c.cNY().szQ.cNW();
            Log.i("HABBYGE-MALI.HellhoundUtil", "FuzzyMatch._getPrePage by activityJumpSrc: %s", cNW);
            if (cNW != null) {
                AppMethodBeat.o(121847);
                return cNW;
            }
            String cOi = com.tencent.mm.plugin.expt.hellhound.core.b.b.d.cOi();
            AppMethodBeat.o(121847);
            return cOi;
        }
        Log.i("HABBYGE-MALI.HellhoundUtil", "FuzzyMatch._getPrePage by key_pause: %s, %b, %s", GS.get(0), GS.get(1), GS.get(2));
        if (((Boolean) GS.get(1)).booleanValue()) {
            String str = (String) GS.get(2);
            if (str != null) {
                AppMethodBeat.o(121847);
                return str;
            }
            String cOi2 = com.tencent.mm.plugin.expt.hellhound.core.b.b.d.cOi();
            AppMethodBeat.o(121847);
            return cOi2;
        }
        String str2 = (String) GS.get(0);
        if (str2 != null) {
            AppMethodBeat.o(121847);
            return str2;
        }
        String cOi3 = com.tencent.mm.plugin.expt.hellhound.core.b.b.d.cOi();
        AppMethodBeat.o(121847);
        return cOi3;
    }

    public static Pair<String, Integer> cNz() {
        AppMethodBeat.i(220400);
        cyh cQr = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQr();
        if (cQr == null) {
            d<String, Boolean, String> GS = e.GS(105);
            if (GS == null) {
                AppMethodBeat.o(220400);
                return null;
            } else if (((Boolean) GS.get(1)).booleanValue()) {
                Pair<String, Integer> create = Pair.create(GS.get(2), 0);
                AppMethodBeat.o(220400);
                return create;
            } else {
                Pair<String, Integer> create2 = Pair.create(GS.get(0), 0);
                AppMethodBeat.o(220400);
                return create2;
            }
        } else {
            Pair<String, Integer> create3 = Pair.create(cQr.dMl, Integer.valueOf(cQr.aHK));
            AppMethodBeat.o(220400);
            return create3;
        }
    }

    public static cbm aoF(String str) {
        AppMethodBeat.i(220401);
        List<cbm> aqQ = com.tencent.mm.plugin.expt.hellhound.a.f.d.b.aqQ(str);
        if (aqQ == null || aqQ.isEmpty()) {
            AppMethodBeat.o(220401);
            return null;
        }
        cbm cbm = aqQ.get(aqQ.size() - 1);
        AppMethodBeat.o(220401);
        return cbm;
    }

    public static boolean aoG(String str) {
        AppMethodBeat.i(169264);
        boolean equals = "com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI".equals(str);
        AppMethodBeat.o(169264);
        return equals;
    }

    public static boolean aoH(String str) {
        AppMethodBeat.i(169265);
        boolean equals = "com.tencent.mm.plugin.account.ui.LoginPasswordUI".equals(str);
        AppMethodBeat.o(169265);
        return equals;
    }

    public static boolean aoI(String str) {
        AppMethodBeat.i(121850);
        boolean matches = Pattern.matches("^(" + "com.tencent.mm.plugin.appbrand.ui.AppBrandUI" + ")[0-9]*$", str);
        AppMethodBeat.o(121850);
        return matches;
    }

    public static boolean aoJ(String str) {
        AppMethodBeat.i(121851);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(121851);
            return false;
        }
        boolean matches = Pattern.matches("^(" + "AppBrandUI" + ")[0-9]*$", str);
        AppMethodBeat.o(121851);
        return matches;
    }

    public static boolean aoK(String str) {
        AppMethodBeat.i(121852);
        boolean equals = "AppBrandLauncherUI".equals(aoE(str));
        AppMethodBeat.o(121852);
        return equals;
    }

    public static boolean aoL(String str) {
        AppMethodBeat.i(169266);
        boolean equals = "com.tencent.mm.plugin.base.stub.WXShortcutEntryActivity".equals(str);
        AppMethodBeat.o(169266);
        return equals;
    }

    public static boolean aoM(String str) {
        AppMethodBeat.i(169267);
        boolean equals = "com.tencent.mm.plugin.base.stub.WXEntryActivity".equals(str);
        AppMethodBeat.o(169267);
        return equals;
    }

    public static boolean aoN(String str) {
        AppMethodBeat.i(169268);
        boolean equals = "com.tencent.mm.plugin.setting.ui.setting.FakeSwitchAccountUI".equals(str);
        AppMethodBeat.o(169268);
        return equals;
    }

    public static boolean aoO(String str) {
        AppMethodBeat.i(169269);
        boolean equals = "com.tencent.mm.plugin.voip.ui.VideoActivity".equals(str);
        AppMethodBeat.o(169269);
        return equals;
    }

    public static boolean aoP(String str) {
        AppMethodBeat.i(169270);
        boolean equals = "com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity".equals(str);
        AppMethodBeat.o(169270);
        return equals;
    }

    public static FragmentActivity cNA() {
        AppMethodBeat.i(121853);
        try {
            Method declaredMethod = Class.forName("com.tencent.mm.ui.LauncherUI").getDeclaredMethod("getInstance", new Class[0]);
            declaredMethod.setAccessible(true);
            FragmentActivity fragmentActivity = (FragmentActivity) declaredMethod.invoke(null, new Object[0]);
            AppMethodBeat.o(121853);
            return fragmentActivity;
        } catch (Exception e2) {
            AppMethodBeat.o(121853);
            return null;
        }
    }

    public static Fragment aoQ(String str) {
        AppMethodBeat.i(121854);
        List<Fragment> c2 = h.c(cNA());
        if (c2 != null) {
            for (Fragment fragment : c2) {
                if (fragment != null && fragment.getClass().getSimpleName().equals(str)) {
                    AppMethodBeat.o(121854);
                    return fragment;
                }
            }
        }
        AppMethodBeat.o(121854);
        return null;
    }

    public static int getUin() {
        AppMethodBeat.i(121855);
        com.tencent.mm.plugin.expt.h.d.cRY();
        int uin = com.tencent.mm.plugin.expt.h.d.getUin();
        if (uin == 0) {
            AppMethodBeat.o(121855);
            return 0;
        }
        AppMethodBeat.o(121855);
        return uin;
    }

    public static boolean aoR(String str) {
        AppMethodBeat.i(169271);
        boolean equals = "com.tencent.mm.plugin.scanner.ui.BaseScanUI".equals(str);
        AppMethodBeat.o(169271);
        return equals;
    }

    public static boolean isNumeric(String str) {
        AppMethodBeat.i(121856);
        if (str == null || "".equals(str.trim()) || !str.matches("^[0-9]*$")) {
            AppMethodBeat.o(121856);
            return false;
        }
        AppMethodBeat.o(121856);
        return true;
    }

    public static String zs(long j2) {
        AppMethodBeat.i(169272);
        String bigInteger = new BigInteger(Long.toBinaryString(j2), 2).toString();
        AppMethodBeat.o(169272);
        return bigInteger;
    }

    public static boolean aoS(String str) {
        AppMethodBeat.i(220402);
        if (str == null) {
            AppMethodBeat.o(220402);
            return false;
        } else if (str.contains(".")) {
            if (syW.equals(str) || syX.equals(str) || syY.equals(str) || syZ.equals(str) || sza.equals(str)) {
                AppMethodBeat.o(220402);
                return true;
            }
            AppMethodBeat.o(220402);
            return false;
        } else if (szb.equals(str) || szc.equals(str) || szd.equals(str) || sze.equals(str) || szf.equals(str)) {
            AppMethodBeat.o(220402);
            return true;
        } else {
            AppMethodBeat.o(220402);
            return false;
        }
    }

    public static boolean aoT(String str) {
        AppMethodBeat.i(177356);
        if (str == null) {
            AppMethodBeat.o(177356);
            return false;
        } else if (str.contains(".")) {
            if (syW.equals(str) || syX.equals(str) || syY.equals(str) || syZ.equals(str)) {
                AppMethodBeat.o(177356);
                return true;
            }
            AppMethodBeat.o(177356);
            return false;
        } else if (szb.equals(str) || szc.equals(str) || szd.equals(str) || sze.equals(str)) {
            AppMethodBeat.o(177356);
            return true;
        } else {
            AppMethodBeat.o(177356);
            return false;
        }
    }

    public static String toHexString(int i2) {
        AppMethodBeat.i(220403);
        if (i2 == -1) {
            AppMethodBeat.o(220403);
            return "-1";
        }
        String str = "0x" + Integer.toHexString(i2);
        AppMethodBeat.o(220403);
        return str;
    }

    public static int u(Activity activity) {
        ActionBar supportActionBar;
        int i2 = 0;
        AppMethodBeat.i(220404);
        if (activity == null) {
            AppMethodBeat.o(220404);
        } else {
            try {
                if ((activity instanceof AppCompatActivity) && (supportActionBar = ((AppCompatActivity) activity).getSupportActionBar()) != null) {
                    i2 = supportActionBar.getCustomView().getHeight();
                    AppMethodBeat.o(220404);
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("HABBYGE-MALI.HellhoundUtil", e2, "initBarHeight", new Object[0]);
            }
            AppMethodBeat.o(220404);
        }
        return i2;
    }

    public static float O(Activity activity) {
        AppMethodBeat.i(220405);
        if (activity == null) {
            AppMethodBeat.o(220405);
            return 0.0f;
        }
        Resources resources = activity.getResources();
        float dimensionPixelSize = (float) resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
        if (dimensionPixelSize <= 0.0f) {
            dimensionPixelSize = (float) resources.getDimensionPixelSize(R.dimen.a3n);
        }
        AppMethodBeat.o(220405);
        return dimensionPixelSize;
    }

    public static String aoU(String str) {
        AppMethodBeat.i(220406);
        if (str == null) {
            AppMethodBeat.o(220406);
            return null;
        }
        String replace = str.replace(",", ".");
        AppMethodBeat.o(220406);
        return replace;
    }

    public static Pair<Integer, Integer> dJ(View view) {
        AppMethodBeat.i(220407);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        Pair<Integer, Integer> create = Pair.create(Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
        AppMethodBeat.o(220407);
        return create;
    }

    public static Pair<Float, Float> dK(View view) {
        AppMethodBeat.i(220408);
        int measuredWidth = view.getMeasuredWidth();
        Pair<Float, Float> create = Pair.create(Float.valueOf(Math.max((float) measuredWidth, (float) view.getWidth())), Float.valueOf(Math.max((float) view.getMeasuredHeight(), (float) view.getHeight())));
        AppMethodBeat.o(220408);
        return create;
    }

    public static String cNB() {
        AppMethodBeat.i(220409);
        try {
            if (!g.aAc()) {
                AppMethodBeat.o(220409);
                return "";
            }
            String str = (String) g.aAh().azQ().get(ar.a.USERINFO_FINDER_ALL_CLICK_TAB_CONTEXT_ID_STRING, "");
            AppMethodBeat.o(220409);
            return str;
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.HellhoundUtil", e2, "getFinderCurTabContextId crash: %s", e2.getMessage());
            AppMethodBeat.o(220409);
            return "";
        }
    }

    public static void aoV(String str) {
        AppMethodBeat.i(220410);
        try {
            if (!g.aAc()) {
                AppMethodBeat.o(220410);
            } else if (TextUtils.isEmpty(str)) {
                AppMethodBeat.o(220410);
            } else {
                g.aAh().azQ().set(ar.a.USERINFO_FINDER_ALL_CLICK_TAB_CONTEXT_ID_STRING, str);
                AppMethodBeat.o(220410);
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.HellhoundUtil", e2, "setFinderCurTabContextId crash: %s", e2.getMessage());
            AppMethodBeat.o(220410);
        }
    }

    public static String cNC() {
        AppMethodBeat.i(220411);
        try {
            if (!g.aAc()) {
                AppMethodBeat.o(220411);
                return "";
            }
            String str = (String) g.aAh().azQ().get(ar.a.USERINFO_FINDER_TAB_CLICK_TAB_CONTEXT_ID_STRING, "");
            AppMethodBeat.o(220411);
            return str;
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.HellhoundUtil", e2, "getFinderReportTabContextId crash: %s", e2.getMessage());
            AppMethodBeat.o(220411);
            return "";
        }
    }

    public static String cND() {
        AppMethodBeat.i(220412);
        try {
            if (!g.aAc()) {
                AppMethodBeat.o(220412);
                return "";
            }
            String str = (String) g.aAh().azQ().get(ar.a.USERINFO_FINDER_CONTEXT_ID_STRING, "");
            AppMethodBeat.o(220412);
            return str;
        } catch (Exception e2) {
            AppMethodBeat.o(220412);
            return "";
        }
    }

    public static void aoW(String str) {
        AppMethodBeat.i(220413);
        try {
            if (!g.aAc()) {
                AppMethodBeat.o(220413);
            } else if (TextUtils.isEmpty(str)) {
                AppMethodBeat.o(220413);
            } else {
                g.aAh().azQ().set(ar.a.USERINFO_FINDER_CONTEXT_ID_STRING, str);
                AppMethodBeat.o(220413);
            }
        } catch (Exception e2) {
            AppMethodBeat.o(220413);
        }
    }

    public static String aoX(String str) {
        AppMethodBeat.i(220414);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(220414);
            return "";
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1817116115:
                if (str.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment")) {
                    c2 = 5;
                    break;
                }
                break;
            case -1010168201:
                if (str.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderLbsTabFragment")) {
                    c2 = 7;
                    break;
                }
                break;
            case -844087327:
                if (str.equals("FinderFriendTabFragment")) {
                    c2 = 2;
                    break;
                }
                break;
            case -464538386:
                if (str.equals("FinderFollowTabFragment")) {
                    c2 = 0;
                    break;
                }
                break;
            case 839202232:
                if (str.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderFriendTabFragment")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1218751173:
                if (str.equals("com.tencent.mm.plugin.finder.ui.fragment.FinderFollowTabFragment")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1271553262:
                if (str.equals("FinderLbsTabFragment")) {
                    c2 = 6;
                    break;
                }
                break;
            case 1835482404:
                if (str.equals("FinderMachineTabFragment")) {
                    c2 = 4;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
                AppMethodBeat.o(220414);
                return AppEventsConstants.EVENT_PARAM_VALUE_NO;
            case 2:
            case 3:
                AppMethodBeat.o(220414);
                return "1";
            case 4:
            case 5:
                AppMethodBeat.o(220414);
                return "2";
            case 6:
            case 7:
                AppMethodBeat.o(220414);
                return TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL;
            default:
                AppMethodBeat.o(220414);
                return str;
        }
    }

    public static String aoY(String str) {
        AppMethodBeat.i(220415);
        if (str == null) {
            AppMethodBeat.o(220415);
            return null;
        }
        String replace = str.replace(",", ".");
        AppMethodBeat.o(220415);
        return replace;
    }

    public static String cNE() {
        return a.ict == null ? a.REV : a.ict;
    }

    public static boolean aoZ(String str) {
        AppMethodBeat.i(220416);
        boolean isEqual = Util.isEqual(str, z.aUg());
        AppMethodBeat.o(220416);
        return isEqual;
    }
}
