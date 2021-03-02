package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.WebView;

public final class n {
    public String appId;
    public int appVersion;
    public int dCv;
    public String kEY;
    public long nJA;
    public volatile long nJu;
    public volatile boolean nJv = false;
    public int nJw;
    public int nJx;
    public long nJy;
    public long nJz;
    public String networkType;
    public int scene;
    public String sessionId;
    public String username;

    public final void bUO() {
        AppMethodBeat.i(261635);
        this.nJu = Util.currentTicks();
        AppMethodBeat.o(261635);
    }

    public final String toString() {
        AppMethodBeat.i(48157);
        String str = "kv_14576{, networkType='" + this.networkType + '\'' + ", appId='" + this.appId + '\'' + ", appVersion=" + this.appVersion + ", appState=" + this.dCv + ", scene=" + this.scene + ", sessionId='" + this.sessionId + '\'' + ", is_download_code=" + this.nJw + ", is_load_x5=" + this.nJx + ", cost_time=" + this.nJy + ", event_time=" + this.nJz + ", load_time=" + this.nJu + ", real_time=" + Util.currentTicks() + ", username=" + this.username + ", appType=" + this.nJA + ", instanceId=" + this.kEY + '}';
        AppMethodBeat.o(48157);
        return str;
    }

    public final void report() {
        AppMethodBeat.i(48159);
        try {
            Log.i("MicroMsg.AppBrand.Report.kv_14576", "report|" + toString());
            e.INSTANCE.a(14576, this.networkType, this.appId, Integer.valueOf(this.appVersion), Integer.valueOf(this.dCv), Integer.valueOf(this.scene), this.sessionId, Integer.valueOf(this.nJw), Integer.valueOf(this.nJx), Long.valueOf(this.nJy), Long.valueOf(this.nJz), this.username, Long.valueOf(this.nJA), this.kEY);
            AppMethodBeat.o(48159);
        } catch (Exception e2) {
            Log.e("MicroMsg.AppBrand.Report.kv_14576", "report exp %s", e2);
            AppMethodBeat.o(48159);
        }
    }

    public final void f(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
        int i2 = 1;
        AppMethodBeat.i(48158);
        this.sessionId = appBrandInitConfigWC.cym;
        p.Um(appBrandInitConfigWC.appId);
        this.networkType = i.getNetworkType(MMApplicationContext.getContext());
        this.appId = appBrandInitConfigWC.appId;
        this.appVersion = appBrandInitConfigWC.appVersion;
        this.dCv = appBrandInitConfigWC.eix;
        this.scene = appBrandStatObject.scene;
        this.nJw = this.nJv ? 1 : 0;
        if (!WebView.isX5()) {
            i2 = 0;
        }
        this.nJx = i2;
        this.nJy = Util.ticksToNow(this.nJu);
        this.nJz = Util.nowMilliSecond();
        this.username = appBrandInitConfigWC.username;
        this.nJA = (long) appBrandInitConfigWC.ldW.apptype;
        this.kEY = appBrandInitConfigWC.ldW.kEY;
        AppMethodBeat.o(48158);
    }
}
