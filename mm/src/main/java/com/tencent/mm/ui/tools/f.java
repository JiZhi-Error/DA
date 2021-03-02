package com.tencent.mm.ui.tools;

import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class f implements InputFilter {
    private int otr;
    private a ots;

    public enum a {
        MODE_CHINESE_AS_1,
        MODE_CHINESE_AS_2;

        public static a valueOf(String str) {
            AppMethodBeat.i(133831);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(133831);
            return aVar;
        }

        static {
            AppMethodBeat.i(133832);
            AppMethodBeat.o(133832);
        }
    }

    public f(int i2, a aVar) {
        this.otr = i2;
        this.ots = aVar;
    }

    public CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
        AppMethodBeat.i(133833);
        if (a(spanned.toString(), this.ots) + a(charSequence.toString(), this.ots) > this.otr) {
            AppMethodBeat.o(133833);
            return "";
        }
        AppMethodBeat.o(133833);
        return charSequence;
    }

    public static int a(String str, a aVar) {
        AppMethodBeat.i(133834);
        if (aVar == a.MODE_CHINESE_AS_1) {
            int bnQ = bnQ(str);
            AppMethodBeat.o(133834);
            return bnQ;
        } else if (aVar == a.MODE_CHINESE_AS_2) {
            int bnP = bnP(str);
            AppMethodBeat.o(133834);
            return bnP;
        } else {
            AppMethodBeat.o(133834);
            return 0;
        }
    }

    public static int bnP(String str) {
        AppMethodBeat.i(133835);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(133835);
            return 0;
        }
        int length = str.length() + bnR(str) + bnS(str);
        AppMethodBeat.o(133835);
        return length;
    }

    private static int bnQ(String str) {
        AppMethodBeat.i(133836);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(133836);
            return 0;
        }
        int length = str.length();
        AppMethodBeat.o(133836);
        return length;
    }

    public static int bnR(String str) {
        AppMethodBeat.i(133837);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(133837);
            return 0;
        }
        Matcher matcher = Pattern.compile("[\\u4e00-\\u9fa5]").matcher(str);
        int i2 = 0;
        while (matcher.find()) {
            for (int i3 = 0; i3 <= matcher.groupCount(); i3++) {
                i2++;
            }
        }
        AppMethodBeat.o(133837);
        return i2;
    }

    private static int bnS(String str) {
        int i2 = 0;
        AppMethodBeat.i(133838);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(133838);
            return 0;
        }
        int i3 = 0;
        while (true) {
            int i4 = i2;
            if (i3 < str.length()) {
                char charAt = str.charAt(i3);
                if (charAt >= 0 && charAt <= 127) {
                    i4++;
                }
                i2 = i4;
                i3++;
            } else {
                int length = str.length() - (bnR(str) + i4);
                AppMethodBeat.o(133838);
                return length;
            }
        }
    }

    public static String hm(String str, int i2) {
        AppMethodBeat.i(196233);
        int i3 = 0;
        for (int i4 = 0; i4 < str.length(); i4++) {
            i3 += str.charAt(i4) > 127 ? 2 : 1;
            if (i3 > i2) {
                String substring = str.substring(0, i4);
                AppMethodBeat.o(196233);
                return substring;
            }
        }
        AppMethodBeat.o(196233);
        return str;
    }

    public static int dp(int i2, String str) {
        AppMethodBeat.i(133839);
        if (LocaleUtil.isChineseAppLang()) {
            int bnP = i2 - bnP(str);
            AppMethodBeat.o(133839);
            return bnP;
        }
        int bnP2 = i2 - bnP(str);
        AppMethodBeat.o(133839);
        return bnP2;
    }

    public static int dq(int i2, String str) {
        AppMethodBeat.i(133840);
        if (LocaleUtil.isChineseAppLang()) {
            int round = Math.round(((float) (Math.round((float) bnP(str)) - i2)) / 2.0f);
            AppMethodBeat.o(133840);
            return round;
        }
        int bnP = bnP(str) - i2;
        AppMethodBeat.o(133840);
        return bnP;
    }
}
