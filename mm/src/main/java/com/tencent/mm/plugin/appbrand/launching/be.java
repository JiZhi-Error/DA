package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.ab;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.page.web_renderingcache.d;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.plugin.appbrand.ui.c.a.b;
import com.tencent.mm.protocal.protobuf.yh;
import com.tencent.mm.protocal.protobuf.yi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class be {
    private final String appId;
    private final String loO;
    private final boolean loP;
    private final String md5 = null;

    public be(String str, String str2, boolean z) {
        this.appId = str;
        this.loO = str2;
        this.loP = z;
    }

    public enum a {
        Ok,
        Fail,
        Timeout,
        CgiFail,
        ResponseInvalid,
        AwaitFail;

        public static a valueOf(String str) {
            AppMethodBeat.i(47363);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(47363);
            return aVar;
        }

        static {
            AppMethodBeat.i(47365);
            AppMethodBeat.o(47365);
        }

        public static a ym(int i2) {
            AppMethodBeat.i(47364);
            if (i2 < 0) {
                AppMethodBeat.o(47364);
                return null;
            }
            a[] values = values();
            for (a aVar : values) {
                if (aVar.ordinal() == i2) {
                    AppMethodBeat.o(47364);
                    return aVar;
                }
            }
            AppMethodBeat.o(47364);
            return null;
        }
    }

    private void p(int i2, String str, String str2) {
        AppMethodBeat.i(47366);
        boolean a2 = n.buL().a(this.appId, i2, str, str2, 0, 0);
        if (a2 && this.loP) {
            h.bWb().cl(this.appId, 2);
        }
        if (a2) {
            d.cd(this.appId, i2);
            ((b) n.W(b.class)).ct(this.appId, i2);
        }
        AppMethodBeat.o(47366);
    }

    public final Pair<Integer, String> bNQ() {
        AppMethodBeat.i(47367);
        c.a e2 = ab.e(J(this.appId, this.md5, this.loO));
        String str = null;
        if (e2.errType == 0 && e2.errCode == 0) {
            try {
                yi yiVar = (yi) e2.iLC;
                String str2 = yiVar.Ljw;
                try {
                    if (yiVar.Ljo == null) {
                        Log.e("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, null wxaapp resp", this.appId);
                        Pair<Integer, String> create = Pair.create(Integer.valueOf(a.ResponseInvalid.ordinal()), str2);
                        AppMethodBeat.o(47367);
                        return create;
                    }
                    Log.i("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, wxa.ErrCode %d, has_new_demo %b, url %s, md5 %s", this.appId, Integer.valueOf(yiVar.Ljo.rBL), Boolean.valueOf(yiVar.Ljp), yiVar.Ljq, yiVar.Ljr);
                    if (yiVar.Ljo.rBL != 0) {
                        Pair<Integer, String> create2 = Pair.create(Integer.valueOf(yiVar.Ljo.rBL), str2);
                        AppMethodBeat.o(47367);
                        return create2;
                    }
                    if (yiVar.Ljp && !Util.isNullOrNil(yiVar.Ljr)) {
                        String aO = ((com.tencent.mm.plugin.appbrand.appcache.d) n.W(com.tencent.mm.plugin.appbrand.appcache.d.class)).aO(this.appId, 2);
                        Log.i("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId:%s, has_new_demo=TRUE, localDemoVersionMd5:%s", this.appId, aO);
                        if (!yiVar.Ljr.equals(aO)) {
                            if (!Util.isNullOrNil(yiVar.Ljq)) {
                                p(2, yiVar.Ljq, yiVar.Ljr);
                            }
                            ((t) n.W(t.class)).a(this.appId, 2, yiVar.Ljv, true);
                            ((com.tencent.mm.plugin.appbrand.appcache.d) n.W(com.tencent.mm.plugin.appbrand.appcache.d.class)).n(this.appId, 2, yiVar.Ljr);
                        } else {
                            ((t) n.W(t.class)).a(this.appId, 2, yiVar.Ljv, false);
                        }
                    }
                    if (yiVar.Ljs && !Util.isNullOrNil(yiVar.Lju) && !Util.isNullOrNil(yiVar.Ljt)) {
                        p(10001, yiVar.Ljt, yiVar.Lju);
                    }
                    Pair<Integer, String> create3 = Pair.create(Integer.valueOf(a.Ok.ordinal()), str2);
                    AppMethodBeat.o(47367);
                    return create3;
                } catch (Exception e3) {
                    e = e3;
                    str = str2;
                    Log.printErrStackTrace("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", e, "CgiCheckDemoInfo, appId %s, cast response failed", this.appId);
                    Pair<Integer, String> create4 = Pair.create(Integer.valueOf(a.ResponseInvalid.ordinal()), str);
                    AppMethodBeat.o(47367);
                    return create4;
                }
            } catch (Exception e4) {
                e = e4;
                Log.printErrStackTrace("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", e, "CgiCheckDemoInfo, appId %s, cast response failed", this.appId);
                Pair<Integer, String> create42 = Pair.create(Integer.valueOf(a.ResponseInvalid.ordinal()), str);
                AppMethodBeat.o(47367);
                return create42;
            }
        } else {
            Log.e("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, errType %d, errCode %d, errMsg %s", this.appId, Integer.valueOf(e2.errType), Integer.valueOf(e2.errCode), e2.errMsg);
            Pair<Integer, String> create5 = Pair.create(Integer.valueOf(a.CgiFail.ordinal()), null);
            AppMethodBeat.o(47367);
            return create5;
        }
    }

    public static com.tencent.mm.ak.d J(String str, String str2, String str3) {
        AppMethodBeat.i(227118);
        d.a aVar = new d.a();
        yh yhVar = new yh();
        yhVar.dNI = str;
        yhVar.Ljm = str2;
        yhVar.Ljn = str3;
        aVar.iLN = yhVar;
        aVar.iLO = new yi();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/checkdemoinfo";
        aVar.funcId = 1124;
        com.tencent.mm.ak.d aXF = aVar.aXF();
        AppMethodBeat.o(227118);
        return aXF;
    }
}
