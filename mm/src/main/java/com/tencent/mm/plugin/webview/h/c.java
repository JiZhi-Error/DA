package com.tencent.mm.plugin.webview.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;

public final class c {
    public int JcC;
    public boolean JcD;
    public String JcE;
    public long endTime;
    public int pCV;
    public int pmM = 10000;
    public long size;
    public long startTime;

    public final void report() {
        String str;
        int i2 = 0;
        AppMethodBeat.i(103134);
        long j2 = this.endTime - this.startTime;
        if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
            str = "wifi";
        } else if (NetStatusUtil.is5G(MMApplicationContext.getContext())) {
            str = "5g";
        } else if (NetStatusUtil.is4G(MMApplicationContext.getContext())) {
            str = "4g";
        } else if (NetStatusUtil.is3G(MMApplicationContext.getContext())) {
            str = "3g";
        } else if (NetStatusUtil.is2G(MMApplicationContext.getContext())) {
            str = "2g";
        } else {
            str = "none";
        }
        Log.d("MicroMsg.Preload.Kv15870", "TemplateVersion:%d, IsDiffUpdate:%s, DownloadCostTime:%d, DownloadSize:%d NetworkType:%s tmplType:%d tmplUid:%s", Integer.valueOf(this.JcC), Boolean.valueOf(this.JcD), Long.valueOf(j2), Long.valueOf(this.size), str, Integer.valueOf(this.pCV), this.JcE);
        h hVar = h.INSTANCE;
        Object[] objArr = new Object[8];
        objArr[0] = Integer.valueOf(this.JcC);
        if (this.JcD) {
            i2 = 1;
        }
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Long.valueOf(Math.min(j2, (long) Util.MILLSECONDS_OF_HOUR));
        objArr[3] = Long.valueOf(this.size);
        objArr[4] = str;
        objArr[5] = Integer.valueOf(this.pCV);
        objArr[6] = this.JcE;
        objArr[7] = Integer.valueOf(this.pmM);
        hVar.a(15870, objArr);
        AppMethodBeat.o(103134);
    }
}
