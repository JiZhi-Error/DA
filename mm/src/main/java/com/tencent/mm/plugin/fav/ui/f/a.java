package com.tencent.mm.plugin.fav.ui.f;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class a {
    public int actionType = 1;
    public int ehn;
    public String hes;
    public int pHw;
    private int position = 0;
    public String query;
    public int scene;
    private long tal = 0;
    public int tlX;
    public int tlY;
    private String tlZ = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    public String tma;
    private int tmb = 0;
    public int tmc;
    private String tmd = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    public long tme;
    public long tmf;
    public boolean tmg = false;

    public final void report() {
        AppMethodBeat.i(235388);
        Log.d("MicroMsg.ReportSearchCTR", String.format("zst, 15488 on report, actionType %s, scene %s, subScene %s, actionTime %s, query %s, tabId %s, searchId:%s, searchCost:%s, localPosition %s, localResultCount %s", Integer.valueOf(this.actionType), Integer.valueOf(this.pHw), Integer.valueOf(this.scene), Integer.valueOf(this.tlX), this.query, Integer.valueOf(this.ehn), this.hes, Integer.valueOf(this.tlY), this.tma, Integer.valueOf(this.tmc)));
        h.INSTANCE.a(15488, Integer.valueOf(this.actionType), Integer.valueOf(this.pHw), Integer.valueOf(this.scene), Integer.valueOf(this.position), Integer.valueOf(this.tlX), this.query, Long.valueOf(this.tal), Integer.valueOf(this.ehn), this.hes, Integer.valueOf(this.tlY), this.tlZ, this.tma, Integer.valueOf(this.tmb), Integer.valueOf(this.tmc), this.tmd);
        AppMethodBeat.o(235388);
    }

    public static String getSearchId() {
        AppMethodBeat.i(235389);
        String format = String.format("%s_%s", z.aTY(), Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(235389);
        return format;
    }
}
