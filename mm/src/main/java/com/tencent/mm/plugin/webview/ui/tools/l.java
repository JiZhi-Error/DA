package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.model.az;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;

public final class l {
    public static l Jhd = new l();
    private String Jhe;
    private String bssid;
    boolean iGD = false;
    private e mHh = null;
    private int networkType;
    private String sessionId;
    private String ssid;
    String traceid;

    static {
        AppMethodBeat.i(79943);
        AppMethodBeat.o(79943);
    }

    private l() {
    }

    public final void b(e eVar) {
        this.mHh = eVar;
    }

    public final void setTraceId(String str) {
        AppMethodBeat.i(211099);
        String str2 = "";
        if (this.mHh != null) {
            try {
                str2 = this.mHh.j(23, null).getString("config_info_username");
            } catch (RemoteException e2) {
                Log.e("MicroMsg.WebViewReportUtil", "setTraceId getConfigInfo exp:%s", e2);
            }
        }
        me(str, str2);
        AppMethodBeat.o(211099);
    }

    public final String getTraceId() {
        return this.traceid;
    }

    public final void me(String str, String str2) {
        AppMethodBeat.i(79938);
        Log.i("MicroMsg.WebViewReportUtil", "setting traceid " + str + ",usename " + str2);
        this.traceid = str;
        this.networkType = az.bHy();
        this.sessionId = MD5Util.getMD5String(str2 + Util.nowMilliSecond());
        this.ssid = NetStatusUtil.getConnectedWifiSsid(MMApplicationContext.getContext());
        this.bssid = NetStatusUtil.getConnectedWifiBssid(MMApplicationContext.getContext());
        this.iGD = false;
        AppMethodBeat.o(79938);
    }

    public final void cV(String str) {
        AppMethodBeat.i(211100);
        Log.v("MicroMsg.WebViewReportUtil", "onPageStarted url %s, currUrl %s, traceid %s", str, this.Jhe, this.traceid);
        String str2 = this.Jhe;
        this.Jhe = str;
        if (Util.isNullOrNil(this.traceid)) {
            AppMethodBeat.o(211100);
            return;
        }
        q(1, str2, 0);
        AppMethodBeat.o(211100);
    }

    public final void LZ() {
        AppMethodBeat.i(211101);
        Log.v("MicroMsg.WebViewReportUtil", "onPageFinished traceid %s", this.traceid);
        if (Util.isNullOrNil(this.traceid)) {
            AppMethodBeat.o(211101);
            return;
        }
        pl(2);
        AppMethodBeat.o(211101);
    }

    public final void agL(int i2) {
        AppMethodBeat.i(79939);
        Log.v("MicroMsg.WebViewReportUtil", "onReceivedError traceid %s", this.traceid);
        if (Util.isNullOrNil(this.traceid)) {
            AppMethodBeat.o(79939);
            return;
        }
        q(3, "", i2);
        AppMethodBeat.o(79939);
    }

    public final void close() {
        AppMethodBeat.i(79940);
        Log.v("MicroMsg.WebViewReportUtil", "close traceid %s", this.traceid);
        this.iGD = true;
        if (Util.isNullOrNil(this.traceid)) {
            AppMethodBeat.o(79940);
            return;
        }
        pl(4);
        this.traceid = null;
        AppMethodBeat.o(79940);
    }

    /* access modifiers changed from: package-private */
    public final void pl(int i2) {
        AppMethodBeat.i(79941);
        q(i2, "", 0);
        AppMethodBeat.o(79941);
    }

    private void q(int i2, String str, int i3) {
        AppMethodBeat.i(79942);
        m mVar = new m();
        mVar.n("20adInfo", this.traceid + ",");
        mVar.n("21optype", i2 + ",");
        mVar.n("22sessionId", this.sessionId + ",");
        mVar.n("23currURL", this.Jhe + ",");
        mVar.n("24referURL", str + ",");
        mVar.n("25errCode", i3 + ",");
        mVar.n("26networkType", this.networkType + ",");
        mVar.n("27timeStamp", Util.nowMilliSecond() + ",");
        mVar.n("28ssid", this.ssid + ",");
        mVar.n("29bssid", this.bssid + ",");
        Log.i("MicroMsg.WebViewReportUtil", "report logbuffer adPageOp(13791): optype:%d, sessionId:%s, currUrl:%s, referUrl:%s, errCode:%d, networkType:%d", Integer.valueOf(i2), this.sessionId, this.Jhe, str, Integer.valueOf(i3), Integer.valueOf(this.networkType));
        h.INSTANCE.a(13791, mVar);
        if (this.mHh == null) {
            Log.e("MicroMsg.WebViewReportUtil", "report invoker null");
            AppMethodBeat.o(79942);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("ad_report_data_str", mVar.toString());
        try {
            this.mHh.x(1295, bundle);
            AppMethodBeat.o(79942);
        } catch (RemoteException e2) {
            Log.e("MicroMsg.WebViewReportUtil", "report: exp:%s", e2);
            AppMethodBeat.o(79942);
        }
    }
}
