package com.tencent.mm.plugin.flutter.c;

import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/flutter/lite/WxaLiteAppCrashReportHandler;", "", "()V", "TAG", "", "handleCrash", "", "crashInfoMap", "", "killSelf", "", "plugin-flutter_release"})
public final class a {
    private static final String TAG = TAG;
    public static final a wJq = new a();

    static {
        AppMethodBeat.i(240993);
        AppMethodBeat.o(240993);
    }

    private a() {
    }

    public static void b(Map<String, ? extends Object> map, boolean z) {
        MultiProcessMMKV multiDefault;
        String string;
        String str;
        AppMethodBeat.i(240992);
        p.h(map, "crashInfoMap");
        Map map2 = (Map) map.get("customParameters");
        if (map2 == null) {
            p.hyc();
        }
        if (map2.containsKey("WxaLiteApp") && (string = (multiDefault = MultiProcessMMKV.getMultiDefault()).getString("wxa_lite_app_game_center_version", "")) != null) {
            if (z) {
                int i2 = multiDefault.getInt("count_".concat(String.valueOf(string)), 0);
                long j2 = multiDefault.getLong("time_".concat(String.valueOf(string)), 0);
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - j2 > Util.MILLSECONDS_OF_HOUR) {
                    multiDefault.putInt("count_".concat(String.valueOf(string)), 1);
                } else {
                    multiDefault.putInt("count_".concat(String.valueOf(string)), i2 + 1);
                }
                multiDefault.putLong("time_".concat(String.valueOf(string)), currentTimeMillis);
                Log.i(TAG, "WxaLiteApp handle crash. version:%s count%d time:%s now:%s", string, Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(currentTimeMillis));
                multiDefault.commit();
            } else {
                Log.i(TAG, "WxaLiteApp handle state error . version:%s", string);
            }
            Object obj = map.get("error");
            if (obj == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(240992);
                throw tVar;
            }
            String str2 = (String) obj;
            if (str2.length() < 10) {
                str = str2;
            } else if (str2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(240992);
                throw tVar2;
            } else {
                String substring = str2.substring(0, 10);
                p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                str = substring;
            }
            if (z) {
                h.INSTANCE.n(1293, 103, 1);
            } else {
                h.INSTANCE.n(1293, 104, 1);
            }
            h hVar = h.INSTANCE;
            Object[] objArr = new Object[3];
            objArr[0] = string;
            objArr[1] = z ? AppMeasurement.CRASH_ORIGIN : "bad state only";
            objArr[2] = str;
            hVar.a(20315, objArr);
        }
        AppMethodBeat.o(240992);
    }
}
