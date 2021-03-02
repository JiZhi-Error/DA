package com.tencent.mm.plugin.appbrand.page.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public interface f {
    void a(a aVar, int i2);

    void adV(String str);

    void bSe();

    void bSf();

    void eE(String str, String str2);

    void ij(boolean z);

    void il(boolean z);

    void requestDisallowInterceptTouchEvent(boolean z);

    void setPullDownText(String str);

    public enum a {
        LIGHT,
        DARK,
        IGNORE;

        public static a valueOf(String str) {
            AppMethodBeat.i(135304);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(135304);
            return aVar;
        }

        static {
            AppMethodBeat.i(135307);
            AppMethodBeat.o(135307);
        }

        public final String bSC() {
            AppMethodBeat.i(259548);
            String lowerCase = name().toLowerCase();
            AppMethodBeat.o(259548);
            return lowerCase;
        }

        public static a az(String str, boolean z) {
            boolean equalsIgnoreCase;
            AppMethodBeat.i(219488);
            if (!TextUtils.isEmpty(str)) {
                a[] values = values();
                for (a aVar : values) {
                    String lowerCase = aVar.name().toLowerCase();
                    if (lowerCase != null) {
                        equalsIgnoreCase = lowerCase.equalsIgnoreCase(str);
                    } else if (str == null) {
                        equalsIgnoreCase = true;
                    } else {
                        equalsIgnoreCase = false;
                    }
                    if (equalsIgnoreCase) {
                        AppMethodBeat.o(219488);
                        return aVar;
                    }
                }
                Log.e("Luggage.AppBrandPageViewPullDownExtension.BackgroundTextStyle", "fromString(%s), unrecognized", str);
                if (z) {
                    a aVar2 = LIGHT;
                    AppMethodBeat.o(219488);
                    return aVar2;
                }
                a aVar3 = DARK;
                AppMethodBeat.o(219488);
                return aVar3;
            } else if (z) {
                a aVar4 = LIGHT;
                AppMethodBeat.o(219488);
                return aVar4;
            } else {
                a aVar5 = DARK;
                AppMethodBeat.o(219488);
                return aVar5;
            }
        }
    }
}
