package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;

public final class as {
    long DMw = 0;
    long DMx = 0;
    long EvE = 0;
    String EvF = "";
    String EvG = "";
    String EvH = "";
    String EvI = "";
    int EvJ = 0;
    boolean EvK = false;
    int position = 0;
    String sNG = "";

    public final boolean fgK() {
        AppMethodBeat.i(98232);
        long ticksToNow = Util.ticksToNow(this.EvE);
        Log.i("MicroMsg.ResumeSnsControl", "resume time %d", Long.valueOf(ticksToNow));
        Log.i("MicroMsg.ResumeSnsControl", "lastSnsTime %s limitSeq %s respMinSeq %s timeLastId %s position %s topy %s, unreadBottomSeq:%s, unreadTopSeq:%s, timeFirstId:%s, upLimitSeq:%s, isPullDownMode:%s", Long.valueOf(this.EvE), this.sNG, this.EvF, Long.valueOf(this.DMw), Integer.valueOf(this.position), Integer.valueOf(this.EvJ), this.EvG, this.EvH, Long.valueOf(this.DMx), this.EvI, Boolean.valueOf(this.EvK));
        if (MultiProcessMMKV.getMMKV("SnsMMKV").getBoolean("SnsMMKVDeleteTable", false)) {
            Log.i("MicroMsg.ResumeSnsControl", "already delete table, need refresh");
            AppMethodBeat.o(98232);
            return false;
        }
        if (this.EvK) {
            if (ticksToNow < 180000) {
                Log.i("MicroMsg.ResumeSnsControl", "timeLastId is %d ", Long.valueOf(this.DMw));
                if (this.DMx == 0 || this.DMw == 0) {
                    AppMethodBeat.o(98232);
                    return false;
                }
                aj.faE().W(this.DMw, -1);
                aj.faE().Jv(this.DMx);
                AppMethodBeat.o(98232);
                return true;
            }
        } else if (ticksToNow < 180000) {
            Log.i("MicroMsg.ResumeSnsControl", "timeLastId is %d ", Long.valueOf(this.DMw));
            if (this.DMw == 0) {
                AppMethodBeat.o(98232);
                return false;
            } else if (this.position != 0 || Util.isNullOrNil((String) g.aAh().azQ().get(68377, (Object) null))) {
                aj.faE().W(this.DMw, -1);
                AppMethodBeat.o(98232);
                return true;
            } else {
                AppMethodBeat.o(98232);
                return false;
            }
        }
        AppMethodBeat.o(98232);
        return false;
    }
}
