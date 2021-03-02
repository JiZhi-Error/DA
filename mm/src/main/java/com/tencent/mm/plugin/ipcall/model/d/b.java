package com.tencent.mm.plugin.ipcall.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class b {
    public String countryCode = "";
    public String kik = "";
    public int roomId = 0;
    public long yop = 0;
    public long ypH = 0;
    public int ypJ = 0;
    public int yqM = 0;
    public int yqN = 0;
    public int yqO = 0;
    public int yqP = 0;
    public int yqQ = 0;
    public long yqR = 0;
    public long yqS = 0;
    public int yqT = 0;
    public long yqU = 0;
    public int yqV = 0;
    public long yqW = 0;
    public int yqX = 0;
    public String yqY = "";
    public long yqZ = 0;
    public long yra = 0;
    public long yrb = 0;
    public long yrc = 0;
    public String yrd = "";
    public String yre = "";
    public String yrf = "";
    public long yrg = 0;
    public long yrh = 0;
    public long yri = 0;
    public int yrj = 0;
    public int yrk = 0;
    public int yrl = 0;
    public int yrm = 0;

    public final void setCountryCode(String str) {
        AppMethodBeat.i(25444);
        Log.d("MicroMsg.IPCallReportHelper", "setCountryCode: %s", str);
        if (!Util.isNullOrNil(str)) {
            this.countryCode = str;
        }
        AppMethodBeat.o(25444);
    }

    public final void gQ(int i2, int i3) {
        AppMethodBeat.i(25445);
        if (this.ypJ == i2) {
            Log.d("MicroMsg.IPCallReportHelper", "setInviteCgiRet: %d", Integer.valueOf(i3));
            this.yqX = i3;
        }
        AppMethodBeat.o(25445);
    }

    public final void eaO() {
        AppMethodBeat.i(25446);
        Log.i("MicroMsg.IPCallReportHelper", "selfShutdown");
        this.yqQ = 1;
        AppMethodBeat.o(25446);
    }

    public final void eaP() {
        AppMethodBeat.i(25447);
        Log.i("MicroMsg.IPCallReportHelper", "selfCancel");
        this.yqP = 1;
        if (this.yri == 0 && this.yqZ != 0) {
            this.yri = System.currentTimeMillis() - this.yqZ;
            Log.d("MicroMsg.IPCallReportHelper", "cancelTime: %d", Long.valueOf(this.yri));
        }
        AppMethodBeat.o(25447);
    }

    public final void eaQ() {
        AppMethodBeat.i(25448);
        Log.i("MicroMsg.IPCallReportHelper", "channelConnect");
        this.yqT = 1;
        AppMethodBeat.o(25448);
    }

    public final void eaR() {
        if (this.yrl == 0) {
            this.yrl = 1;
        }
    }

    public final void eaS() {
        AppMethodBeat.i(25449);
        Log.d("MicroMsg.IPCallReportHelper", "markConnect");
        if (this.yrg == 0) {
            this.yrg = System.currentTimeMillis();
            this.yrh = this.yrg - this.yqZ;
            Log.d("MicroMsg.IPCallReportHelper", "connectTime: %d", Long.valueOf(this.yrh));
        }
        AppMethodBeat.o(25449);
    }

    public final void eaT() {
        AppMethodBeat.i(25450);
        Log.d("MicroMsg.IPCallReportHelper", "markStartTalk");
        if (this.yrb == 0) {
            this.yrb = System.currentTimeMillis();
        }
        AppMethodBeat.o(25450);
    }
}
