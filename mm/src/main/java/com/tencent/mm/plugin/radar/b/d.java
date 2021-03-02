package com.tencent.mm.plugin.radar.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\nJ.\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0012J\b\u0010\u001b\u001a\u00020\u0006H\u0002J\b\u0010\u001c\u001a\u00020\u0010H\u0002J\u0006\u0010\u001d\u001a\u00020\u0010J\u0006\u0010\u001e\u001a\u00020\u0010J\u000e\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\nJ\u0006\u0010!\u001a\u00020\u0010J\u0006\u0010\"\u001a\u00020\u0010J\u0006\u0010#\u001a\u00020\u0010J\b\u0010$\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/radar/model/RadarKvStatReport;", "", "()V", "TAG", "", "enterStartAt", "", "kRadarEnterKey", "kRadarID", "memberCount", "", "memberTotalCount", "searchCount", "searchStartAt", "searchTotalDuring", "FoundFirstFriendTimeSpent", "", "fFoundFirstFriendTimeSpent", "", "FoundFriendsCnt", "nFoundFriendsCnt", "RadarAddFriendStat", "nUserCount", "nTouchTotalCnt", "fTimeSpent", "nFoundFriendsTotalCnt", "fStayTimeSpent", "current", "enterReset", "radarEnter", "radarQuit", "radarReceiveMember", "count", "radarSearchStart", "radarSearchStop", "reportRadarEnterIDKey", "searchReset", "plugin-radar_release"})
public final class d {
    public static int ByA = 0;
    public static long ByB = 0;
    public static long ByC = 0;
    public static long ByD = 0;
    public static int ByE = 0;
    private static final long ByF = ByF;
    private static final long ByG = 0;
    public static final d ByH = new d();
    public static final String TAG = TAG;
    public static int dRN;

    static {
        AppMethodBeat.i(138548);
        AppMethodBeat.o(138548);
    }

    private d() {
    }

    public static long eHi() {
        AppMethodBeat.i(261698);
        long currentTimeMillis = System.currentTimeMillis();
        AppMethodBeat.o(261698);
        return currentTimeMillis;
    }

    public static void eHg() {
        AppMethodBeat.i(138545);
        dRN = 0;
        ByD = ByG;
        ByD = System.currentTimeMillis();
        AppMethodBeat.o(138545);
    }

    public static void eHh() {
        AppMethodBeat.i(138546);
        ByE = 0;
        ByC = ByG;
        ByA = 0;
        ByB = ByG;
        ByC = System.currentTimeMillis();
        h.INSTANCE.idkeyStat(ByF, ByG, 1, false);
        AppMethodBeat.o(138546);
    }
}
