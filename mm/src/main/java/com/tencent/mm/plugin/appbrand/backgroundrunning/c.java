package com.tencent.mm.plugin.appbrand.backgroundrunning;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;

public enum c {
    kYp(2, R.string.j6),
    APPBRAND_VOIP(4, R.string.ja),
    AUDIO_OF_VIDEO_BACKGROUND_PLAY(8, R.string.j3),
    APPBRAND_VOIP_1v1(16, R.string.ja),
    kYt(65535, -1);
    
    public int beL;
    public int kYu;

    public static c valueOf(String str) {
        AppMethodBeat.i(44787);
        c cVar = (c) Enum.valueOf(c.class, str);
        AppMethodBeat.o(44787);
        return cVar;
    }

    static {
        AppMethodBeat.i(44790);
        AppMethodBeat.o(44790);
    }

    private c(int i2, int i3) {
        this.beL = i2;
        this.kYu = i3;
    }

    public static boolean contains(int i2, int i3) {
        return (i2 & i3) > 0;
    }

    public static int dQ(int i2, int i3) {
        return i2 | i3;
    }

    public static int dR(int i2, int i3) {
        return (i3 ^ -1) & i2;
    }

    public static String bm(List<AppBrandBackgroundRunningApp> list) {
        AppMethodBeat.i(44788);
        AppBrandBackgroundRunningApp appBrandBackgroundRunningApp = null;
        ArrayList arrayList = new ArrayList();
        for (AppBrandBackgroundRunningApp appBrandBackgroundRunningApp2 : list) {
            if (contains(appBrandBackgroundRunningApp2.beL, APPBRAND_VOIP.beL)) {
                if (appBrandBackgroundRunningApp2.beL != APPBRAND_VOIP.beL) {
                    arrayList.add(appBrandBackgroundRunningApp2);
                }
                appBrandBackgroundRunningApp = appBrandBackgroundRunningApp2;
            }
            if (!contains(appBrandBackgroundRunningApp2.beL, APPBRAND_VOIP_1v1.beL)) {
                arrayList.add(appBrandBackgroundRunningApp2);
            } else if (appBrandBackgroundRunningApp2.beL != APPBRAND_VOIP_1v1.beL) {
                arrayList.add(appBrandBackgroundRunningApp2);
                appBrandBackgroundRunningApp = appBrandBackgroundRunningApp2;
            } else {
                appBrandBackgroundRunningApp = appBrandBackgroundRunningApp2;
            }
        }
        if (appBrandBackgroundRunningApp != null) {
            String format = String.format("%s %s", String.format("%s %s", String.format(MMApplicationContext.getContext().getString(R.string.j8), appBrandBackgroundRunningApp.name), MMApplicationContext.getContext().getString(R.string.ja)), bn(arrayList));
            AppMethodBeat.o(44788);
            return format;
        }
        String bn = bn(arrayList);
        AppMethodBeat.o(44788);
        return bn;
    }

    private static String bn(List<AppBrandBackgroundRunningApp> list) {
        AppMethodBeat.i(226445);
        String str = "";
        if (!list.isEmpty()) {
            if (list.size() == 1) {
                str = String.format("%s %s", String.format(MMApplicationContext.getContext().getString(R.string.j8), list.get(0).name), MMApplicationContext.getContext().getString(R.string.j5));
            } else {
                str = String.format("%s %s", String.format(MMApplicationContext.getContext().getString(R.string.j7), Integer.valueOf(list.size())), MMApplicationContext.getContext().getString(R.string.j5));
            }
        }
        AppMethodBeat.o(226445);
        return str;
    }

    public static String bo(List<AppBrandBackgroundRunningApp> list) {
        AppMethodBeat.i(44789);
        int i2 = 0;
        for (AppBrandBackgroundRunningApp appBrandBackgroundRunningApp : list) {
            i2 = appBrandBackgroundRunningApp.beL | i2;
        }
        String str = null;
        c[] values = values();
        for (c cVar : values) {
            if (!(cVar.beL == kYt.beL || cVar.beL == APPBRAND_VOIP.beL || cVar.beL == APPBRAND_VOIP_1v1.beL || !contains(i2, cVar.beL))) {
                if (Util.isNullOrNil(str)) {
                    str = MMApplicationContext.getContext().getString(cVar.kYu);
                } else {
                    str = String.format("%s、%s", str, MMApplicationContext.getContext().getString(cVar.kYu));
                }
            }
        }
        AppMethodBeat.o(44789);
        return str;
    }
}
