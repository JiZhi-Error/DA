package com.tencent.mm.sandbox.updater;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatPermissions;

/* access modifiers changed from: package-private */
public final class g {
    private static long NFm = 125829120;
    private static long NFn = 314572800;
    private long NFo = 0;
    private long NFp = 0;
    private String NFq = null;
    private k NFr;
    private boolean initialized = false;
    boolean tcf = false;
    MTimerHandler timer = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.sandbox.updater.g.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(32713);
            g.a(g.this, true);
            AppMethodBeat.o(32713);
            return true;
        }
    }, true);

    static /* synthetic */ void a(g gVar, boolean z) {
        AppMethodBeat.i(32723);
        gVar.Az(z);
        AppMethodBeat.o(32723);
    }

    public g(k kVar) {
        AppMethodBeat.i(32716);
        this.NFr = kVar;
        AppMethodBeat.o(32716);
    }

    public final void gM(String str, int i2) {
        AppMethodBeat.i(32717);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(32717);
            return;
        }
        if (!str.equals(this.NFq)) {
            stop();
        }
        Log.i("MicroMsg.TrafficStatistic", "pack size: ".concat(String.valueOf(i2)));
        Log.i("MicroMsg.TrafficStatistic", "TRAFFIC_ALERT_LINE before : %s", Long.valueOf(NFm));
        NFm = Math.max((long) (i2 * 4), NFm);
        NFm = Math.min(NFn, NFm);
        Log.i("MicroMsg.TrafficStatistic", "TRAFFIC_ALERT_LINE after : %s", Long.valueOf(NFm));
        if (!this.initialized) {
            if (this.NFr.mContext != null) {
                this.tcf = NetStatusUtil.isWifi(this.NFr.mContext);
            }
            this.timer.startTimer(30000);
            this.initialized = true;
            this.NFq = str;
        }
        AppMethodBeat.o(32717);
    }

    public final void stop() {
        AppMethodBeat.i(32718);
        Az(true);
        this.timer.stopTimer();
        this.initialized = false;
        AppMethodBeat.o(32718);
    }

    private void gwk() {
        AppMethodBeat.i(32719);
        if (this.NFo + this.NFp > 0) {
            Intent intent = new Intent();
            intent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
            intent.putExtra("intent_extra_flow_stat_upstream", this.NFo);
            intent.putExtra("intent_extra_flow_stat_downstream", this.NFp);
            if (this.NFr.mContext != null) {
                this.tcf = NetStatusUtil.isWifi(this.NFr.mContext);
            }
            intent.putExtra("intent_extra_flow_stat_is_wifi", this.tcf);
            if (this.NFr.mContext != null) {
                this.NFr.mContext.sendBroadcast(intent, WeChatPermissions.PERMISSION_MM_MESSAGE());
            }
        }
        AppMethodBeat.o(32719);
    }

    /* access modifiers changed from: package-private */
    public final void Az(boolean z) {
        AppMethodBeat.i(32720);
        if ((z || this.NFo + this.NFp >= com.tencent.mm.hardcoder.g.ACTION_MINI_PROGRAM_LAUNCH) && gwl() >= NFm && this.NFr.EtH == 2) {
            Log.e("MicroMsg.TrafficStatistic", "checkIfTrafficAlert reach traffic alert line!");
            this.NFr.cancel();
        }
        AppMethodBeat.o(32720);
    }

    public static boolean bhL(String str) {
        AppMethodBeat.i(32721);
        if (j.bhN(str) > NFm) {
            Log.e("MicroMsg.TrafficStatistic", "overTrafficAlertLine reach traffic alert line!");
            AppMethodBeat.o(32721);
            return true;
        }
        AppMethodBeat.o(32721);
        return false;
    }

    private long gwl() {
        AppMethodBeat.i(32722);
        gwk();
        if (Util.isNullOrNil(this.NFq)) {
            Log.e("MicroMsg.TrafficStatistic", "traffic is null!");
            AppMethodBeat.o(32722);
            return 0;
        }
        long L = j.L(this.NFq, this.NFo, this.NFp);
        this.NFo = 0;
        this.NFp = 0;
        AppMethodBeat.o(32722);
        return L;
    }
}
