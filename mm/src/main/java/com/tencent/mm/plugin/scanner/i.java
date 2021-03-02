package com.tencent.mm.plugin.scanner;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;
import java.util.List;

public final class i {
    public static boolean eOO() {
        AppMethodBeat.i(223713);
        if (((b) g.af(b.class)).a(b.a.clicfg_lib_word_detect_open, 1) == 1) {
            AppMethodBeat.o(223713);
            return true;
        }
        AppMethodBeat.o(223713);
        return false;
    }

    public static boolean eOP() {
        String[] split;
        AppMethodBeat.i(151578);
        if (!eOO()) {
            Log.i("MicroMsg.ScannerHelper", "Word Detect Closed");
            AppMethodBeat.o(151578);
            return false;
        }
        int i2 = ((a) g.af(a.class)).aqJ().getInt("EnableSnsPicTranslation", 0);
        String value = ((a) g.af(a.class)).aqJ().getValue("PicTranslationSupportUserLanguage");
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(i2 == 1);
        objArr[1] = value;
        objArr[2] = LocaleUtil.getApplicationLanguage();
        Log.i("MicroMsg.ScannerHelper", "enable %s, support lang %s, current lang %s", objArr);
        if (i2 == 1 && !Util.isNullOrNil(value) && (split = value.split(";")) != null && Arrays.asList(split).contains(LocaleUtil.getApplicationLanguage())) {
            AppMethodBeat.o(151578);
            return true;
        } else if (d.KyS) {
            AppMethodBeat.o(151578);
            return true;
        } else {
            AppMethodBeat.o(151578);
            return false;
        }
    }

    public static boolean eOQ() {
        String[] split;
        AppMethodBeat.i(151579);
        if (!eOO()) {
            Log.i("MicroMsg.ScannerHelper", "Word Detect Closed");
            AppMethodBeat.o(151579);
            return false;
        }
        int i2 = ((a) g.af(a.class)).aqJ().getInt("EnableFavPicTranslation", 0);
        String value = ((a) g.af(a.class)).aqJ().getValue("PicTranslationSupportUserLanguage");
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(i2 == 1);
        objArr[1] = value;
        objArr[2] = LocaleUtil.getApplicationLanguage();
        Log.i("MicroMsg.ScannerHelper", "enable %s, support lang %s, current lang %s", objArr);
        if (i2 == 1 && !Util.isNullOrNil(value) && (split = value.split(";")) != null && Arrays.asList(split).contains(LocaleUtil.getApplicationLanguage())) {
            AppMethodBeat.o(151579);
            return true;
        } else if (d.KyS) {
            AppMethodBeat.o(151579);
            return true;
        } else {
            AppMethodBeat.o(151579);
            return false;
        }
    }

    private static String Wq(int i2) {
        switch (i2) {
            case 1:
                return LocaleUtil.ENGLISH;
            case 2:
                return LocaleUtil.CHINA;
            case 3:
                return LocaleUtil.JAPANESE;
            case 4:
                return LocaleUtil.KOREAN;
            case 5:
                return LocaleUtil.RUSSIAN;
            case 6:
                return LocaleUtil.THAI;
            case 7:
                return LocaleUtil.VIETNAMESE;
            default:
                return "bg";
        }
    }

    public static int gw(List<Float> list) {
        int i2;
        int floatValue;
        AppMethodBeat.i(223714);
        if (list != null) {
            i2 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (!Wq(i3).equalsIgnoreCase("bg") && !Wq(i3).equalsIgnoreCase(LocaleUtil.getApplicationLanguage()) && (floatValue = (int) (list.get(i3).floatValue() * 100.0f)) > i2) {
                    i2 = floatValue;
                }
            }
        } else {
            i2 = 0;
        }
        AppMethodBeat.o(223714);
        return i2;
    }

    public static boolean gx(List<Float> list) {
        int i2;
        boolean z;
        AppMethodBeat.i(223715);
        if (list != null) {
            int i3 = 0;
            while (true) {
                if (i3 >= list.size()) {
                    break;
                } else if (Wq(i3).equalsIgnoreCase("bg")) {
                    i2 = (int) (list.get(i3).floatValue() * 100.0f);
                    break;
                } else {
                    i3++;
                }
            }
        }
        i2 = 0;
        Log.i("MicroMsg.ScannerHelper", "needShowOCRMenu transBgRatio: %s", Integer.valueOf(i2));
        if (i2 >= 99 || i2 <= 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            AppMethodBeat.o(223715);
            return true;
        }
        AppMethodBeat.o(223715);
        return false;
    }
}
