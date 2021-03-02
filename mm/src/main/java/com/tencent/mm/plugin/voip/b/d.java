package com.tencent.mm.plugin.voip.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\f\u001a\u00020\u000bH\u0007J\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u00020\u000eH\u0007J\u0006\u0010\u0010\u001a\u00020\u000eJ\b\u0010\u0011\u001a\u00020\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u000eH\u0002J\u000e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000bJ\u0006\u0010\u0015\u001a\u00020\u000eJ\b\u0010\u0016\u001a\u00020\u000eH\u0002J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0006\u0010\u001f\u001a\u00020\u000eJ\u0006\u0010 \u001a\u00020\u000eJ\u0006\u0010!\u001a\u00020\u000eJ\u0006\u0010\"\u001a\u00020\u000eJ.\u0010#\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u000bJ0\u0010(\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, hxF = {"Lcom/tencent/mm/plugin/voip/util/VoipActivityReport;", "", "()V", "ID", "", "TAG", "", "bStartActivityMiniViewTick", "bStartActivityNormalTick", "bStartActivityServiceTick", "isAllowToForbidCalling", "", "isUseStaticParamsCheckVoip", "markDiffServiceWithIntent", "", "markEngineIsClose", "markFakeCallingHappened", "markForbiddenCallingAfterCancel", "markForbiddenCallingNoneAfterCancel", "markForbiddenCauseEngineClose", "isAfterCancel", "markNormalCallingHappened", "markOnCreateForeground", "markOnCreateFromVoipService", "cost", "markOnCreateMiniView", "markOnCreateNormal", "markOnCreateRoomKeyNoZero", "type", "", "markOnCreateRoomKeyZero", "markResponseActivityWhileServiceZero", "markStartActivityFromVoipService", "markStartActivityMiniView", "markStartActivityNormal", "markVideoActivityOnCreate", "isError", "roomKey", "currentRoomKey", "isEngineClose", "reportKvStatVoipActivity", "caller", "plugin-voip_release"})
public final class d {
    private static long HgR;
    private static long HgS;
    private static long HgT;
    public static final d HgU = new d();

    static {
        AppMethodBeat.i(236049);
        AppMethodBeat.o(236049);
    }

    private d() {
    }

    public static final boolean fJQ() {
        AppMethodBeat.i(236035);
        if (BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG) {
            AppMethodBeat.o(236035);
            return true;
        }
        boolean a2 = ((b) g.af(b.class)).a(b.a.clicfg_voip_forbid_calling, false);
        AppMethodBeat.o(236035);
        return a2;
    }

    public static final boolean fJR() {
        AppMethodBeat.i(236036);
        if (BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG) {
            AppMethodBeat.o(236036);
            return true;
        }
        boolean a2 = ((b) g.af(b.class)).a(b.a.clicfg_voip_use_local_params_check_voip, false);
        AppMethodBeat.o(236036);
        return a2;
    }

    private static void a(long j2, int i2, long j3, long j4, boolean z) {
        AppMethodBeat.i(236037);
        if (j4 != 0) {
            switch (i2) {
                case 0:
                    h.INSTANCE.n(1433, 20, 1);
                    break;
                case 1:
                    h.INSTANCE.n(1433, 21, 1);
                    break;
                case 2:
                    h.INSTANCE.n(1433, 22, 1);
                    break;
                case 3:
                    h.INSTANCE.n(1433, 23, 1);
                    break;
            }
        } else {
            switch (i2) {
                case 0:
                    h.INSTANCE.n(1433, 16, 1);
                    break;
                case 1:
                    h.INSTANCE.n(1433, 17, 1);
                    break;
                case 2:
                    h.INSTANCE.n(1433, 18, 1);
                    break;
                case 3:
                    h.INSTANCE.n(1433, 19, 1);
                    break;
            }
        }
        h hVar = h.INSTANCE;
        Object[] objArr = new Object[5];
        objArr[0] = Long.valueOf(j2);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Long.valueOf(j3);
        objArr[3] = Long.valueOf(j4);
        objArr[4] = Integer.valueOf(z ? 0 : 1);
        hVar.a(20486, true, true, objArr);
        AppMethodBeat.o(236037);
    }

