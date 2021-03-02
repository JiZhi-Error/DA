package com.tencent.mm.plugin.festival.c;

import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.TimeZone;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u001e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0018J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\\\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 2:\u0010!\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001c0\"H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, hxF = {"Lcom/tencent/mm/plugin/festival/util/FestivalUtil;", "", "()V", "MILLSECONDS_OF_DAY", "", "MILLSECONDS_OF_HOUR", "MILLSECONDS_OF_MINUTE", "MILLSECONDS_OF_SECOND", "TAG", "", "timeCurs", "Ljava/util/HashMap;", "timeHash", "checkOccupyTips", "context", "Landroid/content/Context;", "formatSnsTimeInTimeLine", "time", "isPhoneInUse", "", "isSameDay", "millis1", "millis2", "timeZone", "Ljava/util/TimeZone;", "millis2Days", "millis", "uploadToCdn", "", "filePath", "thumbPath", "dataType", "", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "dataUrl", "thumbUrl", "plugin-festival_release"})
public final class i {
    public static final i UGI = new i();
    private static final HashMap<Long, Long> pMp = new HashMap<>();
    private static final HashMap<Long, String> pMq = new HashMap<>();

    static {
        AppMethodBeat.i(263500);
        AppMethodBeat.o(263500);
    }

    private i() {
    }

    public static boolean a(long j2, long j3, TimeZone timeZone) {
        AppMethodBeat.i(263497);
        p.h(timeZone, "timeZone");
        long j4 = j2 - j3;
        if (j4 >= Util.MILLSECONDS_OF_DAY || j4 <= -86400000 || a(j2, timeZone) != a(j3, timeZone)) {
            AppMethodBeat.o(263497);
            return false;
        }
        AppMethodBeat.o(263497);
        return true;
    }

    private static long a(long j2, TimeZone timeZone) {
        AppMethodBeat.i(263498);
        long offset = (((long) timeZone.getOffset(j2)) + j2) / Util.MILLSECONDS_OF_DAY;
        AppMethodBeat.o(263498);
        return offset;
    }

    public static boolean bZp() {
        boolean z;
        boolean z2;
        Exception e2;
        AppMethodBeat.i(263499);
        try {
            Object systemService = MMApplicationContext.getContext().getSystemService("phone");
            if (systemService == null) {
                t tVar = new t("null cannot be cast to non-null type android.telephony.TelephonyManager");
                AppMethodBeat.o(263499);
                throw tVar;
            }
            TelephonyManager telephonyManager = (TelephonyManager) systemService;
            if (telephonyManager != null) {
                int callState = telephonyManager.getCallState();
                switch (callState) {
                    case 0:
                        z = false;
                        break;
                    case 1:
                    case 2:
                        z = true;
                        break;
                    default:
                        z = false;
                        break;
                }
                try {
                    Log.i("MicroMsg.FestivalUtil", "isPhoneInUse, isPhoneInUse:%s, callState:%s", Boolean.valueOf(z), Integer.valueOf(callState));
                } catch (Exception e3) {
                    e2 = e3;
                    z2 = z;
                }
            } else {
                z = false;
            }
            AppMethodBeat.o(263499);
            return z;
        } catch (Exception e4) {
            e2 = e4;
            z2 = false;
            Log.printErrStackTrace("MicroMsg.FestivalUtil", e2, "isPhoneInUse, exception:%s", e2);
            z = z2;
            AppMethodBeat.o(263499);
            return z;
        }
    }
}
