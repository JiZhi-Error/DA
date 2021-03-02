package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q {
    private static final q nKf = new q(true);
    public String appId;
    public int appType;
    public int appVersion;
    public int dCv;
    public com.tencent.mm.plugin.appbrand.q kBw;
    public String method;
    public final boolean nIR;
    public int nKg;
    public int nKh;
    public int nKi;
    public String networkType;
    public String pageUrl;
    public String referer;
    public int statusCode;
    public String url;

    private q(boolean z) {
        this.nIR = z;
    }

    static {
        AppMethodBeat.i(180359);
        AppMethodBeat.o(180359);
    }

    public static q bUX() {
        return nKf;
    }

    public static q G(com.tencent.mm.plugin.appbrand.q qVar) {
        AppMethodBeat.i(180357);
        q qVar2 = new q(false);
        qVar2.appId = qVar.mAppId;
        qVar2.kBw = qVar;
        if (qVar.bsB() == null) {
            qVar2.dCv = qVar.kAq.eix + 1;
            qVar2.appVersion = qVar.bsC().appVersion;
        } else {
            qVar2.dCv = qVar.bsB().leE.kNW + 1;
            qVar2.appVersion = qVar.bsB().leE.pkgVersion;
        }
        AppMethodBeat.o(180357);
        return qVar2;
    }

    public final String toString() {
        AppMethodBeat.i(180358);
        String str = "kv_19358{appId='" + this.appId + '\'' + ", appVersion=" + this.appVersion + ", appState=" + this.dCv + ", appType=" + this.appType + ", networkType='" + this.networkType + '\'' + ", pageUrl='" + this.pageUrl + '\'' + ", url='" + this.url + '\'' + ", method='" + this.method + '\'' + ", sentSize=" + this.nKg + ", receivedSize=" + this.nKh + ", statusCode=" + this.statusCode + ", visitType=" + this.nKi + ", referer='" + this.referer + '\'' + '}';
        AppMethodBeat.o(180358);
        return str;
    }
}