    public static void a(int i2, boolean z, long j2, long j3, boolean z2) {
        AppMethodBeat.i(236038);
        Log.i("MicroMsg.VoipActivityReport", "markVideoActivityOnCreate ".concat(String.valueOf(i2)));
        switch (i2) {
            case 0:
                if (HgR != 0) {
                    long ticksToNow = Util.ticksToNow(HgR);
                    Log.i("MicroMsg.VoipActivityReport", "markOnCreateFromVoipService cost ".concat(String.valueOf(ticksToNow)));
                    h.INSTANCE.b(1433, 6, 7, (int) ticksToNow, false);
                    if (z) {
                        a(j2, i2, ticksToNow, j3, z2);
                    }
                    HgR = 0;
                    break;
                }
                break;
            case 1:
                if (HgS != 0) {
                    long ticksToNow2 = Util.ticksToNow(HgS);
                    Log.i("MicroMsg.VoipActivityReport", "markOnCreateNormal cost ".concat(String.valueOf(ticksToNow2)));
                    h.INSTANCE.b(1433, 9, 10, (int) ticksToNow2, false);
                    if (z) {
                        a(j2, i2, ticksToNow2, j3, z2);
                    }
                    HgS = 0;
                    break;
                }
                break;
            case 2:
                h.INSTANCE.n(1433, 15, 1);
                if (z) {
                    a(j2, i2, -1, j3, z2);
                    break;
                }
                break;
            case 3:
                if (HgT != 0) {
                    long ticksToNow3 = Util.ticksToNow(HgT);
                    Log.i("MicroMsg.VoipActivityReport", "markOnCreateForeground cost ".concat(String.valueOf(ticksToNow3)));
                    h.INSTANCE.b(1433, 12, 13, (int) ticksToNow3, false);
                    if (z) {
                        a(j2, i2, ticksToNow3, j3, z2);
                    }
                    HgT = 0;
                    break;
                }
                break;
        }
        h.INSTANCE.n(1433, 0, 1);
        AppMethodBeat.o(236038);
    }

    public static void fJS() {
        AppMethodBeat.i(236039);
        Log.i("MicroMsg.VoipActivityReport", "markFakeCallingHappened");
        h.INSTANCE.n(1433, 1, 1);
        AppMethodBeat.o(236039);
    }

    public static void fJT() {
        AppMethodBeat.i(236040);
        Log.i("MicroMsg.VoipActivityReport", "markNormalCallingHappened");
        h.INSTANCE.n(1433, 2, 1);
        AppMethodBeat.o(236040);
    }

    public static void fJU() {
        AppMethodBeat.i(236041);
        HgR = Util.currentTicks();
        Log.i("MicroMsg.VoipActivityReport", "markStartActivityFromVoipService");
        h.INSTANCE.n(1433, 3, 1);
        AppMethodBeat.o(236041);
    }

    public static void fJV() {
        AppMethodBeat.i(236042);
        HgS = Util.currentTicks();
        Log.i("MicroMsg.VoipActivityReport", "markStartActivityNormal");
        h.INSTANCE.n(1433, 4, 1);
        AppMethodBeat.o(236042);
    }

    public static void fJW() {
        AppMethodBeat.i(236043);
        HgT = Util.currentTicks();
        Log.i("MicroMsg.VoipActivityReport", "markStartActivityMiniView");
        h.INSTANCE.n(1433, 5, 1);
        AppMethodBeat.o(236043);
    }

    public static final void fJX() {
        AppMethodBeat.i(236044);
        Log.i("MicroMsg.VoipActivityReport", "markEngineIsClose");
        h.INSTANCE.n(1433, 25, 1);
        AppMethodBeat.o(236044);
    }

    public static void fJY() {
        AppMethodBeat.i(236045);
        Log.i("MicroMsg.VoipActivityReport", "markDiffServiceWithIntent");
        h.INSTANCE.n(1433, 26, 1);
        AppMethodBeat.o(236045);
    }

    public static void fJZ() {
        AppMethodBeat.i(236046);
        Log.i("MicroMsg.VoipActivityReport", "markResponseActivityWhileServiceZero");
        h.INSTANCE.n(1433, 27, 1);
        AppMethodBeat.o(236046);
    }

    public static void fKa() {
        AppMethodBeat.i(236047);
        Log.i("MicroMsg.VoipActivityReport", "markForbiddenCallingAfterCancel");
        h.INSTANCE.n(1433, 28, 1);
        AppMethodBeat.o(236047);
    }

    public static void fKb() {
        AppMethodBeat.i(236048);
        Log.i("MicroMsg.VoipActivityReport", "markForbiddenCallingNoneAfterCancel");
        h.INSTANCE.n(1433, 29, 1);
        AppMethodBeat.o(236048);
    }
}
