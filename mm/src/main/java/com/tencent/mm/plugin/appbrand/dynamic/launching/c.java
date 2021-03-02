package com.tencent.mm.plugin.appbrand.dynamic.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.ab;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.api.e;
import com.tencent.mm.protocal.protobuf.yh;
import com.tencent.mm.protocal.protobuf.yi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c {
    private final String appId;
    private final String loO;
    private final boolean loP;
    private final String md5;

    private c(String str, String str2, String str3) {
        this.appId = str;
        this.md5 = str2;
        this.loO = str3;
        this.loP = false;
    }

    public c(String str, String str2, String str3, byte b2) {
        this(str, str2, str3);
    }

    public enum a {
        Ok,
        Fail,
        Timeout,
        CgiFail,
        ResponseInvalid,
        AwaitFail;

        public static a valueOf(String str) {
            AppMethodBeat.i(121406);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(121406);
            return aVar;
        }

        static {
            AppMethodBeat.i(121407);
            AppMethodBeat.o(121407);
        }
    }

    private void p(int i2, String str, String str2) {
        AppMethodBeat.i(121408);
        ((e) g.af(e.class)).bub().a(this.appId, i2, str, str2, 0, 0);
        AppMethodBeat.o(121408);
    }

    public final int bCj() {
        AppMethodBeat.i(121409);
        String str = this.appId;
        String str2 = this.md5;
        String str3 = this.loO;
        d.a aVar = new d.a();
        yh yhVar = new yh();
        yhVar.dNI = str;
        yhVar.Ljm = str2;
        yhVar.Ljn = str3;
        aVar.iLN = yhVar;
        aVar.iLO = new yi();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/checkdemoinfo";
        aVar.funcId = 1124;
        c.a e2 = ab.e(aVar.aXF());
        if (e2.errType == 0 && e2.errCode == 0) {
            try {
                yi yiVar = (yi) e2.iLC;
                if (yiVar.Ljo == null) {
                    Log.e("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, null wxaapp resp", this.appId);
                    int ordinal = a.ResponseInvalid.ordinal();
                    AppMethodBeat.o(121409);
                    return ordinal;
                }
                Log.i("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, wxa.ErrCode %d, has_new_demo %b, url %s, md5 %s", this.appId, Integer.valueOf(yiVar.Ljo.rBL), Boolean.valueOf(yiVar.Ljp), yiVar.Ljq, yiVar.Ljr);
                if (yiVar.Ljo.rBL != 0) {
                    int i2 = yiVar.Ljo.rBL;
                    AppMethodBeat.o(121409);
                    return i2;
                }
                if (yiVar.Ljp && !Util.isNullOrNil(yiVar.Ljr) && !Util.isNullOrNil(yiVar.Ljq)) {
                    p(2, yiVar.Ljq, yiVar.Ljr);
                }
                if (yiVar.Ljs && !Util.isNullOrNil(yiVar.Lju) && !Util.isNullOrNil(yiVar.Ljt)) {
                    p(10001, yiVar.Ljt, yiVar.Lju);
                }
                int ordinal2 = a.Ok.ordinal();
                AppMethodBeat.o(121409);
                return ordinal2;
            } catch (Exception e3) {
                Log.printErrStackTrace("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", e3, "CgiCheckDemoInfo, appId %s, cast response failed", this.appId);
                int ordinal3 = a.ResponseInvalid.ordinal();
                AppMethodBeat.o(121409);
                return ordinal3;
            }
        } else {
            Log.e("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, errType %d, errCode %d, errMsg %s", this.appId, Integer.valueOf(e2.errType), Integer.valueOf(e2.errCode), e2.errMsg);
            int ordinal4 = a.CgiFail.ordinal();
            AppMethodBeat.o(121409);
            return ordinal4;
        }
    }
}
